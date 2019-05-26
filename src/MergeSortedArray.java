package src;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m--];
            } else {
                nums1[m + n + 1] = nums2[n--];
            }
        }
        while (n >= 0) {
            nums1[n] = nums2[n--];
        }
    }

    public static void main(String[] args) {
        merge(new int[] {3,4,5,0,0,0}, 3, new int[] {0,1,2}, 3);
    }
}
