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
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[networks.length];
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curCom = queue.poll();

            for (int i = 0; i < networks[curCom].size(); i++) {
                int nextCom = networks[curCom].get(i);
                if (!visited[nextCom]) {
                    queue.add(nextCom);
                    cnt++;
                    visited[nextCom] = true;
                }
            }
        }
        return cnt;
    }
}