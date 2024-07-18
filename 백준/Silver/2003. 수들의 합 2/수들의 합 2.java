import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * 투 포이터 알고리즈 사용
         * 앞에서부터 차례대로 배열의 수를 더하거나 뺌
         * 목표보다 커지면 맨 앞 수 빼줌 (포인터1 이동)
         * 목표보다 작으면 다음 수를 더함 (포인터2 이동)
         * 포인터는 같은 위치에 있을 수 있고
         * 2개의 포인터 끝까지 무조건 도달하는 방식으로 탐색
         */
        // 배열 개수
        int N = Integer.parseInt(st.nextToken());
        // 만들어야하는 수
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 담을 배열
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 결과를 담을 변수, 찾을 때 마다 ++
        int result = 0;

        // 2개의 포인터
        int p1 = 0, p2 = 1;

        int sum = arr[p1];
        while (p1 < N) {
            if (p2 < N && sum < M) {
                sum += arr[p2];
                p2++;
                continue;
            }
            if (sum == M) {
                result++;
                sum -= arr[p1];
                p1++;
                continue;
            }
            sum -= arr[p1];
            p1++;
        }
        System.out.println(result);
    }
}
