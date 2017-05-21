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
			showMessage("正在处理...");
			if (!biz.validate("valid", $("#"+this.id).parents('#userInfoFormAdd')[0])) {
				showWarn("<m:message code='validation.object'/>", 3000);
				$(this).prop("disabled",false).css("cursor","pointer");
				return;
			}
		 	var userAccount = $(this).parents('#userInfoFormAdd').find('#edit_userAccount').val()
			if (ajaxGetUserInfoByUserAccount(userAccount)) {
				showMessage("登录账户已经存在，请重新输入.");
				$(this).prop("disabled",false).css("cursor","pointer");
				return;
			} 
			var options = {
					url : "<m:url value='/userInfo/addUserInfo.do'/>",
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
			$(this).parents('#userInfoFormAdd').ajaxSubmit(options);
			
		});
	});
	//选择店铺的弹出框
	var store_iframe_dialog;
	function chooseStore(){
		var url = baseUrl + '/store/toSelectStore.do';
		store_iframe_dialog = new biz.dialog(
				{
					id : $('<div id="sublist_window_iframe"></div>')
							.html(
							'<iframe id="iframeSublist" name="iframeSublist" src="'
									+ url
									+ '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
					modal : true,
					width : $(window).width()*0.8,
					height : $(window).height()*0.8,
					title : "店铺信息列表"
				});
		store_iframe_dialog.open();
	}
	// 关闭员工资源管理界面
	function closeStore() {
		store_iframe_dialog.close();
	}
	//填充数据
	function drawForm(rowData) {
		$("#edit_storeId").val(rowData.storeId);
		$("#edit_storeName").val(rowData.storeName);
		$("#edit_marketingManagerTel").val(rowData.storeOwnerTel);
		$("#edit_marketingManager").val(rowData.storeOwnerName);
		$("#fullName").val(rowData.storeName);
	}
	function ajaxGetUserInfoByUserAccount(userAccount) {
		var b = false;
		if (userAccount != null && userAccount != "") {
			$.ajax({
						url : "<m:url value='/userInfo/ajaxGetUserInfoByUserAccount.do'/>?userAccount="
								+ userAccount,
						cache : false,
						async : false,
						success : function(data, textStatus, jqXHR) {
							if (data == "true") {
								showMessage("登录账户已经存在，请重新输入.");
								b = true;
							}
						}
					});
		};
		return b;
	}
	
</script>
</head>

<body style="background:#fff">
<!-- PAGE CONTENT BEGINS -->
<div class="tabbable">
	<ul class="nav nav-tabs padding-18 tab-size-bigger" id="myTab" >
		<li class="active" onclick="init()">
			<a data-toggle="tab" href="#faq-tab-1" > 
				<i class="blue icon-question-sign bigger-120"></i>
				普通用户
			</a>
		</li>

		<li onclick="init()">
			<a data-toggle="tab" href="#faq-tab-2">
				<i class="green icon-user bigger-120"></i>
				平台店铺
			</a>
		</li>
	</ul>

	<div class="tab-content no-border">
		<div id="faq-tab-1" class="tab-pane fade in active">
			<form id="userInfoFormAdd">
				<div class="ui-table ui-widget ui-corner-all ui-border">
					<table class="table">
					<tr>
					<td class="inputLabelTd"><span class="required">*</span>登录账号：</td>
					<td class="inputTd"><input id="edit_userAccount"
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
						class="search_select choose_select">
							<c:forEach var="role" items="${roleList}">
								<option value="${role.roleId}">${role.roleName}</option>
							</c:forEach>
					</select></td>
					<td class="inputLabelTd">组别</td>
					<td class="inputTd">
					<select name="userGroup"
						class="search_select">
							<c:forEach var="userGroup" items="${userGroupList}">
								<option value="${userGroup.id}" <c:if test="${userGroup.id==userGroupId}">selected</c:if>>${userGroup.groupName}</option>
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
			</div>

			</form>
			</div>
			<div id="faq-tab-2" class="tab-pane fade">
				<form id="userInfoFormAdd">
				<div class="ui-table ui-widget ui-corner-all ui-border">
					<table class="table">
					<!-- 添加平台店铺信息 -->
					<tr>
						<td class="inputLabelTd">店铺名称：</td>
						<td class="inputTd">
							<input style="cursor:pointer" onclick="chooseStore()" data-rel="tooltip" name="storeName" type="text" id="edit_storeName" placeholder="从店铺信息中选择" title="点击选择店铺" data-placement="bottom" />
							<span class="help-button" data-rel="popover" data-trigger="hover" data-placement="left" data-content="More details." title="Popover on hover">?</span>
							<input id="edit_storeId" name="storeId" type="hidden"/> 
							<input id="fullName" name="fullName" type="hidden"/> 
						</td>
						<td class="inputLabelTd">组别</td>
							<td class="inputTd">
							<select name="userGroup"
								class="search_select">
									<c:forEach var="userGroup" items="${userGroupList}">
										<option value="${userGroup.id}" <c:if test="${userGroup.id==userGroupId}">selected</c:if>>${userGroup.groupName}</option>
									</c:forEach>
						</select></td>
						<!-- <td class="inputLabelTd">平台类别：</td>
						<td class="inputTd">
							<select id="edit_platformType" name="platformType"
							class="search_select">
							</select>
						</td> -->
					</tr>
					<tr>
						<td class="inputLabelTd">平台店铺序号：</td>
						<td class="inputTd">
							<input id="edit_platformStoreIndex" name="platformStoreIndex" type="text" class="text" value="${platformStore.platformStoreIndex}"/>
						</td>
						<td class="inputLabelTd">评分：</td>
						<td class="inputTd">
							<div class="knob-container inline">
								<input type="text" name="platformStoreScore" class="input-small knob" value="80" data-min="0" data-max="100" data-step="5" data-width="40" data-height="40" data-thickness=".2" />
							</div>
						</td>
					</tr>
					<tr>
						<td class="inputLabelTd">市场经理：</td>
						<td class="inputTd">
							<input id="edit_marketingManager" name="marketingManager" type="text" class="text" value="${platformStore.marketingManager}"/>
						</td>
						<td class="inputLabelTd">市场经理电话：</td>
						<td class="inputTd">
							<span class="input-icon">
								<input id="edit_marketingManagerTel" name="marketingManagerTel" type="text" class="text" value="${platformStore.marketingManagerTel}"/>
								<i class="icon-phone green"></i>
							</span>
						</td>
					</tr>
					<tr>
					<td class="inputLabelTd"><span class="required">*</span>登录账号：</td>
					<td class="inputTd"><input id="edit_userAccount"
						name="userAccount" type="text" class="text"
						value="${userInfo.userAccount}" /></td>
					<td class="inputLabelTd">角色</td>
					<td class="inputTd">
					<select id="edit_roleId" name="roleId"
						class="search_select">
							<option value="${platformStoreRole.roleId}">${platformStoreRole.roleName}</option> 
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
			</div>

			</form>
			</div>
</div>
</div>

</body>
</html>
