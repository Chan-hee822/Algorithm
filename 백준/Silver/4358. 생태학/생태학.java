import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> trees = new HashMap<>();
        int cnt = 0;
        String tree;
        while ((tree = br.readLine()) != null) {
            cnt++;
            trees.put(tree, trees.getOrDefault(tree, 0) + 1);
        }

        List<Map.Entry<String, Integer>> sortedTrees = trees.entrySet().stream()
                .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> item : sortedTrees) {
            sb.append(item.getKey()).append(" ");
            double num = (double) (item.getValue() * 100) / cnt;
            double part = Math.round(num * 10000) / 10000.0;
            sb.append(String.format("%.4f", part)).append('\n');
        }
        System.out.println(sb);
    }
}