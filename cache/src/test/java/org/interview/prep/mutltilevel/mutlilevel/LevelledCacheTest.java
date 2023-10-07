package org.interview.prep.mutltilevel.mutlilevel;

import java.util.concurrent.ConcurrentHashMap;
import org.interview.prep.mutltilevel.cahce.Cache;
import org.interview.prep.mutltilevel.eviction.LRUEvictionPolicy;
import org.interview.prep.mutltilevel.storage.HashMapBasedStorage;
import org.junit.jupiter.api.Test;

class LevelledCacheTest {

	@Test
	void testMultiLevelCache() {
		final LastLevelCache lastLevel = new LastLevelCache();
		final Cache cacheStorageL1 = new Cache(new HashMapBasedStorage(new ConcurrentHashMap<>(), 2), new LRUEvictionPolicy());
		final Cache cacheStorageL2 = new Cache(new HashMapBasedStorage(new ConcurrentHashMap<>(), 3), new LRUEvictionPolicy());

		final LevelledCache levelledCacheL2 = new MultiLevelCache(cacheStorageL2, lastLevel);
		final LevelledCache levelledCacheL1 = new MultiLevelCache(cacheStorageL1, levelledCacheL2);




	}


}