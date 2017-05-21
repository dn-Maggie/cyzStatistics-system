package com.cyz.staticsystem.area.dao;

import java.util.List;

import com.cyz.staticsystem.area.model.ChinaArea;
/**
 * 描述：省市区地域模块dao接口，提供数据库操作方法
 *
 * @author fan.yang
 * @version 1.0 2017-01-01
 */
public interface ChinaAreaMapper  {

	/**
	 * 根据pid查找省市区地域列表方法
	 * @param 父地域的id
	 * @return List<ChinaArea>: 实体对象的list
	 */
	public List<ChinaArea>  selectByPid(Integer pid);
	public List<ChinaArea> listByCondition(ChinaArea chinaArea);
}