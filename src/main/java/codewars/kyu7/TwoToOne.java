package codewars.kyu7;

import java.util.Arrays;

public class TwoToOne {
    public static void main(String[] args) {
        longest("aretheyhere", "yestheyarehere");
    }

    public static String longest(String s1, String s2) {
        String concatenated = s1.concat(s2);
        char[] chars = concatenated.toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = (char) chars[i];
        }

        return Arrays.stream(ints)
                     .sorted()
                     .distinct()
                     .mapToObj(i -> (char) i)
                     .collect(
                                 StringBuilder::new,
                                 StringBuilder::append,
                                 StringBuilder::append)
                     .toString();
    }
}
