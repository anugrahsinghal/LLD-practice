package com.interview.prep.coding.blox.services;

public class ContestIdGenerator {

	long currentSize = 0;

	public Long getContestId() {
		currentSize++;
		return currentSize;
	}
}