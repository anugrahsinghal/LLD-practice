package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;
import org.interview.prep.ttt.models.Player;

public interface OutputPrinterService {

	void printGrid(Game game);

	void invalidMove(Player player);

	void gameOver();

	void declareWinner(Player player);

}
