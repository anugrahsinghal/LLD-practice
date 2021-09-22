package org.interview.prep.factory;

public interface ModifiableRepository<T> extends Repository<T> {

	T modify(String id, String modifyReq, String newValue);

}
