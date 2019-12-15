package others;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    // Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    // You may assume that each input would have exactly one solution, and you may not use the same element twice.


    class Solution {
        // Brute force
        // public int[] twoSum(int[] nums, int target) {
        //     for(int i = 0; i < nums.length; i++)
        //         for(int j = i + 1; j < nums.length; j++)
        //             if(nums[i]+nums[j] == target)
        //                 return new int[] {i, j};
        //     throw new IllegalArgumentException("No two sum solution");
        // }
        // time complexity: O(n^2)
        // space complexity: O(1)

        // One-pass Hash Table
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (map.containsKey(complement)) {
                    return new int [] {map.get(complement), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum solution");
        }
        // time complexity: O(n)
        // space complexity: O(n)
    }
}
