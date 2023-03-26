package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.HttpMethod;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

class AnnotationMappingHandlerTest {

    @Test
    void test() {
        AnnotationHandlerMapping annotationMappingHandler = new AnnotationHandlerMapping("org.example");
        annotationMappingHandler.init();
        Object handler = annotationMappingHandler.findHandler(new HandlerKey(HttpMethod.GET, "/"));
        assertThat(handler).isNotNull();
        Method method = (Method) handler;
        RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
        Controller controller = method.getAnnotation(Controller.class);
        assertThat(requestMapping).isNotNull();
        assertThat(controller).isNull();

        assertThat(requestMapping.method()).isEqualTo(new HttpMethod[]{HttpMethod.GET});
        assertThat(requestMapping.value()).isEqualTo("/");
    }

}