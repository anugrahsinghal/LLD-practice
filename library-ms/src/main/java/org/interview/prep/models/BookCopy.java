package org.interview.prep.models;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCopy {
	private final String bookId;
	private final String copyId;
	private boolean isBorrowed;

	public BookCopy(Book book, String copyId) {
		this.bookId = book.getId();
		this.copyId = copyId;
		isBorrowed = false;
	}

	public BookCopy(String bookId, String copyId) {
		this.bookId = bookId;
		this.copyId = copyId;
		isBorrowed = false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!(o instanceof BookCopy)) {
			return false;
		}
		BookCopy bookCopy = (BookCopy) o;
		return Objects.equals(getBookId(), bookCopy.getBookId()) && Objects.equals(getCopyId(), bookCopy.getCopyId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getBookId(), getCopyId());
	}
}
