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
				<td class="inputLabelTd">创建时间：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="createDate" id="edit_createDate" type="text" disabled value="${brand.createDate}"/>
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">合同签订时间：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" id="edit_signContractDate" name="signContractDate" type="text" disabled value="${brand.signContractDate}"/>
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">品牌名称：</td>
				<td class="inputTd">
					<input id="edit_brandName" name="brandName" type="text" class="text" value="${brand.brandName}" disabled/>
				</td>
				<td class="inputLabelTd">品牌负责人：</td>
				<td class="inputTd">
					<input id="edit_brandManager" name="brandManager" type="text" class="text" disabled value="${brand.brandManager}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">负责人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_brandManagerTel" name="brandManagerTel" type="text" disabled class="text" value="${brand.brandManagerTel}"/>
						<i class="icon-phone green"></i>
					</span>
				</td>
				<td class="inputLabelTd">门店数量：</td>
				<td class="inputTd">
					<input id="edit_storesNumber" name="storesNumber" type="number" class="text" disabled value="${brand.storesNumber}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">所在省份：</td>
				<td class="inputTd">
					<select disabled
						class="search_select" onchange="regionCodeChange(this)"
						name="provinceCode" id="edit_provinceCode">
						<option value=""></option>
							<c:forEach var="province" items="${province}">
								<option value="${province.id}"<c:if test="${province.id==brand.provinceCode}">selected</c:if>> <c:out value="${province.name}"></c:out></option>
				             </c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">所在地市：</td>
				<td class="inputTd">
					<select disabled
						class="search_select" onchange="cityCodeChange(this)"
						name="regionCode" id="edit_regionCode">
						<option value=""></option>
						<c:forEach var="region" items="${region}">
							<option value="${region.id}"<c:if test="${region.id==brand.regionCode}">selected</c:if>> <c:out value="${region.name}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">所在区县：</td>
				<td class="inputTd">
					<select disabled
						class="search_select" 
						name="cityCode" id="edit_cityCode">
						<option value=""></option>
						<c:forEach var="city" items="${city}">
							<option value="${city.id}"<c:if test="${city.id==brand.cityCode}">selected</c:if>> <c:out value="${city.name}"></c:out> </option>
			            </c:forEach>
				    </select>
				</td>
				<td class="inputLabelTd"></td>
				<td class="inputTd"></td>
			</tr>	
			
			<tr>
				
				<td class="inputLabelTd">所属行业：</td>
				<td class="inputTd">
					<select class="search_select" name="industryId" id="edit_industryId" disabled>
						<option value=""></option>
						<c:forEach var="industry" items="${industry}">
							<option value="${industry.industryId}" <c:if test="${industry.industryId==brand.industryId}">selected</c:if>> <c:out value="${industry.industryName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">所属品类：</td>
				<td class="inputTd">
					<select class="search_select"  name="categoryId" id="edit_categoryId" disabled>
						<option value=""></option>
						<c:forEach var="category" items="${category}">
							<option value="${category.categoryId}" <c:if test="${category.categoryId==brand.categoryId}">selected</c:if>> <c:out value="${category.categoryName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				
				<td class="inputLabelTd">对接人：</td>
				<td class="inputTd">
					<input id="edit_contactName" name="contactName" type="text" class="text" value="${brand.contactName}" disabled/>
				</td>
				<td class="inputLabelTd">对接人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_contactTel" name="contactTel" disabled class="text"  value="${brand.contactTel}"/>
						<i class="icon-phone green"></i>
					</span>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">招商人：</td>
				<td class="inputTd">
					<input id="edit_merchantName" name="merchantName" disabled class="text" value="${brand.merchantName}"/>
				</td>
				<td class="inputLabelTd">招商人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_merchantTel" name="merchantTel" disabled class="text" value="${brand.merchantTel}"/>
						<i class="icon-phone green"></i>
					</span>
				</td>
			</tr>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input id="close_button" type="button" class="ti_bottom" value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
