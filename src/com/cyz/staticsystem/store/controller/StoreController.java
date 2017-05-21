package com.cyz.staticsystem.store.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.basic.model.Brand;
import com.cyz.staticsystem.basic.model.Category;
import com.cyz.staticsystem.basic.model.UserInfo;
import com.cyz.staticsystem.basic.service.BrandService;
import com.cyz.staticsystem.basic.service.CategoryService;
import com.cyz.staticsystem.basic.service.UserInfoService;
import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.excel.ImportExcelUtil;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.HttpRequest;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.model.StoreByPlatform;
import com.cyz.staticsystem.store.service.StoreService;
import com.cyz.staticsystem.system.model.DictInfo;
import com.cyz.staticsystem.system.model.Personrole;
import com.cyz.staticsystem.system.service.DictInfoService;
import com.cyz.staticsystem.system.service.PersonroleService;


/**
 * 描述：店铺模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("store")
public class StoreController{
	@Resource
	private PersonroleService personroleService;
    @Resource
    private StoreService storeService;
    @Resource
    private BrandService brandService;
    @Resource
    private CategoryService categoryService;
    @Resource
    private DictInfoService dictInfoService;
    @Resource
    private UserInfoService userInfoService;
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddStore")
	public ModelAndView toAdd(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/store/addStore");
		mv.addObject("brand", brandService.listByCondition(new Brand()));
		UserInfo userInfo = new UserInfo();
		if(!Utils.isSuperAdmin(request)){userInfo.setId(Utils.getLoginUserInfoId(request));}
		mv.addObject("user", userInfoService.listByCondition(userInfo));
		return mv;
	}
	
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toSelectStore")
	public ModelAndView toSelectStore(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/store/selectStore");
		return mv;
	}
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowStore")
	public ModelAndView toShow(String key,HttpServletRequest request){
		Store entity = storeService.getByPrimaryKey(key);
		Map<String,String> store = FormatEntity.getObjectValue(entity);
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/store/showStore","store",store);
		mv.addObject("settlementMethod", dictInfoService.getDictInfoListByType("settlementMethod"));
		UserInfo userInfo = new UserInfo();
		if(!Utils.isSuperAdmin(request))
 		{userInfo.setId(Utils.getLoginUserInfoId(request));}
		mv.addObject("user", userInfoService.listByCondition(userInfo));
		mv.addObject("brand", brandService.listByCondition(new Brand()));
		return mv;
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param store Store:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addStore")
	public void add(Store store,HttpServletRequest request,HttpServletResponse response){
		store.setStoreId(Utils.generateUniqueID());
		if(storeService.add(store)>0){
			ResultMessage message = userInfoService.addStoreUserInfo(store,Utils.getLoginUserInfo(request));
			if(message.getStatus()==1){
				store.setOwnerUserId(message.getMessage()); 
				storeService.update(store);
				AjaxUtils.sendAjaxForObjectStr(response,storeService.getByPrimaryKey(store.getStoreId()));
			}else{
				AjaxUtils.sendAjaxForObjectStr(response,AjaxUtils.getFailureMessage("此店铺账号已经存在"));
			}
		}
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteStore")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			storeService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 * @throws IOException 
	 */
	@RequestMapping("/toListStore")
	public ModelAndView toList(HttpServletRequest request,HttpServletResponse  response) throws NullPointerException, IOException{
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/store/listStore");
		 	Store store = new Store();
		 	Brand brand = new Brand();
		 	Category category = new Category();
		 	store.setIsDelete(0);
		 	boolean isAdmin = true;
	 		try{if(!Utils.isSuperAdmin(request)){
	 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
	 			isAdmin = false;
			}}
	 		catch(Exception e){
	 				response.sendRedirect(request.getContextPath() +"/tologin.do");
	 		}
			mv.addObject("store",storeService.listByCondition(store));
			mv.addObject("brand",brandService.listByCondition(brand));
			mv.addObject("category",categoryService.listByCondition(category));
			mv.addObject("isAdmin",isAdmin);
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param store Store：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listStore")
	public void listByCondition(Store store,HttpServletRequest request,
			HttpServletResponse response, Page page){
		store.setPage(page);	
		/*Personrole personrole = getPersonrole(Utils.getLoginUserInfoId(request));*/
		/*if(!Utils.isSuperAdmin(request)&&personrole.getRoleId().equals("38703abe-b9ab-4dd1-aa8d-1327c9b35dee"))
 		{
			store.setUserGroup(Utils.getLoginUserInfo(request).getUserGroup());
		}else if(!Utils.isSuperAdmin(request)&&!personrole.getRoleId().equals("38703abe-b9ab-4dd1-aa8d-1327c9b35dee")){
			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
		}*/
		List<Store> list = storeService.listByCondition(store);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 根据用户ID获取角色用户关联实体
	 * 
	 * @param userInfoId
	 *            用户ID
	 * @return 角色用户关联实体
	 
	private Personrole getPersonrole(String userInfoId) {
		Personrole personrole = new Personrole();
		personrole.setUserId(userInfoId);
		List<Personrole> personroles = personroleService
				.listByCondition(personrole);
		if (personroles != null && personroles.size() > 0) {
			return personroles.get(0);
		} else {
			return null;
		}
	}
*/
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditStore")
	public ModelAndView toEdit(String key,HttpServletRequest request){
		Store entity = storeService.getByPrimaryKey(key);
		Map<String,String> store = FormatEntity.getObjectValue(entity);
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/store/store/editStore","store",store );
		mv.addObject("settlementMethod", dictInfoService.getDictInfoListByType("settlementMethod"));
		UserInfo userInfo = new UserInfo();
		if(!Utils.isSuperAdmin(request))
 		{userInfo.setId(Utils.getLoginUserInfoId(request));}
		mv.addObject("user", userInfoService.listByCondition(userInfo));
		mv.addObject("brand", brandService.listByCondition(new Brand()));
		return mv;
	}
	
	/**
	 * 修改图片方法
	 * @param store Store：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateImg")
	public void updateImg(Store store,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,storeService.updateImg(store));	
	}
	/**
	 * 修改方法
	 * @param store Store：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateStore")
	public void update(Store store,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(
				response,storeService.update(store));	
	}
	/**
	 * 进入产品资源界面
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toListStoreProduct")
	public ModelAndView toListStoreProduct(String key){
		return new ModelAndView("WEB-INF/jsp/store/store/listStoreProduct","storeId",key );
	}
	/**
	 * 进入店铺产品分类界面
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toListStoreProductClass")
	public ModelAndView toListStoreProductClass(String key){
		return new ModelAndView("WEB-INF/jsp/store/store/listStoreProduct","storeId",key );
	}
	
	
	/**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
 	@RequestMapping("/storeImport")
	public void storeImport(HttpServletRequest request,HttpServletResponse response
		)throws Exception {  	
 		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
 		InputStream in =null;  
        List<List<Object>> listob = null;  
        ArrayList<Store> storeList = new ArrayList<Store>();
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        for (int i = 0; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            Store store = new Store();  
            try{
            	store.setStoreId(Utils.generateUniqueID());
    			store.setStoreName(StringUtil.valueOf(lo.get(0)));
    			store.setUserAccount(StringUtil.valueOf(lo.get(1)));
    			store.setBusinessArea(StringUtil.valueOf(lo.get(3)));
    			store.setStoreAddress(StringUtil.valueOf(lo.get(4)));
    			store.setStoreTel(StringUtil.valueOf(lo.get(5)));
    			store.setStoreType(StringUtil.valueOf(lo.get(6)));
    			store.setOperateDate(new Timestamp(DateUtil.parseStringToyyyyMMdd(StringUtil.valueOf(lo.get(7))).getTime()));
    			store.setWorkTimeBegin(StringUtil.valueOf(lo.get(8)));
    			store.setWorkTimeEnd(StringUtil.valueOf(lo.get(9)));
    			store.setStoreDistMode(StringUtil.valueOf(lo.get(10)));
    			store.setStoreOwnerName(StringUtil.valueOf(lo.get(11)));
    			store.setStoreOwnerTel(StringUtil.valueOf(lo.get(12)));
    			store.setProInvoiceFlag(StringUtil.valueOf(lo.get(13)));
    			store.setSettlementMethod(StringUtil.valueOf(lo.get(14)));
    			store.setRegistrant(StringUtil.valueOf(lo.get(15)));
    			store.setRegistDate(new Timestamp(DateUtil.parseStringToyyyyMMdd(StringUtil.valueOf(lo.get(16))).getTime()));
    			store.setRemark(StringUtil.valueOf(lo.get(17)));
    			store.setAverageSales(StringUtil.valueOf(lo.get(18)));
    			store.setElmUsername(StringUtil.valueOf(lo.get(19)));
    			store.setElmPwd(StringUtil.valueOf(lo.get(20)));
    			store.setElmId(StringUtil.valueOf(lo.get(21)));
    			store.setElmRate(StringUtil.valueOf(lo.get(22)));
    			store.setMeituanId(StringUtil.valueOf(lo.get(23)));
    			store.setMeituanPwd(StringUtil.valueOf(lo.get(24)));
    			store.setMeituanRate(StringUtil.valueOf(lo.get(25)));
    			store.setMeituanSale(StringUtil.valueOf(lo.get(26)));
    			store.setBaiduId(StringUtil.valueOf(lo.get(27)));
    			store.setBaidupwd(StringUtil.valueOf(lo.get(28)));
    			store.setBaiduRate(StringUtil.valueOf(lo.get(29)));
    			store.setBaiduSale(StringUtil.valueOf(lo.get(30)));
    			store.setBoundType(StringUtil.valueOf(lo.get(31)));
    			ResultMessage rm =userInfoService.addStoreUserInfo(store,Utils.getLoginUserInfo(request));
    			int iStatus = rm.getStatus();
    			String ownerUserId = rm.getMessage();
    			if(iStatus!=1){
    				continue;
    			}else if(iStatus==1&&ownerUserId.length()>0){
    				store.setOwnerUserId(ownerUserId);
                	storeList.add(store);
    			}
            }catch(Exception e){
            	e.printStackTrace();
            }
        }  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
	        Map<String, String> map = new HashMap<String, String>();
	        if(storeList.size()>0){
	        	storeService.addStores(storeList);
	        	map.put("msg", "成功");
	        }else{
	        	map.put("msg", "失败");
	        }
		AjaxUtils.sendAjaxForObject(response, map);
		}
 	
 	/**
	 * 进入店铺产品分类界面
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/listStoreByPlatform")
	public void listStoreByPlatform(String platformType, Page page,HttpServletRequest request,HttpServletResponse response){
		Store s = new Store();
		s.setPlatformType(platformType);
		ResultMessage rm = new ResultMessage();
		List<StoreByPlatform>  sp = storeService.listStoreByPlatform(platformType,s);
		if(sp.size()>0){
			rm.setResult(storeService.listStoreByPlatform(platformType,s));
			rm.setRespCode("0000");
			rm.setRespMsg("成功");
		}else{
			rm.setResult(null);
			rm.setRespCode("9999");
			rm.setRespMsg("失败");
		}
		AjaxUtils.sendAjaxForObjectStr(response, rm);
	}
	/**
	 * 查询账号
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/checkStoreAcocunt")
	public void checkStoreAcocunt(@RequestBody String param,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(response, HttpRequest.sendPost(Constant.URL_STORE_USERNAME_VALIDATE, param));
	}
	/**
	 * 获取百度外卖验证码TOKEN
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/getBDToken")
	public void getBDToken(@RequestBody String param,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(response, HttpRequest.sendPost(Constant.URL_BDSTORE_GETTOKEN, param));
	}
	/**
	 * 百度登录验证
	 * @param key String：店铺ID
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/checkBDStoreAcocunt")
	public void checkBaiDuStoreAcocunt(@RequestBody String param,HttpServletRequest request,HttpServletResponse response){
		AjaxUtils.sendAjaxForObjectStr(response, HttpRequest.sendPost(Constant.URL_BDLOGIN, param));
	}
	
}