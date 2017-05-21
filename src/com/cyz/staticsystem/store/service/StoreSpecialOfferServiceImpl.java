package com.cyz.staticsystem.store.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.store.dao.StoreSpecialOfferMapper;
import com.cyz.staticsystem.store.model.StoreSpecialOffer;
import com.cyz.staticsystem.store.service.StoreSpecialOfferService;
 
/**
 * 描述：商铺特价菜模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-04-10
 */
@Service("storeSpecialOfferService")
public class StoreSpecialOfferServiceImpl implements StoreSpecialOfferService{
        @Resource
	private StoreSpecialOfferMapper storeSpecialOfferMapper;
	
 
	/**
	 * 新增商铺特价菜方法
	 * @param storeSpecialOffer:实体类
	 */	
	public ResultMessage add(StoreSpecialOffer storeSpecialOffer){
		storeSpecialOfferMapper.add(storeSpecialOffer);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找商铺特价菜实体方法
	 * @param key String 实体主键
	 * @return StoreSpecialOffer 实体对象
	 */
	public StoreSpecialOffer getByPrimaryKey(String key){
		return storeSpecialOfferMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除商铺特价菜方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		storeSpecialOfferMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找商铺特价菜列表方法
	 * @param storeSpecialOffer StoreSpecialOffer 实体对象（查询条件）
	 * @return List<StoreSpecialOffer> 实体对象的list
	 */
	public List<StoreSpecialOffer> listByCondition(StoreSpecialOffer storeSpecialOffer){
		return storeSpecialOfferMapper.listByCondition(storeSpecialOffer);
	}
	
	/**
	 * 修改商铺特价菜方法
	 * @param storeSpecialOffer StoreSpecialOffer 实体对象
	 */	
	public ResultMessage update(StoreSpecialOffer storeSpecialOffer){
		storeSpecialOfferMapper.update(storeSpecialOffer);
		return AjaxUtils.getSuccessMessage();
	}
}