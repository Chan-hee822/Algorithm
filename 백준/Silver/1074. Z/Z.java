import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r;
    static int c;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int tableSize = (int) Math.pow(2, N);
        cnt = 0;
        recursion(tableSize, 0, 0);

    }

    private static void recursion(int tableSize, int x, int y) {
        if(tableSize < 2) {
            return;
        }
        if (tableSize == 2) {
            for (int i = x; i < x + tableSize; i++) {
                for (int j = y; j < y + tableSize; j++) {
                    if (i == r && j == c) {
                        System.out.println(cnt);
                        return;
                    }
                    cnt++;
                }
            }
        }

        tableSize /= 2;

        if (r < x + tableSize && c < y + tableSize) {
            recursion(tableSize, x, y);
        } else if (r < x + tableSize && c >= y + tableSize) {
            cnt += tableSize * tableSize;
            recursion(tableSize, x, y + tableSize);
        } else if (r >= x + tableSize && c < y + tableSize) {
            cnt += 2 * tableSize * tableSize;
            recursion(tableSize, x + tableSize, y);
        } else {
            cnt += 3 * tableSize * tableSize;
            recursion(tableSize, x + tableSize, y + tableSize);
        }

    }
}
