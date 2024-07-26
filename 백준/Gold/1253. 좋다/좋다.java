import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Arrays.sort(arr);
        int result = 0;
        for (int i = 0; i < N; i++) {
            long target = arr[i];
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                
                if (arr[j] == 0) {
                    if (target == 0) {
                        if (map.get(target) > 2) {
                            result++;
                            break;
                        }
                    } else {
                        if (map.get(target) > 1) {
                            result++;
                            break;
                        }
                    }
                    continue;
                }
                
                long diff = target - arr[j];
                if (map.containsKey(diff)) {
                    if (diff == arr[j]) {
                        if (map.get(diff) > 1) {
                            result++;
                            break;
                        }
                        continue;
                    }
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}