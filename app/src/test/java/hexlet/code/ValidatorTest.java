package hexlet.code;

import hexlet.code.schemas.MapSchema;
import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidatorTest {

    @Test
    public void testStringSchema() {
        Validator v = new Validator();
        StringSchema schema = v.string();
        final int minTrue = 2;
        final int minFalse = 9;

        assertTrue(schema.isValid(""));
        assertTrue(schema.isValid(null));

        schema.required();
        assertTrue(schema.isValid("what does the fox say"));
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid(""));

        assertTrue(schema.contains("wh").isValid("what does the fox say"));
        assertFalse(schema.contains("whatthe").isValid("what does the fox say"));
        assertFalse(schema.isValid("what does the fox say"));
        assertTrue(schema.minLength(minTrue).isValid("whatthe"));
        assertFalse(schema.minLength(minFalse).isValid("whatthe"));
    }

    @Test
    public void testNumberSchema() {
        Validator v = new Validator();
        NumberSchema schema = v.number();
        final int min = 2;
        final int max = 17;

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertFalse(schema.isValid("5"));
        assertTrue(schema.isValid(10));

        assertTrue(schema.positive().isValid(10));
        assertFalse(schema.isValid(-10));

        schema.range(min, max);
        assertTrue(schema.isValid(2));
        assertTrue(schema.isValid(16));
        assertFalse(schema.isValid(19));
        assertFalse(schema.isValid(-5));

    }

    @Test
    public void testMapSchema() {
        Validator v = new Validator();
        MapSchema schema = v.map();

        assertTrue(schema.isValid(null));

        schema.required();
        assertFalse(schema.isValid(null));
        assertTrue(schema.isValid(new HashMap<>()));
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        assertTrue(schema.isValid(data));

        schema.sizeof(2);
        assertFalse(schema.isValid(data));
        data.put("key2", "value2");
        assertTrue(schema.isValid(data));
    }
}
