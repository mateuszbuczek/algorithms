package src.hackerrank.all;

public class JumpingOnClouds {

    public static void main(String[] args) {
        int jumps = jumpingOnClouds(new int[]{0, 0, 1, 0, 0, 1, 0});
        int jumps2 = jumpingOnClouds(new int[]{0, 0, 0, 0, 1, 0});
        int jumps3 = jumpingOnClouds(new int[]{0, 0, 0, 1, 0, 0});
        return;
    }

    static int jumpingOnClouds(int[] c) {
        int jumps = 0;

        for (int i = 0; i < c.length;) {
            if (isPossibleToJump(c, i + 2)) {
                i+=2;
                jumps++;
            } else if (isPossibleToJump(c, i + 1)) {
                i++;
                jumps++;
            } else {
                break;
            }
        }

        return jumps;
    }

    static boolean isPossibleToJump(int[] c, int pos) {
        if (pos >= c.length) return false;
        if (c[pos] == 1) return false;

        return true;
    }
}

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup