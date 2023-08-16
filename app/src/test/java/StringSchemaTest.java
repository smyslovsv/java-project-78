import static org.assertj.core.api.Assertions.assertThat;

import hexlet.code.Validator;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

class StringSchemaTest {
    @Test
    public void testStringSchema() {
        Validator validator1 = new Validator();
        StringSchema schema1 = validator1.string();

        assertThat(schema1.isValid("string")).isTrue();
        assertThat(schema1.isValid("")).isTrue();
        assertThat(schema1.isValid(null)).isTrue();
    }
    @Test
    public void testStringSchemaRequired() {
        Validator validator2 = new Validator();
        StringSchema schema2 = validator2.string().required();

        assertThat(schema2.isValid("bashOrg")).isTrue();
        assertThat(schema2.isValid("")).isFalse();
        assertThat(schema2.isValid(null)).isFalse();
    }

    @Test
    public void testStringSchemaLength() {
        Validator validator3 = new Validator();
        StringSchema schema3 = validator3.string();

        schema3.minLength(3);

        assertThat(schema3.isValid("hexlet")).isTrue();
        assertThat(schema3.isValid("")).isFalse();
        assertThat(schema3.isValid(null)).isFalse();

        schema3.minLength(7);

        assertThat(schema3.isValid("chebu")).isFalse();
        assertThat(schema3.isValid("")).isFalse();
        assertThat(schema3.isValid(null)).isFalse();
    }

    @Test
    public void testStringSchemaContains() {
        Validator validator4 = new Validator();
        StringSchema schema4 = validator4.string().contains("str");

        assertThat(schema4.isValid("strength")).isTrue();
        assertThat(schema4.isValid("")).isFalse();
        assertThat(schema4.isValid(null)).isFalse();

        schema4.contains("strstr");

        assertThat(schema4.isValid("qwerty")).isFalse();
        assertThat(schema4.isValid("")).isFalse();
        assertThat(schema4.isValid(null)).isFalse();
    }
}
