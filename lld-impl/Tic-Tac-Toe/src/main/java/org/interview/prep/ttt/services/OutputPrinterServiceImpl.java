package org.interview.prep.ttt.services;

import org.interview.prep.ttt.models.Game;
import org.interview.prep.ttt.models.Player;

public class OutputPrinterServiceImpl implements OutputPrinterService {

	@Override
	public void printGrid(Game _game) {
		char[][] grid = _game.getGrid();
		System.out.println();
		for (int i = 0; i < grid[0].length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	@Override
	public void invalidMove(Player player) {
		System.out.println("Invalid Move");
	}

	@Override
	public void gameOver() {
		System.out.println("Game Over");
	}

	@Override
	public void declareWinner(Player player) {
		System.out.println(player.getName() + " won the game");
	}
}
