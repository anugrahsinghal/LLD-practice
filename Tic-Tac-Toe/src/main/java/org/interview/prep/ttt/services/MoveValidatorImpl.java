package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;

public class MoveValidatorImpl implements MoveValidator {
	@Override
	public boolean isValidMove(int row, int col, Game _game) {
		char[][] grid = _game.getGrid();
		return (row >= 0 && row < grid.length) && (col >= 0 && col < grid.length) && grid[row - 1][col - 1] == '-';
	}
}
