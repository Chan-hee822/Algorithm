import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            long[] parts = new long[K];
            PriorityQueue<Long> pq = new PriorityQueue<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                long temp = Long.parseLong(st.nextToken());
                parts[j] = temp;
                pq.add(temp);
            }

            long result = 0;
            while (pq.size() > 1) {
                long first = pq.poll();
                long second = pq.poll();
                result += (first + second);
                pq.add(first + second);
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}