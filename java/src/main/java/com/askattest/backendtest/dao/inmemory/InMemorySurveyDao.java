package com.askattest.backendtest.dao.inmemory;

import com.askattest.backendtest.dao.SurveyDao;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemorySurveyDao implements SurveyDao {

  private final static Map<Integer, List<Integer>> questionIdsBySurveyId = new HashMap<Integer, List<Integer>>() {{
    put(200, Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108, 109));
    put(201, Arrays.asList(110, 111, 112, 113));
  }};

  @Override
  public List<Integer> getQuestionIdsInSurvey(final int surveyId) {
    final List<Integer> questionsIds = questionIdsBySurveyId.get(surveyId);
    if (questionsIds == null) {
      return Collections.emptyList();
    }

    return questionsIds;
  }
}
