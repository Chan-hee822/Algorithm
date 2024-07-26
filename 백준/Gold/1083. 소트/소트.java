import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        // 70 60 50 40 30 10 , 6
        // 99 98 1 3 5 2 4 , 2
        int S = Integer.parseInt(br.readLine());
        int start = 0;
        while (start < N && S > 0) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> b[0] - a[0]);
            for (int i = start; i < Math.min(N, start + S + 1); i++) {
                pq.add(new int[]{arr[i], i});
            }
            int idx = pq.peek()[1];
            if (idx == start) {
                start++;
                continue;
            }
            int temp = arr[idx];
            arr[idx] = arr[idx - 1];
            arr[idx - 1] = temp;
            S--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}