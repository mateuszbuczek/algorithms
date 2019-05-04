package src.binarysearch;

public class BinarySearch {

    public int search(int[] nums, int l, int r, int target) {

        if(r >= l) {
            int mid = l + (r - l)/2;

            if(nums[mid]== target) return mid;
            if(nums[mid] > target) return search(nums, l, mid - 1, target);
            return search(nums, mid + 1, r, target);
        }

        return -1;
    }
}

//Time complexity O(log n) n-> n/2 ->n/4
//Space complexity O(1)