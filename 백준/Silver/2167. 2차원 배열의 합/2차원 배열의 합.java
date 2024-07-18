import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    /*
    2 3     -> 2차원 배열 크기
    1 2 4   -> 각 위치의 값들
    8 16 32
    3       -> 부분 합 구할 개수
    1 1 2 3 -> 시작지점과 끝지점 -> 63
    1 2 1 2                   -> 2
    1 3 2 3                   -> 36
    * */
    public static void main(String[] args) throws IOException {
        //int[] arrValue = {1,2,4,8,16,32};
        //int[][] arr = new int[2][3];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrX = Integer.parseInt(st.nextToken());
        int arrY = Integer.parseInt(st.nextToken());
        int[][] arr = new int[arrX][arrY];
        // 이중 배열 생성

        for (int i = 0; i < arrX; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arrY; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1,2,4,8,16,32 삽입

        st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] arrayLists = new ArrayList[cnt];
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            arrayLists[i] = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                int n = Integer.parseInt(st.nextToken());
                arrayLists[i].add(n);
            }
        }
        // 더할 시작 위치와 끝 위치 받아 리스트에 정렬

        for (int k = 0; k < cnt; k++) {
            int startRow = arrayLists[k].get(0) - 1;    // 1    1   1
            int startCol = arrayLists[k].get(1) - 1;    // 1    2   3
            int endRow = arrayLists[k].get(2) - 1;      // 2    1   2
            int endCol = arrayLists[k].get(3) - 1;      // 3    2   3

            int sum = 0;
            for (int i = startRow; i <= endRow; i++) {
                for (int j = startCol; j <= endCol; j++) {
                    sum += arr[i][j];
                }
            }
            System.out.println(sum);
        }
        // 각 위치를 더해줌.
        
    }
}