package com.askattest.backendtest.dao.inmemory;

import com.askattest.backendtest.dao.TakerQuestionAnswerDao;
import com.askattest.backendtest.model.TakerQuestionAnswer;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryTakerQuestionAnswerDao implements TakerQuestionAnswerDao {

  private static final List<TakerQuestionAnswer> takerQuestionAnswers =
      Arrays.asList(
          new TakerQuestionAnswer(300, 100, 0),
          new TakerQuestionAnswer(300, 101, 1),
          new TakerQuestionAnswer(300, 102, 0),
          new TakerQuestionAnswer(300, 105, 1),
          new TakerQuestionAnswer(300, 109, 3),
          new TakerQuestionAnswer(301, 100, 1),
          new TakerQuestionAnswer(301, 103, 3),
          new TakerQuestionAnswer(301, 104, 2),
          new TakerQuestionAnswer(301, 106, 0),
          new TakerQuestionAnswer(301, 109, 2),
          new TakerQuestionAnswer(302, 100, 1),
          new TakerQuestionAnswer(302, 103, 3),
          new TakerQuestionAnswer(302, 104, 2),
          new TakerQuestionAnswer(302, 106, 3),
          new TakerQuestionAnswer(303, 100, 2),
          new TakerQuestionAnswer(303, 103, 1));

  @Override
  public Optional<TakerQuestionAnswer> getTakerQuestionAnswerForTakerIdAndQuestionId(int takerId, int questionId) {
    return takerQuestionAnswers
        .stream()
        .filter(tqa -> tqa.getTakerId() == takerId && tqa.getQuestionId() == questionId)
        .findFirst();
  }

  @Override
  public List<TakerQuestionAnswer> getTakerQuestionAnswersForTakerIdAndQuestionIds(
      final int takerId, final List<Integer> questionIds) {
    return takerQuestionAnswers
        .stream()
        .filter(tqa -> tqa.getTakerId() == takerId && questionIds.contains(tqa.getQuestionId()))
        .collect(Collectors.toList());
  }
}
