package com.cyz.staticsystem.store.service;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.store.model.StoreSpecialOffer;

/**
 * 描述：商铺特价菜模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-04-10
 */
public interface StoreSpecialOfferService  {

	/**
	 * 新增商铺特价菜方法
	 * @param storeSpecialOffer StoreSpecialOffer:实体类
	 */
	public ResultMessage add(StoreSpecialOffer storeSpecialOffer);
	
	/**
	 * 删除商铺特价菜方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找商铺特价菜实体方法
	 * @param key String：实体主键
	 * @return storeSpecialOffer StoreSpecialOffer 实体对象
	 */
	public StoreSpecialOffer getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找商铺特价菜列表方法
	 * @param storeSpecialOffer StoreSpecialOffer 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<StoreSpecialOffer> listByCondition(StoreSpecialOffer storeSpecialOffer);
	
	/**
	 * 修改商铺特价菜方法
	 * @param storeSpecialOffer StoreSpecialOffer 实体对象
	 */	
	public ResultMessage update(StoreSpecialOffer storeSpecialOffer);
}