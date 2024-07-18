import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(A, 1);

        List<Integer> list = new ArrayList<>();
        list.add(A);

        int idx = 0;

        while (true) {
            int sum = 0;
            while (A > 0) {
                sum += Math.pow((A % 10), P);
                A /= 10;
            }
            A = sum;
            if (!map.containsKey(A)) {
                map.put(A, 1);
                list.add(A);
                idx++;
                continue;
            }
            if (map.get(A) == 2) {
                break;
            }
            map.put(A, map.get(A) + 1);
        }

        int result = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) {
                result++;
            }
        }

        System.out.println(result);
    }
}