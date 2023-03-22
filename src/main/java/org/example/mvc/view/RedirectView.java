package org.example.mvc.view;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class RedirectView implements View {
    public static final String DEFAULT_REDIRECT_PREFIX = "redirect:";
    private final String viewName;

    public RedirectView(final String viewName) {
        this.viewName = viewName;
    }

    @Override
    public void render(final Map<String, Object> model, final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(viewName.substring(DEFAULT_REDIRECT_PREFIX.length()));
    }
}
