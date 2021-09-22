package org.interview.prep.controller;

import org.interview.prep.services.ProjectManagementImpl;
import org.junit.jupiter.api.Test;

class BoardControllerTest {

	BoardController controller = new BoardController(new ProjectManagementImpl());

	@Test
	void createBoard() {

	}

	@Test
	void deleteBoard() {
		final String boardId = controller.createBoard("NEW");
		controller.show(boardId);
		controller.deleteBoard(boardId);
		controller.show();
	}

	@Test
	void addMember() {
		final String boardId = controller.createBoard("NEW");
		controller.addMember(boardId, "USER1");
		controller.show(boardId);
	}

	@Test
	void removeMember() {
		final String boardId = controller.createBoard("NEW");
		controller.addMember(boardId, "USER1");
		final String user2 = controller.addMember(boardId, "USER2");
		controller.show(boardId);
		controller.removeMember(boardId, user2);
		controller.show(boardId);
	}

	@Test
	void show() {
		final String boardId = controller.createBoard("NEW");
		controller.show(boardId);
	}

	@Test
	void testShow() {
		controller.show();
		final String boardId = controller.createBoard("NEW");
		controller.show();
	}
}