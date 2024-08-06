import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[][] distance = new int[v][v];

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE / 2;
                }
            }
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            distance[start - 1][end - 1] = 1;
        }

        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < v; i++) {
            int result = 0;
            for (int j = 0; j < v; j++) {
                int cnt = distance[j][i];
                if (cnt != 0 && cnt != Integer.MAX_VALUE / 2) {
                    result++;
                }
            }
            for (int cnt : distance[i]) {
                if (cnt != 0 && cnt != Integer.MAX_VALUE / 2) {
                    result++;
                }
            }
            if (result == (v - 1)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}