package org.interview.prep.factory.card;

import org.interview.prep.models.Card;

public class NameModifier implements CardModifier {
	@Override
	public void accept(Card board, String newVal) {
		board.setName(newVal);
	}
}
