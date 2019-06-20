package com.github.hcsp.calculation;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CatTest {
    @Test
    public void test1() throws Exception {
        Cat cat = new Cat();
        cat.setCute(true);
        cat.setCute(true);
        cat.setFat(false);
        cat.setWhite(false);
        cat.setWhite(true);
        Assertions.assertTrue(cat.isCute());
        Assertions.assertFalse(cat.isFat());
        Assertions.assertTrue(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        Assertions.assertEquals(0x1 | 0x4, field.get(cat));
    }

    @Test
    public void test2() throws Exception {

        Cat cat = new Cat();
        for (int i = 0; i < 100; ++i) {
            cat.setCute(true);
            cat.setFat(true);
            cat.setWhite(true);
        }
        Assertions.assertTrue(cat.isCute());
        Assertions.assertTrue(cat.isFat());
        Assertions.assertTrue(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        Assertions.assertEquals(0x1 | 0x2 | 0x4, field.get(cat));
    }

    @Test
    public void test3() throws Exception {
        Cat cat = new Cat();
        for (int i = 0; i < 100; ++i) {
            cat.setCute(true);
            cat.setFat(true);
            cat.setWhite(true);
        }
        cat.setCute(false);
        cat.setFat(false);
        cat.setWhite(false);

        Assertions.assertFalse(cat.isCute());
        Assertions.assertFalse(cat.isFat());
        Assertions.assertFalse(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        Assertions.assertEquals(0, field.get(cat));
    }

    @Test
    public void test4() throws Exception {
        Cat cat = new Cat();
        cat.setFat(true);
        cat.setWhite(true);
        cat.setCute(false);

        Assertions.assertTrue(cat.isFat());
        Assertions.assertFalse(cat.isCute());
        Assertions.assertFalse(cat.isWhite());

        Field field = Cat.class.getDeclaredField("properties");
        field.setAccessible(true);
        Assertions.assertEquals(0x2 | 0x4, field.get(cat));
    }
}
