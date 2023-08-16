package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema {
    private static Map<String, Predicate<Object>> checks;

    public BaseSchema() {
        checks = new LinkedHashMap<>();
    }
    public final boolean isValid(Object value) {
        for (Predicate<Object> check : checks.values()) {
            if (!check.test(value))
                return false;
        }
        return true;
    }

    public final void addCheck(String typeCheck, Predicate<Object> predicate) {
        checks.put(typeCheck, predicate);
    }
}
