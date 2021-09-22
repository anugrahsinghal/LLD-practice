package org.interview.prep.services;

import java.util.List;
import org.interview.prep.models.BookCopy;

public interface BookSearchService {

	List<BookCopy> searchBook(String searchType, String searchQuery);

	boolean existsById(String bookId);

}
