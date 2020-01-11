package codewars;

import java.util.Objects;

public class Assert {

    public static void assertEquals(Object a, Object b) {
        if (Objects.isNull(a) || Objects.isNull(b)) {
            throw new IllegalArgumentException("arguments cannot be null");
        }

        if (!a.equals(b)) {
            throw new AssertionError(String.format("'%s' is not equal to '%s'", a, b));
        }
    }
}
