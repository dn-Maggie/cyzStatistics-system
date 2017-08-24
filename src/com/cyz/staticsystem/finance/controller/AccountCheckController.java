package com.cyz.staticsystem.finance.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.common.excel.ExcelExpUtils;
import com.cyz.staticsystem.common.excel.ExpParamBean;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountCheck;
import com.cyz.staticsystem.finance.model.AccountOperateIncome;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.service.AccountCheckService;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;


/**
 * 描述：财务对账模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-23
 */
 
@Controller
@RequestMapping("accountCheck")
public class AccountCheckController{
    @Resource
    private AccountCheckService accountCheckService;
    @Resource
    private AccountOrderDetailService accountOrderDetailService;
    @Resource
	private StoreService storeService;
	/**
	 * 进入明细列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListAccountCheck")
	public ModelAndView toList(HttpServletRequest request){
		ModelAndView mv =  new ModelAndView("WEB-INF/jsp/finance/accountCheck/listAccountCheck");
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
	 * 进入汇总列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListTotalAccountCheck")
	public ModelAndView toListTotal(HttpServletRequest request){
		ModelAndView mv =  new ModelAndView("WEB-INF/jsp/finance/accountCheck/listAccountCheckByTotal");
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
	 * @param accountCheck AccountCheck：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listAccountCheck")
	public void listByCondition(AccountOrderDetail accountOrderDetail,String type,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountOrderDetail.setPage(page);	
		List<AccountOperateIncome> list =  null;
		switch (type) {
		case "boundMerchant":
			list = accountCheckService.listDetailAccountCheckByBoundMerchant(accountOrderDetail);
			break;
		case "boundCompany":
			list = accountCheckService.listDetailAccountCheckByBoundCompany(accountOrderDetail);
			break;
		default:
			break;
		}
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 根据条件查找列表方法
	 * @param accountCheck AccountCheck：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listTotalAccountCheck")
	public void listTotalAccountCheck(AccountOrderDetail accountOrderDetail,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountOrderDetail.setPage(page);
		List<AccountOperateIncome> list = accountCheckService.listTotalAccountCheck(accountOrderDetail);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 修改方法
	 * @param accountCheck AccountCheck：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateAccountCheckTotal")
	public void update(AccountCheck accountCheck,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,accountCheckService.updateTotal(accountCheck));	
	}
	//导出对账明细方法
	@RequestMapping("/exportExcel")
	public void exportDetailExcel(AccountOrderDetail accountOrderDetail, ExpParamBean epb,
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
		List<AccountOperateIncome> list = null;
		try{
			String gridId = request.getParameter("gridId");
			String filename = "";
			String title = "";
				switch (gridId) {
				case "#check":
					list =  accountCheckService.listTotalAccountCheck(accountOrderDetail);
					filename = "对账汇总表";
					title = "对账汇总表";
					break;
				case "#boundMerchant":
					list = accountCheckService.listDetailAccountCheckByBoundMerchant(accountOrderDetail);
					filename = "绑商家卡对账表";
					title = "绑商家卡对账表";
					break;
				case "#boundCompany":
					list = accountCheckService.listDetailAccountCheckByBoundCompany(accountOrderDetail);
					filename = "绑公司卡对账表";
					title = "绑公司卡对账表";
					break;
				default:
					break;
				}
				ExcelExpUtils.exportListToExcel(list, response, epb.getFieldlist(),
						filename, title);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}