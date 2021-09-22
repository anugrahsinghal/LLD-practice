package org.interview.prep.mutltilevel.storage;

import org.interview.prep.mutltilevel.exception.CacheFullException;
import org.interview.prep.mutltilevel.exception.KeyNotFoundException;

public interface Storage {

	void put(String key, String val) throws CacheFullException;

	String get(String key) throws KeyNotFoundException;

	void remove(String key);

}
