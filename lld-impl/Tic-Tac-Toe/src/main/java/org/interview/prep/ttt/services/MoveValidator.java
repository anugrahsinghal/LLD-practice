package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;

public interface MoveValidator {
	boolean isValidMove(int row, int col, Game game);
}
