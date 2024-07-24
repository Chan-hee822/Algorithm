import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split("");

        Stack<String> frontStack = new Stack<>();
        Stack<String> backStack = new Stack<>();
        Collections.addAll(frontStack, strArr);

        int M = Integer.parseInt(br.readLine());

        int pointer = frontStack.size() - 1;

        // abcd
        // dcba 0
        // cba d
        for (int i = 0; i < M; i++) {
            String[] orders = br.readLine().split(" ");
            String order = orders[0];

            if (order.equals("L")) {
                if (frontStack.isEmpty()) {
                    continue;
                }
                backStack.push(frontStack.pop());
                continue;
            }

            if (order.equals("D")) {
                if (backStack.isEmpty()) {
                    continue;
                }
                frontStack.push(backStack.pop());
                continue;
            }

            if (order.equals("B")) {
                if (frontStack.isEmpty()) {
                    continue;
                }
                frontStack.pop();
                continue;
            }

            if (order.equals("P")) {
                frontStack.push(orders[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : frontStack) {
            sb.append(s);
        }
        while (!backStack.isEmpty()) {
            sb.append(backStack.pop());
        }

        System.out.println(sb.toString());
    }
}
