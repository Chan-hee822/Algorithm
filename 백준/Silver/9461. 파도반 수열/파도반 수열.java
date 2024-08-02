import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();

            if (N <= 3) {
                System.out.println(1);
                continue;
            }
            long[] dp = new long[N];

            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 1;

            for (int j = 3; j < N ; j++) {
                dp[j] = dp[j - 2] + dp[j - 3];
            }

            System.out.println(dp[N -1]);
        }

    }
}