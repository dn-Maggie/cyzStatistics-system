package com.cyz.staticsystem.product.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.product.model.Product;
import com.cyz.staticsystem.product.service.ProductClassService;
import com.cyz.staticsystem.product.service.ProductService;


/**
 * 描述：产品模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("product")
public class ProductController{
         @Resource
	private ProductService productService;
         @Resource
     	private ProductClassService productClassService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddProduct")
	public ModelAndView toAdd(String productClassId){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/product/addProduct");
		mv.addObject("productClass", productClassService.listByCondition(null));
		mv.addObject("productClassId", productClassId);
		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowProduct")
	public ModelAndView toShow(String key){
		Product entity = productService.getByPrimaryKey(key);
		Map<String,String> product = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/product/product/showProduct","product",product );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param product Product:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addProduct")
	public void add(Product product,HttpServletRequest request,HttpServletResponse response){
	product.setProductId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(response,productService.add(product));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteProduct")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			productService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListProduct")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/product/listProduct");
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param product Product：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listProduct")
	public void listByCondition(Product product,HttpServletRequest request,
			HttpServletResponse response, Page page){
		product.setPage(page);	
		List<Product> list = productService.listByCondition(product);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditProduct")
	public ModelAndView toEdit(String key){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/product/editProduct");
		mv.addObject("productClass", productClassService.listByCondition(null));
		mv.addObject("product", FormatEntity.getObjectValue(productService.getByPrimaryKey(key)));
		return mv;
	}
	
	/**
	 * 修改方法
	 * @param product Product：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateProduct")
	public void update(Product product,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,productService.update(product));	
	}
	/**
	 * 进入产品资源管理选择界面
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toSelectProduct")
	public ModelAndView toSelectProduct(String key){
		return new ModelAndView("WEB-INF/jsp/product/product/selectProduct","storeId",key);
	}
}