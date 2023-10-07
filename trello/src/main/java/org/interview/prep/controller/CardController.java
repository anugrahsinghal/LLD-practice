package org.interview.prep.controller;

import org.interview.prep.services.CardManagementService;

public class CardController {

	private final CardManagementService cardService;

	public CardController(CardManagementService cardService) {
		this.cardService = cardService;
	}

	public String createCard(String subProjectId, String userEmailId) {
		return cardService.createCard(subProjectId, userEmailId);
	}

	public void modifyCard(String cardId, String property, String value) {
		// todo check
		cardService.modifyCard(cardId, property, value);
	}

	public void assignCard(String subProjectId, String userEmailId) {
		cardService.assignCard(subProjectId, userEmailId);
	}

	public void show(String cardId) {
		cardService.show(cardId);
	}

	public void move(String cardId, String newListId) {
		cardService.move(cardId, newListId);
	}

	public void removeAssignedUser(String cardId) {
		cardService.unassign(cardId);
	}

}
