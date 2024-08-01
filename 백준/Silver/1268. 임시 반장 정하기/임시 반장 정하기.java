import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] table = new int[N + 1][6];
        int[][][] table2 = new int[6][10][N + 1];
        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                int classNum = Integer.parseInt(st.nextToken());
                table[i][j] = classNum;
                table2[j][classNum][i] = 1;
            }
        }

        int max = Integer.MIN_VALUE;
        int result = Integer.MAX_VALUE;
        for (int stdNum = 1; stdNum <= N; stdNum++) {
            int level = 1;
            Set<Integer> friends = new HashSet<>();
            for (int clsNum : table[stdNum]) {
                if (clsNum == 0) {
                    continue;
                }
                int[] students = table2[level][clsNum];
                for (int friend = 1; friend <= N; friend++) {
                    if (friend == stdNum) {
                        continue;
                    }
                    if (students[friend] == 1) {
                        friends.add(friend);
                    }
                }
                level++;
            }
            if (friends.size() > max) {
                result = stdNum;
                max = friends.size();
            }
        }
        System.out.println(result);
    }
}