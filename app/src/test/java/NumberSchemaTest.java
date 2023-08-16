import hexlet.code.Validator;
import hexlet.code.schemas.NumberSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSchemaTest {
    @Test
    public void testNumberSchema() {
        Validator validator1 = new Validator();
        NumberSchema schema1 = validator1.number();

        assertThat(schema1.isValid(123)).isTrue();
        assertThat(schema1.isValid(-15)).isTrue();
        assertThat(schema1.isValid(null)).isTrue();
    }
    @Test
    public void testNumberSchemaRequired() {
        Validator validator2 = new Validator();
        NumberSchema schema2 = validator2.number().required();

        assertThat(schema2.isValid(100)).isTrue();
        assertThat(schema2.isValid(-15)).isTrue();
        assertThat(schema2.isValid(null)).isFalse();
    }

    @Test
    public void testNumberSchemaPositive() {
        Validator validator3 = new Validator();
        NumberSchema schema3 = validator3.number();

        assertThat(schema3.isValid(10)).isTrue();
        assertThat(schema3.isValid(-10)).isTrue();
        assertThat(schema3.isValid(0)).isTrue();
        assertThat(schema3.isValid(null)).isTrue();

        schema3.positive();

        assertThat(schema3.isValid(10)).isTrue();
        assertThat(schema3.isValid(-10)).isFalse();
        assertThat(schema3.isValid(0)).isFalse();
        assertThat(schema3.isValid(null)).isTrue();
    }

    @Test
    public void testNumberSchemaRange() {
        Validator validator4 = new Validator();
        NumberSchema schema4 = validator4.number();

        assertThat(schema4.range(0, 10).isValid(5)).isTrue();
        assertThat(schema4.range(0, 4).isValid(6)).isFalse();
        assertThat(schema4.range(-3, 5).isValid(-4)).isFalse();

        schema4.positive();

        assertThat(schema4.range(0, 10).isValid(5)).isTrue();
        assertThat(schema4.range(-3, 5).isValid(-1)).isFalse();
        assertThat(schema4.range(-3, 5).isValid(0)).isFalse();
    }
}
