// Given q queries in the form of a graph and some starting node, s, perform each query
// by calculating the shortest distance from starting node s to all the other nodes in the graph.
// Then print a single line of n-1 space-separated integers listing node 's shortest distance
// to each of the  other nodes (ordered sequentially by node number);
// if s is disconnected from a node, print -1 as the distance to that node.

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class Graph {

        List<List<Integer>> adjLst;
        int size;

        public Graph(int size) {
            adjLst = new ArrayList<>();
            this.size = size;
            while(size-- > 0)//Initialize the adjancency list.
                adjLst.add(new ArrayList<Integer>());
        }

        public void addEdge(int first, int second) {
            adjLst.get(first).add(second);
            adjLst.get(second).add(first);
            // For an undirected graph, you need to add edges from both sides.
        }

        public int[] shortestReach(int startId) { // 0 indexed

            int[] distances = new int[size];
            Arrays.fill(distances, -1); // O(n) space.

            Queue<Integer> queue = new LinkedList<>();
            queue.add(startId); // Initialize queue.
            distances[startId] = 0;
            HashSet<Integer> visited = new HashSet<>();
            //O(n) space. Could be further optimized. I leave it to you to optimize it.
            visited.add(startId);

            while(!queue.isEmpty()) { // Standard BFS loop.
                Integer current = queue.poll();
                for(int node : adjLst.get(current)) {
                    if(!visited.contains(node)) {
                        queue.offer(node);
                        // Right place to add the visited set.
                        visited.add(node);
                        // Keep on increasing distance level by level.
                        distances[node] = distances[current] + 6;
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int queries = scanner.nextInt();

        for (int t = 0; t < queries; t++) {

            // Create a graph of size n where each edge weight is 6:
            Graph graph = new Graph(scanner.nextInt());
            int m = scanner.nextInt();

            // read and set edges
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;

                // add each edge to the graph
                graph.addEdge(u, v);
            }

            // Find shortest reach from node s
            int startId = scanner.nextInt() - 1;
            int[] distances = graph.shortestReach(startId);

            for (int i = 0; i < distances.length; i++) {
                if (i != startId) {
                    System.out.print(distances[i]);
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
