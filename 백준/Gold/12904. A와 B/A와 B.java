import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        String after = br.readLine();

        Deque<String> dq = new LinkedList<>();
        Collections.addAll(dq, after.split(""));
        boolean flag = false;
        while (before.length() != dq.size()) {
            if (!flag) {
                String poll = dq.pollLast();
                if (poll.equals("A")) {
                    continue;
                }
                flag = true;
                continue;
            }
            String poll = dq.poll();
            if (poll.equals("A")) {
                continue;
            }
            flag = false;
        }
        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.poll());
        }
        after = flag ? sb.reverse().toString()
                : sb.toString();
        System.out.println(before.equals(after) ? 1 : 0);

    }
}