package org.interview.prep.factory.boards;

public class BoardModifierFactory {

	public static BoardModifier get(String type) {
		if (type.equals("name")) {
			return new NameModifier();
		}
		return (board, newVal) -> {
		};
	}

}
