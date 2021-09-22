package org.interview.prep.controller;

import org.interview.prep.services.CardManagementServiceImpl;
import org.interview.prep.services.ListManagementImpl;
import org.interview.prep.services.ProjectManagementImpl;
import org.junit.jupiter.api.Test;

class CardControllerTest {

	final ProjectManagementImpl boradService = new ProjectManagementImpl();
	BoardController boardController = new BoardController(boradService);

	final ListManagementImpl listService = new ListManagementImpl(boradService);
	ListController listController = new ListController(listService);

	CardController cardController = new CardController(new CardManagementServiceImpl(listService));

	@Test
	void createCard() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list = listController.createList(board, "LIST");
		cardController.createCard(list, "user__1");
		boardController.show();
	}

	@Test
	void modifyCard() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list = listController.createList(board, "LIST");
		final String user__1 = cardController.createCard(list, "user__1");
		cardController.show(user__1);
		cardController.modifyCard(user__1, "name", "user__2");
		cardController.show(user__1);
	}

	@Test
	void assignCard() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list = listController.createList(board, "LIST");
		final String user__1 = cardController.createCard(list, "user__1");
		cardController.show(user__1);
		cardController.assignCard(user__1, "user__2");
		cardController.show(user__1);
	}

	@Test
	void show() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list = listController.createList(board, "LIST");
		final String user__1 = cardController.createCard(list, "user__1");
		boardController.show();
		cardController.show(user__1);
	}

	@Test
	void move() {
		final String board = boardController.createBoard("NEW_BOARD");
		final String list1 = listController.createList(board, "LIST1");
		final String list2 = listController.createList(board, "LIST2");
		final String card1 = cardController.createCard(list1, "card1");

		boardController.show();

		listController.showList(board);

		cardController.move(card1, list2);

		listController.showList(board);
	}

	@Test
	void removeAssignedUser() {
	}
}