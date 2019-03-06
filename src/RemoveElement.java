public class RemoveElement {
    static int removeElement(int[] nums, int val) {
        if(nums.length == 0) return 0;
        int x = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                x++;
                nums[x] = nums[i];
            }
        }
        return x-2;
    }

    public static void main(String[] args) {
        removeElement(new int[] {0,2,3,4,5,232,1,2},2);

    }
}
