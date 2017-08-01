<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script type="text/javascript">
$(function() {
	//绑定提交按钮click事件
	$("#submit").click(function() {
		$("#submit").prop('disabled', true).css({'cursor':'not-allowed'});
		showMessage("正在处理...");
		
		var options = {
			url : "<m:url value='/storeSpecialOffer/addStoreSpecialOffer.do'/>",
			type : "post",
				dataType:"json",
				success : function(d) {
					if(d.status){
						showMessage(d.message,"","",function(){
							window.parent.closeAdd();
				     		List.doSearch(window.parent.gridObj);
						});
					}else{
						showMessage(d.message);
					}
				}
		};
		// 将options传给ajaxForm
		if($('#storeSpecialOfferFormEditElm').find("#edit_specialOfferFoodName").val().length>0)$('#storeSpecialOfferFormEditElm').ajaxSubmit(options);
		if($('#storeSpecialOfferFormEditMt').find("#edit_specialOfferFoodName").val().length>0)$('#storeSpecialOfferFormEditMt').ajaxSubmit(options);
		if($('#storeSpecialOfferFormEditBdwm').find("#edit_specialOfferFoodName").val().length>0)$('#storeSpecialOfferFormEditBdwm').ajaxSubmit(options);
	});
});
function chooseId(){
	$("#edit_storeName").val($("#edit_storeId").find("option:selected").text());
}
</script>
</head>
  
<body>
	<form id="storeSpecialOfferFormEditElm" >
		<input type="hidden" id="edit_id" name="id" type="text" value="${storeSpecialOffer.id}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">平台类型：</td>
				<td class="inputTd">
					<select class="search_select" name="platformType" id="edit_platformType">
						<option value="elm">饿了么</option>
					</select>
				</td>
				
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">
					<input id="edit_storeName" name="storeName" type="hidden" /> 
					<select class="search_select choose_select" name="storeId" id="edit_storeId" onchange="chooseId()">
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算起：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="起始日期" id="edit_specialOfferBeginDate" name="specialOfferBeginDate"  type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">特价结算止：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="截止日期" id="edit_specialOfferEndDate" name="specialOfferEndDate" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算菜品名称：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodId" name="specialOfferFoodId" type="hidden" class="text" />
					<input id="edit_specialOfferFoodName" name="specialOfferFoodName" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodName}"/>
				</td>
				<td class="inputLabelTd">是否分前缀：</td>
				<td class="inputTd">
					<select class="search_select" name="specialType" id="edit_specialType">
						<option value="1">不分前缀</option>
						<option value="2">分前缀</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品原价：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodOrginPrice" name="specialOfferFoodOrginPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodOrginPrice}"/>
				</td>
				<td class="inputLabelTd">特价结算价格：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodPrice" name="specialOfferFoodPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodPrice}"/>
				</td>
			</tr>
		</table>
	</form>
	<form id="storeSpecialOfferFormEditMt" >
		<input type="hidden" id="edit_id" name="id" type="text" value="${storeSpecialOffer.id}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">平台类型：</td>
				<td class="inputTd">
					<select class="search_select" name="platformType" id="edit_platformType">
						<option value="mt">美团</option>
					</select>
				</td>
				
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">
					<input id="edit_storeName" name="storeName" type="hidden" /> 
					<select class="search_select choose_select" name="storeId" id="edit_storeId" onchange="chooseId()">
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算起：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="起始日期" id="edit_specialOfferBeginDate" name="specialOfferBeginDate"  type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">特价结算止：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="截止日期" id="edit_specialOfferEndDate" name="specialOfferEndDate" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算菜品名称：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodId" name="specialOfferFoodId" type="hidden" class="text" />
					<input id="edit_specialOfferFoodName" name="specialOfferFoodName" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodName}"/>
				</td>
				<td class="inputLabelTd">是否分前缀：</td>
				<td class="inputTd">
					<select class="search_select" name="specialType" id="edit_specialType">
						<option value="1">不分前缀</option>
						<option value="2">分前缀</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品原价：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodOrginPrice" name="specialOfferFoodOrginPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodOrginPrice}"/>
				</td>
				<td class="inputLabelTd">特价结算价格：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodPrice" name="specialOfferFoodPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodPrice}"/>
				</td>
			</tr>
		</table>
	</form>
	<form id="storeSpecialOfferFormEditBdwm" >
		<input type="hidden" id="edit_id" name="id" type="text" value="${storeSpecialOffer.id}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">平台类型：</td>
				<td class="inputTd">
					<select class="search_select" name="platformType" id="edit_platformType">
						<option value="bdwm">百度外卖</option>
					</select>
				</td>
				
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">
					<input id="edit_storeName" name="storeName" type="hidden" /> 
					<select class="search_select choose_select" name="storeId" id="edit_storeId" onchange="chooseId()">
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算起：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="起始日期" id="edit_specialOfferBeginDate" name="specialOfferBeginDate"  type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">特价结算止：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" placeholder="截止日期" id="edit_specialOfferEndDate" name="specialOfferEndDate" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算菜品名称：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodId" name="specialOfferFoodId" type="hidden" class="text" />
					<input id="edit_specialOfferFoodName" name="specialOfferFoodName" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodName}"/>
				</td>
				<td class="inputLabelTd">是否分前缀：</td>
				<td class="inputTd">
					<select class="search_select" name="specialType" id="edit_specialType">
						<option value="1">不分前缀</option>
						<option value="2">分前缀</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品原价：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodOrginPrice" name="specialOfferFoodOrginPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodOrginPrice}"/>
				</td>
				<td class="inputLabelTd">特价结算价格：</td>
				<td class="inputTd">
					<input id="edit_specialOfferFoodPrice" name="specialOfferFoodPrice" type="text" class="text" value="${storeSpecialOffer.specialOfferFoodPrice}"/>
				</td>
			</tr>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input id="submit" type="button" class="ti_bottom" value="保存"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
