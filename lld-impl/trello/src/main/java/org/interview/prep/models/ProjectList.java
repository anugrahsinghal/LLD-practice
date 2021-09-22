package org.interview.prep.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
public class ProjectList { // or List

	private final String id;
	@Setter
	private String name;
	private final List<Card> cards;

	public ProjectList(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.cards = new ArrayList<>();
	}


	public ProjectList(String name, java.util.List<Card> cards) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.cards = cards;
	}

	public boolean addCard(Card card) {
		return cards.add(card);
	}

	@Override
	public ProjectList clone() {
		final List<Card> cardsClone = this.cards.stream()
				.map(Card::new)
				.collect(Collectors.toList());

		return new ProjectList(name, cardsClone);
	}


}


