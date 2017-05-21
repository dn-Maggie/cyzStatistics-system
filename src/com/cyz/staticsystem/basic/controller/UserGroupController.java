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

import com.cyz.staticsystem.basic.model.UserGroup;
import com.cyz.staticsystem.basic.service.UserGroupService;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.FormatEntity;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.system.model.Role;


/**
 * 描述：用户组别模块controller类，负责页面分发与跳转
 * 
 * @author maggie
 * @version 1.0 2017-03-01
 */
 
@Controller
@RequestMapping("userGroup")
public class UserGroupController{
         @Resource
	private UserGroupService userGroupService;
	 
 	/**
 	* 进入新增页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toAddUserGroup")
	public ModelAndView toAdd(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/userGroup/addUserGroup");
		mv.addObject("userGroupList", userGroupService.listByCondition(null));
		return mv;
	}
	
	/**
	 * 进入查看页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toShowUserGroup")
	public ModelAndView toShow(String key){
		UserGroup entity = userGroupService.getByPrimaryKey(key);
		Map<String,String> userGroup = FormatEntity.getObjectValue(entity);
		return new ModelAndView("WEB-INF/jsp/basic/userGroup/showUserGroup","userGroup",userGroup );
	}
	
	/**
	 * 新增方法
	 * @param response HttpServletResponse
	 * @param userGroup UserGroup:实体类
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/addUserGroup")
	public void add(UserGroup userGroup,HttpServletRequest request,HttpServletResponse response){
	userGroup.setId(Utils.generateUniqueID());
	userGroup.setGroupCreater(Utils.getLoginUserInfoId(request));
	userGroup.setGroupCreateTime(DateUtil.now());
	userGroup.setGroupUpdater(Utils.getLoginUserInfoId(request));
	userGroup.setGroupUpdateTime(DateUtil.now());
	AjaxUtils.sendAjaxForObjectStr(
				response,userGroupService.add(userGroup));		
	}
	
	/**
	 * 删除方法
	 * @param response HttpServletResponse
	 * @param key String:多个由“，”分割开的id字符串
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/deleteUserGroup")
	public void deleteByKey(String key,HttpServletResponse response){
		String[] str = key.split(",");
		for(int i=0;i<str.length;i++){
			userGroupService.deleteByKey(str[i]);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("msg", "成功");
		AjaxUtils.sendAjaxForMap(response, map);
	}
	
	/**
	 * 进入列表页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toListUserGroup")
	public ModelAndView toList(){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/userGroup/listUserGroup");
		 return mv;
	}
	
	/**
	 * 根据条件查找列表方法
	 * @param userGroup UserGroup：实体对象（查询条件）
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @param page Page:分页对象
	 * @return: ajax输入json字符串
	 */
	@RequestMapping("/listUserGroup")
	public void listByCondition(UserGroup userGroup,HttpServletRequest request,
		HttpServletResponse response, Page page){
		userGroup.setPage(page);	
		List<UserGroup> list = userGroupService.listByCondition(userGroup);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 进入修改页面方法
	 * @param key String：实体id
	 * @return ModelAndView: 查询实体
	 */	
	@RequestMapping("/toEditUserGroup")
	public ModelAndView toEdit(String key){
		UserGroup entity = userGroupService.getByPrimaryKey(key);
		Map<String,String> userGroup = FormatEntity.getObjectValue(entity);
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/basic/userGroup/editUserGroup","userGroup",userGroup );
		mv.addObject("userGroupList", userGroupService.listByCondition(null));
		return mv;
	}
	
	/**
	 * 修改方法
	 * @param userGroup UserGroup：实体对象
	 * @param response HttpServletResponse
	 * @return: ajax输入json字符串
	 */	
	@RequestMapping("/updateUserGroup")
	public void update(UserGroup userGroup,HttpServletRequest request,HttpServletResponse response){
		userGroup.setGroupUpdater(Utils.getLoginUserInfoId(request));
		userGroup.setGroupUpdateTime(DateUtil.now());
		AjaxUtils.sendAjaxForObjectStr(
				response,userGroupService.update(userGroup));	
	}
	/**
	 * 为页面获取角色下拉列表
	 * @param userKey 用户ID
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 */
	@RequestMapping("/initGroupTree")
	public void initRoleTree(UserGroup userGroup,HttpServletRequest request, HttpServletResponse response){
		AjaxUtils.sendAjaxForObject(response,userGroupService.initGroupTree(userGroup.getGroupName(), Utils.getLoginUserInfo(request)));
	}
}