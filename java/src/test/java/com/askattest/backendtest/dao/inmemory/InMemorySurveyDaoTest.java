package com.askattest.backendtest.dao.inmemory;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class InMemorySurveyDaoTest {

  private InMemorySurveyDao inMemorySurveyDao;

  @Before
  public void setUp() throws Exception {
    inMemorySurveyDao = new InMemorySurveyDao();
  }

  @Test
  public void getQuestionIdsInSurveyNegativeNumber() throws Exception {
    assertEquals("Expected survey to not exist", Collections.emptyList(), inMemorySurveyDao.getQuestionIdsInSurvey(-1));
  }

  @Test
  public void getQuestionIdsInSurveyDoesntExist() throws Exception {
    assertEquals(
        "Expected survey to not exist", Collections.emptyList(), inMemorySurveyDao.getQuestionIdsInSurvey(812));
  }

  @Test
  public void getQuestionIdsInSurveySuccess() throws Exception {
    final List<Integer> questionIds = inMemorySurveyDao.getQuestionIdsInSurvey(200);
    assertEquals("Expected ten survey questions", 10, questionIds.size());
    assertEquals(
        "Expected correct survey question IDs",
        Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108, 109),
        questionIds);
  }
}
