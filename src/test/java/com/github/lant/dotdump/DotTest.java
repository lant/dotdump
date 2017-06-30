package com.github.lant.dotdump;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DotTest {

  private final GraphNode a = new GraphNode(("a"));
  private final GraphNode b = new GraphNode(("b"));

  @Test
  public void testEmptyDot() {
    Dot dot = new Dot(GraphType.GRAPH, "name");
    assertEquals("GRAPH \"name\" {\n}\n", dot.toString());
  }

  @Test
  public void testTwoNodesDot_noRelations() {
    Dot dot = new Dot(GraphType.GRAPH, "name");
    dot.withNode(a);
    dot.withNode(b);
    assertEquals("GRAPH \"name\" {\n\t\"a\";\n\t\"b\";\n}\n", dot.toString());
  }

  @Test
  public void testTwoNodesDot_GraphRelations() {
    Dot dot = new Dot(GraphType.GRAPH, "name");
    dot.withNode(a);
    dot.withNode(b);
    dot.withRelation(new NodeRelation(a,b));
    assertEquals("GRAPH \"name\" {\n\t\"a\";\n\t\"b\";\n\t\"a\" -- \"b\";\n}\n", dot.toString());
  }

  @Test
  public void testTwoNodesDot_DigraphRelations() {
    Dot dot = new Dot(GraphType.DIGRAPH, "name");
    dot.withNode(a);
    dot.withNode(b);
    dot.withRelation(new NodeRelation(a,b));
    assertEquals("DIGRAPH \"name\" {\n\t\"a\";\n\t\"b\";\n\t\"a\" -> \"b\";\n}\n", dot.toString());
  }

  @Test
  public void testTwoNodesDot_GraphRelationsWithComment() {
    Dot dot = new Dot(GraphType.GRAPH, "name");
    dot.withNode(a);
    dot.withNode(b);
    dot.withRelation(new NodeRelation(a,b));
    dot.withComment("Explanatory comment");
    assertEquals("GRAPH \"name\" {\n# Explanatory comment \n\t\"a\";\n\t\"b\";\n\t\"a\" -- \"b\";\n}\n", dot.toString());
  }
}