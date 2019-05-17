package src.arrays;

import java.lang.reflect.Array;

public class Diagonals {

    static int diagonalDifference(int[][] arr) {

        int f = 0;
        int s = 0;

        for(int i = 0; i < arr[0].length; i++)
            for(int j = 0; j < arr[0].length; j++) {
                if(i == j) f += arr[i][j];
                if( i+j == arr[0].length - 1) s += arr[i][j];
            }

        return s > f ? s - f : f - s;
    }

    public static void main(String[] args) {
        System.out.println(diagonalDifference(new int[][] { {11,2,4}, {4,5,6}, {10,8,-12}}));
    }
}
