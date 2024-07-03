class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for (long x = 0; x <= d; x += k) {
            long Y = (long) Math.sqrt((long)d * d - x * x);
            answer += (Y / k) + 1;
        }
        return answer;
    }
}