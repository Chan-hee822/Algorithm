import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long finger = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        long count = Long.parseLong(st.nextToken());

        String set = "12345432";
        // 122
        // 12345 432 12345 432 12345 432 12345 432
        if (count == 0) {
            System.out.println(finger - 1);
            return;
        }
        long reuslt = 0;
        long odd = count % 2;
        if (finger == 1 || finger == 5) {
            reuslt += (8 * (count));
            long index = set.indexOf(String.valueOf(finger));
            reuslt += index;
            System.out.println(reuslt);
            return;
        }
        if (odd == 1) {
            reuslt += (8 * (count/2));
            long index = set.lastIndexOf(String.valueOf(finger));
            reuslt += index;
            System.out.println(reuslt);
            return;
        }
        reuslt += (8 * (count / 2));
        long index = set.indexOf(String.valueOf(finger));
        reuslt += index;
        System.out.println(reuslt);
    }
}
