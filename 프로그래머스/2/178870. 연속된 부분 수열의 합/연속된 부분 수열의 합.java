class Solution {
    public int[] solution(int[] sequence, int k) {
        /**
         * two pointer로 문제 해결
         * p1, p2 모두 0에서 시작
         * p1을 먼저 왼쪽에서 오른쪽으로 이동하면서 합한 후 목표인 k와 같아지거나 커질 때까지 이동
         * 합이 k와 같다면 p1과 p2를 저장
         * 합이 크다면 p2를 오른쪽으로 이동하고 p2였던 값을 제거
         */
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int[] answer = new int[2];
        boolean firstInsert = false;
        while (true) {
            if (p1 <= sequence.length - 1 && sum < k) {
                // p1 오른쪽으로 이동하면서 값 더하기
                sum += sequence[p1++];
            } else if (p2 == sequence.length) {
                // p2 가 배열 끝 까지 도달하면 멈춤
                break;
            } else {
                // 합이 k보다 클경우 합에서 해당 값을 빼 준 후 p2를 오른쪽이로 이동
                sum -= sequence[p2++];
            }
            int[] result = new int[2];
            if (sum == k) {
                result[0] = p2;
                result[1] = p1 - 1;
                // 맨 처음 값을 넣어줌
                if (!firstInsert) {
                    answer[0] = result[0];
                    answer[1] = result[1];
                    firstInsert = true;
                    continue;
                }
                // 이전의 조건을 만족하는 좌표와 후에 좌표를 만족하는 좌표 길이 비교
                int diffA = answer[1] - answer[0];
                int diffR = p1 - 1 - p2;
                if (diffR < diffA) {
                    answer[0] = p2;
                    answer[1] = p1 - 1;
                }
            }
        }
        return answer;
    }
}