import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            if (pal(str)) {
//                sb.append(0).append('\n');
                System.out.println(0);
                continue;
            }

            if (pal2(str)) {
                System.out.println(1);
//                sb.append(1).append('\n');
                continue;
            }
            System.out.println(2);
//            sb.append(2).append('\n');
        }
//        System.out.println(sb.toString());
    }

    private static boolean pal2sub(String str, int start, int end) {
        while (start < end) {
            char c1 = str.charAt(start);
            char c2 = str.charAt(end);
            if (c1 != c2) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private static boolean pal2(String str) {
        int p1 = 0;
        int p2 = str.length() - 1;

        while (p1 < p2) {
            char c1 = str.charAt(p1);
            char c2 = str.charAt(p2);
            if (c1 != c2) {
                return pal2sub(str, p1 + 1, p2) || pal2sub(str, p1, p2 - 1);
            }
            p1++;
            p2--;
        }
        return false;
    }

    private static boolean pal(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(len - i - 1);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }
}