package com.interview.prep.coding.blox.models;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Builder
@AllArgsConstructor
public class Contest {

	// autoincremented
	private final Long id;
	private final String name;
	private final Level level;
	private final User creator;
	private final long points;

	@Setter
	private Set<Question> questions;
	private State state;

	public Contest(Long id, String name, Level level, User creator, State state) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.creator = creator;
		this.state = state;
		this.points = basedOnLevel(level);
	}

	private long basedOnLevel(Level level) {
		if (level.equals(Level.LOW)) {
			return 100;
		} else if (level.equals(Level.MEDIUM)) {
			return 200;
		} else {
			return 300;
		}
	}

	public void updateState(State state) {
		this.state = state;
	}
}
