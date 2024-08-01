import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
            list.add(num);
            sum += num;
        }
        StringBuilder sb = new StringBuilder();
        // 산술평균
        sb.append((int)Math.round((float) sum /N)).append('\n');
        // 중앙값
        List<Integer> sortedList = list.stream().sorted().collect(Collectors.toList());
        sb.append(sortedList.get(N/2)).append('\n');
        // 최빈값  여러개면 2번쨰로 작은 값
        List<Map.Entry<Integer, Integer>> sortedMap = map.entrySet().stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toList());

        int often = sortedMap.get(0).getValue();

        if (sortedMap.size() == 1 || often != sortedMap.get(1).getValue()) {

            sb.append(sortedMap.get(0).getKey()).append('\n');
        } else {

            List<Integer> oftenList = new ArrayList<>();
            for (Map.Entry<Integer, Integer> item : sortedMap) {
                if (item.getValue() == often) {
                    oftenList.add(item.getKey());
                }
            }
            Integer result = oftenList.stream().sorted().collect(Collectors.toList()).get(1);
            sb.append(result).append('\n');
        }
        // 범위
        sb.append(sortedList.get(N - 1) - sortedList.get(0)).append('\n');

        System.out.println(sb.toString());
    }
}