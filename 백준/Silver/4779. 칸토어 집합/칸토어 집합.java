import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        List<Integer> list = new ArrayList<>();
        while ((str = br.readLine()) != null && !str.isEmpty()) {
            list.add(Integer.parseInt(str));
        }

        int max = list.stream().max(Integer::compareTo).get();

        String dp[] = new String[max + 1];

        dp[0] = "-";
        dp[1] = "- -";

        for (int i = 2; i <= max; i++) {
            StringBuilder sb = new StringBuilder();
            String pre = dp[i - 1];
            sb.append(pre);
            int size = pre.length();
            sb.append(" ".repeat(size));
            sb.append(pre);
            dp[i] = sb.toString();
        }

        for (int s : list) {
            System.out.println(dp[s]);
        }
    }
}