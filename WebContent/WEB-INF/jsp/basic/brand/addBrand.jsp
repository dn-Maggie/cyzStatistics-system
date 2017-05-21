<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>

<script type="text/javascript">
$(function() {
	//绑定提交按钮click事件
	$("#submit").click(function() {
		$("#submit").prop('disabled', true).css({'cursor':'not-allowed'});showMessage("正在处理...");
		if(!biz.validate("valid",$('#brandFormEdit')[0])){
			showWarn("数据验证失败",3000);
			$("#submit").prop('disabled', false).css({'cursor':'pointer'});
			return;
		}
		var options = {
			url : "<m:url value='/brand/addBrand.do'/>",
			type : "post",
				dataType:"json",
				success : function(d) {
					if(d.status){
						showMessage("操作成功","","",function(){
							window.parent.closeAdd();
							List.doSearch(window.parent.gridObj);
						});
					}else{
						showMessage("操作失败");
					}
				}
		};
		// 将options传给ajaxForm
		$('#brandFormEdit').ajaxSubmit(options);
	});

	
	new biz.validate({
		id:"#brandFormEdit",
		rules:{
			"brandName":{required : true},
			"contactName":{required : true},
			"merchantName":{required : true},
			"brandManagerTel" : {
				required : true,
				maxlength : 11,
				naturalnum:true
			},
			"contactTel" : {
				required : true,
				maxlength : 11,
				naturalnum:true
			},
			"merchantTel" : {
				required : true,
				maxlength : 11,
				naturalnum:true
			},
		}
	});  
	
	
});
//地区二级联动
 function regionCodeChange(obj){
	var val = $(obj).find("option:selected").val();
	$ .ajax({
		url: "<m:url value='/chinaArea/loadAreaByParent.do'/>?pid="+val,
		cache:false,
		dataType:"json",
		success: function(data, textStatus, jqXHR){
			$('#edit_regionCode option').remove();
			$('#edit_cityCode option').remove();
			for(var i = 0 ;i<data.length;i++){
				$('#edit_regionCode').append('<option value="'+data[i].id+'">'+data[i].name+' </option>');
			}
			if(!data){
				$('#edit_regionCode').append('<option value="">--请选择--</option>');
				$('#edit_cityCode').append('<option value="">--请选择--</option>');
			} 
			$("#edit_regionCode").change();
		}
	});
}

//地区三级联动
function cityCodeChange(obj){
	var val = $(obj).find("option:selected").val();
	$ .ajax({
		url: "<m:url value='/chinaArea/loadAreaByParent.do'/>?pid="+val,
		cache:false,
		dataType:"json",
		success: function(data, textStatus, jqXHR){
			$('#edit_cityCode option').remove();
			for(var i = 0 ;i<data.length;i++){
				$('#edit_cityCode').append('<option value="'+data[i].id+'">'+data[i].name+'</option>');
			}
			if(!data){
				$('#edit_cityCode').append('<option value="">--请选择--</option>');
			} 
		}
	});
} 
</script>
</head>
  
<body>
	<form id="brandFormEdit" >
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<input type="hidden" id="edit_brandId" name="brandId" type="text" value="${brand.brandId}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">创建时间：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="createDate" id="edit_createDate" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">合同签订时间：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" id="edit_signContractDate" name="signContractDate" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">品牌名称：</td>
				<td class="inputTd">
					<input id="edit_brandName" name="brandName" type="text" class="text" value="${brand.brandName}"/>
				</td>
				<td class="inputLabelTd">品牌负责人：</td>
				<td class="inputTd">
					<input id="edit_brandManager" name="brandManager" type="text" class="text" value="${brand.brandManager}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">负责人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_brandManagerTel" name="brandManagerTel" type="text" class="text" value="${brand.brandManagerTel}"/>
						<i class="icon-phone green"></i>
					</span>
				</td>
				<td class="inputLabelTd">门店数量：</td>
				<td class="inputTd">
					<input id="edit_storesNumber" name="storesNumber" type="text" class="number text" value="${brand.storesNumber}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">所在省份：</td>
				<td class="inputTd">
					<select
						class="search_select choose_select" onchange="regionCodeChange(this)"
						name="provinceCode" id="edit_provinceCode">
						<option value="">--请选择--</option>
							<c:forEach var="chinaArea" items="${chinaArea}">
								<option value="${chinaArea.id}"> <c:out value="${chinaArea.name}"></c:out> </option>
				             </c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">所在地市：</td>
				<td class="inputTd">
					<select 
						class="search_select" onchange="cityCodeChange(this)"
						name="regionCode" id="edit_regionCode">
						<option value="">--请选择--</option>
						<c:forEach var="ca" items="${chinaArea2}">
							<option value="${ca.id}"> <c:out value="${ca.name}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">所在区县：</td>
				<td class="inputTd">
					<select 
						class="search_select" 
						name="cityCode" id="edit_cityCode">
						<option value="">--请选择--</option>
						<c:forEach var="ca" items="${chinaArea3}">
							<option value="${ca.id}"> <c:out value="${ca.name}"></c:out> </option>
			            </c:forEach>
				    </select>
				</td>
				<td class="inputLabelTd"></td>
				<td class="inputTd"></td>
			</tr>	
			
			<tr>
				
				<td class="inputLabelTd">所属行业：</td>
				<td class="inputTd">
					<select class="search_select choose_select" name="industryId" id="edit_industryId">
						<option value="">--请选择--</option>
						<c:forEach var="industry" items="${industry}">
							<option value="${industry.industryId}"> <c:out value="${industry.industryName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">所属品类：</td>
				<td class="inputTd">
					<select class="search_select choose_select"  name="categoryId" id="edit_categoryId">
						<option value="">--请选择--</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.categoryId}"> <c:out value="${category.categoryName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				
				<td class="inputLabelTd">对接人：</td>
				<td class="inputTd">
					<input id="edit_contactName" name="contactName" type="text" class="text" value="${brand.contactName}"/>
				</td>
				<td class="inputLabelTd">对接人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_contactTel" name="contactTel" type="text" class="text" value="${brand.contactTel}"/>
						<i class="icon-phone green"></i>
					</span>
				</td>
			</tr>
			<tr>
				
				<td class="inputLabelTd">招商人：</td>
				<td class="inputTd">
					<input id="edit_merchantName" name="merchantName" type="text" class="text" value="${brand.merchantName}"/>
				</td>
				<td class="inputLabelTd">招商人电话：</td>
				<td class="inputTd">
					<span class="input-icon">
						<input id="edit_merchantTel" name="merchantTel" type="text" class="text" value="${brand.merchantTel}"/>
						<i class="icon-phone green"></i>
					</span>
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
