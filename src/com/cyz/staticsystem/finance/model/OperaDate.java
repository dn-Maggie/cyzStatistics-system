package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：运营日明细模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-03-28
 */
public class OperaDate extends Model{
	
	
		            /**
	                 * 主键
	                 **/
				   			private String id;
		   		
		            /**
	                 * 店铺ID
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

					/**
	                 * 商户名称
	                 **/
				   			private String storeName;
		   		
		            /**
	                 * 日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date createDate;
		
		            /**
	                 * 无效单
	                 **/
				   			private Integer invalidNum;
		   		
		            /**
	                 * 有效单
	                 **/
				   			private Integer validNum;
		   		
		            /**
	                 * 菜品份数
	                 **/
				   			private String goodsQuality;
		   		
		            /**
	                 * 菜品原价
	                 **/
				   			private BigDecimal orginPrice;
		   		
		            /**
	                 * 餐盒费
	                 **/
				   			private BigDecimal mealFee;
		   		
		            /**
	                 * 特价菜原价
	                 **/
				   			private BigDecimal specialOrgin;
		   		
		            /**
	                 * 特价菜结算
	                 **/
				   			private BigDecimal specialOffer;
				   			
			   		 /**
	                 * 原价菜金额
	                 **/
				   			private BigDecimal actualPrice;
		   		
		            /**
	                 * 实际菜品折扣
	                 **/
				   			private BigDecimal activitiesSubsidyBymerchant;
		   		
		            /**
	                 * 订单上收取客户配送费
	                 **/
				   			private BigDecimal orderDistCharge;
		   		
		            /**
	                 * 平台收取配送费
	                 **/
				   			private BigDecimal platformDistCharge;
		   		
		            /**
	                 * 公司收取配送费
	                 **/
				   			private BigDecimal cyzDistCharge;
		   		
		            /**
	                 * 公司承担线上活动费
	                 **/
				   			private BigDecimal activitiesSubsidyBycompany;
		   		
		            /**
	                 * 平台承担线上活动费
	                 **/
				   			private BigDecimal platformActivitiesCharge;
		   		
		            /**
	                 * 平台服务费
	                 **/
				   			private BigDecimal platformServiceCharge;
		   		
		            /**
	                 * 产品销售金额
	                 **/
				   			private String productSaleAmount;
		   		
		            /**
	                 * 应收平台结算金额
	                 **/
				   			private String amountReceivable;
		   		
		            /**
	                 * 结算比例
	                 **/
				   			private BigDecimal orderSaleRate;
		   		
		            /**
	                 * (结算比例)*结算金额
	                 **/
				   			private String amountRatePayable;
		   		
		            /**
	                 * 应付店铺结算金额
	                 **/
				   			private String amountPayable;
		   		
		            /**
	                 * 公司收入(公司收取店铺服务费)
	                 **/
				   			private String cyzServiceCharge;
		   		
		            /**
	                 * 公司收入(工厂应收)
	                 **/
				   			private String cyzServiceChargeIndustryPart;
		   		
		            /**
	                 * 公司收入(运营应收)
	                 **/
				   			private String cyzServiceChargeOperaPart;
		   		
		            /**
	                 * 自配送实际支付金额
	                 **/
				   			private BigDecimal actualMerchantDistCharge;
		   		
		            /**
	                 * 销售毛利
	                 **/
				   			private String saleGrossProfit;
		   		
		            /**
	                 * 毛利率
	                 **/
				   			private String saleGrossProfitRate;
		   		
		            /**
	                 * 自配送金额单价
	                 **/
				   			private BigDecimal distPrice;
		   		
		            /**
	                 * 自配送金额
	                 **/
				   			private BigDecimal distAll;
		   		
		            /**
	                 * 自配送补差
	                 **/
				   			private BigDecimal distDiff;
		   		
		            /**
	                 * 对外支付饿了么平台补贴服务费
	                 **/
				   			private String serviceAll;
		   		
		            /**
	                 * 实际运营毛利
	                 **/
				   			private String profitAll;
		   		
		            /**
	                 * 竞价费用+短信推广
	                 **/
				   			private BigDecimal otherAll;
		   		
		            /**
	                 * 底价
	                 **/
				   			private BigDecimal allbasePrice;
		   		
		            /**
	                 * 其他底价
	                 **/
				   			private BigDecimal allotherBasePrice;
		   		
		            /**
	                 * 备注
	                 **/
				   			private String remark;
		   		
		            /**
	                 * 平台类型
	                 **/
				   			private String platformType;
				   			/*餐盒费*/
				   			private BigDecimal elmMealFee;
				   			private BigDecimal bdMealFee;
				   			private BigDecimal mtMealFee;
				   			/*折扣菜金额*/
				   			private BigDecimal elmSpecialOffer;
				   			private BigDecimal bdSpecialOffer;
				   			private BigDecimal mtSpecialOffer;
				   			/*原价菜金额结算款*/
				   			private BigDecimal elmActualPrice;
				   			private BigDecimal bdActualPrice;
				   			private BigDecimal mtActualPrice;
				   			/*平台到账调整额*/
				   			private BigDecimal elmRecieveAdjust;
				   			private BigDecimal bdRecieveAdjust;
				   			private BigDecimal mtRecieveAdjust;
				   			/*结算金额*/
				   			private BigDecimal elmSettlement;
				   			private BigDecimal bdSettlement;
				   			private BigDecimal mtSettlement;
				   			private BigDecimal settlement;
				   			
				   			
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
			 * 获取 商户名称
			 * @return String this.storeName
			 */
			public String getStoreName(){
				return this.storeName;
			}
			
			/**
			 * 设置 商户名称
			 * @param String storeName 
			 */
			public void setStoreName(String storeName){
				this.storeName = storeName;
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
			 * 获取 无效单
			 * @return Integer this.invalidNum
			 */
			public Integer getInvalidNum(){
				return this.invalidNum;
			}
			
			/**
			 * 设置 无效单
			 * @param BigDecimal invalidNum 
			 */
			public void setInvalidNum(Integer invalidNum){
				this.invalidNum = invalidNum;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 有效单
			 * @return Integer this.validNum
			 */
			public Integer getValidNum(){
				return this.validNum;
			}
			
			/**
			 * 设置 有效单
			 * @param BigDecimal validNum 
			 */
			public void setValidNum(Integer validNum){
				this.validNum = validNum;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 菜品份数
			 * @return String this.goodsQuality
			 */
			public String getGoodsQuality(){
				return this.goodsQuality;
			}
			
			/**
			 * 设置 菜品份数
			 * @param String goodsQuality 
			 */
			public void setGoodsQuality(String goodsQuality){
				this.goodsQuality = goodsQuality;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 菜品原价
			 * @return String this.orginPrice
			 */
			public BigDecimal getOrginPrice(){
				return this.orginPrice;
			}
			
			/**
			 * 设置 菜品原价
			 * @param BigDecimal orginPrice 
			 */
			public void setOrginPrice(BigDecimal orginPrice){
				this.orginPrice = orginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 餐盒费
			 * @return BigDecimal this.mealFee
			 */
			public BigDecimal getMealFee(){
				return this.mealFee;
			}
			
			/**
			 * 设置 餐盒费
			 * @param BigDecimal mealFee 
			 */
			public void setMealFee(BigDecimal mealFee){
				this.mealFee = mealFee;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价菜原价
			 * @return BigDecimal this.specialOrgin
			 */
			public BigDecimal getSpecialOrgin(){
				return this.specialOrgin;
			}
			
			/**
			 * 设置 特价菜原价
			 * @param BigDecimal specialOrgin 
			 */
			public void setSpecialOrgin(BigDecimal specialOrgin){
				this.specialOrgin = specialOrgin;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 特价菜结算
			 * @return BigDecimal this.specialOffer
			 */
			public BigDecimal getSpecialOffer(){
				return this.specialOffer;
			}
			
			/**
			 * 设置 特价菜结算
			 * @param BigDecimal specialOffer 
			 */
			public void setSpecialOffer(BigDecimal specialOffer){
				this.specialOffer = specialOffer;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 实际菜品折扣
			 * @return BigDecimal this.activitiesSubsidyBymerchant
			 */
			public BigDecimal getActivitiesSubsidyBymerchant(){
				return this.activitiesSubsidyBymerchant;
			}
			
			/**
			 * 设置 实际菜品折扣
			 * @param BigDecimal activitiesSubsidyBymerchant 
			 */
			public void setActivitiesSubsidyBymerchant(BigDecimal activitiesSubsidyBymerchant){
				this.activitiesSubsidyBymerchant = activitiesSubsidyBymerchant;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 订单上收取客户配送费
			 * @return BigDecimal this.orderDistCharge
			 */
			public BigDecimal getOrderDistCharge(){
				return this.orderDistCharge;
			}
			
			/**
			 * 设置 订单上收取客户配送费
			 * @param BigDecimal orderDistCharge 
			 */
			public void setOrderDistCharge(BigDecimal orderDistCharge){
				this.orderDistCharge = orderDistCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台收取配送费
			 * @return BigDecimal this.platformDistCharge
			 */
			public BigDecimal getPlatformDistCharge(){
				return this.platformDistCharge;
			}
			
			/**
			 * 设置 平台收取配送费
			 * @param BigDecimal platformDistCharge 
			 */
			public void setPlatformDistCharge(BigDecimal platformDistCharge){
				this.platformDistCharge = platformDistCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收取配送费
			 * @return BigDecimal this.cyzDistCharge
			 */
			public BigDecimal getCyzDistCharge(){
				return this.cyzDistCharge;
			}
			
			/**
			 * 设置 公司收取配送费
			 * @param BigDecimal cyzDistCharge 
			 */
			public void setCyzDistCharge(BigDecimal cyzDistCharge){
				this.cyzDistCharge = cyzDistCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司承担线上活动费
			 * @return BigDecimal this.activitiesSubsidyBycompany
			 */
			public BigDecimal getActivitiesSubsidyBycompany(){
				return this.activitiesSubsidyBycompany;
			}
			
			/**
			 * 设置 公司承担线上活动费
			 * @param BigDecimal activitiesSubsidyBycompany 
			 */
			public void setActivitiesSubsidyBycompany(BigDecimal activitiesSubsidyBycompany){
				this.activitiesSubsidyBycompany = activitiesSubsidyBycompany;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台承担线上活动费
			 * @return BigDecimal this.platformActivitiesCharge
			 */
			public BigDecimal getPlatformActivitiesCharge(){
				return this.platformActivitiesCharge;
			}
			
			/**
			 * 设置 平台承担线上活动费
			 * @param BigDecimal platformActivitiesCharge 
			 */
			public void setPlatformActivitiesCharge(BigDecimal platformActivitiesCharge){
				this.platformActivitiesCharge = platformActivitiesCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台服务费
			 * @return BigDecimal this.platformServiceCharge
			 */
			public BigDecimal getPlatformServiceCharge(){
				return this.platformServiceCharge;
			}
			
			/**
			 * 设置 平台服务费
			 * @param BigDecimal platformServiceCharge 
			 */
			public void setPlatformServiceCharge(BigDecimal platformServiceCharge){
				this.platformServiceCharge = platformServiceCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 产品销售金额
			 * @return BigDecimal this.productSaleAmount
			 */
			public String getProductSaleAmount(){
				return this.productSaleAmount;
			}
			
			/**
			 * 设置 产品销售金额
			 * @param String productSaleAmount 
			 */
			public void setProductSaleAmount(String productSaleAmount){
				this.productSaleAmount = productSaleAmount;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 应收平台结算金额
			 * @return String this.amountReceivable
			 */
			public String getAmountReceivable(){
				return this.amountReceivable;
			}
			
			/**
			 * 设置 应收平台结算金额
			 * @param BigDecimal amountReceivable 
			 */
			public void setAmountReceivable(String amountReceivable){
				this.amountReceivable = amountReceivable;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 结算比例
			 * @return BigDecimal this.orderSaleRate
			 */
			public BigDecimal getOrderSaleRate(){
				return this.orderSaleRate;
			}
			
			/**
			 * 设置 结算比例
			 * @param BigDecimal orderSaleRate 
			 */
			public void setOrderSaleRate(BigDecimal orderSaleRate){
				this.orderSaleRate = orderSaleRate;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 (结算比例)*结算金额
			 * @return String this.amountRatePayable
			 */
			public String getAmountRatePayable(){
				return this.amountRatePayable;
			}
			
			/**
			 * 设置 (结算比例)*结算金额
			 * @param BigDecimal amountRatePayable 
			 */
			public void setAmountRatePayable(String amountRatePayable){
				this.amountRatePayable = amountRatePayable;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 应付店铺结算金额
			 * @return BigDecimal this.amountPayable
			 */
			public String getAmountPayable(){
				return this.amountPayable;
			}
			
			/**
			 * 设置 应付店铺结算金额
			 * @param String amountPayable 
			 */
			public void setAmountPayable(String amountPayable){
				this.amountPayable = amountPayable;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收入(公司收取店铺服务费)
			 * @return BigDecimal this.cyzServiceCharge
			 */
			public String getCyzServiceCharge(){
				return this.cyzServiceCharge;
			}
			
			/**
			 * 设置 公司收入(公司收取店铺服务费)
			 * @param BigDecimal cyzServiceCharge 
			 */
			public void setCyzServiceCharge(String cyzServiceCharge){
				this.cyzServiceCharge = cyzServiceCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收入(工厂应收)
			 * @return BigDecimal this.cyzServiceChargeIndustryPart
			 */
			public String getCyzServiceChargeIndustryPart(){
				return this.cyzServiceChargeIndustryPart;
			}
			
			/**
			 * 设置 公司收入(工厂应收)
			 * @param String cyzServiceChargeIndustryPart 
			 */
			public void setCyzServiceChargeIndustryPart(String cyzServiceChargeIndustryPart){
				this.cyzServiceChargeIndustryPart = cyzServiceChargeIndustryPart;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收入(运营应收)
			 * @return String this.cyzServiceChargeOperaPart
			 */
			public String getCyzServiceChargeOperaPart(){
				return this.cyzServiceChargeOperaPart;
			}
			
			/**
			 * 设置 公司收入(运营应收)
			 * @param BigDecimal cyzServiceChargeOperaPart 
			 */
			public void setCyzServiceChargeOperaPart(String cyzServiceChargeOperaPart){
				this.cyzServiceChargeOperaPart = cyzServiceChargeOperaPart;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 自配送实际支付金额
			 * @return BigDecimal this.actualMerchantDistCharge
			 */
			public BigDecimal getActualMerchantDistCharge(){
				return this.actualMerchantDistCharge;
			}
			
			/**
			 * 设置 自配送实际支付金额
			 * @param BigDecimal actualMerchantDistCharge 
			 */
			public void setActualMerchantDistCharge(BigDecimal actualMerchantDistCharge){
				this.actualMerchantDistCharge = actualMerchantDistCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 销售毛利
			 * @return BigDecimal this.saleGrossProfit
			 */
			public String getSaleGrossProfit(){
				return this.saleGrossProfit;
			}
			
			/**
			 * 设置 销售毛利
			 * @param BigDecimal saleGrossProfit 
			 */
			public void setSaleGrossProfit(String saleGrossProfit){
				this.saleGrossProfit = saleGrossProfit;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 毛利率
			 * @return String this.saleGrossProfitRate
			 */
			public String getSaleGrossProfitRate(){
				return this.saleGrossProfitRate;
			}
			
			/**
			 * 设置 毛利率
			 * @param String saleGrossProfitRate 
			 */
			public void setSaleGrossProfitRate(String saleGrossProfitRate){
				this.saleGrossProfitRate = saleGrossProfitRate;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 自配送金额单价
			 * @return BigDecimal this.distPrice
			 */
			public BigDecimal getDistPrice(){
				return this.distPrice;
			}
			
			/**
			 * 设置 自配送金额单价
			 * @param BigDecimal distPrice 
			 */
			public void setDistPrice(BigDecimal distPrice){
				this.distPrice = distPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 自配送金额
			 * @return BigDecimal this.distAll
			 */
			public BigDecimal getDistAll(){
				return this.distAll;
			}
			
			/**
			 * 设置 自配送金额
			 * @param BigDecimal distAll 
			 */
			public void setDistAll(BigDecimal distAll){
				this.distAll = distAll;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 自配送补差
			 * @return BigDecimal this.distDiff
			 */
			public BigDecimal getDistDiff(){
				return this.distDiff;
			}
			
			/**
			 * 设置 自配送补差
			 * @param BigDecimal distDiff 
			 */
			public void setDistDiff(BigDecimal distDiff){
				this.distDiff = distDiff;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 对外支付饿了么平台补贴服务费
			 * @return BigDecimal this.serviceAll
			 */
			public String getServiceAll(){
				return this.serviceAll;
			}
			
			/**
			 * 设置 对外支付饿了么平台补贴服务费
			 * @param BigDecimal serviceAll 
			 */
			public void setServiceAll(String serviceAll){
				this.serviceAll = serviceAll;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 实际运营毛利
			 * @return BigDecimal this.profitAll
			 */
			public String getProfitAll(){
				return this.profitAll;
			}
			
			/**
			 * 设置 实际运营毛利
			 * @param BigDecimal profitAll 
			 */
			public void setProfitAll(String profitAll){
				this.profitAll = profitAll;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 竞价费用+短信推广
			 * @return BigDecimal this.otherAll
			 */
			public BigDecimal getOtherAll(){
				return this.otherAll;
			}
			
			/**
			 * 设置 竞价费用+短信推广
			 * @param BigDecimal otherAll 
			 */
			public void setOtherAll(BigDecimal otherAll){
				this.otherAll = otherAll;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 底价
			 * @return BigDecimal this.allbasePrice
			 */
			public BigDecimal getAllbasePrice(){
				return this.allbasePrice;
			}
			
			/**
			 * 设置 底价
			 * @param BigDecimal allbasePrice 
			 */
			public void setAllbasePrice(BigDecimal allbasePrice){
				this.allbasePrice = allbasePrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 其他底价
			 * @return BigDecimal this.allotherBasePrice
			 */
			public BigDecimal getAllotherBasePrice(){
				return this.allotherBasePrice;
			}
			
			/**
			 * 设置 其他底价
			 * @param BigDecimal allotherBasePrice 
			 */
			public void setAllotherBasePrice(BigDecimal allotherBasePrice){
				this.allotherBasePrice = allotherBasePrice;
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

			public BigDecimal getActualPrice() {
				return actualPrice;
			}

			public void setActualPrice(BigDecimal actualPrice) {
				this.actualPrice = actualPrice;
			}

			public BigDecimal getElmSpecialOffer() {
				return elmSpecialOffer;
			}

			public void setElmSpecialOffer(BigDecimal elmSpecialOffer) {
				this.elmSpecialOffer = elmSpecialOffer;
			}

			public BigDecimal getBdSpecialOffer() {
				return bdSpecialOffer;
			}

			public void setBdSpecialOffer(BigDecimal bdSpecialOffer) {
				this.bdSpecialOffer = bdSpecialOffer;
			}

			public BigDecimal getMtSpecialOffer() {
				return mtSpecialOffer;
			}

			public void setMtSpecialOffer(BigDecimal mtSpecialOffer) {
				this.mtSpecialOffer = mtSpecialOffer;
			}

			public BigDecimal getElmActualPrice() {
				return elmActualPrice;
			}

			public void setElmActualPrice(BigDecimal elmActualPrice) {
				this.elmActualPrice = elmActualPrice;
			}

			public BigDecimal getBdActualPrice() {
				return bdActualPrice;
			}

			public void setBdActualPrice(BigDecimal bdActualPrice) {
				this.bdActualPrice = bdActualPrice;
			}

			public BigDecimal getMtActualPrice() {
				return mtActualPrice;
			}

			public void setMtActualPrice(BigDecimal mtActualPrice) {
				this.mtActualPrice = mtActualPrice;
			}

			public BigDecimal getElmRecieveAdjust() {
				return elmRecieveAdjust;
			}

			public void setElmRecieveAdjust(BigDecimal elmRecieveAdjust) {
				this.elmRecieveAdjust = elmRecieveAdjust;
			}

			public BigDecimal getBdRecieveAdjust() {
				return bdRecieveAdjust;
			}

			public void setBdRecieveAdjust(BigDecimal bdRecieveAdjust) {
				this.bdRecieveAdjust = bdRecieveAdjust;
			}

			public BigDecimal getMtRecieveAdjust() {
				return mtRecieveAdjust;
			}

			public void setMtRecieveAdjust(BigDecimal mtRecieveAdjust) {
				this.mtRecieveAdjust = mtRecieveAdjust;
			}

			public BigDecimal getElmSettlement() {
				return elmSettlement;
			}

			public void setElmSettlement(BigDecimal elmSettlement) {
				this.elmSettlement = elmSettlement;
			}

			public BigDecimal getBdSettlement() {
				return bdSettlement;
			}

			public void setBdSettlement(BigDecimal bdSettlement) {
				this.bdSettlement = bdSettlement;
			}

			public BigDecimal getMtSettlement() {
				return mtSettlement;
			}

			public void setMtSettlement(BigDecimal mtSettlement) {
				this.mtSettlement = mtSettlement;
			}

			public BigDecimal getSettlement() {
				return settlement;
			}

			public void setSettlement(BigDecimal settlement) {
				this.settlement = settlement;
			}

			public BigDecimal getElmMealFee() {
				return elmMealFee;
			}

			public void setElmMealFee(BigDecimal elmMealFee) {
				this.elmMealFee = elmMealFee;
			}

			public BigDecimal getBdMealFee() {
				return bdMealFee;
			}

			public void setBdMealFee(BigDecimal bdMealFee) {
				this.bdMealFee = bdMealFee;
			}

			public BigDecimal getMtMealFee() {
				return mtMealFee;
			}

			public void setMtMealFee(BigDecimal mtMealFee) {
				this.mtMealFee = mtMealFee;
			}
		   		
		
		
			
			}