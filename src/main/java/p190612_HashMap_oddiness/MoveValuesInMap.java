package p190612_HashMap_oddiness;

import java.util.HashMap;
import java.util.Map;

public class MoveValuesInMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "1value");
        map.put("2", "2value");

        String oldKey = "1";
        String newKey = "2";

        String oldValue = map.remove(oldKey);
        map.compute(newKey, (k, v) -> oldValue == null ? v : oldValue);
        System.out.println(map);
    }
}
