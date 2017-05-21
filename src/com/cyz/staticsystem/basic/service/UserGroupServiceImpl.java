package com.cyz.staticsystem.basic.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.basic.dao.UserGroupMapper;
import com.cyz.staticsystem.basic.model.UserGroup;
import com.cyz.staticsystem.basic.model.UserInfo;
import com.cyz.staticsystem.basic.service.UserGroupService;
import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.system.model.Role;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
 
/**
 * 描述：用户组别模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-03-01
 */
@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService{
        @Resource
	private UserGroupMapper userGroupMapper;
	
 
	/**
	 * 新增用户组别方法
	 * @param userGroup:实体类
	 */	
	public ResultMessage add(UserGroup userGroup){
		userGroupMapper.add(userGroup);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找用户组别实体方法
	 * @param key String 实体主键
	 * @return UserGroup 实体对象
	 */
	public UserGroup getByPrimaryKey(String key){
		return userGroupMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除用户组别方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		userGroupMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找用户组别列表方法
	 * @param userGroup UserGroup 实体对象（查询条件）
	 * @return List<UserGroup> 实体对象的list
	 */
	public List<UserGroup> listByCondition(UserGroup userGroup){
		return userGroupMapper.listByCondition(userGroup);
	}
	
	/**
	 * 修改用户组别方法
	 * @param userGroup UserGroup 实体对象
	 */	
	public ResultMessage update(UserGroup userGroup){
		userGroupMapper.update(userGroup);
		return AjaxUtils.getSuccessMessage();
	}
	/*
	 * (非 Javadoc) <p>Title: initOrgTree</p> <p>Description: </p>
	 * 
	 * @param orgName
	 * 
	 * @return
	 * 
	 * @see com.dongnao.workbench.basic.service.OrgService#initOrgTree(java.lang.String)
	 */
		public String initGroupTree(String groupName, UserInfo userInfo) {
		JSONArray roleTree = new JSONArray();
		UserGroup group = new UserGroup();
		group.setGroupName(groupName);
		group.setIsActive(Constant.ISDELETE_FALSE);
		group.setGroupStates("1");
		
		if(!Utils.isSuperAdmin(userInfo)){
			group.setGroupPId(userInfo.getUserGroup());
			group.setId(userInfo.getUserGroup());
		}
		List<UserGroup> groups = userGroupMapper.listByCondition(group);
		JSONObject jsonObj;
		for (UserGroup o : groups) {
			jsonObj = new JSONObject();
			jsonObj.put("isParent", "true");
			jsonObj.put("id", o.getId());
			jsonObj.put("pId", o.getGroupPId());
			jsonObj.put("name", o.getGroupName());
			jsonObj.put("open", "true");
			roleTree.add(jsonObj);
		}
		return roleTree.toString();
	}
}