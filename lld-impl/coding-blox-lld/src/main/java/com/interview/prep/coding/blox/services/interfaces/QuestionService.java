package com.interview.prep.coding.blox.services.interfaces;

import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.Question;
import java.util.Set;

public interface QuestionService {

	String createQuestion(Level level, String statement);

	Set<Question> listQuestions(Level level);

	Set<Question> listQuestions();

	Set<Question> getRandomSet(Level level);

}
