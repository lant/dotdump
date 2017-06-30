package com.github.lant.dotdump;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphNodeTest {

  @Test
  public void testBasicNode() {
    GraphNode node = new GraphNode("id");
    assertEquals("\t\"id\";\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithText() {
    GraphNode node = new GraphNode("id");
    node.withText("this is my text");
    assertEquals("\t\"id\" [label=\"this is my text\"];\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithShape() {
    GraphNode node = new GraphNode("id");
    node.withShape(NodeShapes.box);
    assertEquals("\t\"id\" [shape=box];\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithTextAndShape() {
    GraphNode node = new GraphNode("id");
    node.withText("this is my text");
    node.withShape(NodeShapes.box);
    assertEquals("\t\"id\" [label=\"this is my text\", shape=box];\n", node.toNodeDefinition());
  }

}