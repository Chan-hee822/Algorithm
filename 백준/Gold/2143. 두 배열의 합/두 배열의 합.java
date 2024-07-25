import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 1. 목표 (T) 입력
         * 2. 배열 A의 크기와 요소들을 입력
         * 3. 배열 B의 크기와 요소들을 입력
         * 4. 배열 A와 B의 모든 부분합을 계산 후 각각 이 몇 번 등장하는지 map에 저장
         *    key - 부분 합, value - 그 개수
         * 5. 배열 A의 부분합과 배열 B의 부분합을 더하여 목표 합 T가 되는 경우의 수를 계산
         *    map A 순회 -> T = map A key + map B Key
         *    diff = T - map A key -> diff 로 map B가 key로 가지고 있느지 체크
         * 6. 각 경우의 수를 누적하여 결과를 출력합니다.
         *    map B가 키를 가지고 있을 때 - map A value * map B value 결과에 더함
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());

        int A = Integer.parseInt(br.readLine());
        int[] arrA = new int[A];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        int B = Integer.parseInt(br.readLine());
        int[] arrB = new int[B];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < B; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A와 B의 부분합을 저장할 Map 초기화
        Map<Long, Long> mapA = new HashMap<>();
        Map<Long, Long> mapB = new HashMap<>();

        // 배열 A와 B의 부분합을 계산하여 Map에 저장
        makePart(arrA, mapA);
        makePart(arrB, mapB);

        long result = 0;
        // 배열 A의 각 부분합에 대해 배열 B에서 목표 합 T를 만들 수 있는 경우의 수 계산
        for (Map.Entry<Long, Long> item : mapA.entrySet()) {
            long a = item.getKey();
            long countA = item.getValue();
            long diff = T - a;
            if (mapB.containsKey(diff)) {
                long countB = mapB.get(diff);
                result += countA * countB;
            }
        }
        // 최종 결과 출력
        System.out.println(result);
    }

    // 배열의 부분합을 계산하여 Map에 저장하는 함수
    private static void makePart(int[] arr, Map<Long, Long> map) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            long sum = 0;
            for (int j = i; j < size; j++) {
                sum += arr[j];
                map.put(sum, map.getOrDefault(sum, 0L) + 1L);
            }
        }
    }
}