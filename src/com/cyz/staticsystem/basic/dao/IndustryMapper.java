package com.cyz.staticsystem.basic.dao;

import java.util.List;

import com.cyz.staticsystem.basic.model.Industry;
/**
 * 描述：餐饮行业模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface IndustryMapper  {

	/**
	 * 新增餐饮行业方法
	 * @param industry Industry:实体类
	 */
	void add(Industry industry);
	
	/**
	 * 删除餐饮行业方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找餐饮行业实体方法
	 * @param key String：实体主键（查询条件）
	 * @return Industry: 实体
	 */
	public Industry getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找餐饮行业列表方法
	 * @param Industry industry：实体对象（查询条件）
	 * @return List<Industry>: 实体对象的list
	 */
	public List<Industry>  listByCondition(Industry industry);
	
	/**
	 * 修改餐饮行业方法
	 * @param industry Industry：实体对象
	 */	
	public void update(Industry industry);
}