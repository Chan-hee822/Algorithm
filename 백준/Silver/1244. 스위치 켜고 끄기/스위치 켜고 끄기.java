import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int switchCounts = Integer.parseInt(br.readLine());

        int[] switchArr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int personCounts = Integer.parseInt(br.readLine());

        for (int i = 0; i < personCounts; i++) {
            String[] person = br.readLine().split(" ");
            int sex = Integer.parseInt(person[0]);
            int idx = Integer.parseInt(person[1]);
            // 남자 배수
            if (sex == 1) {
                int tempIdx = idx;
                while (tempIdx <= switchCounts) {
                    int targetSwitch = switchArr[tempIdx - 1];
                    switchArr[tempIdx - 1] = (targetSwitch + 1) % 2;
                    tempIdx += idx;
                }
                continue;
            }

            if (sex == 2) {
//                if (idx == 1 || idx == switchCounts) {
//                    switchArr[idx - 1] = (switchArr[idx - 1] + 1) % 2;
//                    continue;
//                }

                int diff = Math.min(idx - 1, switchCounts - idx);
                int cnt = 0;
                for (int j = 0; j <= diff; j++) {

                    int left = idx - j - 1;
                    int switchLeft = switchArr[left];

                    int right = idx + j - 1;
                    int switchRight = switchArr[right];

                    if (switchLeft == switchRight) {
                        cnt = j;
                        continue;
                    }
                    break;
                }
                for (int j = idx - cnt - 1; j <= idx + cnt - 1; j++) {
                    switchArr[j] = (switchArr[j] + 1) % 2;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < switchCounts; i++) {
            sb.append(switchArr[i]).append(" ");
            cnt++;
            if (cnt == 20) {
                sb.append('\n');
                cnt = 0;
            }
        }
        System.out.println(sb.toString().trim());
    }
}