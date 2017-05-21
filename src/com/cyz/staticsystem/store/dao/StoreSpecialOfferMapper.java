package com.cyz.staticsystem.store.dao;

import java.util.List;

import com.cyz.staticsystem.store.model.StoreSpecialOffer;
/**
 * 描述：商铺特价菜模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-04-10
 */
public interface StoreSpecialOfferMapper  {

	/**
	 * 新增商铺特价菜方法
	 * @param storeSpecialOffer StoreSpecialOffer:实体类
	 */
	void add(StoreSpecialOffer storeSpecialOffer);
	
	/**
	 * 删除商铺特价菜方法
	 * @param key String:多个由“，”分割开的id字符串
	 */
	void deleteByKey(String key);
	
	/**
	 * 根据主键查找商铺特价菜实体方法
	 * @param key String：实体主键（查询条件）
	 * @return StoreSpecialOffer: 实体
	 */
	public StoreSpecialOffer getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找商铺特价菜列表方法
	 * @param StoreSpecialOffer storeSpecialOffer：实体对象（查询条件）
	 * @return List<StoreSpecialOffer>: 实体对象的list
	 */
	public List<StoreSpecialOffer>  listByCondition(StoreSpecialOffer storeSpecialOffer);
	
	/**
	 * 修改商铺特价菜方法
	 * @param storeSpecialOffer StoreSpecialOffer：实体对象
	 */	
	public void update(StoreSpecialOffer storeSpecialOffer);
}