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
		if(!biz.validate("valid",$('#storeSpecialOfferFormEdit')[0])){
			showWarn("数据验证失败",3000);
			$("#submit").prop('disabled', false).css({'cursor':'pointer'});
			return;
		}
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
		$('#storeSpecialOfferFormEdit').ajaxSubmit(options);
	});
});
function chooseId(){
	$("#edit_storeName").val($("#edit_storeId").find("option:selected").text());
}
</script>
</head>
  
<body>
	<form id="storeSpecialOfferFormEdit" >
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<input type="hidden" id="edit_id" name="id" type="text" value="${storeSpecialOffer.id}"/>
		<table class="table">
			<tr>	
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">
					<input id="edit_storeName" name="storeName" type="hidden" /> 
					<select class="search_select choose_select" name="storeId" id="edit_storeId" onchange="chooseId()">
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">特价结算时间：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" style="width: 85px" placeholder="起始日期" id="edit_specialOfferBeginDate" name="specialOfferBeginDate"  type="text" data-date-format="yyyy-mm-dd" />
						<input class="date-picker text" style="width: 85px" placeholder="截止日期" id="edit_specialOfferEndDate" name="specialOfferEndDate" type="text" data-date-format="yyyy-mm-dd" />
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
    </div>
	</form>
</body>
</html>
