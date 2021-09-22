package com.interview.prep.snakeladder.model;

public class OutputPrinter {

	public void printMove(Player player, Cell oldPosition, int roll) {
		System.out.printf("%s rolled a %d and moved from %d to %d\n", player.getName(), roll, oldPosition.getCellNumber(), player.getCurrentPosition().getCellNumber());
	}

}
