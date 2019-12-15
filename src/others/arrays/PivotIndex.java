package src.arrays;

public class PivotIndex {

    public static int pivotIndex(int[] nums) {

        if(nums.length < 2) return -1;

        int leftSum = 0;
        int rightSum = 0;
        for(int item : nums) {
            rightSum += item;
        }

        for (int i = 0; i < nums.length; i++) {
            if(i > 0) {
                leftSum += nums[i - 1];
                rightSum -= nums[i - 1];
            }

            if(leftSum == rightSum - nums[i]) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[] {1,7,3,6,5,6}));
    }
}
