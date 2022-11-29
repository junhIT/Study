package com.example.demo.cache;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Component;

@Component("memoryCustomCacheManager")
public class MemoryCustomCacheManager implements CustomCacheManager{
	
	private final ConcurrentMap<String, CurrentMapCustomCache> cacheMap
	 = new ConcurrentHashMap<>(16);

	@Override
	public AbstractCustomCache getCache(String name) {
		CurrentMapCustomCache cache = this.cacheMap.get(name);
		if(cache == null) {
			synchronized (this.cacheMap) {
				cache = this.cacheMap.get(name);
				if (cache == null) {
					cache = createConcurrentMapCustomCache(name);
					this.cacheMap.put(name, cache);
				}
			}
		}
		return cache;
	}

	@Override
	public Collection<String> getCacheStoragenames() {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected CurrentMapCustomCache createConcurrentMapCustomCache(String name) {
		return new CurrentMapCustomCache(name, new ConcurrentHashMap<>(256));
	}

}
