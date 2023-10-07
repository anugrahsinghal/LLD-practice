package org.interview.prep.ttt.models;

import lombok.Getter;

public class Player {
	@Getter
	private final String name;
	@Getter
	private final char piece;

	public Player(String name, char piece) {
		this.name = name;
		this.piece = piece;
	}
}
