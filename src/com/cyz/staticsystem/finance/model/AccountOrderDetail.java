package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：订单明细模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-03-02
 */
public class AccountOrderDetail extends Model{
	
	
		            /**
	                 * 账单ID
	                 **/
		   			private String id;
		   			/**
	                 * 是否为有效单
	                 **/
		   			private String isInvalid;
		   		
		            /**
	                 * 创建日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
					private Date createDate;
					private String brandId;
					private String brandName;
					/** 配送地址
	                 */	
					private String targetAddr;
						
		   			private String storeId;
		   			private String storeELMId;
		   			private String storeMTId;
		   			private String storeBDId;
		   			private String storeName;
		   			private String businessArea;
		            /**
	                 * 账单编号
	                 **/
				   			private String checkNo;
		   		
		            /**
	                 * 订单类型
	                 **/
				   			private String orderType;
		   		
		            /**
	                 * 订单创建时间
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
						private Timestamp orderTime;
		
		            /**
	                 * 订单完成时间
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
						private Timestamp overTime;
		
		            /**
	                 * 接单序号
	                 **/
				   			private String orderIndex;
		   		
		            /**
	                 * 订单号
	                 **/
				   			private String orderNo;
		   		
		            /**
	                 * 菜价
	                 **/
				   			private BigDecimal orginPrice;
		   		
		            /**
	                 * 餐盒费
	                 **/
				   			private BigDecimal mealFee;
		   			/**
	                 * 原价
	                 **/
				   			private BigDecimal totalPrice;
				   	/**
	                 * 产品销售金额
	                 **/
				   			private BigDecimal productSaleAmount;
		   		
		            /**
	                 * 原价菜金额
	                 **/
				   			private BigDecimal actualPrice;
		   		
		            /**
	                 * 商户承担活动补贴
	                 **/
				   			private BigDecimal merchantActivitiesSubsidies;
		   		
		            /**
	                 * 商户承担代金券补贴
	                 **/
				   			private BigDecimal merchantSubsidyVouchers;
		   		
		   			/**
	                 * 订单上收取配送费
	                 **/
				   			private BigDecimal orderDistCharge;
		            /**
	                 * 商户收取配送费
	                 **/
				   			private BigDecimal merchantDistCharge;
		   			/**
	                 * 自配送实际支付金额
	                 **/
				   			private BigDecimal actualMerchantDistCharge;
		   			/**
	                 * 平台收取配送费
	                 **/
				   			private BigDecimal platformDistCharge;
		            /**
	                 * 服务费费率
	                 **/
				   			private String serviceRate;
		   		
		            /**
	                 * 服务费
	                 **/
				   			private BigDecimal serviceCharge;
		   		
		            /**
	                 * 用户申请退单金额
	                 **/
				   			private String refundAmount;
		   			/**
	                 * 订单最终状态
	                 **/
				   			private String latestStatus;
		   			/**
	                 * 订单最终有效性
	                 **/
				   			private String latestValidStatus;
						   					
				   			
		            /**
	                 * 结算金额
	                 **/
				   			private BigDecimal settlementAmount;
		   		
		            /**
	                 * 配送方式
	                 **/
				   			private String distributionMode;
		   		
		            /**
	                 * 备注
	                 **/
				   			private String remark;
				   			private String platformType;
		   		
		            /**
	                 * 平台承担活动补贴
	                 **/
				   			private BigDecimal platformActivitiesSubsidies;
		   			
		   		
		            /**
	                 * 平台承担代金券补贴
	                 **/
		   			private BigDecimal platformSubsidyVouchers;
		   			
		   			/**
	                 * 商户承担活动补贴(菜品折扣部分)
	                 **/
		   			private BigDecimal activitiesSubsidyBymerchant;
		   			/**
	                 * 商户承担活动补贴（公司承担线上活动费）
	                 **/
		   			private BigDecimal activitiesSubsidyBycompany;
		   			/**
	                 * 折扣菜价
	                 **/
		   			private BigDecimal foodDiscount;
		   			/**
	                 * 特价结算
	                 **/
		   			private BigDecimal specialOffer;
		   			/**
	                 * 特价结算原价
	                 **/
		   			private BigDecimal specialOrgin;
				
		   			
	   		 /**
                 * 预定时间
                 **/
				@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
					private Timestamp bookedTime;
	
            /**
             * 客户名称
             **/
		   			private String consigneeName;
   		
            /**
             * 客户手机号
             **/
		   			private String consigneePhones;
   		
            /**
             * 活动时间
             **/
			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
					private Timestamp activeTime;

            /**
             * 活动优惠
             **/
		   			private BigDecimal activeTotal;
   		
            /**
             * 菜品名称
             **/
		   			private String goodsName;
   		
            /**
             * 菜品数量
             **/
		   			private String goodsQuality;
   		
            /**
             * 菜品id
             **/
		   			private String goodsId;
   		
            /**
             * 菜品价格
             **/
		   			private String goodsPrice;
   		
            /**
             * 结算比例
             **/
		   			private BigDecimal orderSaleRate;
		   			
			   			
				   			
				   			
				   			
				   			
		  			public Timestamp getBookedTime() {
						return bookedTime;
					}

					public void setBookedTime(Timestamp bookedTime) {
							this.bookedTime = bookedTime;
					}

					public String getConsigneeName() {
						return consigneeName;
					}

					public void setConsigneeName(String consigneeName) {
						this.consigneeName = consigneeName;
					}

					public String getConsigneePhones() {
						return consigneePhones;
					}

					public void setConsigneePhones(String consigneePhones) {
						this.consigneePhones = consigneePhones;
					}

					public Timestamp getActiveTime() {
						return activeTime;
					}

					public void setActiveTime(Timestamp activeTime) {
						this.activeTime = activeTime;
					}

					public BigDecimal getActiveTotal() {
						return activeTotal;
					}

					public void setActiveTotal(BigDecimal activeTotal) {
						this.activeTotal = activeTotal;
					}

					public String getGoodsName() {
						return goodsName;
					}

					public void setGoodsName(String goodsName) {
						this.goodsName = goodsName;
					}

					public String getGoodsQuality() {
						return goodsQuality;
					}

					public void setGoodsQuality(String goodsQuality) {
						this.goodsQuality = goodsQuality;
					}

					public String getGoodsId() {
						return goodsId;
					}

					public void setGoodsId(String goodsId) {
						this.goodsId = goodsId;
					}

					public String getGoodsPrice() {
						return goodsPrice;
					}

					public void setGoodsPrice(String goodsPrice) {
						this.goodsPrice = goodsPrice;
					}

					public BigDecimal getOrderSaleRate() {
						return orderSaleRate;
					}

					public void setOrderSaleRate(BigDecimal orderSaleRate) {
						this.orderSaleRate = orderSaleRate;
					}

					/**
			 * 获取 账单ID
			 * @return String this.id
			 */
			public String getId(){
				return this.id;
			}
			
			/**
			 * 设置 账单ID
			 * @param String id 
			 */
			public void setId(String id){
				this.id = id;
			}
		   		
		
		
			
								/**
			 * 获取 创建日期
			 * @return Date this.createDate
			 */
			public Date getCreateDate(){
				return this.createDate;
			}
			
			/**
			 * 设置 创建日期
			 * @param Date createDate 
			 */
			public void setCreateDate(Date createDate){
				this.createDate = createDate;
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
			 * 获取 账单编号
			 * @return String this.checkNo
			 */
			public String getCheckNo(){
				return this.checkNo;
			}
			
			/**
			 * 设置 账单编号
			 * @param String checkNo 
			 */
			public void setCheckNo(String checkNo){
				this.checkNo = checkNo;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 订单类型
			 * @return String this.orderType
			 */
			public String getOrderType(){
				return this.orderType;
			}
			
			/**
			 * 设置 订单类型
			 * @param String orderType 
			 */
			public void setOrderType(String orderType){
				this.orderType = orderType;
			}
		   		
		
		
			
								/**
			 * 获取 订单创建时间
			 * @return Date this.orderTime
			 */
			public Timestamp getOrderTime(){
				return this.orderTime;
			}
			
			/**
			 * 设置 订单创建时间
			 * @param Date orderTime 
			 */
			public void setOrderTime(Timestamp orderTime){
				this.orderTime = orderTime;
			}
			/**
			 * 获取 订单完成时间
			 * @return Date this.overTime
			 */
			public Timestamp getOverTime(){
				return this.overTime;
			}
			
			/**
			 * 设置 订单完成时间
			 * @param Date overTime 
			 */
			public void setOverTime(Timestamp overTime){
				if(overTime!=null){
					this.overTime = overTime;
				}
			}
						
		  			/**
			 * 获取 接单序号
			 * @return String this.orderIndex
			 */
			public String getOrderIndex(){
				return this.orderIndex;
			}
			
			/**
			 * 设置 接单序号
			 * @param String orderIndex 
			 */
			public void setOrderIndex(String orderIndex){
				this.orderIndex = orderIndex;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 订单号
			 * @return String this.orderNo
			 */
			public String getOrderNo(){
				return this.orderNo;
			}
			
			/**
			 * 设置 订单号
			 * @param String orderNo 
			 */
			public void setOrderNo(String orderNo){
				this.orderNo = orderNo;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 菜价
			 * @return String this.orginPrice
			 */
			public BigDecimal getOrginPrice(){
				return this.orginPrice;
			}
			
			/**
			 * 设置 菜价
			 * @param String orginPrice 
			 */
			public void setOrginPrice(BigDecimal orginPrice){
				this.orginPrice = orginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 餐盒费
			 * @return String this.mealFee
			 */
			public BigDecimal getMealFee(){
				return this.mealFee;
			}
			
			/**
			 * 设置 餐盒费
			 * @param String mealFee 
			 */
			public void setMealFee(BigDecimal mealFee){
				this.mealFee = mealFee;
			}
		   		
		
		
			
						
  			/**
			 * 获取 赠品补贴
			 * @return String this.giftAllowance
			 */
			public BigDecimal getActualPrice(){
				return this.actualPrice;
			}
			
			/**
			 * 设置 赠品补贴
			 * @param String giftAllowance 
			 */
			public void setActualPrice(BigDecimal actualPrice){
				this.actualPrice = actualPrice;
			}
		   		
		
		
			
		
		
			
		
		
			
		
			
						
  			/**
			 * 获取 服务费费率
			 * @return String this.serviceRate
			 */
			public String getServiceRate(){				
				return this.serviceRate;
			}
			
			/**
			 * 设置 服务费费率
			 * @param String serviceRate 
			 */
			public void setServiceRate(String serviceRate){
				this.serviceRate = serviceRate;
			}
		   		
		
		
			
						
  			/**
			 * 获取 服务费
			 * @return String this.serviceCharge
			 */
			public BigDecimal getServiceCharge(){
				return this.serviceCharge;
			}
			
			/**
			 * 设置 服务费
			 * @param String serviceCharge 
			 */
			public void setServiceCharge(BigDecimal serviceCharge){
				this.serviceCharge = serviceCharge;
			}
		   		
		
		
			
						
  			/**
			 * 获取 用户申请退单金额
			 * @return String this.refundAmount
			 */
			public String getRefundAmount(){
				return this.refundAmount;
			}
			
			/**
			 * 设置 用户申请退单金额
			 * @param String refundAmount 
			 */
			public void setRefundAmount(String refundAmount){
				this.refundAmount = refundAmount;
			}
		   		
		
		
			
						
  			/**
			 * 获取 结算金额
			 * @return String this.settlementAmount
			 */
			public BigDecimal getSettlementAmount(){
				return this.settlementAmount;
			}
			
			/**
			 * 设置 结算金额
			 * @param String settlementAmount 
			 */
			public void setSettlementAmount(BigDecimal settlementAmount){
				this.settlementAmount = settlementAmount;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 配送方式
			 * @return String this.distributionMode
			 */
			public String getDistributionMode(){
				return this.distributionMode;
			}
			
			/**
			 * 设置 配送方式
			 * @param String distributionMode 
			 */
			public void setDistributionMode(String distributionMode){
				this.distributionMode = distributionMode;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 备注
			 * @return String this.remark
			 */
			public String getRemark(){
				return this.remark;
			}
			
			/**
			 * 设置 备注
			 * @param String remark 
			 */
			public void setRemark(String remark){
				this.remark = remark;
			}
		   		
		
		
						

			public String getStoreName() {
				return this.storeName;
			}

			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}

			public String getPlatformType() {
				return this.platformType;
			}

			public void setPlatformType(String platformType) {
				this.platformType = platformType;
			}

			public String getStoreELMId() {
				return storeELMId;
			}

			public void setStoreELMId(String storeELMId) {
				this.storeELMId = storeELMId;
			}

			public String getStoreMTId() {
				return this.storeMTId;
			}

			public void setStoreMTId(String storeMTId) {
				this.storeMTId = storeMTId;
			}

			public String getStoreBDId() {
				return this.storeBDId;
			}

			public void setStoreBDId(String storeBDId) {
				this.storeBDId = storeBDId;
			}

			public BigDecimal getMerchantActivitiesSubsidies() {
				return merchantActivitiesSubsidies;
			}

			public void setMerchantActivitiesSubsidies(BigDecimal merchantActivitiesSubsidies) {
				this.merchantActivitiesSubsidies = merchantActivitiesSubsidies;
			}

			public BigDecimal getMerchantSubsidyVouchers() {
				return merchantSubsidyVouchers;
			}

			public void setMerchantSubsidyVouchers(BigDecimal merchantSubsidyVouchers) {
				this.merchantSubsidyVouchers = merchantSubsidyVouchers;
			}

			public BigDecimal getMerchantDistCharge() {
				return merchantDistCharge;
			}

			public void setMerchantDistCharge(BigDecimal merchantDistCharge) {
				this.merchantDistCharge = merchantDistCharge;
			}

			public BigDecimal getPlatformDistCharge() {
				return platformDistCharge;
			}

			public void setPlatformDistCharge(BigDecimal platformDistCharge) {
				this.platformDistCharge = platformDistCharge;
			}

			public BigDecimal getPlatformActivitiesSubsidies() {
				return platformActivitiesSubsidies;
			}

			public void setPlatformActivitiesSubsidies(BigDecimal platformActivitiesSubsidies) {
				this.platformActivitiesSubsidies = platformActivitiesSubsidies;
			}

			public BigDecimal getPlatformSubsidyVouchers() {
				return platformSubsidyVouchers;
			}

			public void setPlatformSubsidyVouchers(BigDecimal platformSubsidyVouchers) {
				this.platformSubsidyVouchers = platformSubsidyVouchers;
			}

			public String getIsInvalid() {
				return isInvalid;
			}

			public void setIsInvalid(String isInvalid) {
				this.isInvalid = isInvalid;
			}

			public BigDecimal getActivitiesSubsidyBymerchant() {
				return activitiesSubsidyBymerchant;
			}

			public void setActivitiesSubsidyBymerchant(BigDecimal activitiesSubsidyBymerchant) {
				this.activitiesSubsidyBymerchant = activitiesSubsidyBymerchant;
			}

			public BigDecimal getActivitiesSubsidyBycompany() {
				return activitiesSubsidyBycompany;
			}

			public void setActivitiesSubsidyBycompany(BigDecimal activitiesSubsidyBycompany) {
				this.activitiesSubsidyBycompany = activitiesSubsidyBycompany;
			}

			public BigDecimal getFoodDiscount() {
				return foodDiscount;
			}

			public void setFoodDiscount(BigDecimal foodDiscount) {
				this.foodDiscount = foodDiscount;
			}

			public BigDecimal getSpecialOffer() {
				return specialOffer;
			}

			public void setSpecialOffer(BigDecimal specialOffer) {
				this.specialOffer = specialOffer;
			}

			public BigDecimal getSpecialOrgin() {
				return specialOrgin;
			}

			public void setSpecialOrgin(BigDecimal specialOrgin) {
				this.specialOrgin = specialOrgin;
			}

			public BigDecimal getProductSaleAmount() {
				return productSaleAmount;
			}

			public void setProductSaleAmount(BigDecimal productSaleAmount) {
				this.productSaleAmount = productSaleAmount;
			}

			public BigDecimal getTotalPrice() {
				return totalPrice;
			}

			public void setTotalPrice(BigDecimal totalPrice) {
				this.totalPrice = totalPrice;
			}

			public BigDecimal getOrderDistCharge() {
				return orderDistCharge;
			}

			public void setOrderDistCharge(BigDecimal orderDistCharge) {
				this.orderDistCharge = orderDistCharge;
			}

			public BigDecimal getActualMerchantDistCharge() {
				return actualMerchantDistCharge;
			}

			public void setActualMerchantDistCharge(BigDecimal actualMerchantDistCharge) {
				this.actualMerchantDistCharge = actualMerchantDistCharge;
			}

			public String getTargetAddr() {
				return targetAddr;
			}

			public void setTargetAddr(String targetAddr) {
				this.targetAddr = targetAddr;
			}

			public String getBrandId() {
				return brandId;
			}

			public void setBrandId(String brandId) {
				this.brandId = brandId;
			}

			public String getBrandName() {
				return brandName;
			}

			public void setBrandName(String brandName) {
				this.brandName = brandName;
			}

			public String getLatestStatus() {
				return latestStatus;
			}

			public void setLatestStatus(String latestStatus) {
				this.latestStatus = latestStatus;
			}

			public String getLatestValidStatus() {
				return latestValidStatus;
			}

			public void setLatestValidStatus(String latestValidStatus) {
				this.latestValidStatus = latestValidStatus;
			}

			public String getBusinessArea() {
				return businessArea;
			}

			public void setBusinessArea(String businessArea) {
				this.businessArea = businessArea;
			}


		   		
		
		
			
			}