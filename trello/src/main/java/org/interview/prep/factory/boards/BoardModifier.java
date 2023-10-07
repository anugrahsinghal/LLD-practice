package org.interview.prep.factory.boards;

import org.interview.prep.models.Board;

public interface BoardModifier {
	void accept(Board board, String newVal);
}
