package com.interview.prep.snakeladder.model;

import java.util.Map;

public class Game {

	private final Map<String, Player> players;
	private final Board board;

	public Game(Map<String, Player> players, Board board) {
		this.players = players;
		this.board = board;
	}

	public void play(String name) {
		final Player player = players.get(name);
		board.accept(player);
		isGameFinished(player);
	}

	private void isGameFinished(Player player) {
		if (player.getCurrentPosition().getCellNumber() == board.getSize()) {
			// Sagar wins the game
			System.out.printf("%s wins the game\n", player.getName());
			System.exit(0);
		}
	}

}
