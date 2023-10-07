package org.interview.prep.factory.boards;

import org.interview.prep.models.Board;

public class NameModifier implements BoardModifier {
	@Override
	public void accept(Board board, String newVal) {
		board.setName(newVal);
	}
}
