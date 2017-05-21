<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html  >
<html>
<head>
<%@ include file="../../common/header.jsp"%>
 <script type="text/javascript">
$(function() {
	//绑定提交按钮click事件
	$("#submit").click(function() {
		if(!biz.validate("valid",$('#userGroupFormEdit')[0])){
			showWarn("数据验证失败",3000);
			return;
		}
		var options = {
			url : "<m:url value='/userGroup/updateUserGroup.do'/>",
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
		$('#userGroupFormEdit').ajaxSubmit(options);
	});
	new biz.select({//状态下拉
	    id:"#edit_groupStates",
	    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=status'/>",
	    value:"${role.states}"
	});
	/*编辑表单数据验证*/
	new biz.validate({
		id:"#userGroupFormEdit",
		rules:{
		}
	}); 
});

</script>
</head>
  
<body>
	<form id="userGroupFormEdit" >
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<input type="hidden" id="edit_id" name="id" type="text" value="${userGroup.id}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">上级名称：</td>
				<td class="inputTd">
					<select name="groupPId" class="search_select">
							<c:forEach var="userGroupList" items="${userGroupList}">
								<option value="${userGroupList.id}" <c:if test="${userGroup.groupPId==userGroupList.id}">selected</c:if>>${userGroupList.groupName}</option>
							</c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">小组名称：</td>
				<td class="inputTd">
					<input id="edit_groupName" name="groupName" type="text" class="text" value="${userGroup.groupName}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">组别描述：</td>
				<td class="inputTd">
					<input id="edit_groupDesc" name="groupDesc" type="text" class="text" value="${userGroup.groupDesc}"/>
				</td>
				<td class="inputLabelTd">组别状态：</td>
				<td class="inputTd">
					<select id="edit_groupStates" name="groupStates" class="search_select"></select>
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
