import java.util.*;

public class MinEffortsReqAns {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        int dest = sc.nextInt();

        int ans = minEffortsRequired(arr, src, dest);
        System.out.println(ans);
    }

    public static int minEffortsRequired(int[][] arr, int src, int dest) {
        int n = arr.length;
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            int effort = arr[i][2];

            graph.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[]{v, effort});
            graph.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[]{u, effort}); // Assuming undirected graph
        }

        return dijkstra(graph, src, dest);
    }

    private static int dijkstra(Map<Integer, List<int[]>> graph, int src, int dest) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Map<Integer, Integer> dist = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        pq.add(new int[]{src, 0});
        dist.put(src, 0);

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDist = current[1];

            if (node == dest) {
                return currentDist;
            }

            if (visited.contains(node)) {
                continue;
            }

            visited.add(node);

            for (int[] neighbor : graph.getOrDefault(node, Collections.emptyList())) {
                int nextNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if (!visited.contains(nextNode)) {
                    int newDist = currentDist + edgeWeight;
                    if (newDist < dist.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                        dist.put(nextNode, newDist);
                        pq.add(new int[]{nextNode, newDist});
                    }
                }
            }
        }
        return -1; // Return -1 if no path is found
    }
}
