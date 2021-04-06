package com.wjj.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/*
  / * 表示映射所有的路径，所有的请求都会被这个filter处理
  urlPatterns = {"/*"}
 */
@WebFilter(filterName = "encodingFilter", value = "/*")
public class EncodingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 设置request和response的编码
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        // 继续进行转发[设置编码之后，让request或者response请求响应继续向前进行转发处理]
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
