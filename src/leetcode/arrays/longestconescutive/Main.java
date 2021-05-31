package leetcode.arrays.longestconescutive;


// leetcode.com/problems/longest-consecutive-sequence

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int result = 0;

        for (int num : nums) { // O(n)
            set.add(num);
        }

        for (int startingCandidate : nums) { // O(n)
            int consecutiveCandidate;
            if (!set.contains(startingCandidate - 1)) {
                consecutiveCandidate = startingCandidate;
                while (set.contains(consecutiveCandidate)) {
                    consecutiveCandidate++;
                }

                if (result < consecutiveCandidate - startingCandidate) {
                    result = consecutiveCandidate - startingCandidate;
                }
            }
        }
        // 2 * O(n) ~ O(n)
        return result;
    }
}
