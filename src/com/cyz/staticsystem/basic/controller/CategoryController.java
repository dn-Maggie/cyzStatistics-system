package com.cyz.staticsystem.basic.controller;

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

import com.cyz.staticsystem.basic.model.Category;
import com.cyz.staticsystem.basic.service.CategoryService;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.Utils;


/**
 * 描述：品类模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("category")
public class CategoryController{
	@Resource
	private CategoryService categoryService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddCategory")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/category/addCategory");
		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowCategory")
	public ModelAndView toShow(String key){
		Category entity = categoryService.getByPrimaryKey(key);
		Map<String,String> category = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/basic/category/showCategory","category",category );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param category Category:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addCategory")
	public void add(Category category,HttpServletRequest request,HttpServletResponse response){
	category.setCategoryId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(
				response,categoryService.add(category));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteCategory")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			categoryService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListCategory")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/category/listCategory");
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param category Category：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listCategory")
	public void listByCondition(Category category,HttpServletRequest request,
			HttpServletResponse response, Page page){
		category.setPage(page);	
		List<Category> list = categoryService.listByCondition(category);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditCategory")
	public ModelAndView toEdit(String key){
		Category entity = categoryService.getByPrimaryKey(key);
		Map<String,String> category = FormatEntity.getObjectValue(entity);
		
		return new ModelAndView("WEB-INF/jsp/basic/category/editCategory","category",category );
	}
	
	/**
	 * 修改方法
	 * @param category Category：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateCategory")
	public void update(Category category,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,categoryService.update(category));	
	}
	
}