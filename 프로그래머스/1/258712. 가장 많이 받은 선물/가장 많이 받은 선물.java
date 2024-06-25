import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        Map<String, Integer> friendMap = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendMap.put(friends[i], i);
        }
        int sizeFriends = friends.length;
        int[][] friendGiftTable = new int[sizeFriends][sizeFriends];
        int[] giftIndex = new int[sizeFriends];
        for (int i = 0; i < gifts.length; i++) {
            String nameFrom = gifts[i].split(" ")[0];
            String nameTo = gifts[i].split(" ")[1];
            int numToNameFrom = friendMap.get(nameFrom);
            int numToNameTo = friendMap.get(nameTo);
            friendGiftTable[numToNameFrom][numToNameTo]++;
            giftIndex[numToNameFrom]++;
            giftIndex[numToNameTo]--;
        }

        int[] result = new int[sizeFriends];
        for (int i = 0; i < sizeFriends; i++) {
            for (int j = 0; j < sizeFriends; j++) {
                if (i == j) {
                    continue;
                }
                int give = friendGiftTable[i][j];
                int get = friendGiftTable[j][i];
                if (give > get) {
                    result[i]++;
                } else if (give == get) {
                    if (giftIndex[i] > giftIndex[j]) {
                        result[i]++;
                    }
                }
            }
        }
        answer = Arrays.stream(result).max().getAsInt();

        return answer;
    }
}