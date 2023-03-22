package org.example.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardController implements Controller {
    private String forwardPath;

    public ForwardController(final String forwardPath) {
        this.forwardPath = forwardPath;
    }

    @Override
    public String handleRequest(final HttpServletRequest request, final HttpServletResponse response) {
        return forwardPath;
    }
}
