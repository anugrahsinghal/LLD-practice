package com.interview.prep.snakeladder.command;

import java.util.Random;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FairDice implements RollingService {

	private static final Random RANDOM = new Random();

	public int roll() {
		final int i = RANDOM.nextInt(7);
		if(i == 0) return 1;
		return i;
	}

}
