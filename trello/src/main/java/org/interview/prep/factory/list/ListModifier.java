package org.interview.prep.factory.list;

import org.interview.prep.models.ProjectList;

public interface ListModifier {
	void accept(ProjectList board, String newVal);
}
