package org.loststone.dotdump;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

  private final String id;
  private String text;
  private NodeShapes nodeShape;

  public GraphNode(String id) {
    // todo check that the id is valid.
    this.id = id; 
  }

  public String getId() {
    return this.id;
  }

  public GraphNode withText(String text) {
    this.text = text; 
    return this; 
  }

  public GraphNode withShape(NodeShapes nodeShape) {
    this.nodeShape = nodeShape;
    return this;
  }

  private boolean hasAttributes() {
    return (this.nodeShape != null) ||
        (this.text != null);
  }

  public String toNodeDefinition() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\t');
    stringBuilder.append(id);
    if (hasAttributes()) {
      List<String> attributes = new ArrayList<>();

      if (text != null) { attributes.add("label=\"" + text+"\"" ); }
      if (nodeShape != null) { attributes.add("shape=" + nodeShape.name() ); }

      stringBuilder.append(" [");
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
}
