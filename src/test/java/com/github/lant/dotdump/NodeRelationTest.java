package com.github.lant.dotdump;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeRelationTest {

  private final GraphNode a = new GraphNode("a");
  private final GraphNode b = new GraphNode("b");

  @Test
  public void testBasicGraphRelation() {
    NodeRelation nodeRelation = new NodeRelation(a, b)
            .withType(GraphType.GRAPH);
    assertEquals("\t\"a\" -- \"b\";\n",
            nodeRelation.toString());
  }

  @Test
  public void testBasicDigraphRelation() {
    NodeRelation nodeRelation = new NodeRelation(a, b)
            .withType(GraphType.DIGRAPH);
    assertEquals("\t\"a\" -> \"b\";\n",
            nodeRelation.toString());
  }

  @Test
  public void testRelationWithColor() {
    NodeRelation nodeRelation = new NodeRelation(a, b)
            .withType(GraphType.DIGRAPH)
            .withColor(Color.red);
    assertEquals("\t\"a\" -> \"b\" [color=\"red\"];\n",
            nodeRelation.toString());
  }

  @Test
  public void testRelationWithLabel() {
    NodeRelation nodeRelation = new NodeRelation(a, b)
            .withType(GraphType.DIGRAPH)
            .withLabel("test");
    assertEquals("\t\"a\" -> \"b\" [label=\"test\"];\n",
            nodeRelation.toString());
  }

  @Test
  public void testRelationWithColorAndLabel() {
    NodeRelation nodeRelation = new NodeRelation(a, b)
            .withType(GraphType.DIGRAPH)
            .withLabel("test")
            .withColor(Color.black);
    assertEquals("\t\"a\" -> \"b\" [color=\"black\", label=\"test\"];\n",
            nodeRelation.toString());
  }

}