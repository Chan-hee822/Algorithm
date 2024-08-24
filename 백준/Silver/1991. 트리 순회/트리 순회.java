import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 로직 설명:
         * 1. 입력: 노드 수 N을 입력받고, 트리 정보를 저장할 두 개의 맵 초기화
         *    - map: 노드 이름을 키로 하고 해당 노드의 위치(인덱스)를 값으로 저장.
         *        - 순회 할 때 쓸 컬랙션을 만들기 위해.
         *    - map2: 위치(인덱스)를 키로 하고 해당 위치에 있는 노드 이름을 값으로 저장.
         *        - 순회할 때 인덱스로 검색 용이하게.
         * 2. 트리 구성: 루트 노드를 먼저 map과 map2에 저장한 후, 각 노드의 자식 노드 정보를 입력받아 트리 구성.
         *    - 각 노드는 부모 노드의 인덱스를 기준으로 왼쪽 자식은 부모 * 2, 오른쪽 자식은 부모 * 2 + 1 에 위치.
         *    - 계산하기 쉽게 root node는 1부터 시작.
         * 3. 순회 출력: 세 가지 순회 방식 (전위, 중위, 후위)을 사용하여 트리 탐색.
         *    - preOrder: 전위 순회 방식 - 중앙 왼 오
         *    - inOrder: 중위 순회 방식 - 왼 중앙 오
         *    - postOrder: 후위 순회 방식 - 왼 오 중앙
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        // 루트 노드 정보 저장
        for (int i = 0; i < 3; i++) {
            String L = st.nextToken();
            map.put(L, i + 1);
            map2.put(i + 1, L);
        }
        // 자식 노드로 트리 구성
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

        System.out.println(preOrder(map2, new StringBuilder(), 1));
        System.out.println(inOrder(map2, new StringBuilder(), 1));
        System.out.println(postOrder(map2, new StringBuilder(), 1));

    }

    private static String preOrder(Map<Integer, String> map, StringBuilder sb, int start) {
        // 전위 순회: 현재 노드를 먼저 방문한 후 왼쪽, 오른쪽 자식 순으로 방문
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        sb.append(map.get(start));  // 현재 노드 방문
        preOrder(map, sb, start * 2);  // 왼쪽 자식 방문
        preOrder(map, sb, start * 2 + 1);  // 오른쪽 자식 방문
        return sb.toString();
    }

    private static String inOrder(Map<Integer, String> map, StringBuilder sb, int start) {
        // 중위 순회: 왼쪽 자식을 먼저 방문한 후 현재 노드, 그리고 오른쪽 자식 방문
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        inOrder(map, sb, start * 2);  // 왼쪽 자식 방문
        sb.append(map.get(start));  // 현재 노드 방문
        inOrder(map, sb, start * 2 + 1);  // 오른쪽 자식 방문
        return sb.toString();
    }

    private static String postOrder(Map<Integer, String> map, StringBuilder sb, int start) {
        // 후위 순회: 왼쪽, 오른쪽 자식을 모두 방문한 후 현재 노드 방문
        if (map.get(start).isEmpty() || map.get(start).equals(".")) {
            return "";
        }
        postOrder(map, sb, start * 2);  // 왼쪽 자식 방문
        postOrder(map, sb, start * 2 + 1);  // 오른쪽 자식 방문
        sb.append(map.get(start));  // 현재 노드 방문
        return sb.toString();
    }
}