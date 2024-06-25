import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> basket = new Stack<>();
        HashMap<Integer, Integer> basketPoint = new HashMap<>();

        for (Integer move : moves) {
            move--;
            if (!basketPoint.containsKey(move)) {
                basketPoint.put(move, 0);
            }

            int[] select = board[move];

            for (int i = basketPoint.get(move); i < board.length; i++) {
                int pick = board[i][move];
                if (pick != 0) {
                    if (basket.isEmpty()) {
                        basket.push(pick);
                        basketPoint.put(move, i + 1);
                        break;
                    }

                    if (basket.peek() == pick) {
                        basket.pop();
                        answer += 2;
                    } else {
                        basket.push(pick);
                    }
                    basketPoint.put(move, i + 1);
                    break;
                }
            }
        }

        return answer;
    }
}