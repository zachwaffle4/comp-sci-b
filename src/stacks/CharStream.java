package stacks;

import java.util.stream.Stream;

public class CharStream {
    private final String expression;
    private int index = 0;

    public CharStream(String expression) {
        this.expression = expression;
    }

    public char next() {
        return expression.charAt(index++);
    }

    public boolean hasNext() {
        return index < expression.length();
    }

    public Stream<Character> stream() {
        return expression.codePoints().mapToObj(e -> (char) e);
    }

    public static CharStream of(String expression) {
        return new CharStream(expression);
    }
}
