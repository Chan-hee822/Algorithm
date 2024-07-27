import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int n = (int) Math.pow(2, K);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();
        int[] result = new int[n];
        result = dfs(K, arr, result, n / 2, 1);

        int idx = 2;
        for (int i = 1; i < n; i++) {
            if (i == idx) {
                idx *= 2;
                sb.append('\n');
            }
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int[] dfs(int depth, int[] arr, int[] result, int mid, int start) {
        if (depth == 0) {
            return result;
        }

        result = dfs(depth - 1, arr, result, mid - (int) Math.pow(2, depth - 2), (start) * 2);
        result[start] = arr[mid];
        result = dfs(depth - 1, arr, result, mid + (int) Math.pow(2, depth - 2), (start) * 2 + 1);

        return result;
    }
}