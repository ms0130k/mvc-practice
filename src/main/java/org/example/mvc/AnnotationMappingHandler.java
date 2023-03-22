package org.example.mvc;

import org.example.mvc.controller.HandlerKey;
import org.reflections.Reflections;

import java.util.Map;

public class AnnotationMappingHandler implements HandlerMapping {

    private Map<HandlerKey, Object> requestHandlerMap;
    private final String basePackage;

    public AnnotationMappingHandler(String basePackage) {
        this.basePackage = basePackage;
    }


    @Override
    public Object findHandler(final HandlerKey handlerKey) {
        return requestHandlerMap.get(handlerKey);
    }

    public void init() {

    }
}
