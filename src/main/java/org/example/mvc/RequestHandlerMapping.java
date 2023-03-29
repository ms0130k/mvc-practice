package org.example.mvc;

import org.example.mvc.constant.HttpMethod;
import org.example.mvc.controller.simple.HomeController;
import org.example.mvc.controller.simple.UserController;

import java.util.HashMap;

public class RequestHandlerMapping {
    public static RequestHandlerMapping requestHandlerMapping;
    private HashMap<Object, Object> requestHandlerMap;

    private RequestHandlerMapping() {
        init();
    }

    public static RequestHandlerMapping getInstance() {
        if (requestHandlerMapping == null) {
            requestHandlerMapping = new RequestHandlerMapping();
        }
        return requestHandlerMapping;
    }

    private void init() {
        requestHandlerMap = new HashMap<>() {{
            put(new HandlerKey("/", HttpMethod.GET), new HomeController());
            put(new HandlerKey("/user", HttpMethod.GET), new UserController());
        }};
    }

    public Object getHandler(HandlerKey handlerKey) {
        return requestHandlerMap.get(handlerKey);
    }
}
