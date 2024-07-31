import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Float> map = new HashMap<>();
        map.put("A+", 4.5f);
        map.put("A0", 4.0f);
        map.put("B+", 3.5f);
        map.put("B0", 3.0f);
        map.put("C+", 2.5f);
        map.put("C0", 2.0f);
        map.put("D+", 1.5f);
        map.put("D0", 1.0f);
        map.put("F", 0.0f);

        float totalGrade = 0;
        float totalScore = 0.0f;
        for (int i = 0; i < 20; i++) {
            String[] split = br.readLine().split(" ");
            float grade = Float.parseFloat(split[1]);
            String s = split[2];
            if (s.equals("P")) {
                continue;
            }
            totalGrade += grade;
            if (s.equals("F")) {
                continue;
            }

            Float score = map.get(s);

            totalScore += (float) score * grade;

        }
        System.out.println(Math.round((totalScore / totalGrade) * 1000000) / 1000000.0);
    }
}