package com.cyz.staticsystem.finance.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：财务对账模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-23
 */
public class AccountCheck extends Model{
	
	
		            /**
	                 * 主键
	                 **/
			   				private String id;
		   		
		            /**
	                 * 结算日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date accountTime;
		
		            /**
	                 * 饿了吗结算款
	                 **/
				   			private BigDecimal elmSettlement;
		   		
		            /**
	                 * 百度结算款
	                 **/
				   			private BigDecimal baiduSettlement;
		   		
		            /**
	                 * 美团结算款
	                 **/
				   			private BigDecimal meituanSettlement;
		   		
		            /**
	                 * 合计结算金额
	                 **/
				   			private BigDecimal totalSettlement;
		   		
		            /**
	                 * 饿了么扣回金额
	                 **/
				   			private String elmCost;
		   		
		            /**
	                 * 百度扣回金额
	                 **/
				   			private BigDecimal baiduCost;
		   		
		            /**
	                 * 美团扣回金额
	                 **/
				   			private BigDecimal meituanCost;
		   		
		            /**
	                 * 实际应结算金额
	                 **/
				   			private String actualSettlement;
		   		
		            /**
	                 * 备注
	                 **/
				   			private String remark;
		   		
		            /**
	                 * 店铺ID
	                 **/
				   			private String storeId;
				   			private String storeName;
		   		
	
				
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
			 * 获取 结算日期
			 * @return Date this.accountTime
			 */
			public Date getAccountTime(){
				return this.accountTime;
			}
			
			/**
			 * 设置 结算日期
			 * @param Date accountTime 
			 */
			public void setAccountTime(Date accountTime){
				this.accountTime = accountTime;
			}
						
		  			/**
			 * 获取 饿了吗结算款
			 * @return BigDecimal this.elmSettlement
			 */
			public BigDecimal getElmSettlement(){
				return this.elmSettlement;
			}
			
			/**
			 * 设置 饿了吗结算款
			 * @param String elmSettlement 
			 */
			public void setElmSettlement(BigDecimal elmSettlement){
				this.elmSettlement = elmSettlement;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 百度结算款
			 * @return BigDecimal this.baiduSettlement
			 */
			public BigDecimal getBaiduSettlement(){
				return this.baiduSettlement;
			}
			
			/**
			 * 设置 百度结算款
			 * @param String baiduSettlement 
			 */
			public void setBaiduSettlement(BigDecimal baiduSettlement){
				this.baiduSettlement = baiduSettlement;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 美团结算款
			 * @return BigDecimal this.meituanSettlement
			 */
			public BigDecimal getMeituanSettlement(){
				return this.meituanSettlement;
			}
			
			/**
			 * 设置 美团结算款
			 * @param String meituanSettlement 
			 */
			public void setMeituanSettlement(BigDecimal meituanSettlement){
				this.meituanSettlement = meituanSettlement;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 合计结算金额
			 * @return BigDecimal this.totalSettlement
			 */
			public BigDecimal getTotalSettlement(){
				return this.totalSettlement;
			}
			
			/**
			 * 设置 合计结算金额
			 * @param String totalSettlement 
			 */
			public void setTotalSettlement(BigDecimal totalSettlement){
				this.totalSettlement = totalSettlement;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 饿了么扣回金额
			 * @return String this.elmCost
			 */
			public String getElmCost(){
				return this.elmCost;
			}
			
			/**
			 * 设置 饿了么扣回金额
			 * @param String elmCost 
			 */
			public void setElmCost(String elmCost){
				this.elmCost = elmCost;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 百度扣回金额
			 * @return BigDecimal this.baiduCost
			 */
			public BigDecimal getBaiduCost(){
				return this.baiduCost;
			}
			
			/**
			 * 设置 百度扣回金额
			 * @param String baiduCost 
			 */
			public void setBaiduCost(BigDecimal baiduCost){
				this.baiduCost = baiduCost;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 美团扣回金额
			 * @return BigDecimal this.meituanCost
			 */
			public BigDecimal getMeituanCost(){
				return this.meituanCost;
			}
			
			/**
			 * 设置 美团扣回金额
			 * @param String meituanCost 
			 */
			public void setMeituanCost(BigDecimal meituanCost){
				this.meituanCost = meituanCost;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 实际应结算金额
			 * @return String this.actualSettlement
			 */
			public String getActualSettlement(){
				return this.actualSettlement;
			}
			
			/**
			 * 设置 实际应结算金额
			 * @param String actualSettlement 
			 */
			public void setActualSettlement(String actualSettlement){
				this.actualSettlement = actualSettlement;
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

			public String getStoreName() {
				return storeName;
			}

			public void setStoreName(String storeName) {
				this.storeName = storeName;
			}
		   		
		
		
			
			}