package org.interview.prep.services;

import org.interview.prep.factory.Repository;
import org.interview.prep.models.Card;

public interface CardManagementService extends Repository<Card> {

	String createCard(String subProjectId, String userEmailId);

	void modifyCard(String cardId, String property, String value);

	void assignCard(String subProjectId, String userEmailId);

	void show(String cardId);

	void move(String cardId, String newListId);

	void unassign(String cardId);

}
