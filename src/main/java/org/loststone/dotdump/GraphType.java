package org.loststone.dotdump;

public enum GraphType {
  DIGRAPH("-->"), GRAPH("--");
  private String arrow;

  GraphType(String arrow) {
    this.arrow = arrow;
  }

  public String getArrow() {
    return arrow;
  }
}
