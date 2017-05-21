<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<script type="text/javascript">
$(function() {
	//绑定提交按钮click事件
	$("#submit").click(function() {
		$("#submit").prop('disabled', true).css({'cursor':'not-allowed'});showMessage("正在处理...");
		if(!biz.validate("valid",$('#industryFormEdit')[0])){
			showWarn("数据验证失败",3000);
			$("#submit").prop('disabled', false).css({'cursor':'pointer'});
			return;
		}
		var options = {
			url : "<m:url value='/industry/addIndustry.do'/>",
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
		$('#industryFormEdit').ajaxSubmit(options);
	});

	/*编辑表单数据验证*/
	new biz.validate({
		id:"#industryFormEdit",
		rules:{
		}
	}); 
});
</script>
</head>
  
<body>
	<form id="industryFormEdit" >
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<input type="hidden" id="edit_industryId" name="industryId" type="text" value="${industry.industryId}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">行业名称：</td>
				<td class="inputTd">
					<input id="edit_industryName" name="industryName" type="text" class="text" value="${industry.industryName}"/>
				</td>
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
