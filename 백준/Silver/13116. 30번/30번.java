import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A == B) {
                System.out.println(A * 10);
                return;
            }
            int rootA = A;
            int rootB = B;

            while (rootA != rootB) {
                if (rootA > rootB) {
                    rootA /= 2;
                } else {
                    rootB /= 2;
                }
            }
            System.out.println(rootA * 10);
        }
    }
}