package com.github.lant.dotdump;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Main class to interact with the file format.
 */
public class Dot {

  private final Queue<GraphNode> nodes;
  private final Queue<NodeRelation> relations;

  private final GraphType type;
  private final String name;

  private String comment; 
  
  /**
   * Create a dot file specifying the graph type (graph / digraph)
   * and its name.
   */
  public Dot(GraphType graphType, String name) {
    this.type = graphType;
    this.name = name;
    nodes = new ConcurrentLinkedQueue<>();
    relations = new ConcurrentLinkedQueue<>();
  } 
  
  /**
   * Add a node into the dot file. 
   * - Does not do any sanity checks. 
   **/
  public Dot withNode(GraphNode node) {
    nodes.add(node); 
    return this;  
  }

  /**
   * Add a relation between two nodes. 
   * - Does not do any sanity checks. 
   **/
  public Dot withRelation(NodeRelation relation) {
    relation.withType(this.type);
    relations.add(relation);
    return this; 
  }

  /**
   * Add a top level comment into the dot file. 
   * Useful if you want to explain what the graph is about. 
   **/
  public Dot withComment(String comment) {
    this.comment = comment;
    return this;
  }

  private void build(Appendable container) throws IOException {
    header(container);
    if (comment != null) { explain(container); }

    defineNodes(nodes, container);
    writeRelations(relations, container);

    footnote(container);
  }

  private void writeRelations(Queue<NodeRelation> relations, Appendable container) throws IOException {
    for (NodeRelation relation : relations) {
      container.append(relation.toString());
    }
  }

  private void defineNodes(Queue<GraphNode> nodes, Appendable container) throws IOException {
     for (GraphNode node : nodes) {
       container.append(node.toNodeDefinition());
     }
  }

  private void explain(Appendable container) throws IOException {
     container.append(String.format("# %s \n", comment));
  }

  private void header(Appendable container) throws IOException {
      container.append(String.format("%s \"%s\" {\n", type.toString(), name));
  }

  private void footnote(Appendable container) throws IOException {
    container.append("}\n");
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    try {
      build(sb);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    return sb.toString();
  }

  /**
   * Writes the .dot formatted output into the specified file.
   * @param outputFile
   * @throws IOException
   */
  public void writeToFile(File outputFile) throws IOException {
    FileWriter fw = new FileWriter(outputFile); 
    build(fw); 
    fw.close(); 
  }

  public int getNodesSize() {
    return this.nodes.size();
  }

  public int getRelationsSize() {
    return this.relations.size();
  }
}
