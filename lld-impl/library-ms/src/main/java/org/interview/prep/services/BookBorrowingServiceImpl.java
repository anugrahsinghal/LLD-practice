package org.interview.prep.services;

import java.util.Arrays;
import java.util.Date;
import java.util.function.Predicate;
import lombok.AllArgsConstructor;
import org.interview.prep.models.BookCopy;
import org.interview.prep.models.Library;
import org.interview.prep.models.Rack;

@AllArgsConstructor
public class BookBorrowingServiceImpl implements BookBorrowingService {

	private final Library library;

	private BookSearchService bookSearchService;
	private UserDetailsService userDetailsService;

	@Override
	public void borrowBook(String bookId, String userId, Date dueDate) {
		if (isUserOverLimit(userId)) {
			return;
		}
		final boolean bookBorrowed = library.borrowBook(bookId);
		if (bookBorrowed) {
			userDetailsService.bookBorrowed(userId, bookId, dueDate);
		}
	}

	@Override
	public void borrowBookCopy(String bookId, String userId, Date dueDate) {
		if (isUserOverLimit(userId)) {
			return;
		}
		final boolean bookBorrowed = library.borrowBookCopy(bookId);
		if (bookBorrowed) {
			userDetailsService.bookCopyBorrowed(userId, bookId, dueDate);
		}
	}

	private boolean getRackNumberForBook(String bookId) {
		final boolean hasNonBorrowedBook = Arrays.stream(library.getRacks())
				.anyMatch(doesRackHaveNonBorrowedBook(bookId));
		if (!hasNonBorrowedBook) {
			System.out.println("Not available");
			return true;
		}
		return false;
	}

	private boolean isUserOverLimit(String userId) {
		final boolean overLimit = userDetailsService.isOverLimit(userId);
		if (overLimit) {
			System.out.println("Overlimit");
			return true;
		}
		return false;
	}

	private boolean isBookIdNotValid(String bookId) {
		final boolean bookExists = bookSearchService.existsById(bookId);
		if (!bookExists) {
			System.out.println("Invalid Book ID");
			return true;
		}
		return false;
	}

	private Predicate<Rack> doesRackHaveNonBorrowedBook(String bookId) {
		return rack -> {
			for (BookCopy book : rack.getBooks()) {
				if (book.getBookId().equalsIgnoreCase(bookId) && !book.isBorrowed()) {
					return true;
				}
			}
			return false;
		};
	}

	@Override
	public void returnBook(String bookId, String userId, Date dueDate) {

	}

	@Override
	public void returnBookCopy(String bookCopyId, String userId, Date dueDate) {

	}

	@Override
	public void returnBook(String bookCopyId) {

	}

}
