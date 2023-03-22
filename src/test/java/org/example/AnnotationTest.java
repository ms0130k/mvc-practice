package org.example;

import org.example.mvc.controller.HttpMethod;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Arrays;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnnotationTest {
    @Target(ElementType.TYPE)
    @interface ControllerTest {
        String name() default "";
    }

    @interface RequestMappingTest {
        String value() default "";

        HttpMethod[] method() default {};
    }

    @ControllerTest(name = "annotatedClass")
    class TestAnnotated {
        @RequestMappingTest(value = "/go", method = HttpMethod.GET)
        void method() {

        }
    }

    /**
     * 1. Controller 표시 class
     * 2. 메서드
     * 3. RequestMapping 표시
     * 4. value, method 일치
     */
    @Test
    void 애너테이션으로_클래스와_포함_메서드_찾기() {
//        Reflections reflections = new Reflections(getClass().getPackageName());
//        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ControllerTest.class);
//        typesAnnotatedWith.stream()
//                .filter(clazz -> Arrays.stream(Arrays.stream(clazz.getDeclaredMethods())
//                        .filter())
//                ) // [[method1, method2], [method3, method4]]

        //        Map<Object, Object> map = new HashMap<>();
//        map.put(null, 1);
//        assertTrue(null instanceof Object);
    }
}
