import java.util.Arrays;

class Solution {
    public int[] solution(int[] sequence, int k) {

        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] answer = new int[2];
        boolean firstInsert = false;
        while (true) {
            if (p1 <= sequence.length - 1 && sum < k) {
                sum += sequence[p1++];
            } else if (p2 == sequence.length) {
                break;
            } else {
                sum -= sequence[p2++];
            }
            int[] result = new int[2];
            if (sum == k) {
                result[0] = p2;
                result[1] = p1 -1;
                if (!firstInsert) {
                    answer[0] = result[0];
                    answer[1] = result[1];
                    firstInsert = true;
                    continue;
                }

                int diffA = answer[1] - answer[0];
                int diffR = p1 -1 -p2;
                if (diffR < diffA) {
                    answer[0] = p2;
                    answer[1] = p1 -1;
                } else if (diffR == diffA && answer[0] < result[0]) {

                }
            }
        }

        return answer;
    }
}