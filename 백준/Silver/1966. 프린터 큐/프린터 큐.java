import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Printer {

    int idx;
    int point;

    public Printer(int idx, int point) {
        this.idx = idx;
        this.point = point;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * Map과 queue 사용해서 풀이
         * Map -> key = 중요도, value = 해당 중요도 개수
         * Queue -> 프린트 요청 순서
         * 반복문 9 ~ 1 까지 돌면서 Map에 해당 숫자를 key로 가지고 있는지 체크
         * 해당 키 존재 시 :
         *   1. queue peek 값의 중요도 값이 해당 key와 일치하는지 체크
         *   2. 일치하면 queue에서 제거 후, 해당 key의 value 값도 하나 줄임, key의 value가 0이 되면 Map에서도 해당 key 삭제, 결과 리스트에 추가
         *   3. queue peek 값의 중요도 값이 해당 key와 일치하지 않으면 queue 최상단 값을 poll -> 마지막으로 push
         * 해당 키 존재 x :
         *   하나 낮은 중요도로 넘어감
         * 결과 리스트에서 원하는 인덱스(M) 인 프린트를 찾아 출력
         * (결과 리스트에는 중요도 순으로 프린트가 정렬음)
         * 리스트에 담기는 타입 :
         *  Print Class -> new Print(인덱스, 중요도)
         *  print.idx = 원하는 인덱스 일 때 출력
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 테스트 개수
        int C = Integer.parseInt(br.readLine());
        // 테스트 개수 순회
        for (int c = 0; c < C; c++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 프린트 요청 개수
            int N = Integer.parseInt(st.nextToken());
            // 몇 번째로 출력되는지 알고 싶은 idx
            int M = Integer.parseInt(st.nextToken());
            // 프린트 요청 담는 큐
            Queue<Printer> printers = new LinkedList<>();
            // 중요도 당 개수 담는 맵
            Map<Integer, Integer> map = new HashMap<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int temp = Integer.parseInt(st.nextToken());
                printers.add(new Printer(i, temp));
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
            // 정답 담는 리스트
            List<Printer> list = new ArrayList<>();
            // 중요도 9부터 해당 중요도와 맞는 프린트 있는지 순회
            for (int i = 9; i >= 1; i--) {
                while (map.containsKey(i)) {
                    // 해당 중요도 있을 때
                    if (printers.peek().point == i) {
                        list.add(printers.poll());
                        // 해당 중요도 마지막일 때
                        if (map.get(i) == 1) {
                            map.remove(i);
                            continue;
                        }
                        // 프린트할 것이기 때문에 1감소
                        map.put(i, map.get(i) - 1);
                        continue;
                    }
                    // 프린트의 중요도가 key과 같지 않으면 마지막으로 옮김
                    printers.add(printers.poll());
                }
            }
            // 원하는 인덱스를 가진 프린트 찾아 출력
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).idx == M) {
                    System.out.println(i + 1);
                }
            }
        }
    }
}
