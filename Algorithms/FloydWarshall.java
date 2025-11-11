public class FloydWarshall {
    /*
     * The Floyd-Warshall algorithm finds shortest paths in a weighted graph with
     * positive or negative edge weights (but with no negative cycles).
     * 
     * Time Complexity: O(V^3)
     * Space Complexity: O(V^2)
     */
    public static int[][] floydWarshall(int V, int[][] graph) {
        int[][] dist = new int[V][V];
        // Initialize the distance matrix
        // Integer.MAX_VALUE is used to represent "no edge"
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else if (graph[i][j] != 0) {
                    dist[i][j] = graph[i][j];
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        // If -1 is used to represent "no edge" in the input graph, use this:
        // Convert -1 to Integer.MAX_VALUE to represent "no edge"

        // for (int i = 0; i < V; i++) {
        //     for (int j = 0; j < V; j++) {
        //         if (i == j) {
        //             dist[i][j] = 0;
        //         } else if (graph[i][j] == -1) {
        //             dist[i][j] = Integer.MAX_VALUE;
        //         } else {
        //             dist[i][j] = graph[i][j];
        //         }
        //     }
        // }

        // Update the distance matrix
        // time complexity: O(V^3)
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Detect negative cycles
        for (int i = 0; i < V; i++) {
            if (dist[i][i] < 0) {
                throw new IllegalArgumentException("Graph contains a negative-weight cycle");
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        // int V = 4;
        // int[][] graph = {
        // { 0, 2, Integer.MAX_VALUE, 3 },
        // { 3, 0, 2, Integer.MAX_VALUE },
        // { Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 4 },
        // { -2, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 }
        // };
        int V = 3;
        int[][] graph = {
                { 0, 1, Integer.MAX_VALUE },
                { Integer.MAX_VALUE, 0, -1 },
                { -1, Integer.MAX_VALUE, 0 }
        };

        try {
            int[][] dist = floydWarshall(V, graph);

            System.out.println("Shortest distances between every pair of vertices:");
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][j] == Integer.MAX_VALUE) {
                        System.out.print("INF ");
                    } else {
                        System.out.print(dist[i][j] + " ");
                    }
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error computing shortest paths: " + e.getMessage());
        }
    }
}
