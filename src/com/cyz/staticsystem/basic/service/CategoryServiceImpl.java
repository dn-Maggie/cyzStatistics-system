package com.cyz.staticsystem.basic.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.basic.dao.CategoryMapper;
import com.cyz.staticsystem.basic.model.Category;
import com.cyz.staticsystem.basic.service.CategoryService;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
 
/**
 * 描述：品类模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService{
        @Resource
	private CategoryMapper categoryMapper;
	
 
	/**
	 * 新增品类方法
	 * @param category:实体类
	 */	
	public ResultMessage add(Category category){
		categoryMapper.add(category);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找品类实体方法
	 * @param key String 实体主键
	 * @return Category 实体对象
	 */
	public Category getByPrimaryKey(String key){
		return categoryMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除品类方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		categoryMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找品类列表方法
	 * @param category Category 实体对象（查询条件）
	 * @return List<Category> 实体对象的list
	 */
	public List<Category> listByCondition(Category category){
		return categoryMapper.listByCondition(category);
	}
	
	/**
	 * 修改品类方法
	 * @param category Category 实体对象
	 */	
	public ResultMessage update(Category category){
		categoryMapper.update(category);
		return AjaxUtils.getSuccessMessage();
	}
}