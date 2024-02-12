package com.askattest.backendtest.model;

import java.util.Objects;
import java.util.Optional;

    public class TakerSurveyProgressImpl implements TakerSurveyProgress {

        private final Optional<Question> nextQuestion;
        private final int answeredQuestions;
        private final int maxNumQuestions;
        private final int totalAmountPaid; // Assumption the amount is in pence

        public TakerSurveyProgressImpl(Optional<Question> nextQuestion, int answeredQuestions, int maxNumQuestions, int totalAmountPaid) {
            this.nextQuestion = nextQuestion;
            this.answeredQuestions = answeredQuestions;
            this.maxNumQuestions = maxNumQuestions;
            this.totalAmountPaid = totalAmountPaid;
        }

        @Override
        public Optional<Question> getNextQuestion() {
            return nextQuestion;
        }

        @Override
        public int getNumAnsweredQuestions() {
            return answeredQuestions;
        }

        @Override
        public int getMaxNumQuestions() {
            return maxNumQuestions;
        }

        @Override
        public int getTotalAmountPaidPence() {
            return totalAmountPaid;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            TakerSurveyProgressImpl that = (TakerSurveyProgressImpl) o;

            if (answeredQuestions != that.answeredQuestions) return false;
            if (maxNumQuestions != that.maxNumQuestions) return false;
            if (totalAmountPaid != that.totalAmountPaid) return false;
            return Objects.equals(nextQuestion, that.nextQuestion);
        }

        @Override
        public int hashCode() {
            int result = nextQuestion.isPresent() ? nextQuestion.hashCode() : 0;
            result = 31 * result + answeredQuestions;
            result = 31 * result + maxNumQuestions;
            result = 31 * result + totalAmountPaid;
            return result;
        }
    }

