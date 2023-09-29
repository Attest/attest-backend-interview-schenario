package com.askattest.backendtest.dao;

import com.askattest.backendtest.model.TakerQuestionAnswer;
import java.util.List;
import java.util.Optional;

public interface TakerQuestionAnswerDao {

  /**
   * Finds a taker question answer given a taker ID and a question ID.
   *
   * @param takerId: the taker ID
   * @param questionId: the question ID
   * @return An {@code Optional} containing the taker question answer, or {@code Optional.empty()} when the taker
   *     question answer is not found
   */
  Optional<TakerQuestionAnswer> getTakerQuestionAnswerForTakerIdAndQuestionId(final int takerId, final int questionId);

  /**
   * Finds taker question answers given a taker ID and a list of question IDs. The taker question answers are returned
   * in the order that they are answered by the taker, i.e. the first returned taker question answer is the oldest and
   * the last is the most recent.
   *
   * @param takerId: the taker ID
   * @param questionIds: the question IDs
   * @return A {@code List} containing the found taker question answers, or {@code Collection.emptyList()} when no taker
   *     question answers are found
   */
  List<TakerQuestionAnswer> getTakerQuestionAnswersForTakerIdAndQuestionIds(
      final int takerId, final List<Integer> questionIds);
}
