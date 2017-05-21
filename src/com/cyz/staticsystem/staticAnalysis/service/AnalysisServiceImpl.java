package com.cyz.staticsystem.staticAnalysis.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cyz.staticsystem.staticAnalysis.model.DemandAnalysis;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.product.dao.ProductMapper;
import com.cyz.staticsystem.staticAnalysis.dao.AnalysisMapper;
import com.cyz.staticsystem.staticAnalysis.model.BidStaticAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.StoreActiveAnalysis;
/**
 * 描述：数据统计分析模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */

@Service("analysisService")
public class AnalysisServiceImpl implements AnalysisService{
	@Resource
	private AnalysisMapper analysisMapper;
	/**
	 * 精准客户需求分析方法
	 * */
	public List<DemandAnalysis> demandAnalysis(DemandAnalysis demandAnalysis){
		return analysisMapper.demandAnalysis(demandAnalysis);
		
	};
	/**
	 * 	竞价分析方法
	 * */
	public List<BidStaticAnalysis> bidStaticAnalysis(BidStaticAnalysis bidStaticAnalysis){
		return analysisMapper.bidStaticAnalysis(bidStaticAnalysis);
		
	};
	/**
	 * 活动数据分析方法
	 * */
	public List<StoreActiveAnalysis> storeActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis){
		return analysisMapper.storeActiveAnalysis(storeActiveAnalysis);
		
	}
	/**
	 * 获取数据总览信息
	 * */
	public List<BidStaticAnalysis> allStatic(Object object) {
		return analysisMapper.allStatic(object);
	};
	/**
	 * 新增竞价分析方法
	 * @param bidAnalysis:实体类
	 */
	@Override
	public int addbidAnalysis(List<BidStaticAnalysis> bidAnalysis) {
		return analysisMapper.addbidAnalysis(bidAnalysis);
	};
	
	/**
	 *插入精准需求分析的方法
	 * @param demanAnalysis:实体类
	 */
	@Override
	public int adddemanAnalysis(List<DemandAnalysis> demanAnalysis) {
		return analysisMapper.adddemanAnalysis(demanAnalysis);
	};
	
	/**
	 *  插入活动数据分析的方法
	 * @param storeActiveAnalysis:实体类
	 */
	@Override
	public int addactiveAnalysis(List<StoreActiveAnalysis> storeActiveAnalysis) {
		return analysisMapper.addactiveAnalysis(storeActiveAnalysis);
	};
}
