package com.github.lant.dotdump;

import org.junit.Before;
import org.junit.Test;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class ConcurrencyTest {

  private ExecutorService executor;

  @Before
  public void setUp() {
    executor = Executors.newFixedThreadPool(5);
  }

  @Test
  public void testMultipleConcWrites() throws InterruptedException {
    Dot dot = new Dot(GraphType.GRAPH, "concurrency test");
    for (int i = 0; i < 10000; i++) {
      executor.execute(() -> dot.withNode(new GraphNode(UUID.randomUUID().toString())));
      executor.execute(() -> dot.withRelation(new NodeRelation(null, null)));
    }
    executor.shutdown();
    executor.awaitTermination(5, TimeUnit.SECONDS);
    assertEquals(10000, dot.getNodesSize());
    assertEquals(10000, dot.getRelationsSize());
  }


}
