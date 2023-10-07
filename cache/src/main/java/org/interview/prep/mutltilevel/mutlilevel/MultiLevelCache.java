package org.interview.prep.mutltilevel.mutlilevel;

import org.interview.prep.mutltilevel.cahce.Cache;

public class MultiLevelCache implements LevelledCache {

	private final Cache cache;
	private final LevelledCache nextLevel;

	public MultiLevelCache(Cache cache, LevelledCache nextLevel) {
		this.cache = cache;
		this.nextLevel = nextLevel;
	}

	@Override
	public String get(String key) {
		// if this level contains then return from this level itself
		// else get value from next level and also write to this level
		String value = cache.get(key);
		if (value != null) {
			return value;
		}
		value = nextLevel.get(key);
		this.cache.put(key, value);
		return value;
	}

	@Override
	public void put(String key, String val) {
		// write to this level and all levels below it
		this.cache.put(key, val);
		nextLevel.put(key, val);
	}
}
