import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //  주사위 눈   눈 개수
        Map<Integer, Integer> map = new HashMap<>();

        int A = 0;
        for (int i = 0; i < 3; i++) {
            int N = Integer.parseInt(st.nextToken());
            A = N;
            if (!map.containsKey(N)) {
                map.put(N, 1);
            } else {
                map.put(N, map.get(N) + 1);
            }
        }

        int size = map.size();
        int result = 0;
        if (size == 3) {
            result = map.keySet().stream().max(Integer::compareTo).get();
            System.out.println(result * 100);
        } else if (size == 2) {
            result = map.entrySet().stream().sorted((a, b) -> b.getValue() - a.getValue()).collect(Collectors.toList()).get(0).getKey();
            System.out.println(result * 100 + 1000);
        } else {
            result = A;
            System.out.println(result * 1000 + 10000);
        }
    }
}
