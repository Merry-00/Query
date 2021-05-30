package com.gcl.query.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "TimeFilter")
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin","*");//解决跨域访问报错
        response.setHeader("Access-Control-Allow-Methods","POST,PUT,GET,OPTIONS,DELETE");//
        response.setHeader("Access-Control-Max-Age","3600");//设置过期时间
        response.setHeader("Access-Control-Allow-Headers","Origin,X-Requested-With, Content-Type, Accept, client_id, uuid, Authorization");
        response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");// 支持HTTP 1.1.
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {

    }
}
