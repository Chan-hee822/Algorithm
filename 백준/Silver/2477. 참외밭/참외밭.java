import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * 전체 넓이에서 - 빈 곳 넓이를 빼서 계산
         * 인접한 변을 사용하여 넓이를 각각의 넓이를 구함 모두 더함
         * 위 결과에서 전체 넓이 * 2 한 값을 빼주어 결과값 반환
         * 이유 : 빈 곳은 2번 넓이가 겹지고, 원하는 곳은 3번 겹치기 때문에
         */
        // 미터 당 당근 개수
        int K = Integer.parseInt(st.nextToken());
        int maxV = Integer.MIN_VALUE;
        int maxH = Integer.MIN_VALUE;

        // 면적 계산
        int area = 0;
        // 방향을 나타내는 변수
        int p = 0;
        // 각 변을 순서대로 저장할 변수
        int d = 0;
        // 처음 변과 마지막 변 계산 위해 필요한 변수
        int start = 0;
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            // 입력 방향
            p = Integer.parseInt(st.nextToken());
            int temp = Integer.parseInt(st.nextToken());
            // 전체 넓이 구하기 위한 각 변 최대값 계산
            if ((p == 4 || p == 3) && temp > maxH) {
                maxH = temp;
            }
            if ((p == 2 || p == 1) && temp > maxV) {
                maxV = temp;
            }
            // 첫번째 변은 곱할 값이 없기 때문에 저장만
            if (i == 0) {
                start = temp;
                d = temp;
                continue;
            }
            // 인접 변과 넓이 계산 후 누적
            area += d * temp;
            // 그 다음 변으로 갱신
            d = temp;
        }
        // 마지막 변과 처음 변 넓이 계산
        area += d * start;
        // 결과 계산
        int result = area - (maxH * maxV * 2);
        System.out.println(result * K);
    }
}
