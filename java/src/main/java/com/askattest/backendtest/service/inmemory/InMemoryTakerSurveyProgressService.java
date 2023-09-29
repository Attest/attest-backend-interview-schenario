package com.askattest.backendtest.service.inmemory;

import com.askattest.backendtest.dao.QuestionDao;
import com.askattest.backendtest.dao.SurveyDao;
import com.askattest.backendtest.dao.TakerQuestionAnswerDao;
import com.askattest.backendtest.dao.inmemory.InMemoryQuestionDao;
import com.askattest.backendtest.dao.inmemory.InMemorySurveyDao;
import com.askattest.backendtest.dao.inmemory.InMemoryTakerQuestionAnswerDao;
import com.askattest.backendtest.model.TakerSurveyProgress;
import com.askattest.backendtest.service.TakerSurveyProgressService;

public class InMemoryTakerSurveyProgressService implements TakerSurveyProgressService {

  private final QuestionDao questionDao;
  private final SurveyDao surveyDao;
  private final TakerQuestionAnswerDao takerQuestionAnswerDao;

  public InMemoryTakerSurveyProgressService() {
    questionDao = new InMemoryQuestionDao();
    surveyDao = new InMemorySurveyDao();
    takerQuestionAnswerDao = new InMemoryTakerQuestionAnswerDao();
  }

  @Override
  public TakerSurveyProgress getTakerSurveyProgressForTakerIdAndSurveyId(final int takerId, final int surveyId) {
    // TODO
    throw new UnsupportedOperationException("Implement me!");
  }
}
