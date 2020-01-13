package codewars.algorithms;

import codewars.Assert;

import java.util.ArrayList;

public class Scramblies {

    public static void main(String[] args) {
        Assert.assertEquals(scramble("rkqodlw", "world"), true);
        Assert.assertEquals(scramble("cedewaraaossoqqyt","codewars"),true);
        Assert.assertEquals(scramble("katas","steak"),false);
        Assert.assertEquals(scramble("scriptjavx","javascript"),false);
        Assert.assertEquals(scramble("scriptingjava","javascript"),true);
        Assert.assertEquals(scramble("scriptsjava","javascripts"),true);
        Assert.assertEquals(scramble("javscripts","javascript"),false);
        Assert.assertEquals(scramble("aabbcamaomsccdd","commas"),true);
        Assert.assertEquals(scramble("commas","commas"),true);
        Assert.assertEquals(scramble("sammoc","commas"),true);
    }

    public static boolean scramble(String str1, String str2) {
        if (str1.equals(str2)) return true;

        ArrayList<Character> charactersToFind = getArrayList(str2);

        char[] chars = str1.toCharArray();

        for (char c : chars) {
            charactersToFind.remove((Character) c);
        }

        return charactersToFind.isEmpty();
    }

    private static ArrayList<Character> getArrayList(String str) {
        ArrayList<Character> arrayList = new ArrayList<>();

        for (char c : str.toCharArray()) {
            arrayList.add(c);
        }

        return arrayList;
    }

}

// https://www.codewars.com/kata/55c04b4cc56a697bb0000048/train/java
