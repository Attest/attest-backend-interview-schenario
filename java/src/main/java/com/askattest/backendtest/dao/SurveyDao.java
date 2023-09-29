package com.askattest.backendtest.dao;

import java.util.List;

public interface SurveyDao {

  /**
   * Finds the IDs of the questions that are part of the given survey.
   *
   * @param surveyId: the survey ID
   * @return A {@code List} containing the survey's question IDs, or {@code Collection.emptyList()} when the survey is
   *     not found
   */
  List<Integer> getQuestionIdsInSurvey(final int surveyId);
}
