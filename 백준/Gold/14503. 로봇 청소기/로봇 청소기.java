import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    final static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int result = 0;
        while (true) {
            // 1. 현재 위치를 청소
            if (map[r][c] == 0) {
                map[r][c] = 2;  // 청소 완료 표시
                result++;
            }
            
            boolean cleaned = false;
            // 2. 현재 방향을 기준으로 왼쪽 방향부터 차례대로 인접한 칸을 탐색
            for (int i = 0; i < 4; i++) {
                d = (d + 3) % 4;  // 왼쪽으로 회전
                int newX = r + dx[d];
                int newY = c + dy[d];
                
                if (map[newX][newY] == 0) {  // 왼쪽 방향에 청소하지 않은 공간이 있다면
                    r = newX;
                    c = newY;
                    cleaned = true;
                    break;
                }
            }
            
            if (!cleaned) {  // 네 방향 모두 청소가 이미 되어 있거나 벽인 경우
                int backX = r - dx[d];
                int backY = c - dy[d];
                
                if (map[backX][backY] == 1) {  // 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우
                    break;
                }
                // 후진
                r = backX;
                c = backY;
            }
        }
        
        System.out.println(result);
    }
}