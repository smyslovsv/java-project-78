import hexlet.code.Validator;
import hexlet.code.schemas.BaseSchema;
import hexlet.code.schemas.MapSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MapSchemaTest {
    @Test
    public void MapSchema() {
        Validator validator1 = new Validator();
        MapSchema schema1 = validator1.map();

        assertThat(schema1.isValid(null)).isTrue();

        Map<String, String> data1 = new HashMap<>();
        data1.put("key1", "value1");
        assertThat(schema1.isValid(data1)).isTrue();

        Map<Integer, Integer> data2 = new HashMap<>();
        data2.put(123, -15);
        assertThat(schema1.isValid(data2)).isTrue();
    }
    @Test
    public void MapSchemaRequired() {
        Validator validator2 = new Validator();
        MapSchema schema2 = validator2.map().required();

        assertThat(schema2.isValid(null)).isFalse();
        assertThat(schema2.isValid(new HashMap<>())).isTrue();
    }

    @Test
    public void MapSchemaSizeOf() {
        Validator validator3 = new Validator();
        MapSchema schema3 = validator3.map();
        schema3.sizeof(2);

        Map<String, String> data1 = new HashMap<>();
        data1.put("key1", "value1");
        assertThat(schema3.isValid(data1)).isFalse();

        data1.put("key2", "value2");
        assertThat(schema3.isValid(data1)).isTrue();
    }
    @Test
    public void MapSchemaShape() {
        Validator validator = new Validator();
        MapSchema mapSchema = validator.map();

        Map<String, BaseSchema> schemas = new HashMap<>();
        Validator validator2 = new Validator();

        schemas.put("name", validator2.string().required());
        schemas.put("age", validator2.number().positive());
        mapSchema.shape(schemas);

        Map<String, Object> map3 = new HashMap<>();
        map3.put("name", "Eliza");
        map3.put("age", 24);
        assertThat(mapSchema.isValid(map3)).isTrue();

//        map3.put("name", 24);
//        map3.put("age", "Eliza");
//        assertThat(mapSchema.isValid(map3)).isFalse();
//
//        Map<String, Object> human4 = new HashMap<>();
//        human4.put("name", "Valya");
//        human4.put("age", -5);
//        assertThat(mapSchema.isValid(human4)).isFalse();
    }
}
