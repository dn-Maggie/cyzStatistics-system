package com.cyz.staticsystem.product.service;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.product.model.ProductClass;

/**
 * 描述：产品分类模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface ProductClassService  {

	/**
	 * 新增产品分类方法
	 * @param productClass ProductClass:实体类
	 */
	public ResultMessage add(ProductClass productClass);
	
	/**
	 * 删除产品分类方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找产品分类实体方法
	 * @param key String：实体主键
	 * @return productClass ProductClass 实体对象
	 */
	public ProductClass getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找产品分类列表方法
	 * @param productClass ProductClass 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<ProductClass> listByCondition(ProductClass productClass);
	
	/**
	 * 修改产品分类方法
	 * @param productClass ProductClass 实体对象
	 */	
	public ResultMessage update(ProductClass productClass);
	/**
	 * 初始化树
	 * @param productClassName 类型名
	 * @return String 
	 */
	String initDictTypeTree(String productClassName);
}