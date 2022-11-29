package com.example.demo.cache;

import java.util.Optional;

public abstract class AbstractCustomCache {
    protected abstract Optional<Object> lookup(Object key);
    protected abstract boolean put(String key, Object value);
}
