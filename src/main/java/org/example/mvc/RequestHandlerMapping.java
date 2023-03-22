package org.example.mvc;

import org.example.mvc.controller.*;

import java.util.HashMap;
import java.util.Map;

public class RequestHandlerMapping implements HandlerMapping {

    private Map<HandlerKey, Object> mappings = new HashMap<>();

    public void init() {
//        mappings.put(new HandlerKey(HttpMethod.GET, "/"), new HomeController());
        mappings.put(new HandlerKey(HttpMethod.GET, "/users"), new UserListController());
        mappings.put(new HandlerKey(HttpMethod.POST, "/users"), new UserCreateController());
        mappings.put(new HandlerKey(HttpMethod.GET, "/user/form"), new ForwardController("/user/form"));
    }

    public Object findHandler(HandlerKey handlerKey) {
        return mappings.get(handlerKey);
    }
}
