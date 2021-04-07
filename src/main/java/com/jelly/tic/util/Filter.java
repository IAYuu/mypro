package com.jelly.tic.util;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public interface Filter {
    void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException;
}
