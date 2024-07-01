import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    int baseTime;
    int baseFee;
    int perTime;
    int perFee;

    public int[] solution(int[] fees, String[] records) {

        Map<String, Integer> totalTime = new HashMap<>();
        Map<String, Integer> carInTime = new HashMap<>();
        Map<String, Integer> carTotalFee = new HashMap<>();

        baseTime = fees[0];
        baseFee = fees[1];
        perTime = fees[2];
        perFee = fees[3];

        for (String record : records) {
            String[] recordArr = record.split(" ");
            int time = getMin(recordArr[0]);
            String carNumber = recordArr[1];
            //
            if (!carInTime.containsKey(carNumber)) {
                carInTime.put(carNumber, time);
            } else {
                insertParkingTime(carInTime.get(carNumber), time, totalTime, carNumber);
                carInTime.remove(carNumber);
            }
        }
        if (!carInTime.isEmpty()) {
            for (Map.Entry<String, Integer> item : carInTime.entrySet()) {
                String carNumber = item.getKey();
                insertParkingTime(item.getValue(), getMin("23:59"), totalTime, carNumber);
            }
        }
        for (Map.Entry<String, Integer> item : totalTime.entrySet()) {
            String carNumber = item.getKey();
            int fee = getFee(item.getValue());
            carTotalFee.put(carNumber, fee);
        }
        int[] answer = carTotalFee.entrySet()
                .stream()
                .sorted((a, b) -> Integer.parseInt(a.getKey()) - Integer.parseInt(b.getKey()))
                .mapToInt(Map.Entry::getValue)
                .toArray();
        return answer;
    }

    private static void insertParkingTime(Integer carInTime, int time, Map<String, Integer> totalTime, String carNumber) {
        int inTime = carInTime;
        int outTime = time;
        if (totalTime.containsKey(carNumber)) {
            totalTime.put(carNumber, totalTime.get(carNumber) + (outTime - inTime));
        } else {
            totalTime.put(carNumber, outTime - inTime);
        }
    }

    public int getFee(int totalTime) {
        if (totalTime <= baseTime) {
            return baseFee;
        }
        totalTime -= baseTime;
        totalTime = totalTime % perTime == 0 ? totalTime / perTime : totalTime / perTime + 1;
        return baseFee + totalTime * perFee;
    }

    public static int getMin(String time) {
        String[] timeArr = time.split(":");
        int hour = Integer.parseInt(timeArr[0]);
        int min = Integer.parseInt(timeArr[1]);
        return hour * 60 + min;
    }
}