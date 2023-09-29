package com.askattest.backendtest.model;

import java.util.Optional;

public interface TakerSurveyProgress {

  /**
   * Get the next question for this survey that should be presented to the taker.
   *
   * @return An {@code Optional} containing the question if there is one, or {@code Optional.empty()} when there are no
   *     more questions that the taker can respond to in this survey
   */
  Optional<Question> getNextQuestion();

  /**
   * Get the number of questions that the taker has answered so far as part of this survey.
   *
   * @return An {@code int} indicating the number of answers
   */
  int getNumAnsweredQuestions();

  /**
   * Get the maximum number of questions available in this survey, considering the answers that have already been given
   * by the taker (if any). This number could change as the taker provides more answers.
   *
   * @return An {@code int} indicating the number of questions
   */
  int getMaxNumQuestions();

  /**
   * Get the amount of money (in pence) earned by the taker for the answers he/she has given so far as part of this
   * survey.
   *
   * @return An {@code int} indicating the number of pence (e.g. 100 = £1.00)
   */
  int getTotalAmountPaidPence();
}
