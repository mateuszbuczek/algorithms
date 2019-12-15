package src.arrays;

// largest K and -K exist in an array

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SmallestNumberThatExistsInAnArray {

    public static int solution(int[] A) {

        if(A == null)
            throw new IllegalArgumentException("given array shouldn't be null");

        Set<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        for (int i = 0; i < A.length; i++) {
            set.add(A[i]);
        }

        for(int item: set) {
            if(item > 0 && set.contains(item * -1))
                return item;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new int[] {3, 2, -2, 5, -3});
    }
}
