package com.cyz.staticsystem.basic.model;

import java.util.Date;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：餐饮品牌模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class Brand extends Model{
	
	
            /**
             * 品牌ID(主键)
             **/
		   			private String brandId;
   		
            /**
             * 品牌名称
             **/
		   			private String brandName;
   		
            /**
             * 品牌负责人
             **/
		   			private String brandManager;
   		
            /**
             * 负责人电话
             **/
		   			private String brandManagerTel;
   		
            /**
             * 门店数量
             **/
		   			private Integer storesNumber;
   		
            /**
             * 所在省份
             **/
		   			private String provinceCode;
   		
            /**
             * 所在地市
             **/
		   			private String regionCode;
   		
            /**
             * 所在区县
             **/
		   			private String cityCode;
   		
            /**
             * 行业ID
             **/
		   			private String industryId;
		   			private String industryName;
   		
            /**
             * 品类ID
             **/
		   			private String categoryId;
		   			private String categoryName;
   		
            /**
             * 对接人
             **/
		   			private String contactName;
   		
            /**
             * 负责人电话
             **/
		   			private String contactTel;
   		
            /**
             * 招商人
             **/
		   			private String merchantName;
   		
            /**
             * 招商人电话
             **/
		   			private String merchantTel;
   		
            /**
             * 合同签订时间
             **/
			@DateTimeFormat(pattern="yyyy-MM-dd") 
					private Date signContractDate;

            /**
             * 创建时间
             **/
			@DateTimeFormat(pattern="yyyy-MM-dd") 
					private Date createDate;
		
	
				
  			/**
			 * 获取 品牌ID(主键)
			 * @return String this.brandId
			 */
			public String getBrandId(){
				return this.brandId;
			}
			
			/**
			 * 设置 品牌ID(主键)
			 * @param String brandId 
			 */
			public void setBrandId(String brandId){
				this.brandId = brandId;
			}
		   		
		
		
			
						
  			/**
			 * 获取 品牌名称
			 * @return String this.brandName
			 */
			public String getBrandName(){
				return this.brandName;
			}
			
			/**
			 * 设置 品牌名称
			 * @param String brandName 
			 */
			public void setBrandName(String brandName){
				this.brandName = brandName;
			}
						
  			/**
			 * 获取 品牌负责人
			 * @return String this.brandManager
			 */
			public String getBrandManager(){
				return this.brandManager;
			}
			
			/**
			 * 设置 品牌负责人
			 * @param String brandManager 
			 */
			public void setBrandManager(String brandManager){
				this.brandManager = brandManager;
			}
		   		
		
		
			
						
  			/**
			 * 获取 负责人电话
			 * @return String this.brandManagerTel
			 */
			public String getBrandManagerTel(){
				return this.brandManagerTel;
			}
			
			/**
			 * 设置 负责人电话
			 * @param String brandManagerTel 
			 */
			public void setBrandManagerTel(String brandManagerTel){
				this.brandManagerTel = brandManagerTel;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 门店数量
			 * @return Integer this.storesNumber
			 */
			public Integer getStoresNumber(){
				return this.storesNumber;
			}
			
			/**
			 * 设置 门店数量
			 * @param BigDecimal storesNumber 
			 */
			public void setStoresNumber(Integer storesNumber){
				this.storesNumber = storesNumber;
			}
		  		
		
		
			
						
		  			/**
			 * 获取 所在省份
			 * @return String this.provinceCode
			 */
			public String getProvinceCode(){
				return this.provinceCode;
			}
			
			/**
			 * 设置 所在省份
			 * @param String provinceCode 
			 */
			public void setProvinceCode(String provinceCode){
				this.provinceCode = provinceCode;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 所在地市
			 * @return String this.regionCode
			 */
			public String getRegionCode(){
				return this.regionCode;
			}
			
			/**
			 * 设置 所在地市
			 * @param String regionCode 
			 */
			public void setRegionCode(String regionCode){
				this.regionCode = regionCode;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 所在区县
			 * @return String this.cityCode
			 */
			public String getCityCode(){
				return this.cityCode;
			}
			
			/**
			 * 设置 所在区县
			 * @param String cityCode 
			 */
			public void setCityCode(String cityCode){
				this.cityCode = cityCode;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 行业ID
			 * @return String this.industryId
			 */
			public String getIndustryId(){
				return this.industryId;
			}
			
			/**
			 * 设置 行业ID
			 * @param String industryId 
			 */
			public void setIndustryId(String industryId){
				this.industryId = industryId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 品类ID
			 * @return String this.categoryId
			 */
			public String getCategoryId(){
				return this.categoryId;
			}
			
			/**
			 * 设置 品类ID
			 * @param String categoryId 
			 */
			public void setCategoryId(String categoryId){
				this.categoryId = categoryId;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 对接人
			 * @return String this.contactName
			 */
			public String getContactName(){
				return this.contactName;
			}
			
			/**
			 * 设置 对接人
			 * @param String contactName 
			 */
			public void setContactName(String contactName){
				this.contactName = contactName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 负责人电话
			 * @return String this.contactTel
			 */
			public String getContactTel(){
				return this.contactTel;
			}
			
			/**
			 * 设置 负责人电话
			 * @param String contactTel 
			 */
			public void setContactTel(String contactTel){
				this.contactTel = contactTel;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 招商人
			 * @return String this.merchantName
			 */
			public String getMerchantName(){
				return this.merchantName;
			}
			
			/**
			 * 设置 招商人
			 * @param String merchantName 
			 */
			public void setMerchantName(String merchantName){
				this.merchantName = merchantName;
			}
		   		
		
		
			
						
		  			/**
			 * 获取 招商人电话
			 * @return String this.merchantTel
			 */
			public String getMerchantTel(){
				return this.merchantTel;
			}
			
			/**
			 * 设置 招商人电话
			 * @param String merchantTel 
			 */
			public void setMerchantTel(String merchantTel){
				this.merchantTel = merchantTel;
			}
		   		
		
		
			
								/**
			 * 获取 合同签订时间
			 * @return Date this.signContractDate
			 */
			public Date getSignContractDate(){
				return this.signContractDate;
			}
			
			/**
			 * 设置 合同签订时间
			 * @param Date signContractDate 
			 */
			public void setSignContractDate(Date signContractDate){
				this.signContractDate = signContractDate;
			}
								/**
			 * 获取 创建时间
			 * @return Date this.createDate
			 */
			public Date getCreateDate(){
				return this.createDate;
			}
			
			/**
			 * 设置 创建时间
			 * @param Date createDate 
			 */
			public void setCreateDate(Date createDate){
				this.createDate = createDate;
			}

			public String getIndustryName() {
				return industryName;
			}

			public void setIndustryName(String industryName) {
				this.industryName = industryName;
			}

			public String getCategoryName() {
				return categoryName;
			}

			public void setCategoryName(String categoryName) {
				this.categoryName = categoryName;
			}
			}