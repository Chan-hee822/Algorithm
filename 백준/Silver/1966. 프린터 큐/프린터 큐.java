import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Printer {

    int idx;
    int point;

    public Printer(int idx, int point) {
        this.idx = idx;
        this.point = point;
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
            
            Queue<Printer> queue = new LinkedList<>();
            int[] priorityCount = new int[10];
            
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new Printer(i, priority));
                priorityCount[priority]++;
            }
            
            int printOrder = 0;
            outerLoop:
            for (int priority = 9; priority >= 1; priority--) {
                while (priorityCount[priority] > 0) {
                    Printer current = queue.poll();
                    if (current.point == priority) {
                        printOrder++;
                        priorityCount[priority]--;
                        if (current.idx == M) {
                            System.out.println(printOrder);
                            break outerLoop;
                        }
                    } else {
                        queue.add(current);
                    }
                }
            }
        }
    }
}