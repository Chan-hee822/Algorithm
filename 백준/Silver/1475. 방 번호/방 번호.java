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

        String[] N = st.nextToken().split("");

        Map<String, Integer> map = new HashMap<>();

        for (String s : N) {
            if (s.equals("9")) {
                if (!map.containsKey("6")) {
                    map.put("6", 1);
                    continue;
                }
                map.put("6", map.get("6") + 1);
                continue;
            }
            if (!map.containsKey(s)) {
                map.put(s, 1);
                continue;
            }
            map.put(s, map.get(s) + 1);
        }
        if (map.containsKey("6")) {
            map.put("6", (int) Math.ceil((double) map.get("6") / 2));
        }
        int result = map.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList()).get(0);
        System.out.println(result);
    }
}
