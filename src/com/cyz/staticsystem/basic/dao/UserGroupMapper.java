package com.cyz.staticsystem.basic.dao;

import java.util.List;

import com.cyz.staticsystem.basic.model.UserGroup;
/**
 * 描述：用户组别模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-03-01
 */
public interface UserGroupMapper  {

	/**
	 * 新增用户组别方法
	 * @param userGroup UserGroup:实体类
	 */
	void add(UserGroup userGroup);
	
	/**
	 * 删除用户组别方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找用户组别实体方法
	 * @param key String：实体主键（查询条件）
	 * @return UserGroup: 实体
	 */
	public UserGroup getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找用户组别列表方法
	 * @param UserGroup userGroup：实体对象（查询条件）
	 * @return List<UserGroup>: 实体对象的list
	 */
	public List<UserGroup>  listByCondition(UserGroup userGroup);
	
	/**
	 * 修改用户组别方法
	 * @param userGroup UserGroup：实体对象
	 */	
	public void update(UserGroup userGroup);
}