package com.askattest.backendtest.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.askattest.backendtest.dao.QuestionDao;
import com.askattest.backendtest.dao.SurveyDao;
import com.askattest.backendtest.dao.TakerQuestionAnswerDao;
import com.askattest.backendtest.dao.inmemory.InMemoryQuestionDao;
import com.askattest.backendtest.dao.inmemory.InMemorySurveyDao;
import com.askattest.backendtest.dao.inmemory.InMemoryTakerQuestionAnswerDao;
import com.askattest.backendtest.model.Question;
import com.askattest.backendtest.model.TakerSurveyProgress;
import com.askattest.backendtest.model.TakerSurveyProgressImpl;
import com.askattest.backendtest.service.TakerSurveyProgressService;
import com.askattest.backendtest.service.TakerSurveyProgressServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TakerSurveyProgressServiceImplTest {

    private TakerSurveyProgressService takerSurveyProgressService;
    private QuestionDao questionDao;
    private SurveyDao surveyDao;
    private TakerQuestionAnswerDao takerQuestionAnswerDao;

    @Before
    public void setUp() throws Exception {
        questionDao = Mockito.mock(QuestionDao.class);
        surveyDao = Mockito.mock(SurveyDao.class);
        takerQuestionAnswerDao = Mockito.mock(TakerQuestionAnswerDao.class);

        takerSurveyProgressService = new TakerSurveyProgressServiceImpl(questionDao,surveyDao,takerQuestionAnswerDao);
    }

    @Test
    public void getTakerSurveyProgressForTakerIdAndSurveyIdWrongSurvey() throws Exception {

        Mockito.when(surveyDao.getQuestionIdsInSurvey(anyInt())).thenReturn(Collections.emptyList());

        TakerSurveyProgress progress = takerSurveyProgressService.getTakerSurveyProgressForTakerIdAndSurveyId(0, 0);
        TakerSurveyProgress noProgress = new TakerSurveyProgressImpl(Optional.empty(),0,0,0);
        assertEquals("Expected survey does not exist",noProgress,progress);
    }
    @Test
    public void getTakerSurveyProgressForTakerIdAndSurveyIdNoAnswers() throws Exception {
        Question first = new Question(1,0,"",Collections.emptyList(),null,0);
        Mockito.when(surveyDao.getQuestionIdsInSurvey(anyInt())).thenReturn(List.of(1));
        Mockito.when(surveyDao.getFirstQuestionId(anyInt())).thenReturn(Optional.of(1));
        Mockito.when(questionDao.getQuestion(1)).thenReturn(Optional.of(first));
        Mockito.when(takerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(0, List.of(1))).thenReturn(Collections.emptyList());


        TakerSurveyProgress progress = takerSurveyProgressService.getTakerSurveyProgressForTakerIdAndSurveyId(0, 0);
        TakerSurveyProgress noProgress = new TakerSurveyProgressImpl(Optional.of(first),0,0,0);
        assertEquals("Expected survey does not exist",noProgress,progress);
    }

    @Test
    public void getTakerSurveyProgressForTakerIdAndSurveyIdInMemoryNotCompletedTest() throws Exception {

        TakerSurveyProgressService inMemoryTakerSurveyProgressService =
                new TakerSurveyProgressServiceImpl(
                        new InMemoryQuestionDao(),
                        new InMemorySurveyDao(),
                        new InMemoryTakerQuestionAnswerDao()
                );

        TakerSurveyProgress progress = inMemoryTakerSurveyProgressService.getTakerSurveyProgressForTakerIdAndSurveyId(303, 200);

        assertEquals("Expected survey progress with few questions answered will have correct number answers",2,progress.getNumAnsweredQuestions());
        assertEquals("Expected survey progress with few questions answered will have correct total amount",3,progress.getTotalAmountPaidPence());
        assertEquals("Expected survey progress with few questions answered will have next question",104,progress.getNextQuestion().get().getId());
    }

    @Test
    public void getTakerSurveyProgressForTakerIdAndSurveyIdInMemoryCompletedTest() throws Exception {

        TakerSurveyProgressService inMemoryTakerSurveyProgressService =
                new TakerSurveyProgressServiceImpl(
                        new InMemoryQuestionDao(),
                        new InMemorySurveyDao(),
                        new InMemoryTakerQuestionAnswerDao()
                );

        TakerSurveyProgress progress = inMemoryTakerSurveyProgressService.getTakerSurveyProgressForTakerIdAndSurveyId(300, 200);

        assertEquals("Expected survey progress with all questions answered will have correct number answers",5,progress.getNumAnsweredQuestions());
        assertEquals("Expected survey progress with all questions answered will have correct total amount",29,progress.getTotalAmountPaidPence());
        assertEquals("Expected survey progress with all questions answered will not have next question",Optional.empty(),progress.getNextQuestion());
    }
}
