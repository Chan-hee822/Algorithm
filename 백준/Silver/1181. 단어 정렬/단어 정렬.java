import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            set.add(word);
        }

        List<String> sortedWords = set.stream().sorted((a, b)
                        -> a.length() == b.length() ? a.compareTo(b)
                        : a.length() - b.length())
                .collect(Collectors.toList());
        
        StringBuilder sb = new StringBuilder();
        for (String w : sortedWords) {
            sb.append(w).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}