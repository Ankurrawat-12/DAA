import java.util.Arrays;
import java.util.PriorityQueue;

class Graph {
    private int vertices;
    private int[][] adjacencyMatrix;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination, int weight) {
        this.adjacencyMatrix[source][destination] = weight;
        this.adjacencyMatrix[destination][source] = weight;
    }

    public int[] dijkstra(int startVertex) {
        int[] distance = new int[vertices];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[startVertex] = 0;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startVertex, 0));

        while (!priorityQueue.isEmpty()) {
            int currentVertex = priorityQueue.poll().vertex;

            for (int adjacentVertex = 0; adjacentVertex < vertices; adjacentVertex++) {
                int edgeWeight = adjacencyMatrix[currentVertex][adjacentVertex];

                if (edgeWeight > 0) {
                    int newDistance = distance[currentVertex] + edgeWeight;

                    if (newDistance < distance[adjacentVertex]) {
                        distance[adjacentVertex] = newDistance;
                        priorityQueue.add(new Node(adjacentVertex, newDistance));
                    }
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 4);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 3, 7);
        graph.addEdge(2, 4, 3);
        graph.addEdge(3, 4, 1);

        long startBest = System.nanoTime();
        int[] bestCaseDistance = graph.dijkstra(0);
        long endBest = System.nanoTime();
        double bestTime = (endBest - startBest) / 1e6;

        long startWorst = System.nanoTime();
        int[] worstCaseDistance = graph.dijkstra(0);
        long endWorst = System.nanoTime();
        double worstTime = (endWorst - startWorst) / 1e6;

        System.out.println("Best case:");
        System.out.println("Shortest distances: " + Arrays.toString(bestCaseDistance));
        System.out.println("Time taken: " + bestTime + " ms");

        System.out.println("\nWorst case:");
        System.out.println("Shortest distances: " + Arrays.toString(worstCaseDistance));
        System.out.println("Time taken: " + worstTime + " ms");
    }
}
