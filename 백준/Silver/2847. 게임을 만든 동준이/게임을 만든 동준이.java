import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int lastOne = arr[N - 1];
        int result = 0;

        if (lastOne < N) {
            result = N - lastOne;
            lastOne = N;
            arr[N - 1] = lastOne;
        }

        int size = N - 2;
        int pre = arr[size + 1] - 1;
        while (size >= 0) {
            int cur = arr[size];
            if (cur > pre) {
                result += cur - pre;
            }
            pre = Math.min(cur - 1, pre - 1);
            size--;
        }

        System.out.println(result);
    }
}