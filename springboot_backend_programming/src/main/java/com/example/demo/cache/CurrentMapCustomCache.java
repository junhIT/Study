package com.example.demo.cache;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public class CurrentMapCustomCache extends AbstractCustomCache{
	
	
	private final String name;	// 이름 반환
	private final ConcurrentMap<String, Object> store;	// 저장소
	
	public CurrentMapCustomCache(String name, ConcurrentMap<String, Object> store) {
		this.name = name;
		this.store = store;
	}
	
	public String getName() {return this.name;};	// 이름 반환
	
	public Object getNativeCache() { return this.store; };	// 저장소 반환

	// 검색
	protected Optional<Object> lookup(Object key) {
		return Optional.ofNullable(this.store.get(key));
	}
	
	// 삽입
	protected boolean put(String key, Object value) {
		this.store.put(key, value);
		return true;
	}
	
	// Cache 조회
	public ConcurrentMap<String, Object> getCache() {
		return this.store;
	}
}