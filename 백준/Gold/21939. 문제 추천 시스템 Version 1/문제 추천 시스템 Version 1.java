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
        /**
         * 1. 두 개의 우선순위 큐를 사용하여 문제를 난이도에 따라 정렬.
         *    - topDown: 난이도가 높은 문제를 먼저 추천.
         *    - bottomUp: 난이도가 낮은 문제를 먼저 추천.
         * 2. 문제 추가, 추천, 해결 등의 명령어를 처리.
         *    - add: 새로운 문제를 우선순위 큐에 추가.
         *    - recommend: 특정 방향(-1 또는 1)에 따라 문제를 추천.
         *    - solved: 문제를 해결하고 해결된 문제는 우선순위 큐에서 제거.
         * 3. 해결된 문제를 처리하기 위해 map을 사용하여 제거할 문제를 추적.
         *    - 해결한 문제 map에 추가
         *    - 해결한 문제를 추천하는 경우 -> 두 큐에서 제거, 밑 맵에서 제거 -> 한 큐의 피크 값이 map 에 없을 때 까지 반복
         */
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
                            bottomUp.poll();
                        } while (map.containsKey(bottomUp.peek().number));

                    }
                    sb.append(bottomUp.peek().number).append('\n');
                } else {
                    if (map.containsKey(topDown.peek().number)) {
                        do {
                            map.remove(topDown.peek().number);
                            topDown.poll();
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