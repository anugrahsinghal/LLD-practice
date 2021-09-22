package org.interview.prep.factory;

import java.util.Collection;

public interface Repository<T> {

	default boolean create(T t) {
		return false;
	}

	T getById(String id);

	Collection<T> getAll();

	void delete(T t);

}
