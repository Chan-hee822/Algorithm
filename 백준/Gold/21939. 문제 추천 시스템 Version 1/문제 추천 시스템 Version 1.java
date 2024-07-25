import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Problem {
    int number;
    int level;

    public Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }

    // Override equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Problem problem = (Problem) o;
        return number == problem.number && level == problem.level;
    }

    // Override hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(number, level);
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Problem> topDown = new PriorityQueue<>(
                (a, b) -> a.level == b.level ? b.number - a.number : b.level - a.level);
        PriorityQueue<Problem> bottomUp = new PriorityQueue<>(
                (a, b) -> a.level == b.level ? a.number - b.number : a.level - b.level);
        StringTokenizer st;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Problem problem = new Problem(
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            topDown.add(problem);
            bottomUp.add(problem);
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("add")) {
                Problem problem = new Problem(
                        Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                topDown.add(problem);
                bottomUp.add(problem);
                continue;
            }
            if (order.equals("recommend")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    if (map.containsKey(bottomUp.peek().number)) {
                        do {
                            map.remove(bottomUp.peek().number);
                            topDown.remove(bottomUp.poll());
                        } while (map.containsKey(bottomUp.peek().number));

                    }
                    sb.append(bottomUp.peek().number).append('\n');
                } else {
                    if (map.containsKey(topDown.peek().number)) {
                        do {
                            map.remove(topDown.peek().number);
                            bottomUp.remove(topDown.poll());
                        } while (map.containsKey(topDown.peek().number));
                    }
                    sb.append(topDown.peek().number).append('\n');
                }
                continue;
            }
            if (order.equals("solved")) {
                int solvedProblem = Integer.parseInt(st.nextToken());
                map.put(solvedProblem, 1);
            }
        }
        System.out.println(sb.toString());
    }
}