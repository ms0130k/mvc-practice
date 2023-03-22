package org.example.mvc.controller;

import org.example.mvc.model.User;
import org.example.mvc.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class UserListController implements Controller {
    @Override
    public String handleRequest(final HttpServletRequest request, final HttpServletResponse response) {
        request.setAttribute("users", UserRepository.findAll());
        return "/user/list";
    }
}
