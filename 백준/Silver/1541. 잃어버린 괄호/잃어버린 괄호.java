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
            int num = Integer.parseInt(split[i]);
            if (flag) {
                resultMinus +=num;
                continue;
            }

            if (c.equals('-')) {
                flag = true;
                resultMinus += num;
                continue;
            }
            resultPlus += num;
        }
        System.out.println(resultPlus - resultMinus);
    }
}