package com.github.hcsp.calculation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void test() throws Exception {
        Cat cat = new Cat();
        cat.setCute(true);
        cat.setCute(true);
        cat.setFat(false);
        cat.setWhite(false);
        cat.setWhite(false);
        assertTrue(cat.isCute());
        assertFalse(cat.isFat());
        assertFalse(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        assertEquals(0x1, field.get(cat));

        cat = new Cat();
        for (int i = 0; i < 100; ++i) {
            cat.setCute(true);
            cat.setFat(true);
            cat.setWhite(true);
        }
        assertTrue(cat.isCute());
        assertTrue(cat.isFat());
        assertTrue(cat.isWhite());

        assertEquals(0x1 | 0x2 | 0x4, field.get(cat));

        cat = new Cat();
        for (int i = 0; i < 100; ++i) {
            cat.setCute(true);
            cat.setFat(true);
            cat.setWhite(true);
        }
        cat.setCute(false);
        cat.setFat(false);
        cat.setWhite(false);

        assertFalse(cat.isCute());
        assertFalse(cat.isFat());
        assertFalse(cat.isWhite());

        assertEquals(0, field.get(cat));
    }
}
