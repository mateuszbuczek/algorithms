package others;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        // First we need to keep track of current minimum subarray sum we've seen so far;
        int currMin = 0;
        // Second we need to keep track of current sum of subarray so far
        int currSum = 0;
        // everytime we find currSum - currMin > maxSum, we will update maxSum
        int maxSum = Integer.MIN_VALUE;

        // iterate through input nums array
        for(int num: nums) {
            // get sum of current subarray [0 ... num]
            currSum += num;
            // check to see if we need to update maxSum
            if(currSum - currMin > maxSum) maxSum = currSum-currMin;
            // update current min
            currMin = Math.min(currMin, currSum);
        }

        return maxSum;
    }

    // Kadane's algorithm
    public int maxSubAray1(int[] nums) {
        if(nums.length == 0) return 0;

        int curMax = nums[0];
        int allMax = nums[0];

        for(int i = 1; i< nums.length; i++) {
            curMax = Math.max(nums[i], curMax + nums[i]);
            allMax = Math.max(curMax, allMax);
        }

        return allMax;
    }
}
