import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] applicants = new int[N][2];
            StringTokenizer st;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                applicants[j][0] = Integer.parseInt(st.nextToken());
                applicants[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(applicants, (a, b) -> a[0] - b[0]);
            int cnt = 0;
            int pre = applicants[0][1];
            for (int j = 1; j < N; j++) {
                int cur = applicants[j][1];
                if (pre < cur) {
                    cnt++;
                } else {
                    pre = cur;
                }
            }
            sb.append(N - cnt).append('\n');
//            System.out.println(N - cnt);
        }
        System.out.println(sb.toString());
    }
}