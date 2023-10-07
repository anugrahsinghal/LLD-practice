package com.interview.prep.coding.blox.models;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
@Builder
public class Question {

	private final Long id;
	private final Level level;
	private final String statement;

//	public Question(Level level, String statement) {
//
//	}
}
