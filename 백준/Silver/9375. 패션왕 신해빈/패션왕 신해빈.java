import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 테스트 케이스의 수를 입력
         * 각 테스트 케이스 (c):
         *    의상 아이템의 수를 입력 (n)
         *    HashMap을 사용하여 각 카테고리의 아이템 개수 -> key : cat value : 개 수
         *    총 조합의 수 계산:
         *    - 각 카테고리에 대해, 아이템의 개수에 1을 더함(해당 카테고리에서 아이템을 선택하지 않는 경우를 고려).
         *    - 이 값들을 모두 곱함
         *    아무것도 선택하지 않는 경우를 제외하기 위해 총 조합의 수에서 -1
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for (int i = 0; i < c; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> categoryMap = new HashMap<>();

            // 각 카테고리별 아이템 개수 카운팅
            for (int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                String category = input[1];
                categoryMap.put(category, categoryMap.getOrDefault(category, 0) + 1);
            }

            // 경우의 수 계산
            int combinations = 1;
            for (int count : categoryMap.values()) {
                combinations *= (count + 1); // 각 카테고리별로 아이템을 입지 않는 경우 포함
            }

            // 아무것도 입지 않은 경우는 제외
            System.out.println(combinations - 1);
        }
    }
}