package com.cyz.staticsystem.staticAnalysis.model;

import com.cyz.staticsystem.common.bean.Model;

public class DemandAnalysis extends Model{
	
	/**
     * 主键
     **/
	private String id;
   	/**
     * 查询时间（日期时间段）
     **/
	private String searchTime;
	 /**
     * 商户所在区域(商圈)
     **/
	private String storeArea;
	/*客户名称*/
	private String customName;
	/*客户常用订餐地址*/
	private String customOrdAddr;
	/*客户手机号*/
	private String customTel;
	/*客户浏览最多次的商户名称*/
	private String mostBrowseMerchantName;
	/*客户浏览最多次的商户类型*/
	private String mostBrowseMerchantType;;
	/*客户消费的平均单价*/
	private String averageCost;
	/*客户最喜欢的菜品名称*/
	private String favoriteDishesName;
	/*客户最喜欢的菜品的平均价格*/
	private String favoriteDishesCost;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	public String getStoreArea() {
		return storeArea;
	}
	public void setStoreArea(String storeArea) {
		this.storeArea = storeArea;
	}
	public String getCustomName() {
		return customName;
	}
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	public String getCustomOrdAddr() {
		return customOrdAddr;
	}
	public void setCustomOrdAddr(String customOrdAddr) {
		this.customOrdAddr = customOrdAddr;
	}
	public String getCustomTel() {
		return customTel;
	}
	public void setCustomTel(String customTel) {
		this.customTel = customTel;
	}
	public String getMostBrowseMerchantName() {
		return mostBrowseMerchantName;
	}
	public void setMostBrowseMerchantName(String mostBrowseMerchantName) {
		this.mostBrowseMerchantName = mostBrowseMerchantName;
	}
	public String getMostBrowseMerchantType() {
		return mostBrowseMerchantType;
	}
	public void setMostBrowseMerchantType(String mostBrowseMerchantType) {
		this.mostBrowseMerchantType = mostBrowseMerchantType;
	}
	public String getAverageCost() {
		return averageCost;
	}
	public void setAverageCost(String averageCost) {
		this.averageCost = averageCost;
	}
	public String getFavoriteDishesName() {
		return favoriteDishesName;
	}
	public void setFavoriteDishesName(String favoriteDishesName) {
		this.favoriteDishesName = favoriteDishesName;
	}
	public String getFavoriteDishesCost() {
		return favoriteDishesCost;
	}
	public void setFavoriteDishesCost(String favoriteDishesCost) {
		this.favoriteDishesCost = favoriteDishesCost;
	}
}
