import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String file = st.nextToken().split("\\.")[1];
            map.put(file, map.getOrDefault(file, 0) + 1);
        }

        int size = map.size();
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Integer> item : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(item.getKey()).append(" ").append(item.getValue());
            list.add(sb.toString());
        }

        list = list.stream().sorted().collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String f : list) {
            sb.append(f).append('\n');
        }
        System.out.println(sb);
    }
}