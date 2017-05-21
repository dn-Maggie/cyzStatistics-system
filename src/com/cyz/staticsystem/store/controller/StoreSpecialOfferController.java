package com.cyz.staticsystem.store.controller;

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
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.model.StoreSpecialOffer;
import com.cyz.staticsystem.store.service.StoreService;
import com.cyz.staticsystem.store.service.StoreSpecialOfferService;


/**
 * 描述：商铺特价菜模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-04-10
 */
 
@Controller
@RequestMapping("storeSpecialOffer")
public class StoreSpecialOfferController{
     @Resource
     private StoreSpecialOfferService storeSpecialOfferService;
     @Resource
     private StoreService storeService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddStoreSpecialOffer")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeSpecialOffer/addStoreSpecialOffer");
		Store store = new Store();
	 	store.setIsDelete(0);
		boolean isAdmin = true;
 		if(!Utils.isSuperAdmin(request)){
 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
 			isAdmin = false;
		}
		mv.addObject("store",storeService.listByCondition(store));
		mv.addObject("isAdmin",isAdmin);
 		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowStoreSpecialOffer")
	public ModelAndView toShow(String key){
		StoreSpecialOffer entity = storeSpecialOfferService.getByPrimaryKey(key);
		Map<String,String> storeSpecialOffer = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/store/storeSpecialOffer/showStoreSpecialOffer","storeSpecialOffer",storeSpecialOffer );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param storeSpecialOffer StoreSpecialOffer:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addStoreSpecialOffer")
	public void add(StoreSpecialOffer storeSpecialOffer,HttpServletRequest request,HttpServletResponse response){
	storeSpecialOffer.setId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(
				response,storeSpecialOfferService.add(storeSpecialOffer));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteStoreSpecialOffer")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			storeSpecialOfferService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListStoreSpecialOffer")
	public ModelAndView toList(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeSpecialOffer/listStoreSpecialOffer");
		 Store store = new Store();
		 	store.setIsDelete(0);
			boolean isAdmin = true;
	 		if(!Utils.isSuperAdmin(request)){
	 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
	 			isAdmin = false;
			}
			mv.addObject("store",storeService.listByCondition(store));
			mv.addObject("isAdmin",isAdmin);
	 		return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param storeSpecialOffer StoreSpecialOffer：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listStoreSpecialOffer")
	public void listByCondition(StoreSpecialOffer storeSpecialOffer,HttpServletRequest request,
			HttpServletResponse response, Page page){
		storeSpecialOffer.setPage(page);	
		List<StoreSpecialOffer> list = storeSpecialOfferService.listByCondition(storeSpecialOffer);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditStoreSpecialOffer")
	public ModelAndView toEdit(String key,HttpServletRequest request){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeSpecialOffer/editStoreSpecialOffer");
		StoreSpecialOffer entity = storeSpecialOfferService.getByPrimaryKey(key);
		Map<String,String> storeSpecialOffer = FormatEntity.getObjectValue(entity);
		mv.addObject("storeSpecialOffer",storeSpecialOffer);
		Store store = new Store();
	 	store.setIsDelete(0);
 		if(!Utils.isSuperAdmin(request)){
 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
		}
 		mv.addObject("store",storeService.listByCondition(store));
		return mv;
	}
	
	/**
	 * 修改方法
	 * @param storeSpecialOffer StoreSpecialOffer：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateStoreSpecialOffer")
	public void update(StoreSpecialOffer storeSpecialOffer,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,storeSpecialOfferService.update(storeSpecialOffer));	
	}
	
}