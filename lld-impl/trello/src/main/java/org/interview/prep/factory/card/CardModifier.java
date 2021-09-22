package org.interview.prep.factory.card;

import org.interview.prep.models.Card;

public interface CardModifier {
	void accept(Card board, String newVal);
}
