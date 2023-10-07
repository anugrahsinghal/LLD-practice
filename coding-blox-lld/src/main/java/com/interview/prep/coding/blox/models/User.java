package com.interview.prep.coding.blox.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@ToString

@Getter
@AllArgsConstructor
public class User {
	//	private final Long id;
	private final String username;
	private long score;

	public User(String username) {
		this.username = username;
		this.score = 0;
	}

	public void updateScore(long val) {
		score = val;
	}
}
