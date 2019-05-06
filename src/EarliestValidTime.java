package src;

// given six digits, find the eariliest valid time that can be bidplayed in 24-hour format

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EarliestValidTime {

        public static Map<Integer, Integer> secondDigitMap = new HashMap<>();
        public static Map<Integer, Integer> firstOrSecondDigitMap = new HashMap<>();
        public static final String NOT_POSSIBLE = "NOT POSSIBLE";

        public static String solution(int A, int B, int C, int D, int E, int F) {

            int[] tempArr = new int[]{A, B, C, D, E, F};

            int[] secondDigit = new int[3];
            int[] firstDigit = new int[3];
            Arrays.fill(secondDigit, -1);
            Arrays.fill(firstDigit, -1);

            // initialize HashMap
            for (int i : tempArr) {
                //must be second digit
                if (i > 5) {
                    if (secondDigitMap.containsKey(i)) {
                        // item already exists
                        secondDigitMap.put(i, secondDigitMap.get(i) + 1);
                    } else {
                        // item doesnt exist
                        secondDigitMap.put(i, 1);
                    }
                } else {
                    if (firstOrSecondDigitMap.containsKey(i)) {
                        // item already exists
                        firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) + 1);
                    } else {
                        // item doesnt exist
                        firstOrSecondDigitMap.put(i, 1);
                    }
                }

            }

            boolean flag = false;

            //seconds
            for (int i = 9; i > 5; i--) {
                if (secondDigitMap.containsKey(i) && secondDigitMap.get(i) > 0) {
                    secondDigit[2] = i;
                    secondDigitMap.put(i, secondDigitMap.get(i) - 1);
                    flag = true;
                    break;
                }
            }

            if (!flag)
                for (int i = 5; i >= 0; i--) {
                    if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                        secondDigit[2] = i;
                        firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                        flag = true;
                        break;
                    }
                }


            for (int i = 5; i >= 0; i--) {
                if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                    firstDigit[2] = i;
                    firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                    flag = true;
                    break;

                }
            }

            //minutes
            flag = false;
            for (int i = 9; i > 5; i--) {
                if (secondDigitMap.containsKey(i) && secondDigitMap.get(i) > 0) {
                    secondDigit[1] = i;
                    secondDigitMap.put(i, secondDigitMap.get(i) - 1);
                    flag = true;
                    break;

                }
            }

            if (!flag)
                for (int i = 5; i >= 0; i--) {
                    if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                        secondDigit[1] = i;
                        firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                        flag = true;
                        break;

                    }
                }


            for (int i = 5; i >= 0; i--) {
                if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                    firstDigit[1] = i;
                    firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                    flag = true;
                    break;

                }
            }
            //hours
            flag = false;
            for (int i = 9; i > 5; i--) {
                if (secondDigitMap.containsKey(i) && secondDigitMap.get(i) > 0) {
                    secondDigit[0] = i;
                    secondDigitMap.put(i, secondDigitMap.get(i) - 1);
                    flag = true;
                    break;

                }
            }
            if (!flag)
                for (int i = 4; i >= 0; i--) {
                    if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                        secondDigit[0] = i;
                        firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                        break;
                    }

                }


            for (int i = 2; i >= 0; i--) {
                if (firstOrSecondDigitMap.containsKey(i) && firstOrSecondDigitMap.get(i) > 0) {
                    firstDigit[0] = i;
                    firstOrSecondDigitMap.put(i, firstOrSecondDigitMap.get(i) - 1);
                    break;
                }
            }

            if(firstDigit[0] != -1 && secondDigit[0] != -1) return firstDigit[0] + "" + secondDigit[0]  + ":"
                                                                        + firstDigit[1]  + secondDigit[1]+ ":"
                                                                        + firstDigit[2]  + secondDigit[2];

            return NOT_POSSIBLE;
        }

    public static void main(String[] args) {
        System.out.println(solution(1,8,3,2,6,4));
        System.out.println(solution(0,0,0,0,0,0));
        System.out.println(solution(0,7,0,8,0,9));
    }


}
