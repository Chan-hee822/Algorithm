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
            String book = st.nextToken();
            map.put(book, map.getOrDefault(book, 0) + 1);
        }

        List<String> list = map.entrySet()
                .stream().sorted((a, b)
                        -> Objects.equals(a.getValue(), b.getValue())
                        ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(list.get(0));
    }
}