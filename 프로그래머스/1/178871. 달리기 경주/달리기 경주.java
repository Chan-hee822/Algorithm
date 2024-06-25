import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int idx = map.get(call);
            String temp = players[idx - 1];
            players[idx - 1] = call;
            players[idx] = temp;
            map.put(temp, idx);
            map.put(call, idx - 1);
        }

        return players;
    }
}