package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.service.RandomStringService;
import ir.maktabsharif101.jpaexample.util.CacheManager;

import java.util.List;

public class RandomStringProxyServiceImpl implements RandomStringService {

    private final RandomStringService originalService = new RandomStringServiceImpl();

    private final CacheManager cacheManager = CacheManager.getInstance();

    public static final String CACHE_NAME = "stringCache";

    @Override
    public List<String> generateRandomStringList() {
        List<String> strings = (List<String>) cacheManager.getCache(CACHE_NAME);
        if (strings == null) {
            strings = originalService.generateRandomStringList();
            cacheManager.put(CACHE_NAME, strings);
        }
        return strings;
    }
}
