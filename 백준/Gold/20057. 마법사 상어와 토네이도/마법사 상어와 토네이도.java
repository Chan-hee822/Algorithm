import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 로직
 * 1. 입력 처리: 격자판의 크기 N과 각 셀에 있는 모래의 양을 입력받아 2차원 배열로 저장합니다.
 * 2. 토네이도 이동 및 모래 분배:
 *    - 격자판의 중앙에서 시작하여 토네이도가 특정 규칙에 따라 이동합니다.
 *    - 각 위치에서 모래를 지정된 비율에 따라 주변 칸으로 분배하고, 나머지 모래는 알파(α) 위치로 이동시킵니다.
 *    - 이동하는 모래 위치와 지정된 비율을 배열로 정의해 놓습니다.
 * 3. 격자판 밖으로 나가는 모래 처리:
 *    - 모래가 격자판 밖으로 나가는 경우, 그 양을 누적하여 계산합니다.
 * 4. 최종 출력: 격자판 밖으로 나간 모래의 총량을 출력합니다.
 */
public class Main {

    static int[] dx = {0, 1, 0, -1}; // 왼, 아래, 오, 위 순서로 이동
    static int[] dy = {-1, 0, 1, 0};

    // 각 방향에 따른 모래 이동 좌표 (왼쪽, 아래, 오른쪽, 위쪽)
    static int[][][] sandMovePointSet
            = {{{0, -2}, {-1, -1}, {1, -1}, {-2, 0}, {-1, 0}, {1, 0}, {2, 0}, {-1, 1}, {1, 1}},
            {{2, 0}, {1, -1}, {1, 1}, {0, -2}, {0, -1}, {0, 1}, {0, 2}, {-1, -1}, {-1, 1}},
            {{0, 2}, {-1, 1}, {1, 1}, {2, 0}, {1, 0}, {-1, 0}, {-2, 0}, {1, -1}, {-1, -1}},
            {{-2, 0}, {-1, 1}, {-1, -1}, {0, 2}, {0, 1}, {0, -1}, {0, -2}, {1, 1}, {1, -1}}};

    static float[] perSand
            = {0.05f, 0.1f, 0.1f, 0.02f, 0.07f, 0.07f, 0.02f, 0.01f, 0.01f};

    // 모래를 이동시키는 메서드
    private static int magicOn(
            int[][] table, int x, int y, int direction, int curSandAmount, int N) {

        int[][] movePoints = sandMovePointSet[direction];
        int totalMovedSand = 0;
        int outSand = 0;

        for (int i = 0; i < 9; i++) {
            int[] curPoint = movePoints[i];
            int newX = x + curPoint[0];
            int newY = y + curPoint[1];
            int sandToMove = (int) (curSandAmount * perSand[i]);

            if (newX >= 0 && newY >= 0 && newX < N && newY < N) {
                table[newX][newY] += sandToMove;
            } else {
                outSand += sandToMove;
            }

            totalMovedSand += sandToMove;
        }

        // 남은 모래(α)를 처리
        int alphaX = x + dx[direction];
        int alphaY = y + dy[direction];
        int remainingSand = curSandAmount - totalMovedSand;

        if (alphaX >= 0 && alphaY >= 0 && alphaX < N && alphaY < N) {
            table[alphaX][alphaY] += remainingSand;
        } else {
            outSand += remainingSand;
        }

        return outSand;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] tableA = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                tableA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int x = N / 2;
        int y = N / 2;
        int direction = 0;
        int c = 1;

        int outSand = 0;

        Loop:
        while (true) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < c; j++) {
                    x = x + dx[direction % 4];
                    y = y + dy[direction % 4];

                    int curSand = tableA[x][y];
                    if (curSand > 0) {
                        outSand += magicOn(tableA, x, y, direction % 4, curSand, N);
                        tableA[x][y] = 0;
                    }
                    if (x == 0 && y == 0) {
                        break Loop;
                    }
                }
                direction++;
            }
            c++;
        }

        System.out.println(outSand);
    }
}