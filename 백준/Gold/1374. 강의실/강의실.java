import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] table = new int[N][2];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            table[i][0] = Integer.parseInt(st.nextToken());
            table[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(table, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        int classCnt = 0;
        for (int[] item : table) {
            if (que.isEmpty()) {
                que.add(item[1]);
                classCnt = 1;
                continue;
            }

            int endTime = que.peek();
            int curStartTime = item[0];
            int curEndTime = item[1];
            if (curStartTime < endTime) {
                que.add(curEndTime);
                if (classCnt < que.size()) {
                    classCnt++;
                }
                continue;
            }
            que.add(item[1]);
            que.poll();
        }
        System.out.println(classCnt);
    }
}