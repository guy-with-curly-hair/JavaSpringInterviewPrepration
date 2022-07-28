package lld_machinecoding.distributedcache.src.main.java;

import java.util.concurrent.atomic.LongAdder;

public class AccessDetails {

    private final LongAdder accesCount;
    private long lastAccessTime;

    public AccessDetails(long lastAccessTime) {
        this.accesCount = new LongAdder();
        this.lastAccessTime = lastAccessTime;
    }
}
