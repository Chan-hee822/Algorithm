import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computerCount = Integer.parseInt(br.readLine());
        int networkCount = Integer.parseInt(br.readLine());

        List<Integer>[] networks = new List[computerCount + 1];
        for (int i = 1; i <= computerCount ; i++) {
            networks[i] = new ArrayList<>();
        }
        StringTokenizer st;
        for (int i = 0; i < networkCount; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            networks[a].add(b);
            networks[b].add(a);
        }

        int result = bfs(networks, 1, 0);
        System.out.println(result);
    }

    private static int bfs(List<Integer>[] networks, int start, int cnt) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[networks.length];
        queue.add(new int[]{start, cnt});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curCom = cur[0];
            int curCnt = cur[1];

            for (int i = 0; i < networks[curCom].size(); i++) {
                int nextCom = networks[curCom].get(i);
                if (!visited[nextCom]) {
                    queue.add(new int[]{nextCom, curCnt + 1});
                    cnt++;
                    visited[nextCom] = true;
                }
            }
        }
        return cnt;
    }
}