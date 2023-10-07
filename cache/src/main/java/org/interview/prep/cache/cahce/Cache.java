package org.interview.prep.cache.cahce;

import org.interview.prep.cache.eviction.EvictionPolicy;
import org.interview.prep.cache.exception.CacheFullException;
import org.interview.prep.cache.exception.KeyNotFoundException;
import org.interview.prep.cache.storage.Storage;

public class Cache {

	private final Storage storage;
	private final EvictionPolicy evictionPolicy;

	public Cache(Storage storage, EvictionPolicy evictionPolicy) {
		this.storage = storage;
		this.evictionPolicy = evictionPolicy;
	}

	public String get(String key) {
		String val = null;
		try {
			val = storage.get(key);
			evictionPolicy.keyAccessed(key);
		} catch (KeyNotFoundException e) {
			System.out.println("KEY NOT FOUND");
		}
		return val;
	}

	public void put(String key, String val) {
		try {
			storage.put(key, val);
			evictionPolicy.keyAccessed(key);
		} catch (CacheFullException e) {
			final String elementToEvict = evictionPolicy.evict();
			this.storage.remove(elementToEvict);
			put(key, val);
		}
	}


}
