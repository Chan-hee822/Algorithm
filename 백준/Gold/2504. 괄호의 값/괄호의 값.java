import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        // 차례 대로 넣기
        // 닫힘 만나면 숫자 넣기 ) *2 ] *3 해서 넣기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        int cnt = 0;
        for (String s : strArr) {
            if (s.equals("(") || s.equals("[")) {
                stack.add(s);
                cnt++;
                continue;
            }
            cnt--;
            if (s.equals(")")) {
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("[")) {
                        System.out.println(0);
                        return;
                    }
                    if (pop.equals("(")) {
                        if (sum == 0) {
                            stack.add(String.valueOf(2));
                        } else {
                            stack.add(String.valueOf(sum * 2));
                        }
                        break;
                    }
                    sum += Integer.parseInt(pop);
                }
            } else if (s.equals("]")) {
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) {
                        System.out.println(0);
                        return;
                    }
                    if (pop.equals("[")) {
                        if (sum == 0) {
                            stack.add(String.valueOf(3));
                        } else {
                            stack.add(String.valueOf(sum * 3));
                        }
                        break;
                    }
                    sum += Integer.parseInt(pop);
                }
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (cnt != 0) {
                System.out.println(0);
                return;
            }
            result += Integer.parseInt(pop);
        }
        System.out.println(result);
    }
}