package org.interview.prep.cache.cahce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import java.util.concurrent.ConcurrentHashMap;
import org.interview.prep.cache.eviction.LRUEvictionPolicy;
import org.interview.prep.cache.storage.HashMapBasedStorage;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class CacheTest {

	final HashMapBasedStorage storage = Mockito.spy(new HashMapBasedStorage(new ConcurrentHashMap<>(), 3));
	final LRUEvictionPolicy evictionPolicy = Mockito.spy(new LRUEvictionPolicy());
	private final Cache cache = new Cache(storage, evictionPolicy);


	@Test
	void testEvictionWhenCacheGetFull() {
		cache.put("1", "1");
		cache.put("2", "1");
		cache.put("3", "1");
		// 1 should be evicted
		cache.put("4", "1");

		final String s = cache.get("1");

		assertNull(s);
		Mockito.verify(evictionPolicy, times(1)).evict();
	}

	@Test
	void test_eviction_when_cache_full_with_get_op() {
		cache.put("1", "1");
		cache.put("2", "1");
		cache.put("3", "1");
		// 1->2->3
		cache.get("1");
		// 2->3->1
		cache.put("4", "1");
		// 3->1->4
		final String s = cache.get("2");
		assertNull(s);

		cache.put("3", "2");
		// 1->4->3
		assertEquals("2", cache.get("3"));

		verify(evictionPolicy, times(2)).evict();

	}

	@Test
	void test_latest_values_are_returned() {
		cache.put("1", "1");
		cache.put("2", "1");
		cache.put("3", "1");
		// 1->2->3
		cache.get("1");
		// 2->3->1
		cache.put("4", "1");
		// 3->1->4
		cache.put("3", "2");
		// 1->4->3
		assertEquals("2", cache.get("3"));

		verify(evictionPolicy, times(2)).evict();
	}


}