package lld_machinecoding.distributedcache.src.main.java;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Cache<KEY, VALUE> {

    private final  int cacheSize;
    private final FetchingAlgorithm fetchingAlgorithm;
    private final EvictionAlgorithm evictionAlgorithm;
    private final Duration expiryTime;
    private  final Map<KEY , CompletionStage<Record<KEY,VALUE>>> cache;
    private final ConcurrentSkipListMap<AccessDetails, List<KEY>> priorityQueue;
    private final ConcurrentSkipListMap<Long, List<KEY>> expiryQueue;
    private  final  DataSource<KEY,VALUE> dataSource;
    private final List<Event<KEY,VALUE>> eventqueue;
    private final ExecutorService[] executorServicesPool;
    private final CustomTimer timer;

    public Cache(int maximumSize, Duration expiryTime, FetchingAlgorithm fetchAlgorithm, EvictionAlgorithm evictionAlgorithm,
                 DataSource<KEY, VALUE> dataSource, Set<KEY> onStartLoad, CustomTimer timer,
                 int poolSize) {
        this.cacheSize = maximumSize;
        this.fetchingAlgorithm = fetchAlgorithm;
        this.evictionAlgorithm = evictionAlgorithm;
        this.expiryTime = expiryTime;
        this.cache = new ConcurrentHashMap<>();
        this.priorityQueue = new ConcurrentSkipListMap<>();
        this.expiryQueue = new ConcurrentSkipListMap<>();
        this.dataSource = dataSource;
        this.eventqueue = new ArrayList<>();
        this.executorServicesPool = new ExecutorService[poolSize];
        IntStream.rangeClosed(0,cacheSize-1).forEach( i -> executorServicesPool[i]= Executors.newSingleThreadExecutor());
        this.timer = timer;
        CompletableFuture[] eagerLoads = onStartLoad.stream().map( key -> addToCache(key)).toArray(CompletableFuture[] :: new);
        CompletableFuture.allOf(eagerLoads).join();
    }

    private CompletionStage<Record<KEY,VALUE>> addToCache(KEY key) {
        CompletionStage<VALUE> futureValue = loadFromDB(dataSource,key);
        CompletionStage<Record<KEY,VALUE>> recordFuture = futureValue.thenApply( value ->
        {
            final Record<KEY, VALUE> record = new Record<>(key, value, timer.getCurretnTime());
            expiryQueue.putIfAbsent(record.getInsertionTime(), new CopyOnWriteArrayList<>());
            expiryQueue.get(record.getInsertionTime()).add(key);
            priorityQueue.putIfAbsent(record.getAccessDetails(), new CopyOnWriteArrayList<>());
            priorityQueue.get(record.getAccessDetails()).add(key);
            return record;
        });
        cache.put(key,recordFuture);
        return recordFuture;
    }


    public VALUE getFromCache(KEY key) throws ExecutionException, InterruptedException {
        final CompletionStage<Record<KEY,VALUE>> record;
        if (!cache.containsKey(key))
            record = addToCache(key);
            else
        {
            record= null;
        }

        return  record.thenApply( rec -> rec.getValue()).toCompletableFuture().get();
    }

    private CompletionStage<VALUE> loadFromDB(DataSource<KEY,VALUE> dataSource, KEY key) {
        CompletionStage<VALUE> v = dataSource.load(key);
        return v;
    }
    private CompletionStage<Void> persist(DataSource<KEY,VALUE> dataSource, KEY key, VALUE value) {
        CompletionStage<Void> v = dataSource.persist(key, value);
        return v;
    }
}
