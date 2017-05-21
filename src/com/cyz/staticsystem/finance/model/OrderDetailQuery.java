package com.cyz.staticsystem.finance.model;

import com.cyz.staticsystem.common.bean.Model;

public class OrderDetailQuery extends Model {
	private String username;
	private String password;
	/**
	 * 查询日期*/
	private String queryTime;
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
}
