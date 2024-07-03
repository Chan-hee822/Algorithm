import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int sizeX = book_time.length;
        int sizeY = book_time[0].length;
        int[][] bookTimeToMin = new int[sizeX][sizeY];
        timeToMin(book_time, sizeX, sizeY, bookTimeToMin);
        int[][] sortedBookTimeArr = Arrays.stream(bookTimeToMin)
                .sorted((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]).toArray(int[][]::new);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int roomList = 0;
        for (int i = 0; i < sortedBookTimeArr.length; i++) {
            if (pq.isEmpty()) {
                roomList++;
                answer++;
                pq.add(sortedBookTimeArr[i][1] + 10);
                continue;
            }
            int[] newRoom = sortedBookTimeArr[i];
            if (newRoom[0] < pq.peek()) {
                if (answer == roomList) {
                    answer++;
                    roomList++;
                    pq.add(newRoom[1] + 10);
                } else if (answer > roomList) {
                    roomList++;
                    pq.add(newRoom[1] + 10);
                }
            } else {
                while (!pq.isEmpty() && newRoom[0] >= pq.peek()) {
                    pq.poll();
                    roomList--;
                }
                roomList++;
                pq.add(newRoom[1] + 10);
            }

        }
        return answer;
    }

    private static void timeToMin(String[][] book_time, int sizeX, int sizeY, int[][] bookTimeToMin) {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                String[] time = book_time[i][j].split(":");
                bookTimeToMin[i][j] = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
            }
        }
    }
}