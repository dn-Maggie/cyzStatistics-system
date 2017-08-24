package com.cyz.staticsystem.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.basic.model.UserInfo;
import com.cyz.staticsystem.basic.service.UserInfoService;
import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.RespMess;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.MD5Encryption;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;
import com.cyz.staticsystem.system.model.Module;
import com.cyz.staticsystem.system.service.DictInfoService;
import com.cyz.staticsystem.system.service.ModuleService;


/**
 * 描述：首页模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2016-03-06
 */

@Controller
@RequestMapping("/")
public class MainController {
	@Resource
    private StoreService storeService;
	@Resource
	private UserInfoService userInfoService;
	@Resource
    private AccountOrderDetailService accountOrderDetailService;
	/**
	 * 设置service
	 * 
	 * @param userInfoService
	 *            UserService
	 */
	@Autowired
	public void setUserInfoService(UserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}
	private DictInfoService dictInfoService;
	/**
	 * 设置service
	 * @param dictInfoService DictInfoService
	 */
	@Autowired
	public void setDictInfoService(DictInfoService dictInfoService) {
		this.dictInfoService = dictInfoService;
	}
	private ModuleService moduleService;

	/**
	 * 设置service
	 * 
	 * @param moduleService
	 *            ModuleService
	 */
	@Autowired
	public void setModuleService(ModuleService moduleService) {
		this.moduleService = moduleService;
	}

	/**
	 * 进入首页页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView 返回到首页页面
	 */
	@RequestMapping("/index")
	public ModelAndView toMain(HttpServletRequest request) {
		UserInfo user = Utils.getLoginUserInfo(request);
		List<Module> menus = null;
		if (user.getUserAccount().equals("admin")) {// 超级管理员
			menus = moduleService.getMenuListForAdmin();
		} else {
			menus = moduleService.getMenuListByPcode(Utils.getLoginUserInfo(request).getId());
		}
		ModelAndView m = new ModelAndView("WEB-INF/jsp/common/adminMain");
		Map<String, Object> map = m.getModel();
		map.put("menus", menus);
		m.addObject("tradingArea", storeService.getBussinessArea());
		return m;
	}
	
	/**
	 * 进入首页页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView 返回到首页页面
	 */
	@RequestMapping("/adminHomePage")
	public ModelAndView adminHomePage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/common/adminHomePage");
		Map<String,Object> model = new HashMap<String,Object>();
		mv.addObject("model", model);
		mv.addObject("tradingArea", storeService.getBussinessArea());
		Store store = new Store();
	 	store.setIsDelete(0);
 		if(!Utils.isSuperAdmin(request)){
 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
		}
		mv.addObject("store",storeService.listByCondition(store));
		return mv;
	}
	/**
	 * 登录处理
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView 登陆页面
	 */
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		String userName = StringUtils.defaultIfEmpty(
				request.getParameter("userName"), StringUtils.EMPTY);
		String password = StringUtils.defaultIfEmpty(
				request.getParameter("password"), StringUtils.EMPTY);
		// 根据用户SID获取用户实体
		UserInfo userInfo = userInfoService.getByUserAccount(userName);
		// 判断用户密码和加密后输入密码是否一致
		if (userInfo == null || password == null || "".equals(password)) {
			return new ModelAndView("jsp/common/login", "message",
					Utils.getI18n("user.password.mistake", null));
		}
		boolean b = userInfo.getPassword().equals(MD5Encryption.MD5(password));
		// 如果一致则跳转主页否则跳转至登陆页
		if (!b) {
			// 密码错误跳转登陆页面，并返回提示
			return new ModelAndView("jsp/common/login", "message",
					Utils.getI18n("user.password.mistake", null));
		}
		if ((userInfo.getEnableStateDate() != null && DateUtil.now().compareTo(
				userInfo.getEnableStateDate()) == -1)
				|| (userInfo.getEnableEndDate() != null && DateUtil.parseDate(
						DateUtil.now(), Constant.DATETIME_FORMAT).compareTo(
						DateUtil.parseDate(userInfo.getEnableEndDate(),
								Constant.DATE_FORMAT) + " 23:59:59") == 1)) {
			// 开通开始时间大于NOW获取结束时间小于NOW，则图示
			return new ModelAndView("jsp/common/login", "message",
					Utils.getI18n("user.overdue", null));
		}
		// 登陆成功将用户信息放入session中
		request.getSession().setAttribute(Constant.LOGIN_USER_KEY, userInfo);
		userInfo.setLastLoginIp(Utils.getRemortIP(request));
		userInfo.setLastLoginTime(DateUtil.nowSqlTimestamp());
		userInfoService.updateLastLoginInfo(userInfo);
		return new ModelAndView("redirect:/index.do");
	}

	/**
	 * 跳转到登录页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView 登陆页面
	 */
	@RequestMapping("/tologin")
	public ModelAndView tologin(HttpServletRequest request) {
		return new ModelAndView("WEB-INF/jsp/common/login");

	}

	/**
	 * app登录处理
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView 登陆页面
	 */
	@RequestMapping("/appLogin")
	public void applogin(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = StringUtils.defaultIfEmpty(
				request.getParameter("userName"), StringUtils.EMPTY);
		String password = StringUtils.defaultIfEmpty(
				request.getParameter("password"), StringUtils.EMPTY);
		// 根据用户SID获取用户实体
		UserInfo userInfo = userInfoService.getByUserAccount(userName);
		ResultMessage rm = new ResultMessage();
		
		// 判断用户密码和加密后输入密码是否一致
		if (userInfo == null || password == null || "".equals(password)) {
			rm.setStatus(0);
			rm.setMessage(Utils.getI18n("user.password.mistake", null));
			AjaxUtils.sendAjaxForObjectStr(response, rm);
			return;
		}
		password = MD5Encryption.MD5(password);
		boolean b = userInfo.getPassword().equals(password);
		// 如果一致则跳转主页否则跳转至登陆页
		if (!b) {
			// 密码错误跳转登陆页面，并返回提示
			rm.setStatus(0);
			rm.setMessage(Utils.getI18n("user.password.mistake", null));
			AjaxUtils.sendAjaxForObjectStr(response, rm);
			return;
		}
		if ((userInfo.getEnableStateDate() != null && DateUtil.now().compareTo(
				userInfo.getEnableStateDate()) == -1)
				|| (userInfo.getEnableEndDate() != null && DateUtil.parseDate(
						DateUtil.now(), Constant.DATETIME_FORMAT).compareTo(
						DateUtil.parseDate(userInfo.getEnableEndDate(),
								Constant.DATE_FORMAT) + " 23:59:59") == 1)) {
			// 开通开始时间大于NOW获取结束时间小于NOW，则图示 账号过期
			rm.setStatus(0);
			rm.setMessage(Utils.getI18n("user.overdue", null));
			AjaxUtils.sendAjaxForObjectStr(response, rm);
			return;
		}

		// 登陆成功将用户信息放入session中
		request.getSession().setAttribute(Constant.LOGIN_USER_KEY, userInfo);
		userInfo.setLastLoginIp(Utils.getRemortIP(request));
		userInfo.setLastLoginTime(DateUtil.nowSqlTimestamp());
		userInfoService.updateLastLoginInfo(userInfo);
		rm.setData(userInfo);
		rm.setJsessionid(request.getSession().getId());
		AjaxUtils.sendAjaxForObjectStr(response, rm);
		
	}

	/**
	 * 验证图片验证码
	 * @return 
	 * */
	@RequestMapping("/varifyCode")
	public void varifyCode(HttpServletRequest request,HttpServletResponse response,String strcode){
		HttpSession session = request.getSession();
        String obj = session.getAttribute("validateCode").toString();
        String code = StringUtils.defaultIfEmpty(
				request.getParameter("strcode"), StringUtils.EMPTY);
        
        ResultMessage rm = new ResultMessage();
        // 如果一致则返回true
       if(code.toLowerCase().equals(obj.toLowerCase())){
    	   	rm.setStatus(1);
			AjaxUtils.sendAjaxForObjectStr(response, rm);
			return;
       }
       return;
	}
	/**
	 * 登出操作请求的页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView
	 */
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute(Constant.LOGIN_USER_KEY);
		return new ModelAndView("WEB-INF/jsp/common/login");
	}

	/**
	 * 登出操作请求的页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView
	 */
	@RequestMapping("/getLocationStr")
	public void getLocationStr(HttpServletRequest request,
			HttpServletResponse response) {
		String urlStr = StringUtils.defaultIfEmpty(
				request.getParameter("urlStr"), StringUtils.EMPTY);
		ResultMessage rm = new ResultMessage();
		rm.setMessage(moduleService.getModuleLocationStrByUrl(urlStr));
		AjaxUtils.sendAjaxForObjectStr(response, rm);
	}

	/**
	 * 进入没有权限信息提示页面
	 * 
	 * @return error
	 */
	@RequestMapping("/alertNoRight")
	public ModelAndView alertNoRight() {
		return showError("msg.noRight", null);
	}

	/**
	 * 进入错误信息提示页面
	 * 
	 * @param mKey
	 *            String
	 * @param mValue
	 *            mValue
	 * @return ModelAndView
	 */
	@RequestMapping("/showError")
	public ModelAndView showError(String mKey, String mValue) {
		Object[] variable = null;
		if (StringUtil.isBlank(mValue)) {
			variable = new Object[] {};
		} else {
			variable = mValue.split(",");
		}
		return new ModelAndView("jsp/common/error", "message", Utils.getI18n(mKey, variable));
	}


	/**
	 * 跳转到导入共通页面
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return ModelAndView
	 */
	@RequestMapping("/import/toImportExcel")
	public ModelAndView toImportExcel(HttpServletRequest request,
			String parseUrl, String serviceName, String serviceId) {
		ModelAndView m = new ModelAndView("jsp/common/importExcelPage");
		m.addObject("parseUrl", parseUrl);
		m.addObject("serviceName", serviceName);
		m.addObject("serviceId", serviceId);
		return m;
	}
	/**
	 * 登陆成功返回所有shopId
	 * 
	 * @return storeList
	 */
	@RequestMapping("/getShopId")
	public void getShopId(HttpServletRequest request,
			HttpServletResponse response) {
		String userName = StringUtils.defaultIfEmpty(
				request.getParameter("userName"), StringUtils.EMPTY);
		String password = StringUtils.defaultIfEmpty(
				request.getParameter("password"), StringUtils.EMPTY);
		// 根据用户SID获取用户实体
		UserInfo userInfo = userInfoService.getByUserAccount(userName);
		password = MD5Encryption.MD5(password);
		
		boolean b = userInfo.getPassword().equals(password);
		RespMess rm = new RespMess();
		if(b){
			Store store = new Store();
			store.setOwnerUserId(userInfo.getId());
			List<Store> list = storeService.listByCondition(store);
			rm.setRespMsg("成功");
			rm.setRespCode("0000");
			rm.setResult(list);
			AjaxUtils.sendAjaxForObjectStr(response, rm);
		}else{
			rm.setRespMsg("失败");
			rm.setRespCode("9999");
			rm.setResult(null);
			AjaxUtils.sendAjaxForObjectStr(response, rm);
		}
		
	}
}
