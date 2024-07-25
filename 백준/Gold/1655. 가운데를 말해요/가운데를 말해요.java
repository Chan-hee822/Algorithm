import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    /**
     *
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int centre = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(centre).append('\n');
        right.add(centre);
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (centre <= num) {
                right.add(num);
            } else {
                left.add(num);
            }
            int leftSize = left.size();
            int rightSize = right.size();
            int diff = leftSize - rightSize;
            if (diff == 2) {
                right.add(left.poll());
                leftSize--;
                rightSize++;
            }
            if (diff == -2) {
                left.add(right.poll());
                rightSize--;
                leftSize++;
            }
            if (leftSize > rightSize) {
                centre = left.peek();
                sb.append(left.peek()).append('\n');
            } else if (leftSize == rightSize) {
                centre = Math.min(left.peek(), right.peek());
                sb.append(Math.min(left.peek(), right.peek())).append('\n');
            } else {
                centre = right.peek();
                sb.append(right.peek()).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
