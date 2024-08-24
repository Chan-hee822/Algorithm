import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int size = N * 4 + 1;
        String[] arr = new String[size];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        // 최상위 부모
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            String L = st.nextToken();
            map.put(L, i + 1);
            map2.put(i + 1, L);
        }
        // 그다음 부터
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int mother = map.get(st.nextToken());
            for (int j = 0; j < 2; j++) {
                String L = st.nextToken();
                int idx = mother * 2 + j;
                map.put(L, idx);
                map2.put(idx, L);
            }
        }
        System.out.println(pre(map2, new StringBuilder(), 1));
        System.out.println(inOrder(map2, new StringBuilder(), 1));
        System.out.println(postOrder(map2, new StringBuilder(), 1));

    }

    private static String pre(Map<Integer, String> map, StringBuilder sb, int start) {
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        sb.append(map.get(start));
        pre(map, sb, start * 2);
        pre(map, sb, start * 2 + 1);

        return sb.toString();
    }

    private static String inOrder(Map<Integer, String> map, StringBuilder sb, int start) {
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        inOrder(map, sb, start * 2);
        sb.append(map.get(start));
        inOrder(map, sb, start * 2 + 1);
        return sb.toString();
    }

    private static String postOrder(Map<Integer, String> map, StringBuilder sb, int start) {
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        postOrder(map, sb, start * 2);
        postOrder(map, sb, start * 2 + 1);
        sb.append(map.get(start));
        return sb.toString();
    }
}