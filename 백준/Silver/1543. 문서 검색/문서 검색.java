import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        int idx = 0;
        int lng = target.length();
        int cnt = 0;
        while (true) {
            int i = str.indexOf(target, idx);
            if (i >= 0) {
                idx = i + lng;
                cnt++;
            } else {
                break;
            }
        }
        System.out.println(cnt);
    }
}