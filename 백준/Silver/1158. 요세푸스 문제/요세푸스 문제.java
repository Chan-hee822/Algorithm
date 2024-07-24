import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> leftQueue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            leftQueue.add(i);
        }

        int idx = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!leftQueue.isEmpty()) {
            if (idx % K == 0) {
                sb.append(leftQueue.poll()).append(", ");
                idx++;
                continue;
            }
            leftQueue.add(leftQueue.poll());
            idx++;
        }
        String substring = sb.substring(0, sb.length() - 2);
        System.out.println(substring + ">");
    }
}