import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Deque<String> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String[] orders = br.readLine().split(" ");
            String order = orders[0];
            switch (order) {
                case "push_back" :
                    dq.add(orders[1]);
                    break;
                case "push_front" :
                    dq.addFirst(orders[1]);
                    break;
                case "front" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(dq.peek()).append('\n');
                    break;
                }
                case "back" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(dq.peekLast()).append('\n');
                    break;
                }
                case "size" : {
                    sb.append(dq.size()).append('\n');
                    break;
                }
                case "empty" : {
                    if (dq.isEmpty()) {
                        sb.append(1).append('\n');
                        continue;
                    }
                    sb.append(0).append('\n');
                    break;
                }
                case "pop_front" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(dq.poll()).append('\n');
                    break;
                }
                case "pop_back" : {
                    if (dq.isEmpty()) {
                        sb.append(-1).append('\n');
                        continue;
                    }
                    sb.append(dq.pollLast()).append('\n');
                    break;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
