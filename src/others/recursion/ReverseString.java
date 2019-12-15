//Write a function that reverses a string. The input string is given as an array of characters char[].
//Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
//You may assume all the characters consist of printable ascii characters.

package src.recursion;

public class ReverseString {

    private static char[] reverseString(char[] arr) {
        StringBuffer s = new StringBuffer();
        helper(0, arr, s);
        return s.toString().toCharArray();
    }

    private static void helper(int index, char[] arr, StringBuffer s) {

        if(arr == null || arr.length <= index ) return;
        helper(index + 1, arr, s);
        s.append(arr[index]);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("dash".toCharArray()));
    }
}
