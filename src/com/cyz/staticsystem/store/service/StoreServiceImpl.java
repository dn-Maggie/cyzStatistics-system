package com.cyz.staticsystem.store.service;
import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.store.dao.StoreMapper;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.model.StoreByPlatform;
import com.cyz.staticsystem.store.service.StoreService;
 
/**
 * 描述：店铺模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("storeService")
public class StoreServiceImpl implements StoreService{
    @Resource
	private StoreMapper storeMapper;
	
 
	/**
	 * 新增店铺方法
	 * @param store:实体类
	 */	
	public int add(Store store){
		return storeMapper.add(store);
	}
	
	/**
	 * 根据主键查找店铺实体方法
	 * @param key String 实体主键
	 * @return Store 实体对象
	 */
	public Store getByPrimaryKey(String key){
		return storeMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除店铺方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		storeMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找店铺列表方法
	 * @param store Store 实体对象（查询条件）
	 * @return List<Store> 实体对象的list
	 */
	public List<Store> listByCondition(Store store){
		return storeMapper.listByCondition(store);
	}
	
	/**
	 * 修改店铺方法
	 * @param store Store 实体对象
	 */	
	public ResultMessage update(Store store){
		storeMapper.update(store);
		return AjaxUtils.getSuccessMessage();
	}

	@Override
	public ResultMessage updateImg(Store store) {
		storeMapper.updateImg(store);
		return AjaxUtils.getSuccessMessage();
	}
	/**
	 * 批量新增店铺
	 */
	@Override
	public int addStores(ArrayList<Store> storeList) {
		return storeMapper.addStores(storeList);
	}

	@Override
	public List<StoreByPlatform> listStoreByPlatform(String platformType,Store store) {
		switch (platformType) {
		case "elm":
			return storeMapper.listStoreByElm(store);
		case "mt":
			return storeMapper.listStoreByMt(store);
		case "bdwm":
			return storeMapper.listStoreByBdwm(store);
		default:
			return null;
		}
	}

	/**
	 * 统计商家数量*/ 
	public List<Store> staticStoreNum(Store store) {
		return storeMapper.staticStoreNum(store);
	}

	/**
	 * 获取所有商圈*/ 
	public List<Store> getBussinessArea() {
		return storeMapper.getBussinessArea();
	}

	/**
	 * 获取所有订单店铺*/ 
	public List<Store> getOrderStore(Store store) {
		return storeMapper.getOrderStore(store);
	}
}