package com.cyz.staticsystem.finance.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：运营合计模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-03-26
 */
public class AccountOperaTotal extends Model{
	
	
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
   			private String brandName;
   			private String storeName;
   			private String storeType;
   			private String storeDistMode;
	
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
     * 平台承担线上活动费
     **/
   			private BigDecimal platformActivitiesCharge;
	
    /**
     * 产品销售金额
     **/
   			private BigDecimal productSaleAmount;
	
    /**
     * 应收平台结算金额
     **/
   			private BigDecimal amountReceivable;
	
    /**
     * 应付店铺结算金额
     **/
   			private BigDecimal amountPayable;
	
    /**
     * 公司收入(公司收取店铺服务费)
     **/
   			private BigDecimal cyzServiceCharge;
	
    /**
     * 自配送实际支付金额
     **/
   			private BigDecimal actualMerchantDistCharge;
	
    /**
     * 销售毛利
     **/
   			private BigDecimal saleGrossProfit;
	
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
   			private BigDecimal serviceAll;
	
    /**
     * 实际运营毛利
     **/
   			private BigDecimal profitAll;
	
    /**
     * 竞价费用+短信推广
     **/
   			private BigDecimal otherAll;
	
    /**
     * 备注
     **/
   			private String remark;
	
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
			* 获取 平台承担线上活动费
			* @return BigDecimal this.platformActivitiesCharge
			*/
			public BigDecimal getPlatformActivitiesCharge(){
			return this.platformActivitiesCharge;
			}
			
			/**
			* 设置 平台承担线上活动费
			* @param String platformActivitiesCharge 
			*/
			public void setPlatformActivitiesCharge(BigDecimal platformActivitiesCharge){
			this.platformActivitiesCharge = platformActivitiesCharge;
			}
				
			
						
						
					
					/**
			* 获取 产品销售金额
			* @return String this.productSaleAmount
			*/
			public BigDecimal getProductSaleAmount(){
			return this.productSaleAmount;
			}
			
			/**
			* 设置 产品销售金额
			* @param String productSaleAmount 
			*/
			public void setProductSaleAmount(BigDecimal productSaleAmount){
			this.productSaleAmount = productSaleAmount;
			}
				
			
			
			
					
					/**
			* 获取 应收平台结算金额
			* @return String this.amountReceivable
			*/
			public BigDecimal getAmountReceivable(){
			return this.amountReceivable;
			}
			
			/**
			* 设置 应收平台结算金额
			* @param String amountReceivable 
			*/
			public void setAmountReceivable(BigDecimal amountReceivable){
			this.amountReceivable = amountReceivable;
			}
				




				
				/**
		* 获取 应付店铺结算金额
		* @return String this.amountPayable
		*/
		public BigDecimal getAmountPayable(){
		return this.amountPayable;
		}
		
		/**
		* 设置 应付店铺结算金额
		* @param BigDecimal amountPayable 
		*/
		public void setAmountPayable(BigDecimal amountPayable){
		this.amountPayable = amountPayable;
		}
			


			
					
					/**
			* 获取 公司收入(公司收取店铺服务费)
			* @return BigDecimal this.cyzServiceCharge
			*/
			public BigDecimal getCyzServiceCharge(){
			return this.cyzServiceCharge;
			}
			
			/**
			* 设置 公司收入(公司收取店铺服务费)
			* @param BigDecimal cyzServiceCharge 
			*/
			public void setCyzServiceCharge(BigDecimal cyzServiceCharge){
			this.cyzServiceCharge = cyzServiceCharge;
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
			public BigDecimal getSaleGrossProfit(){
			return this.saleGrossProfit;
			}
			
			/**
			* 设置 销售毛利
			* @param BigDecimal saleGrossProfit 
			*/
			public void setSaleGrossProfit(BigDecimal saleGrossProfit){
			this.saleGrossProfit = saleGrossProfit;
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
			public BigDecimal getServiceAll(){
			return this.serviceAll;
			}
			
			/**
			* 设置 对外支付饿了么平台补贴服务费
			* @param BigDecimal serviceAll 
			*/
			public void setServiceAll(BigDecimal serviceAll){
			this.serviceAll = serviceAll;
			}
				
			
			

					
					/**
			* 获取 实际运营毛利
			* @return BigDecimal this.profitAll
			*/
			public BigDecimal getProfitAll(){
			return this.profitAll;
			}
			
			/**
			* 设置 实际运营毛利
			* @param BigDecimal profitAll 
			*/
			public void setProfitAll(BigDecimal profitAll){
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

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public String getStoreType() {
			return storeType;
		}

		public void setStoreType(String storeType) {
			this.storeType = storeType;
		}

		public String getStoreDistMode() {
			return storeDistMode;
		}

		public void setStoreDistMode(String storeDistMode) {
			this.storeDistMode = storeDistMode;
		}

	}