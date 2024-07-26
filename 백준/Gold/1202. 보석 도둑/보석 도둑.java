import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewelry{
    int weight;
    int value;

    public Jewelry(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewelry[] jewelries = new Jewelry[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(M, V);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries, (a, b) ->
                a.weight == b.weight ? b.value - a.value : a.weight - b.weight
                ); // 무게 순으로 정렬 같으면 가치 순
        Arrays.sort(bags); // 가방을 무게 기준으로 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 우선순위 큐 (최대힙)
        long result = 0;
        int j = 0;

        for (int i = 0; i < K; i++) {
            while (j < N && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j].value);
                j++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        System.out.println(result);
    }
}