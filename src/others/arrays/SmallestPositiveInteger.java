//given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

package src.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SmallestPositiveInteger {

//    public int solution(int[] A) {
//        Arrays.sort(A);
//
//        int min = 1;
//
//        for (int i = 0; i < A.length; i++) {
//            if(A[i] == min) min += 1;
//        }
//
//        return min;
//    }

    public int solution(int[] A) {

        Set<Integer> set = new HashSet<>();

        int max = 1;

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
            if(A[i] > max) max = A[i];
        }

        for (int i = 1; i <= max + 1; i++) {
            if(!set.contains(i)) return i;
        }

        return -1;
    }
}
