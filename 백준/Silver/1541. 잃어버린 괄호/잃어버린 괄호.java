import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();

        if (!formula.contains("+")) {
            String[] split = formula.split("-");
            int sum = Integer.parseInt(split[0]);
            for (int i = 1; i < split.length; i++) {
                sum -= Integer.parseInt(split[i]);
            }
            System.out.println(sum);
            return;
        }

        if (!formula.contains("-")) {
            String[] split = formula.replaceAll("[+]", " ").split(" ");
            int sum = Integer.parseInt(split[0]);
            for (int i = 1; i < split.length; i++) {
                sum += Integer.parseInt(split[i]);
            }
            System.out.println(sum);
            return;
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : formula.toCharArray()) {
            if (c == '+' || c == '-') {
                queue.add(c);
            }
        }
        String[] split = formula.replaceAll("[+-]", " ").split(" ");

        int resultPlus = 0;
        int resultMinus = 0;

        resultPlus = (Integer.parseInt(split[0]));
        boolean flag = false;
        for (int i = 1; i < split.length; i++) {
            Character c = queue.poll();
            if (!flag && c.equals('-')) {
                flag = true;
                resultMinus += (Integer.parseInt(split[i]));
                continue;
            }
            if (!flag && c.equals('+')) {
                resultPlus += (Integer.parseInt(split[i]));
                continue;
            }
            resultMinus += (Integer.parseInt(split[i]));
        }
        System.out.println(resultPlus - resultMinus);
    }
}