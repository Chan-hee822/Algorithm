//package hanghaeWeek1.day3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] table = new String[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(table[i], " ");
        }

        recursion(table, N, 0, 0);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // 각 배열의 값 sb(스트링 빌더)에 저장
                sb.append(table[i][j]);
            }
            // 한줄이 끝나면 개행 문자 추가
            sb.append('\n');
        }

        // 스트링 빌더 출력
        System.out.println(sb);
    }
    

    private static void recursion(String[][] table, int N, int x, int y) {

        if (N == 1) {
            table[x][y] = "*";
            return;
        }

        int newN = N / 3;
        for (int i = x; i < x + N; i += newN) {
            for (int j = y; j < y + N; j += newN) {

                if (i == x + newN && j == y + newN) {
                    continue;
                }
                recursion(table, newN, i, j);
            }
        }

    }
}