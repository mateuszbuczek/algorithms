package leetcode.arrays.missingpositive;

// leetcode.com/problems/first-missing-positive

public class Main {
    public static void main(String[] args) {
        System.out.println(new Main().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean[] available = new boolean[n + 1];

        for (int num : nums) {
            if (num > 0 && num <= n) {
                available[num] = true;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (!available[i]) {
                return i;
            }
        }
        return n + 1;
    }
}
