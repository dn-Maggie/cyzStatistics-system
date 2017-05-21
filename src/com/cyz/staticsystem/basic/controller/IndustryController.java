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

import com.cyz.staticsystem.basic.model.Industry;
import com.cyz.staticsystem.basic.service.IndustryService;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.Utils;


/**
 * 描述：餐饮行业模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("industry")
public class IndustryController{
         @Resource
	private IndustryService industryService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddIndustry")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/industry/addIndustry");
		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowIndustry")
	public ModelAndView toShow(String key){
		Industry entity = industryService.getByPrimaryKey(key);
		Map<String,String> industry = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/basic/industry/showIndustry","industry",industry );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param industry Industry:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addIndustry")
	public void add(Industry industry,HttpServletRequest request,HttpServletResponse response){
	industry.setIndustryId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(
				response,industryService.add(industry));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteIndustry")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			industryService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListIndustry")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/industry/listIndustry");
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param industry Industry：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listIndustry")
	public void listByCondition(Industry industry,HttpServletRequest request,
			HttpServletResponse response, Page page){
		industry.setPage(page);	
		List<Industry> list = industryService.listByCondition(industry);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditIndustry")
	public ModelAndView toEdit(String key){
		Industry entity = industryService.getByPrimaryKey(key);
		Map<String,String> industry = FormatEntity.getObjectValue(entity);
		
		return new ModelAndView("WEB-INF/jsp/basic/industry/editIndustry","industry",industry );
	}
	
	/**
	 * 修改方法
	 * @param industry Industry：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateIndustry")
	public void update(Industry industry,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,industryService.update(industry));	
	}
	
}