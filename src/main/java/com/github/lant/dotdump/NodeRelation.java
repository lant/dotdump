package com.github.lant.dotdump;

import java.util.Map;
import java.util.TreeMap;

public class NodeRelation {
  private final AttributeBuilder attributeBuilder = new AttributeBuilder();

  private final GraphNode a; 
  private final GraphNode b;
  private GraphType type;

  private Map<String, String> attributes = new TreeMap<>();

  public NodeRelation(GraphNode a, GraphNode b) {
    this.a = a; 
    this.b = b;
  }

  public NodeRelation withType(GraphType type) {
    this.type = type;
    return this;
  }

  public NodeRelation withLabel(String text) {
    this.attributes.put("label", text);
    return this; 
  }

  public NodeRelation withColor(Color color) {
    this.attributes.put("color", color.name());
    return this;
  }

  public NodeRelation withWeight(int weight) {
    this.attributes.put("weight", String.valueOf(weight));
    return this;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\t');
    stringBuilder.append(a.wrappedId());
    stringBuilder.append(" ");
    stringBuilder.append(type.getArrow());
    stringBuilder.append(" ");
    stringBuilder.append(b.wrappedId());

    stringBuilder.append(attributeBuilder.build(attributes));

    stringBuilder.append(";\n");
    return stringBuilder.toString();
  }
}
