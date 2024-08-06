import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] map = new int[5][5];

        Map<Integer, int[]> map1 = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                map1.put(num, new int[]{i, j});
            }
        }

        int[] xBingo = new int[5];
        int[] yBingo = new int[5];
        int xyBingo = 0;
        int yxBingo = 0;
        int cnt = 0;
        int result = 0;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5 ; j++) {
                int target = Integer.parseInt(st.nextToken());
                int[] point = map1.get(target);
                result++;
                int targetX = point[0];
                xBingo[targetX]++;
                if (xBingo[targetX] == 5) {
                    cnt++;
                }
                int targetY = point[1];
                yBingo[targetY]++;
                if (yBingo[targetY] == 5) {
                    cnt++;
                }
                if (targetX == targetY) {
                    xyBingo++;
                    if (xyBingo == 5) {
                        cnt++;
                    }
                }
                if (targetX + targetY == 4) {
                    yxBingo++;
                    if (yxBingo == 5) {
                        cnt++;
                    }
                }
                if (cnt >= 3) {
                    System.out.println(result);
                    return;
                }
            }
        }
    }
}