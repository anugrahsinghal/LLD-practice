package org.interview.prep.ttt.models;

import lombok.Getter;
import org.interview.prep.ttt.services.GridCheckService;
import org.interview.prep.ttt.services.MoveValidator;
import org.interview.prep.ttt.services.OutputPrinterService;

public class Game {

	@Getter
	private final char[][] grid;
	private final GridCheckService gridCheckService;
	private final MoveValidator moveValidator;
	private final OutputPrinterService outputPrinterService;
	@Getter
	private GameState gameState;

	public Game(final int size, final GridCheckService gridCheckService, final MoveValidator moveValidator,
	            final OutputPrinterService outputPrinterService) {
		this.grid = new char[size][size];
		this.gridCheckService = gridCheckService;
		this.moveValidator = moveValidator;
		this.outputPrinterService = outputPrinterService;
		this.gameState = GameState.IN_PROGRESS;
		initGrid(size);
		outputPrinterService.printGrid(this);
	}

	private void initGrid(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[i][j] = '-';
			}
		}
	}

	public boolean placePiece(Player player, int row, int col) {
		if (moveValidator.isValidMove(row, col, this)) {
			grid[row - 1][col - 1] = player.getPiece();
			outputPrinterService.printGrid(this);
			updateGameState(player);
			return true;
		}
		outputPrinterService.invalidMove(player);
		return false;
	}

	private void updateGameState(Player player) {
		if (gridCheckService.checkGridForFilledState(this)) {
			this.gameState = GameState.OVER;
			outputPrinterService.gameOver();
		} else if (gridCheckService.checkGridForWinningState(this)) {
			this.gameState = GameState.OVER;
			outputPrinterService.declareWinner(player);
		}
	}

	public void endGame() {
		this.gameState = GameState.OVER;
	}

}
