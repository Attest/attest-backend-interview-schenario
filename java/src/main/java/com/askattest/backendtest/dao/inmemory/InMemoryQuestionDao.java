package com.askattest.backendtest.dao.inmemory;

import com.askattest.backendtest.dao.QuestionDao;
import com.askattest.backendtest.model.Question;
import com.askattest.backendtest.model.Routes;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryQuestionDao implements QuestionDao {

  private static final List<Question> questions =
      Arrays.asList(
          new Question(
              100,
              200,
              "What do you expect to happen to the price of fuel in the UK in the next 6 months?",
              Arrays.asList("Much lower", "A little lower", "Stay about the same", "A little higher", "Much higher"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 101);
                      put(1, 103);
                      put(2, 103);
                      put(3, 103);
                      put(4, 103);
                    }
                  }),
              0),
          new Question(
              101,
              200,
              "Which toothpaste brand do you trust the most?",
              Arrays.asList("Colgate", "Aquafresh", "Oral-B", "Sensodyne", "Pearl Drops", "Supermarket own brand"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 102);
                      put(1, 102);
                      put(2, 102);
                      put(3, 102);
                      put(4, 102);
                      put(5, 102);
                    }
                  }),
              7),
          new Question(
              102,
              200,
              "What cash offer would lead you to switch your primary bank account?",
              Arrays.asList("Under £100", "£100", "£150", "£200", "Over £250"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 105);
                      put(1, 105);
                      put(2, 105);
                      put(3, 105);
                      put(4, 105);
                    }
                  }),
              8),
          new Question(
              103,
              200,
              "What is more important to you when buying flights?",
              Arrays.asList(
                  "Departure & arrival time (significantly)",
                  "Departure & arrival time (slightly)",
                  "Airline (slightly)",
                  "Airline (significantly)"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 104);
                      put(1, 104);
                      put(2, 104);
                      put(3, 104);
                    }
                  }),
              3),
          new Question(
              104,
              200,
              "How likely are you to watch the next England football match live on TV?",
              Arrays.asList("Very unlikely", "Unlikely", "Not sure", "Likely", "Very likely"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 106);
                      put(1, 106);
                      put(2, 106);
                      put(3, 107);
                      put(4, 107);
                    }
                  }),
              5),
          new Question(
              105,
              200,
              "How do you expect fuel prices to change in the next 12 months?",
              Arrays.asList("Much lower", "A little lower", "Stay about the same", "A little higher", "Much higher"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 109);
                      put(1, 109);
                      put(2, 109);
                      put(3, 109);
                      put(4, 109);
                    }
                  }),
              9),
          new Question(
              106,
              200,
              "If you had to choose to vote Green Party or LibDems, who would you vote for?",
              Arrays.asList(
                  "Green Party (definitely)", "Green Party (slightly)", "LibDems (definitely)", "LibDems (slightly)"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 109);
                      put(1, 109);
                      put(2, 109);
                      put(3, 109);
                    }
                  }),
              11),
          new Question(
              107,
              200,
              "Rank these shoe brands by how fashionable they are",
              Arrays.asList("Nike", "Converse", "Puma", "Adidas", "Dunlop", "Reebok"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 108);
                      put(1, 108);
                      put(2, 108);
                      put(3, 108);
                      put(4, 108);
                      put(5, 108);
                    }
                  }),
              13),
          new Question(
              108,
              200,
              "Which type of phone would you consider buying the near future?",
              Arrays.asList("iPhone", "Android", "Windows Phone", "Blackberry", "FireFox OS"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 109);
                      put(1, 109);
                      put(2, 109);
                      put(3, 109);
                      put(4, 109);
                    }
                  }),
              5),
          new Question(
              109,
              200,
              "When do you most often eat cereal for breakfast?",
              Arrays.asList(
                  "Every day of the week",
                  "Some weekdays and sometimes weekends",
                  "Most days during the working week",
                  "Only on weekends",
                  "Maybe once or twice",
                  "Never"),
              null,
              5),
          new Question(
              110,
              201,
              "When you buy high-value electronics (such as a TV or PC), do you need to see them in person first?",
              Arrays.asList("Always", "Sometimes", "Never"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 111);
                      put(1, 111);
                      put(2, 111);
                    }
                  }),
              0),
          new Question(
              111,
              201,
              "How have NHS GP waiting times changed over the last year?",
              Arrays.asList(
                  "Significantly longer", "A little longer", "Unchanged", "A little shorter", "Significantly shorter"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 112);
                      put(1, 112);
                      put(2, 112);
                      put(3, 112);
                      put(4, 112);
                    }
                  }),
              0),
          new Question(
              112,
              201,
              "Are you answering these questions truthly?",
              Arrays.asList("Never", "No", "Sometimes", "Always"),
              new Routes(
                  new LinkedHashMap<Integer, Integer>() {
                    {
                      put(0, 113);
                      put(1, 113);
                      put(2, 113);
                      put(3, 113);
                    }
                  }),
              7),
          new Question(
              113,
              201,
              "Which of these are important to you when buying flights?",
              Arrays.asList(
                  "Departure & arrival time",
                  "Cost",
                  "Which airport",
                  "Duration of flight",
                  "Airline history",
                  "Word of mouth recommendations"),
              null,
              8));

  @Override
  public Optional<Question> getQuestion(int questionId) {
    return questions.stream().filter(q -> q.getId() == questionId).findFirst();
  }

  @Override
  public List<Question> getQuestions(final List<Integer> questionIds) {
    return questions.stream().filter(q -> questionIds.contains(q.getId())).collect(Collectors.toList());
  }
}
