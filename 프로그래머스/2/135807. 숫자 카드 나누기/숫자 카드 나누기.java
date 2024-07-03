class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        int minA = arrayA[0];
        int minB = arrayB[0];

        minA = getMin(arrayA, minA);
        if (minA == 1) {
            minA = 0;
        }
        if (minA != 0 && checkDiv(arrayB, minA)) {
            minA = 0;
        }
        minB = getMin(arrayB, minB);
        if (minB == 1) {
            minB = 0;
        }
        if (minB != 0 && checkDiv(arrayA, minB)) {
            minB = 0;
        }

        return Math.max(minA, minB);
    }

    private static boolean checkDiv(int[] array, int min) {
        for (int a : array) {
            if (a % min == 0) {
                return true;
            }
        }
        return false;
    }

    private static int getMin(int[] arrayA, int minA) {
        while (minA >= 1) {
            boolean check = true;
            for (int a : arrayA) {
                if (a % minA != 0) {
                    minA--;
                    check = false;
                    break;
                }
            }
            if (check) {
                break;
            }
            if (minA == 1) {
                break;
            }
        }
        return minA;
    }
}