package org.interview.prep.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Library {

	private final Map<String, Book> books;
	private final Rack[] racks;

	public Library(int numRacks) {
		this.books = new HashMap<>();
		this.racks = new Rack[numRacks];
	}

	public List<BookCopy> searchBookById(String bookId) {
		final Book book = books.get(bookId);
		if (book == null) {
			System.out.println("NOT FOUND");
		} else {
			return findInRacksById(bookId);
		}
	}

	private List<BookCopy> findInRacksById(String bookId) {
		return null;
	}

	public boolean borrowBook(String bookId) {
		if (!books.containsKey(bookId)) { //book exists
			System.out.println("Invalid Book id");
			return false;
		} else if (findRackWithNonBookedBook(bookId) == -1) {
			System.out.println("Not Available");
			return false; // cannot borrow book
		}
		System.out.println();
		return true;
	}

	public int findRackWithNonBookedBook(String bookId) {
		return 0;
	}

	public boolean borrowBookCopy(String bookId) {
		return borrowBook(bookId);
	}
}
