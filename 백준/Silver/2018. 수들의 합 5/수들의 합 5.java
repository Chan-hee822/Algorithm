import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int idx = 1;
        do {
            arr[idx - 1] = idx;
            idx++;
        } while (idx <= N);

        // 결과를 담을 변수, 찾을 때 마다 ++
        int result = 0;

        // 2개의 포인터
        //  왼 포일터  오 포인터
        int p1 = 0, p2 = 1;
        // 초기 값 세팅
        int sum = arr[p1];
        while (p1 < N) {
            // 작을 경우 오른쪽 값 더해주고 p2 하나이동
            if (p2 < N && sum < N) {
                sum += arr[p2];
                p2++;
                continue;
            }
            // 같으면 결과 증가, 왼쪽 값 하나 빼주고 p1 하나 이동
            if (sum == N) {
                result++;
                sum -= arr[p1];
                p1++;
                continue;
            }
            // 크면 왼쪽 하나 빼주고 p1 하나 이동
            sum -= arr[p1];
            p1++;
        }
        System.out.println(result);
    }
}
