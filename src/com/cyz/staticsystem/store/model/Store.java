package com.cyz.staticsystem.store.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cyz.staticsystem.common.bean.Model;
/**
 * 描述：店铺模块实体类，负责页面与后台数据传输功能
 *
 * @author maggie
 * @version 1.0 2017-02-10
 */
public class Store extends Model{
	
					private static final long serialVersionUID = 1L;
					
					/**
				     * 店铺使用者账号
				     **/	private Integer isDelete;//逻辑删除标识
							private String userAccount;
					 /**
				     * 店铺使用者ID
				     **/	private String categoryId;
							private String ownerUserId;
					/**
				     * 店铺使用者组别
				     **/
							private String userGroup;
					/**
				     * 店铺所属商圈
				     **/
							private String businessArea;
		            /**
	                 * 店铺ID(主键)
	                 **/
				   			private String storeId;
				   			private String boundType;
		            /**
	                 * 店铺名称SS
	                 **/
				   			private String storeName;
				   			private String storeType;
				   			private String storeDistMode;
		            /**
	                 * 所属品牌ID
	                 **/
				   			private String brandId;
				   			private String brandName;
		   		
		            /**
	                 * 店铺地址
	                 **/
				   			private String storeAddress;
		   		
		            /**
	                 * 营业时间起
	                 **/
							private String workTimeBegin;
		
		            /**
	                 * 营业时间止
	                 **/
							private String workTimeEnd;
		
		            /**
	                 * 店长姓名
	                 **/
				   			private String storeOwnerName;
		   		
		            /**
	                 * 店长电话
	                 **/
				   			private String storeOwnerTel;
		   		
		            /**
	                 * 是否可以提供发票
	                 **/
				   			private String proInvoiceFlag;
		   		
		            /**
	                 * 备注
	                 **/
				   			private String remark;
		   		
		            /**
	                 * 运营开始时间
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date operateDate;
		
		            /**
	                 * 结算方式
	                 **/
				   			private String settlementMethod;
		   		
		            /**
	                 * 店铺联系电话
	                 **/
				   			private String storeTel;
		   		
		            /**
	                 * 实景图片1
	                 **/
				   			private String realImagePath1;
		   		
		            /**
	                 * 实景图片2
	                 **/
				   			private String realImagePath2;
		   		
		            /**
	                 * 实景图片3
	                 **/
				   			private String realImagePath3;		            
				   	/**
	                 * 大概店铺月销售额
	                 **/
				   			private String averageSales;
		   		
		            /**
	                 * 饿了么平台月销售单量
	                 **/
				   			private String elmSale;
		   		
		            /**
	                 * 美团平台月销售单量
	                 **/	
				   			private String meituanSale;
		   		
		            /**
	                 * 百度平台月销售单量
	                 **/
				   			private String baiduSale;
		   		
		            /**
	                 * 饿了么平台佣金率
	                 **/
				   			private String elmId;
				   			private String elmUsername;
				   			private String elmPwd;
				   			private String elmRate;
		   		
		            /**
	                 * 美团平台佣金率
	                 **/
				   			private String meituanId;
				   			private String meituanPwd;
				   			private String meituanRate;
		   		
		            /**
	                 * 百度平台佣金率
	                 **/
				   			private String baiduId;
				   			private String baidupwd;
				   			private String baiduRate;
		   		
		            /**
	                 * 登记人
	                 **/
				   			private String registrant;
		   		
		            /**
	                 * 登记日期
	                 **/
					@DateTimeFormat(pattern="yyyy-MM-dd") 
							private Date registDate;
		
		   		
		            /**
	                 * 营业执照
	                 **/
				   			private String businessLicenseImg;
		   		
		            /**
	                 * 卫生经营许可证
	                 **/
				   			private String healthLicenseImg;
		   		
		            /**
	                 * 菜单
	                 **/
				   			private String menuImg;
		   		
		            /**
	                 * 法人身份证（正面）
	                 **/
				   			private String corporateIdcardFront;
		   		
		            /**
	                 * 法人身份证（反面）
	                 **/
				   			private String corporateIdcardBack;
		   		
		            /**
	                 * 堂食照
	                 **/
				   			private String canteenImg;
		   		
		            /**
	                 * 后厨照
	                 **/
				   			private String kitchenImg;
		   		
		            /**
	                 * 门头
	                 **/
				   			private String doorImg;
		   		
		            /**
	                 * 法人手持身份证(正）
	                 **/
				   			private String corporateWithidcardFront;
		   		
		            /**
	                 * 法人手持身份证(反)
	                 **/
				   			private String corporateWithidcardBack;
			   		/**
			   		 * 附加项
			   		 */
				   			private String platformType;
							private String username;
							private String password;
							private String shopId;
					/**
					 * 获取 店铺使用者ID
					 */
		  			public String getOwnerUserId() {
						return ownerUserId;
					}
		  			/**
					 * 设置 店铺使用者ID
					 */
					public void setOwnerUserId(String ownerUserId) {
						this.ownerUserId = ownerUserId;
					}

					/**
					 * 获取 店铺ID(主键)
					 * @return String this.storeId
					 */
					public String getStoreId(){
						return this.storeId;
					}
					
					/**
					 * 设置 店铺ID(主键)
					 * @param String storeId 
					 */
					public void setStoreId(String storeId){
						this.storeId = storeId;
					}
					/**
					 * 获取 店铺类型（夜宵、正餐..）
					 * @return String this.storeId
					 */
					public String getStoreType() {
						return storeType;
					}
					/**
					 * 设置 店铺类型（夜宵、正餐..）
					 * @return String this.storeId
					 */
					public void setStoreType(String storeType) {
						this.storeType = storeType;
					}
					/**
					 * 获取 店铺配送方式
					 * @return String this.storeId
					 */
					public String getStoreDistMode() {
						return storeDistMode;
					}
					/**
					 * 设置 店铺配送方式
					 * @return String this.storeId
					 */
					public void setStoreDistMode(String storeDistMode) {
						this.storeDistMode = storeDistMode;
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
			 * 获取 所属品牌ID
			 * @return String this.brandId
			 */
			public String getBrandId(){
				return this.brandId;
			}
			
			/**
			 * 设置 所属品牌ID
			 * @param String brandId 
			 */
			public void setBrandId(String brandId){
				this.brandId = brandId;
			}
  			/**
			 * 获取 店铺地址
			 * @return String this.storeAddress
			 */
			public String getStoreAddress(){
				return this.storeAddress;
			}
			/**
			 * 设置 店铺地址
			 * @param String storeAddress 
			 */
			public void setStoreAddress(String storeAddress){
				this.storeAddress = storeAddress;
			}
			/**
			 * 获取 营业时间起
			 * @return Date this.workTimeBegin
			 */
			public String getWorkTimeBegin(){
				return this.workTimeBegin;
			}
			
			/**
			 * 设置 营业时间起
			 * @param Date workTimeBegin 
			 */
			public void setWorkTimeBegin(String workTimeBegin){
				this.workTimeBegin = workTimeBegin;
			}
			/**
			 * 获取 营业时间起
			 * @return Date this.workTimeEnd
			 */
			public String getWorkTimeEnd(){
				return this.workTimeEnd;
			}
			
			/**
			 * 设置 营业时间起
			 * @param Date workTimeEnd 
			 */
			public void setWorkTimeEnd(String workTimeEnd){
				this.workTimeEnd = workTimeEnd;
			}
						
  			/**
			 * 获取 店长姓名
			 * @return String this.storeOwnerName
			 */
			public String getStoreOwnerName(){
				return this.storeOwnerName;
			}
			
			/**
			 * 设置 店长姓名
			 * @param String storeOwnerName 
			 */
			public void setStoreOwnerName(String storeOwnerName){
				this.storeOwnerName = storeOwnerName;
			}
  			/**
			 * 获取 店长电话
			 * @return String this.storeOwnerTel
			 */
			public String getStoreOwnerTel(){
				return this.storeOwnerTel;
			}
			/**
			 * 设置 店长电话
			 * @param String storeOwnerTel 
			 */
			public void setStoreOwnerTel(String storeOwnerTel){
				this.storeOwnerTel = storeOwnerTel;
			}
  			/**
			 * 获取 是否可以提供发票
			 * @return String this.proInvoiceFlag
			 */
			public String getProInvoiceFlag(){
				return this.proInvoiceFlag;
			}
			
			/**
			 * 设置 是否可以提供发票
			 * @param String proInvoiceFlag 
			 */
			public void setProInvoiceFlag(String proInvoiceFlag){
				this.proInvoiceFlag = proInvoiceFlag;
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
			 * 获取 运营开始时间
			 * @return Date this.operateDate
			 */
			public Date getOperateDate(){
				return this.operateDate;
			}
			/**
			 * 设置 运营开始时间
			 * @param Date operateDate 
			 */
			public void setOperateDate(Date operateDate){
				this.operateDate = operateDate;
			}
						
  			/**
			 * 获取 结算方式
			 * @return String this.settlementMethod
			 */
			public String getSettlementMethod(){
				return this.settlementMethod;
			}
			
			/**
			 * 设置 结算方式
			 * @param String settlementMethod 
			 */
			public void setSettlementMethod(String settlementMethod){
				this.settlementMethod = settlementMethod;
			}
  			/**
			 * 获取 店铺联系电话
			 * @return String this.storeTel
			 */
			public String getStoreTel(){
				return this.storeTel;
			}
			
			/**
			 * 设置 店铺联系电话
			 * @param String storeTel 
			 */
			public void setStoreTel(String storeTel){
				this.storeTel = storeTel;
			}
  			/**
			 * 获取 实景图片1
			 * @return String this.realImagePath1
			 */
			public String getRealImagePath1(){
				return this.realImagePath1;
			}
			/**
			 * 设置 实景图片1
			 * @param String realImagePath1 
			 */
			public void setRealImagePath1(String realImagePath1){
				this.realImagePath1 = realImagePath1;
			}
  			/**
			 * 获取 实景图片2
			 * @return String this.realImagePath2
			 */
			public String getRealImagePath2(){
				return this.realImagePath2;
			}
			
			/**
			 * 设置 实景图片2
			 * @param String realImagePath2 
			 */
			public void setRealImagePath2(String realImagePath2){
				this.realImagePath2 = realImagePath2;
			}
  			/**
			 * 获取 实景图片3
			 * @return String this.realImagePath3
			 */
			public String getRealImagePath3(){
				return this.realImagePath3;
			}
			
			/**
			 * 设置 实景图片3
			 * @param String realImagePath3 
			 */
			public void setRealImagePath3(String realImagePath3){
				this.realImagePath3 = realImagePath3;
			}

			public String getBrandName() {
				return brandName;
			}

			public void setBrandName(String brandName) {
				this.brandName = brandName;
			}

			public String getAverageSales() {
				return averageSales;
			}

			public void setAverageSales(String averageSales) {
				this.averageSales = averageSales;
			}

			public String getElmSale() {
				return elmSale;
			}

			public void setElmSale(String elmSale) {
				this.elmSale = elmSale;
			}

			public String getMeituanSale() {
				return meituanSale;
			}

			public void setMeituanSale(String meituanSale) {
				this.meituanSale = meituanSale;
			}

			public String getBaiduSale() {
				return baiduSale;
			}

			public void setBaiduSale(String baiduSale) {
				this.baiduSale = baiduSale;
			}

			public String getElmRate() {
				return elmRate;
			}

			public void setElmRate(String elmRate) {
				this.elmRate = elmRate;
			}

			public String getElmId() {
				return elmId;
			}

			public void setElmId(String elmId) {
				this.elmId = elmId;
			}

			public String getMeituanRate() {
				return meituanRate;
			}

			public void setMeituanRate(String meituanRate) {
				this.meituanRate = meituanRate;
			}

			public String getMeituanId() {
				return meituanId;
			}

			public void setMeituanId(String meituanId) {
				this.meituanId = meituanId;
			}

			public String getBaiduRate() {
				return baiduRate;
			}

			public void setBaiduRate(String baiduRate) {
				this.baiduRate = baiduRate;
			}

			public String getBaiduId() {
				return baiduId;
			}

			public void setBaiduId(String baiduId) {
				this.baiduId = baiduId;
			}

			public String getRegistrant() {
				return registrant;
			}

			public void setRegistrant(String registrant) {
				this.registrant = registrant;
			}

			public Date getRegistDate() {
				return registDate;
			}

			public void setRegistDate(Date registDate) {
				this.registDate = registDate;
			}


			public String getBusinessLicenseImg() {
				return businessLicenseImg;
			}

			public void setBusinessLicenseImg(String businessLicenseImg) {
				this.businessLicenseImg = businessLicenseImg;
			}

			public String getHealthLicenseImg() {
				return healthLicenseImg;
			}

			public void setHealthLicenseImg(String healthLicenseImg) {
				this.healthLicenseImg = healthLicenseImg;
			}

			public String getMenuImg() {
				return menuImg;
			}

			public void setMenuImg(String menuImg) {
				this.menuImg = menuImg;
			}

			public String getCorporateIdcardFront() {
				return corporateIdcardFront;
			}

			public void setCorporateIdcardFront(String corporateIdcardFront) {
				this.corporateIdcardFront = corporateIdcardFront;
			}

			public String getCorporateIdcardBack() {
				return corporateIdcardBack;
			}

			public void setCorporateIdcardBack(String corporateIdcardBack) {
				this.corporateIdcardBack = corporateIdcardBack;
			}

			public String getCanteenImg() {
				return canteenImg;
			}

			public void setCanteenImg(String canteenImg) {
				this.canteenImg = canteenImg;
			}

			public String getKitchenImg() {
				return kitchenImg;
			}

			public void setKitchenImg(String kitchenImg) {
				this.kitchenImg = kitchenImg;
			}

			public String getDoorImg() {
				return doorImg;
			}

			public void setDoorImg(String doorImg) {
				this.doorImg = doorImg;
			}

			public String getCorporateWithidcardFront() {
				return corporateWithidcardFront;
			}

			public void setCorporateWithidcardFront(String corporateWithidcardFront) {
				this.corporateWithidcardFront = corporateWithidcardFront;
			}

			public String getCorporateWithidcardBack() {
				return corporateWithidcardBack;
			}

			public void setCorporateWithidcardBack(String corporateWithidcardBack) {
				this.corporateWithidcardBack = corporateWithidcardBack;
			}

			public String getUserGroup() {
				return userGroup;
			}

			public void setUserGroup(String userGroup) {
				this.userGroup = userGroup;
			}

			public String getBoundType() {
				return boundType;
			}

			public void setBoundType(String boundType) {
				this.boundType = boundType;
			}

			public String getBaidupwd() {
				return baidupwd;
			}

			public void setBaidupwd(String baidupwd) {
				this.baidupwd = baidupwd;
			}

			public String getElmUsername() {
				return elmUsername;
			}

			public void setElmUsername(String elmUsername) {
				this.elmUsername = elmUsername;
			}

			public String getElmPwd() {
				return elmPwd;
			}

			public void setElmPwd(String elmPwd) {
				this.elmPwd = elmPwd;
			}

			public String getMeituanPwd() {
				return meituanPwd;
			}

			public void setMeituanPwd(String meituanPwd) {
				this.meituanPwd = meituanPwd;
			}
			
			/**
			 * 获取店铺用户账号
			 */
			public String getUserAccount() {
				return userAccount;
			}
			/**
			 * 设置店铺用户账号
			 */
			public void setUserAccount(String userAccount) {
				this.userAccount = userAccount;
			}
			/**
			 * 获取店铺所属商圈
			 */
			public String getBusinessArea() {
				return businessArea;
			}

			/**
			 * 设置店铺所属商圈
			 */
			public void setBusinessArea(String businessArea) {
				this.businessArea = businessArea;
			}
			
			/**
			 * 附加项
			 */
			public String getUsername() {
				return username;
			}

			public void setUsername(String username) {
				this.username = username;
			}

			public String getPassword() {
				return password;
			}

			public void setPassword(String password) {
				this.password = password;
			}

			public String getShopId() {
				return shopId;
			}

			public void setShopId(String shopId) {
				this.shopId = shopId;
			}

			public String getPlatformType() {
				return platformType;
			}

			public void setPlatformType(String platformType) {
				this.platformType = platformType;
			}
			public Integer getIsDelete() {
				return isDelete;
			}
			public void setIsDelete(Integer isDelete) {
				this.isDelete = isDelete;
			}
			public String getCategoryId() {
				return categoryId;
			}
			public void setCategoryId(String categoryId) {
				this.categoryId = categoryId;
			}
		
			
			}