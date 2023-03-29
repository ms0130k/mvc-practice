package org.example.mvc;

import org.example.mvc.constant.HttpMethod;

import java.util.Objects;

public class HandlerKey {
    private final String requestURI;
    private final HttpMethod httpMethod;

    public HandlerKey(String requestURI, HttpMethod httpMethod) {
        this.requestURI = requestURI;
        this.httpMethod = httpMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return Objects.equals(requestURI, that.requestURI) && httpMethod == that.httpMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestURI, httpMethod);
    }
}
