import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int centi = Integer.parseInt(st.nextToken());
        int hammer = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> height = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            height.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = hammer;
        while (hammer > 0) {

            if (height.peek() < centi) {
                break;
            }

            int temp = height.poll();
            if (temp == 1) {
                height.add(temp);
                break;
            }
            hammer--;
            height.add(temp / 2);
        }

        if (centi > height.peek()) {
            System.out.println("YES");
            System.out.println(cnt - hammer);
            return;
        }

        if (height.peek() >= centi) {
            System.out.println("NO");
            System.out.println(height.peek());
        }

    }
}