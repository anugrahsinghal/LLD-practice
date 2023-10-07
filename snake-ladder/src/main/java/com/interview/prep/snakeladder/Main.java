package com.interview.prep.snakeladder;

import com.interview.prep.snakeladder.command.FairDice;
import com.interview.prep.snakeladder.command.RollingService;
import com.interview.prep.snakeladder.model.Board;
import com.interview.prep.snakeladder.model.Cell;
import com.interview.prep.snakeladder.model.Game;
import com.interview.prep.snakeladder.model.MoveInterrupter;
import com.interview.prep.snakeladder.model.OutputPrinter;
import com.interview.prep.snakeladder.model.Player;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
* Problem Statement
Create a snake and ladder application. The application should take as input (from the command line or a file):

Number of snakes (s) followed by s lines each containing 2 numbers denoting the head and tail positions of the snake.
Number of ladders (l) followed by l lines each containing 2 numbers denoting the start and end positions of the ladder.
Number of players (p) followed by p lines each containing a name.
After taking these inputs, you should print all the moves in the form of the current player name followed by a random number between 1 to 6 denoting the die roll and the initial and final position based on the move.
Format: <player_name> rolled a <dice_value> and moved from <initial_position> to <final_position>

When someone wins the game, print that the player won the game.
Format: <player_name> wins the game

Rules of the game
The board will have 100 cells numbered from 1 to 100.
The game will have a six sided dice numbered from 1 to 6 and will always give a random number on rolling it.
Each player has a piece which is initially kept outside the board (i.e., at position 0).
Each player rolls the dice when their turn comes.
Based on the dice value, the player moves their piece forward that number of cells. Ex: If the dice value is 5 and the piece is at position 21, the player will put their piece at position 26 now (21+5).
A player wins if it exactly reaches the position 100 and the game ends there.
After the dice roll, if a piece is supposed to move outside position 100, it does not move.
The board also contains some snakes and ladders.
Each snake will have its head at some number and its tail at a smaller number.
Whenever a piece ends up at a position with the head of the snake, the piece should go down to the position of the tail of that snake.
Each ladder will have its start position at some number and end position at a larger number.
Whenever a piece ends up at a position with the start of the ladder, the piece should go up to the position of the end of that ladder.

There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.
Assumptions you can take apart from those already mentioned in rules
There won’t be a snake at 100.
There won’t be multiple snakes/ladders at the same start/head point.
It is possible to reach 100, i.e., it is possible to win the game.
Snakes and Ladders do not form an infinite loop.
*
* */
public class Main {

	public static final int NUM_PLAYER = 5;

	public static void main(String[] args) {
		List<Cell> cells = new ArrayList<>();
		cells.add(null);// first cell is empty
		final int boardSize = 100;
		for (int i = 1; i <= boardSize; i++) {
			cells.add(new Cell(i, null));
		}


		cells.get(62).setSnakeOrLadder(new MoveInterrupter(5));
		cells.get(33).setSnakeOrLadder(new MoveInterrupter(6));
		cells.get(49).setSnakeOrLadder(new MoveInterrupter(9));
		cells.get(88).setSnakeOrLadder(new MoveInterrupter(16));
		cells.get(41).setSnakeOrLadder(new MoveInterrupter(20));
		cells.get(56).setSnakeOrLadder(new MoveInterrupter(53));
		cells.get(98).setSnakeOrLadder(new MoveInterrupter(64));
		cells.get(93).setSnakeOrLadder(new MoveInterrupter(73));
		cells.get(95).setSnakeOrLadder(new MoveInterrupter(75));

		cells.get(2).setSnakeOrLadder(new MoveInterrupter(37));
		cells.get(10).setSnakeOrLadder(new MoveInterrupter(32));
		cells.get(27).setSnakeOrLadder(new MoveInterrupter(46));
		cells.get(51).setSnakeOrLadder(new MoveInterrupter(68));
		cells.get(61).setSnakeOrLadder(new MoveInterrupter(79));
		cells.get(65).setSnakeOrLadder(new MoveInterrupter(84));
		cells.get(71).setSnakeOrLadder(new MoveInterrupter(91));
		cells.get(81).setSnakeOrLadder(new MoveInterrupter(100));

		System.out.println(cells);

		final OutputPrinter printer = new OutputPrinter();
		final Board board = new Board(cells, boardSize, printer);
		final RollingService fairDice = new FairDice();

		Map<String, Player> playerMap = new TreeMap<>(Comparator.comparingInt(s -> Integer.parseInt(s.substring(4))));
		for (int i = 1; i <= NUM_PLAYER; i++) {
			final String user = "USER" + i;
			final Player player = new Player(user, fairDice);
			playerMap.put(user, player);
		}

		Game game = new Game(playerMap, board);
		final Set<String> strings = playerMap.keySet();

		for (int i = 0; i < 200; i++) {
			for (String name : strings) {
				game.play(name);
			}
		}


		// list of players
		// board with cells 0 to 100
		// dice with one to six
		// player is outside board
		// on dice role player will move
		// if player reach 100, then game end
		// if player roll more than 100 then no move

		// if player at head of snake then player move to tail
		// if player at tail of ladder then move to head

		// There could be another snake/ladder at the tail of the snake or the end position of the ladder and the piece should go up/down accordingly.

		// There won’t be a snake at 100.
		// There won’t be multiple snakes/ladders at the same start/head point.
	}
}
