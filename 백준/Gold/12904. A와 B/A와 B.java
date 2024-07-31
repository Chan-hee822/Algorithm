import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String before = br.readLine();
        String after = br.readLine();

        while (before.length() != after.length()) {
            int size = after.length();
            if (after.charAt(size - 1) == 'A') {
                after = after.substring(0, size - 1);
                continue;
            }
            after = after.substring(0, size -1);
            StringBuilder sb = new StringBuilder();
            after = sb.append(after).reverse().toString();
        }

        System.out.println(before.equals(after) ? 1 : 0);

    }
}