<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script type="text/javascript" charset="utf-8" src="<%=request.getContextPath()%>/js/huploadify/jquery.Huploadify.js"></script>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/js/huploadify/Huploadify.css">
<style>
	.table{
		 border-top: 1px solid #eee;
	}   
</style>
<script type="text/javascript">
	function init(){
		new biz.select({//状态下拉
		    id:"#edit_states1",
		    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=status'/>",
		    value:"${role.states}"
		});
		new biz.select({//状态下拉
		    id:"#edit_states2",
		    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=status'/>",
		    value:"${role.states}"
		});
		$(".knob").knob();
		
		/*编辑表单数据验证*/
		new biz.validate({
			id : "#userInfoFormAdd",
			rules : {
				"userAccount" : {
					required : true,
					maxlength : 50
				},
			}
		});
	}
	$(function() {
		init();
		//绑定提交按钮click事件
		$(".submit").click(function() {
			$(this).prop("disabled",true).css("cursor","not-allowed");
			/* this.disabled = true;
			this.style.cursor ='not-allowed' */
			showMessage("正在处理...");
			var options = {
					url : "<m:url value='/userInfo/updateUserInfo.do'/>",
					type : "post",
					dataType:"json",
					success : function(d) {
						if(d.status){
							showMessage(d.message,"","",function(){
								window.parent.closeEdit();
					     		List.doSearch(window.parent.gridObj);
							});
						}else{
							showMessage(d.message);
						}
					}
				};
			// 将options传给ajaxForm
			$(this).parents('#userInfoFormAdd').ajaxSubmit(options);
			
		});
	});
</script>
</head>

<body style="background:#fff">
<!-- PAGE CONTENT BEGINS -->
<div class="tabbable">
			<c:choose>
				<c:when test="${userInfo.storeId!=''}">
				<form id="userInfoFormAdd">
				<input  name="id" type="hidden" value="${userInfo.id}"/>
					<table class="table">
					<!-- 添加平台店铺信息 -->
					<tr>
						<td class="inputLabelTd">店铺名称：</td>
						<td class="inputTd">
							<input  name="storeName" type="text" id="edit_storeName" value="${userInfo.fullName}"  />
							<input id="edit_storeId" name="storeId" type="hidden" value="${userInfo.storeId}"/> 
							<input id="fullName" name="fullName" type="hidden" value="${userInfo.fullName}"/> 
						</td>
						<td class="inputLabelTd">组别</td>
							<td class="inputTd">
							<select name="userGroup"
								class="search_select">
									<c:forEach var="userGroupList" items="${userGroupList}">
										<option value="${userGroupList.id}" <c:if test="${userGroupList.id==userInfo.userGroup}">selected</c:if>>${userGroupList.groupName}</option>
									</c:forEach>
						</select></td>
					</tr>
					<tr>
						<td class="inputLabelTd">平台店铺序号：</td>
						<td class="inputTd">
							<input id="edit_platformStoreIndex" name="platformStoreIndex" type="text" class="text" value="${userInfo.platformStoreIndex}"/>
						</td>
						<td class="inputLabelTd">评分：</td>
						<td class="inputTd">
							<div class="knob-container inline">
								<input type="text" name="platformStoreScore" value="${userInfo.platformStoreScore}"/>
							</div>
						</td>
					</tr>
					<tr>
						<td class="inputLabelTd">市场经理：</td>
						<td class="inputTd">
							<input id="edit_marketingManager" name="marketingManager" type="text" class="text" value="${userInfo.marketingManager}"/>
						</td>
						<td class="inputLabelTd">市场经理电话：</td>
						<td class="inputTd">
							<span class="input-icon">
								<input id="edit_marketingManagerTel" name="marketingManagerTel" type="text" class="text" value="${userInfo.marketingManagerTel}"/>
								<i class="icon-phone green"></i>
							</span>
						</td>
					</tr>
					<tr>
					<td class="inputLabelTd"><span class="required">*</span>登录账号：</td>
					<td class="inputTd"><input id="edit_userAccount" readonly
						name="userAccount" type="text" class="text"
						value="${userInfo.userAccount}" /></td>
					<td class="inputLabelTd">角色</td>
					<td class="inputTd">
					<select id="edit_roleId" name="roleId"
						class="search_select">
							<option value="${platformStoreRole.roleId}" <c:if test="${platformStoreRole.roleId == userInfo.roleId}"></c:if>>${platformStoreRole.roleName}</option> 
					</select></td>
				</tr>
				<tr>
					<td class="inputLabelTd">备注：</td>
					<td class="inputTd"><input id="edit_memo" name="memo"
						type="text" class="text" value="${userInfo.memo}" /></td>
					<td class="inputLabelTd">状态：</td>
					<td class="inputTd">
					<select id="edit_states2" name="states" class="search_select">
					</select></td>
				</tr>
				<tr>
					<td class="inputTd" colspan="5" style="text-align: center;">
						<input id="submitt" type="button" class="ti_bottom submit" value="保存" />
						<input id="reset" type="reset" class="ti_bottom mr22" value="重置" />
					</td>
				</tr>
			</table>
				</form>
				</c:when>
				<c:otherwise>
					<form id="userInfoFormAdd">
					<input  name="id" type="hidden" value="${userInfo.id}"/>
					<table class="table">
					<tr>
					<td class="inputLabelTd"><span class="required">*</span>登录账号：</td>
					<td class="inputTd"><input id="edit_userAccount" readonly
						name="userAccount" type="text" class="text"
						value="${userInfo.userAccount}" /></td>
					<td class="inputLabelTd"><span class="required">*</span>用户姓名：</td>
					<td class="inputTd"><input id="edit_fullName" name="fullName"
						type="text" class="text" value="${userInfo.fullName}" /></td>
				</tr>
				<tr>
					<td class="inputLabelTd"><span class="required">*</span>手机号码：</td>
					<td class="inputTd"><input id="mobilePhone" name="mobilePhone"
						type="text" class="text" value="${userInfo.mobilePhone}" /></td>
						<td class="inputLabelTd"><span class="required">*</span>身份证号码：</td>
					<td class="inputTd"><input id="idCard" name="idCard"
						type="text" class="text" value="${userInfo.idCard}" /></td>
				</tr>
				<tr>
					<td class="inputLabelTd">备注：</td>
					<td class="inputTd"><input id="edit_memo" name="memo"
						type="text" class="text" value="${userInfo.memo}" /></td>
					<td class="inputLabelTd">状态：</td>
					<td class="inputTd">
					<select id="edit_states1" name="states" class="search_select">
					</select></td>
				</tr>
				<tr>
					<td class="inputLabelTd">角色</td>
					<td class="inputTd">
					<select name="roleId"
						class="search_select" >
							<c:forEach var="role" items="${roleList}">
								<option value="${role.roleId}" <c:if test="${role.roleId==userInfo.roleId}"></c:if>>${role.roleName}</option>
							</c:forEach>
					</select></td>
					<td class="inputLabelTd">组别</td>
					<td class="inputTd">
					<select name="userGroup"
						class="search_select">
							<c:forEach var="userGroupList" items="${userGroupList}">
								<option value="${userGroupList.id}" <c:if test="${userGroupList.id==userInfo.userGroup}">selected</c:if>>${userGroupList.groupName}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td class="inputTd" colspan="5" style="text-align: center;">
						<input id="submit" type="button" class="ti_bottom submit" value="保存" />
						<input id="reset" type="reset" class="ti_bottom mr22" value="重置" />
					</td>
				</tr>
				</table>
				</form>
				</c:otherwise>
			</c:choose>
	</div>
</body>
</html>
