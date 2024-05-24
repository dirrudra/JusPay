import heapq

class Graph:
    def __init__(self, vertices):
        self.V = vertices
        self.adj = [[] for _ in range(vertices)]

    def add_edge(self, u, v, w):
        self.adj[u].append((v, w))
        self.adj[v].append((u, w))

    def shortest_path(self, src, dest):
        pq = []
        dist = [float('inf')] * self.V
        dist[src] = 0
        heapq.heappush(pq, (0, src))

        while pq:
            current_dist, u = heapq.heappop(pq)

            if u == dest:
                break

            for v, weight in self.adj[u]:
                if dist[v] > current_dist + weight:
                    dist[v] = current_dist + weight
                    heapq.heappush(pq, (dist[v], v))

        print("Vertex Distance from Source")
        for i in range(self.V):
            print(f"{i}\t\t{dist[i]}")

        print(f"Shortest path from {src} to {dest} is {dist[dest]}")



v = int(input("Enter the number of vertices"))
g = Graph(v)
while (v>0):
    u, v, w = map(int, input("Enter node, t_node and cost:").split())
    g.add_edge(u, v, w)
    v -= 1


src = int(input("Enter source"))
dest = int(input("Destination"))
g.shortest_path(src, dest)
# V = 9
# g = Graph(V)

# g.add_edge(0, 1, 4)
# g.add_edge(0, 7, 8)
# g.add_edge(1, 2, 8)
# g.add_edge(1, 7, 11)
# g.add_edge(2, 3, 7)
# g.add_edge(2, 8, 2)
# g.add_edge(2, 5, 4)
# g.add_edge(3, 4, 9)
# g.add_edge(3, 5, 14)
# g.add_edge(4, 5, 10)
# g.add_edge(5, 6, 2)
# g.add_edge(6, 7, 1)
# g.add_edge(6, 8, 6)
# g.add_edge(7, 8, 7)

    
