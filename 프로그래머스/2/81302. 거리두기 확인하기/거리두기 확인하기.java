import java.util.Arrays;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        Arrays.fill(answer, 1);

        int[] dx = {0, -1, 0, 1};
        int[] dy = {1, 0, -1, 0};

        for (int idx = 0; idx < places.length; idx++) {
            String[] place = places[idx];
            String[][] room = new String[5][5];
            makeRoom(place, room);
            int size = room.length;
            Loop:
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    String letter = room[i][j];
                    if (letter.equals("P")) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int newX = i + dx[k];
                            int newY = j + dy[k];
                            if (newX >= 0 && newX < size & newY >= 0 && newY < size) {
                                if (room[newX][newY].equals("P")) {
                                    cnt++;
                                    break;
                                }
                            }
                        }
                        if (cnt > 0) {
                            answer[idx] = 0;
                            break Loop;
                        }
                    } else if (letter.equals("O")) {
                        int cnt = 0;
                        for (int k = 0; k < 4; k++) {
                            int newX = i + dx[k];
                            int newY = j + dy[k];
                            if (newX >= 0 && newX < size & newY >= 0 && newY < size) {
                                if (room[newX][newY].equals("P")) {
                                    cnt++;
                                }
                            }
                        }
                        if (cnt >= 2) {
                            answer[idx] = 0;
                            break Loop;
                        }
                    }
                }
            }
        }
        return answer;
    }

    private static void makeRoom(String[] place, String[][] room) {

        for (int i = 0; i < 5; i++) {
            room[i] = place[i].split("");
        }
    }
}