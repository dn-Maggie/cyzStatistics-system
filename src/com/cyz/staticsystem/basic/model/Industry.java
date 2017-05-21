package com.cyz.staticsystem.basic.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：餐饮行业模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class Industry extends Model{
	
	
		            /**
	                 * 行业ID(主键)
	                 **/
				   			private String industryId;
		   		
		            /**
	                 * 行业名称
	                 **/
				   			private String industryName;
		   		
	
				
		  			/**
			 * 获取 行业ID(主键)
			 * @return String this.industryId
			 */
			public String getIndustryId(){
				return this.industryId;
			}
			
			/**
			 * 设置 行业ID(主键)
			 * @param String industryId 
			 */
			public void setIndustryId(String industryId){
				this.industryId = industryId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 行业名称
			 * @return String this.industryName
			 */
			public String getIndustryName(){
				return this.industryName;
			}
			
			/**
			 * 设置 行业名称
			 * @param String industryName 
			 */
			public void setIndustryName(String industryName){
				this.industryName = industryName;
			}
		   		
		
		
			
			}