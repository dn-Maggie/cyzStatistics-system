package com.cyz.staticsystem.common.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 基础controller
 * @author Maggie
 */
public abstract class BaseController {
	/**
	 * 异常处理
	 * 
	 * @param message
	 * @return
	 */
	@ExceptionHandler
    public String exception(HttpServletRequest request, Exception e) { 
        // 根据不同的异常类型进行不同处理
        if(e instanceof SQLException) {
            String s = "数据库异常" ;
            request.setAttribute( "exceptionMessage", s);
            return "error";     
        }else if(e instanceof IOException){
           String s = "IO异常";
            request.setAttribute( "exceptionMessage", s);
            return "error";     
        }
        else return "error"; 
    }
}
