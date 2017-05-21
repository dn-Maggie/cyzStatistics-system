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
import com.cyz.staticsystem.product.model.ProductClass;
import com.cyz.staticsystem.product.service.ProductClassService;


/**
 * 描述：产品分类模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("productClass")
public class ProductClassController{
    @Resource
	private ProductClassService productClassService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddProductClass")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/productClass/addProductClass");
		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowProductClass")
	public ModelAndView toShow(String key){
		ProductClass entity = productClassService.getByPrimaryKey(key);
		Map<String,String> productClass = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/product/productClass/showProductClass","productClass",productClass );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param productClass ProductClass:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addProductClass")
	public void add(ProductClass productClass,HttpServletRequest request,HttpServletResponse response){
	productClass.setProductClassId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(
				response,productClassService.add(productClass));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteProductClass")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			productClassService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListProductClass")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/productClass/listProductClass");
		 return mv;
	}
	/**
	 * 进入产品管理页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toProductManage")
	public ModelAndView toProductManage(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/product/productManage/productManage");
		 return mv;
	}
	/**
	 * 根据条件查找列表方法
	 * @param productClass ProductClass：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listProductClass")
	public void listByCondition(ProductClass productClass,HttpServletRequest request,
			HttpServletResponse response, Page page){
		productClass.setPage(page);	
		List<ProductClass> list = productClassService.listByCondition(productClass);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditProductClass")
	public ModelAndView toEdit(String key){
		ProductClass entity = productClassService.getByPrimaryKey(key);
		Map<String,String> productClass = FormatEntity.getObjectValue(entity);
		
		return new ModelAndView("WEB-INF/jsp/product/productClass/editProductClass","productClass",productClass );
	}
	
	/**
	 * 修改方法
	 * @param productClass ProductClass：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateProductClass")
	public void update(ProductClass productClass,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,productClassService.update(productClass));	
	}
	/**
	 * 初始化树
	 * @param productClassName 
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	@RequestMapping("/initProductClassTree")
	public void initProductClassTree(String productClassName, HttpServletRequest request,
			HttpServletResponse response){
		String jsonData = productClassService.initDictTypeTree(productClassName);
		AjaxUtils.sendAjaxForObject(response, jsonData);
	}
}