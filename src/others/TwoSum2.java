package others;

import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
//    Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
//    The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.


    class Solution {
//         Brute force
            public int[] twoSum(int[] numbers, int target)
            {
                int first=0, last=numbers.length-1;
                while(numbers[first]+numbers[last] !=target)
                {
                    if(numbers[first]+numbers[last] > target)
                        last--;
                    else first++;
                }
                return new int[]{first+1,last+1};
            }
//         time complexity: O(n)

        // One-pass Hash Table
//        public int[] twoSum(int[] nums, int target) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for(int i = 0; i < nums.length; i++) {
//                int complement = target - nums[i];
//                if (map.containsKey(complement)) {
//                    return new int [] {map.get(complement), i};
//                }
//                map.put(nums[i], i);
//            }
//            throw new IllegalArgumentException("No two sum solution");
//        }
        // time complexity: O(n)
        // space complexity: O(n)
    }
}
