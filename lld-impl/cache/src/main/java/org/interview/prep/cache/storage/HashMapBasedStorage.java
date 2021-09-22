package org.interview.prep.cache.storage;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.interview.prep.cache.exception.CacheFullException;
import org.interview.prep.cache.exception.KeyNotFoundException;

public class HashMapBasedStorage implements Storage {

	private final int capacity;
	Map<String, String> map;

	public HashMapBasedStorage(Map<String, String> map, int capacity) {
		this.map = map;
		this.capacity = capacity;
	}

	@Override
	public void put(String key, String val) throws CacheFullException {
		checkStorageFull();
		map.put(key, val);
	}

	private void checkStorageFull() throws CacheFullException {
		if (map.size() == capacity) {
			throw new CacheFullException("CACHE IS FULL");
		}
	}

	@Override
	public String get(String key) throws KeyNotFoundException {
		if (!map.containsKey(key)) {
			throw new KeyNotFoundException(key + "not found");
		}
		return map.get(key);
	}

	@Override
	public void remove(String key) {
		map.remove(key);
	}
}
