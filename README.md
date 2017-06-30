# DotDump, a JVM .dot file library. 

DotDump aims to be a very simple *dot* graph file format output for the JVM. 

This is **not** a graph library, it just writes your graph into *dot* format. 

You can find more info about the *dot* format at [Graphviz web](http://www.graphviz.org)


[![Build Status](https://travis-ci.org/lant/dotdump.svg?branch=master)](https://travis-ci.org/lant/dotdump)

# Examples

A simple music chart: 

```java
import com.github.lant.dotdump.*;

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

```

That will generate this `dot` file: 

```
DIGRAPH "Some metal bands" {
# Some metal bands to draw a graph
	"iron-maiden" [label="Iron Maiden", shape=box];
	"b-sabbath" [label="Black Sabbath", shape=circle];
	"acdc" [label="AC-DC", shape=diamond];
	"mayhem" [label="Mayhem", shape=ellipse];
	"venom" [label="Venom", shape=house];
	"nasum" [label="Nasum", shape=lpromoter];
	"slayer" [label="Slayer", shape=box3d];
	"acdc" -> "iron-maiden"[label="Influenced"];
	"b-sabbath" -> "iron-maiden"[label="Influenced"];
	"slayer" -> "venom"[label="Influenced"];
	"venom" -> "mayhem"[label="Influenced"];
	"b-sabbath" -> "slayer"[label="Influenced"];
	"slayer" -> "nasum"[label="Influenced"];
}
```

# Changelog
## 0.1
* Basic functionality to draw graphs and digraphs. 
* Node shapes and labels. 

## 0.2
* Tested with files. 
* Colors
