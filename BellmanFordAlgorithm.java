import java.util.Arrays;

class Graph {
    private int vertices;
    private int edges;
    private Edge[] edgeList;

    public Graph(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.edgeList = new Edge[edges];
        for (int i = 0; i < edges; i++) {
            this.edgeList[i] = new Edge();
        }
    }

    public void addEdge(int source, int destination, int weight, int edgeIndex) {
        this.edgeList[edgeIndex].source = source;
        this.edgeList[edgeIndex].destination = destination;
        this.edgeList[edgeIndex].weight = weight;
    }

    public void bellmanFord(int startVertex) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[startVertex] = 0;

        for (int i = 0; i < vertices - 1; i++) {
            for (int j = 0; j < edges; j++) {
                int u = edgeList[j].source;
                int v = edgeList[j].destination;
                int weight = edgeList[j].weight;

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight;
                }
            }
        }

        for (int j = 0; j < edges; j++) {
            int u = edgeList[j].source;
            int v = edgeList[j].destination;
            int weight = edgeList[j].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        System.out.println("Shortest distances from vertex " + startVertex + ": " + Arrays.toString(distance));
    }

    static class Edge {
        int source, destination, weight;
    }
}

public class BellmanFordAlgorithm {

    public static void main(String[] args) {
        int vertices = 5;
        int edges = 8;

        Graph graph = new Graph(vertices, edges);

        graph.addEdge(0, 1, -1, 0);
        graph.addEdge(0, 2, 4, 1);
        graph.addEdge(1, 2, 3, 2);
        graph.addEdge(1, 3, 2, 3);
        graph.addEdge(1, 4, 2, 4);
        graph.addEdge(3, 2, 5, 5);
        graph.addEdge(3, 1, 1, 6);
        graph.addEdge(4, 3, -3, 7);

        long startBest = System.nanoTime();
        graph.bellmanFord(0);
        long endBest = System.nanoTime();
        double bestTime = (endBest - startBest) / 1e6;

        System.out.println("\nTime taken for best case: " + bestTime + " ms");
    }
}
