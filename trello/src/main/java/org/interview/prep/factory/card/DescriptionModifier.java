package org.interview.prep.factory.card;

import org.interview.prep.models.Card;

public class DescriptionModifier implements CardModifier {
	@Override
	public void accept(Card board, String newVal) {
		board.setDescription(newVal);
	}
}
