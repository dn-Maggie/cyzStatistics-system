package com.cyz.staticsystem.basic.service;

import java.util.List;

import com.cyz.staticsystem.basic.model.Industry;
import com.cyz.staticsystem.common.bean.ResultMessage;

/**
 * 描述：餐饮行业模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface IndustryService  {

	/**
	 * 新增餐饮行业方法
	 * @param industry Industry:实体类
	 */
	public ResultMessage add(Industry industry);
	
	/**
	 * 删除餐饮行业方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找餐饮行业实体方法
	 * @param key String：实体主键
	 * @return industry Industry 实体对象
	 */
	public Industry getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找餐饮行业列表方法
	 * @param industry Industry 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<Industry> listByCondition(Industry industry);
	
	/**
	 * 修改餐饮行业方法
	 * @param industry Industry 实体对象
	 */	
	public ResultMessage update(Industry industry);
}