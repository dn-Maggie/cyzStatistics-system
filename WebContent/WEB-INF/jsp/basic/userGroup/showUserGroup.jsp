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
				<td class="inputLabelTd">组别名：</td>
				<td class="inputTd">${userGroup.groupName}</td>
				<td class="inputLabelTd">组别描述：</td>
				<td class="inputTd">${userGroup.groupDesc}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">组别状态：</td>
				<td class="inputTd">${userGroup.groupStates}</td>
				<td class="inputLabelTd">创建者ID：</td>
				<td class="inputTd">${userGroup.groupCreater}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">更新者ID：</td>
				<td class="inputTd">${userGroup.groupUpdater}</td>
				<td class="inputLabelTd">创建时间：</td>
				<td class="inputTd">${userGroup.groupCreateTime}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">更新时间：</td>
				<td class="inputTd">${userGroup.groupUpdateTime}</td>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input class="ti_bottom"  type="button" id="close_button" value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
