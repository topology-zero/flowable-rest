package com.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.flowable.common.engine.impl.identity.Authentication;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "myFilter", urlPatterns = {"/*"})
@Slf4j
public class UserFilter implements Filter {

    private static final String userHeader = "FlowableUserId";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String userId = req.getHeader(userHeader);
        log.error("获取到用户的ID {}", userId);
        if (userId != null && !userId.equals("")) {
            Authentication.setAuthenticatedUserId(userId);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
