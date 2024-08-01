import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int minHeight = 300;
        int maxHeight = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;
                if (h < minHeight) {
                    minHeight = h;
                }
                if (h > maxHeight) {
                    maxHeight = h;
                }
            }
        }
        int resultTime = Integer.MAX_VALUE;
        int resultHeight = 0;
        for (int h = minHeight; h <= maxHeight; h++) {
            int b = B;
            int time = 0;
            int leaves = 0;
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    int curHeight = map[n][m];
                    if (curHeight > h) {
                        time += (curHeight - h) * 2;
                        b += curHeight - h;
                    } else if (curHeight < h) {
                        leaves += h - curHeight;
                    }
                }
            }
            if (b >= leaves) {
                time += leaves;
            } else {
                break;
            }
            if (resultTime >= time) {
                resultTime = time;
                resultHeight = h;
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}