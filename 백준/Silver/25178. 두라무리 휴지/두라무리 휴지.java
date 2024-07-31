import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        String second = br.readLine();

        String sortedFirst = Arrays.stream(first.split("")).sorted().collect(Collectors.joining());
        String sortedSecond = Arrays.stream(second.split("")).sorted().collect(Collectors.joining());

        if (!sortedFirst.equals(sortedSecond)) {
            System.out.println("NO");
            return;
        }

        if (first.charAt(0) != second.charAt(0) || first.charAt(N - 1) != second.charAt(N - 1)
        ) {
            System.out.println("NO");
            return;
        }
        String firstWithoutVowel = first.replaceAll("[aeiou]", "");
        String secondWithoutVowel = second.replaceAll("[aeiou]", "");

        if (!firstWithoutVowel.equals(secondWithoutVowel)) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");


    }
}