package ir.maktabsharif101.jpaexample.util;

import java.util.HashMap;
import java.util.Map;

public class CacheManager {

    private final Map<String, Object> cacheMap = new HashMap<>();

    private static final CacheManager CACHE_MANAGER = new CacheManager();

    private CacheManager() {
    }

    public static CacheManager getInstance() {
        return CACHE_MANAGER;
    }

    public void put(String cacheName, Object value) {
        cacheMap.put(cacheName, value);
    }

    public Object getCache(String cacheName) {
        return cacheMap.get(cacheName);
    }

    public void clearCache(String cacheName) {
        cacheMap.remove(cacheName);
    }
}
