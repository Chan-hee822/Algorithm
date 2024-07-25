import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    /**
     * 해결 로직:
     * 1. 두 개의 PriorityQueue를 사용하여 중간 값을 관리
     *    - left: 최대 힙으로 중간 값 이하의 숫자들을 저장
     *    - right: 최소 힙으로 중간 값 이상의 숫자들을 저장
     * 2. 초기 값을 입력받아 right 힙에 추가하고 중간 값으로 설정
     * 3. 이후 입력되는 숫자들을 순회하며:
     *    - 숫자가 중간 값보다 크거나 같으면 right 힙에 추가
     *    - 숫자가 중간 값보다 작으면 left 힙에 추가
     * 4. 두 힙의 크기 차이를 확인하여:
     *    - left 힙이 right 힙보다 2개 많으면 left 힙에서 값을 하나 꺼내어 right 힙에 추가
     *    - right 힙이 left 힙보다 2개 많으면 right 힙에서 값을 하나 꺼내어 left 힙에 추가
     * 5. 중간 값을 갱신합니다:
     *    - left 힙의 크기가 크면 중간 값은 left 힙의 루트 값
     *    - 두 힙의 크기가 같으면 중간 값은 두 힙의 루트 값 중 작은 값
     *    - right 힙의 크기가 크면 중간 값은 right 힙의 루트 값
     * 6. StringBuilder로 중간 값을 출력합니다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a); // 최대 힙
        PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙

        int centre = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(centre).append('\n');
        right.add(centre);
        
        for (int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            
            // 숫자를 적절한 힙에 추가
            if (centre <= num) {
                right.add(num);
            } else {
                left.add(num);
            }
            
            // 두 힙의 크기 차이를 조정
            if (left.size() > right.size() + 1) {
                right.add(left.poll());
            } else if (right.size() > left.size() + 1) {
                left.add(right.poll());
            }
            
            // 중간 값 갱신
            if (left.size() > right.size()) {
                centre = left.peek();
            } else if (left.size() == right.size()) {
                centre = Math.min(left.peek(), right.peek());
            } else {
                centre = right.peek();
            }
            
            sb.append(centre).append('\n');
        }
        
        System.out.println(sb.toString());
    }
}
