package com.cyz.staticsystem.basic.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.basic.dao.BrandMapper;
import com.cyz.staticsystem.basic.model.Brand;
import com.cyz.staticsystem.basic.service.BrandService;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
 
/**
 * 描述：餐饮品牌模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("brandService")
public class BrandServiceImpl implements BrandService{
        @Resource
	private BrandMapper brandMapper;
	
 
	/**
	 * 新增餐饮品牌方法
	 * @param brand:实体类
	 */	
	public ResultMessage add(Brand brand){
		brandMapper.add(brand);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找餐饮品牌实体方法
	 * @param key String 实体主键
	 * @return Brand 实体对象
	 */
	public Brand getByPrimaryKey(String key){
		return brandMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除餐饮品牌方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		brandMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找餐饮品牌列表方法
	 * @param brand Brand 实体对象（查询条件）
	 * @return List<Brand> 实体对象的list
	 */
	public List<Brand> listByCondition(Brand brand){
		return brandMapper.listByCondition(brand);
	}
	
	/**
	 * 修改餐饮品牌方法
	 * @param brand Brand 实体对象
	 */	
	public ResultMessage update(Brand brand){
		brandMapper.update(brand);
		return AjaxUtils.getSuccessMessage();
	}
}