import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * dp 사용해서 풀이
         * 원하는 수는 = x + (3,5)
         * dp[원하는 수] = dp[3,5] + dp[x];
         * d[x]은 이전에 저장한 값;
         * 3, 5 중 최소값을 저장, 만들 수 없으면 -1 저장
         * 1 - 5 까지는 미리 저장 6부터, 원하는 수까지 차례대로 저장하면서 계산
         */
        int N = Integer.parseInt(st.nextToken());

        // 만들 수 없기 때문에 -1
        if (N == 1 || N == 2 || N == 4) {
            System.out.println(-1);
        // 한 번이면 끝나는 수
        } else if (N == 3 || N == 5) {
            System.out.println(1);
        // 6부터 N까지 차래대로 저장하면서 계산
        } else {
            int[] dp = new int[N + 1];
            // 초기 값 설정
            dp[1] = dp[2] = dp[4] = -1;
            dp[3] = dp[5] = 1;
            // 6부터 계산 시작
            for (int i = 6; i <= N ; i++) {
                // 3을 뺀 값
                int diff3 = i - 3;
                int diff5 = i - 5;
                // 6 = 3 + 3
                // dp[6] = dp[3] + dp[3]
                if (diff3 > 0 ) {
                    if (dp[diff3] != -1) {
                        diff3 = dp[3] + dp[diff3];
                    } else {
                        diff3 = Integer.MAX_VALUE;
                    }
                }
                // dp[6] = dp[5] + dp[1]
                if (diff5 > 0) {
                    if (dp[diff5] != -1) {
                        diff3 = dp[5] + dp[diff5];
                    } else {
                        // dp[1] = -1 이기 때문에 저장 안 하기 위해 큰 값으로
                        diff5 = Integer.MAX_VALUE;
                    }
                }
                // dp[차이 값] 둘다 -1 인 경우 -> 딱 나누어 떨어지지 않음
                if (diff3 == Integer.MAX_VALUE && diff5 == Integer.MAX_VALUE) {
                    dp[i] = -1;
                // 두 수 사용해서 수 만들 수 있는 경우     
                } else {
                    dp[i] = Math.min(diff3, diff5);
                }
            }
            System.out.println(dp[N]);
        }
    }
}
