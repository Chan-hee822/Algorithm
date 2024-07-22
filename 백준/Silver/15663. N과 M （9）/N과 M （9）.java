import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static boolean[] visited;
    static int[] result;
    static int[] numArr;
    static Set<String> set;

    public static void main(String[] args) throws IOException {

        /**
         *  dfs 순열 만들기
         *  사용한 숫자 visited 배열로 체크
         *  사용할 숫자 true, 사용 끝나면 false
         *  TreeSet을 사용해서 순열 출력
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 재료 개수
        N = Integer.parseInt(st.nextToken());
        // 깊이
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        result = new int[M];

        numArr = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();

        set = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        dfs(0, answer);
        System.out.println(answer.toString());
    }

    private static void dfs(int depth, StringBuilder answer) {
        if (depth == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                answer.append(sb).append('\n');
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = numArr[i];
                dfs(depth + 1, answer);
                visited[i] = false;
            }
        }
    }
}