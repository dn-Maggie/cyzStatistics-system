package com.cyz.staticsystem.area.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cyz.staticsystem.area.model.ChinaArea;
import com.cyz.staticsystem.area.service.ChinaAreaService;
import com.cyz.staticsystem.common.util.AjaxUtils;

import net.sf.json.JSONArray;


/**
 * 描述：省市区地域模块controller类，负责页面分发与跳转
 * 
 * @author fan.yang
 * @version 1.0 2017-01-01
 */
 
@Controller
@RequestMapping("chinaArea")
public class ChinaAreaController{
    @Resource
	private ChinaAreaService chinaAreaService;
	 
	/**
	 * 
	 * @param pid String：父级区域的id
	 * @return List<ChinaArea>根据pid查询出来的结果，最终以json格式相应客户端
	 */	
	@RequestMapping("/loadAreaByParent")
	public void loadAreaByParent(Integer pid,HttpServletResponse response){
		if(pid==null){
			pid = 0;
		}
		AjaxUtils.sendAjaxForListStr(response, chinaAreaService.loadAreaByParent(pid));
	}	
}