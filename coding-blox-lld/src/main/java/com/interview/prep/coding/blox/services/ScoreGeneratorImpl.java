package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.exceptions.UserDoesNotExistException;
import com.interview.prep.coding.blox.models.Contest;
import com.interview.prep.coding.blox.models.Question;
import com.interview.prep.coding.blox.models.User;
import com.interview.prep.coding.blox.models.UserData;
import com.interview.prep.coding.blox.services.interfaces.UserScoreGenerator;
import com.interview.prep.coding.blox.services.interfaces.UserService;
import java.util.Set;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ScoreGeneratorImpl implements UserScoreGenerator {

	private final UserService userService;

	@Override
	public void generateRandomScoreForUsers(Contest contest, Set<UserData> userData) {
		for (UserData data : userData) {
			try {
				final User user = userService.getByName(data.getUsername());
				for (Question question : contest.getQuestions()) {
					final long currentScore = user.getScore();
					long newScore = currentScore;
					if (Math.random() > 0.3) {
						newScore = currentScore + (contest.getPoints() - 50);
						data.getSolvedQuestionIds().add(question.getId());
					}
					user.updateScore(newScore);
				}
			} catch (UserDoesNotExistException e) {
				System.out.println("USER REGISTERED BUT ENTITY WAS SOMEHOW DELETED");
			}

		}
	}
}
