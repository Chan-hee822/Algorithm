import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static String[][] map;
//    static boolean[][] visited;
    final static int[] dx = {0, 1, 0, -1};
    final static int[] dy = {1, 0, -1, 0};

    static int X;
    static int Y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new String[X][Y];
        boolean[][] visited = new boolean[X][Y];

        Queue<int[]> vQueue = new LinkedList<>();
        Queue<int[]> kQueue = new LinkedList<>();
        for (int i = 0; i < X; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < Y; j++) {
                String s = strArr[j];
                map[i][j] = s;
                if (s.equals("k")) {                // 양
                    kQueue.add(new int[]{i, j});
                } else if (s.equals("v")) {         // 늑대
                    vQueue.add(new int[]{i, j});
                }
            }
        }

        int resultK = 0;
        int resultV = 0;
        while (!kQueue.isEmpty()) {
            int[] point = kQueue.poll();
            int[] temp = dfs(0, 0, point[0], point[1], visited);
            if (temp == null) {
                continue;
            }
            int k = temp[0];
            int v = temp[1];
            if (k > v) {
                resultK += k;
            } else {
                resultV += v;
            }
        }
        while (!vQueue.isEmpty()) {
            int[] point = vQueue.poll();
            int[] temp = dfs(0, 0, point[0], point[1], visited);
            if (temp == null) {
                continue;
            }
            int k = temp[0];
            int v = temp[1];
            if (k > v) {
                resultK += k;
            } else {
                resultV += v;
            }
        }
        System.out.println(resultK + " " + resultV);
    }

    private static int[] dfs (int k, int v, int x, int y, boolean[][] visited) {

        if (visited[x][y] || map[x][y].equals("#")) {
            return new int[] {k, v};
        }

        visited[x][y] = true;

        String s = map[x][y];

        if (s.equals("k")) {
            k++;
        }
        if (s.equals("v")) {
            v++;
        }

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < X && newY < Y && !visited[newX][newY]) {
                int[] temp = dfs(k, v, newX, newY, visited);
                k = temp[0];
                v = temp[1];
            }
        }

        return new int[]{k, v};
    }
}