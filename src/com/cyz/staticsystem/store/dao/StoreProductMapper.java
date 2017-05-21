package com.cyz.staticsystem.store.dao;

import java.util.List;

import com.cyz.staticsystem.store.model.StoreProduct;
/**
 * 描述：店铺产品模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-20
 */
public interface StoreProductMapper  {

	/**
	 * 新增店铺产品方法
	 * @param storeProduct StoreProduct:实体类
	 */
	void add(StoreProduct storeProduct);
	
	/**
	 * 删除店铺产品方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找店铺产品实体方法
	 * @param key String：实体主键（查询条件）
	 * @return StoreProduct: 实体
	 */
	public StoreProduct getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找店铺产品列表方法
	 * @param StoreProduct storeProduct：实体对象（查询条件）
	 * @return List<StoreProduct>: 实体对象的list
	 */
	public List<StoreProduct>  listByCondition(StoreProduct storeProduct);
	
	/**
	 * 修改店铺产品方法
	 * @param storeProduct StoreProduct：实体对象
	 */	
	public void update(StoreProduct storeProduct);
}