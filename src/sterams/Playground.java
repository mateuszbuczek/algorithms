package src.sterams;

import java.util.stream.Stream;

public class Playground {

    public static void main(String[] args) {

        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

    }
}
