import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        if (N == 1 || N == 2 || N == 4) {
            System.out.println(-1);
        } else if (N == 3 || N == 5) {
            System.out.println(1);
        } else {
            int[] dp = new int[N + 1];
            dp[1] = dp[2] = dp[4] = -1;
            dp[3] = dp[5] = 1;

            for (int i = 6; i <= N ; i++) {
                int diff3 = i - 3;
                int diff5 = i - 5;
                if (diff3 > 0 ) {
                    if (dp[diff3] != -1) {
                        diff3 = dp[3] + dp[diff3];
                    } else {
                        diff3 = Integer.MAX_VALUE;
                    }
                } else {
                    diff3 = Integer.MAX_VALUE;
                }
                if (diff5 > 0) {
                    if (dp[diff5] != -1) {
                        diff3 = dp[5] + dp[diff5];
                    } else {
                        diff5 = Integer.MAX_VALUE;
                    }
                }else {
                    diff5 = Integer.MAX_VALUE;
                }

                if (diff3 == Integer.MAX_VALUE && diff5 == Integer.MAX_VALUE) {
                    dp[i] = -1;
                } else {
                    dp[i] = Math.min(diff3, diff5);
                }
            }
            System.out.println(dp[N]);
        }
    }
}