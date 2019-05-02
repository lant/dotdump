package com.github.lant.dotdump;

import java.util.Map;
import java.util.TreeMap;

public class GraphNode {
  private final AttributeBuilder attributeBuilder = new AttributeBuilder();
  private Map<String, String> attributes = new TreeMap<>();

  private final String id;

  public GraphNode(String id) {
    // todo check that the id is valid.
    this.id = id; 
  }

  String wrappedId() {
    return "\""+this.id+"\"";
  }

  public GraphNode withText(String text) {
    this.attributes.put("label", text);
    return this;
  }

  public GraphNode withShape(NodeShapes nodeShape) {
    this.attributes.put("shape", nodeShape.name());
    return this;
  }

  public GraphNode withColor(Color color) {
    this.attributes.put("color", color.name());
    return this;
  }

  public String toNodeDefinition() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\t');
    stringBuilder.append(wrappedId());
    stringBuilder.append(attributeBuilder.build(attributes));
    stringBuilder.append(";\n");

    return stringBuilder.toString();
  }
}
