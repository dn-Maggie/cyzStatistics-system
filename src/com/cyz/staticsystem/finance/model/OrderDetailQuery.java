package com.cyz.staticsystem.finance.model;

import com.cyz.staticsystem.common.bean.Model;

public class OrderDetailQuery extends Model {
	private String username;
	private String password;
	/**
	 * 查询日期*/
	private String queryTime;
	
	private String beginTime;
	
	private String businessArea;
	
	private String storeId;
	private String storeELMId;
	private String storeMTId;
	private String storeBDId;
	public String getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(String beginTime) {
		this.beginTime = beginTime;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQueryTime() {
		return queryTime;
	}
	public void setQueryTime(String queryTime) {
		this.queryTime = queryTime;
	}
	public String getStoreId() {
		return storeId;
	}
	public String getStoreELMId() {
		return storeELMId;
	}
	public String getStoreMTId() {
		return storeMTId;
	}
	public String getStoreBDId() {
		return storeBDId;
	}
	public void setStoreId(String storeId) {
		this.storeId = storeId;
	}
	public void setStoreELMId(String storeELMId) {
		this.storeELMId = storeELMId;
	}
	public void setStoreMTId(String storeMTId) {
		this.storeMTId = storeMTId;
	}
	public void setStoreBDId(String storeBDId) {
		this.storeBDId = storeBDId;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
}
