import java.util.ArrayList;

class Edge {
    int u, v, weight;

    // u: source vertex
    // v: destination vertex
    // weight: edge weight
    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

public class BellmanFord {
    public static final int INF = Integer.MAX_VALUE;

    public static int[] bellmanFord(int V, ArrayList<Edge> edges, int source) {
        /*
         * Time Complexity: O(V*E)
         * Space Complexity: O(V)
         */

        int[] distance = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = INF;
        }
        distance[source] = 0;

        // Relax edges repeatedly
        // V*E time complexity
        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edges) {
                if (distance[edge.u] != INF && distance[edge.u] + edge.weight < distance[edge.v]) {
                    distance[edge.v] = distance[edge.u] + edge.weight;
                }
            }
        }

        // Check for negative-weight cycles
        for (Edge edge : edges) {
            if (distance[edge.u] != INF && distance[edge.u] + edge.weight < distance[edge.v]) {
                System.out.println("Graph contains negative weight cycle");
                return null;
            }
        }

        // Print the shortest distances
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + (distance[i] == INF ? "INF" : distance[i]));
        }

        return distance;
    }

    public static void main(String[] args) {
        ArrayList<Edge> graph = new ArrayList<>();
        int[][] edges = {
                { 3, 2, 6 },
                { 5, 3, 1 },
                { 0, 1, 5 },
                { 1, 5, -3 },
                { 1, 2, -2 },
                { 3, 4, -2 },
                { 2, 4, 3 }
        };
        // Construct the graph
        for (int[] e : edges) {
            graph.add(new Edge(e[0], e[1], e[2]));
        }

        int source = 0;
        int V = 6;
        bellmanFord(V, graph, source);
    }
}