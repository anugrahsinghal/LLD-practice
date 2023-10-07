package org.interview.prep.services;

import java.util.List;
import lombok.AllArgsConstructor;
import org.interview.prep.models.BookCopy;
import org.interview.prep.models.Library;

@AllArgsConstructor
public class BookSearchServiceImpl implements BookSearchService {

	private final Library library;

	@Override
	public List<BookCopy> searchBook(String searchType, String searchQuery) {
		return null;
	}
}
