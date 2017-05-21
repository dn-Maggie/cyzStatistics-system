package com.cyz.staticsystem.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.log4j.Logger;
import org.apache.log4j.config.PropertySetter;

import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.SpringInit;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/Filedownload")
public class FileDownload extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    Logger logger = Logger.getLogger(FileDownload.class);//日志
    
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    /**
     * @see Servlet#init(ServletConfig)
     */
    public void init() throws ServletException {
        // TODO Auto-generated method stub
    }
    
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

    	request.setCharacterEncoding("utf-8");
    	try {          
			// path是指欲下载的文件的路径。         
    		String platFormType = request.getParameter("platFormType");
    		//String file_path="/dncyz/WebContent/tempFile/订单详细（饿了么模板）.xlsx";
    		String file_path = getServletContext().getRealPath("tempFile");
    		String file_name = "/订单详细（饿了么模板）.xlsx";
    		if(platFormType.equals("meituan")){
    			file_name="/订单详细（美团模板）.xlsx";
    		}else if(platFormType.equals("baidu")){
    			file_name="/订单详细（百度模板）.xlsx";
    		}else if(platFormType.equals("store")){
    			file_name="/店铺信息表.xlsx";
    		}
			File file = new File(file_path + file_name);  
			// 取得文件名。          
			String filename = file.getName();            
			// 以流的形式下载文件。 
			InputStream fis = new BufferedInputStream(new FileInputStream(file));  
			byte[] buffer = new byte[fis.available()]; 
			 fis.read(buffer);  
			 fis.close();           
			 // 清空response  
			 response.reset();           
			 // 设置response的Header           
			 String fileName = URLEncoder.encode(filename,"UTF-8");  
			 if(fileName.length()>150){   
				 //解决IE 6.0 bug   
				 fileName=new String(filename.getBytes("GBK"),"ISO-8859-1");          
				 }    
			 response.addHeader("Content-Disposition", "attachment;filename=" + fileName);  
			 response.addHeader("Content-Length", "" + file.length());   
			 OutputStream toClient = new BufferedOutputStream(response.getOutputStream());  
			 response.setContentType("application/octet-stream");  
			 toClient.write(buffer);  
			 toClient.flush();  
			 toClient.close();     
//			 JSONObject reJo = new JSONObject();
//			 AjaxUtils.sendAjaxForObject(response, reJo);
			 } catch (IOException e) {   
				 logger.error("下载文档(WordUtil)出错：【msg："+e.getMessage()+"】 ");  
				 e.printStackTrace();      
				 }   
		//return response;  
		}  
}

