package org.interview.prep.services;

import java.util.Date;

public interface UserDetailsService {
	void printBorrowingDetails(String user1);

	boolean isOverLimit(String userId);

	void bookBorrowed(String userId, String bookId, Date dueDate);

	void bookCopyBorrowed(String userId, String bookId, Date dueDate);

}
