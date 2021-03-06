package com.cyz.staticsystem.area.model;

import com.cyz.staticsystem.common.Constant;
import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：省市区地域模块实体类，负责页面与后台数据传输功能
 *
 * @author fan.yang
 * @version 1.0 2017-01-01
 */
public class ChinaArea extends Model{
		
	
		            /**
	                 * 
	                 **/
				   			private Integer id;
		   		
		            /**
	                 * 
	                 **/
				   			private String name;
		   		
		            /**
	                 * 
	                 **/
				   			private Integer pid;
		   		
	
				
		  			/**
			 * 获取 
			 * @return Integer this.id
			 */
			public Integer getId(){
				return this.id;
			}
			
			/**
			 * 设置 
			 * @param BigDecimal id 
			 */
			public void setId(Integer id){
				this.id = id;
			}
						
  			/**
			 * 获取 
			 * @return String this.name
			 */
			public String getName(){
				return this.name;
			}
			
			/**
			 * 设置 
			 * @param String name 
			 */
			public void setName(String name){
				this.name = name;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 
			 * @return Integer this.pid
			 */
			public Integer getPid(){
				return this.pid;
			}
			
			/**
			 * 设置 
			 * @param BigDecimal pid 
			 */
			public void setPid(Integer pid){
				this.pid = pid;
			}
		  		
		
		
			
			}