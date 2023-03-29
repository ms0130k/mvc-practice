package org.example.mvc.controller.simple;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface Controller {
    public void requestHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}
