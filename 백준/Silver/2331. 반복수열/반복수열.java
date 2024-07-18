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

        int idx = 1;
        Map<Integer, Integer> idxMap = new HashMap<>();
        idxMap.put(A, 0);
        while (true) {
            int sum = 0;
            while (A > 0) {
                sum += Math.pow((A % 10), P);
                A /= 10;
            }
            A = sum;
            if (!map.containsKey(A)) {
                map.put(A, 1);
                idxMap.put(A, idx++);
                list.add(A);
                continue;
            }
            idx = idxMap.get(A);
            break;
        }
        System.out.println(idx);
    }
}