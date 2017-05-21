package com.cyz.staticsystem.finance.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.common.bean.RespMess;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.OrderDetailQuery;
import com.cyz.staticsystem.finance.model.OrderDetailStatic;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.finance.service.OperaDateService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


/**
 * 描述：财务配置类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-03-26
 */
 
@Controller
@RequestMapping("config")
public class ConfigController{
	@Resource
	private OperaDateService operaDateService;
	@Resource
	private AccountOrderDetailService accountOrderDetailService;
	@Resource
    private StoreService storeService;
	/**
	 * 配置表头
	 */
	@RequestMapping("/toConfigGridTitle")
	public ModelAndView toConfigGridTitle(String storeName){
		try {
			storeName = new String(storeName.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/finance/config/configGridTitle");
		mv.addObject("storeName",storeName);
		return mv;
	}	 
	/**
	 * 统计订单数据
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/calcuOrderDetail")
	public void calcuOrderDetail(@RequestBody String str,HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		RespMess rm = new RespMess();
		OrderDetailQuery odq = new OrderDetailQuery();
		AccountOrderDetail orders = new AccountOrderDetail();
		Store store = new Store();
		try{
			JSONObject jo = JSONObject.fromObject(str);
			odq.setUsername(jo.getString("username").trim());
			odq.setPassword(jo.getString("password").trim());
			odq.setQueryTime(jo.getString("queryTime"));
			//运营系统显示今日商家排名
			orders.setCreateDate(DateUtil.parseStringToDate(odq.getQueryTime(), "yyyy-MM-dd"));
			rm.setStoreOrderList(accountOrderDetailService.staticStoreOrder(orders));
			//运营系统显示今日商家总量
			store.setRegistDate(DateUtil.parseStringToDate(odq.getQueryTime(), "yyyy-MM-dd"));
			rm.setStoreNumList(storeService.staticStoreNum(store));
			//如果是超级管理员，可以看到所有
			if(Utils.isSuperAdmin(request)){
				odq.setUsername(null);
				odq.setPassword(null);
			}
			//否则看自己所属账号下的店铺
			else{
				odq.setUsername(new String(odq.getUsername().getBytes("ISO-8859-1"),"utf-8"));
				odq.setPassword(odq.getPassword());
			}
			
			List<OrderDetailStatic> osList = accountOrderDetailService.calcuOrderDetail(odq);
			if(osList.size()==0){
				odq.setQueryTime("");
				osList = accountOrderDetailService.calcuOrderDetailNull(odq);
			}
			JSONArray allList = new JSONArray();
			Integer successOrderNum = 0;
			Integer elmsuccessOrderNum = 0;
			Integer mtsuccessOrderNum = 0;
			Integer bdwmsuccessOrderNum = 0;
			double successOrderPrice = 0;
			double elmsuccessOrderPrice = 0;
			double mtsuccessOrderPrice = 0;
			double bdwmsuccessOrderPrice = 0;
			//计算饿了么、美团、百度外卖平台分别的销售量
			for(int i = 0;i<osList.size();i++){
				successOrderPrice+=osList.get(i).getSuccessOrderAmount();
				successOrderNum+=osList.get(i).getSuccessOrderNum();
				if("elm".equals(osList.get(i).getPlatformType())){
					elmsuccessOrderNum+=osList.get(i).getSuccessOrderNum();
					elmsuccessOrderPrice+=osList.get(i).getSuccessOrderAmount();
				}else if("mt".equals(osList.get(i).getPlatformType())){
					mtsuccessOrderNum+=osList.get(i).getSuccessOrderNum();
					mtsuccessOrderPrice+=osList.get(i).getSuccessOrderAmount();
				}else if("bdwm".equals(osList.get(i).getPlatformType())){
					bdwmsuccessOrderNum+=osList.get(i).getSuccessOrderNum();
					bdwmsuccessOrderPrice+=osList.get(i).getSuccessOrderAmount();
				}
			}
			allList.add(osList);
			
			rm.setRespMsg("成功");
			rm.setRespCode("0000");
			rm.setResult(allList);
			rm.setSuccessOrderPrice(successOrderPrice);
			rm.setSuccessOrderNum(successOrderNum);
			rm.setElmsuccessOrderNum(elmsuccessOrderNum);
			rm.setMtsuccessOrderNum(mtsuccessOrderNum);
			rm.setBdwmsuccessOrderNum(bdwmsuccessOrderNum);
			
			rm.setElmsuccessOrderPrice(elmsuccessOrderPrice);
			rm.setMtsuccessOrderPrice(mtsuccessOrderPrice);
			rm.setBdwmsuccessOrderPrice(bdwmsuccessOrderPrice);
			
			rm.setUsername(odq.getUsername());
		}catch(Exception e){
			rm.setRespMsg("失败");
			rm.setRespCode("9999");
			rm.setResult(null);
			rm.setSuccessOrderPrice(0);
			rm.setSuccessOrderNum(0);
			rm.setUsername(odq.getUsername());
		}
		AjaxUtils.sendAjaxForObjectStr(response, rm);
	}	 
	/**
	 * 统计商家排名
	 */
	@RequestMapping("/staticStoreOrder")
	public List<AccountOrderDetail> staticStoreOrder(AccountOrderDetail orders){
		return accountOrderDetailService.staticStoreOrder(orders);
	}	 
}