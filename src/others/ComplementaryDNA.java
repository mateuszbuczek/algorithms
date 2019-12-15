package others;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ComplementaryDNA {

    public static String makeComplement(String dna) {

        Map<Character, Character> map = Map.of('A', 'T', 'G', 'C', 'T', 'A', 'C', 'G');

        StringBuilder stringBuilder = new StringBuilder();

        for (Character i : dna.toUpperCase().toCharArray()) {
            stringBuilder.append(map.get(i));
        }

        return stringBuilder.toString();
    }

    // another solution
    private static Map<Character, String> map = new HashMap<>();

    static {
        map.put('A', "T");
        map.put('T', "A");
        map.put('C', "G");
        map.put('G', "C");
    }

    public String makeComplement1(String dna) {
        return dna.chars()
                .mapToObj(val -> map.get((char) val))
                .collect(Collectors.joining(""));
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        System.out.println(makeComplement("aagcT"));
    }
}
