package org.interview.prep.services;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.interview.prep.factory.card.CardModifierFactory;
import org.interview.prep.models.Card;
import org.interview.prep.models.ProjectList;

public class CardManagementServiceImpl implements CardManagementService {

	private final ListManagement listService;

	public CardManagementServiceImpl(ListManagement listService) {
		this.listService = listService;
	}

	@Override
	public String createCard(String subProjectId, String userEmailId) {

		final Card card = new Card(userEmailId);
		boolean added = listService.addCardToList(subProjectId, card);
		if (added) {
			System.out.println("CARD CREATED " + card.getId());
		}

		return card.getId();
	}

	@Override
	public void modifyCard(String cardId, String property, String value) {
		CardModifierFactory.get(property).accept(getById(cardId), value);
	}

	@Override
	public void assignCard(String cardId, String userEmailId) {
		modifyCard(cardId, "assign", userEmailId);
	}

	@Override
	public void show(String cardId) {
		System.out.println(getById(cardId));
	}

	@Override
	public void move(String cardId, String newListId) {
		final Card oldCard = getById(cardId);
		delete(oldCard);
		listService.addCardToList(newListId, oldCard);
	}

	@Override
	public void unassign(String cardId) {
		modifyCard(cardId, "assign", null);
	}

	@Override
	public Card getById(String id) {
		final Optional<Card> any = getAllCardAsStream()
				.filter(card -> card.getId().equals(id))
				.findAny();
		return any.orElse(null);
	}

	@Override
	public Collection<Card> getAll() {
		return getAllCardAsStream().collect(Collectors.toList());
	}

	private Stream<Card> getAllCardAsStream() {
		return listService.getAll()
				.stream()
				.flatMap(list -> list.getCards().stream());
	}

	@Override
	public void delete(Card card) {
		for (ProjectList projectList : listService.getAll()) {
			projectList.getCards().removeIf(card1 -> card1.equals(card));
		}
	}

}
