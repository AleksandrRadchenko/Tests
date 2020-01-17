package codewars.kyu7;

import java.util.HashMap;
import java.util.Map;

public class TwoToOne {
    public static String longestMap(String s1, String s2) {
        char[] conc = s1.concat(s2).toCharArray();
        Map<Character, Boolean> alphabet = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabet.put(ch, false);
        }
        for (char c : conc) {
            alphabet.put(c, true);
        }
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (Boolean.TRUE.equals(alphabet.get(ch))) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String longestArraySpeedOptimized(String s1, String s2) {
        boolean[] alphabet = new boolean['z' + 1];
        char[] conc = s1.concat(s2).toCharArray();
        for (char c : conc) {
            alphabet[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (alphabet[ch]) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static String longestArrayMemOptimized(String s1, String s2) {
        boolean[] alphabet = new boolean['z' - 'a' + 1];
        char[] conc = s1.concat(s2).toCharArray();
        for (char c : conc) {
            alphabet[c - 'a'] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (alphabet[ch - 'a']) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
