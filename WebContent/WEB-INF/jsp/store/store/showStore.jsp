<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<style>
	.storeImg{width:100%;height:200px}
</style>
<script src="<%=request.getContextPath() %>/static/js/fuelux/fuelux.wizard.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.validate.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/additional-methods.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/bootbox.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/select2.min.js"></script>
<script type="text/javascript">
$(function() {
 	$('#fuelux-wizard').ace_wizard().on('finished', function(e) {
 		window.parent.closeShow();
	}) 
});
</script>
</head>
<body>
<div class="widget-box">
	<div class="widget-body">
		<div class="widget-main">
					 <input type="hidden" id="edit_storeId" name="storeId" type="text" value="${store.storeId}"/>
					 <table class="table">
					 	<tr>	
					 		<td class="inputLabelTd">关联店铺账号：</td>
							<td class="inputTd">
									<c:forEach items="${user}" var="user">
										 <c:if test="${user.id==store.ownerUserId}">${user.userAccount}</c:if>
									</c:forEach>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>所属商圈：</td>
							<td class="inputTd">
								${store.businessArea}
							</td>
							
						</tr>
						<tr>
							<td class="inputLabelTd">店铺名称：</td>
							<td class="inputTd">${store.storeName} </td>
							<td class="inputLabelTd">所属品牌：</td>
							<td class="inputTd">
								<c:forEach var="brand" items="${brand}">
									<c:if test="${brand.brandId==store.brandId}"> ${brand.brandName}</c:if>
						        </c:forEach>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">店铺地址：</td>
							<td class="inputTd">${store.storeAddress}
							</td>
							<td class="inputLabelTd">店铺联系电话：</td>
							<td class="inputTd">${store.storeTel}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">营业时间：</td>
							<td class="inputTd" colspan="3">${store.workTimeBegin}-${store.workTimeEnd}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">店长姓名：</td>
							<td class="inputTd">${store.storeOwnerName}
							</td>
							<td class="inputLabelTd">店长电话：</td>
							<td class="inputTd">
								<i class="icon-phone green"></i>
								${store.storeOwnerTel}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">结算方式：</td>
							<td class="inputTd">
								<c:forEach var="settlementMethod" items="${settlementMethod}">
									<c:if test="${settlementMethod.dictCode==store.settlementMethod}">${settlementMethod.dictName}</c:if>
		            			</c:forEach>
							</td>
							<td class="inputLabelTd">是否可以提供发票：</td>
							<td class="inputTd">
								<c:choose>
									<c:when test="${store.proInvoiceFlag==1}">是</c:when>
									<c:when test="${store.proInvoiceFlag==0}">否</c:when>
								</c:choose>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">登记人：</td>
							<td class="inputTd">${store.registrant}
							</td>
							<td class="inputLabelTd">登记日期：</td>
							<td class="inputTd">${store.registDate}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">运营开始时间：</td>
							<td class="inputTd">${store.operateDate}
							</td>
							<td class="inputLabelTd">备注：</td>
							<td class="inputTd">${store.remark}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">大概店铺月销售额(万元)：</td>
							<td class="inputTd">${store.averageSales}
							</td>
							<td class="inputLabelTd">饿了么平台月销售单量：</td>
							<td class="inputTd">${store.elmSale}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">美团平台月销售单量：</td>
							<td class="inputTd">${store.meituanSale}
							</td>
							<td class="inputLabelTd">百度平台月销售单量：</td>
							<td class="inputTd">${store.baiduSale}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd"><span class="required">*</span>绑卡类型：</td>
							<td class="inputTd">
									<c:if test="${store.boundType==1}">绑商家卡</c:if>
									<c:if test="${store.boundType==2}">绑公司卡</c:if>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>饿了么平台商铺ID：</td>
							<td class="inputTd">${store.elmId}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd"><span class="required">*</span>美团平台商铺ID：</td>
							<td class="inputTd">${store.meituanId}
							</td>
							<td class="inputLabelTd"><span class="required">*</span>百度平台商铺ID：</td>
							<td class="inputTd">${store.baiduId}
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">实景图片1：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg"class="storeImg" src="${store.realImagePath1}"> <!--数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">实景图片2：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg" class="storeImg"  src="${store.realImagePath2}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">实景图片3：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.realImagePath3}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">菜单：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.menuImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">堂食照：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.canteenImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">后厨照：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.kitchenImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">门头：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src=""${store.doorImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">营业执照：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.businessLicenseImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">卫生经营许可证：</td>
							<td class="inputTd" colspan="3">
									<img alt="storeImg"class="storeImg" src="${store.healthLicenseImg}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">法人身份证（正面）：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg"class="storeImg" src="${store.corporateIdcardFront}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">法人身份证（反面）：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg" class="storeImg" src="${store.corporateIdcardBack}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">法人手持身份证(正）：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg" class="storeImg" src="${store.corporateWithidcardFront}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">法人手持身份证(反)：</td>
							<td class="inputTd" colspan="3">
								<img alt="storeImg" class="storeImg" src="${store.corporateWithidcardBack}"> <!-- 数据库保存地址 -->
							</td>
						</tr>
					</table>
				</div>
		</div>
   </div>
</body>
</html>
