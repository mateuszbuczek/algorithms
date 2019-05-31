package src.arrays;

public class PairsOfSameElements {
    public static int solution(int[] A) {

        int pairs = 0;

        for (int i = 0; i < A.length; i++)
            for (int j = i+1; j < A.length; j++)
                if(A[i] == A[j]) pairs += 1;

        return pairs;
    }

    public static void main(String[] args) {
        solution(null);
    }
}
