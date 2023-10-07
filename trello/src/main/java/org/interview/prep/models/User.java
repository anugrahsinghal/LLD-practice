package org.interview.prep.models;

import java.util.UUID;
import lombok.Getter;
import lombok.ToString;

@ToString
public class User {

	@Getter
	private final String userId;
	private final String name;
	private final String email;

	public User(String name) {
		userId = UUID.randomUUID().toString();
		this.name = name;
		this.email = name + "@gmail.com";
	}

	public User(User assignedUser) {
		this.userId = assignedUser.userId;
		this.name = assignedUser.name;
		this.email = assignedUser.email;
	}

	public User(String userId, String name, String email) {
		this.userId = userId;
		this.name = name;
		this.email = email;
	}

	@Override
	public User clone() {
		return new User(name);
	}

}
