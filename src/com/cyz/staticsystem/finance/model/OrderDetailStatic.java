package com.cyz.staticsystem.finance.model;

import com.cyz.staticsystem.common.bean.Model;

public class OrderDetailStatic extends Model {
	/**
	 * 店铺ID*/
	private String storeId;
	/**
	 * 店铺名称*/
	private String storeName;
	/**
	 * 平台类型*/
	private String platformType;
	/**
	 * 成功订单数*/
	private Integer successOrderNum;
	/**
	 * 失败订单数*/
	private Integer failOrderNum;
	/**
	 * 查询时间
	private Date orderTime;*/
	/**
	 * 成功订单总额*/
	private double successOrderAmount;
	/**
	 * 失败订单总额*/
	private double failOrderAmount;
	
	
	public String getStoreId() {
		return storeId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getPlatformType() {
		return platformType;
	}
	public void setPlatformType(String platformType) {
		this.platformType = platformType;
	}
	public Integer getSuccessOrderNum() {
		return successOrderNum;
	}
	public void setSuccessOrderNum(Integer successOrderNum) {
		this.successOrderNum = successOrderNum;
	}
	public Integer getFailOrderNum() {
		return failOrderNum;
	}
	public void setFailOrderNum(Integer failOrderNum) {
		this.failOrderNum = failOrderNum;
	}
	public double getSuccessOrderAmount() {
		return successOrderAmount;
	}
	public void setSuccessOrderAmount(double successOrderAmount) {
		this.successOrderAmount = successOrderAmount;
	}
	public double getFailOrderAmount() {
		return failOrderAmount;
	}
	public void setFailOrderAmount(double failOrderAmount) {
		this.failOrderAmount = failOrderAmount;
	}
}
