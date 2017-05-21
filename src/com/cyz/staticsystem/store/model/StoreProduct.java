package com.cyz.staticsystem.store.model;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：店铺产品模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-20
 */
public class StoreProduct extends Model{
				
	
		            /**
	                 * 店铺产品ID
	                 **/
				   			private String storeProductId;
				   				
		            /**
	                 * 店铺ID
	                 **/
				   			private String storeId;
				   			private String storeName;
				   			private String ownerUserId;
		   		
		            /**
	                 * 产品分类ID
	                 **/
				   			private String productClassId;
		   		
		            /**
	                 * 产品类名
	                 **/
				   			private String productClassName;
		   		
		            /**
	                 * 产品ID
	                 **/
				   			private String productId;
		   		
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
	                 * 店铺产品折扣
	                 **/
				   			private String merchantDiscount;
				   		
		            /**
	                 * 折扣时间起
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
							private Timestamp merchantDiscountBegin;
				
				            /**
			                 * 折扣时间止
			                 **/
							@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
					private Timestamp merchantDiscountEnd;
				
				            /**
			                 * 签订特价结算金额
			                 **/
				   			private String specialOffer;
				   		
				            /**
			                 * 签订特价结算起
			                 **/
							@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
							private Timestamp specialOfferBegin;
				
				            /**
			                 * 签订特价结算止
			                 **/
							@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
							private Timestamp specialOfferEnd;
				
					public String getMerchantDiscount() {
						return merchantDiscount;
					}

					public void setMerchantDiscount(String merchantDiscount) {
						this.merchantDiscount = merchantDiscount;
					}

					public Timestamp getMerchantDiscountBegin() {
						return merchantDiscountBegin;
					}

					public void setMerchantDiscountBegin(Timestamp merchantDiscountBegin) {
						this.merchantDiscountBegin = merchantDiscountBegin;
					}

					public Timestamp getMerchantDiscountEnd() {
						return merchantDiscountEnd;
					}

					public void setMerchantDiscountEnd(Timestamp merchantDiscountEnd) {
						this.merchantDiscountEnd = merchantDiscountEnd;
					}

					public String getSpecialOffer() {
						return specialOffer;
					}

					public void setSpecialOffer(String specialOffer) {
						this.specialOffer = specialOffer;
					}

					public Timestamp getSpecialOfferBegin() {
						return specialOfferBegin;
					}

					public void setSpecialOfferBegin(Timestamp specialOfferBegin) {
						this.specialOfferBegin = specialOfferBegin;
					}

					public Timestamp getSpecialOfferEnd() {
						return specialOfferEnd;
					}

					public void setSpecialOfferEnd(Timestamp specialOfferEnd) {
						this.specialOfferEnd = specialOfferEnd;
					}

					public String getOwnerUserId() {
						return ownerUserId;
					}

					public void setOwnerUserId(String ownerUserId) {
						this.ownerUserId = ownerUserId;
					}

					/**
			 * 获取 店铺产品ID
			 * @return String this.storeProductId
			 */
			public String getStoreProductId(){
				return this.storeProductId;
			}
			
			/**
			 * 设置 店铺产品ID
			 * @param String storeProductId 
			 */
			public void setStoreProductId(String storeProductId){
				this.storeProductId = storeProductId;
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
			 * 获取 产品类名
			 * @return String this.productClassName
			 */
			public String getProductClassName(){
				return this.productClassName;
			}
			
			/**
			 * 设置 产品类名
			 * @param String productClassName 
			 */
			public void setProductClassName(String productClassName){
				this.productClassName = productClassName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品ID
			 * @return String this.productId
			 */
			public String getProductId(){
				return this.productId;
			}
			
			/**
			 * 设置 产品ID
			 * @param String productId 
			 */
			public void setProductId(String productId){
				this.productId = productId;
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

			public String getStoreName() {
				return storeName;
			}

			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}
		}