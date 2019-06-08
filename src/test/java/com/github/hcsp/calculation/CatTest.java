package com.github.hcsp.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void test() throws Exception {
        Cat cat = new Cat(true, false, false);
        assertTrue(cat.isCute());
        assertFalse(cat.isFat());
        assertFalse(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        assertEquals(0x1, field.get(cat));

        cat = new Cat(true, true, true);
        assertTrue(cat.isCute());
        assertTrue(cat.isFat());
        assertTrue(cat.isWhite());

        assertEquals(0x1 | 0x2 | 0x4, field.get(cat));
    }
}
