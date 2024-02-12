package com.askattest.backendtest.service;

import com.askattest.backendtest.dao.QuestionDao;
import com.askattest.backendtest.dao.SurveyDao;
import com.askattest.backendtest.dao.TakerQuestionAnswerDao;
import com.askattest.backendtest.model.*;

import java.util.List;
import java.util.Optional;

public class TakerSurveyProgressServiceImpl implements TakerSurveyProgressService {


    private final QuestionDao questionDao;
    private final SurveyDao surveyDao;
    private final TakerQuestionAnswerDao takerQuestionAnswerDao;


    public TakerSurveyProgressServiceImpl(QuestionDao questionDao, SurveyDao surveyDao, TakerQuestionAnswerDao takerQuestionAnswerDao) {
        this.questionDao = questionDao;
        this.surveyDao = surveyDao;
        this.takerQuestionAnswerDao = takerQuestionAnswerDao;
    }

    @Override
    public TakerSurveyProgress getTakerSurveyProgressForTakerIdAndSurveyId(final int takerId, final int surveyId) {
        List<Integer> allQuestionIds = surveyDao.getQuestionIdsInSurvey(surveyId);

        if (allQuestionIds.isEmpty()) {
            return new TakerSurveyProgressImpl(Optional.empty(), 0, 0, 0);
        }
        // get all answers, assumption is answers are in taken
        List<TakerQuestionAnswer> answers = takerQuestionAnswerDao.getTakerQuestionAnswersForTakerIdAndQuestionIds(
                takerId, allQuestionIds
        );
        int answeredQuestions = 0;
        int totalPaid = 0;
        // initialize with first question
        int nextQuestionId = surveyDao.getFirstQuestionId(surveyId).get();


        for (TakerQuestionAnswer answer :
                answers) {
            // the assumption: if answer exists - question exists as well
            Question question = questionDao.getQuestion(answer.getQuestionId()).get();
            answeredQuestions++;
            totalPaid += question.getPayingAmountPence();

            nextQuestionId = question.getRoutes().isEmpty() ? 0 : question.getRoutes().get().getNextQuestionGivenAnswer(answer.getAnswer()).get();
        }


        return new TakerSurveyProgressImpl(questionDao.getQuestion(nextQuestionId), answeredQuestions, 0, totalPaid);
    }
}
