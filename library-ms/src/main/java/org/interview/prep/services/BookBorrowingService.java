package org.interview.prep.services;

import java.util.Date;

public interface BookBorrowingService {

	/**
	 * @param bookId  can refer to either book's id or book's copy Id
	 * @param userId  id of user
	 * @param dueDate date by which book needs to be returned
	 */
	void borrowBook(final String bookId, final String userId, Date dueDate);

	void borrowBookCopy(final String bookCopyId, final String userId, Date dueDate);

	/**
	 * @param bookId  can refer to either book's id or book's copy Id
	 * @param userId  id of user
	 * @param dueDate date by which book needs to be returned
	 */
	void returnBook(final String bookId, final String userId, Date dueDate);
	void returnBookCopy(final String bookCopyId, final String userId, Date dueDate);


}

