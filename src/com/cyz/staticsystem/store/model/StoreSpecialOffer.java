package com.cyz.staticsystem.store.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：商铺特价菜模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-04-10
 */
public class StoreSpecialOffer extends Model{
	
	
		            /**
	                 * 主键
	                 **/
				   			private String id;
		   			/**
	                 * 平台类型
	                 **/
				   			private String platformType;
		   		
		            /**
	                 * 店铺ID
	                 **/
				   			private String storeId;
		   		
		            /**
	                 * 店铺名称
	                 **/
				   			private String storeName;
		   		
		            /**
	                 * 特价结算时间起
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
					private Date specialOfferBeginDate;
		
		            /**
	                 * 特价结算时间止
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
					private Date specialOfferEndDate;
		
		            /**
	                 * 特价结算菜品id
	                 **/
				   			private String specialOfferFoodId;
		   		
		            /**
	                 * 特价结算菜品名称
	                 **/
				   			private String specialOfferFoodName;
		   		
		            /**
	                 * 特价结算菜品原价
	                 **/
				   			private String specialOfferFoodOrginPrice;
		   		
		            /**
	                 * 特价结算价格
	                 **/
				   			private String specialOfferFoodPrice;
		   		
		            /**
	                 * 特价结算方式（1.模糊查询  2.精准查询）
	                 **/
				   			private String specialType;
		   		
	
				
		  			/**
			 * 获取 主键
			 * @return String this.id
			 */
			public String getId(){
				return this.id;
			}
			
			/**
			 * 设置 主键
			 * @param String id 
			 */
			public void setId(String id){
				this.id = id;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 店铺ID
			 * @return String this.storeId
			 */
			public String getStoreId(){
				return this.storeId;
			}
			
			/**
			 * 设置 店铺ID
			 * @param String storeId 
			 */
			public void setStoreId(String storeId){
				this.storeId = storeId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 店铺名称
			 * @return String this.storeName
			 */
			public String getStoreName(){
				return this.storeName;
			}
			
			/**
			 * 设置 店铺名称
			 * @param String storeName 
			 */
			public void setStoreName(String storeName){
				this.storeName = storeName;
			}
		   		
		
		
			
								/**
			 * 获取 特价结算时间起
			 * @return Date this.specialOfferBeginDate
			 */
			public Date getSpecialOfferBeginDate(){
				return this.specialOfferBeginDate;
			}
			
			/**
			 * 设置 特价结算时间起
			 * @param Date specialOfferBeginDate 
			 */
			public void setSpecialOfferBeginDate(Date specialOfferBeginDate){
				this.specialOfferBeginDate = specialOfferBeginDate;
			}
								/**
			 * 获取 特价结算时间止
			 * @return Date this.specialOfferEndDate
			 */
			public Date getSpecialOfferEndDate(){
				return this.specialOfferEndDate;
			}
			
			/**
			 * 设置 特价结算时间止
			 * @param Date specialOfferEndDate 
			 */
			public void setSpecialOfferEndDate(Date specialOfferEndDate){
				this.specialOfferEndDate = specialOfferEndDate;
			}
						
		  			/**
			 * 获取 特价结算菜品id
			 * @return String this.specialOfferFoodId
			 */
			public String getSpecialOfferFoodId(){
				return this.specialOfferFoodId;
			}
			
			/**
			 * 设置 特价结算菜品id
			 * @param String specialOfferFoodId 
			 */
			public void setSpecialOfferFoodId(String specialOfferFoodId){
				this.specialOfferFoodId = specialOfferFoodId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价结算菜品名称
			 * @return String this.specialOfferFoodName
			 */
			public String getSpecialOfferFoodName(){
				return this.specialOfferFoodName;
			}
			
			/**
			 * 设置 特价结算菜品名称
			 * @param String specialOfferFoodName 
			 */
			public void setSpecialOfferFoodName(String specialOfferFoodName){
				this.specialOfferFoodName = specialOfferFoodName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价结算菜品原价
			 * @return String this.specialOfferFoodOrginPrice
			 */
			public String getSpecialOfferFoodOrginPrice(){
				return this.specialOfferFoodOrginPrice;
			}
			
			/**
			 * 设置 特价结算菜品原价
			 * @param String specialOfferFoodOrginPrice 
			 */
			public void setSpecialOfferFoodOrginPrice(String specialOfferFoodOrginPrice){
				this.specialOfferFoodOrginPrice = specialOfferFoodOrginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价结算价格
			 * @return String this.specialOfferFoodPrice
			 */
			public String getSpecialOfferFoodPrice(){
				return this.specialOfferFoodPrice;
			}
			
			/**
			 * 设置 特价结算价格
			 * @param String specialOfferFoodPrice 
			 */
			public void setSpecialOfferFoodPrice(String specialOfferFoodPrice){
				this.specialOfferFoodPrice = specialOfferFoodPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价结算方式（1.模糊查询  2.精准查询）
			 * @return String this.specialType
			 */
			public String getSpecialType(){
				return this.specialType;
			}
			
			/**
			 * 设置 特价结算方式（1.模糊查询  2.精准查询）
			 * @param String specialType 
			 */
			public void setSpecialType(String specialType){
				this.specialType = specialType;
			}

			/**
			 * @return the platformType
			 */
			public String getPlatformType() {
				return platformType;
			}

			/**
			 * @param platformType the platformType to set
			 */
			public void setPlatformType(String platformType) {
				this.platformType = platformType;
			}
		   		
		
		
			
			}