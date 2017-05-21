package com.cyz.staticsystem.product.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：产品模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class Product extends Model{
	
	
		            /**
	                 * 产品ID(主键)
	                 **/
				   			private String productId;
				   			
		   		
		            /**
	                 * 产品分类ID
	                 **/
				   			private String productClassId;
				   			private String productClassName;
		   		
		            /**
	                 * 产品名称
	                 **/
				   			private String productName;
		   		
		            /**
	                 * 产品图片地址
	                 **/
				   			private String productImagePath;
		   		
		            /**
	                 * 产品单价
	                 **/
				   			private String productUnitPrice;
		   		
		            /**
	                 * 库存数量
	                 **/
				   			private Integer productStocks;
		   		
		            /**
	                 * 产品状态
	                 **/
				   			private String productStatus;
		   			/**
	                 * 关联店铺ID
	                 **/
				   			private String storeId;		   		
	
				
		  			/**
			 * 获取 产品ID(主键)
			 * @return String this.productId
			 */
			public String getProductId(){
				return this.productId;
			}
			
			/**
			 * 设置 产品ID(主键)
			 * @param String productId 
			 */
			public void setProductId(String productId){
				this.productId = productId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品分类ID
			 * @return String this.productClassId
			 */
			public String getProductClassId(){
				return this.productClassId;
			}
			
			/**
			 * 设置 产品分类ID
			 * @param String productClassId 
			 */
			public void setProductClassId(String productClassId){
				this.productClassId = productClassId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品名称
			 * @return String this.productName
			 */
			public String getProductName(){
				return this.productName;
			}
			
			/**
			 * 设置 产品名称
			 * @param String productName 
			 */
			public void setProductName(String productName){
				this.productName = productName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品图片地址
			 * @return String this.productImagePath
			 */
			public String getProductImagePath(){
				return this.productImagePath;
			}
			
			/**
			 * 设置 产品图片地址
			 * @param String productImagePath 
			 */
			public void setProductImagePath(String productImagePath){
				this.productImagePath = productImagePath;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品单价
			 * @return String this.productUnitPrice
			 */
			public String getProductUnitPrice(){
				return this.productUnitPrice;
			}
			
			/**
			 * 设置 产品单价
			 * @param String productUnitPrice 
			 */
			public void setProductUnitPrice(String productUnitPrice){
				this.productUnitPrice = productUnitPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 库存数量
			 * @return Integer this.productStocks
			 */
			public Integer getProductStocks(){
				return this.productStocks;
			}
			
			/**
			 * 设置 库存数量
			 * @param BigDecimal productStocks 
			 */
			public void setProductStocks(Integer productStocks){
				this.productStocks = productStocks;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 产品状态
			 * @return String this.productStatus
			 */
			public String getProductStatus(){
				return this.productStatus;
			}
			
			/**
			 * 设置 产品状态
			 * @param String productStatus 
			 */
			public void setProductStatus(String productStatus){
				this.productStatus = productStatus;
			}

			public String getProductClassName() {
				return productClassName;
			}

			public void setProductClassName(String productClassName) {
				this.productClassName = productClassName;
			}

			public String getStoreId() {
				return storeId;
			}

			public void setStoreId(String storeId) {
				this.storeId = storeId;
			}
		   		
		
		
			
			}