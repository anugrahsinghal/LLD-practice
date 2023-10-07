package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.exceptions.UserDoesNotExistException;
import com.interview.prep.coding.blox.models.User;
import com.interview.prep.coding.blox.services.interfaces.UserService;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final Map<String, User> userMap;

	@Override
	public String createUser(String username) {
		if (username == null || userMap.containsKey(username)) {
			throw new IllegalArgumentException("WRONG USER NAME");
		}
		User user = new User(username);
		userMap.put(username, user);
		return username;
	}

	@Override
	public User getByName(String userName) throws UserDoesNotExistException {
		return Optional.ofNullable(userMap.get(userName)).orElseThrow(() -> new UserDoesNotExistException());
	}

	@Override
	public Collection<User> getAll() {
		return userMap.values();
	}
}
