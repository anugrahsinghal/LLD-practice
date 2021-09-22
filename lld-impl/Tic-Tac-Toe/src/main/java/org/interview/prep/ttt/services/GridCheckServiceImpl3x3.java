package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;

public class GridCheckServiceImpl3x3 implements GridCheckService {

	private final char[] validPieces;

	public GridCheckServiceImpl3x3(char[] validPieces) {
		this.validPieces = validPieces;
	}

	@Override
	public boolean checkGridForFilledState(Game game) {
		return filled(game.getGrid());
	}

	@Override
	public boolean checkGridForWinningState(Game game) {
		return checkDiagonals(game.getGrid()) ||
		       checkHorizontalSeq(game.getGrid()) ||
		       checkVerticalSeq(game.getGrid());
	}

	private boolean filled(char[][] grid) {
		int countNotFilled = 0;
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '-') {
					countNotFilled++;
				}
			}
		}
		return countNotFilled == 0;
	}

	private boolean checkVerticalSeq(char[][] grid) {
		for (char piece : validPieces) {
			for (int columnNumber = 0; columnNumber < 3; columnNumber++) {
				if (grid[0][columnNumber] == piece && grid[1][columnNumber] == piece && grid[2][columnNumber] == piece) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkHorizontalSeq(char[][] grid) {
		for (char piece : validPieces) {
			for (int rowNumber = 0; rowNumber < 3; rowNumber++) {
				if (grid[rowNumber][0] == piece && grid[rowNumber][1] == piece && grid[rowNumber][2] == piece) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean checkDiagonals(char[][] grid) {
		for (char piece : validPieces) {
			final boolean b = (grid[0][0] == piece && grid[1][1] == piece && grid[2][2] == piece) ||
			                  (grid[0][2] == piece && grid[1][1] == piece && grid[2][2] == piece);
			return b;

		}
		return false;
	}

}
