<div align="center">

# 🔌 Lazy Prim's MST - Minimum Cable Network

### Java · Graph Algorithms · Minimum Spanning Tree

Lazy Prim's minimum spanning tree for a cable network, plus per-station MST costs - choosing the cheapest field station to build from.

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Graph Algorithms](https://img.shields.io/badge/Graph_Algorithms-5382A1?style=for-the-badge&logoColor=white)
![MST](https://img.shields.io/badge/MST-6E4C13?style=for-the-badge&logoColor=white)

</div>

## What it does

| Feature | Detail |
|---|---|
| Lazy Prim's MST | Builds a minimum spanning tree without an indexed priority queue, lazily skipping stale edges |
| Cable-network optimization | Finds the minimum total cable cost to connect the network |
| Per-station costs | Computes MST cost from each candidate field station and picks the cheapest |
| Multiple graphs | Includes the G7, G14, G25, G28, G40, and G50 graph datasets |

## Run

```bash
javac *.java
java CableNetworkLazyPrim
```

## Files

- `CableNetworkLazyPrim.java` - Lazy Prim's algorithm and driver
- `G7.java`, `G14.java`, `G25.java`, `G28.java`, `G40.java`, `G50.java` - graph datasets

> Originally a Data Structures & Algorithms (CIS 27) project, extracted here as a standalone repo from [java-algorithms-and-concurrency](https://github.com/afshinmalek/java-algorithms-and-concurrency).
