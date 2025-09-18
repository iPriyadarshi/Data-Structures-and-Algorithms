import java.util.*;

public class Graph {
    // Graph representation using adjacency list
    private Map<Integer, List<Integer>> adjList;

    public Graph() {
        this.adjList = new HashMap<>();
    }

    // Add edge to the graph
    public void addEdge(int src, int dest) {
        this.adjList.putIfAbsent(src, new ArrayList<>());
        this.adjList.putIfAbsent(dest, new ArrayList<>());
        this.adjList.get(src).add(dest);
        this.adjList.get(dest).add(src); // For undirected graph
    }

    // Depth-First Search (DFS)
    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited.contains(node)) {
                visited.add(node);
                System.out.print(node + " ");
                for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }
    }

    // Breadth-First Search (BFS)
    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue the head(front) node
            System.out.print(node + " ");
            for (int neighbor : adjList.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        System.out.println("DFS starting from node 1:");
        graph.dfs(1); // Output: 1 3 5 2 4 (order may vary)

        System.out.println("\nBFS starting from node 1:");
        graph.bfs(1); // Output: 1 2 3 4 5
    }
}