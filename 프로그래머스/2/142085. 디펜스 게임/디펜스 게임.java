import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int length = enemy.length;

        PriorityQueue<Integer> queue = new PriorityQueue<>();

//        for (int i = 0; i < k; i++) {
//            queue.add(enemy[i]);
//        }

        for (int j : enemy) {
            int enemyCnt = j;
            if (k > 0) {
                k--;
                queue.add(enemyCnt);
                answer++;
                continue;
            }
            if (enemyCnt > queue.peek()) {
                queue.add(enemyCnt);
                enemyCnt = queue.poll();
            }
            if (n >= enemyCnt) {
                n -= enemyCnt;
            } else {
                break;
            }
            answer++;
        }

        return answer;
    }
}