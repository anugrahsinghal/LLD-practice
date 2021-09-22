package org.interview.prep.factory.boards;

import org.interview.prep.models.Board;
import org.interview.prep.models.Privacy;

public class PrivacyModifier implements BoardModifier {
	@Override
	public void accept(Board board, String newVal) {
		board.setPrivacy(Privacy.valueOf(newVal));
	}
}
