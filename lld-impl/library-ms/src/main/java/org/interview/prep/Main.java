package org.interview.prep;

import java.util.Date;
import org.interview.prep.models.Library;
import org.interview.prep.services.BookBorrowingService;
import org.interview.prep.services.BookBorrowingServiceImpl;
import org.interview.prep.services.BookSearchServiceImpl;
import org.interview.prep.services.LibraryManagementServiceImpl;
import org.interview.prep.services.UserDetailsService;

public class Main {
	public static void main(String[] args) {
		Library library = new Library(10);
		final LibraryManagementServiceImpl libraryManagementService = new LibraryManagementServiceImpl(
				new BookBorrowingServiceImpl(), new BookSearchServiceImpl(), library
		);

		libraryManagementService.addBook(2, null);

		libraryManagementService.removeBook("queryTyp", 1);

		UserDetailsService userDetailsService = new UserDetailsService() {
			@Override
			public void printBorrowingDetails(String user1) {

			}
		};

		userDetailsService.printBorrowingDetails("user1");


		BookBorrowingService bookBorrowingService = new BookBorrowingService() {
			@Override
			public void borrowBook(String bookId, String userId, Date dueDate) {

			}

			@Override
			public void returnBook(String bookId, String userId, Date dueDate) {

			}

			@Override
			public void returnBook(String bookCopyId) {

			}
		};

		bookBorrowingService.returnBook("", "", new Date());

	}
}
