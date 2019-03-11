import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class SingleNumber {
    static int singleNumber(int[] nums) {
        int s = 0;

        //using XOR
        for(int num : nums) {
            s ^= num;
        }
        return s;
    }

    static int singleNumber1(int[] nums) {
        HashSet<Integer> h = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(h.contains(nums[i]))
                h.remove(nums[i]);
            else
                h.add(nums[i]);
        }
        return h.iterator().next();
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {3,4,3,1,1,4,2,5,2}));
        System.out.println(singleNumber1(new int[] {3,4,3,1,1,4,2,5,2}));

    }
}
