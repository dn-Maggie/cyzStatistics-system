package com.cyz.staticsystem.finance.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
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

import com.cyz.staticsystem.common.bean.RespMess;
import com.cyz.staticsystem.common.excel.ExcelExpUtils;
import com.cyz.staticsystem.common.excel.ExpParamBean;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.OperaDetailStatic;
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
	 * 统计运营订单数据
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/calcuOperaDetail")
	public void calcuOrderDetail(@RequestBody String str,HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		RespMess rm = new RespMess();
		OrderDetailQuery odq = new OrderDetailQuery();
		AccountOrderDetail orders = new AccountOrderDetail();
		JSONObject jo = JSONObject.fromObject(str);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			try{
				map.put("startDate",DateUtil.parseStringToDate(jo.getString("beginTime"), "yyyy-MM-dd"));
				map.put("endDate",DateUtil.parseStringToDate(jo.getString("queryTime"), "yyyy-MM-dd"));
			}catch(Exception e){
				map.put("startDate",DateUtil.now());
				map.put("endDate",DateUtil.now());
			}
			odq.setPropsMap(map);
			orders.setPropsMap(map);
			odq.setUsername(jo.getString("username").trim());
			odq.setPassword(jo.getString("password").trim());
			odq.setStoreId(StringUtils.defaultIfEmpty(jo.getString("storeId"), ""));
			odq.setBusinessArea(StringUtils.defaultIfEmpty(jo.getString("businessArea"), ""));
			orders.setStoreId(StringUtils.defaultIfEmpty(jo.getString("storeId"), ""));
			orders.setBusinessArea(StringUtils.defaultIfEmpty(jo.getString("businessArea"), ""));
			if(odq.getStoreId()!=""&&odq.getStoreId()!=null){
				Store s = storeService.getByPrimaryKey(jo.getString("storeId"));
				odq.setStoreELMId(StringUtils.defaultIfEmpty(
						s.getElmId(), "0"));
				odq.setStoreMTId(StringUtils.defaultIfEmpty(
						s.getMeituanId(), "0"));
				odq.setStoreBDId(StringUtils.defaultIfEmpty(
						s.getBaiduId(), "0"));
				orders.setStoreELMId(StringUtils.defaultIfEmpty(
						s.getElmId(), "0"));
				orders.setStoreMTId(StringUtils.defaultIfEmpty(
						s.getMeituanId(), "0"));
				orders.setStoreBDId(StringUtils.defaultIfEmpty(
						s.getBaiduId(), "0"));
			}
			//如果是超级管理员，可以看到所有
			if(Utils.isSuperAdmin(request)){
				odq.setUsername(null);
				odq.setPassword(null);
				orders.setBrandName(null);
			}
			//否则看自己所属账号下的店铺
			else{
				odq.setUsername(new String(odq.getUsername().getBytes("ISO-8859-1"),"utf-8"));
				odq.setPassword(odq.getPassword());
				orders.setBrandName(odq.getUsername());
			}
			List<OperaDetailStatic> osListdetail = accountOrderDetailService.listDetailStatic(orders);
			RespMess rs = new RespMess();
			for(int i = 0;i<osListdetail.size();i++){
				rs.setSuccessOrderPrice(rs.getSuccessOrderPrice()+osListdetail.get(i).getSuccessOrderAmount());
				rs.setSuccessOrderNum(rs.getSuccessOrderNum()+osListdetail.get(i).getSuccessOrderNum());
				rs.setElmsuccessOrderNum(rs.getElmsuccessOrderNum()+osListdetail.get(i).getElmsuccessOrderNum());
				rs.setElmsuccessOrderPrice(rs.getElmsuccessOrderPrice()+osListdetail.get(i).getElmsuccessOrderAmount());
				rs.setMtsuccessOrderNum(rs.getMtsuccessOrderNum()+osListdetail.get(i).getMtsuccessOrderNum());
				rs.setMtsuccessOrderPrice(rs.getMtsuccessOrderPrice()+osListdetail.get(i).getMtsuccessOrderAmount());
				rs.setBdwmsuccessOrderNum(rs.getBdwmsuccessOrderNum()+osListdetail.get(i).getBdwmsuccessOrderNum());
				rs.setBdwmsuccessOrderPrice(rs.getBdwmsuccessOrderPrice()+osListdetail.get(i).getBdwmsuccessOrderAmount());
			}
			rm.setRespMsg("成功");
			rm.setRespCode("0000");
			rm.setUsername(odq.getUsername());
			//运营详细数据
			rm.setOperaStatic(rs);
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
	 * 统计财务单数据
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/calcuOrderDetail")
	public void calcuOperaDetail(@RequestBody String str,HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException{
		RespMess rm = new RespMess();
		OrderDetailQuery odq = new OrderDetailQuery();
		JSONObject jo = JSONObject.fromObject(str);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			try{
				map.put("startDate",DateUtil.parseStringToDate(jo.getString("beginTime"), "yyyy-MM-dd"));
				map.put("endDate",DateUtil.parseStringToDate(jo.getString("queryTime"), "yyyy-MM-dd"));
			}catch(Exception e){
				map.put("startDate",DateUtil.now());
				map.put("endDate",DateUtil.now());
			}
			odq.setPropsMap(map);
			odq.setUsername(jo.getString("username").trim());
			odq.setPassword(jo.getString("password").trim());
			odq.setStoreId(StringUtils.defaultIfEmpty(jo.getString("storeId"), ""));
			odq.setBusinessArea(StringUtils.defaultIfEmpty(jo.getString("businessArea"), ""));
			
			if(odq.getStoreId()!=""&&odq.getStoreId()!=null){
				Store s = storeService.getByPrimaryKey(jo.getString("storeId"));
				odq.setStoreELMId(StringUtils.defaultIfEmpty(
						s.getElmId(), "0"));
				odq.setStoreMTId(StringUtils.defaultIfEmpty(
						s.getMeituanId(), "0"));
				odq.setStoreBDId(StringUtils.defaultIfEmpty(
						s.getBaiduId(), "0"));
			}
			//如果是超级管理员，可以看到所有
			if(Utils.isSuperAdmin(request)){
				odq.setUsername(null);
				odq.setPassword(null);
			}else{//否则看自己所属账号下的店铺
				odq.setUsername(new String(odq.getUsername().getBytes("ISO-8859-1"),"utf-8"));
				odq.setPassword(odq.getPassword());
			}
			List<OrderDetailStatic> osList = accountOrderDetailService.calcuOrderDetail(odq);
			if(osList.size()==0){
				odq.setQueryTime("");
				osList = accountOrderDetailService.calcuOrderDetailNull(odq);
			}
			RespMess rs = new RespMess();
			//计算饿了么、美团、百度外卖平台分别的销售量
			for(int i = 0;i<osList.size();i++){
				rs.setSuccessOrderPrice(rs.getSuccessOrderPrice()+osList.get(i).getSuccessOrderAmount());
				rs.setSuccessOrderNum(rs.getSuccessOrderNum()+osList.get(i).getSuccessOrderNum());
				if("elm".equals(osList.get(i).getPlatformType())){
					rs.setElmsuccessOrderNum(rs.getElmsuccessOrderNum()+osList.get(i).getSuccessOrderNum());
					rs.setElmsuccessOrderPrice(rs.getElmsuccessOrderPrice()+osList.get(i).getSuccessOrderAmount());
				}else if("mt".equals(osList.get(i).getPlatformType())){
					rs.setMtsuccessOrderNum(rs.getMtsuccessOrderNum()+osList.get(i).getSuccessOrderNum());
					rs.setMtsuccessOrderPrice(rs.getMtsuccessOrderPrice()+osList.get(i).getSuccessOrderAmount());
				}else if("bdwm".equals(osList.get(i).getPlatformType())){
					rs.setBdwmsuccessOrderNum(rs.getBdwmsuccessOrderNum()+osList.get(i).getSuccessOrderNum());
					rs.setBdwmsuccessOrderPrice(rs.getBdwmsuccessOrderPrice()+osList.get(i).getSuccessOrderAmount());
				}
			}
			rm.setRespMsg("成功");
			rm.setRespCode("0000");
			rm.setUsername(odq.getUsername());
			//财务数据
			rm.setAccountStatic(rs);
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
	 * 统计今日商家排名
	 */
	@RequestMapping("/staticStoreOrder")
	public void staticStoreOrder(@RequestBody String str,HttpServletRequest request,HttpServletResponse response){
		RespMess rm = new RespMess();
		AccountOrderDetail orders = new AccountOrderDetail();
		JSONObject jo = JSONObject.fromObject(str);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("startDate",DateUtil.parseStringToDate(jo.getString("beginTime"), "yyyy-MM-dd"));
			map.put("endDate",DateUtil.parseStringToDate(jo.getString("queryTime"), "yyyy-MM-dd"));
		}catch(Exception e){
			map.put("startDate",DateUtil.now());
			map.put("endDate",DateUtil.now());
		}
		orders.setPropsMap(map);
		//运营系统显示今日商家排名
		rm.setStoreOrderList(accountOrderDetailService.staticStoreOrder(orders));
		AjaxUtils.sendAjaxForObjectStr(response, rm);
	}	 
	/**
	 * 统计今日商家总量
	 */
	@RequestMapping("/staticStoreNum")
	public void staticStoreNum(@RequestBody String str,HttpServletRequest request,HttpServletResponse response){
		RespMess rm = new RespMess();
		Store store = new Store();
		JSONObject jo = JSONObject.fromObject(str);
		Map<String, Object> map = new HashMap<String, Object>();
		try{
			map.put("startDate",DateUtil.parseStringToDate(jo.getString("beginTime"), "yyyy-MM-dd"));
			map.put("endDate",DateUtil.parseStringToDate(jo.getString("queryTime"), "yyyy-MM-dd"));
		}catch(Exception e){
			map.put("startDate",DateUtil.now());
			map.put("endDate",DateUtil.now());
		}
		//运营系统显示今日商家排名
		store.setPropsMap(map);
		rm.setStoreNumList(storeService.staticStoreNum(store));
		AjaxUtils.sendAjaxForObjectStr(response, rm);
	}	 
	
	//导出全盘数据方法
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
			List<OperaDetailStatic> list = accountOrderDetailService.listDetailStatic(accountOrderDetail);
			ExcelExpUtils.exportListToExcel(list, response, epb.getFieldlist(),
					"全盘数据信息表", "全盘数据信息表");
		}
}