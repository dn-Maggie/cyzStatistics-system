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
				<td class="inputLabelTd">产品ID(主键)：</td>
				<td class="inputTd">${product.productId}</td>
				<td class="inputLabelTd">产品名称：</td>
				<td class="inputTd">${product.productName}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品图片地址：</td>
				<td class="inputTd">${product.productImagePath}</td>
				<td class="inputLabelTd">产品单价：</td>
				<td class="inputTd">${product.productUnitPrice}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">库存数量：</td>
				<td class="inputTd">${product.productStocks}</td>
				<td class="inputLabelTd">产品状态：</td>
				<td class="inputTd">${product.productStatus}</td>
			</tr>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input class="ti_bottom"  type="button" id="close_button"  value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
