package org.interview.prep.factory.card;

import org.interview.prep.models.Card;
import org.interview.prep.models.User;

public class AssignmentModifier implements CardModifier {
	@Override
	public void accept(Card board, String newVal) {
		// TODO modify to use UserManagement type service
		// TODO check user is valid for board, i.e is member of board
		board.setAssignedUser(new User(newVal));
	}
}
