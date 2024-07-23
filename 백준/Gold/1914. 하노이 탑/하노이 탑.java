import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        BigInteger count = new BigInteger("2");

        System.out.println(count.pow(N).subtract(new BigInteger("1")));

        if (N <= 20) {
            List<int[]> list = new ArrayList<>();
            hanoi(N, 1, 2, 3, list);
            for (int[] step : list) {
                System.out.println(step[0] + " " + step[1]);
            }
        }
    }

    private static void hanoi(int N, int start, int mid, int end, List<int[]> list) {
        if (N == 1) {
            list.add(new int[]{start, end});
            return;
        }
        hanoi(N - 1, start, end, mid, list);
        list.add(new int[]{start, end});
        hanoi(N - 1, mid, start, end, list);
    }
}