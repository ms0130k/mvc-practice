package org.example.mvc;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;
import org.example.mvc.controller.HandlerKey;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AnnotationHandlerMapping implements HandlerMapping {

    private Map<HandlerKey, Object> requestHandlerMap = new HashMap<>();
    private final Object[] basePackage;

    public AnnotationHandlerMapping(Object... basePackage) {
        this.basePackage = basePackage;
    }


    @Override
    public Object findHandler(final HandlerKey handlerKey) {
        return requestHandlerMap.get(handlerKey);
    }

    public void init() {
        Reflections reflections = new Reflections(basePackage);
        reflections.getTypesAnnotatedWith(Controller.class, true).stream()
                .forEach(aClass -> Arrays.stream(aClass.getDeclaredMethods())
                        .filter(method -> method.isAnnotationPresent(RequestMapping.class))
                        .forEach(method -> {
                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                            Arrays.stream(requestMapping.method())
                                    .forEach(httpMethod -> requestHandlerMap.put(new HandlerKey(httpMethod, requestMapping.value()), method));
                        }));

    }
}
