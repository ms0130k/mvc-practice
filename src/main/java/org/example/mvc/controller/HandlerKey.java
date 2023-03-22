package org.example.mvc.controller;

import java.util.Objects;

public class HandlerKey {
    private HttpMethod httpMethod;
    private String uriPath;

    public HandlerKey(final HttpMethod httpMethod, final String uriPath) {
        this.httpMethod = httpMethod;
        this.uriPath = uriPath;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HandlerKey that = (HandlerKey) o;
        return httpMethod == that.httpMethod && Objects.equals(uriPath, that.uriPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpMethod, uriPath);
    }
}
