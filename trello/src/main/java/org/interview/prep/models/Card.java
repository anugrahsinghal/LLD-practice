package org.interview.prep.models;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class Card {
	private final String id;

	private String name;
	private String description;
	private User assignedUser;
	private Set<String> tags;

	public Card(String name) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.tags = new HashSet<>();
	}

	public Card(String name, String description, User assignedUser, Set<String> tags) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.description = description;
		this.assignedUser = assignedUser;
		this.tags = tags;
	}

	public Card(Card card) {
		this.id = UUID.randomUUID().toString();
		this.name = card.name;
		this.description = card.description;
		this.assignedUser = new User(card.assignedUser);
		this.tags = new HashSet<>(card.tags);
	}

}
