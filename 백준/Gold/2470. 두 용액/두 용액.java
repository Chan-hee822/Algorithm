import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0;
        int right = N - 1;
        int[] result = new int[2];
        int sum;
        int sumPrime = Integer.MAX_VALUE;
        while (left < right) {

            int leftAcid = arr[left];
            int rightAcid = arr[right];
            sum = leftAcid + rightAcid;

            if (sum > 0) {
                right--;
                if (sum < sumPrime) {
                    result[0] = leftAcid;
                    result[1] = rightAcid;
                    sumPrime = sum;
                }
            } else if (sum < 0) {
                left++;
                int absSum = Math.abs(sum);
                if (absSum < sumPrime) {
                    result[0] = leftAcid;
                    result[1] = rightAcid;
                    sumPrime = absSum;
                }
            } else {
                System.out.println(leftAcid + " " + rightAcid);
                return;
            }
        }
        System.out.println(result[0] + " " + result[1]);
    }
}