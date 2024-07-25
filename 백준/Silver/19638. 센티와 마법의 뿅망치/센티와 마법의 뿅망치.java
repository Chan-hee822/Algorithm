import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
         * 우선순위 큐 사용해여 풀이
         * 거인들의 키 내림차순으로 큐에 담음
         * 큐에 피크값(거인들 중 가장 큰 키) 센티를 비교, 크면 하나씩 hammer수 줄여가며 체크
         * hammer 수가 0이 되거나 피크 값이 센티보다 작을 때 까지 반복
         * 피크 값이 크다면 큐에서 pop --> 해당 값 / 2 -> 큐에 push -> hammer--
         * 만약 피크 값이 1이면 hammer 효과 없기 때문 반복 종료
         * 주의) 처음부터 센티보다 작은 거인도 존재
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int hammer = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> height = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            height.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = hammer;
        while (hammer > 0) {

            if (height.peek() < centi || height.peek() == 1) {
                break;
            }

            int temp = height.poll();
            hammer--;
            height.add(temp / 2);
        }

        if (centi > height.peek()) {
            System.out.println("YES");
            System.out.println(cnt - hammer);
            return;
        }

        if (height.peek() >= centi) {
            System.out.println("NO");
            System.out.println(height.peek());
        }

    }
}
