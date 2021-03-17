package com.jelly.tic.web;

import com.jelly.tic.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicAuthenticator implements Authenticator {

    public User authenticate(HttpServletRequest request, HttpServletResponse response) {
        String auth = getHeaderFromRequest(request, "Authorization");
        if (auth == null) {
            return null;
        }
        String name = parseUsernameFromAuthorizationHeader(auth);
        String password = parsePasswordFromAuthorizationHeader(auth);
        return authenticateUserByPassword(name, password);
    }

    public String getHeaderFromRequest(HttpServletRequest request, String str) {
        return null;
    }

    public String parseUsernameFromAuthorizationHeader(String auth) {
        return null;
    }

    public String parsePasswordFromAuthorizationHeader(String auth) {
        return null;
    }

    public User authenticateUserByPassword(String name, String password) {
        return null;
    }
}
