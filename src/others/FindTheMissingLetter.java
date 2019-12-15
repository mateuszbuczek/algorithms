package others;

//#Find the missing letter
//
//        Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
//
//        You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
//        The array will always contain letters in only one case.

public class FindTheMissingLetter {
    public static char findMissingLetter(char[] array) {

        char curr = array[0];
        char prev = array[0];

        for (int i = 0; i < array.length; i++) {
            curr = array[i];
            if(curr == prev + 2) return prev++;
            prev = array[i];
        }
        return ' ';
    }

    public static char findMissingLetter1(char[] array) {
        char expectableLetter = array[0];
        for(char letter : array) {
            if(letter != expectableLetter) break;
            expectableLetter++;
        }
        return expectableLetter;
    }

    public static void main(String[] args) {
        System.out.println(findMissingLetter(new char[] { 'a','b','c','d','f' }));
    }
}
