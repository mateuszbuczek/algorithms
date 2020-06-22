package codewars.arrays;

import codewars.Assert;

class EnoughValue {

    public static void main(String[] args){
        Assert.assertEquals(true, tickets(new int[] {25, 25, 50}));
        Assert.assertEquals(false, tickets(new int[]{25, 100}));
        Assert.assertEquals(false, tickets(new int[] {25, 25, 50, 50, 100}));

        System.out.println("Success");
    }

    public static boolean tickets(int[] peopleInLine) {
        boolean result = true;

        int twoFive = 0;
        int fiveZero = 0;
        int oneZeroZero = 0;

        for (int value : peopleInLine) {
            switch (value) {
                case 25:
                    twoFive++;
                    break;
                case 50:
                    twoFive--;
                    fiveZero++;
                    break;
                case 100:
                    if (fiveZero > 0) {
                        fiveZero--;
                    } else {
                        twoFive -= 2;
                    }
                    twoFive--;
                    oneZeroZero++;
                    break;
                default:
                    throw new RuntimeException("Not possible to determine billon");
            }

            if (twoFive < 0 || fiveZero < 0 || oneZeroZero < 0) {
                result = false;
                break;
            }
        }

        return result;
    }
}

// https://www.codewars.com/kata/555615a77ebc7c2c8a0000b8/train/java
