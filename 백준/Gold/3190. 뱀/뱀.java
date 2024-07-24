import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int appleCount = Integer.parseInt(br.readLine());

        int[][] table = new int[N + 1][N + 1];

        for (int i = 0; i < appleCount; i++) {
            String[] point = br.readLine().split(" ");
            // 사과 위치 갱신
            table[Integer.parseInt(point[0])][Integer.parseInt(point[1])] = 1;
        }

        boolean[][] bam = new boolean[N + 1][N + 1];
        int x = 1, y = 1;
        bam[x][y] = true;
        Deque<int[]> dq = new LinkedList<>();
        dq.add(new int[]{1, 1});

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int idxDirection = 0;

        int orderCount = Integer.parseInt(br.readLine());

        int result = 1;
        int sec = 0;
        for (int i = 0; i < orderCount; i++) {
            String[] order = br.readLine().split(" ");
            int time = Integer.parseInt(order[0]);
            sec = time - sec;
            int cnt = sec;
            while (cnt > 0) {
                x += dx[idxDirection];
                y += dy[idxDirection];

                if (x == 0 || x == N + 1 || y == 0 || y == N + 1) {
                    System.out.println(result);
                    return;
                }

                if (table[x][y] == 1) {
                    table[x][y] = 0;
                    bam[x][y] = true;
                    dq.add(new int[]{x, y});
                    cnt--;
                    result++;
                    continue;
                }

                if (bam[x][y]) {
                    System.out.println(result);
                    return;
                }

                int[] tail = dq.poll();
                bam[tail[0]][tail[1]] = false;

                dq.add(new int[]{x, y});
                bam[x][y] = true;
                cnt--;
                result++;
            }

            String direction = order[1]; // L(왼) , D (오른)
            if (direction.equals("L")) {
                idxDirection = (idxDirection - 1 + 4) % 4;
            } else {
                idxDirection = (idxDirection + 1) % 4;
            }
            sec = time;
        }

        while (true){
            x += dx[idxDirection];
            y += dy[idxDirection];
            if (x == 0 || x == N + 1 || y == 0 || y == N + 1) {
                System.out.println(result);
                return;
            }
            if (bam[x][y]) {
                System.out.println(result);
                return;
            }
            dq.add(new int[]{x ,y});
            bam[x][y] = true;
            bam[x - dx[idxDirection]][y - dy[idxDirection]] = false;
            result++;
            dq.poll();
        }
    }
}