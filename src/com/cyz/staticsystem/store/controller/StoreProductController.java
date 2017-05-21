package com.cyz.staticsystem.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.product.service.ProductClassService;
import com.cyz.staticsystem.product.service.ProductService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.model.StoreProduct;
import com.cyz.staticsystem.store.service.StoreProductService;
import com.cyz.staticsystem.store.service.StoreService;
import com.cyz.staticsystem.system.service.DictInfoService;


/**
 * 描述：店铺产品模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-20
 */
 
@Controller
@RequestMapping("storeProduct")
public class StoreProductController{
	@Resource
	private StoreProductService storeProductService;
	@Resource
	private ProductClassService productClassService;	
	@Resource
	private ProductService productService;	
	@Resource
	private StoreService storeService;
	@Resource
	private DictInfoService dictInfoService;
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddStoreProduct")
	public ModelAndView toAdd(String storeId,HttpServletRequest request){
 		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeProduct/addStoreProduct","storeId",storeId);
 		mv.addObject("productClass", productClassService.listByCondition(null));
 		mv.addObject("product", productService.listByCondition(null));
 		Store store = new Store();
	 	store.setIsDelete(0);
 		if(!Utils.isSuperAdmin(request))
 		{store.setOwnerUserId(Utils.getLoginUserInfoId(request));}
 		mv.addObject("store",storeService.listByCondition(store));
 		return  mv;
 	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowStoreProduct")
	public ModelAndView toShow(String key,HttpServletRequest request){
		StoreProduct entity = storeProductService.getByPrimaryKey(key);
		Map<String,String> storeProduct = FormatEntity.getObjectValue(entity);
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeProduct/showStoreProduct","storeProduct",storeProduct );
		mv.addObject("productClass", productClassService.listByCondition(null));
 		mv.addObject("product", productService.listByCondition(null));
 		mv.addObject("productStatus", dictInfoService.getDictInfoListByType("productStatus"));
 		Store store = new Store();
	 	store.setIsDelete(0);
		if(!Utils.isSuperAdmin(request))
 		{store.setOwnerUserId(Utils.getLoginUserInfoId(request));}
 		mv.addObject("store",storeService.listByCondition(store));
		return mv;
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param storeProduct StoreProduct:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addStoreProduct")
	public void add(StoreProduct storeProduct,HttpServletRequest request,HttpServletResponse response){
	storeProduct.setStoreProductId(Utils.generateUniqueID());
	
	AjaxUtils.sendAjaxForObjectStr(response,storeProductService.add(storeProduct));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteStoreProduct")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			storeProductService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListStoreProduct")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeProduct/listStoreProduct");
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param storeProduct StoreProduct：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listStoreProduct")
	public void listByCondition(StoreProduct storeProduct,HttpServletRequest request,
			HttpServletResponse response, Page page){
		storeProduct.setPage(page);	
		if(!Utils.isSuperAdmin(request))
 		{storeProduct.setOwnerUserId(Utils.getLoginUserInfoId(request));}
		List<StoreProduct> list = storeProductService.listByCondition(storeProduct);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditStoreProduct")
	public ModelAndView toEdit(String key,HttpServletRequest request){
		StoreProduct entity = storeProductService.getByPrimaryKey(key);
		Map<String,String> storeProduct = FormatEntity.getObjectValue(entity);
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/storeProduct/editStoreProduct","storeProduct",storeProduct );
		mv.addObject("productClass", productClassService.listByCondition(null));
 		mv.addObject("product", productService.listByCondition(null));
 		mv.addObject("productStatus", dictInfoService.getDictInfoListByType("productStatus"));
 		Store store = new Store();
	 	store.setIsDelete(0);
		if(!Utils.isSuperAdmin(request))
 		{store.setOwnerUserId(Utils.getLoginUserInfoId(request));}
 		mv.addObject("store",storeService.listByCondition(store));
		return mv;
	}
	
	/**
	 * 修改方法
	 * @param storeProduct StoreProduct：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateStoreProduct")
	public void update(StoreProduct storeProduct,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,storeProductService.update(storeProduct));	
	}
	
}