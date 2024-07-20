import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] S = sc.nextLine().split("");

        int size = S.length;

        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for (int i = 0; i < size; i++) {
            String temp = S[i];

            if (temp.equals("<")) {
                sb.append(temp);
                check = true;
                continue;
            }

            if (temp.equals(">")) {
                sb.append(temp);
                check = false;
                continue;
            }

            if (temp.equals(" ")) {
                sb.append(temp);
                continue;
            }

            if (check) {
                sb.append(temp);
                continue;
            }

            while (i < size && !S[i].equals(" ") && !S[i].equals("<") && !S[i].equals(">")) {
                stack.push(S[i++]);
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
            i--;
        }
        System.out.println(sb.toString());
    }
}