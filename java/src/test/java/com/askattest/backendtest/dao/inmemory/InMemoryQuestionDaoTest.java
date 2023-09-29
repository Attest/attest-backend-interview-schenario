package com.askattest.backendtest.dao.inmemory;

import static org.junit.Assert.*;

import com.askattest.backendtest.model.Question;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class InMemoryQuestionDaoTest {

  private InMemoryQuestionDao inMemoryQuestionDao;

  @Before
  public void setUp() throws Exception {
    inMemoryQuestionDao = new InMemoryQuestionDao();
  }

  @Test
  public void getQuestionNegativeNumber() throws Exception {
    assertEquals("Expected question to not exist", Optional.empty(), inMemoryQuestionDao.getQuestion(-1));
  }

  @Test
  public void getQuestionDoesntExist() throws Exception {
    assertEquals("Expected question to not exist", Optional.empty(), inMemoryQuestionDao.getQuestion(812));
  }

  @Test
  public void getQuestionSuccess() throws Exception {
    final Optional<Question> optionalQuestion = inMemoryQuestionDao.getQuestion(100);
    assertTrue("Expected question to exist", optionalQuestion.isPresent());
    assertEquals("Expected correct question ID", 100, optionalQuestion.get().getId());
  }

  @Test
  public void getQuestionsNegativeNumbers() throws Exception {
    assertEquals(
        "Expected no questions to not exist",
        Collections.emptyList(),
        inMemoryQuestionDao.getQuestions(Arrays.asList(-2, -1)));
  }

  @Test
  public void getQuestionsDoesntExists() throws Exception {
    assertEquals(
        "Expected no questions to not exist",
        Collections.emptyList(),
        inMemoryQuestionDao.getQuestions(Collections.singletonList(812)));
  }

  @Test
  public void getQuestionsSuccess() throws Exception {
    final List<Question> questionList = inMemoryQuestionDao.getQuestions(Arrays.asList(-1, 100, 101));
    assertEquals("Expected two questions", 2, questionList.size());
    assertEquals("Expected correct question ID for first question", 100, questionList.get(0).getId());
    assertEquals("Expected correct question ID for second question", 101, questionList.get(1).getId());
  }
}
