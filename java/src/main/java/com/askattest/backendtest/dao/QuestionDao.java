package com.askattest.backendtest.dao;

import com.askattest.backendtest.model.Question;
import java.util.List;
import java.util.Optional;

public interface QuestionDao {

  /**
   * Finds a question given a question ID.
   *
   * @param questionId: the question ID
   * @return An {@code Optional} containing the question, or {@code Optional.empty()} when the question is not found
   */
  Optional<Question> getQuestion(final int questionId);

  /**
   * Finds questions given a list of question IDs
   *
   * @param questionIds: the question IDs
   * @return A {@code List} containing the found questions, or {@code Collection.emptyList()} when no questions are
   *     found
   */
  List<Question> getQuestions(final List<Integer> questionIds);
}
