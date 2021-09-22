package org.interview.prep.models;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Rack {

	private final Set<BookCopy> books;
	private final int maxSize;

	public Rack(int maxSize) {
		this.books = new HashSet<>();
		this.maxSize = maxSize;
	}

	public boolean addBookCopy(String bookId, String copyId) {
		return books.add(new BookCopy(bookId, copyId));
	}

	public boolean removeBookCopy(String copyId) {
		final Optional<BookCopy> bookCopy = books.stream().filter(copy -> copy.getCopyId().equalsIgnoreCase(copyId)).findAny();
		return bookCopy.filter(books::remove).isPresent();
	}

}
