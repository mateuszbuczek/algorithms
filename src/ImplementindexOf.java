public class ImplementindexOf {
    static int indexOf1 (String haystack, String needle) {
        if(needle.isEmpty()) return 0;

        for(int i = 0; i < haystack.length(); i++){
            if(haystack.charAt(i) == needle.charAt(0)) {
                int j;
                for(j = 1; j < needle.length(); j++) {
                    if(haystack.charAt(i+j) != needle.charAt(j))
                        break;
                }
                if(j == needle.length())
                    return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(indexOf1("hello","ll"));
    }
}
