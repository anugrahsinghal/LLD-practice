package com.interview.prep.coding.blox.models;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UserData {
	private final String username;
	private final Set<Long> solvedQuestionIds;

	public UserData(String username) {
		this.username = username;
		this.solvedQuestionIds = new HashSet<>();
	}

}
