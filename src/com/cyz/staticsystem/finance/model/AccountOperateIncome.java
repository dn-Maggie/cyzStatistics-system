package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import java.sql.Timestamp;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：运营数据模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-03-05
 */
public class AccountOperateIncome extends Model{
	
	
		            /**
	                 * 主键
	                 **/
				   			private String id;
		   		
		            /**
	                 * 日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date createDate;
		
		            /**
	                 * 订单时点
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss") 
							private Timestamp createTime;
					
		            /**
	                 * 订单编号
	                 **/
				   			private String orderNo;
		   		
		            /**
	                 * 原价
	                 **/
				   			private BigDecimal orginPrice;
		   		
		            /**
	                 * 菜品折扣
	                 **/
				   			private BigDecimal discountPrice;
		   		
		            /**
	                 * 折扣后菜价格
	                 **/
				   			private BigDecimal afterDiscountPrice;
		   		
		            /**
	                 * 实际结算折扣菜金额
	                 **/
				   			private BigDecimal actualPrice;
				   			private BigDecimal specialOffer;
		   		
		            /**
	                 * 订单上收取客户配送费
	                 **/
				   			private BigDecimal orderDistributionCharge;
		   		
		            /**
	                 * 平台收取客户配送费
	                 **/
				   			private BigDecimal platformDistributionCharge;
		   		
		            /**
	                 * 公司收取客户配送费
	                 **/
				   			private BigDecimal cyzDistributionCharge;
		   		
		            /**
	                 * 无效单
	                 **/
				   			private Integer invalidNum;
		   		
		            /**
	                 * 有效单
	                 **/
				   			private Integer validNum;
		   		
		            /**
	                 * 产品销售金额
	                 **/
				   			private BigDecimal productSaleAmount;
		   		
		            /**
	                 * 应收平台结算金额
	                 **/
				   			private BigDecimal amountReceivable;
		   		
		            /**
	                 * 70%结算金额
	                 **/
				   			private BigDecimal seventypProductSaleAmount;
		   		
		            /**
	                 * 折扣菜退还佣金
	                 **/
				   			private BigDecimal discountBackCommission;
		   		
		            /**
	                 * 应付店铺结算金额
	                 **/
				   			private BigDecimal amountPayable;
		   		
		            /**
	                 * 公司收取店铺服务费
	                 **/
				   			private BigDecimal cyzServiceCharge;
		   		
		            /**
	                 * 公司承担线上活动费
	                 **/
				   			private BigDecimal cyzActivitiesCharge;
		   		
		            /**
	                 * 公司收入
	                 **/
				   			private BigDecimal cyzAllIncome;
		   		
		            /**
	                 * 销售毛利
	                 **/
				   			private BigDecimal saleGrossProfit;
				   			private BigDecimal actualProfit;
		   		
		            /**
	                 * 毛利率
	                 **/
				   			private String saleGrossProfitRate;
		   		
		            /**
	                 * 自配送实际支付金额
	                 **/
				   			private BigDecimal distributionActualPayment;
		   		
		            /**
	                 * 平台承担线上活动费
	                 **/
				   			private BigDecimal platformActivitiesCharge;
		   		
		            /**
	                 * 平台服务费
	                 **/
				   			private BigDecimal platformServiceCharge;
		   		
		            /**
	                 * 应收取自配送金额
	                 **/
				   			private BigDecimal shouldDistributionCharge;
		   		
		            /**
	                 * 实际按10元/单自配送金额
	                 **/
				   			private BigDecimal cyzDistributionChargeActual;
		   		
		            /**
	                 * 按10元/单自配送金额补差
	                 **/
				   			private BigDecimal diffDistributionCharge;
		   		
		            /**
	                 * 平台补贴
	                 **/
				   			private BigDecimal platformSubsidy;
		   		
		            /**
	                 * 平台类型
	                 **/
				   			private String platformType;
		   		
		            /**
	                 * 店铺ID
	                 **/
				   			private String storeId;
				   			private String storeName;
				   			private String storeType;
				   			private String storeWorkTime;
				   			private String remark;
				
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
			 * 获取 订单时点
			 * @return Date this.createTime
			 */
			public Timestamp getCreateTime(){
				return this.createTime;
			}
			
			/**
			 * 设置 订单时点
			 * @param Date createTime 
			 */
			public void setCreateTime(Timestamp createTime){
				this.createTime = createTime;
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
			 * 获取 原价
			 * @return String this.orginPrice
			 */
			public BigDecimal getOrginPrice(){
				return this.orginPrice;
			}
			
			/**
			 * 设置 原价
			 * @param String orginPrice 
			 */
			public void setOrginPrice(BigDecimal orginPrice){
				this.orginPrice = orginPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 菜品折扣
			 * @return BigDecimal this.discountPrice
			 */
			public BigDecimal getDiscountPrice(){
				return this.discountPrice;
			}
			
			/**
			 * 设置 菜品折扣
			 * @param BigDecimal discountPrice 
			 */
			public void setDiscountPrice(BigDecimal discountPrice){
				this.discountPrice = discountPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 折扣后菜价格
			 * @return BigDecimal this.afterDiscountPrice
			 */
			public BigDecimal getAfterDiscountPrice(){
				return this.afterDiscountPrice;
			}
			
			/**
			 * 设置 折扣后菜价格
			 * @param BigDecimal afterDiscountPrice 
			 */
			public void setAfterDiscountPrice(BigDecimal afterDiscountPrice){
				this.afterDiscountPrice = afterDiscountPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 实际结算折扣菜金额
			 * @return BigDecimal this.actualPrice
			 */
			public BigDecimal getActualPrice(){
				return this.actualPrice;
			}
			
			/**
			 * 设置 实际结算折扣菜金额
			 * @param BigDecimal actualPrice 
			 */
			public void setActualPrice(BigDecimal actualPrice){
				this.actualPrice = actualPrice;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 订单上收取客户配送费
			 * @return BigDecimal this.orderDistributionCharge
			 */
			public BigDecimal getOrderDistributionCharge(){
				return this.orderDistributionCharge;
			}
			
			/**
			 * 设置 订单上收取客户配送费
			 * @param BigDecimal orderDistributionCharge 
			 */
			public void setOrderDistributionCharge(BigDecimal orderDistributionCharge){
				this.orderDistributionCharge = orderDistributionCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台收取客户配送费
			 * @return BigDecimal this.platformDistributionCharge
			 */
			public BigDecimal getPlatformDistributionCharge(){
				return this.platformDistributionCharge;
			}
			
			/**
			 * 设置 平台收取客户配送费
			 * @param BigDecimal platformDistributionCharge 
			 */
			public void setPlatformDistributionCharge(BigDecimal platformDistributionCharge){
				this.platformDistributionCharge = platformDistributionCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收取客户配送费
			 * @return BigDecimal this.cyzDistributionCharge
			 */
			public BigDecimal getCyzDistributionCharge(){
				return this.cyzDistributionCharge;
			}
			
			/**
			 * 设置 公司收取客户配送费
			 * @param BigDecimal cyzDistributionCharge 
			 */
			public void setCyzDistributionCharge(BigDecimal cyzDistributionCharge){
				this.cyzDistributionCharge = cyzDistributionCharge;
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
			 * 获取 产品销售金额
			 * @return BigDecimal this.productSaleAmount
			 */
			public BigDecimal getProductSaleAmount(){
				return this.productSaleAmount;
			}
			
			/**
			 * 设置 产品销售金额
			 * @param BigDecimal productSaleAmount 
			 */
			public void setProductSaleAmount(BigDecimal productSaleAmount){
				this.productSaleAmount = productSaleAmount;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 应收平台结算金额
			 * @return BigDecimal this.amountReceivable
			 */
			public BigDecimal getAmountReceivable(){
				return this.amountReceivable;
			}
			
			/**
			 * 设置 应收平台结算金额
			 * @param BigDecimal amountReceivable 
			 */
			public void setAmountReceivable(BigDecimal amountReceivable){
				this.amountReceivable = amountReceivable;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 70%结算金额
			 * @return BigDecimal this.seventypProductSaleAmount
			 */
			public BigDecimal getSeventypProductSaleAmount(){
				return this.seventypProductSaleAmount;
			}
			
			/**
			 * 设置 70%结算金额
			 * @param BigDecimal seventypProductSaleAmount 
			 */
			public void setSeventypProductSaleAmount(BigDecimal seventypProductSaleAmount){
				this.seventypProductSaleAmount = seventypProductSaleAmount;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 折扣菜退还佣金
			 * @return BigDecimal this.discountBackCommission
			 */
			public BigDecimal getDiscountBackCommission(){
				return this.discountBackCommission;
			}
			
			/**
			 * 设置 折扣菜退还佣金
			 * @param BigDecimal discountBackCommission 
			 */
			public void setDiscountBackCommission(BigDecimal discountBackCommission){
				this.discountBackCommission = discountBackCommission;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 应付店铺结算金额
			 * @return BigDecimal this.amountPayable
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
			 * 获取 公司收取店铺服务费
			 * @return BigDecimal this.cyzServiceCharge
			 */
			public BigDecimal getCyzServiceCharge(){
				return this.cyzServiceCharge;
			}
			
			/**
			 * 设置 公司收取店铺服务费
			 * @param BigDecimal cyzServiceCharge 
			 */
			public void setCyzServiceCharge(BigDecimal cyzServiceCharge){
				this.cyzServiceCharge = cyzServiceCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司承担线上活动费
			 * @return BigDecimal this.cyzActivitiesCharge
			 */
			public BigDecimal getCyzActivitiesCharge(){
				return this.cyzActivitiesCharge;
			}
			
			/**
			 * 设置 公司承担线上活动费
			 * @param BigDecimal cyzActivitiesCharge 
			 */
			public void setCyzActivitiesCharge(BigDecimal cyzActivitiesCharge){
				this.cyzActivitiesCharge = cyzActivitiesCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 公司收入
			 * @return BigDecimal this.cyzAllIncome
			 */
			public BigDecimal getCyzAllIncome(){
				return this.cyzAllIncome;
			}
			
			/**
			 * 设置 公司收入
			 * @param BigDecimal cyzAllIncome 
			 */
			public void setCyzAllIncome(BigDecimal cyzAllIncome){
				this.cyzAllIncome = cyzAllIncome;
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
			 * 获取 自配送实际支付金额
			 * @return BigDecimal this.distributionActualPayment
			 */
			public BigDecimal getDistributionActualPayment(){
				return this.distributionActualPayment;
			}
			
			/**
			 * 设置 自配送实际支付金额
			 * @param BigDecimal distributionActualPayment 
			 */
			public void setDistributionActualPayment(BigDecimal distributionActualPayment){
				this.distributionActualPayment = distributionActualPayment;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台承担线上活动费
			 * @return String this.platformActivitiesCharge
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
			 * 获取 应收取自配送金额
			 * @return BigDecimal this.shouldDistributionCharge
			 */
			public BigDecimal getShouldDistributionCharge(){
				return this.shouldDistributionCharge;
			}
			
			/**
			 * 设置 应收取自配送金额
			 * @param String shouldDistributionCharge 
			 */
			public void setShouldDistributionCharge(BigDecimal shouldDistributionCharge){
				this.shouldDistributionCharge = shouldDistributionCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 实际按10元/单自配送金额
			 * @return BigDecimal this.cyzDistributionChargeActual
			 */
			public BigDecimal getCyzDistributionChargeActual(){
				return this.cyzDistributionChargeActual;
			}
			
			/**
			 * 设置 实际按10元/单自配送金额
			 * @param String cyzDistributionChargeActual 
			 */
			public void setCyzDistributionChargeActual(BigDecimal cyzDistributionChargeActual){
				this.cyzDistributionChargeActual = cyzDistributionChargeActual;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 按10元/单自配送金额补差
			 * @return BigDecimal this.diffDistributionCharge
			 */
			public BigDecimal getDiffDistributionCharge(){
				return this.diffDistributionCharge;
			}
			
			/**
			 * 设置 按10元/单自配送金额补差
			 * @param String diffDistributionCharge 
			 */
			public void setDiffDistributionCharge(BigDecimal diffDistributionCharge){
				this.diffDistributionCharge = diffDistributionCharge;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 平台补贴
			 * @return BigDecimal this.platformSubsidy
			 */
			public BigDecimal getPlatformSubsidy(){
				return this.platformSubsidy;
			}
			
			/**
			 * 设置 平台补贴
			 * @param String platformSubsidy 
			 */
			public void setPlatformSubsidy(BigDecimal platformSubsidy){
				this.platformSubsidy = platformSubsidy;
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

			public BigDecimal getActualProfit() {
				return actualProfit;
			}

			public void setActualProfit(BigDecimal actualProfit) {
				this.actualProfit = actualProfit;
			}

			public String getStoreName() {
				return storeName;
			}

			public void setStoreName(String storeName){
				this.storeName = storeName;
			}

			public String getStoreType() {
				return storeType;
			}

			public void setStoreType(String storeType) {
				this.storeType = storeType;
			}

			public String getStoreWorkTime() {
				return storeWorkTime;
			}

			public void setStoreWorkTime(String storeWorkTime) {
				this.storeWorkTime = storeWorkTime;
			}

			public String getRemark() {
				return remark;
			}

			public void setRemark(String remark) {
				this.remark = remark;
			}

			public BigDecimal getSpecialOffer() {
				return specialOffer;
			}

			public void setSpecialOffer(BigDecimal specialOffer) {
				this.specialOffer = specialOffer;
			}
		   		
		
		
			
			}