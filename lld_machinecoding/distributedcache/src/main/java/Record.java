package lld_machinecoding.distributedcache.src.main.java;

public class Record<KEY, VALUE> {

    KEY key;
    VALUE value;
    private long insertionTime;

    public Record(KEY key, VALUE value, long insertionTime) {
        this.key = key;
        this.value = value;
        this.insertionTime = insertionTime;
        this .accessDetails = new AccessDetails(insertionTime);
    }

    private AccessDetails accessDetails ;

    public long getInsertionTime() {
        return insertionTime;
    }

    public AccessDetails getAccessDetails() {
        return accessDetails;
    }

    public VALUE getValue() {
        return value;
    }
}
