package com.cyz.staticsystem.basic.dao;

import java.util.List;

import com.cyz.staticsystem.basic.model.Category;
/**
 * 描述：品类模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface CategoryMapper  {

	/**
	 * 新增品类方法
	 * @param category Category:实体类
	 */
	void add(Category category);
	
	/**
	 * 删除品类方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找品类实体方法
	 * @param key String：实体主键（查询条件）
	 * @return Category: 实体
	 */
	public Category getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找品类列表方法
	 * @param Category category：实体对象（查询条件）
	 * @return List<Category>: 实体对象的list
	 */
	public List<Category>  listByCondition(Category category);
	
	/**
	 * 修改品类方法
	 * @param category Category：实体对象
	 */	
	public void update(Category category);
}