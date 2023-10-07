package com.interview.prep.coding.blox.services.interfaces;

import com.interview.prep.coding.blox.exceptions.ContestNotFoundException;
import com.interview.prep.coding.blox.exceptions.UserDoesNotExistException;
import com.interview.prep.coding.blox.models.Contest;
import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.UserData;
import java.util.Set;
import lombok.NonNull;

public interface ContestService {

	Long createContest(@NonNull String contestName, @NonNull Level level, @NonNull String userName) throws UserDoesNotExistException;

	Set<Contest> listContest(@NonNull Level level);

	Set<Contest> listContest();

	void attendContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException;

	void runContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException;

	void withdrawContest(@NonNull Long contestId, @NonNull String userName) throws ContestNotFoundException, UserDoesNotExistException;

	Set<UserData> getHistory(@NonNull Long contestId) throws ContestNotFoundException;
}

