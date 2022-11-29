package com.example.demo.cache;

import java.util.Collection;

public interface CustomCacheManager {
	AbstractCustomCache getCache(String name);
	Collection<String> getCacheStoragenames();
}
