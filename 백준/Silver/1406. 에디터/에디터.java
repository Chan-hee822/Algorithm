import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 2개 Stack을 사용해서 풀이
         * 커서 움직 임에 따라 2개의 스택에 push or pop
         * 커서 좌우에 어떤 글자가 있는지 스택으로 판별
         * 시작 : 처음에 모든 글자 1번 스택에 push
         * 커서가 왼쪽으로 움직이면 1번 스택 최상단 요소 2번 스택으로 push
         * 커서 오른쪽으로 움직이면 2번 스택 pop 1번 스택으로 push
         * ex ) 입력 : abcd -> 1번 스택 : dcba / 2번 스택 : ""
         *      왼쪽으로 2칸 -> 1번 스택 : cba / 2번 스택 : d
         * 커서 왼쪽 글자 제거시 1번 스택 pop
         * 커서 왼쪽에 글자 삽입시 1번 스택에 push
         * ex ) 커서 왼쪽 글자 삭제 -> 1번 스택 : ba / 2번 스택 : d
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split("");

        Stack<String> frontStack = new Stack<>();
        Stack<String> backStack = new Stack<>();
        Collections.addAll(frontStack, strArr);

        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            String[] orders = br.readLine().split(" ");
            String order = orders[0];
            // 커서 왼쪽으로 한 칸
            if (order.equals("L")) {
                // 끝지점 변환 x
                if (frontStack.isEmpty()) {
                    continue;
                }
                // 커서 왼쪽으로 이동시 커서 오른쪽에 글자 하나 추가
                backStack.push(frontStack.pop());
                continue;
            }
            // 커서 오른쪽으로 한 칸
            if (order.equals("D")) {
                // 끝 지점 변화 x
                if (backStack.isEmpty()) {
                    continue;
                }
                // 오른쪽으로 이동시 커서 왼쪽에 글자 하나 추가
                frontStack.push(backStack.pop());
                continue;
            }
            // 커서 왼쪽 글자 삭제
            if (order.equals("B")) {
                if (frontStack.isEmpty()) {
                    continue;
                }
                // 커서 왼쪽 글자 하나 삭제
                frontStack.pop();
                continue;
            }
            // 커서 왼쪽 글자 추가
            if (order.equals("P")) {
                // 커서 왼쪽 글자 하나 추가
                frontStack.push(orders[1]);
            }
        }
        StringBuilder sb = new StringBuilder();
        // 입력 순서 보장 위해 향상된 포문으로 (꺼꾸로 담고 있기 때문)
        for (String s : frontStack) {
            sb.append(s);
        }
        // 
        while (!backStack.isEmpty()) {
            sb.append(backStack.pop());
        }

        System.out.println(sb.toString());
    }
}