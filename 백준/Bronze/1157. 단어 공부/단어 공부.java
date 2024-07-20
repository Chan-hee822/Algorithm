import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.next().toUpperCase().split("");
        
        Map<String, Integer> map = new HashMap<>();
        for (String str : strArr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        if (map.size() == 1) {
            System.out.println(strArr[0].toUpperCase());
            return;
        }

        List<Map.Entry<String, Integer>> list = map.entrySet()
                .stream().sorted((a, b) -> b.getValue() - a.getValue())
                .collect(Collectors.toList());
        int fir = list.get(0).getValue();
        int sec = list.get(1).getValue();
        if (fir == sec) {
            System.out.println("?");
        } else {
            System.out.println(list.get(0).getKey());
        }
    }
}
