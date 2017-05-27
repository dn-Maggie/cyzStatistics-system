package com.cyz.staticsystem.staticAnalysis.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;

public class DemandAnalysis extends Model{
	
	/**
     * 主键
     **/
	private String id;
   	/**
     * 查询时间（日期时间段）
     **/
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private Date searchTime;
	 /**
     * 商户所在区域(商圈)
     **/
	private String storeArea;
	private String storeId;
	private String storeELMId;
	private String storeMTId;
	private String storeBDId;
	public String getStoreELMId() {
		return storeELMId;
	}
	public void setStoreELMId(String storeELMId) {
		this.storeELMId = storeELMId;
	}
	public String getStoreMTId() {
		return storeMTId;
	}
	public void setStoreMTId(String storeMTId) {
		this.storeMTId = storeMTId;
	}
	public String getStoreBDId() {
		return storeBDId;
	}
	public void setStoreBDId(String storeBDId) {
		this.storeBDId = storeBDId;
	}
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
	/*平台类型*/
	private String platformType;
	
	public String getPlatformType() {
		return platformType;
	}
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getSearchTime() {
		return searchTime;
	}
	public void setSearchTime(Date searchTime) {
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
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
}
