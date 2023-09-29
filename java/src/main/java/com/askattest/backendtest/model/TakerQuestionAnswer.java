package com.askattest.backendtest.model;

public class TakerQuestionAnswer {

  private final int takerId;
  private final int questionId;
  private final int answer;

  public TakerQuestionAnswer(int takerId, int questionId, int answer) {
    this.takerId = takerId;
    this.questionId = questionId;
    this.answer = answer;
  }

  public int getTakerId() {
    return takerId;
  }

  public int getQuestionId() {
    return questionId;
  }

  public int getAnswer() {
    return answer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof TakerQuestionAnswer)) {
      return false;
    }

    TakerQuestionAnswer that = (TakerQuestionAnswer) o;

    if (takerId != that.takerId) {
      return false;
    }
    if (questionId != that.questionId) {
      return false;
    }
    return answer == that.answer;
  }

  @Override
  public int hashCode() {
    int result = takerId;
    result = 31 * result + questionId;
    result = 31 * result + answer;
    return result;
  }

  @Override
  public String toString() {
    return "TakerQuestionAnswer{" +
        "takerId=" + takerId +
        ", questionId=" + questionId +
        ", answer=" + answer +
        '}';
  }
}
