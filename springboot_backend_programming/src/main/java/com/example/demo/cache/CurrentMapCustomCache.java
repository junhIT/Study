package com.example.demo.cache;

import java.util.Optional;
import java.util.concurrent.ConcurrentMap;

public class CurrentMapCustomCache extends AbstractCustomCache{
	
	
	private final String name;	// �̸� ��ȯ
	private final ConcurrentMap<String, Object> store;	// �����
	
	public CurrentMapCustomCache(String name, ConcurrentMap<String, Object> store) {
		this.name = name;
		this.store = store;
	}
	
	public String getName() {return this.name;};	// �̸� ��ȯ
	
	public Object getNativeCache() { return this.store; };	// ����� ��ȯ

	// �˻�
	protected Optional<Object> lookup(Object key) {
		return Optional.ofNullable(this.store.get(key));
	}
	
	// ����
	protected boolean put(String key, Object value) {
		this.store.put(key, value);
		return true;
	}
	
	// Cache ��ȸ
	public ConcurrentMap<String, Object> getCache() {
		return this.store;
	}
}