import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String state = st.nextToken();
            if (!map.containsKey(name)) {
                map.put(name, 1);
                continue;
            }
            map.remove(name);
        }

        List<String> l = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i = l.size() - 1; i >= 0; i--) {
            System.out.println(l.get(i));
        }
    }
}