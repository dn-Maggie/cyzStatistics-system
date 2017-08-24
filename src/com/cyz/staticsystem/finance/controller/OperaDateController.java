package com.cyz.staticsystem.finance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.excel.ExcelExpUtils;
import com.cyz.staticsystem.common.excel.ExpParamBean;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountCheck;
import com.cyz.staticsystem.finance.model.AccountOperaTotal;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.AccountSaleGoods;
import com.cyz.staticsystem.finance.model.AccountSpecialFood;
import com.cyz.staticsystem.finance.model.OperaDate;
import com.cyz.staticsystem.finance.service.AccountCheckService;
import com.cyz.staticsystem.finance.service.AccountOperaTotalService;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.finance.service.OperaDateService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;


/**
 * 描述：运营日明细模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-03-28
 */
 
@Controller
@RequestMapping("operaDate")
public class OperaDateController{
    @Resource
	private OperaDateService operaDateService;
    @Resource
 	private AccountOperaTotalService accountOperaTotalService;
    @Resource
	private StoreService storeService;
    @Resource
    private AccountOrderDetailService accountOrderDetailService;
    @Resource
    private AccountCheckService accountCheckService;
	/**
	 * 进入运营数据菜品分析
	 * @return ModelAndView
	 */
	@RequestMapping("/toListGoods")
	public ModelAndView toListByDate(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/accountOperateIncome/listGoods");
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
	 * 进入特价菜品表明细
	 * @return ModelAndView
	 */
	@RequestMapping("/toListSpecialFood")
	public ModelAndView toListSpecialFood(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/accountOperateIncome/listAccountSpecialFood");
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
	 * 特价菜品表明细
	 */
	@RequestMapping("/listSpecialFood")
	public void listSpecialFood(AccountSpecialFood accountSpecialFood,HttpServletRequest request,
			HttpServletResponse response, Page page){
		accountSpecialFood.setPage(page);	
		if(accountSpecialFood.getStoreId()!=""&&accountSpecialFood.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(accountSpecialFood.getStoreId());
			accountSpecialFood.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			accountSpecialFood.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			accountSpecialFood.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<AccountSpecialFood> list = operaDateService.listSpecialFood(accountSpecialFood);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}	
	/**
	 * 进入运营明细列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListAccountOperateIncome")
	public ModelAndView toList(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/accountOperateIncome/listAccountOperateIncome");
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
	 * 进入运营汇总数据
	 * @return ModelAndView
	 */
	@RequestMapping("/toListOperateIncomeByTotal")
	public ModelAndView toListAllFromOrderDetail(HttpServletRequest request){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/accountOperateIncome/listAccountOperateIncomeByTotal");
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
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteOperaDate")
	public void deleteByKey(AccountOrderDetail accountOrderDetail,String type,HttpServletResponse response){
		Map<String, String> map = new HashMap<String, String>();
		try{
			operaDateService.deleteDeepOperaByOrderDetail(accountOrderDetail);
			map.put("msg", "成功");
		}catch(Exception e){
			map.put("msg", e.getMessage());
		}
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	
	/**
	 * 根据条件查找列表方法
	 * @param operaDate OperaDate：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listOperaDate")
	public void listByCondition(OperaDate operaDate,String type,HttpServletRequest request,
			HttpServletResponse response, Page page){
		operaDate.setPage(page);
		if(operaDate.getStoreId()!=""&&operaDate.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(operaDate.getStoreId());
			operaDate.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			operaDate.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			operaDate.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<OperaDate> list = operaDateService.listDeepOperaByCondition(operaDate);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 修改运营日报表方法
	 * @param operaDate OperaDate：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateOperaDate")
	public void update(OperaDate operaDate,String type,HttpServletRequest request,HttpServletResponse response){
		ResultMessage rs = new ResultMessage();
		switch (type) {
		case "deepOpera":
			rs= operaDateService.updateDeepOpera(operaDate);
			//根据修改的运营日报表修改运营总表（深运营）
			operaDate.setId(operaDate.getStoreId());
			accountOperaTotalService.deleteDeepTotalByOperaDate(operaDate);
			accountOperaTotalService.addDeepTotalByOperaDate(operaDate);
			AjaxUtils.sendAjaxForObjectStr(response,rs);	
			break;
		case "otherSum":
			Store s = storeService.getByPrimaryKey(operaDate.getStoreName());
			operaDate.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			operaDate.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			operaDate.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
			operaDate.setOperator(Utils.getLoginUserInfoId(request));
			rs = operaDateService.updateDeepOperaSum(operaDate);
			accountOperaTotalService.deleteDeepTotalByOperaDate(operaDate);
			accountOperaTotalService.addDeepTotalByOperaDate(operaDate);
			AjaxUtils.sendAjaxForObjectStr(response,rs);	
			break;
		default:
			break;
		}
		
	}
	
	/**
	 * 批量新增方法
	 * @param response HttpServletResponse
	 * @param accountOperaTotal AccountOperaTotal:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addByOrderDetail")
	public void addByOperaDetail(AccountOrderDetail accountOrderDetail,HttpServletRequest request,HttpServletResponse response){
		OperaDate operaDate = new OperaDate();
		ResultMessage rs = new ResultMessage(0,"店铺未关联该系统");
		try{
			operaDateService.deleteDeepOperaByOrderDetail(accountOrderDetail);
			if(operaDateService.addDeepOperaByOrderDetail(accountOrderDetail)>0){
				rs.setMessage("生成运营表成功");
				Store s = storeService.getByPrimaryKey(accountOrderDetail.getStoreId());
				if(s!=null){
					operaDate.setStoreId(accountOrderDetail.getStoreId());
					operaDate.setStoreELMId(StringUtils.defaultIfEmpty(
							s.getElmId(), "0"));
					operaDate.setStoreMTId(StringUtils.defaultIfEmpty(
							s.getMeituanId(), "0"));
					operaDate.setStoreBDId(StringUtils.defaultIfEmpty(
							s.getBaiduId(), "0"));
				}
				accountOperaTotalService.deleteDeepTotalByOperaDate(operaDate);
				accountOperaTotalService.addDeepTotalByOperaDate(operaDate);
			}
			}catch(Exception e){
				rs.setMessage("生成运营表或对账表时出错");
				AjaxUtils.sendAjaxForObjectStr(response,rs);
				return;
			}
		AjaxUtils.sendAjaxForObjectStr(response,rs);
	}
	//导出数据方法
	@RequestMapping("/exportExcel")
	public void exportExcel(OperaDate operaDate, ExpParamBean epb,
			HttpServletRequest request, HttpServletResponse response, Page page)
			throws Exception {		
		if(operaDate.getStoreId()!=""&&operaDate.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(operaDate.getStoreId());
			operaDate.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			operaDate.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			operaDate.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		//获取到处选择项
		int expType = Integer.parseInt(request.getParameter("expType"));
		//导出当前页数据
		if (expType == 1) {operaDate.setPage(page);}
		List<OperaDate> list = null;
		try{
			String gridId = request.getParameter("gridId");
			String filename = "";
			String title = "";
				switch (gridId) {
				case "#special":
					AccountSpecialFood accountSpecialFood = new AccountSpecialFood();
					accountSpecialFood.setStoreName(operaDate.getStoreName());
					List<AccountSpecialFood> specialList = operaDateService.listSpecialFood(accountSpecialFood);
					filename = "特价菜结算表";
					title = "特价菜结算表";
					ExcelExpUtils.exportListToExcel(specialList, response, epb.getFieldlist(),
							filename, title);
					return;
				case "#goods":
					AccountOrderDetail accountOrderDetail = new AccountOrderDetail();
					accountOrderDetail.setStoreName(operaDate.getStoreName());
					List<AccountSaleGoods> goodsList = accountOrderDetailService.listGoods(accountOrderDetail);
					filename = "菜品数量表";
					title = "菜品数量表";
					ExcelExpUtils.exportListToExcel(goodsList, response, epb.getFieldlist(),
							filename, title);
					return;
				case "#deepOpera":
					list = operaDateService.listDeepOperaByCondition(operaDate);
					filename = "深运营表";
					title = "深运营表";
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