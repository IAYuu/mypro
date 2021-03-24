package com.jelly.tic.extension;

import com.jelly.tic.entity.User;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class APIAuthenticator implements Authenticator {
    @Override
    public User authenticate(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String token = request.getHeader("X-API-Token");
        if (token == null) {
            return null;
        }
        return authenticateUserByAPIToken(token);
    }

    public User authenticateUserByAPIToken(String token) {

        return null;
    }
}
