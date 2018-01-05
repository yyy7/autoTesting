package com.katey2658.web.controller;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by 11456 on 2016/12/10.
 */
public class CharacterEncoding implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
