package org.interview.prep.controller;

import org.interview.prep.services.ListManagementImpl;
import org.interview.prep.services.ProjectManagementImpl;
import org.junit.jupiter.api.Test;

class ListControllerTest {

	final ProjectManagementImpl boradService = new ProjectManagementImpl();
	BoardController boardController = new BoardController(boradService);
	ListController listController = new ListController(new ListManagementImpl(boradService));

	@Test
	void createList() {
		final String board = boardController.createBoard("NEW_BOARD");
		listController.createList(board, "LIST");
		listController.showList(board);
		boardController.show();
	}

	@Test
	void showList() {
		final String board = boardController.createBoard("NEW_BOARD");
		listController.createList(board, "LIST");
		listController.showList(board);
	}

	@Test
	void modifySubProject() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list = listController.createList(board, "LIST");
		listController.showList(board);
		listController.modifyList(list, "name", "NEWEST_LIST_NAME");
		listController.showList(board);

	}
}