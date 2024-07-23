import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] table = new int[19][19];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 19; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
                cnt += table[i][j];
                if (table[i][j] != 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int x = temp[0];
            int y = temp[1];
            int cnt = 0;
            // 가로로 y 증가
            for (int i = y; i <= y + 5; i++) {
                if (i == 19) {
                    break;
                }
                if (table[x][i] != table[x][y]) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                if (y >= 1) {
                    if (table[x][y] == table[x][y - 1]) {
                        continue;
                    }
                }
                System.out.println(table[x][y]);
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
            // 세로로 x 증가
            cnt = 0;
            for (int i = x; i <= x + 5; i++) {
                if (i == 19) {
                    break;
                }
                if (table[i][y] != table[x][y]) {
                    break;
                }
                cnt++;
            }
            if (cnt == 5) {
                if (x >= 1) {
                    if (table[x][y] == table[x - 1][y]) {
                        continue;
                    }
                }
                System.out.println(table[x][y]);
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
            // 대각 오른쪽으로 x, y 증가
            cnt = 0;
            int x1 = x;
            int y1 = y;
            while (cnt != 6) {
                if (x1 == 19) {
                    break;
                }
                if (y1 == 19) {
                    break;
                }
                if (table[x1][y1] != table[x][y]) {
                    break;
                }
                x1++;
                y1++;
                cnt++;
            }
            if (cnt == 5) {
                if (x >= 1 && y >= 1) {
                    if (table[x][y] == table[x - 1][y - 1]) {
                        continue;
                    }
                }
                System.out.println(table[x][y]);
                System.out.println((x + 1) + " " + (y + 1));
                return;
            }
            // 대각 왼쪽으로 x 감소 y 증가
            cnt = 0;
            x1 = x;
            y1 = y;
            while (cnt != 6) {
                if (x1 == 19) {
                    break;
                }
                if (y1 < 0) {
                    break;
                }
                if (table[x1][y1] != table[x][y]) {
                    break;
                }
                x1++;
                y1--;
                cnt++;
            }
            if (cnt == 5) {
                if (x >= 1 && y >= 1) {
                    if (table[x][y] == table[x - 1][y + 1]) {
                        continue;
                    }
                }
                System.out.println(table[x][y]);
                System.out.println((x1) + " " + (y1 + 2));
                return;
            }
            if (queue.size() < 5) {
                break;
            }
        }
        System.out.println(0);
    }
}