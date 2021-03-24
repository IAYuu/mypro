package com.jelly.tic.extension;

import com.jelly.tic.entity.User;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Authenticator {
    User authenticate(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException;
}
