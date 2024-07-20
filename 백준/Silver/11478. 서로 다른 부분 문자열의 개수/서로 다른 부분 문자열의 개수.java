import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();

        int size = S.length();

        Set<String> set = new HashSet<>();

        int window = 1;

        while (window <= size) {
            int idx = 0;
            while (idx + window <= size) {
                String cut = S.substring(idx, idx + window);
                set.add(cut);
                idx++;
            }
            window++;
        }

        System.out.println(set.size());
    }
}