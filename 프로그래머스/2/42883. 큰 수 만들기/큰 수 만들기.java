import java.util.Stack;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            char digit = number.charAt(i);
            // 스택이 비어 있지 않고, 제거할 k가 남아 있으며,
            // 스택의 최상단 값이 현재 숫자보다 작을 때 제거
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // k개의 수를 모두 제거하지 못한 경우, 남은 수 만큼 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // 스택을 문자열로 변환
        StringBuilder sb = new StringBuilder();
        for (Character ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}