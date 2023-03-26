package org.example;

import org.example.mvc.controller.HttpMethod;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;

import javax.sound.midi.Soundbank;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnnotationTest {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface ControllerTest {
        String name() default "";
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    @interface RequestMappingTest {
        String value() default "";

        HttpMethod[] method() default {};
    }

    @ControllerTest(name = "annotatedClass")
    class TestAnnotated {
        @RequestMappingTest(value = "/go", method = HttpMethod.GET)
        void 고고고() {

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
        Reflections reflections = new Reflections(getClass().getPackageName());
        List<Method> methodList = new ArrayList<>();
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ControllerTest.class);

        typesAnnotatedWith.stream()
                .map(Class::getDeclaredMethods)
                .forEach(methods -> Arrays.stream(methods)
                        .filter(method -> method.isAnnotationPresent(RequestMappingTest.class))
                        .forEach(method -> methodList.add(method)));
        assertThat(methodList.size()).isEqualTo(1);
        RequestMappingTest annotation = methodList.get(0).getAnnotation(RequestMappingTest.class);
        assertThat(annotation.method()).contains(HttpMethod.GET);
        assertThat(annotation.value()).isEqualTo("/go");
    }
}
