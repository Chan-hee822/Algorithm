import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) throws IOException {

        /**
         *  dfs 순열 만들기
         *  사용한 숫자 visited 배열로 체크
         *  사용할 숫자 true, 사용 끝나면 false
         *  result 배열을 사용해서 순열 출력
         *  depth를 index로 result 배열에 순열 저장
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 재료 개수
        N = Integer.parseInt(st.nextToken());
        // 깊이
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[M];
        dfs(0);
    }

    private static void dfs(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
