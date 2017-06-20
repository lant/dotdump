package org.loststone.dotdump;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphNodeTest {

  @Test
  public void testBasicNode() {
    GraphNode node = new GraphNode("id");
    assertEquals("\tid;\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithText() {
    GraphNode node = new GraphNode("id");
    node.withText("this is my text");
    assertEquals("\tid [label=\"this is my text\"];\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithShape() {
    GraphNode node = new GraphNode("id");
    node.withShape(NodeShapes.box);
    assertEquals("\tid [shape=box];\n", node.toNodeDefinition());
  }

  @Test
  public void testNodeWithTextAndShape() {
    GraphNode node = new GraphNode("id");
    node.withText("this is my text");
    node.withShape(NodeShapes.box);
    assertEquals("\tid [label=\"this is my text\", shape=box];\n", node.toNodeDefinition());
  }

}