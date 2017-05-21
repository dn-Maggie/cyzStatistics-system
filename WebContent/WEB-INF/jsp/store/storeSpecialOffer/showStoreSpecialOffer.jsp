<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">

<%@ include file="../../common/header.jsp"%>
<script type="text/javascript">
	$(function() {
		//绑定提交按钮click事件
		$("#close_button").click(function() {
			window.parent.closeShow();
		});
	});
</script>
</head>
  
<body>
	<div class="ui-table ui-widget ui-corner-all ui-border">
		<table class="table forview">
			<tr>
				<td class="inputLabelTd">店铺ID：</td>
				<td class="inputTd">${storeSpecialOffer.storeId}</td>
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">${storeSpecialOffer.storeName}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算时间起：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferBeginDate}</td>
				<td class="inputLabelTd">特价结算时间止：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferEndDate}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算菜品id：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferFoodId}</td>
				<td class="inputLabelTd">特价结算菜品名称：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferFoodName}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算菜品原价：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferFoodOrginPrice}</td>
				<td class="inputLabelTd">特价结算价格：</td>
				<td class="inputTd">${storeSpecialOffer.specialOfferFoodPrice}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算方式（1.模糊查询  2.精准查询）：</td>
				<td class="inputTd">${storeSpecialOffer.specialType}</td>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input class="ti_bottom"  type="button" id="close_button" value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
