package com.interview.prep.coding.blox.services.interfaces;

import com.interview.prep.coding.blox.models.Level;
import com.interview.prep.coding.blox.models.Question;
import java.util.Map;
import java.util.Set;

public interface QuestionGeneratorFactory {

	Set<Question> getQuestions(Level level, Map<Level, Set<Question>> q);

}
