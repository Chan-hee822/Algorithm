import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] distance = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        while (true) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            if (start == -1) {
                break;
            }
            int end = Integer.parseInt(st.nextToken());
            distance[start - 1][end - 1] = 1;
            distance[end - 1][start - 1] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int cnt = 1;
        for (int[] dist : distance) {
            int maxD = Arrays.stream(dist).max().getAsInt();
            pq.add(new int[]{maxD, cnt});
            cnt++;
        }
        StringBuilder sb = new StringBuilder();
        cnt = 0;
        int max = pq.peek()[0];
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            if (poll[0] == max) {
                cnt++;
                sb.append(poll[1]).append(" ");
            } else {
                break;
            }
        }
        System.out.println(max + " " + cnt);
        System.out.println(sb);
    }
}