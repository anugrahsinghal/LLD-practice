package org.interview.prep.controller;

import org.interview.prep.models.User;
import org.interview.prep.services.ProjectManagement;

public class BoardController {

	private ProjectManagement boardManagement;

	public BoardController(ProjectManagement boardManagement) {
		this.boardManagement = boardManagement;
	}

	public String createBoard(String boardName) {
		return boardManagement.createBoard(boardName);
	}


	public void deleteBoard(String boardId) {
		boardManagement.deleteBoard(boardId);
	}

	public String addMember(String boardId, String name) {
		final User member = new User(name);
		boardManagement.addMember(boardId, member);
		return member.getUserId();
	}

	public void removeMember(String boardId, String userId) {
		boardManagement.removeMember(boardId, userId);
	}

	public void show(String boardId) {
		boardManagement.show(boardId);
	}

	public void show() {
		boardManagement.show();
	}


}
