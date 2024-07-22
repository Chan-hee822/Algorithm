import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int result = 0;
        for (int i = 0; i < N; i++) {
            Stack<Character> stack = new Stack<>();
            char[] word = br.readLine().toCharArray();
            for (char item : word) {

                if (stack.isEmpty()) {
                    stack.push(item);
                    continue;
                }

                if (stack.peek().equals(item)) {
                    stack.pop();
                } else {
                    stack.push(item);
                }
                continue;
            }
            if (stack.isEmpty()){
                result++;
            }
        }
        System.out.println(result);
    }
}