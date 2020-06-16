package com.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//自定义filter，可以用注解方式自动配置filter，也可以去web.xml里手动配置
@WebFilter("/*")
public class CharEncodingFilter implements Filter {

//    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        this.encoding = filterConfig.getInitParameter("encoding");
//        System.out.println(encoding);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        servletRequest.setCharacterEncoding(encoding);
//        servletResponse.setCharacterEncoding(encoding);
        servletRequest.setCharacterEncoding("UTF-8");
        servletResponse.setCharacterEncoding("UTF-8");
        //将请求和相应往后传递，放行请求
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
