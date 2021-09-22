package org.interview.prep.cache.storage;

import org.interview.prep.cache.exception.CacheFullException;
import org.interview.prep.cache.exception.KeyNotFoundException;

public interface Storage {

	void put(String key, String val) throws CacheFullException;

	String get(String key) throws KeyNotFoundException;

	void remove(String key);

}
