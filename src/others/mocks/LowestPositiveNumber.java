package src.mocks;

import java.util.Arrays;

public class LowestPositiveNumber {

    public static int solution(int[] A) {
        Arrays.sort(A);

        if(A[A.length-1] < 1) return 1;

        int smallest = A[A.length - 1] + 1;

        for (int i = 0; i < A.length - 1; i++) {
            if(isSpace(A[i], A[i+1])) {
                smallest = A[i] + 1;
                break;
            }
        }

        return smallest;
    }

    public static boolean isSpace(int a, int b) {
        if(a == b || a+1 == b) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));
    }
}
