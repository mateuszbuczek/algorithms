package others;

public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        String[] arr = s.split(" ");
        if(arr.length < 2) return 0;
        return arr[arr.length-1].length();
    }

    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord1(" wer we wergasdf"));
    }
}
