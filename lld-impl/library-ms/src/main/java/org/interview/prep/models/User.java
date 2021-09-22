package org.interview.prep.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

	private final String userId;
	private final String name;
	private final BorrowingDetail[] borrowedBooks;

	public User(String userId, String name, int maxAllowedToBorrow) {
		this.userId = userId;
		this.name = name;
		this.borrowedBooks = new BorrowingDetail[maxAllowedToBorrow];
	}

}
