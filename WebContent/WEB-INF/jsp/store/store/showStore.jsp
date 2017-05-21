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
			<div id="fuelux-wizard" class="row-fluid" data-target="#step-container">
				<ul class="wizard-steps">
					<li data-target="#step1" class="active">
						<span class="step">1</span>
						 <p>基本数据</p> 
					</li>

					<li data-target="#step2">
						<span class="step">2</span>
						 <p>店铺平台信息</p> 
					</li>

					<li data-target="#step3">
						<span class="step">3</span>
						 <p>实景图片</p>
					</li>

					<li data-target="#step4">
						<span class="step">4</span>
						<p>证件图片</p> 
					</li>
				</ul>
			</div>
			<div class="step-content row-fluid position-relative" id="step-container">
				<form class="form-horizontal" id="basicMessForm" method="post" autocomplete="off">
					<div class="step-pane active" id="step1">
					 <input type="hidden" id="edit_storeId" name="storeId" type="text" value="${store.storeId}"/>
					 <table class="table">
					 	<tr>	
					 		<td class="inputLabelTd">关联店铺账号：</td>
							<td class="inputTd">
								<select class="search_select" name="ownerUserId" id="edit_ownerUserId" disabled>
									<c:forEach items="${user}" var="user">
										<option value="${user.id}" <c:if test="${user.id==store.ownerUserId}">selected</c:if>><c:out value="${user.userAccount}"></c:out></option>
									</c:forEach>
								</select>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>所属商圈：</td>
							<td class="inputTd">
								<input id="edit_businessArea" name="businessArea" type="text" class="text" value="${store.businessArea}" />
							</td>
							
						</tr>
						<tr>
							<td class="inputLabelTd">店铺名称：</td>
							<td class="inputTd">
								<input id="edit_storeName" name="storeName" type="text" class="text" value="${store.storeName}" disabled/>
							</td>
							<td class="inputLabelTd">所属品牌：</td>
							<td class="inputTd">
								<select class="search_select choose_select" name="brandId" id="edit_brandId" disabled>
									<option value="">--请选择--</option>
									<c:forEach var="brand" items="${brand}">
										<option value="${brand.brandId}" <c:if test="${brand.brandId==store.brandId}">selected</c:if>> <c:out value="${brand.brandName}"></c:out> </option>
						             </c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">店铺地址：</td>
							<td class="inputTd">
								<input id="edit_storeAddress" name="storeAddress" type="text" class="text" value="${store.storeAddress}" disabled/>
							</td>
							<td class="inputLabelTd">店铺联系电话：</td>
							<td class="inputTd">
								<span class="input-icon">
									<input id="edit_storeTel" name="storeTel" type="text" class="text" value="${store.storeTel}" disabled/>
									<i class="icon-phone green"></i>
								</span>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">营业时间起：</td>
							<td class="inputTd">
								<div class="input-group bootstrap-timepicker">
									<input class="timepicker text" name="workTimeBegin" id="edit_workTimeBegin" type="text"  disabled  value="${store.workTimeBegin}"/>
									<span>
										<i class="icon-time bigger-110"></i>
									</span>
								</div>
							</td>
							<td class="inputLabelTd">营业时间止：</td>
							<td class="inputTd">
								<div class="input-group bootstrap-timepicker">
									<input class="timepicker text" name="workTimeEnd" id="edit_workTimeEnd" type="text" disabled value="${store.workTimeEnd}"/>
									<span>
										<i class="icon-time bigger-110"></i>
									</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">店长姓名：</td>
							<td class="inputTd">
								<input id="edit_storeOwnerName" name="storeOwnerName" type="text" class="text" disabled value="${store.storeOwnerName}"/>
							</td>
							<td class="inputLabelTd">店长电话：</td>
							<td class="inputTd">
								<span class="input-icon">
									<input id="edit_storeOwnerTel" name="storeOwnerTel" type="text" class="text" disabled value="${store.storeOwnerTel}"/>
									<i class="icon-phone green"></i>
								</span>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">结算方式：</td>
							<td class="inputTd">
								<select class="search_select" name="settlementMethod" id="edit_settlementMethod" disabled>
									<c:forEach var="settlementMethod" items="${settlementMethod}">
										<option value="${settlementMethod.dictCode}" <c:if test="${settlementMethod.dictCode==store.settlementMethod}">selected</c:if>> 
										<c:out value="${settlementMethod.dictName}"></c:out> 
										</option>
			            			 </c:forEach>
								</select>
							</td>
							<td class="inputLabelTd">是否可以提供发票：</td>
							<td class="inputTd">
								<label>
									<input id="edit_proInvoiceFlag" name="proInvoiceFlag" class="ace ace-switch ace-switch-5" 
									value = "${store.proInvoiceFlag}"
									<c:if test="${store.proInvoiceFlag==1}">checked</c:if>
									type="checkbox" />
									<span class="lbl"></span>
								</label>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">登记人：</td>
							<td class="inputTd">
								<input id="edit_registrant" name="registrant" type="text" class="text" value="${store.registrant}" disabled/>
							</td>
							<td class="inputLabelTd">登记日期：</td>
							<td class="inputTd">
								<div class="input-group">
									<input class="date-picker text" name="registDate" id="edit_registDate" type="text" value="${store.registDate}" data-date-format="yyyy-mm-dd" />
									<span>
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">运营开始时间：</td>
							<td class="inputTd">
								<div class="input-group">
									<input class="date-picker text" name="operateDate" id="edit_operateDate" type="text" value="${store.operateDate}" data-date-format="yyyy-mm-dd" />
									<span>
										<i class="icon-calendar bigger-110"></i>
									</span>
								</div>
							</td>
							<td class="inputLabelTd">备注：</td>
							<td class="inputTd">
								<input id="edit_remark" name="remark" type="text" class="text" value="${store.remark}"/>
							</td>
						</tr>
					</table>
				</div>
				<div class="step-pane" id="step2">
					 <table class="table">
						<tr>
							<td class="inputLabelTd">大概店铺月销售额(万元)：</td>
							<td class="inputTd">
								<input id="edit_averageSales" name="averageSales" type="number" class="text" value="${store.averageSales}"/>
							</td>
							<td class="inputLabelTd">饿了么平台月销售单量：</td>
							<td class="inputTd">
								<input id="edit_elmSale" name="elmSale" type="number" class="text" value="${store.elmSale}"/>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd">美团平台月销售单量：</td>
							<td class="inputTd">
								<input id="edit_meituanSale" name="meituanSale" type="number" class="text" value="${store.meituanSale}"/>
							</td>
							<td class="inputLabelTd">百度平台月销售单量：</td>
							<td class="inputTd">
								<input id="edit_baiduSale" name="baiduSale" type="number" class="text" value="${store.baiduSale}"/>
							</td>
						</tr>
						<!-- tr>
							<td class="inputLabelTd">饿了么平台佣金率(%)：</td>
							<td class="inputTd">
								<input id="edit_elmRate" name="elmRate" type="number" class="text" value="${store.elmRate}"/>
							</td>
							<td class="inputLabelTd">美团平台佣金率(%)：</td>
							<td class="inputTd">
								<input id="edit_meituanRate" name="meituanRate" type="number" class="text" value="${store.meituanRate}"/>
							</td>
						</tr-->
						<tr>
							<!-- td class="inputLabelTd">百度平台佣金率(%)：</td>
							<td class="inputTd">
								<input id="edit_baiduRate" name="baiduRate" type="number" class="text" value="${store.baiduRate}"/>
							</td-->
							<td class="inputLabelTd"><span class="required">*</span>绑卡类型：</td>
							<td class="inputTd">
								<select class="search_select" name="boundType" id="edit_boundType">
									<option value="1" <c:if test="${store.boundType==1}">selected</c:if>>绑商家卡</option>
									<option value="2" <c:if test="${store.boundType==2}">selected</c:if>>绑公司卡</option>
								</select>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>饿了么平台商铺ID：</td>
							<td class="inputTd">
								<input id="edit_elmId" name="elmId" type="text" class="text" value="${store.elmId}"/>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd"><span class="required">*</span>饿了么平台商铺账号：</td>
							<td class="inputTd">
								<input id="edit_elmUsername" name="elmUsername" type="text" class="text" value="${store.elmUsername}"/>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>饿了么平台商铺密码：</td>
							<td class="inputTd">
								<input id="edit_elmPwd" name="elmPwd" type="text" class="text" value="${store.elmPwd}"/>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd"><span class="required">*</span>美团平台商铺账号：</td>
							<td class="inputTd">
								<input id="edit_meituanId" name="meituanId" type="text" class="text" value="${store.meituanId}"/>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>美团平台商铺密码：</td>
							<td class="inputTd">
								<input id="edit_meituanPwd" name="meituanPwd" type="text" class="text" value="${store.meituanPwd}"/>
							</td>
						</tr>
						<tr>
							<td class="inputLabelTd"><span class="required">*</span>百度平台商铺账号：</td>
							<td class="inputTd">
								<input id="edit_baiduId" name="baiduId" type="text" class="text" value="${store.baiduId}"/>
							</td>
							<td class="inputLabelTd"><span class="required">*</span>百度平台商铺密码：</td>
							<td class="inputTd">
								<input id="edit_baidupwd" name="baidupwd" type="text" class="text" value="${store.baidupwd}"/>
							</td>
						</tr>
					</table>
				</div>
				</form>
				<div class="step-pane" id="step3">
					<table class="table">
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
					</table>
				</div>
				<div class="step-pane" id="step4">
					<table>
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
			<div class="row-fluid wizard-actions">
				<button class="btn btn-prev btn-sm">
					<i class="icon-arrow-left"></i>
					上一页
				</button>
				<button class="btn btn-success btn-next btn-sm" data-last="关闭">
					下一页
					<i class="icon-arrow-right icon-on-right"></i>
				</button>
			</div>
		</div>
	</div>
   </div>
</body>
</html>
