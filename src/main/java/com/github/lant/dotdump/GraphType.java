package com.github.lant.dotdump;

public enum GraphType {
  DIGRAPH("->"), GRAPH("--");
  private final String arrow;

  GraphType(String arrow) {
    this.arrow = arrow;
  }

  public String getArrow() {
    return arrow;
  }
}
