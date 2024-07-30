import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y) {
                stack.pop();
                result++;
            }

            if (stack.isEmpty() || stack.peek() < y) {
                stack.push(y);
            }
        }

        while (!stack.isEmpty() && stack.peek() > 0) {
            stack.pop();
            result++;
        }

        System.out.println(result);
    }
}