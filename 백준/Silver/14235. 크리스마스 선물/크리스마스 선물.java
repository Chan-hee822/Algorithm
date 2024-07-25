import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 우선 순위 큐 활용하여 풀이 (최대 힙, 가장 큰 값 최상단)
         * 입력값 (a) 이 0 일 경우 큐 최상단 값 출력, 큐가 비어있으면 -1 출력
         * 0 아닐 경우 a 개수 만큼 수 큐에 저장
         * 잦은 출력 피하기 위해 스트링빌더로 한 번에 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(pq.poll()).append('\n');
                continue;
            }
            for (int j = 0; j < a; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(sb.toString());
    }

}