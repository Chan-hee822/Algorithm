import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public String[] solution(int[][] line) {
        Set<Point> points = new HashSet<>();
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        // 1. 모든 직선 쌍에 대해 교점 구하기
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long[] p = getIntersection(line[i], line[j]);
                if (p != null) {
                    int x = (int) p[0];
                    int y = (int) p[1];
                    points.add(new Point(x, y));
                    minX = Math.min(minX, x);
                    minY = Math.min(minY, y);
                    maxX = Math.max(maxX, x);
                    maxY = Math.max(maxY, y);
                }
            }
        }

        // 2. 결과 격자 생성
        int width = maxX - minX + 1;
        int height = maxY - minY + 1;
        char[][] grid = new char[height][width];

        for (int i = 0; i < height; i++) {
            Arrays.fill(grid[i], '.');
        }

        for (Point p : points) {
            int x = p.x - minX;
            int y = maxY - p.y;
            grid[y][x] = '*';
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = new String(grid[i]);
        }

        return result;
    }

    private long[] getIntersection(int[] line1, int[] line2) {
        long A1 = line1[0], B1 = line1[1], C1 = line1[2];
        long A2 = line2[0], B2 = line2[1], C2 = line2[2];

        long det = A1 * B2 - A2 * B1;
        if (det == 0) {
            return null; // 평행 또는 동일한 직선
        }

        long x = B1 * C2 - B2 * C1;
        long y = A2 * C1 - A1 * C2;

        if (x % det != 0 || y % det != 0) {
            return null; // 정수가 아닌 교점
        }

        return new long[]{x / det, y / det};
    }

    private class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
}