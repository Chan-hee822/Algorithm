import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] charArray = br.readLine().replaceAll(" ", "").toCharArray();

            Deque<Character> deque = new LinkedList<>();

            deque.add(charArray[0]);

            for (int j = 1; j < N; j++) {
                char temp = charArray[j];
                if (deque.peek() < temp) {
                    deque.add(temp);
                } else {
                    deque.addFirst(temp);
                }
            }

            for (int j = 0; j < N; j++) {
                sb.append(deque.poll());
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}