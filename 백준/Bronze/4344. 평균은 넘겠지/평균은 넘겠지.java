import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        String[] result = new String[C];
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scoreArr = new int[N];
            int total = 0;
            for (int j = 0; j < N; j++) {
                scoreArr[j] = Integer.parseInt(st.nextToken());
                total += scoreArr[j];
            }
            double avg = (double) total / N;
            Arrays.sort(scoreArr);
            int cnt = 0;
            for (int j = N -1; j >= 0; j--) {
                if (avg < scoreArr[j]) {
                    cnt++;
                }
            }
            avg = (double) cnt * 100 / N;
            result[i] = String.format("%.3f", avg) + "%";
        }
        for (int i = 0; i < C; i++) {
            System.out.println(result[i]);
        }
    }
}