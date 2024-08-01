import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] table = new int[N][N];

        List<int[]> houseQueue = new LinkedList<>();
        List<int[]> chikQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());

                if (table[i][j] == 1) {
                    houseQueue.add(new int[]{i, j});
                }

                if (table[i][j] == 2) {
                    chikQueue.add(new int[]{i, j});
                }
            }
        }
        List<int[]> chickenCombi = new ArrayList<>();
        combination(0, 0, M, chickenCombi
                , new boolean[chikQueue.size()], new int[M], chikQueue.size());

        int result = Integer.MAX_VALUE;
        for (int[] combi : chickenCombi) {
            int tempResult = getTempResult(combi, houseQueue, chikQueue);
            result = Math.min(result, tempResult);
        }
        System.out.println(result);
    }

    private static int getTempResult(int[] combi, List<int[]> houseQueue, List<int[]> chikQueue) {
        int tempResult = 0;
        for (int[] house : houseQueue) {
            int hx = house[0];
            int hy = house[1];
            int minDist = Integer.MAX_VALUE;
            for (int idx : combi) {
                int[] chicken = chikQueue.get(idx);
                int cx = chicken[0];
                int cy = chicken[1];
                int temp = Math.abs(cx - hx) + Math.abs(cy - hy);
                if (temp < minDist) {
                    minDist = temp;
                }
            }
            tempResult += minDist;
        }
        return tempResult;
    }

    private static void combination(int start, int depth, int M
            , List<int[]> chickenCombi, boolean[] visited, int[] result, int chickenSize) {
        if (depth == M) {
            int[] temp = new int[M];
            System.arraycopy(result, 0, temp, 0, M);
            chickenCombi.add(temp);
            return;
        }

        for (int i = start; i < chickenSize; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                combination(i, depth + 1, M, chickenCombi, visited, result, chickenSize);
                visited[i] = false;
            }
        }
    }

}