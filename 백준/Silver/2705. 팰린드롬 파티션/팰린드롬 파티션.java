import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Arrays.stream(arr).max().getAsInt();

        int[] dp = new int[max + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;

        for (int i = 4; i <= max; i++) {
            for (int j = 0; j <= i; j++) {
                int diff = i - j;
                if (diff % 2 == 0) {
                    dp[i] += dp[diff / 2];
                }
            }
        }

        for (int result : arr) {
            System.out.println(dp[result]);
        }
    }
}