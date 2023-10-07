package org.interview.prep.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.interview.prep.ttt.models.Game;
import org.interview.prep.ttt.models.GameState;
import org.interview.prep.ttt.models.Player;
import org.interview.prep.ttt.services.GridCheckServiceImpl3x3;
import org.interview.prep.ttt.services.MoveValidatorImpl;
import org.interview.prep.ttt.services.OutputPrinterServiceImpl;

public class Main {

	/*
Ask the user for the names of the two players
Print the grid after initializing
Allow the user to make moves on behalf of both the players.
The user will make a move by entering the cell position.
You need to determine the piece (X/O) and make the move if it is valid.
Valid move:
The piece is controlled by the player having the current turn
The cell is empty
If the move is invalid
print 'Invalid Move'
the same player plays again
If the move is valid:
put the piece on the cell
print the board after the move
Determine if a player has won or if there are no valid moves left. Ignore all moves mentioned after that.
A position in the cell is represented by two values: row number (1-3) and column number (1-3).
*/
	public static void main(String[] args) throws IOException {

		if (args.length == 0) {
			interactiveGamePlay();
		} else {
			fileInputGamePlay();
		}
		// take 2 player
		// print grid
		// take move from player as cell position
		// placing of X/O to be owned by program

		// If the move is invalid
		// print 'Invalid Move'
		// and same player moves again

		// on valid move
		// put piece
		// print board

		// game end
		// if player wins
		// or no valid moves left


		// if game not over
	}

	private static void fileInputGamePlay() {

	}

	private static void interactiveGamePlay() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<Player> players = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			final String playerDetail = bufferedReader.readLine();
			final String[] s = playerDetail.split(" ");
			Player player = new Player(s[1], s[0].toCharArray()[0]);
			players.add(player);
		}
		Game game = new Game(
				3,
				new GridCheckServiceImpl3x3(new char[] {'X', 'O'}),
				new MoveValidatorImpl(),
				new OutputPrinterServiceImpl()
		);

		outer:
		while (true) { // play till end
			for (Player player : players) {
				boolean valid = false;
				while (!valid && !game.getGameState().equals(GameState.OVER)) {
					final String moveStr = bufferedReader.readLine().trim();
					if (moveStr.equalsIgnoreCase("exit")) {
						game.endGame();
						break;
					}
					final String[] s = moveStr.split(" ");

					valid = game.placePiece(player, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
				}
				if (game.getGameState().equals(GameState.OVER)) {
					break outer;
				}
			}
		}
	}

}
