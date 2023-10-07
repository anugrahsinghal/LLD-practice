package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.Question;
import com.interview.prep.coding.blox.services.interfaces.QuestionGeneratorFactory;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionGeneratorFactoryImpl implements QuestionGeneratorFactory {

	public static final int MAX_QUESTIONS = 3;

	// TODO will take in algo to generate the list of question based on difficulty

	@Override
	public Set<Question> getQuestions(Level level, Map<Level, Set<Question>> q) {
		// TODO MAKE IT BETTER TO USE RANDOMIZE
		return q.get(level).stream()
				.limit(MAX_QUESTIONS)
				.collect(Collectors.toSet());
	}
}
