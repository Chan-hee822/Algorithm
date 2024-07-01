import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int n = topping.length;
        // 나누었을 때 해당 자리 토핑 수
        int[] leftToppings = new int[n];
        int[] rightToppings = new int[n];
        
        // 토핑을 담는 set, 크기로 토핑 개수 체크
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
        
        // 왼쪽에서 오른쪽으로 가며 각 위치에서의 토핑 가짓수 저장
        for (int i = 0; i < n; i++) {
            leftSet.add(topping[i]);
            leftToppings[i] = leftSet.size();
        }

        // 오른쪽에서 왼쪽으로 가며 각 위치에서의 토핑 가짓수 저장
        for (int i = n - 1; i >= 0; i--) {
            rightSet.add(topping[i]);
            rightToppings[i] = rightSet.size();
        }

        // 공평하게 나눌 수 있는 방법의 수 count
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (leftToppings[i] == rightToppings[i + 1]) {
                count++;
            }
        }

        return count;
    }
}