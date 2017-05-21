package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：菜品数量表模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-04-11
 */
public class AccountSaleGoods extends Model{
	
	
		            /**
	                 * 主键
	                 **/
				   			private String id;
		   		
		            /**
	                 * 店铺ID
	                 **/
				   			private String storeId;
		   		
		            /**
	                 * 店铺名称
	                 **/	
	                 
				   			private String storeName;
		   			/**
	                 * 日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date createDate;
		   		
		            /**
	                 * 订单编号
	                 **/
				   			private String orderNo;
		   		
		            /**
	                 * 菜品名称
	                 **/
				   			private String goodName;
		   		
		            /**
	                 * 原价单价
	                 **/
				   			private BigDecimal goodUnitPrice;
		   			/**
	                 * 实际结算单价
	                 **/
				   			private BigDecimal goodActualPrice;
		            /**
	                 * 销售数量
	                 **/
				   			private Integer goodNum;
				   			private BigDecimal goodsPrice;
		            /**
	                 * 平台类型
	                 **/
				   			private String platformType;
		   		
	
				
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
			 * 获取 订单编号
			 * @return String this.orderNo
			 */
			public String getOrderNo(){
				return this.orderNo;
			}
			
			/**
			 * 设置 订单编号
			 * @param String orderNo 
			 */
			public void setOrderNo(String orderNo){
				this.orderNo = orderNo;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 菜品名称
			 * @return String this.goodName
			 */
			public String getGoodName(){
				return this.goodName;
			}
			
			/**
			 * 设置 菜品名称
			 * @param String goodName 
			 */
			public void setGoodName(String goodName){
				this.goodName = goodName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 结算单价
			 * @return String this.goodUnitPrice
			 */
			public BigDecimal getGoodUnitPrice(){
				return this.goodUnitPrice;
			}
			
			/**
			 * 设置 结算单价
			 * @param BigDecimal goodUnitPrice 
			 */
			public void setGoodUnitPrice(BigDecimal goodUnitPrice){
				this.goodUnitPrice = goodUnitPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 销售数量
			 * @return Integer this.goodNum
			 */
			public Integer getGoodNum(){
				return this.goodNum;
			}
			
			/**
			 * 设置 销售数量
			 * @param BigDecimal goodNum 
			 */
			public void setGoodNum(Integer goodNum){
				this.goodNum = goodNum;
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

			public BigDecimal getGoodsPrice() {
				return goodsPrice;
			}

			public void setGoodsPrice(BigDecimal goodsPrice) {
				this.goodsPrice = goodsPrice;
			}

			public Date getCreateDate() {
				return createDate;
			}

			public void setCreateDate(Date createDate) {
				this.createDate = createDate;
			}

			public BigDecimal getGoodActualPrice() {
				return goodActualPrice;
			}

			public void setGoodActualPrice(BigDecimal goodActualPrice) {
				this.goodActualPrice = goodActualPrice;
			}
		   		
		
		
			
			}