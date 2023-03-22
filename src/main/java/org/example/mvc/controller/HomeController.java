package org.example.mvc.controller;

import org.example.mvc.annotation.Controller;
import org.example.mvc.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    @RequestMapping(value = "/", method = HttpMethod.GET)
    public String handleRequest(final HttpServletRequest request, final HttpServletResponse response) {
        return "home";
    }
}
