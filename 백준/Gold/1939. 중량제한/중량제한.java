import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static List<int[]>[] listArr;
    static int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        listArr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            listArr[i] = new ArrayList<>();
        }

        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            listArr[start].add(new int[]{end, cost});
            listArr[end].add(new int[]{start, cost});
            maxWeight = Math.max(maxWeight, cost);
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(binarySearch(1, maxWeight));
    }

    private static boolean bfs(int weight) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N + 1];

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curIsland = queue.poll();

            if (curIsland == end) {
                return true;
            }

            for (int[] next : listArr[curIsland]) {
                int nextIsland = next[0];
                int nextWeight = next[1];

                if (!visited[nextIsland] && nextWeight >= weight) {
                    queue.add(nextIsland);
                    visited[nextIsland] = true;
                }
            }
        }

        return false;
    }

    private static int binarySearch(int low, int high) {
        int result = low;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bfs(mid)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}