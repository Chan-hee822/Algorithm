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

        boolean satisfies = a0 <= (c - a1) * n0;
        
        if (c >= a1 && satisfies) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
