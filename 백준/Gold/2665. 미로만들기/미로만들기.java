import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] miroTable = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                miroTable[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println(bfs(miroTable, n));
    }

    private static int bfs(int[][] miroTable, int n) {

        Deque<int[]> queue = new LinkedList<>();
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        queue.add(new int[]{0, 0});
        distance[0][0] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++) {

                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newY >= 0 && newX < n && newY < n) {
                    if (miroTable[newX][newY] == 0 && distance[newX][newY] > distance[x][y] + 1) {
                        distance[newX][newY] = distance[x][y] + 1;
                        queue.addLast(new int[]{newX, newY});
                    } else if (miroTable[newX][newY] == 1 && distance[newX][newY] > distance[x][y]) {
                        distance[newX][newY] = distance[x][y];
                        queue.addFirst(new int[]{newX, newY});
                    }
                }
            }
        }
        return distance[n - 1][n - 1];
    }
}