import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    final static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    final static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][M];

        Queue<int[]> sharkQueue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                table[i][j] = num;
                if (num == 1) {
                    sharkQueue.add(new int[]{i, j, 0});
                    table[i][j] = 0;
                } else {
                    table[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        bfs(sharkQueue, table);

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (result < table[i][j]) {
                    result = table[i][j];
                }
            }
        }
        System.out.println(result);
    }

    private static void bfs(Queue<int[]> queue, int[][] table) {

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                if (newX >= 0 && newY >= 0 && newX < N && newY < M && table[newX][newY] != 0) {
                    if (table[newX][newY] > cur[2] + 1) {
                        table[newX][newY] = cur[2] + 1;
                        queue.add(new int[]{newX, newY, cur[2] + 1});
                    }
                }
            }
        }
    }
}