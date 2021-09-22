package org.interview.prep.factory.card;

public class CardModifierFactory {

	public static CardModifier get(String type) {
		if (type.equals("name")) {
			return new NameModifier();
		} else if (type.equals("description")) {
			return new DescriptionModifier();
		} else if (type.equals("assign")) {
			return new AssignmentModifier();
		}
		return (board, newVal) -> {
		};
	}

}
