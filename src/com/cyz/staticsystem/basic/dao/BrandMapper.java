package com.cyz.staticsystem.basic.dao;

import java.util.List;

import com.cyz.staticsystem.basic.model.Brand;
/**
 * 描述：餐饮品牌模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface BrandMapper  {

	/**
	 * 新增餐饮品牌方法
	 * @param brand Brand:实体类
	 */
	void add(Brand brand);
	
	/**
	 * 删除餐饮品牌方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找餐饮品牌实体方法
	 * @param key String：实体主键（查询条件）
	 * @return Brand: 实体
	 */
	public Brand getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找餐饮品牌列表方法
	 * @param Brand brand：实体对象（查询条件）
	 * @return List<Brand>: 实体对象的list
	 */
	public List<Brand>  listByCondition(Brand brand);
	
	/**
	 * 修改餐饮品牌方法
	 * @param brand Brand：实体对象
	 */	
	public void update(Brand brand);
}