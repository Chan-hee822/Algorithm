import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
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

        Map<Long, Long> mapA = new HashMap<>();
        Map<Long, Long> mapB = new HashMap<>();

        makePart(arrA, T, mapA);
        makePart(arrB, T, mapB);

        long result = 0;
        for (Map.Entry<Long, Long> item : mapA.entrySet()) {
            long a = item.getKey();
            long countA = item.getValue();
            long diff = T - a;
            if (mapB.containsKey(diff)) {
                long countB = mapB.get(diff);
                result += countA * countB;
            }
        }
        System.out.println(result);
    }

    private static void makePart(int[] arr, long T, Map<Long, Long> map) {
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