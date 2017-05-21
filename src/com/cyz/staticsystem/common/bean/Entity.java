package com.cyz.staticsystem.common.bean;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cyz.staticsystem.common.util.ReflectUtil;

public abstract class Entity implements IEntity {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String queryFilters = null;
	static Class a;

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public String getQueryFilters() {
		return this.queryFilters;
	}

	public void setQueryFilters(String queryFilters) {
		this.queryFilters = queryFilters;
	}

	

}