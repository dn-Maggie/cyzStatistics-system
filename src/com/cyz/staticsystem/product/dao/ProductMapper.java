package com.cyz.staticsystem.product.dao;

import java.util.List;

import com.cyz.staticsystem.product.model.Product;
/**
 * 描述：产品模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface ProductMapper  {

	/**
	 * 新增产品方法
	 * @param product Product:实体类
	 */
	void add(Product product);
	
	/**
	 * 删除产品方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找产品实体方法
	 * @param key String：实体主键（查询条件）
	 * @return Product: 实体
	 */
	public Product getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找产品列表方法
	 * @param Product product：实体对象（查询条件）
	 * @return List<Product>: 实体对象的list
	 */
	public List<Product>  listByCondition(Product product);
	
	/**
	 * 修改产品方法
	 * @param product Product：实体对象
	 */	
	public void update(Product product);
}