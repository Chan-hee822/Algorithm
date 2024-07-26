import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> rpq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> lpq = new PriorityQueue<>(Comparator.reverseOrder());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp > 0) {
                rpq.add(temp);
            } else {
                lpq.add(temp * -1);
            }
        }

        int rightMax = !rpq.isEmpty() ? rpq.peek() : 0;
        int leftMax = !lpq.isEmpty() ? lpq.peek() : 0;
        int result = 0;
        if (rightMax >= leftMax) {

            result += getResult(lpq, M);

            int cnt = M - 1;
            result += rpq.poll();
            while (cnt > 0 && !rpq.isEmpty()) {
                rpq.poll();
                cnt--;
            }

            result += getResult(rpq, M);
        } else {

            result += getResult(rpq, M);

            int cnt = M - 1;
            result += lpq.poll();
            while (cnt > 0 && !lpq.isEmpty()) {
                lpq.poll();
                cnt--;
            }

            result += getResult(lpq, M);
        }
        System.out.println(result);
    }

    private static int getResult(PriorityQueue<Integer> pq, int M) {
        int cnt;
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += (pq.poll() * 2);
            cnt = M - 1;
            while (cnt > 0 && !pq.isEmpty()) {
                pq.poll();
                cnt--;
            }
        }
        return sum;
    }
}