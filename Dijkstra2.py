import heapq

def dijkstra(graph, src, dest):
    pq = [(0, src)]
    dist = {node: float('inf') for node in graph}
    dist[src] = 0
    while pq:
        current_dist, current_node = heapq.heappop(pq)
        if current_node == dest:
            return dist[dest]
        for neighbor, weight in graph[current_node]:
            distance = current_dist + weight
            if distance < dist[neighbor]:
                dist[neighbor] = distance
                heapq.heappush(pq, (distance, neighbor))
    return -1

n = int(input("Enter the number of rows: "))
graph = {}

for _ in range(n):
    u, v, x = map(int, input().split())
    if u not in graph:
        graph[u] = []
    if v not in graph:
        graph[v] = []
    graph[u].append((v, x))
    graph[v].append((u, x))

src, dest = map(int, input("Enter source and destination nodes: ").split())

total_cost = dijkstra(graph, src, dest)

if total_cost != -1:
    print("Total cost:", total_cost)
else:
    print("Destination is not reachable")
