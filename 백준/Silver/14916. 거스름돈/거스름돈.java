import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 1 || n == 3) {
            System.out.println(-1);
            return;
        }

        if (n == 2 || n == 5) {
            System.out.println(1);
            return;
        }

        if (n == 4) {
            System.out.println(2);
            return;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
            int a = i - 5;
            if (dp[a] != 0 && dp[a] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[a] + 1, dp[i]);
            }
            a = i - 2;
            if (dp[a] != 0 && dp[a] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[a] + 1, dp[i]);
            }
        }

        System.out.println(dp[n] == 0 || dp[n] == Integer.MAX_VALUE ? -1 : dp[n]);
    }
}