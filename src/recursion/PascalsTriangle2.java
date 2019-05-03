//  Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
//
//  Note that the row index starts from 0.

package src.recursion;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        return helper(list, rowIndex);

    }

    public static List<Integer> helper(List<Integer> list, int rowIndex) {

        List<Integer> newList = new ArrayList<>();
        // base case
        if(rowIndex == list.size()) return list;
        if(rowIndex == 1 || list.size() == 0) newList.add(1);
        else if(rowIndex > 1) {
            for (int i = 0; i < list.size(); i++) {
                if(i == 0) newList.add(1);
                if(i > 0) newList.add(list.get(i-1) + list.get(i));
                if(i == list.size() - 1) newList.add(1);
            }
        }
        return helper(newList, rowIndex);
    }

    public static void main(String[] args) {
        System.out.println(getRow(10));
    }
}
