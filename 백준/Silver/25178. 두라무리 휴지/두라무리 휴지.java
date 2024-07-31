import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String first = br.readLine();
        String second = br.readLine();

        // 두 문자열이 동일한지, 시작과 끝이 같은지 확인
        if (first.charAt(0) != second.charAt(0) || first.charAt(N - 1) != second.charAt(N - 1)) {
            System.out.println("NO");
            return;
        }

        // 모음을 제거한 문자열 비교
        String firstWithoutVowel = first.replaceAll("[aeiou]", "");
        String secondWithoutVowel = second.replaceAll("[aeiou]", "");
        if (!firstWithoutVowel.equals(secondWithoutVowel)) {
            System.out.println("NO");
            return;
        }

        // 남은 모음들을 정렬하여 비교
        char[] firstVowels = first.replaceAll("[^aeiou]", "").toCharArray();
        char[] secondVowels = second.replaceAll("[^aeiou]", "").toCharArray();
        Arrays.sort(firstVowels);
        Arrays.sort(secondVowels);
        if (!Arrays.equals(firstVowels, secondVowels)) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
    }
}
