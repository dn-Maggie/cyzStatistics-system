package com.cyz.staticsystem.staticAnalysis.service;

import java.util.List;
import com.cyz.staticsystem.staticAnalysis.model.DemandAnalysis;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.staticAnalysis.model.BidStaticAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.StoreActiveAnalysis;
/**
 * 描述：数据统计分析模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */


public interface AnalysisService {
	/**
	 * 精准客户需求分析方法
	 * */
	List<DemandAnalysis> demandAnalysis(DemandAnalysis demandAnalysis);
	/**
	 * 	竞价分析方法
	 * */
	List<BidStaticAnalysis> bidStaticAnalysis(BidStaticAnalysis bidStaticAnalysis);
	/**
	 * 活动数据分析方法
	 * */
	List<StoreActiveAnalysis> storeActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis);
	/**
	 * 获取数据总览信息
	 * */
	List<BidStaticAnalysis> allStatic(Object object);
	/**
	 * 插入竞价分析数据的方法
	 * @param BidStaticAnalysis bidAnalysis:实体类
	 */
	public int  addbidAnalysis(List<BidStaticAnalysis> bidAnalysis);
	
	/**
	 *  插入精准需求分析的方法
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
	public ResultMessage updateStoreActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis);
	public DemandAnalysis demandNumAnalysis(DemandAnalysis demandAnalysis);
}
