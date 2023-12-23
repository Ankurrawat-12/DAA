import java.util.Arrays;

class Graph {
    private int vertices;
    private int[][] graph;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.graph = new int[vertices][vertices];
    }

    public void addEdge(int u, int v, int weight) {
        this.graph[u][v] = weight;
        this.graph[v][u] = weight;
    }

    public int minKey(int[] key, boolean[] mstSet) {
        int minVal = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int v = 0; v < this.vertices; v++) {
            if (!mstSet[v] && key[v] < minVal) {
                minVal = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    public int[] primMST() {
        int[] key = new int[this.vertices];
        int[] parent = new int[this.vertices];
        boolean[] mstSet = new boolean[this.vertices];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;
        for (int i = 0; i < this.vertices - 1; i++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < this.vertices; v++) {
                if (this.graph[u][v] > 0 && !mstSet[v] && key[v] > this.graph[u][v]) {
                    key[v] = this.graph[u][v];
                    parent[v] = u;
                }
            }
        }
        return parent;
    }
}

public class MinimumSpanningTree {
    public static void main(String[] args) {
        Graph best = new Graph(4);
        best.addEdge(0, 1, 2);
        best.addEdge(1, 2, 2);
        best.addEdge(2, 3, 2);
        best.addEdge(3, 0, 2);
        best.addEdge(0, 2, 2);
        best.addEdge(1, 3, 2);
        long startB = System.currentTimeMillis();
        int[] bestParent = best.primMST();
        long endB = System.currentTimeMillis();
        String bestTime = String.format("%.6f", (endB - startB) / 1000.0);

        Graph worst = new Graph(4);
        worst.addEdge(0, 1, 1);
        worst.addEdge(1, 2, 2);
        worst.addEdge(2, 3, 3);
        worst.addEdge(3, 0, 4);
        worst.addEdge(0, 2, 5);
        worst.addEdge(1, 3, 6);
        long startW = System.currentTimeMillis();
        int[] worstParent = worst.primMST();
        long endW = System.currentTimeMillis();
        String worstTime = String.format("%.6f", (endW - startW) / 1000.0);

        System.out.println("Best case:");
        System.out.println("Time taken: " + bestTime);
        System.out.println("MST Parent array: " + Arrays.toString(bestParent));

        System.out.println("\nWorst case:");
        System.out.println("Time taken: " + worstTime);
        System.out.println("MST Parent array: " + Arrays.toString(worstParent));
    }
}
