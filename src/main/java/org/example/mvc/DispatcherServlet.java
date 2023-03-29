package org.example.mvc;

import lombok.extern.slf4j.Slf4j;
import org.example.mvc.constant.HttpMethod;
import org.example.mvc.controller.simple.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private RequestHandlerMapping requestHandlerMapping;

    @Override
    public void init() throws ServletException {
        log.info("init DispatcherServlet");
        requestHandlerMapping = RequestHandlerMapping.getInstance();
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        log.info("requestURI: {}", requestURI);

        Object handler = requestHandlerMapping.getHandler(new HandlerKey(requestURI, HttpMethod.valueOf(method)));
        if (handler == null) {
            log.error("handler is null, request uri: {}, method: {}", requestURI, method);
            return;
        }
        ((Controller) handler).requestHandle(request, response);
    }
}
