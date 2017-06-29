package org.loststone.dotdump;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {

  private final String id;
  private String text;
  private NodeShapes nodeShape;
  private Color color;

  public GraphNode(String id) {
    // todo check that the id is valid.
    this.id = id; 
  }

  public String wrappedId() {
    return "\""+this.id+"\"";
  }

  public GraphNode withText(String text) {
    this.text = text; 
    return this; 
  }

  public GraphNode withShape(NodeShapes nodeShape) {
    this.nodeShape = nodeShape;
    return this;
  }

  public GraphNode withColor(Color color) {
    this.color = color;
    return this;
  }

  private boolean hasAttributes() {
    return (this.nodeShape != null) ||
        (this.text != null) || (this.color != null);
  }

  public String toNodeDefinition() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append('\t');
    stringBuilder.append(wrappedId());
    if (hasAttributes()) {
      List<String> attributes = new ArrayList<>();

      if (text != null) { attributes.add("label=\"" + text+"\"" ); }
      if (nodeShape != null) { attributes.add("shape=" + nodeShape.name() ); }
      if (color != null) { attributes.add("color="+color.name()); }

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
