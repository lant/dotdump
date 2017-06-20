package org.loststone.dotdump;

import java.util.ArrayList;
import java.util.List;

public class NodeRelation {
  private final GraphNode a; 
  private final GraphNode b;
  private GraphType type;

  private String text; 

  public NodeRelation(GraphNode a, GraphNode b) {
    this.a = a; 
    this.b = b;
  }

  public NodeRelation withType(GraphType type) {
    this.type = type;
    return this;
  }

  public NodeRelation withLabel(String text) {
    this.text = text;  
    return this; 
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\t');
    stringBuilder.append(a.getId());
    stringBuilder.append(" ");
    stringBuilder.append(type.getArrow());
    stringBuilder.append(" ");
    stringBuilder.append(b.getId());

    if (hasAttributes()) {
      stringBuilder.append("[");
      List<String> attributes = new ArrayList<>();
      if (text != null) { attributes.add("label=\"" + text + "\"");  }
      int attIdx = 0;
      for (String attribute : attributes) {
        stringBuilder.append(attribute);
        attIdx++;
        if (attIdx < attributes.size()) {
          stringBuilder.append(", ");
        }
      }
      stringBuilder.append("]");
    }

    stringBuilder.append(";\n");

    return stringBuilder.toString();
  }

  private boolean hasAttributes() {
    return (this.text != null);
  }
}
