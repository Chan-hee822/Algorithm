class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        // 4, 5, [1, 0, 3, 1, 2], [0, 3, 0, 4, 0] 16

        int idx = n - 1;    // n = 5
        int restPick = 0;
        int restBox = 0;
        for (int i = 0; i < n; i++) {
            restPick += deliveries[i];
            restBox += pickups[i];
        }
        while (idx >= 0) {
            if (deliveries[idx] == 0 && pickups[idx] == 0) {
                idx--;
                continue;
            }
            int cnt = Math.min(cap, restBox);
            restBox = getRest(deliveries, idx, restBox, cnt);
            cnt = cap;
            restPick = getRest(pickups, idx, restPick, cnt);
            answer += idx + idx + 2;
        }

        return answer;
    }

    private static int getRest(int[] deliveries, int idx, int restBox, int cnt) {
        if (restBox > 0) {
            for (int i = idx; i >= 0; i--) {
                int item = deliveries[i];
                if (item != 0) {
                    if (item > cnt) {
                        deliveries[i] -= cnt;
                        cnt = 0;
                    } else {
                        deliveries[i] = 0;
                        cnt -= item;
                    }
                }
                if (cnt == 0) {
                    break;
                }
            }
            restBox -= cnt;
        }
        return restBox;
    }
}