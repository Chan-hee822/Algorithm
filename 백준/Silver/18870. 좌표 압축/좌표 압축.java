import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        int[] pointArr = new int[N];
        for (int i = 0; i < N; i++) {
            pointArr[i] = Integer.parseInt(st.nextToken());
            set.add(pointArr[i]);
        }
        
        List<Integer> setList = set.stream().sorted().collect(Collectors.toList());
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < setList.size(); i++) {
            map.put(setList.get(i), i);
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int temp = pointArr[i];
            sb.append(map.get(temp)).append(" ");
        }
        
        System.out.println(sb.toString());
    }
}