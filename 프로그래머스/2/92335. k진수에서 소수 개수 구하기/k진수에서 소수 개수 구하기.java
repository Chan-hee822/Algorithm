class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] s = turnToK(n, k).split("0");
        for (int i = 0; i < s.length; i++) {
            String s1 = s[i];
            if (s1.equals("")) {
                continue;
            }
            long a = Long.parseLong(s1);
            boolean prime = isPrime(a);
            if (prime && !s1.contains("0")) {
                answer++;
            }
        }
        return answer;
    }
    // 진수 변환
    public static String turnToK(int num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num / k != 0) {
            sb.append(num % k);
            num = num / k;
        }
        sb.append(num % k);
        return sb.reverse().toString();
    }
    // 체
    public static boolean isPrime(long num) {
        if (num < 2L) return false;
        for (Long i = 2L; i * i <= num; i++) {
            if (num % i == 0L) return false;
        }
        return true;
    }
}