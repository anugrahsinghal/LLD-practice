package org.interview.prep.mutltilevel;

import java.util.concurrent.ConcurrentHashMap;
import org.interview.prep.mutltilevel.cahce.Cache;
import org.interview.prep.mutltilevel.eviction.LRUEvictionPolicy;
import org.interview.prep.mutltilevel.storage.HashMapBasedStorage;

public class Main {

	public static void main(String[] args) {
		Cache cache = new Cache(new HashMapBasedStorage(new ConcurrentHashMap<>(), 3), new LRUEvictionPolicy());
		cache.put("1", "1");
		cache.put("2", "1");
		cache.put("3", "1");
		cache.get("1");
		cache.put("4", "1");
		final String s = cache.get("3");
		if (s == null) {
			System.out.println("Evicted");
		}


	}
}
