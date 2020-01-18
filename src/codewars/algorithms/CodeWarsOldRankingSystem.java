package codewars.algorithms;

import java.util.stream.IntStream;

import static codewars.Assert.assertEquals;

public class CodeWarsOldRankingSystem {

    private static void assertState(User user, int rank, int progress) {
        assertEquals(user.rank, rank);
        assertEquals(user.progress, progress);
    }

    public static void main(String[] args) {
        User user = new User();

        assertState(user, -8, 0);
        user.incProgress(-8);
        assertState(user, -8, 3);
        user.incProgress(8);
        assertState(user, 8, 0);
    }

    private static class User {
        private int rank;
        private int progress;

        public User() {
            this.rank = -8;
            this.progress = 0;
        }

        void incProgress(int exerciseRank) {
            int points = getPoints(exerciseRank) + progress;

            IntStream.range(0, points / 100)
                    .forEach(i -> levelUp());

            if (rank == 8) {
                progress = 0;
            } else {
                progress = points % 100;
            }
        }

        private int getPoints(int exerciseRank) {
            if (exerciseRank > 8 || exerciseRank < -8 || exerciseRank == 0) {
                throw new IllegalArgumentException("illegal argument");
            }

            int diff = (exerciseRank + 8) - (rank + 8);

            if (diff == 0) {
                return 3;
            } else if (diff == -1) {
                return 1;
            } else if (diff <= -2) {
                return 0;
            } else {
                return 10 * diff * diff;
            }
        }

        private void levelUp() {
            if (this.rank == -1) {
                rank = 1;
                return;
            }

            if (this.rank == 8) {
                return;
            }

            this.rank++;
        }
    }
}

//  https://www.codewars.com/kata/51fda2d95d6efda45e00004e/train/java