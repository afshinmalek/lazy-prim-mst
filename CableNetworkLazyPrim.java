import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList; // Still using LinkedList for internal queue in UnionFind example if needed

// Provided Edge class
class Edge implements Comparable<Edge> {
  private final int v, w;
  private final double weight;

  public Edge(int v, int w, double weight) {
    if (v < 0 || w < 0)
      throw new IllegalArgumentException("vertex index must be a nonnegative integer");
    if (Double.isNaN(weight))
      throw new IllegalArgumentException("Weight is NaN");
    this.v = v;
    this.w = w;
    this.weight = weight;
  }

  public double weight() {
    return weight;
  }

  public int either() {
    return v;
  }

  public int other(int vertex) {
    if (vertex == v)
      return w;
    else if (vertex == w)
      return v;
    else
      throw new IllegalArgumentException("Illegal endpoint");
  }

  @Override
  public int compareTo(Edge that) {
    if (this.weight < that.weight)
      return -1;
    else if (this.weight > that.weight)
      return +1;
    else
      return 0;
  }

  @Override
  public String toString() {
    return String.format("%d-%d %.2f", v, w, weight);
  }
}

// Provided Bag class
class Bag<Item> implements Iterable<Item> {
  private Node first; // first node in list
  private int n; // number of elements in bag

  private class Node {
    Item item;
    Node next;
  }

  public Bag() {
    first = null;
    n = 0;
  }

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return n;
  }

  public void add(Item item) {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    n++;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}

class Queue<Item> implements Iterable<Item> {
  private Node first; // link to least recently added node
  private Node last; // link to most recently added node
  private int N; // number of items on the queue

  private class Node { // nested class to define nodes
    Item item;
    Node next;
  }

  public boolean isEmpty() {
    return first == null;
  } // Or: N == 0.

  public int size() {
    return N;
  }

  public void enqueue(Item item) { // Add item to the end of the list.
    Node oldlast = last;
    last = new Node();
    last.item = item;
    last.next = null;

    if (isEmpty())
      first = last;
    else
      oldlast.next = last;
    N++;
  }

  public Item dequeue() { // Remove item from the beginning of the list.
    if (isEmpty())
      throw new NoSuchElementException("Queue underflow");
    Item item = first.item;
    first = first.next;
    if (isEmpty())
      last = null;
    N--;
    return item;
  }

  public Iterator<Item> iterator() {
    return new ListIterator();
  }

  private class ListIterator implements Iterator<Item> {
    private Node current = first;

    public boolean hasNext() {
      return current != null;
    }

    public void remove() {
      throw new UnsupportedOperationException();
    }

    public Item next() {
      if (!hasNext())
        throw new NoSuchElementException();
      Item item = current.item;
      current = current.next;
      return item;
    }
  }
}

// Provided EdgeWeightedGraph class
class EdgeWeightedGraph {

  private final int V;
  private final Bag<Edge>[] adj;

  public EdgeWeightedGraph(int V) {
    if (V < 0)
      throw new IllegalArgumentException("Number of vertices must be a nonnegative integer");
    this.V = V;
    adj = (Bag<Edge>[]) new Bag[V];
    for (int v = 0; v < V; v++)
      adj[v] = new Bag<Edge>();
  }

  public int V() {
    return V;
  }

  public void addEdge(Edge e) {
    int v = e.either(), w = e.other(v);
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    if (w < 0 || w >= V)
      throw new IllegalArgumentException("vertex " + w + " is not between 0 and " + (V - 1));
    adj[v].add(e);
    adj[w].add(e);
  }

  public Iterable<Edge> adj(int v) {
    if (v < 0 || v >= V)
      throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
    return adj[v];
  }

  public Iterable<Edge> edges() {
    Bag<Edge> list = new Bag<Edge>();
    for (int v = 0; v < V; v++) {
      for (Edge e : adj(v)) {
        if (e.other(v) > v) {
          list.add(e);
        }
      }
    }
    return list;
  }

}

// Class for Lazy Prim's MST algorithm with Dummy Node
class LazyPrimMST {

  private boolean[] marked; // marked[v] = true if v is in MST
  private Queue<Edge> mst; // edges in the MST
  private PriorityQueue<Edge> pq; // edges incident to marked[], not in MST
  private int numOriginalNodes; // Number of original nodes (excluding dummy)
  private int dummyNode; // ID of the dummy node

  public LazyPrimMST(EdgeWeightedGraph G, int startNode, int numOriginalNodes) {
    this.numOriginalNodes = numOriginalNodes;
    this.dummyNode = numOriginalNodes; // Dummy node is the last node ID

    marked = new boolean[G.V()];
    mst = new Queue<>(); // Using the provided Queue class
    pq = new PriorityQueue<>();

    // Start Prim's from the dummy node.
    // The visit method adds incident edges to the PQ.
    if (startNode != dummyNode) {
      visit(G, startNode);
    } else {
      visit(G, dummyNode);
    }

    while (!pq.isEmpty()) {
      Edge e = pq.poll(); // Get cheapest edge from pq
      int v = e.either();
      int w = e.other(v);

      // If both endpoints are already in MST, discard edge (creates a cycle in the
      // MST being built)
      if (marked[v] && marked[w])
        continue;

      // Otherwise, edge e connects current MST to a new vertex
      mst.enqueue(e); // Add edge to MST using the provided Queue

      // Visit the endpoint(s) not yet in MST
      if (!marked[v])
        visit(G, v);
      if (!marked[w])
        visit(G, w);
    }
  }

  // Add vertex v to MST and add all its incident edges to pq
  private void visit(EdgeWeightedGraph G, int v) {
    marked[v] = true;
    for (Edge e : G.adj(v)) {
      if (!marked[e.other(v)]) {
        pq.add(e);
      }
    }
  }

  // Returns the edges in the MST
  public Iterable<Edge> mstEdges() {
    return mst;
  }

  // Calculates the total cable cost (excluding dummy node edges)
  public double getTotalCableCost() {
    double totalCost = 0;
    for (Edge e : mst) {
      // Only add the weight if the edge does not involve the dummy node
      if (e.either() != dummyNode && e.other(e.either()) != dummyNode) {
        totalCost += e.weight();
      }
    }
    return totalCost;
  }
}

public class CableNetworkLazyPrim {

  public static void main(String[] args) {
    int numOriginalNodes = 50;
    int dummyNode = numOriginalNodes;

    System.out.println("Running Lazy Prim's algorithm with dummy node starting from the dummy node...");
    LazyPrimMST lazyPrim = new LazyPrimMST(G50.graph(), 50, 50);

    System.out.println("\nEdges in the Minimum Cost Cable Network (using dummy node + Lazy Prim's):");
    double totalCableUsed = lazyPrim.getTotalCableCost();
    // Print edges that were part of the MST and are NOT connected to the dummy node
    for (Edge edge : lazyPrim.mstEdges()) {
      if (edge.either() != dummyNode && edge.other(edge.either()) != dummyNode) {
        System.out.println(edge);
      }
    }
    System.out.println("Total length of the cable used: " + totalCableUsed);
    System.out.println();
    System.out.println("\nCalculating the cost of the cable network for each field station...");

    LazyPrimMST station7 = new LazyPrimMST(G7.graph(), 7, numOriginalNodes);
    double cost7 = station7.getTotalCableCost();
    LazyPrimMST station14 = new LazyPrimMST(G14.graph(), 14, numOriginalNodes);
    double cost14 = station14.getTotalCableCost();
    LazyPrimMST station25 = new LazyPrimMST(G25.graph(), 25, numOriginalNodes);
    double cost25 = station25.getTotalCableCost();
    LazyPrimMST station28 = new LazyPrimMST(G28.graph(), 28, numOriginalNodes);
    double cost28 = station28.getTotalCableCost();
    LazyPrimMST station40 = new LazyPrimMST(G40.graph(), 40, numOriginalNodes);
    double cost40 = station40.getTotalCableCost();

    System.out.println("station 7: " + cost7);
    System.out.println("station 14: " + cost14);
    System.out.println("station 25: " + cost25);
    System.out.println("station 28: " + cost28);
    System.out.println("station 40: " + cost40);

    double minCost = Math.min(Math.min(cost7, cost14), Math.min(Math.min(cost25, cost28), cost40));
    if (minCost == cost7) {
      System.out.println("The minimum cost is for station 7: " + cost7);
    } else if (minCost == cost14) {
      System.out.println("The minimum cost is for station 14: " + cost14);
    } else if (minCost == cost25) {
      System.out.println("The minimum cost is for station 25: " + cost25);
    } else if (minCost == cost28) {
      System.out.println("The minimum cost is for station 28: " + cost28);
    } else {
      System.out.println("The minimum cost is for station 40: " + cost40);
    }

  }

}

/*
 * Running Lazy Prim's algorithm with dummy node starting from the dummy node...
 * 
 * Edges in the Minimum Cost Cable Network (using dummy node + Lazy Prim's):
 * 3-14 15.00
 * 5-7 15.00
 * 1-5 13.00
 * 3-8 15.00
 * 2-3 15.00
 * 14-21 16.00
 * 8-9 16.00
 * 23-28 18.00
 * 1-6 18.00
 * 0-6 17.00
 * 7-17 20.00
 * 17-32 15.00
 * 18-32 15.00
 * 40-45 20.00
 * 4-5 20.00
 * 11-45 21.00
 * 25-31 21.00
 * 26-31 20.00
 * 12-14 22.00
 * 10-12 22.00
 * 41-45 23.00
 * 41-43 14.00
 * 43-47 15.00
 * 14-19 23.00
 * 7-16 25.00
 * 28-35 25.00
 * 24-25 25.00
 * 24-29 15.00
 * 34-41 25.00
 * 34-42 20.00
 * 42-44 24.00
 * 27-34 25.00
 * 17-22 28.00
 * 10-13 28.00
 * 13-15 28.00
 * 15-20 25.00
 * 36-40 30.00
 * 36-39 25.00
 * 39-46 20.00
 * 46-48 15.00
 * 33-39 25.00
 * 33-49 20.00
 * 33-38 25.00
 * 37-38 25.00
 * 30-37 30.00
 * Total length of the cable used: 937.0
 * 
 * 
 * Calculating the cost of the cable network for each field station...
 * station 7: 990.0
 * station 14: 984.0
 * station 25: 1030.0
 * station 28: 994.0
 * station 40: 1001.0
 * The minimum cost is for station 14: 984.0
 */