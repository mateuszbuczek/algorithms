package src.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*      Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

        Note:

        The solution set must not contain duplicate triplets.

        Example:

        Given array nums = [-1, 0, 1, 2, -1, -4],

        A solution set is:
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]
*/

public class ThreeSum {

    static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3) return new ArrayList<>();

        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < len - 2; i++) {
            int head = i + 1, tail = len - 1;
            while (head < tail) {
                int t1 = nums[head] + nums[tail] + nums[i];
                if(t1 < 0) head++;
                else if(t1 > 0) tail--;
                else {
                    List<Integer> t2 = Arrays.asList(nums[i], nums[head], nums[tail]);
                    if(!res.contains(t2))
                        res.add(t2);
                    head++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[] {-1, -1 , 0, 1, 2, 4});
    }
}
