import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        // s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"
        s = s.replaceAll("[\\{\\}]", "");
        // s = "2,2,1,2,1,3,2,1,3,4"
        String[] arrFromS = s.split(",");
        HashMap<String, Integer> map = new HashMap<>();
        for (String num : arrFromS) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(map.entrySet());
        answer = entryList.stream().sorted((x, y) -> y.getValue() - x.getValue())
                .map(Map.Entry::getKey).mapToInt(Integer::parseInt).toArray();
        return answer;
    }
}