package com.jelly.tic.extension;

import com.jelly.tic.entity.User;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocalCookieAuthenticator implements Authenticator {
    @Override
    public User authenticate(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String cookie = getCookieFromRequest(request, "cookieName");
        if (cookie == null)
            return null;
        return getUserByCookie(cookie);
    }

    public String getCookieFromRequest(HttpServletRequest request, String cookieName) {
        return null;
    }

    public User getUserByCookie(String cookie) {
        return null;
    }
}
