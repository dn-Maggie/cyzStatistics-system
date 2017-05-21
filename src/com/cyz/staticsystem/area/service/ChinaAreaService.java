package com.cyz.staticsystem.area.service;

import java.util.List;

import com.cyz.staticsystem.area.model.ChinaArea;

/**
 * 描述：省市区地域模块service接口，提供controller操作所需方法
 *
 * @author fan.yang
 * @version 1.0 2017-01-01
 */
public interface ChinaAreaService  {

	/**
	 * 根据父区域返回下面的所有子区域集合对象
	 * @param pid String：父级区域的id
	 * @return List<ChinaArea>根据pid查询出来的结果，最终以json格式相应客户端
	 */	
	public List<ChinaArea> loadAreaByParent(Integer pid);
	
	public List<ChinaArea> listByCondition(ChinaArea ChinaArea);
}