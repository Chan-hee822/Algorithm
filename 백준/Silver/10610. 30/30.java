import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N = br.readLine().split("");

        int num = 0;
        boolean flag = false;
        for (int i = 0; i < N.length; i++) {
            if (N[i].equals("0")) {
                flag = true;
                continue;
            }
            num += Integer.parseInt(N[i]);
        }

        if (!flag) {
            System.out.println(-1);
            return;
        }

        if (num % 3 != 0) {
            System.out.println(-1);
            return;
        }

        String result = Arrays.stream(N).sorted((a, b) -> b.compareTo(a)).collect(Collectors.joining());
        System.out.println(result);

    }
}