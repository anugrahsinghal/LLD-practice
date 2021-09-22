package org.interview.prep.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.interview.prep.factory.boards.BoardModifierFactory;
import org.interview.prep.models.Board;
import org.interview.prep.models.User;

public class ProjectManagementImpl implements ProjectManagement {

	Map<String, Board> boardMap = new HashMap<>();

	@Override
	public Board getById(String id) {
		return getBoardById(id);
	}

	@Override
	public Board getBoardById(String boardId) {
		return getBoard(boardId);
	}

	@Override
	public boolean create(Board board) {
		return boardMap.put(board.getId(), board) != null;
	}

	@Override
	public Collection<Board> getAll() {
		return boardMap.values();
	}

	@Override
	public void delete(Board board) {
		boardMap.values().remove(board);
	}

	@Override
	public Board modify(String id, String modifyReq, String newValue) {
		final Board board = getBoard(id);

		BoardModifierFactory.get(modifyReq).accept(board, newValue);

		return board;
	}

	@Override
	public String createBoard(String name) {
		final Board board = new Board(name);
		create(board);
		return board.getId();
	}

	@Override
	public void show() {
		final Collection<Board> values = boardMap.values();
		if (values.isEmpty()) {
			System.out.println("No Boards");
		} else {
			System.out.println(values);
		}
	}

	@Override
	public void deleteBoard(String boardId) {
		boardMap.remove(boardId);
	}

	@Override
	public String addMember(String boardId, User member) {
		final Board board = getBoard(boardId);
		board.addMember(member);
		return member.getUserId();
	}

	@Override
	public void removeMember(String boardId, String memberId) {
		final Board board = getBoard(boardId);
		board.removeMember(memberId);
	}

	@Override
	public void show(String boardId) {
		System.out.println(getBoard(boardId));
	}

	private Board getBoard(String boardId) {
		final Board board = boardMap.get(boardId);
		if (board == null) {
			throw new IllegalArgumentException(boardId);
		}
		return board;
	}
}

