import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 로직 설명:
         * 1. 입력 처리: 입력된 괄호 문자열을 읽어와서 한 글자씩 배열로 분리
         * 2. 스택을 이용한 괄호 계산:
         *     - 여는 괄호 '(' 또는 '[' : 스택에 push.
         *     - 닫는 괄호 ')' 또는 ']' :
         *         - 스택에 pop -> 괄호 쌍 확인.
         *         - 해당 괄호 쌍 계산 후 스택에 push.
         *     - 괄호 쌍 개수 체크를 위해 push 할 때 cnt++, pop 할 때 cnt--
         * 3. 최종 결과 계산 및 출력:
         *      - 스택에 남아있는 값을 모두 더하여 최종 값 출력.
         *      - 잘못된 괄호 구조가 있을 경우 0 출력.
         *         - cnt == 0 아니면 올바른 것 X.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split("");

        Stack<String> stack = new Stack<>();

        int cnt = 0; // 여는 괄호의 개수를 세기 위한 변수 초기화
        for (String s : strArr) {
            if (s.equals("(") || s.equals("[")) {
                stack.add(s); // 여는 괄호 '(' 또는 '['를 스택에 추가
                cnt++;
                continue;
            }
            cnt--;
            if (s.equals(")")) {
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("[")) {
                        System.out.println(0); // 괄호 쌍이 맞지 않으면 0을 출력하고 종료
                        return;
                    }
                    if (pop.equals("(")) {
                        stack.add(String.valueOf(sum == 0 ? 2 : sum * 2)); // 괄호 안 비어있으면 2 아니면 (해당 수 * 2)
                        break;
                    }
                    sum += Integer.parseInt(pop); // 스택에서 꺼낸 숫자를 합산
                }
            } else if (s.equals("]")) {
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) {
                        System.out.println(0); // 괄호 쌍이 맞지 않으면 0을 출력하고 종료
                        return;
                    }
                    if (pop.equals("[")) {
                        stack.add(String.valueOf(sum == 0 ? 3 : sum * 3)); // 괄호 안 비어있으면 3 아니면 (해당 수 * 3)
                        break;
                    }
                    sum += Integer.parseInt(pop); // 스택에서 꺼낸 숫자를 합산
                }
            }
        }

        int result = 0;
        while (!stack.isEmpty()) {
            String pop = stack.pop();
            if (cnt != 0) { // 여는 괄호와 닫는 괄호의 개수가 맞지 않으면
                System.out.println(0); // 0을 출력
                return;
            }
            result += Integer.parseInt(pop); // 스택에 남은 모든 숫자를 더하여 최종 결과를 계산
        }
        System.out.println(result);
    }
}