import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        /**

         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 재료 개수
        int a1 = Integer.parseInt(st.nextToken());
        // 깊이
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());

        int left = a1 * n0 + a0;
        int right = c * n0;
        
        if (c < a1) {
            System.out.println(0);
            return;
        }

        if (left <= right) {
            System.out.println(1);
            return;
        }
        System.out.println(0);
    }
}
