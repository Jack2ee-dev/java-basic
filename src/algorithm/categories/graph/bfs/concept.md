# Breadth First Search

## Explanation

Given a graph G == (V, E) and a distinguished source vertex s, breadth-first search systematically
explores the edges of G to
"discover" every vertex that is reachable from s. it computes ths distance (smallest number of
edges) from s to each reachable vertex. That is, the algorithm discovers all vertices at distance k
from s before discovering any vertices at distance k+1.

## Pseudo code

The algorithm uses a **first-in, first-out queue** Q to manage the set of gray vertices.
<br>
<br>
BFS

```
for each vertex u ∈ G.V - {s}:
    u.color = WHITE
    u.d = INFINITY // d stands for the distance from the source s to vertex u.
    u.pi = NIL // pi stands for the predecessor
s.color = GRAY
s.d = 0
s.pi = NIL
Q = {}
ENQUEUE(Q,s)
while Q != {}: // O(V)
    u = DEQUEUE(Q); // O(1)
    for each v ∈ G.Adj(u): // O(E)
        if v.color == WHITE
            v.color = GRAY
            v.d = u.d + 1
            v.pi = u
            ENQUEUE(Q,v)
    u.color = BLACK
```