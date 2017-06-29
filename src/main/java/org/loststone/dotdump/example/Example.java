package org.loststone.dotdump.example;

import org.loststone.dotdump.*;

import java.io.File;
import java.io.IOException;

class Example {

  public static void main(String ...args) throws IOException {
    Dot musicGraph = new Dot(GraphType.DIGRAPH, "Some metal bands");
    musicGraph.withComment("Some metal bands to draw a graph");

    GraphNode maiden = new GraphNode("iron-maiden").withText("Iron Maiden").withShape(NodeShapes.box);
    GraphNode sabbath = new GraphNode("b-sabbath").withText("Black Sabbath").withShape(NodeShapes.circle);
    GraphNode acdc = new GraphNode("acdc").withText("AC-DC").withShape(NodeShapes.diamond);
    GraphNode mayhem = new GraphNode("mayhem").withText("Mayhem").withShape(NodeShapes.ellipse);
    GraphNode venom = new GraphNode("venom").withText("Venom").withShape(NodeShapes.house);
    GraphNode nasum = new GraphNode("nasum").withText("Nasum").withShape(NodeShapes.lpromoter);
    GraphNode slayer = new GraphNode("slayer").withText("Slayer").withShape(NodeShapes.box3d);

    musicGraph.withNode(maiden);
    musicGraph.withNode(sabbath);
    musicGraph.withNode(acdc);
    musicGraph.withNode(mayhem);
    musicGraph.withNode(venom);
    musicGraph.withNode(nasum);
    musicGraph.withNode(slayer);


    musicGraph.withRelation(new NodeRelation(acdc, maiden).withLabel("Influenced"));
    musicGraph.withRelation(new NodeRelation(sabbath, maiden).withLabel("Influenced"));
    musicGraph.withRelation(new NodeRelation(slayer, venom).withLabel("Influenced"));
    musicGraph.withRelation(new NodeRelation(venom, mayhem).withLabel("Influenced"));
    musicGraph.withRelation(new NodeRelation(sabbath, slayer).withLabel("Influenced"));
    musicGraph.withRelation(new NodeRelation(slayer, nasum).withLabel("Influenced"));

    musicGraph.writeToFile(new File("music.dot"));
  }
}
