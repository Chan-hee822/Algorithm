import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        if (N == 1) {
            System.out.println(10);
            return;
        }
        if (N == 2) {
            System.out.printf("11");
            return;
        }

        int repeatCnt = 1;
        int time = 0;
        while (true) {
            int diff = N - repeatCnt;
            if (diff <= repeatCnt) {
                time++;
                break;
            }
            repeatCnt *= 2;
            time++;
        }
        System.out.println(repeatCnt == N / 2 ? 8 + time + 2 : 8 + time + 1);
    }
}