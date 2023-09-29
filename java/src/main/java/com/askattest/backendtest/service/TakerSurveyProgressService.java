package com.askattest.backendtest.service;

import com.askattest.backendtest.model.TakerSurveyProgress;

public interface TakerSurveyProgressService {

  TakerSurveyProgress getTakerSurveyProgressForTakerIdAndSurveyId(final int takerId, final int surveyId);
}
