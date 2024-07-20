import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()) - 1;

        st = new StringTokenizer(br.readLine());
        st.nextToken();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String person = st.nextToken();
            sb.append(person).append(" ");
        }

        int result = 0;

        String[] personArr = sb.toString().split("ENTER ");
        for (String person : personArr) {
            Set<String> set = new HashSet<>(Arrays.asList(person.split(" ")));
            result += set.size();
        }

        System.out.println(result);
    }
}