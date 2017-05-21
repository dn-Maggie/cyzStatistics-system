package com.cyz.staticsystem.product.dao;

import java.util.List;

import com.cyz.staticsystem.product.model.ProductClass;
/**
 * 描述：产品分类模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface ProductClassMapper  {

	/**
	 * 新增产品分类方法
	 * @param productClass ProductClass:实体类
	 */
	void add(ProductClass productClass);
	
	/**
	 * 删除产品分类方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找产品分类实体方法
	 * @param key String：实体主键（查询条件）
	 * @return ProductClass: 实体
	 */
	public ProductClass getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找产品分类列表方法
	 * @param ProductClass productClass：实体对象（查询条件）
	 * @return List<ProductClass>: 实体对象的list
	 */
	public List<ProductClass>  listByCondition(ProductClass productClass);
	
	/**
	 * 修改产品分类方法
	 * @param productClass ProductClass：实体对象
	 */	
	public void update(ProductClass productClass);
}