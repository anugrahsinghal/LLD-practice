package org.interview.prep.cache.eviction;

public interface EvictionPolicy {

	void keyAccessed(String key);

	String evict();

}
