package com.cyz.staticsystem.store.service;

import java.util.ArrayList;
import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.model.StoreByPlatform;

/**
 * 描述：店铺模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface StoreService  {

	/**
	 * 新增店铺方法
	 * @param store Store:实体类
	 */
	public int add(Store store);
	
	/**
	 * 删除店铺方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找店铺实体方法
	 * @param key String：实体主键
	 * @return store Store 实体对象
	 */
	public Store getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找店铺列表方法
	 * @param store Store 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<Store> listByCondition(Store store);
	
	/**
	 * 修改店铺方法
	 * @param store Store 实体对象
	 */	
	public ResultMessage update(Store store);
	/**
	 * 修改店铺资料图片方法
	 * @param store Store 实体对象
	 */	
	public ResultMessage updateImg(Store store);
	/**
	 * 批量插入店铺方法
	 */
	public int addStores(ArrayList<Store> storeList);

	public List<StoreByPlatform> listStoreByPlatform(String platformType,Store store);
	/**
	 * 统计商家数量*/
	public List<Store> staticStoreNum(Store store);
	/**
	 * 获取所有商圈*/ 
	public List<Store> getBussinessArea();
	/**
	 * 获取所有订单店铺*/ 
	public List<Store> getOrderStore(Store store);
}