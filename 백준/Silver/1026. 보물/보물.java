import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arrA = new int[N];
        int[] arrB = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int a = 0; a < N; a++) {
            arrA[a] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int b = 0; b < N; b++) {
            arrB[b] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Integer[] reverseArrB = Arrays.stream(arrB).boxed().toArray(Integer[]::new);
        Arrays.sort(reverseArrB, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < N; i++) {
            result += arrA[i] * reverseArrB[i];
        }
        
        System.out.println(result);
    }
}