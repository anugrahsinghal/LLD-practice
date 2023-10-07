package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.models.User;
import com.interview.prep.coding.blox.services.interfaces.LeaderBoardService;
import com.interview.prep.coding.blox.services.interfaces.UserService;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LeaderBoardServiceImpl implements LeaderBoardService {

	private final UserService userService;

	@Override
	public void showLeaderBoard(String order) {

		final List<User> collect = userService.getAll()
				.stream()
				.sorted(getComparator(order))
				.collect(Collectors.toList());
		System.out.println(collect);

	}

	private Comparator<User> getComparator(String s) {
		if (s.equals("ASC")) {
			return Comparator.comparing(User::getScore);
		} else {
			return Comparator.comparing(User::getScore).reversed();
		}
	}


}
