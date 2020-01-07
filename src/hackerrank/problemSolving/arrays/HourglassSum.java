package hackerrank.problemSolving.arrays;

import java.awt.*;
import java.util.Arrays;

public class HourglassSum {

    private static void putValue(int[][] arr, Point point, int value) {
        arr[point.x][point.y] = value;
    }

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        putValue(arr, new Point(0, 0), 1);
        putValue(arr, new Point(1, 0), 1);
        putValue(arr, new Point(2, 0), 1);
        putValue(arr, new Point(1, 1), 1);
        putValue(arr, new Point(0, 2), 1);
        putValue(arr, new Point(1, 2), 1);
        putValue(arr, new Point(2, 2), 1);

        putValue(arr, new Point(2, 3), 2);
        putValue(arr, new Point(3, 3), 4);
        putValue(arr, new Point(4, 3), 4);
        putValue(arr, new Point(3, 4), 2);
        putValue(arr, new Point(2, 5), 1);
        putValue(arr, new Point(3, 5), 2);
        putValue(arr, new Point(4, 5), 4);

        System.out.println(hourglassSum(arr));
        return;
    }

    static int hourglassSum(int[][] arr) {
        int maximumSum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (isPossibleToGetHourglassSum(new Point(i, j), arr)) {
                    int hourglassSum = getHourglassSum(new Point(i, j), arr);
                    maximumSum = Math.max(maximumSum, hourglassSum);
                }
            }
        }

        return maximumSum;
    }


    private static int getHourglassSum(Point topLeftCorner, int[][] arr) {
        Point point = new Point(topLeftCorner.x + 1, topLeftCorner.y);
        Point point1 = new Point(topLeftCorner.x + 2, topLeftCorner.y);
        Point point2 = new Point(topLeftCorner.x + 1, topLeftCorner.y + 1);
        Point point3 = new Point(topLeftCorner.x, topLeftCorner.y + 2);
        Point point4 = new Point(topLeftCorner.x + 1, topLeftCorner.y + 2);
        Point point5 = new Point(topLeftCorner.x + 2, topLeftCorner.y + 2);

        return getSumOfPoints(arr, topLeftCorner, point, point1, point2, point3, point4, point5);
    }

    private static int getSumOfPoints(int[][] arr, Point... points) {
        return Arrays.stream(points)
                .mapToInt(point -> arr[point.x][point.y])
                .sum();
    }

    private static boolean isPossibleToGetHourglassSum(Point topLeftCorner, int[][] arr) {
        return topLeftCorner.x + 2 < arr.length && topLeftCorner.y + 2 < arr[0].length;
    }
}

//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
