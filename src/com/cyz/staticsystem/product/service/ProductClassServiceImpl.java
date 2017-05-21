package com.cyz.staticsystem.product.service;
import javax.annotation.Resource;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.product.dao.ProductClassMapper;
import com.cyz.staticsystem.product.model.ProductClass;
import com.cyz.staticsystem.product.service.ProductClassService;
import com.cyz.staticsystem.system.model.DictType;
 
/**
 * 描述：产品分类模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("productClassService")
public class ProductClassServiceImpl implements ProductClassService{
        @Resource
	private ProductClassMapper productClassMapper;
	
 
	/**
	 * 新增产品分类方法
	 * @param productClass:实体类
	 */	
	public ResultMessage add(ProductClass productClass){
		productClassMapper.add(productClass);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找产品分类实体方法
	 * @param key String 实体主键
	 * @return ProductClass 实体对象
	 */
	public ProductClass getByPrimaryKey(String key){
		return productClassMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除产品分类方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		productClassMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找产品分类列表方法
	 * @param productClass ProductClass 实体对象（查询条件）
	 * @return List<ProductClass> 实体对象的list
	 */
	public List<ProductClass> listByCondition(ProductClass productClass){
		return productClassMapper.listByCondition(productClass);
	}
	
	/**
	 * 修改产品分类方法
	 * @param productClass ProductClass 实体对象
	 */	
	public ResultMessage update(ProductClass productClass){
		productClassMapper.update(productClass);
		return AjaxUtils.getSuccessMessage();
	}
	/**
	 * 初始化树
	 * @param productClassName 类型名
	 * @return String 
	 */
	@Override
	public String initDictTypeTree(String productClassName) {
		JSONArray productClassTree = new JSONArray();
		//根节点数据
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("id", "0");
		jsonObj.put("name", Utils.getI18n("system.product", null));
		jsonObj.put("open", "true");
		jsonObj.put("isParent", "true");
		productClassTree.add(jsonObj);
		
		ProductClass productClass = new ProductClass();
		productClass.setProductClassName(productClassName);;
		productClass.setOrder("asc");
		productClass.setOrderFields("PRODUCT_CLASS_NAME");
		List<ProductClass> productClassList = productClassMapper.listByCondition(productClass);
		for (ProductClass dt : productClassList) {
			jsonObj = new JSONObject();
			jsonObj.put("id", dt.getProductClassId());
			jsonObj.put("pId", 0);
			jsonObj.put("name", dt.getProductClassName());
			productClassTree.add(jsonObj);
		}
		return productClassTree.toString();
	}
}