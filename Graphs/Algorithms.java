package Graphs;

import java.util.ArrayList;

public class Algorithms {
    // Bellman–Ford is used to find the shortest path from a single source to all
    // nodes, and it works even with negative edge weights.
    // For every edge ((u, v)), we perform relaxation:
    // if(dist[u] + wt < dist[v] -> update dist[v].
    // This relaxation is repeated V − 1 times to ensure all shortest paths are
    // computed.
    // Then we run **one extra iteration:
    // If any distance still updates, a negative weight cycle exists → return -1.
    // Otherwise, the `dist[]` array contains the final shortest paths.
    // Time Complexity: O(V X E)
    // Space Complexity: O(V)
    public static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        int[] dis = new int[V];
        for (int i = 0; i < dis.length; i++) {
            dis[i] = (int) 1e9;
        }
        dis[src] = 0;

        // V - 1 interations to update shortest path in dis arr.
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if (dis[u] != (int) 1e9 && dis[u] + wt < dis[v]) {
                    dis[v] = dis[u] + wt;
                }
            }
        }

        // vth iteration to check negative cycle.
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            if (dis[u] != (int) 1e9 && dis[u] + wt < dis[v]) {
                return new int[] { -1 };
            }
        }

        return dis;
    }

    public static void main(String[] args) {

    }
}