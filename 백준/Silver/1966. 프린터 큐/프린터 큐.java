import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Printer {

    int idx;
    int point;
    int turn;

    public Printer(int idx, int point, int turn) {
        this.idx = idx;
        this.point = point;
        this.turn = turn;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Printer> printers = new LinkedList<>();
            Deque<Printer> waitingQueue = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                printers.add(new Printer(i, Integer.parseInt(st.nextToken()), i + 1));
            }

            waitingQueue.add(printers.poll());

            while (!printers.isEmpty()) {
                int leftPoint = waitingQueue.peek().point;
                int rightPoint = printers.peek().point;

                if (leftPoint >= rightPoint) {
                    int temp = waitingQueue.peekLast().point;
                    if (temp < rightPoint) {
                        Stack<Printer> stack = new Stack<>();
                        while (temp < rightPoint) {
                            stack.push(waitingQueue.pollLast());
//                            printers.add(waitingQueue.pollLast());
                            temp = waitingQueue.peekLast().point;
                        }
                        while (!stack.isEmpty()) {
                            printers.add(stack.pop());
                        }
                    }
                    waitingQueue.add(printers.poll());
                    continue;
                }

                while (leftPoint < rightPoint) {
                    printers.add(waitingQueue.poll());
                    if (waitingQueue.isEmpty()) {
                        waitingQueue.add(printers.poll());
                        break;
                    }
                    leftPoint = waitingQueue.peek().point;
                }
            }

            int cnt = 1;
            for (Printer p : waitingQueue) {
                if (p.idx == M) {
                    System.out.println(cnt);
                    break;
                }
                cnt++;
            }
        }
    }
}