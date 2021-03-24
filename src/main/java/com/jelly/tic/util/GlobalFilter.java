package com.jelly.tic.util;

import com.jelly.tic.entity.User;
import com.jelly.tic.extension.Authenticator;
import com.jelly.tic.extension.UserContext;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class GlobalFilter implements Filter {

    Authenticator[] authenticators = initAuthenticators();

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 链式认证获得User:
        User user = tryGetAuthenticatedUser(request, response);
        // 把User绑定到UserContext中:
        try (UserContext ctx = new UserContext(user)) {
            chain.doFilter(request, response);
        }
    }

    public User tryGetAuthenticatedUser(ServletRequest request, ServletResponse response) {
        return null;
    }

    public Authenticator[] initAuthenticators() {
        return null;
    }
}