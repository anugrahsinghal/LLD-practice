package org.interview.prep.factory.list;

import org.interview.prep.models.ProjectList;

public class NameModifier implements ListModifier {
	@Override
	public void accept(ProjectList board, String newVal) {
		board.setName(newVal);
	}
}
