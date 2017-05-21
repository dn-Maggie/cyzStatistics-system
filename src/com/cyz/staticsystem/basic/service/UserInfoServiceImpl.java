package com.cyz.staticsystem.basic.service;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.basic.dao.UserInfoMapper;
import com.cyz.staticsystem.basic.model.UserInfo;
import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.enums.UserInfoType;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.MD5Encryption;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.system.dao.PersonroleMapper;
import com.cyz.staticsystem.system.model.Personrole;


/**
 * 描述：用户信息模块service接口实现类，实现service接口方法
 * 
 * @author yao.su
 * @version 1.0 2016-03-13
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
	/**
	 * 用户信息Mapper
	 */
	@Resource
	private UserInfoMapper userInfoMapper;
	/**
	 * 用户角色关联关系Mapper
	 */
	@Resource
	private PersonroleMapper personroleMapper;

	/**
	 * 新增用户和权限信息
	 * 
	 * @param userInfo
	 *            用户信息
	 * @param role
	 *            权限ID
	 * @param request
	 *            HttpServletRequest
	 * @return true成功，false失败
	 */
	public ResultMessage add(UserInfo userInfo, String roleId,
			UserInfo loginUserInfo) {
		UserInfo info  = userInfoMapper.getByUserAccount(userInfo.getUserAccount());
		if (info != null) {
			return AjaxUtils.getFailureMessage("此帐号已经存在,请重新选择");
		} else {
			userInfo.setPassword(MD5Encryption.MD5(getInitialPassword()));
			String userId = loginUserInfo.getId();
			userInfo.setId(Utils.generateUniqueID());
			userInfo.setCreated(DateUtil.now());
			userInfo.setCreatedby(userId);
			userInfo.setUpdated(DateUtil.now());
			userInfo.setUpdatedby(userId);
			userInfo.setIsActive(Constant.ISDELETE_FALSE);
			// 如果有身份证，那么要复制身份证图片信息到指定目录
//			if (!StringUtil.isNullorBlank(userInfo.getIdCardImgPath())) {
//				FileIOUtils.copyFileChannel(Utils.getAppUpLoadFileTmpPath()
//						+ userInfo.getIdCardImgPath(), Utils.getIdCardImgPath()
//						+ userInfo.getIdCardImgPath());
//			}
			userInfoMapper.add(userInfo);
			Personrole personrole = new Personrole();
			personrole.setCreateTime(DateUtil.now());
			personrole.setUserId(userInfo.getId());
			if (StringUtil.isNotBlank(roleId)) {// 如果有角色就使用传入的角色，否则使用默认角色
				personrole.setRoleId(roleId);
			} else {
				personrole.setRoleId(getInitialRoleId());
			}
			personroleMapper.add(personrole);
			return AjaxUtils.getSuccessMessage();
		}
	}

	/**
	 * 新增店铺用户方法
	 */
	public ResultMessage addStoreUserInfo(Store store, UserInfo loginUserInfo) {
		UserInfo info  = userInfoMapper.getByUserAccount(store.getUserAccount());
		UserInfo userInfo = new UserInfo();
		if (info != null) {
			return AjaxUtils.getFailureMessage("此店铺账号已经存在");
		} else {
			userInfo.setPassword(MD5Encryption.MD5(getInitialPassword()));
			String userId = loginUserInfo.getId();
			userInfo.setId(Utils.generateUniqueID());
			userInfo.setCreated(DateUtil.now());
			userInfo.setCreatedby(userId);
			userInfo.setUserType(UserInfoType.STAFF.getValue());
			userInfo.setUserAccount(store.getUserAccount());
			userInfo.setStates("1");
			userInfo.setUpdated(DateUtil.now());
			userInfo.setUpdatedby(userId);
			userInfo.setIsActive(Constant.ISDELETE_FALSE);
			userInfo.setStoreId(store.getStoreId());
			userInfo.setFullName(store.getStoreName());
			userInfo.setMobilePhone(store.getStoreTel());
			userInfo.setMarketingManager(store.getStoreOwnerName());
			userInfo.setMarketingManagerTel(store.getStoreOwnerTel());
			userInfo.setUserGroup("000000000000000000000000000000");
			userInfoMapper.add(userInfo);
			Personrole personrole = new Personrole();
			personrole.setCreateTime(DateUtil.now());
			personrole.setUserId(userInfo.getId());
			//用户角色默认设置为平台店铺
			personrole.setRoleId("dece69a6-9922-45df-af25-0b9762b58306");
			personroleMapper.add(personrole);
			return AjaxUtils.getSuccessMessage(userInfo.getId());
		}
	}
	/**
	 * 根据主键查找实体方法
	 * 
	 * @param key
	 *            String 实体主键
	 * @return UserInfo 实体对象
	 */
	public UserInfo getByPrimaryKey(String key) {
		return userInfoMapper.getByPrimaryKey(key);
	}

	/**
	 * 删除方法
	 * 
	 * @param key
	 *            信息ID，多个以“，”分割
	 * @param request
	 *            HttpServletRequest
	 */
	public String deleteByKey(String key, UserInfo loginUserInfo) {
		String msg = "";
		UserInfo userInfo = getByPrimaryKey(key);
		if (StringUtils.isNotEmpty(key)) {
			boolean b = true;
			if (Utils.isSuperAdmin(userInfo)) {
				msg = "不能删除管理员用户！";
				b = false;
			}
			if (userInfo.getId().equals(loginUserInfo.getId())) {
				msg = "不能删除当前登陆用户！";
				b = false;
			}
			if (b == true) {
				userInfoMapper.logicDeleteByKey(key);// 修改删除状态，同时修改帐号
				msg = "操作成功";
			}
		}
		return msg;
	}

	/**
	 * 根据条件查找列表方法
	 * 
	 * @param userInfo
	 *            UserInfo 实体对象（查询条件）
	 * @return List<UserInfo> 实体对象的list
	 */
	public List<UserInfo> listByCondition(UserInfo userInfo) {

		return userInfoMapper.listByCondition(userInfo);
	}

	/**
	 * 修改方法
	 * 
	 * @param userInfo
	 *            UserInfo 实体对象
	 * @param role
	 *            权限ID
	 */
	// @CacheEvict(value = MemcacheService.BEAN_ID,
	// key="'"+ModuleService.BEAN_ID+".getMenuJsonByPcode.'+#userInfo.userAccount")
	public ResultMessage update(UserInfo userInfo, String roleId,
			UserInfo loginUserInfo) {
		userInfo.setUpdated(DateUtil.now());
		userInfo.setUpdatedby(loginUserInfo.getId());
		/*UserInfo oldUserInfo = userInfoMapper.getByPrimaryKey(userInfo
				.getId());*/
		// 如果有身份证，那么要复制身份证图片信息到指定目录,删除原来的
//		if (!userInfo.getIdCardImgPath().equals(oldUserInfo.getIdCardImgPath())) {
//			// 先删除原来的
//			FileIOUtils.deleteFile(Utils.getIdCardImgPath()
//					+ oldUserInfo.getIdCardImgPath());
//			// 然后再复制新的
//			FileIOUtils.copyFileChannel(Utils.getAppUpLoadFileTmpPath()
//					+ userInfo.getIdCardImgPath(), Utils.getIdCardImgPath()
//					+ userInfo.getIdCardImgPath());
//		}
		//属性覆盖
//		Utils.copyPropertiesIgnoreNull(userInfo, oldUserInfo);
		userInfoMapper.update(userInfo);
		if (StringUtil.isNotBlank(roleId)) {
			Personrole personrole = new Personrole();
			personrole.setUserId(userInfo.getId());
			List<Personrole> personroles = personroleMapper
					.listByCondition(personrole);
			if (personroles != null && personroles.size() > 0) {
				personrole = personroles.get(0);
				if (!StringUtil.isBlank(roleId)) {
					personrole.setRoleId(roleId);
					personroleMapper.update(personrole);
				} else {
					personroleMapper.deleteByKey(userInfo.getId());
				}
			} else {
				personrole.setRoleId(roleId);
				personrole.setCreateTime(DateUtil.now());
				personroleMapper.add(personrole);
			}
		}
		return AjaxUtils.getSuccessMessage();
	}

	/**
	 * 更新最后登录信息
	 * 
	 * @param userInfo
	 *            用户实体
	 */
	public void updateLastLoginInfo(UserInfo userInfo) {
		userInfoMapper.update(userInfo);
	}

	/**
	 * 根据用户名获取用户信息
	 * 
	 * @param userName
	 *            用户登录名
	 * @return 用户信息实体
	 */
	public UserInfo getByUserAccount(String userName) {
		return userInfoMapper.getByUserAccount(userName);
	}

	/**
	 * 更新用户密码
	 * 
	 * @param info
	 *            用户信息实体
	 */
	public void updatePassword(UserInfo info) {
		if (info != null) {
			// 密码加密
			if (!StringUtil.isBlank(info.getPassword())) {
				info.setPassword(MD5Encryption.MD5(info.getPassword()));
			}
			userInfoMapper.updatePassWord(info);
		}
	}

	/**
	 * 根据角色ID获取当前拥有当前角色人员列表
	 * 
	 * @param params
	 *            条件集合
	 * @return 根据条件查询LIST
	 */
	public List<HashMap<String, String>> listUserByRid(
			HashMap<String, Object> params) {
		return userInfoMapper.listUserByRid(params);
	}

	@Override
	public List<UserInfo> getByUserInfo(UserInfo userInfo) {
		if (userInfo == null) {
			return null;
		}
		List<UserInfo> userInfos = userInfoMapper.listByCondition(userInfo);
		return userInfos;
	}

	/**
	 * 获取系统设置里的初始角色ID
	 * 
	 * @return MD5加密后的初始密码
	 */
	public String getInitialRoleId() {
		return Utils.getConfigValue(Constant.INITIAL_ROLEID);
	}

	/**
	 * 获取系统设置里的初始密码
	 * 
	 * @return MD5加密后的初始密码
	 */
	public String getInitialPassword() {
		return Utils.getConfigValue(Constant.INITIAL_PASSWORD);
	}

}