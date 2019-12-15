package others;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MajorityElement {

    // brute force
    static int majorityElement(int[] nums) {
        int majorityCount  = nums.length/2;

        for(int num : nums) {
            int count = 0;
            for(int elem : nums)
                if(elem == num)
                    count++;

            if(count > majorityCount)
                return num;
        }

        return -1;
    }

    // hashmap
    private static Map<Integer,Integer> countNums(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for(int num: nums) {
            if(!counts.containsKey(num)) {
                counts.put(num, 1);
            } else {
                counts.put(num, counts.get(num) + 1);
            }
        }

        return counts;
    }

    static int majorityElement1(int[] nums) {
        Map<Integer,Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntry = null;
        for(Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }

        return majorityEntry.getValue();
    }

    // if majority is defined as more than 50% of an array then majority element can be found at n/2 index
    static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // randomization - more than n/2 array indices are occupied by majority element
    static int randRange(Random rand, int min, int max) {
        return rand.nextInt(max-min) + min;
    }

    static int countOccurences(int[] nums, int num) {
        int count = 0;
        for(int e: nums)
            if(e == num)
                count++;

        return count;
    }

    static int majorityElement3(int[] nums) {
        Random rand = new Random();

        int majorityCount = nums.length / 2;

        while (true) {
            int candidate = nums[randRange(rand,0,nums.length)];
            if(countOccurences(nums, candidate) > majorityCount)
                return candidate;
        }
    }
}
