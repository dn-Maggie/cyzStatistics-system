package com.cyz.staticsystem.basic.service;

import java.util.List;

import com.cyz.staticsystem.basic.model.Brand;
import com.cyz.staticsystem.common.bean.ResultMessage;

/**
 * 描述：餐饮品牌模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface BrandService  {

	/**
	 * 新增餐饮品牌方法
	 * @param brand Brand:实体类
	 */
	public ResultMessage add(Brand brand);
	
	/**
	 * 删除餐饮品牌方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找餐饮品牌实体方法
	 * @param key String：实体主键
	 * @return brand Brand 实体对象
	 */
	public Brand getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找餐饮品牌列表方法
	 * @param brand Brand 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<Brand> listByCondition(Brand brand);
	
	/**
	 * 修改餐饮品牌方法
	 * @param brand Brand 实体对象
	 */	
	public ResultMessage update(Brand brand);
}