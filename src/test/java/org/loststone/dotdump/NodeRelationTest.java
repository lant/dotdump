package org.loststone.dotdump;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NodeRelationTest {

  private final GraphNode a = new GraphNode("a");
  private final GraphNode b = new GraphNode("b");

  @Test
  public void testBasicGraphRelation() {
    NodeRelation nodeRelation = new NodeRelation(a, b).withType(GraphType.GRAPH);
    assertEquals("\ta -- b;\n", nodeRelation.toString());
  }

  @Test
  public void testBasicDigraphRelation() {
    NodeRelation nodeRelation = new NodeRelation(a, b).withType(GraphType.DIGRAPH);
    assertEquals("\ta --> b;\n", nodeRelation.toString());
  }

}