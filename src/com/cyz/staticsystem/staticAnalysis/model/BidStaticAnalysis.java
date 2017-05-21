package com.cyz.staticsystem.staticAnalysis.model;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：调用流程模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class BidStaticAnalysis extends Model{
	 /**
     * 主键
     **/
   			private String id;
	 /**
     * 商户名称
     **/
   			private String storeName;
   	
	 /**
     * 商户所在区域(商圈)
     **/
   			private String storeArea;
	 /**
     * 竞价时段（小时时间段）
     **/
   			private String bidTime;
   	/**
     * 查询时间（日期时间段）
     **/
   			private String searchTime;
	 /**
     * 竞价周期
     **/
   			private String bidCycle;	 
	/**
     * 一周内竞价总金额
     **/
   			private String bidTotalAmountInWeek;
	 /**
     * 平均单次点击费用
     **/
   			private String averageClickCost;	 
	/**
     * 竞价期间活动力度
     **/
   			private String bidActivityIntensity;
	 /**
     * 竞价期间同比周期曝光量增幅
     **/
   			private String exposureIncrementPercent;	 
	/**
     * 竞价期间同比周期进店率增幅
     **/
   			private String enterRateIncrementPercent;
	/**
     * 竞价期间同比同期转化率增幅
     **/
   			private String transformIncrementPercent;
	 /**
     * 竞价期间同期交易额增幅
     **/
   			private String tradeAmountIncrementPercent;	
	/**
     * 竞价前店铺排名
     **/
   			private String rankBeforeBid;
	 /**
     * 竞价后店铺排名
     **/
   			private String rankAfterBid;   			 
	/**
     * 竞价排名贡献值
     **/
   			private String contributionInBid;
   			
			public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
			public String getStoreName() {
				return storeName;
			}
			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}
			public String getStoreArea() {
				return storeArea;
			}
			public void setStoreArea(String storeArea) {
				this.storeArea = storeArea;
			}
			public String getBidTime() {
				return bidTime;
			}
			public void setBidTime(String bidTime) {
				this.bidTime = bidTime;
			}
			public String getBidCycle() {
				return bidCycle;
			}
			public void setBidCycle(String bidCycle) {
				this.bidCycle = bidCycle;
			}
			public String getBidTotalAmountInWeek() {
				return bidTotalAmountInWeek;
			}
			public void setBidTotalAmountInWeek(String bidTotalAmountInWeek) {
				this.bidTotalAmountInWeek = bidTotalAmountInWeek;
			}
			public String getAverageClickCost() {
				return averageClickCost;
			}
			public void setAverageClickCost(String averageClickCost) {
				this.averageClickCost = averageClickCost;
			}
			public String getBidActivityIntensity() {
				return bidActivityIntensity;
			}
			public void setBidActivityIntensity(String bidActivityIntensity) {
				this.bidActivityIntensity = bidActivityIntensity;
			}
			public String getExposureIncrementPercent() {
				return exposureIncrementPercent;
			}
			public void setExposureIncrementPercent(String exposureIncrementPercent) {
				this.exposureIncrementPercent = exposureIncrementPercent;
			}
			public String getEnterRateIncrementPercent() {
				return enterRateIncrementPercent;
			}
			public void setEnterRateIncrementPercent(String enterRateIncrementPercent) {
				this.enterRateIncrementPercent = enterRateIncrementPercent;
			}
			public String getTradeAmountIncrementPercent() {
				return tradeAmountIncrementPercent;
			}
			public void setTradeAmountIncrementPercent(String tradeAmountIncrementPercent) {
				this.tradeAmountIncrementPercent = tradeAmountIncrementPercent;
			}
			public String getRankBeforeBid() {
				return rankBeforeBid;
			}
			public void setRankBeforeBid(String rankBeforeBid) {
				this.rankBeforeBid = rankBeforeBid;
			}
			public String getRankAfterBid() {
				return rankAfterBid;
			}
			public void setRankAfterBid(String rankAfterBid) {
				this.rankAfterBid = rankAfterBid;
			}
			public String getContributionInBid() {
				return contributionInBid;
			}
			public void setContributionInBid(String contributionInBid) {
				this.contributionInBid = contributionInBid;
			}
			public String getSearchTime() {
				return searchTime;
			}
			public void setSearchTime(String searchTime) {
				this.searchTime = searchTime;
			}
			public String getTransformIncrementPercent() {
				return transformIncrementPercent;
			}
			public void setTransformIncrementPercent(String transformIncrementPercent) {
				this.transformIncrementPercent = transformIncrementPercent;
			}
}