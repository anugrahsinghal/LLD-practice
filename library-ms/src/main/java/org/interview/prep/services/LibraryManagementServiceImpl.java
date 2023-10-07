package org.interview.prep.services;

import lombok.AllArgsConstructor;
import org.interview.prep.models.Book;
import org.interview.prep.models.Library;

@AllArgsConstructor
public class LibraryManagementServiceImpl implements LibraryManagementService {

	public static final String DEAFULT_KEY = "DEAFULT_KEY";

	private final Library library;

	@Override
	public void addBook(int rackNumber, Book book) {

	}

	@Override
	public void removeBook(String queryTyp, int i) {

	}
}
