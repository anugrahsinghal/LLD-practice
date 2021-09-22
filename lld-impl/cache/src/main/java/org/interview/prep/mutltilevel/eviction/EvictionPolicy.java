package org.interview.prep.mutltilevel.eviction;

public interface EvictionPolicy {

	void keyAccessed(String key);

	String evict();

}
