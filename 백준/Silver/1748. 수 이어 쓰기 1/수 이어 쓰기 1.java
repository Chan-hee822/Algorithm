import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String N = sc.next();

        int n = Integer.parseInt(N);
        int length = N.length();
        int size = length - 1;
        int cnt = size;

        int result = 0;
        int A;
        while (cnt > 0) {
            A = (int) (Math.pow(10, cnt)) - ((int) (Math.pow(10, cnt - 1)));
            result += A * cnt;
            cnt--;
        }
        A = (n - (int) (Math.pow(10, size)) + 1) * length;
        result += A;
        System.out.println(result);
    }
}