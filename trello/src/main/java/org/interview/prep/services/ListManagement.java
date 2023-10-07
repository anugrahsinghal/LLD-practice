package org.interview.prep.services;

import org.interview.prep.factory.Repository;
import org.interview.prep.models.Card;
import org.interview.prep.models.ProjectList;

public interface ListManagement extends Repository<ProjectList> {

	String create(String boardId, String subProjectName);

	void show(String subProjectId);

	void modifyList(String subProjectId, String attribute, String value);

	boolean addCardToList(String subProjectId, Card card);
}
