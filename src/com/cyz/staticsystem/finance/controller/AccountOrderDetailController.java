package com.cyz.staticsystem.finance.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.basic.model.Brand;
import com.cyz.staticsystem.basic.service.BrandService;
import com.cyz.staticsystem.common.excel.ExcelExpUtils;
import com.cyz.staticsystem.common.excel.ExpParamBean;
import com.cyz.staticsystem.common.excel.ImportExcelUtil;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountOperaTotal;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.AccountSaleGoods;
import com.cyz.staticsystem.finance.model.OperaDetailStatic;
import com.cyz.staticsystem.finance.service.AccountOperaTotalService;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;


/**
 * 描述：订单明细模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-03-02
 */
 
@Controller
@RequestMapping("accountOrderDetail")
public class AccountOrderDetailController{
        @Resource
        private AccountOrderDetailService accountOrderDetailService;
     	@Resource
    	private AccountOperaTotalService accountOperaTotalService;
     	@Resource
    	private BrandService brandService;
     	@Resource
    	private StoreService storeService;
    	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param accountOrderDetail AccountOrderDetail:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addAccountOrderDetail")
	public void add(AccountOrderDetail accountOrderDetail,HttpServletRequest request,HttpServletResponse response){
	accountOrderDetail.setId(Utils.generateUniqueID());
	AjaxUtils.sendAjaxForObjectStr(
				response,accountOrderDetailService.add(accountOrderDetail));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteAccountOrderDetail")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			accountOrderDetailService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowAccountOrderDetail")
	public ModelAndView toShow(String key){
		AccountOrderDetail entity = accountOrderDetailService.getByPrimaryKey(key);
		Map<String,String> accountOrderDetail = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/finance/accountOrderDetail/showAccountOrderDetail","accountOrderDetail",accountOrderDetail);
	}
	/**
	 * 进入订单详细列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListAccountOrderDetail")
	public ModelAndView toList(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/accountOrderDetail/listAccountOrderDetail");
		 Store store = new Store();
		 Brand brand = new Brand();
		 	store.setIsDelete(0);
			boolean isAdmin = true;
	 		if(!Utils.isSuperAdmin(request)){
	 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
			}
			mv.addObject("brand",brandService.listByCondition(brand));
			mv.addObject("store",storeService.listByCondition(store));
			mv.addObject("isAdmin",isAdmin);
	 		return mv;
	}
	
	
	/**
	 * 根据条件查找订单详细
	 * @param accountOrderDetail AccountOrderDetail：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listAccountOrderDetail")
	public void listByCondition(AccountOrderDetail accountOrderDetail,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountOrderDetail.setPage(page);	
		if(accountOrderDetail.getStoreId()!=""&&accountOrderDetail.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(accountOrderDetail.getStoreId());
			accountOrderDetail.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			accountOrderDetail.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			accountOrderDetail.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<AccountOrderDetail> list = accountOrderDetailService.listByCondition(accountOrderDetail);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditAccountOrderDetail")
	public ModelAndView toEdit(String key){
		AccountOrderDetail entity = accountOrderDetailService.getByPrimaryKey(key);
		Map<String,String> accountOrderDetail = FormatEntity.getObjectValue(entity);
		
		return new ModelAndView("WEB-INF/jsp/finance/accountOrderDetail/editAccountOrderDetail","accountOrderDetail",accountOrderDetail );
	}
	
	/**
	 * 修改方法
	 * @param accountOrderDetail AccountOrderDetail：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateAccountOrderDetail")
	public void update(AccountOrderDetail accountOrderDetail,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,accountOrderDetailService.update(accountOrderDetail));	
	}
	/**
	 * 菜品数量表明细
	 */
	@RequestMapping("/listAccountSaleGoods")
	public void listGoods(AccountOrderDetail accountOrderDetail,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountOrderDetail.setPage(page);	
		List<AccountSaleGoods> list = accountOrderDetailService.listGoods(accountOrderDetail);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}	
 	//导出数据方法
	@RequestMapping("/exportExcel")
	public void exportExcel(AccountOrderDetail accountOrderDetail, ExpParamBean epb,
			HttpServletRequest request, HttpServletResponse response, Page page)
			throws Exception {		
		if(accountOrderDetail.getStoreId()!=""&&accountOrderDetail.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(accountOrderDetail.getStoreId());
			accountOrderDetail.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			accountOrderDetail.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			accountOrderDetail.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		int expType = Integer.parseInt(request.getParameter("expType"));
		if (expType == 1) {
			accountOrderDetail.setPage(page);
		}
		List<AccountOrderDetail> list = accountOrderDetailService.listByCondition(accountOrderDetail);
		ExcelExpUtils.exportListToExcel(list, response, epb.getFieldlist(),
				"订单明细列表", "订单明细列表");
	}
	
	/**
	 * 全盘信息页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListDetailStatic")
	public ModelAndView toListDetailStatic(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/staticAnalysis/detailStatic");
		 Store store = new Store();
		 Brand brand = new Brand();
		 	store.setIsDelete(0);
			boolean isAdmin = true;
	 		if(!Utils.isSuperAdmin(request)){
	 			//store.setOwnerUserId(Utils.getLoginUserInfoId(request));
	 			isAdmin = false;
			}
			mv.addObject("brand",brandService.listByCondition(brand));
			mv.addObject("store",storeService.listByCondition(store));
			mv.addObject("isAdmin",isAdmin);
	 		return mv;
	}
	/**
	 * 查询全盘信息页面
	 * @return ModelAndView
	 */
	@RequestMapping("/listDetailStatic")
	public void listDetailStatic(AccountOrderDetail accountOrderDetail,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountOrderDetail.setPage(page);	
		if(accountOrderDetail.getStoreId()!=""&&accountOrderDetail.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(accountOrderDetail.getStoreId());
			accountOrderDetail.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			accountOrderDetail.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			accountOrderDetail.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<OperaDetailStatic> list = accountOrderDetailService.listDetailStatic(accountOrderDetail);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
}