import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(bfs(N, K));
    }

    private static int bfs(int N, int K) {

        if (N == K) {
            return 0;
        }

        Queue<int[]> queue = new LinkedList<>();
        int maxValue = Math.max(K + 2, N + 2);
        Boolean[] visited = new Boolean[maxValue];
        Arrays.fill(visited,false);
        queue.add(new int[]{N, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curPoint = cur[0];
            int curCount = cur[1];

            if (curPoint == K) {
                return curCount;
            }

            visited[curPoint] = true;
            int newPoint = curPoint -1;
            if (newPoint >= 0) {
                if (!visited[newPoint]) {
                    queue.add(new int[]{newPoint, curCount + 1});
                }
            }

            newPoint = curPoint + 1;
            if (newPoint <= K ) {
                if (!visited[newPoint]) {
                    queue.add(new int[]{newPoint, curCount + 1});
                }
            }

            newPoint = curPoint * 2;
            if (newPoint < maxValue) {
                if (!visited[newPoint]) {
                    queue.add(new int[]{newPoint, curCount + 1});
                }
            }
        }
        return 0;
    }
}