package org.interview.prep.factory.list;

public class ListModifierFactory {

	public static ListModifier get(String type) {
		if (type.equals("name")) {
			return new NameModifier();
		}
		return (board, newVal) -> {
		};
	}

}
