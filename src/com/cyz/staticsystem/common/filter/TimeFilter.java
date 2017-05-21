package com.cyz.staticsystem.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * 描述：请求响应时间记录类，负责将HTTP请求响应时间输出到日志
 * @author joan.xiong
 * @version 1.0 2016-03-10
 */
public class TimeFilter implements Filter {

	private static Logger log = Logger.getLogger(TimeFilter.class);

	@Override
	public void destroy() {
	}

	/**
	 * 过滤实现
	 * @param request ServletRequest
	 * @param response ServletResponse
	 * @param chain FilterChain
	 * @throws IOException if has error
	 * @throws ServletException if has error
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
		throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		long t1 = System.currentTimeMillis();  
		if(request == null){
			response.setContentType("text/html;charset=utf-8");  
            PrintWriter out = response.getWriter(); 
			out.println("<script language='javascript' type='text/javascript'>");  
            out.println("alert('Session失效!请重新登录!');");  
            out.println("</script>"); 
 			rs.sendRedirect(hreq.getContextPath() +"/tologin.do");
        	return;
 		}
		chain.doFilter(request, response);  
		long t2 = System.currentTimeMillis(); 
		log.debug("****** request ("+hreq.getRequestURI()+") finished with time(ms):"+(t2-t1));
	}

	@Override
	public void init(FilterConfig fc) throws ServletException {
	}

}
