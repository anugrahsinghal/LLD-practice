package com.interview.prep.snakeladder.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Board {

	//	private final Map<Integer, Cell> positionToCellMap;
	private final List<Cell> cells;
	@Getter
	private final int size;
	private final OutputPrinter printer;

	public Cell getNewPosition(Cell oldPosition, int roll) {
		Cell newPos = getCellAtPosition(oldPosition.getCellNumber() + roll);
		return findCellRecursively(newPos);
	}

	private Cell getCellAtPosition(int pos) {
		return cells.get(pos);
	}

	private Cell findCellRecursively(Cell cell) {
		if (!cell.hasInterruption()) {
			return cell;
		} else {
			System.out.println("RECURSE");
			return findCellRecursively(getCellAtPosition(cell.getDestination(cell.getSnakeOrLadder())));
		}
	}

	// this way we can have more logic in board
	// say, to block player
	public void accept(Player player) {
		final int move = player.rollDice();
		if (isMoveLegal(move, player)) {
			Cell oldPos = player.getCurrentPosition();
			final Cell newPosition = getNewPosition(player.getCurrentPosition(), move);
			player.offerNewPosition(newPosition);
			printer.printMove(player, oldPos, move);
		}
	}

	private boolean isMoveLegal(int roll, Player player) {
		if (player.getCurrentPosition().getCellNumber() + roll > this.getSize()) {
			System.out.printf("%s NO MOVE got roll %d and would move from %d to %d\n", player.getName(), roll, player.getCurrentPosition().getCellNumber(),
					(player.getCurrentPosition().getCellNumber() + roll));
			return false;
		}
		return true;
	}


}
