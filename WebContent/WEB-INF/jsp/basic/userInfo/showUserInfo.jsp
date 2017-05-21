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
		<table class="table">
			<tr>
				<td class="inputLabelTd"><span class="required">*</span>登录账号：</td>
				<td class="inputTd">${userInfo.userAccount}</td>
				<td class="inputLabelTd"><span class="required">*</span>用户姓名：</td>
				<td class="inputTd">${userInfo.fullName}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">所在小组</td>
				<td class="inputTd">
					<select name="userGroup" class="search_select">
							<c:forEach var="userGroupList" items="${userGroupList}">
								<option value="${userGroupList.id}" <c:if test="${userGroupList.id==userInfo.userGroup}">selected</c:if>>${userGroupList.groupName}</option>
							</c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">性别：</td>
				<td class="inputTd"><c:if test="${userInfo.sex eq 1}">男</c:if>
					<c:if test="${userInfo.sex eq 0}">女</c:if></td>
			</tr>
			<tr>
				<td class="inputLabelTd"><span class="required">*</span>手机号码：</td>
				<td class="inputTd">${userInfo.mobilePhone}</td>
				<td class="inputLabelTd"><span class="required">*</span>年龄：</td>
				<td class="inputTd">${userInfo.age}</td>
			</tr>
			<tr>
				<td class="inputTd" colspan="5" style="text-align: center;"><input
					class="ti_bottom" type="button" id="close_button" value="关闭" /></td>
			</tr>
		</table>
	</div>
</body>
</html>
