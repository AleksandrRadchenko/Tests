package p190612_HashMap_oddiness;

import java.util.HashMap;
import java.util.Map;

/**
 * Even if mapping key->null exists, it counts as absent value
 * and replaced.
 */
public class PutIfAbsent {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.putIfAbsent("x", null);
        System.out.print(map.getOrDefault("x", "1"));
        map.putIfAbsent("x", "2");
        System.out.print(map.getOrDefault("x", "3"));
    }
}
