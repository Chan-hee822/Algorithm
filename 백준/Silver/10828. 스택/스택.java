import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            String[] orders = br.readLine().split(" ");
            String order = orders[0];

            if (order.equals("push")) {
                stack.push(orders[1]);
                continue;
            }

            if (order.equals("top")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.peek());
                continue;
            }

            if (order.equals("size")) {
                System.out.println(stack.size());
                continue;
            }

            if (order.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println(1);
                    continue;
                }
                System.out.println(0);
                continue;
            }

            if (order.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println(-1);
                    continue;
                }
                System.out.println(stack.pop());
            }
        }
    }
}