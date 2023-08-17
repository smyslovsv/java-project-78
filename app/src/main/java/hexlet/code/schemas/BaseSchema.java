package hexlet.code.schemas;

import java.util.*;
import java.util.function.Predicate;

public class BaseSchema {
    private static Map<String, Predicate<Object>> checks;

    public BaseSchema() {
        checks = new LinkedHashMap<>();
    }

    public final boolean isValid(Object value) {
        Set<String> set = checks.keySet();
        List<String> list = new ArrayList<>(set);
        for (String s : list) {
            System.out.println("Checked " + s
                    + " -> " + checks.get(s).test(value));
            if (!checks.get(s).test(value)) {
                return false;
            }
        }
//        for (Predicate<Object> check : checks.values()) {
//            if (!check.test(value))
//                return false;
//        }
        return true;
    }

    public final void addCheck(String typeCheck, Predicate<Object> predicate) {
        checks.put(typeCheck, predicate);
    }
}
