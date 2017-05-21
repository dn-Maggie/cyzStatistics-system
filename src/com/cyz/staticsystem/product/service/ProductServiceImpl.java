package com.cyz.staticsystem.product.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.product.dao.ProductMapper;
import com.cyz.staticsystem.product.model.Product;
 
/**
 * 描述：产品模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Resource
	private ProductMapper productMapper;
	
 
	/**
	 * 新增产品方法
	 * @param product:实体类
	 */	
	public ResultMessage add(Product product){
		productMapper.add(product);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找产品实体方法
	 * @param key String 实体主键
	 * @return Product 实体对象
	 */
	public Product getByPrimaryKey(String key){
		return productMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除产品方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		productMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找产品列表方法
	 * @param product Product 实体对象（查询条件）
	 * @return List<Product> 实体对象的list
	 */
	public List<Product> listByCondition(Product product){
		return productMapper.listByCondition(product);
	}
	
	/**
	 * 修改产品方法
	 * @param product Product 实体对象
	 */	
	public ResultMessage update(Product product){
		productMapper.update(product);
		return AjaxUtils.getSuccessMessage();
	}
}