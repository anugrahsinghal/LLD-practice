package org.interview.prep.services;

import org.interview.prep.factory.ModifiableRepository;
import org.interview.prep.models.Board;
import org.interview.prep.models.User;

public interface ProjectManagement extends ModifiableRepository<Board> {

	String createBoard(String name);

	void deleteBoard(String boardId);

	String addMember(String boardId, User member);

	void removeMember(String boardId, String memberId);

	void show(String boardId);

	void show();

	Board getBoardById(String boardId);
}
