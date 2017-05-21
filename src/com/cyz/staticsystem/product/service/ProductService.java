package com.cyz.staticsystem.product.service;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.product.model.Product;

/**
 * 描述：产品模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface ProductService  {

	/**
	 * 新增产品方法
	 * @param product Product:实体类
	 */
	public ResultMessage add(Product product);
	
	/**
	 * 删除产品方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找产品实体方法
	 * @param key String：实体主键
	 * @return product Product 实体对象
	 */
	public Product getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找产品列表方法
	 * @param product Product 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<Product> listByCondition(Product product);
	
	/**
	 * 修改产品方法
	 * @param product Product 实体对象
	 */	
	public ResultMessage update(Product product);
}