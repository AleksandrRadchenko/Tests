package java8_test_180726;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Dilshod_shelve_test {
    public static void main(String[] args) {
        Map<String, String> usageDays = new HashMap<>();
        String value = "value";
        String newValue = "newValue";
        String key = "key";
//        usageDays.put(key, "alreadyPResent");
        System.out.println(usageDays.get(key));
        System.out.println(
                Optional.ofNullable(usageDays.get(key))
                        .map(v -> System.out.println(newValue))
                        .orElse(usageDays.put(key, newValue)));
        System.out.println(usageDays.get(key));
//        if (usageDays.containsKey(key))
//        {
//            usageDays.get(key).concat(newValue);
//        }
//        else
//        {
//            usageDays.put(key, new UsageDay.Builder().withValues(ud));
//        }


    }
}
