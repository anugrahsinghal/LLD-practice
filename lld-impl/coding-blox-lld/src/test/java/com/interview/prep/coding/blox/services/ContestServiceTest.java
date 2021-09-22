package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.services.interfaces.ContestService;
import com.interview.prep.coding.blox.services.interfaces.LeaderBoardService;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

class ContestServiceTest {

	@Test
	void test_single_contest() throws Exception {
		final UserServiceImpl userService = new UserServiceImpl(new HashMap<>());
		final QuestionServiceImpl questionService = new QuestionServiceImpl(new HashMap<>());
		final ScoreGeneratorImpl userScoreGenerator = new ScoreGeneratorImpl(userService);
		ContestService contestService = new ContestServiceImpl(userService, new HashMap<>(), userScoreGenerator, new ContestIdGenerator(),
				new HashMap<>(), questionService);
		final LeaderBoardService leaderBoard = new LeaderBoardServiceImpl(userService);

		final String user = "USER";
		userService.createUser(user);

		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.LOW, "NEW LOW QUESTION " + i);
		}
		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.HIGH, "NEW HIGH QUESTION " + i);
		}
		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.MEDIUM, "NEW MEDIUM QUESTION " + i);
		}

		System.out.println("questionService.listQuestions() = " + questionService.listQuestions());

		final String contestName = "NAME";
		final Long contestId = contestService.createContest(contestName, Level.LOW, user);

		System.out.println("contestService.listContest() = " + contestService.listContest());

		for (int i = 0; i < 5; i++) {
			userService.createUser(user + i);
		}

		for (int i = 0; i < 3; i++) {
			contestService.attendContest(contestId, user + i);
		}

		contestService.runContest(contestId, user);


		leaderBoard.showLeaderBoard("ASC");
		leaderBoard.showLeaderBoard("DESC");

	}


	@Test
	void test_multiple_contest() throws Exception {
		final UserServiceImpl userService = new UserServiceImpl(new HashMap<>());
		final QuestionServiceImpl questionService = new QuestionServiceImpl(new HashMap<>());
		final ScoreGeneratorImpl userScoreGenerator = new ScoreGeneratorImpl(userService);
		ContestService contestService = new ContestServiceImpl(userService, new HashMap<>(), userScoreGenerator, new ContestIdGenerator(),
				new HashMap<>(), questionService);
		final LeaderBoardService leaderBoard = new LeaderBoardServiceImpl(userService);

		final String user = "USER";
		userService.createUser(user);

		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.LOW, "NEW LOW QUESTION " + i);
		}
		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.HIGH, "NEW HIGH QUESTION " + i);
		}
		for (int i = 0; i < 5; i++) {
			questionService.createQuestion(Level.MEDIUM, "NEW MEDIUM QUESTION " + i);
		}

		System.out.println("questionService.listQuestions() = " + questionService.listQuestions());

		final String contestName = "NAME";
		final Long contestId_LOW = contestService.createContest(contestName, Level.LOW, user);
		final Long contestId_med = contestService.createContest(contestName, Level.MEDIUM, user);
		final Long contestId_high = contestService.createContest(contestName, Level.HIGH, user);

		System.out.println("contestService.listContest() = " + contestService.listContest());

		for (int i = 0; i < 5; i++) {
			userService.createUser(user + i);
		}

		for (int i = 0; i < 3; i++) {
			contestService.attendContest(contestId_LOW, user + i);
		}

		contestService.runContest(contestId_LOW, user);
		contestService.runContest(contestId_med, user);
		contestService.runContest(contestId_high, user);

		System.out.println("contestService.listContest() = " + contestService.listContest());


		System.out.println("contestService.getHistory(contestId_LOW) = " + contestService.getHistory(contestId_LOW));
		System.out.println("contestService.getHistory(contestId_med) = " + contestService.getHistory(contestId_med));
		System.out.println("contestService.getHistory(contestId_high) = " + contestService.getHistory(contestId_high));

		leaderBoard.showLeaderBoard("ASC");
		leaderBoard.showLeaderBoard("DESC");

	}

}