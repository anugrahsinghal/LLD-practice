package com.interview.prep.snakeladder.model;

import com.interview.prep.snakeladder.command.RollingService;
import lombok.Getter;

public class Player {

	@Getter
	private final String name;
	private final RollingService dice;

	@Getter
	private Cell currentPosition;

	public Player(String name, RollingService dice) {
		this.name = name;
		this.currentPosition = Cell.DEFAULT_POSITION;
		this.dice = dice;
	}

	public int rollDice() {
		return dice.roll();
	}

	public void offerNewPosition(Cell newPosition) {
		this.currentPosition = newPosition;
	}

}
