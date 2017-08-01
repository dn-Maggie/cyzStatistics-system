package com.cyz.staticsystem.staticAnalysis.dao;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.staticAnalysis.model.BidStaticAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.DemandAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.StoreActiveAnalysis;

/**
 * 描述：数据分析统计dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public interface AnalysisMapper {
	/**
	 * 精准客户需求分析方法
	 * */
	public List<DemandAnalysis> demandAnalysis(DemandAnalysis demandAnalysis);
	/**
	 * 	竞价分析方法
	 * */
	public List<BidStaticAnalysis> bidStaticAnalysis(BidStaticAnalysis bidStaticAnalysis);
	/**
	 * 活动数据分析方法
	 * */
	public List<StoreActiveAnalysis> storeActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis);
	/**
	 * 获取数据总览信息
	 * */
	public List<BidStaticAnalysis> allStatic(Object object);
	/**
	 * 插入竞价分析数据的方法
	 * @param BidStaticAnalysis bidAnalysis:实体类
	 */
	public int addbidAnalysis(List<BidStaticAnalysis> bidAnalysis);
	/**
	 * 插入精准需求分析的方法
	 * @param DemandAnalysis demanAnalysis:实体类
	 */
	public int adddemanAnalysis(List<DemandAnalysis> demanAnalysis);
	
	/**
	 * 插入活动数据分析的方法
	 * @param StoreActiveAnalysis storeActiveAnalysis:实体类
	 */
	public int addactiveAnalysis(List<StoreActiveAnalysis> storeActiveAnalysis);
	/**
	 * 更新活动数据分析方法
	 * */
	public int updateStoreActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis);
	
	public DemandAnalysis demandNumAnalysis(DemandAnalysis demandAnalysis);
	
	public int insertDataInDataBase(DemandAnalysis demandAnalysis);
}
