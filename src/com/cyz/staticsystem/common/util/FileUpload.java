package com.cyz.staticsystem.common.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import com.cyz.staticsystem.common.util.AjaxUtils;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    Logger logger = Logger.getLogger(FileUpload.class);
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUpload() {
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
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        //从item_upload.jsp中拿取数据，因为上传页的编码格式跟一般的不同，使用的是enctype="multipart/form-data"  
        //form提交采用multipart/form-data,无法采用req.getParameter()取得数据  
        //String itemNo = req.getParameter("itemNo");  
        //System.out.println("itemNo======" + itemNo);  
    	
    	request.setCharacterEncoding("utf-8");
       /* response.setContentType("application/xml");*/
        
        File uploadPath = new File("D:" + File.separator + "餐予者");
        logger.debug("uploadPath=====" + uploadPath);
        
        if (!uploadPath.exists() && !uploadPath.isDirectory()) {
            uploadPath.mkdir();
        }
        File imagePath = new File(uploadPath.getAbsoluteFile() + File.separator+ "店铺资料");
        
        if (!imagePath.exists() && !imagePath.isDirectory()) {
            imagePath.mkdir();
        }
        
        File tempPath = new File(getServletContext().getRealPath("temp"));
        if (!tempPath.exists()) {
            tempPath.mkdir();
        }
        
        /********************************使用 FileUpload 组件解析表单********************/
        
        //DiskFileItemFactory：创建 FileItem 对象的工厂，在这个工厂类中可以配置内存缓冲区大小和存放临时文件的目录。  
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // maximum size that will be stored in memory  
        factory.setSizeThreshold(4096);
        // the location for saving data that is larger than getSizeThreshold()  
        factory.setRepository(tempPath);
        
        //ServletFileUpload：负责处理上传的文件数据，并将每部分的数据封装成一到 FileItem 对象中。  
        //在接收上传文件数据时，会将内容保存到内存缓存区中，如果文件内容超过了 DiskFileItemFactory 指定的缓冲区的大小，  
        //那么文件将被保存到磁盘上，存储为 DiskFileItemFactory 指定目录中的临时文件。  
        //等文件数据都接收完毕后，ServletUpload再从文件中将数据写入到上传文件目录下的文件中  
        
        ServletFileUpload upload = new ServletFileUpload(factory);
        // maximum size before a FileUploadException will be thrown  
        upload.setSizeMax(1000000 * 20);
        
        /*******************************解析表单传递过来的数据，返回List集合数据-类型:FileItem***********/
        
        
        File storeNamePath = null;
        File itemPath = null;
        try {
            
            List fileItems = upload.parseRequest(request);
            
            String itemNo = "";String itemFold="";
            //Iterator iter = fileItems.iterator()取其迭代器  
            //iter.hasNext()检查序列中是否还有元素  
            for (Iterator iter = fileItems.iterator(); iter.hasNext();) {
                //获得序列中的下一个元素  
                FileItem item = (FileItem)iter.next();
                
                //判断是文件还是文本信息  
                //是普通的表单输入域  
                if (item.isFormField()) {
                    //if ("itemNo".equals(item.getFieldName())) {
                    //itemNo为界面上传过来的店铺的名称
                    itemNo = item.getString();
                    itemFold = item.getFieldName();
                    itemNo = new String(itemNo.getBytes("ISO-8859-1"), "utf-8");
                    itemFold = new String(itemFold.getBytes("ISO-8859-1"), "utf-8");
                    if (itemNo != null && !"".equals(itemNo)) {
                        storeNamePath = new File(imagePath.getAbsoluteFile() + File.separator + itemNo);
                        if (!storeNamePath.exists() && !storeNamePath.isDirectory()) {
                            storeNamePath.mkdir();
                        }
                       itemPath = new File(storeNamePath.getAbsoluteFile() + File.separator+ itemFold);
                        if (!itemPath.exists() && !itemPath.isDirectory()) {
                        	itemPath.mkdir();
                        }
                    }
                    
                    //                    }
                }
                //是否为input="type"输入域  
                if (!item.isFormField()) {
                    //上传文件的名称和完整路径  
                    String fileName = item.getName();
                    
                    long size = item.getSize();
                    //判断是否选择了文件  
                    if ((fileName == null || fileName.equals("")) && size == 0) {
                        continue;
                    }
                    //截取字符串 如：C:\WINDOWS\Debug\PASSWD.LOG  
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1,
                            fileName.length());
                  /*  String imageName = new Date().getTime() + ".jpg";*/
                    // 保存文件在服务器的物理磁盘中：第一个参数是：完整路径（不包括文件名）第二个参数是：文件名称     
                    //item.write(file);  
                    //修改文件名和物料名一致，且强行修改了文件扩展名为gif  
                    //item.write(new File(uploadPath, itemNo + ".gif"));  
                    //将文件保存到目录下，不修改文件名  
                    File file = new File(itemPath, fileName);
                    logger.debug("图片路径========" + file.getAbsolutePath());
                    item.write(file);
                    
                    JSONObject reJo = new JSONObject();
                    reJo.put("respCode", "0000");
                    reJo.put("respMsg", "image upload succsess");
                    reJo.put("picAddr",
                            request.getScheme() + "://"
                                    + request.getServerName() + ":"
                                    + request.getServerPort()
                                    + request.getContextPath() + "/file/"
                                    + itemNo +"/" + itemFold+"/" + fileName);
                   /* PrintWriter out = response.getWriter();
                    out.print(reJo);*/
                    AjaxUtils.sendAjaxForObject(response,reJo);	
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
