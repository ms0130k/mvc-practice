package org.example.mvc.view;

import java.util.Collections;
import java.util.Map;

public class ModelAndView {
    private Object view;
    private Map<String, Object> model;

    public ModelAndView(final String viewName) {
        this.view = viewName;
    }

    public Map<String, Object> getModel() {
        return Collections.unmodifiableMap(model);
    }

    public String getViewName() {
        return view instanceof String ? (String) view : null;
    }
}
