package com.cyz.staticsystem.common.bean;

import java.io.Serializable;

import com.cyz.staticsystem.common.enums.ResultStatus;


/**
 * 描述：用于业务层返回结果给控制层
 * 
 * @author yao.su
 * @version 1.0 2016-11-06
 */
public class RespMess implements Serializable {
	private static final long serialVersionUID = 2060919719016478351L;
	

	public RespMess() {
		super();
		this.result = null;
		this.operaStatic = null;
		this.accountStatic = null;
		this.storeNumList = null;
		this.storeOrderList = null;
		this.successOrderPrice = 0;
		this.successOrderNum = 0;
		this.elmsuccessOrderNum = 0;
		this.mtsuccessOrderNum = 0;
		this.bdwmsuccessOrderNum = 0;
		this.elmsuccessOrderPrice = 0;
		this.mtsuccessOrderPrice = 0;
		this.bdwmsuccessOrderPrice = 0;
	}

	/**
	 * 配合app输出
	 */
	private String jsessionid;
	/**
	 * 结果状态1是成功，0是失败
	 */
	private String respCode;
	
	

	/**
	 * 结果消息，返回业务执行结果
	 */
	private String respMsg;
	/**
	 * 结果数据
	 */
	private Object result;
	private Object operaStatic;
	private Object accountStatic;
	public Object getAccountStatic() {
		return accountStatic;
	}

	public void setAccountStatic(Object accountStatic) {
		this.accountStatic = accountStatic;
	}

	/**
	 * 今日商家数量
	 * */
	private Object storeNumList;
	/**
	 * 今日商家排名
	 * */
	private Object storeOrderList;
	
	/**
	 * 订单统计查询出参 - 参与者账号ID*/
	private String username;
	/**
	 * 订单统计查询出参 -营业总额"*/
	private double successOrderPrice;
	/**
	 * 订单统计查询出参 -营业总单数"*/
	private Integer successOrderNum;
	
	/** 分平台营业单数"*/
	private Integer elmsuccessOrderNum;
	private Integer mtsuccessOrderNum;
	private Integer bdwmsuccessOrderNum;
	
	/** 分平台营业额"*/
	private double elmsuccessOrderPrice;
	private double mtsuccessOrderPrice;
	private double bdwmsuccessOrderPrice;
	
	public String getJsessionid() {
		return jsessionid;
	}

	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getSuccessOrderPrice() {
		return successOrderPrice;
	}

	public void setSuccessOrderPrice(double successOrderPrice) {
		this.successOrderPrice = successOrderPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getRespMsg() {
		return respMsg;
	}

	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getRespCode() {
		return respCode;
	}

	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}

	public Integer getSuccessOrderNum() {
		return successOrderNum;
	}

	public void setSuccessOrderNum(Integer successOrderNum) {
		this.successOrderNum = successOrderNum;
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

	public double getElmsuccessOrderPrice() {
		return elmsuccessOrderPrice;
	}

	public void setElmsuccessOrderPrice(double elmsuccessOrderPrice) {
		this.elmsuccessOrderPrice = elmsuccessOrderPrice;
	}

	public double getMtsuccessOrderPrice() {
		return mtsuccessOrderPrice;
	}

	public void setMtsuccessOrderPrice(double mtsuccessOrderPrice) {
		this.mtsuccessOrderPrice = mtsuccessOrderPrice;
	}

	public double getBdwmsuccessOrderPrice() {
		return bdwmsuccessOrderPrice;
	}

	public void setBdwmsuccessOrderPrice(double bdwmsuccessOrderPrice) {
		this.bdwmsuccessOrderPrice = bdwmsuccessOrderPrice;
	}

	public Object getStoreNumList() {
		return storeNumList;
	}

	public void setStoreNumList(Object storeNumList) {
		this.storeNumList = storeNumList;
	}

	public Object getStoreOrderList() {
		return storeOrderList;
	}

	public void setStoreOrderList(Object storeOrderList) {
		this.storeOrderList = storeOrderList;
	}

	public Object getOperaStatic() {
		return operaStatic;
	}

	public void setOperaStatic(Object operaStatic) {
		this.operaStatic = operaStatic;
	}

}
