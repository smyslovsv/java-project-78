package hexlet.code.schemas;

import java.util.Map;

public class MapSchema extends BaseSchema{
    private static final String DATA_TYPE = "dataType";
    private static final String REQUIRED = "required";
    private static final String SIZE_OF = "sizeOf";
    private static int sizeValue;

    public MapSchema() {
        addCheck(DATA_TYPE, value -> (value instanceof Map) || (value == null));
    }

    public MapSchema required() {
        addCheck(REQUIRED, value -> value instanceof Map);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        sizeValue = size;
        addCheck(SIZE_OF, value -> (value == null) || (((Map) value).size() == sizeValue));
        return this;
    }
}
