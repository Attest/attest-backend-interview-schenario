package com.askattest.backendtest.dao;

import java.util.List;
import java.util.Optional;

public interface SurveyDao {

  /**
   * Finds the IDs of the questions that are part of the given survey.
   *
   * @param surveyId: the survey ID
   * @return A {@code List} containing the survey's question IDs, or {@code Collection.emptyList()} when the survey is
   *     not found
   */
  List<Integer> getQuestionIdsInSurvey(final int surveyId);

  /**
   * Returns the ID of the first question of the given survey.
   *
   * @param surveyId: the survey ID
   * @return A {@code Integer} representing first survey's question ID, or {@code Optional.empty()} when the survey is
   *     not found or there are no questions in survey
   */
  Optional<Integer> getFirstQuestionId(final int surveyId);
}
