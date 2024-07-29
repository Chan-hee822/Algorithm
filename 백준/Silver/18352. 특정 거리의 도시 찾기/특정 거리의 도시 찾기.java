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
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] lists = new List[N + 1];
        for (int i = 0; i <= N ; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lists[start].add(end);
        }
        List<Integer> result = new ArrayList<>();

        bfs(lists, K, X, result);

        if (result.isEmpty()) {
            System.out.println(-1);
            return;
        }

        List<Integer> sortedList = result.stream().sorted().collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Integer num : sortedList) {
            sb.append(num).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void bfs(List<Integer>[] lists, int K, int X, List<Integer> result) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{X, 0});
//        int[] distances = new int[lists.length];
        boolean[] visited = new boolean[lists.length];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int start = cur[0];
            int cnt = cur[1];

            if (start == X && cnt > 0) {
                continue;
            }

            if (cnt == K) {
                result.add(start);
            }

            for (int i = 0; i < lists[start].size(); i++) {
                int newStart = lists[start].get(i);
                if (!visited[newStart]) {
                    visited[newStart] = true;
                    queue.add(new int[]{newStart, cnt + 1});
                }
            }
        }
    }
}