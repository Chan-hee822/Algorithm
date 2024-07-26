import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * 로직 설명:
         * 1. 입력 처리: 테스트 케이스의 수와 각 테스트 케이스의 지원자 정보를 입력받음.
         * 2. 정렬: 각 지원자의 서류 심사 성적을 기준으로 오름차순 정렬. ( 낮은 수가 가장 잘한 지원자)
         * 3. 선발 과정: 서류 심사 2등 지원자부터 앞선 등 수 지원자와 면접 성적을 비교하여 선발.
         *    - 앞선 지원자의 면접 성적보다 낮은 성적을 가진 지원자는 선발하지 않음.
         *    - 최소 등수 설정 현재 지원자가 이것보다 앞서야 선발
         *    - 초기 최소 등수 = 서류 1등 지원자
         *    - 현재 지원자 등수가 최소 등수 보다 우수 하면 (ex 현재 3, 최소 등수 4 -> 우수)
         *      -> 최소 등수 갱신
         * 4. 결과 출력: 선발된 지원자의 수를 출력.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[][] applicants = new int[N][2];
            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[j][0] = Integer.parseInt(st.nextToken());
                applicants[j][1] = Integer.parseInt(st.nextToken());
            }
            
            // 서류심사 순으로 정렬
            Arrays.sort(applicants, (a, b) -> Integer.compare(a[0], b[0]));

            int selectedCount = 1;
            // 넘어야하는 최소 등수
            int minInterviewRank = applicants[0][1];
            for (int j = 1; j < N; j++) {
                if (applicants[j][1] < minInterviewRank) {
                    selectedCount++;
                    minInterviewRank = applicants[j][1];
                }
            }
            sb.append(selectedCount).append('\n');
        }
        System.out.println(sb.toString());
    }
}