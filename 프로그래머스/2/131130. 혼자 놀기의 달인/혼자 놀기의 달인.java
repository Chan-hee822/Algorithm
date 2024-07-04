import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;

        int start = 0;
        int cnt = 0;
        int cnt2 = 0;
        Set<Integer> integerSet = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y - x);
        while (cnt < cards.length) {
            int temp = start;
            int setSize = integerSet.size();
            integerSet.add(temp);
            if (setSize == integerSet.size()) {
                integerSet.clear();
                queue.add(setSize);
                cnt += setSize;
                for (int i = 0; i < cards.length; i++) {
                    if (cards[i] != 0) {
                        start = i;
                        break;
                    }
                }
                continue;
            }
            start = cards[start] - 1;
            cards[temp] = 0;
        }
        if (queue.size() >= 2) {
            int A = queue.poll();
            int B = queue.poll();
            answer = A * B;
        }

        return answer;
    }
}