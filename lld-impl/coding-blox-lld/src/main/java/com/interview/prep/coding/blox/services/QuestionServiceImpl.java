package com.interview.prep.coding.blox.services;

import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.Question;
import com.interview.prep.coding.blox.services.interfaces.QuestionService;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import lombok.Getter;

@Getter
public class QuestionServiceImpl implements QuestionService {

	// just for easier access
	// when using a DB we will just have ste of questions
	private final Map<Level, Set<Question>> questions;

	public QuestionServiceImpl(Map<Level, Set<Question>> questions) {
		this.questions = questions;
		for (Level value : Level.values()) {
			questions.put(value, new HashSet<>());
		}
	}

	@Override
	public String createQuestion(Level level, String statement) {
		questions.get(level).add(
				Question.builder()
						.id(getQuestionId())
						.level(level)
						.statement(statement)
						.build()
		);

		return "DONE";
	}

	@Override
	public Set<Question> listQuestions(Level level) {
		if (level == null) {
			throw new IllegalArgumentException("INVALID LEVEL");
		}
		return questions.get(level);
	}

	@Override
	public Set<Question> listQuestions() {
		// TODO modify to use streams
		final Collection<Set<Question>> values = questions.values();
		Set<Question> res = new HashSet<>();
		for (Set<Question> value : values) {
			res.addAll(value);
		}
		return res;
	}

	@Override
	public Set<Question> getRandomSet(Level level) {
		// TODO MODIFY FOR RANDOM SET
		return questions.get(level);
	}

	private long getQuestionId() {
		return questions.values()
				       .stream()
				       .mapToLong(Collection::size)
				       .sum() + 1;
	}


}
