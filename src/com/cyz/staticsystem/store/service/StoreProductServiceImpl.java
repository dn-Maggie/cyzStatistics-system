package com.cyz.staticsystem.store.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.store.dao.StoreProductMapper;
import com.cyz.staticsystem.store.model.StoreProduct;
import com.cyz.staticsystem.store.service.StoreProductService;
 
/**
 * 描述：店铺产品模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-20
 */
@Service("storeProductService")
public class StoreProductServiceImpl implements StoreProductService{
        @Resource
	private StoreProductMapper storeProductMapper;
	
 
	/**
	 * 新增店铺产品方法
	 * @param storeProduct:实体类
	 */	
	public ResultMessage add(StoreProduct storeProduct){
		storeProductMapper.add(storeProduct);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找店铺产品实体方法
	 * @param key String 实体主键
	 * @return StoreProduct 实体对象
	 */
	public StoreProduct getByPrimaryKey(String key){
		return storeProductMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除店铺产品方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		storeProductMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找店铺产品列表方法
	 * @param storeProduct StoreProduct 实体对象（查询条件）
	 * @return List<StoreProduct> 实体对象的list
	 */
	public List<StoreProduct> listByCondition(StoreProduct storeProduct){
		return storeProductMapper.listByCondition(storeProduct);
	}
	
	/**
	 * 修改店铺产品方法
	 * @param storeProduct StoreProduct 实体对象
	 */	
	public ResultMessage update(StoreProduct storeProduct){
		storeProductMapper.update(storeProduct);
		return AjaxUtils.getSuccessMessage();
	}
}