package com.cyz.staticsystem.common.bean;

import java.io.Serializable;

import com.cyz.staticsystem.common.enums.ResultStatus;


/**
 * 描述：用于业务层返回结果给控制层
 * 
 * @author yao.su
 * @version 1.0 2016-11-06
 */
public class ResultMessage implements Serializable {
	private static final long serialVersionUID = 2060919719016478351L;
	/**
	 * 配合app输出
	 */
	private String jsessionid;
	/**
	 * 结果状态1是成功，0是失败
	 */
	private Integer status = ResultStatus.SUCCESS.getValue();
	/**
	 * 结果消息，返回业务执行结果
	 */
	private String message="操作成功";
	/**
	 * 结果数据
	 */
	private Object data;
	private Object result;
	private String respCode;
	private String respMsg;

	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getJsessionid() {
		return jsessionid;
	}

	public void setJsessionid(String jsessionid) {
		this.jsessionid = jsessionid;
	}
	public Object getResult() {
		return result;
	}
	public void setResult(Object result) {
		this.result = result;
	}
}
