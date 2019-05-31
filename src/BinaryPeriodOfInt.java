package src;

public class BinaryPeriodOfInt {
    static int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        int p;


        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p <  l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < 1 + ( l / 2 ); ++i) {
                if (d[i] != d[i + p]) {
                    System.out.println(d[i+p] + " index: " + (i+p));
                    ok = false;
                    break;
                }
            }
            if (ok) {
                System.out.println(p);
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        solution(955);

    }
}
