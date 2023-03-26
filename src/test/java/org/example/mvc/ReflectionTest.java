package org.example.mvc;

import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ReflectionTest {
    class TestClass {

        int TestMethod(int a) {
           return 0;
        }
    }
    @Test
    void name() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        Method method = TestClass.class.getDeclaredMethods()[0];
        Class<?> clazz = method.getDeclaringClass();
        Constructor<?> constructor = clazz.getDeclaredConstructors()[1];
        assertNotNull(constructor);
        Object instance = constructor.newInstance();//mark
        assertNotNull(instance);
        Object result = method.invoke(instance, 0);
        assertEquals(0, result);




    }
}

