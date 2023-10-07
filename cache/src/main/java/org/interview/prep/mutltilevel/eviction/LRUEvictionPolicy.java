package org.interview.prep.mutltilevel.eviction;

import java.util.LinkedList;

public class LRUEvictionPolicy implements EvictionPolicy {

	private final LinkedList<String> lruOrderedList;

	public LRUEvictionPolicy() {
		this.lruOrderedList = new LinkedList<>();
	}

	@Override
	public void keyAccessed(final String key) {
		System.out.println("BEFORE" + lruOrderedList);
		// remove if already present
		lruOrderedList.remove(key);

		// add at last the key that was accessed
		lruOrderedList.addLast(key);
		System.out.println("AFTER" + lruOrderedList);
	}

	@Override
	public String evict() {
		return lruOrderedList.removeFirst();
	}

}
