package com.cyz.staticsystem.common.util;

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
import javax.servlet.http.HttpSession;

public class LoginFilter  implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		 // TODO Auto-generated method stub  
        HttpServletRequest request = (HttpServletRequest) req;  
        HttpServletResponse response = (HttpServletResponse) res;  
        HttpSession session = request.getSession();  
        // 如果session不为空，则可以浏览其他页面  
        String url = request.getServletPath();  
      //这里判断目录，后缀名，当然也可以写在web.xml中，用url-pattern进行拦截映射  
        if ((!request.getServletPath().equals("/error.jsp"))  
                && (!request.getServletPath().equals("/login.do"))  
                && (!request.getServletPath().equals("/getShopId.do"))
                && (!request.getServletPath().equals("/logout.do"))
                && (!request.getServletPath().equals("/tologin.do"))
                && (!request.getServletPath().equals("/order/testOrder.do"))
                && (!request.getServletPath().equals("/appLogin.do"))
                && (!request.getServletPath().equals("/varifyCode.do"))
                && (!request.getServletPath().equals("/activity/toListActivity.do"))
                && (!request.getServletPath().equals("/userInfo/toEditPassWord.do"))
                && (!request.getServletPath().equals("/productClass/toProductManage.do"))
        		&& (!request.getServletPath().equals("/store/listStoreByPlatform.do"))
                && (!request.getServletPath().equals("/config/calcuOrderDetail.do"))
        		) {  
            System.out.println(request.getServletPath());  
            if (Utils.getLoginUserInfo(request) == null) {  
                session.invalidate();  
                response.setContentType("text/html;charset=utf-8");  
                PrintWriter out = response.getWriter();  
                out.println("<script language='javascript' type='text/javascript'>");  
                out.println("alert('由于你长时间没有操作,导致Session失效!请你重新登录!');window.location.href='" + request.getContextPath() + "/tologin.do'");  
                out.println("</script>");  
            } else {  
                chain.doFilter(request, response);  
            }  
        } else {  
            chain.doFilter(request, response);  
        }  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
