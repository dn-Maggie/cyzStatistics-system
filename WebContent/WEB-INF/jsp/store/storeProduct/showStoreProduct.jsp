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
				<td class="inputTd">${storeProduct.storeId}</td>
				<td class="inputLabelTd">产品分类ID：</td>
				<td class="inputTd">${storeProduct.productClassId}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品类名：</td>
				<td class="inputTd">${storeProduct.productClassName}</td>
				<td class="inputLabelTd">产品ID：</td>
				<td class="inputTd">${storeProduct.productId}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品名称：</td>
				<td class="inputTd">${storeProduct.productName}</td>
				<td class="inputLabelTd">产品图片地址：</td>
				<td class="inputTd">${storeProduct.productImagePath}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品单价：</td>
				<td class="inputTd">${storeProduct.productUnitPrice}</td>
				<td class="inputLabelTd">库存数量：</td>
				<td class="inputTd">${storeProduct.productStocks}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品状态：</td>
				<td class="inputTd">${storeProduct.productStatus}</td>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input class="ti_bottom"  type="button" id="close_button" value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
