package org.interview.prep.services;

import java.util.List;
import org.interview.prep.models.Book;
import org.interview.prep.models.BookCopy;

public interface LibraryManagementService {

	void addBook(int rackNumber, Book book);

	void removeBook(String queryTyp, int i);

}
