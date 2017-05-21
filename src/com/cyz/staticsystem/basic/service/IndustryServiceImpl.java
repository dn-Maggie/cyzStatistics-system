package com.cyz.staticsystem.basic.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.basic.dao.IndustryMapper;
import com.cyz.staticsystem.basic.model.Industry;
import com.cyz.staticsystem.basic.service.IndustryService;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
 
/**
 * 描述：餐饮行业模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
@Service("industryService")
public class IndustryServiceImpl implements IndustryService{
        @Resource
	private IndustryMapper industryMapper;
	
 
	/**
	 * 新增餐饮行业方法
	 * @param industry:实体类
	 */	
	public ResultMessage add(Industry industry){
		industryMapper.add(industry);
		return AjaxUtils.getSuccessMessage();
	}
	
	/**
	 * 根据主键查找餐饮行业实体方法
	 * @param key String 实体主键
	 * @return Industry 实体对象
	 */
	public Industry getByPrimaryKey(String key){
		return industryMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除餐饮行业方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key){
		industryMapper.deleteByKey(key);
	}
	
	/**
	 * 根据条件查找餐饮行业列表方法
	 * @param industry Industry 实体对象（查询条件）
	 * @return List<Industry> 实体对象的list
	 */
	public List<Industry> listByCondition(Industry industry){
		return industryMapper.listByCondition(industry);
	}
	
	/**
	 * 修改餐饮行业方法
	 * @param industry Industry 实体对象
	 */	
	public ResultMessage update(Industry industry){
		industryMapper.update(industry);
		return AjaxUtils.getSuccessMessage();
	}
}