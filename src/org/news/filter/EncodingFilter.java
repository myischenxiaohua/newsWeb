package org.news.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/*
ClassName:${PACKAGE_NAME}
Description:
User: myischenxiaohua@163.com
Date: 2019-03-04
Time: 21:22
*/
@WebFilter(filterName = "EncodingFilter",urlPatterns="/*",initParams = {@WebInitParam(name = "encoding",value = "UTF-8")})
public class EncodingFilter implements Filter {
    private String encoding=null;
    public void destroy() {
        this.encoding=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        if(req.getCharacterEncoding()==null){
            req.setCharacterEncoding(this.encoding);
        }
        System.out.println(this.encoding);
        chain.doFilter(req, resp);

    }

    public void init(FilterConfig config) throws ServletException {
        if(this.encoding==null){
            this.encoding=config.getInitParameter("encoding");
        }


    }

}
