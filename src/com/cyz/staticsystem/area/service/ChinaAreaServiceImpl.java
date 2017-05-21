package com.cyz.staticsystem.area.service;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyz.staticsystem.area.dao.ChinaAreaMapper;
import com.cyz.staticsystem.area.model.ChinaArea;
 
/**
 * 描述：省市区地域模块service接口实现类，实现service接口方法
 *
 * @author fan.yang
 * @version 1.0 2017-01-01
 */
@Service("chinaAreaService")
public class ChinaAreaServiceImpl implements ChinaAreaService{
        @Resource
        private ChinaAreaMapper chinaAreaMapper;

		@Override
		public List<ChinaArea> loadAreaByParent(Integer pid) {
			return chinaAreaMapper.selectByPid(pid);
		}

		@Override
		public List<ChinaArea> listByCondition(ChinaArea ChinaArea) {
			return chinaAreaMapper.listByCondition(ChinaArea);
		}
	
        
}