import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int X = Integer.parseInt(st.nextToken());
        int idx = 1;
        int sum = 0;
        while (true) {
            sum += idx;
            if (sum >= X) {
                break;
            }
            idx++;
        }
        sum = sum - idx + 1;
        int child = 1;
        int mother = idx;
        if (idx % 2 == 0) {
            while (true) {
                if (sum != X) {
                    sum++;
                    child++;
                    mother--;
                    continue;
                }
                System.out.println(child + "/" + mother);
                return;
            }
        }
        child = idx;
        mother = 1;
        while (true){
            if (sum != X) {
                sum++;
                child--;
                mother++;
                continue;
            }
            System.out.println(child + "/" + mother);
            return;
        }
    }
}