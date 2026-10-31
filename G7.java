public class G7 {
  public static EdgeWeightedGraph graph() {
    EdgeWeightedGraph graph = new EdgeWeightedGraph(50); // assuming 50 nodes; adjust if needed

    graph.addEdge(new Edge(0, 1, 33));
    graph.addEdge(new Edge(0, 2, 30));
    graph.addEdge(new Edge(0, 6, 17));
    graph.addEdge(new Edge(0, 9, 25));

    graph.addEdge(new Edge(1, 4, 25));
    graph.addEdge(new Edge(1, 5, 13));
    graph.addEdge(new Edge(1, 6, 18));

    graph.addEdge(new Edge(2, 3, 15));
    graph.addEdge(new Edge(2, 9, 20));
    graph.addEdge(new Edge(2, 10, 35));
    graph.addEdge(new Edge(2, 12, 27));

    graph.addEdge(new Edge(3, 8, 15));
    graph.addEdge(new Edge(3, 9, 31));
    graph.addEdge(new Edge(3, 12, 23));
    graph.addEdge(new Edge(3, 21, 20));

    graph.addEdge(new Edge(4, 5, 20));
    graph.addEdge(new Edge(4, 7, 31));
    graph.addEdge(new Edge(4, 16, 40));

    graph.addEdge(new Edge(5, 6, 20));
    graph.addEdge(new Edge(5, 7, 15));
    graph.addEdge(new Edge(5, 8, 30));

    graph.addEdge(new Edge(6, 8, 25));
    graph.addEdge(new Edge(6, 9, 21));

    graph.addEdge(new Edge(7, 8, 35));
    graph.addEdge(new Edge(7, 16, 25));
    graph.addEdge(new Edge(7, 17, 20));
    graph.addEdge(new Edge(7, 32, 30));

    graph.addEdge(new Edge(8, 9, 16));
    graph.addEdge(new Edge(8, 21, 35));
    graph.addEdge(new Edge(8, 32, 32));

    graph.addEdge(new Edge(10, 12, 22));
    graph.addEdge(new Edge(10, 13, 28));

    graph.addEdge(new Edge(12, 15, 30));

    graph.addEdge(new Edge(13, 15, 28));
    graph.addEdge(new Edge(13, 20, 40));

    graph.addEdge(new Edge(15, 20, 25));

    graph.addEdge(new Edge(16, 17, 30));
    graph.addEdge(new Edge(16, 22, 35));
    graph.addEdge(new Edge(16, 27, 50));

    graph.addEdge(new Edge(17, 22, 28));
    graph.addEdge(new Edge(17, 23, 25));
    graph.addEdge(new Edge(17, 32, 15));

    graph.addEdge(new Edge(18, 21, 20));
    graph.addEdge(new Edge(18, 23, 30));
    graph.addEdge(new Edge(18, 24, 30));
    graph.addEdge(new Edge(18, 29, 40));

    graph.addEdge(new Edge(19, 20, 30));
    graph.addEdge(new Edge(19, 21, 30));
    graph.addEdge(new Edge(19, 24, 35));
    graph.addEdge(new Edge(19, 26, 40));

    graph.addEdge(new Edge(20, 26, 30));

    graph.addEdge(new Edge(21, 24, 45));
    graph.addEdge(new Edge(21, 32, 26));

    graph.addEdge(new Edge(22, 27, 35));
    graph.addEdge(new Edge(23, 29, 32));
    graph.addEdge(new Edge(23, 32, 30));

    graph.addEdge(new Edge(24, 29, 15));

    graph.addEdge(new Edge(26, 31, 20));
    graph.addEdge(new Edge(26, 38, 55));

    graph.addEdge(new Edge(27, 34, 25));
    graph.addEdge(new Edge(27, 42, 26));

    graph.addEdge(new Edge(29, 30, 35));
    graph.addEdge(new Edge(29, 35, 30));
    graph.addEdge(new Edge(29, 36, 37));

    graph.addEdge(new Edge(30, 36, 33));
    graph.addEdge(new Edge(30, 37, 30));

    graph.addEdge(new Edge(31, 37, 35));
    graph.addEdge(new Edge(31, 38, 40));

    graph.addEdge(new Edge(33, 37, 35));
    graph.addEdge(new Edge(33, 38, 25));
    graph.addEdge(new Edge(33, 39, 25));
    graph.addEdge(new Edge(33, 46, 30));
    graph.addEdge(new Edge(33, 49, 20));

    graph.addEdge(new Edge(34, 35, 33));
    graph.addEdge(new Edge(34, 41, 25));
    graph.addEdge(new Edge(34, 42, 20));
    graph.addEdge(new Edge(34, 43, 37));

    graph.addEdge(new Edge(35, 36, 43));

    graph.addEdge(new Edge(36, 37, 28));
    graph.addEdge(new Edge(36, 39, 25));

    graph.addEdge(new Edge(37, 38, 25));
    graph.addEdge(new Edge(37, 39, 30));

    graph.addEdge(new Edge(38, 49, 45));

    graph.addEdge(new Edge(41, 45, 23));

    graph.addEdge(new Edge(42, 43, 34));
    graph.addEdge(new Edge(42, 44, 24));
    graph.addEdge(new Edge(42, 47, 36));

    graph.addEdge(new Edge(43, 45, 30));

    graph.addEdge(new Edge(43, 47, 15));

    graph.addEdge(new Edge(44, 47, 26));

    graph.addEdge(new Edge(45, 46, 30));

    graph.addEdge(new Edge(46, 48, 15));
    graph.addEdge(new Edge(46, 49, 35));

    graph.addEdge(new Edge(48, 49, 32));

    // Finally, the three edges for node 11:
    graph.addEdge(new Edge(11, 43, 35));
    graph.addEdge(new Edge(11, 45, 21));
    graph.addEdge(new Edge(11, 48, 44));
    graph.addEdge(new Edge(18, 32, 15));
    graph.addEdge(new Edge(35, 41, 30));
    graph.addEdge(new Edge(39, 46, 20));
    graph.addEdge(new Edge(41, 43, 14));
    graph.addEdge(new Edge(43, 45, 30));
    graph.addEdge(new Edge(45, 48, 33));

    return graph;
  }
}
