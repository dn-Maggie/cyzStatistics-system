package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：特价菜结算明细模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-04-10
 */
public class AccountSpecialFood extends Model{
	
	
		            /**
	                 * 主键
	                 **/
				   			private Integer id;
		   		
		            /**
	                 * 
	                 **/
				   			private String storeId;
				   			private String storeELMId;
				   			private String storeMTId;
				   			private String storeBDId;
				   			public String getStoreELMId() {
								return storeELMId;
							}
		
							public void setStoreELMId(String storeELMId) {
								this.storeELMId = storeELMId;
							}
		
							public String getStoreMTId() {
								return storeMTId;
							}
		
							public void setStoreMTId(String storeMTId) {
								this.storeMTId = storeMTId;
							}
		
							public String getStoreBDId() {
								return storeBDId;
							}

							public void setStoreBDId(String storeBDId) {
								this.storeBDId = storeBDId;
							}

							
				   			private String orderNo;
		   		
		            /**
	                 * 
	                 **/
				   			private String storeName;
		   		
		            /**
	                 * 特价菜品
	                 **/
				   			private String specialOfferFoodName;
		   		
		            /**
	                 * 日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
						private Date createDate;
		
		            /**
	                 * 销量
	                 **/
				   			private Integer saleNum;
		   		
		            /**
	                 * 原单价
	                 **/
				   			private BigDecimal orginPrice;
		   		
		            /**
	                 * 结算单价
	                 **/
				   			private BigDecimal settlementPrice;
		   		
		            /**
	                 * 特价菜原价
	                 **/
				   			private BigDecimal specialOfferOrginPrice;
		   		
		            /**
	                 * 特价菜结算
	                 **/
				   			private BigDecimal specialOfferSettlement;
		   		
		            /**
	                 * 平台类型
	                 **/
				   			private String platformType;
		   		
	
				
		  			/**
			 * 获取 主键
			 * @return Integer this.id
			 */
			public Integer getId(){
				return this.id;
			}
			
			/**
			 * 设置 主键
			 * @param BigDecimal id 
			 */
			public void setId(Integer id){
				this.id = id;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 
			 * @return String this.storeId
			 */
			public String getStoreId(){
				return this.storeId;
			}
			
			/**
			 * 设置 
			 * @param String storeId 
			 */
			public void setStoreId(String storeId){
				this.storeId = storeId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 
			 * @return String this.storeName
			 */
			public String getStoreName(){
				return this.storeName;
			}
			
			/**
			 * 设置 
			 * @param String storeName 
			 */
			public void setStoreName(String storeName){
				this.storeName = storeName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价菜品
			 * @return String this.specialOfferFoodName
			 */
			public String getSpecialOfferFoodName(){
				return this.specialOfferFoodName;
			}
			
			/**
			 * 设置 特价菜品
			 * @param BigDecimal specialOfferFoodName 
			 */
			public void setSpecialOfferFoodName(String specialOfferFoodName){
				this.specialOfferFoodName = specialOfferFoodName;
			}
		   		
		
		
			
								/**
			 * 获取 日期
			 * @return Date this.createDate
			 */
			public Date getCreateDate(){
				return this.createDate;
			}
			
			/**
			 * 设置 日期
			 * @param Date createDate 
			 */
			public void setCreateDate(Date createDate){
				this.createDate = createDate;
			}
						
		  			/**
			 * 获取 销量
			 * @return Integer this.saleNum
			 */
			public Integer getSaleNum(){
				return this.saleNum;
			}
			
			/**
			 * 设置 销量
			 * @param BigDecimal saleNum 
			 */
			public void setSaleNum(Integer saleNum){
				this.saleNum = saleNum;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 原单价
			 * @return BigDecimal this.orginPrice
			 */
			public BigDecimal getOrginPrice(){
				return this.orginPrice;
			}
			
			/**
			 * 设置 原单价
			 * @param BigDecimal orginPrice 
			 */
			public void setOrginPrice(BigDecimal orginPrice){
				this.orginPrice = orginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 结算单价
			 * @return BigDecimal this.settlementPrice
			 */
			public BigDecimal getSettlementPrice(){
				return this.settlementPrice;
			}
			
			/**
			 * 设置 结算单价
			 * @param BigDecimal settlementPrice 
			 */
			public void setSettlementPrice(BigDecimal settlementPrice){
				this.settlementPrice = settlementPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价菜原价
			 * @return BigDecimal this.specialOfferOrginPrice
			 */
			public BigDecimal getSpecialOfferOrginPrice(){
				return this.specialOfferOrginPrice;
			}
			
			/**
			 * 设置 特价菜原价
			 * @param BigDecimal specialOfferOrginPrice 
			 */
			public void setSpecialOfferOrginPrice(BigDecimal specialOfferOrginPrice){
				this.specialOfferOrginPrice = specialOfferOrginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价菜结算
			 * @return BigDecimal this.specialOfferSettlement
			 */
			public BigDecimal getSpecialOfferSettlement(){
				return this.specialOfferSettlement;
			}
			
			/**
			 * 设置 特价菜结算
			 * @param BigDecimal specialOfferSettlement 
			 */
			public void setSpecialOfferSettlement(BigDecimal specialOfferSettlement){
				this.specialOfferSettlement = specialOfferSettlement;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台类型
			 * @return String this.platformType
			 */
			public String getPlatformType(){
				return this.platformType;
			}
			
			/**
			 * 设置 平台类型
			 * @param String platformType 
			 */
			public void setPlatformType(String platformType){
				this.platformType = platformType;
			}

			public String getOrderNo() {
				return orderNo;
			}

			public void setOrderNo(String orderNo) {
				this.orderNo = orderNo;
			}
		   		
		
		
			
			}