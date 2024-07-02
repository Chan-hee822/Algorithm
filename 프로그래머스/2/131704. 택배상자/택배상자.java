import java.util.Stack;

class Solution {
        public int solution(int[] order) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int idx = 0;
        for (int i = 1; i <= order.length; i++) {
            boolean check = false;
            if (order[idx] == i) {
                idx++;
                answer++;
                check = true;
            }
            while (!stack.isEmpty() && stack.peek() == order[idx]) {
                stack.pop();
                answer++;
                idx++;
                check = true;
            }

            if (!check) {
                stack.push(i);
            }
        }

        return answer;
    }
}