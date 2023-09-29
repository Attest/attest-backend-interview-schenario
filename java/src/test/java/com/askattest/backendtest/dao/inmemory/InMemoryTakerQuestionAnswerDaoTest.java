package com.askattest.backendtest.dao.inmemory;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.askattest.backendtest.model.TakerQuestionAnswer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;

public class InMemoryTakerQuestionAnswerDaoTest {

  private InMemoryTakerQuestionAnswerDao inMemoryTakerQuestionAnswerDao;

  @Before
  public void setUp() throws Exception {
    inMemoryTakerQuestionAnswerDao = new InMemoryTakerQuestionAnswerDao();
  }

  @Test
  public void getTakerQuestionAnswerQuestionNegativeNumber() throws Exception {
    assertEquals(
        "Expected taker question answer to not exist",
        Optional.empty(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswerForTakerIdAndQuestionId(300, -1));
  }

  @Test
  public void getTakerQuestionAnswerQuestionDoesntExist() throws Exception {
    assertEquals(
        "Expected taker question answer to not exist",
        Optional.empty(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswerForTakerIdAndQuestionId(300, 812));
  }

  @Test
  public void getTakerQuestionAnswerTakerNegativeNumber() throws Exception {
    assertEquals(
        "Expected taker question answer to not exist",
        Optional.empty(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswerForTakerIdAndQuestionId(-1, 100));
  }

  @Test
  public void getTakerQuestionAnswerTakerDoesntExist() throws Exception {
    assertEquals(
        "Expected taker question answer to not exist",
        Optional.empty(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswerForTakerIdAndQuestionId(812, 100));
  }

  @Test
  public void getTakerQuestionAnswerSuccess() throws Exception {
    final Optional<TakerQuestionAnswer> optionalTakerQuestionAnswer =
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswerForTakerIdAndQuestionId(300, 100);
    assertTrue("Expected taker question answer to exist", optionalTakerQuestionAnswer.isPresent());
    assertEquals("Expected correct taker ID", 300, optionalTakerQuestionAnswer.get().getTakerId());
    assertEquals("Expected correct question ID", 100, optionalTakerQuestionAnswer.get().getQuestionId());
  }

  @Test
  public void getTakerQuestionAnswersQuestionsNegativeNumbers() throws Exception {
    assertEquals(
        "Expected no taker question answers to not exist",
        Collections.emptyList(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(300, Arrays.asList(-2, -1)));
  }

  @Test
  public void getTakerQuestionAnswersQuestionsDoesntExists() throws Exception {
    assertEquals(
        "Expected no taker question answers to not exist",
        Collections.emptyList(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(
            300, Collections.singletonList(812)));
  }

  @Test
  public void getTakerQuestionAnswersTakerNegativeNumber() throws Exception {
    assertEquals(
        "Expected no taker question answers to not exist",
        Collections.emptyList(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(
            -1, Arrays.asList(-1, 100, 101)));
  }

  @Test
  public void getTakerQuestionAnswersTakerDoesntExists() throws Exception {
    assertEquals(
        "Expected no taker question answers to not exist",
        Collections.emptyList(),
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(
            812, Arrays.asList(-1, 100, 101)));
  }

  @Test
  public void getTakerQuestionAnswersSuccess() throws Exception {
    final List<TakerQuestionAnswer> takerQuestionAnswerList =
        inMemoryTakerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(
            300, Arrays.asList(-1, 100, 101));
    assertEquals("Expected two taker question answers", 2, takerQuestionAnswerList.size());
    assertEquals(
        "Expected correct taker ID for first taker question answer", 300, takerQuestionAnswerList.get(0).getTakerId());
    assertEquals(
        "Expected correct question ID for first taker question answer",
        100,
        takerQuestionAnswerList.get(0).getQuestionId());
    assertEquals(
        "Expected correct taker ID for first taker question answer", 300, takerQuestionAnswerList.get(1).getTakerId());
    assertEquals(
        "Expected correct question ID for first taker question answer",
        101,
        takerQuestionAnswerList.get(1).getQuestionId());
  }
}
