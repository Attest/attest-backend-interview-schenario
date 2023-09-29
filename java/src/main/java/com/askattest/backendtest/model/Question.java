package com.askattest.backendtest.model;

import java.util.List;
import java.util.Optional;

public class Question {
  private final int id;
  private final int surveyId;
  private final String title;
  private final List<String> choices;
  private final Routes routes;
  private final int payingAmountPence;

  public Question(
      int id, int surveyId, String title, List<String> choices, Routes routes, final int payingAmountPence) {
    this.id = id;
    this.surveyId = surveyId;
    this.title = title;
    this.choices = choices;
    this.routes = routes;
    this.payingAmountPence = payingAmountPence;
  }

  public int getId() {
    return id;
  }

  public int getSurveyId() {
    return surveyId;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getChoices() {
    return choices;
  }

  public Optional<Routes> getRoutes() {
    return Optional.ofNullable(routes);
  }

  public int getPayingAmountPence() {
    return payingAmountPence;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Question)) {
      return false;
    }

    Question question = (Question) o;

    if (id != question.id) {
      return false;
    }
    if (surveyId != question.surveyId) {
      return false;
    }
    if (payingAmountPence != question.payingAmountPence) {
      return false;
    }
    if (title != null ? !title.equals(question.title) : question.title != null) {
      return false;
    }
    if (choices != null ? !choices.equals(question.choices) : question.choices != null) {
      return false;
    }
    return routes != null ? routes.equals(question.routes) : question.routes == null;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + surveyId;
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (choices != null ? choices.hashCode() : 0);
    result = 31 * result + (routes != null ? routes.hashCode() : 0);
    result = 31 * result + payingAmountPence;
    return result;
  }

  @Override
  public String toString() {
    return "Question{"
        + "id="
        + id
        + ", surveyId="
        + surveyId
        + ", title='"
        + title
        + '\''
        + ", choices="
        + choices
        + ", routes="
        + routes
        + ", payingAmountPence="
        + payingAmountPence
        + '}';
  }
}
