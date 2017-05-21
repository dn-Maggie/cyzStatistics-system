package com.cyz.staticsystem.product.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：产品分类模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class ProductClass extends Model{
	
	
		            /**
	                 * 产品分类ID(主键)
	                 **/
				   			private String productClassId;
		   		
		            /**
	                 * 产品分类名称
	                 **/
				   			private String productClassName;
		   		
		   			/**
	                 * 关联店铺ID
	                 **/
				   			private String storeId;	
				
		  			/**
			 * 获取 产品分类ID(主键)
			 * @return String this.productClassId
			 */
			public String getProductClassId(){
				return this.productClassId;
			}
			
			/**
			 * 设置 产品分类ID(主键)
			 * @param String productClassId 
			 */
			public void setProductClassId(String productClassId){
				this.productClassId = productClassId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品分类名称
			 * @return String this.productClassName
			 */
			public String getProductClassName(){
				return this.productClassName;
			}
			
			/**
			 * 设置 产品分类名称
			 * @param String productClassName 
			 */
			public void setProductClassName(String productClassName){
				this.productClassName = productClassName;
			}

			public String getStoreId() {
				return storeId;
			}

			public void setStoreId(String storeId) {
				this.storeId = storeId;
			}
		   		
		
		
			
			}