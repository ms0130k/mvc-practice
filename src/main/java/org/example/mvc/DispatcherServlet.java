package org.example.mvc;

import org.example.mvc.controller.HandlerKey;
import org.example.mvc.controller.HttpMethod;
import org.example.mvc.view.JspViewResolver;
import org.example.mvc.view.ModelAndView;
import org.example.mvc.view.View;
import org.example.mvc.view.ViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(DispatcherServlet.class);
    private List<HandlerMapping> handlerMappings;
    private List<ViewResolver> viewResolvers;
    private List<HandlerAdapter> handlerAdapters;

    @Override
    public void init() throws ServletException {
        RequestHandlerMapping rhm = new RequestHandlerMapping();
        rhm.init();
        AnnotationHandlerMapping amh = new AnnotationHandlerMapping("?????");
        amh.init();
        handlerMappings = List.of(rhm, amh);
        viewResolvers = Collections.singletonList(new JspViewResolver());
        handlerAdapters=List.of(new SimpleControllerHandlerAdapter(), new AnnotationHandlerAdapter());
    }

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        Object handler = handlerMappings.stream()
                .filter(hm -> hm.findHandler(new HandlerKey(HttpMethod.valueOf(req.getMethod()), req.getRequestURI())) != null)
                .findFirst()
                .orElseThrow(() -> new ServletException(""));

        HandlerAdapter handlerAdapter = handlerAdapters.stream()
                .filter(ha -> ha.supports(handler))
                .findFirst()
                .orElseThrow(() -> new ServletException("No adapter for handler [" + handler + "]"));
        ModelAndView modelAndView = handlerAdapter.handle(req, res, handler);

        for (ViewResolver viewResolver : viewResolvers) {
            View view = viewResolver.resolveView(modelAndView.getViewName());
            view.render(modelAndView.getModel(), req, res);
        }
    }
}
