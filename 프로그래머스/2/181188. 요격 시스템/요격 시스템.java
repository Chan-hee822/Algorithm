import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        double max = -1;
        for (int i = 0; i < targets.length; i++) {

            int start = targets[i][0];
            int end = targets[i][1];
            if(start >= max) {
                max = end;
                answer++;
            }
        }
        return answer;
    }
}