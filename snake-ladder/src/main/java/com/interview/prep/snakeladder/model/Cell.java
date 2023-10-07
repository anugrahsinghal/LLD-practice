package com.interview.prep.snakeladder.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Cell {

	public static final Cell DEFAULT_POSITION = new Cell(0, null);

	private final int cellNumber;

	// FIXME REMOVE SETTER
	@Setter
	private MoveInterrupter snakeOrLadder;

	public boolean hasInterruption() {
		return this.snakeOrLadder != null;
	}

	public boolean hasLadder() {
		return this.hasInterruption();
	}

	public int getDestination(MoveInterrupter moveInterrupter) {
		return moveInterrupter.getTo();
	}


}
