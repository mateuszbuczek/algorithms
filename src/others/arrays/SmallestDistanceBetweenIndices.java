package src.arrays;

import java.util.HashSet;
import java.util.Set;

public class SmallestDistanceBetweenIndices {

    public static int sol(int[] A) {

        Set<Integer> set = new HashSet<>();

        for (int i : A) {
            set.add(i);
        }

        // i - possible distance between
        for (int i = 1; i < A.length; i++)
            for (int j = 0; j < A.length - i; j++) {

                boolean nothingBetween = true;

                // equal
                if(A[j] == A[i + j])
                    break;

                int from = A[j] > A[i + j] ? A[i + j] : A[j];
                int to = A[j] < A[i + j] ? A[i + j] : A[j];

                for (int k = from; k < to; k++) {
                    if(set.contains(k)) {
                        nothingBetween = false;
                        break;
                    }
                }

                if(nothingBetween)
                    return i;
            }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(sol(new int[] {1,4,7,3,3,5}));
    }
}
