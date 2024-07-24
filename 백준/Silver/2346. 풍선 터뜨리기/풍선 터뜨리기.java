import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Balloon {
    int idx;
    int next;

    public Balloon(int idx, int next) {
        this.idx = idx;
        this.next = next;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        Balloon[] dq = new Balloon[N];
        boolean[] visited = new boolean[N];

        // 3 2 1 -3 1
        for (int i = 1; i <= N; i++) {
            int balloon = Integer.parseInt(st.nextToken());
            dq[i - 1] = new Balloon(i, balloon);
        }

        StringBuilder sb = new StringBuilder();
        int index = 0;
        int cnt = 0;
        while (cnt < N) {
            Balloon balloon = dq[index];

            sb.append(balloon.idx).append(" ");
            visited[index] = true;

            if (cnt == N - 1) {
                break;
            }

            int next = balloon.next;
            if (next >= 0) {
                while (next > 0) {
                    index++;
                    if (index == N) {
                        index = 0;
                    }
                    if (visited[index]) {
                        continue;
                    }
                    next--;
                }
            } else {
                next *= -1;
                while (next > 0) {
                    index--;
                    if (index == -1) {
                        index = N - 1;
                    }
                    if (visited[index]) {
                        continue;
                    }
                    next--;
                }
            }
            cnt++;
        }
        System.out.println(sb.toString());
    }
}