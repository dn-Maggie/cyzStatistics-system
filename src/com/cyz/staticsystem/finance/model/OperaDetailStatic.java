package com.cyz.staticsystem.finance.model;

import java.io.Serializable;

public class OperaDetailStatic implements Serializable {
	private static final long serialVersionUID = 2060919719016478351L;

	/**
	 * 订单统计查询出参 -营业总单数"*/
	private Integer successOrderNum;
	private Integer failOrderNum;
	private double successOrderAmount;
	private double failOrderAmount;
	
	
	/** 分平台营业单数"*/
	private Integer elmsuccessOrderNum;
	private Integer mtsuccessOrderNum;
	private Integer bdwmsuccessOrderNum;
	
	private Integer elmfailOrderNum;
	private Integer mtfailOrderNum;
	private Integer bdwmfailOrderNum;
	
	/** 分平台营业额"*/
	private double elmsuccessOrderAmount;
	private double mtsuccessOrderAmount;
	private double bdwmsuccessOrderAmount;
	
	private double elmfailOrderAmount;
	private double mtfailOrderAmount;
	private double bdwmfailOrderAmount;
	
	private String brandName;
	private String storeName;
	private String businessArea;
	
	
	
	
	
	
	
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
	public Integer getElmsuccessOrderNum() {
		return elmsuccessOrderNum;
	}
	public void setElmsuccessOrderNum(Integer elmsuccessOrderNum) {
		this.elmsuccessOrderNum = elmsuccessOrderNum;
	}
	public Integer getMtsuccessOrderNum() {
		return mtsuccessOrderNum;
	}
	public void setMtsuccessOrderNum(Integer mtsuccessOrderNum) {
		this.mtsuccessOrderNum = mtsuccessOrderNum;
	}
	public Integer getBdwmsuccessOrderNum() {
		return bdwmsuccessOrderNum;
	}
	public void setBdwmsuccessOrderNum(Integer bdwmsuccessOrderNum) {
		this.bdwmsuccessOrderNum = bdwmsuccessOrderNum;
	}
	public Integer getElmfailOrderNum() {
		return elmfailOrderNum;
	}
	public void setElmfailOrderNum(Integer elmfailOrderNum) {
		this.elmfailOrderNum = elmfailOrderNum;
	}
	public Integer getMtfailOrderNum() {
		return mtfailOrderNum;
	}
	public void setMtfailOrderNum(Integer mtfailOrderNum) {
		this.mtfailOrderNum = mtfailOrderNum;
	}
	public Integer getBdwmfailOrderNum() {
		return bdwmfailOrderNum;
	}
	public void setBdwmfailOrderNum(Integer bdwmfailOrderNum) {
		this.bdwmfailOrderNum = bdwmfailOrderNum;
	}
	public double getElmsuccessOrderAmount() {
		return elmsuccessOrderAmount;
	}
	public void setElmsuccessOrderAmount(double elmsuccessOrderAmount) {
		this.elmsuccessOrderAmount = elmsuccessOrderAmount;
	}
	public double getMtsuccessOrderAmount() {
		return mtsuccessOrderAmount;
	}
	public void setMtsuccessOrderAmount(double mtsuccessOrderAmount) {
		this.mtsuccessOrderAmount = mtsuccessOrderAmount;
	}
	public double getBdwmsuccessOrderAmount() {
		return bdwmsuccessOrderAmount;
	}
	public void setBdwmsuccessOrderAmount(double bdwmsuccessOrderAmount) {
		this.bdwmsuccessOrderAmount = bdwmsuccessOrderAmount;
	}
	public double getElmfailOrderAmount() {
		return elmfailOrderAmount;
	}
	public void setElmfailOrderAmount(double elmfailOrderAmount) {
		this.elmfailOrderAmount = elmfailOrderAmount;
	}
	public double getMtfailOrderAmount() {
		return mtfailOrderAmount;
	}
	public void setMtfailOrderAmount(double mtfailOrderAmount) {
		this.mtfailOrderAmount = mtfailOrderAmount;
	}
	public double getBdwmfailOrderAmount() {
		return bdwmfailOrderAmount;
	}
	public void setBdwmfailOrderAmount(double bdwmfailOrderAmount) {
		this.bdwmfailOrderAmount = bdwmfailOrderAmount;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
