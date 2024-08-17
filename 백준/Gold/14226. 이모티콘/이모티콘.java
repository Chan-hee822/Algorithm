import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        System.out.println(bfs(S));

    }

    private static int bfs(int S) {

        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{1, 0, 0});
        boolean[][] visited = new boolean[1001][1001];
        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curCount = cur[0];
            int curClip = cur[1];
            int curTime = cur[2];

            if (curCount == S) {
                return curTime;
            }
            // 2배 하기
            if (curCount < S && !visited[curCount][curCount]) {
                visited[curCount][curCount] = true;
                queue.add(new int[]{curCount, curCount, curTime + 1});
            }
            // clip 더하기
            if (curCount + curClip <= S && !visited[curCount + curClip][curClip]) {
                visited[curCount + curClip][curClip] = true;
                queue.add(new int[]{curCount + curClip, curClip, curTime + 1});
            }
            // 빼기
            if (curCount > 1 && !visited[curCount - 1][curClip]) {
                visited[curCount - 1][curClip] = true;
                queue.add(new int[]{curCount - 1, curClip, curTime + 1});
            }
        }
        return S;
    }
}