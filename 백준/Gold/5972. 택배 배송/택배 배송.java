import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
    int target;
    int weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        int result = dijkstra(graph, 0, N);
        System.out.println(result);
    }

    private static int dijkstra(List<List<Edge>> graph, int start, int end) {
        int[] distance = new int[end];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curEdge = pq.poll();
            int curTarget = curEdge.target;
            int curWeight = curEdge.weight;

            if (curWeight > distance[curTarget]) {
                continue;
            }

            for (Edge edge : graph.get(curTarget)) {
                int nextTarget = edge.target;
                int nextWeight = edge.weight;

                if (distance[curTarget] + nextWeight < distance[nextTarget]) {
                    distance[nextTarget] = distance[curTarget] + nextWeight;
                    pq.add(new Edge(nextTarget, nextWeight));
                }
            }
        }
        return distance[end - 1];
    }
}