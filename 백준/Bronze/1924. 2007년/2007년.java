import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        /**
         * Array 배열 자료구조 사용
         * 달에 해당하는 인덱스에 그 달 끝 날 저장
         * 입력하는 달까지 날을 더한 후 7로 나누어 나머지 계산
         * 요일을 일요일부터 배열에 저장
         * 계산한 나머지로에 해당하는 인덱스 값 출력
         */
        // 1-12월 끝일 저장
        int[] monthArr = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 요일 저장
        String[] dayArr = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        // 월 입력 값
        int month = Integer.parseInt(st.nextToken());
        // 날 입력 
        int day = Integer.parseInt(st.nextToken());
        // 결과 계산 변수
        int result = 0;
        // 입력 값 2월 부터는 그 전달 까지 각 달 한 달 날 수 만큼 저장
        if (month != 1) {
            for (int i = 1; i < month; i++) {
                result += monthArr[i];
            }
        }
        // 해당 달 일수 저장
        result += day;
        // 나머지 계산
        int idx = result % 7;
        System.out.println(dayArr[idx]);
    }
}