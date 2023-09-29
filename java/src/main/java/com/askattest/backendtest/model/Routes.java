package com.askattest.backendtest.model;

import java.util.LinkedHashMap;
import java.util.Optional;

public class Routes {

  private final LinkedHashMap<Integer, Integer> routes;

  public Routes(final LinkedHashMap<Integer, Integer> routes) {
    this.routes = routes;
  }

  public Optional<Integer> getNextQuestionGivenAnswer(final int answer) {
    return Optional.ofNullable(routes.get(answer));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Routes)) {
      return false;
    }

    Routes routes1 = (Routes) o;

    return routes != null ? routes.equals(routes1.routes) : routes1.routes == null;
  }

  @Override
  public int hashCode() {
    return routes != null ? routes.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Routes{" +
        "routes=" + routes +
        '}';
  }
}
