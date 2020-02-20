package a180911;

public class RevertString {
    public static char[] reverseStringUsingStringBuilder(String expr) {
        char[] chars = expr.toCharArray();
        StringBuilder sb = new StringBuilder(new String(chars));
        return sb.reverse().toString().toCharArray();
    }

    public static char[] reverseStringUsingFor(String expr) {
        char[] chars = expr.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char tmp = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = tmp;
        }
        return chars;
    }
}
