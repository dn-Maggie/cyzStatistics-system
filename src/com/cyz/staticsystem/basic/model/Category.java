package com.cyz.staticsystem.basic.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：品类模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class Category extends Model{
	
	
		            /**
	                 * 品类ID(主键)
	                 **/
				   			private String categoryId;
		   		
		            /**
	                 * 品类名称
	                 **/
				   			private String categoryName;
		   		
	
				
		  			/**
			 * 获取 品类ID(主键)
			 * @return String this.categoryId
			 */
			public String getCategoryId(){
				return this.categoryId;
			}
			
			/**
			 * 设置 品类ID(主键)
			 * @param String categoryId 
			 */
			public void setCategoryId(String categoryId){
				this.categoryId = categoryId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 品类名称
			 * @return String this.categoryName
			 */
			public String getCategoryName(){
				return this.categoryName;
			}
			
			/**
			 * 设置 品类名称
			 * @param String categoryName 
			 */
			public void setCategoryName(String categoryName){
				this.categoryName = categoryName;
			}
		   		
		
		
			
			}