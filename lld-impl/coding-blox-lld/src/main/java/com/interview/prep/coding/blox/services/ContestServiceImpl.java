package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.exceptions.ContestNotFoundException;
import com.interview.prep.coding.blox.exceptions.UserDoesNotExistException;
import com.interview.prep.coding.blox.models.Contest;
import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.State;
import com.interview.prep.coding.blox.models.User;
import com.interview.prep.coding.blox.models.UserData;
import com.interview.prep.coding.blox.services.interfaces.ContestService;
import com.interview.prep.coding.blox.services.interfaces.QuestionService;
import com.interview.prep.coding.blox.services.interfaces.UserScoreGenerator;
import com.interview.prep.coding.blox.services.interfaces.UserService;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ContestServiceImpl implements ContestService {

	private final UserService userService;
	@Getter
	private final Map<Long, Contest> contestIdToContest;
	private final UserScoreGenerator userScoreGenerator;
	private final ContestIdGenerator contestIdGenerator;

	private final Map<Long, Set<UserData>> contestUserDetails;
	private final QuestionService questionService;

	@Override
	public Long createContest(@NonNull String contestName, @NonNull Level level, @NonNull String userName) throws UserDoesNotExistException {
		final User creator = userService.getByName(userName);

		final Long contestId = contestIdGenerator.getContestId();
		Contest contest = new Contest(contestId, contestName, level, creator, State.CREATED);
		contest.setQuestions(questionService.getRandomSet(level));

		contestIdToContest.put(contestId, contest);

		storeHistory(creator.getUsername(), contestId);

		return contestId;
	}

	private void storeHistory(String userName, Long contestId) {
		final UserData userData = new UserData(userName);
		Set<UserData> userToQuestions = new HashSet<>();
		userToQuestions.add(userData);
		contestUserDetails.put(contestId, userToQuestions);
	}

	@Override
	public Set<Contest> listContest(@NonNull Level level) {
		return contestIdToContest.values()
				.stream()
				.filter(contest -> contest.getLevel().equals(level))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<Contest> listContest() {
		return new HashSet<>(contestIdToContest.values());
	}

	@Override
	public void attendContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException {
		final Contest contest = contestIdToContest.get(contestId);
		if (contest == null) {
			throw new ContestNotFoundException(contestId);
		}
		if (contest.getState().equals(State.FINISHED)) {
			// we are allowing user to attend contest while it is running
			throw new IllegalArgumentException("CANNOT ATTEND FINISHED CONTEST");
		}

		storeHistory(userName, contestId);
	}

	@Override
	public void runContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException {
		final Contest contest = contestIdToContest.get(contestId);
		if (contest == null) {
			throw new ContestNotFoundException(contestId);
		}
		final User user = userService.getByName(userName);

		if (contest.getCreator().equals(user)) {
			contest.updateState(State.RUNNING);

			userScoreGenerator.generateRandomScoreForUsers(contest, contestUserDetails.get(contestId));

			contest.updateState(State.FINISHED);

		} else {
			throw new IllegalArgumentException("CANNOT START");
		}


	}

	@Override
	public void withdrawContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException {
		final Contest contest = contestIdToContest.get(contestId);
		if (contest == null) {
			throw new ContestNotFoundException(contestId);
		}
		final User user = userService.getByName(userName);

		final Set<UserData> userData = contestUserDetails.get(contestId);

		final Optional<UserData> userDataOptional = userData.stream()
				.filter(ud -> ud.getUsername().equals(user.getUsername()))
				.findFirst();

		if (userDataOptional.isPresent()) {
			userData.remove(userDataOptional.get());
		} else {
			throw new IllegalArgumentException("NOT ATTENDING CONTEST");
		}

	}

	@Override
	public Set<UserData> getHistory(@NonNull Long contestId) throws ContestNotFoundException {
		final Contest contest = contestIdToContest.get(contestId);
		if (contest == null) {
			throw new ContestNotFoundException(contestId);
		}
		return contestUserDetails.get(contestId);
	}

}


