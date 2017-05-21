<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<style>
	.ace-file-input{width:180px;position: relative;height: 38px; line-height: 38px; margin:0; display:inline-block;float:left;}
	.upload{margin-left: 15px;}
</style>
<script type="text/javascript">
$(function() {
	//select多选 初始化方法
	/*  $(".choose_select").chosen(); 
	$('.number').ace_spinner({value:0,min:0,max:200000,step:1, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
	$('.timepicker').timepicker({
		minuteStep: 1,
		showSeconds: true,
		showMeridian: false
	}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});  */
	$('input[type="file"]').on('change',function(){
    	$(this).parent().parent().find('.realImage_submit').val("上传");
    	$(this).parent().parent().find('.path').val($(this).val());
    	var extend=$(this).val().split('.').pop().toLowerCase();
			if("gif|png|jpg|jpeg|svg".indexOf(extend)==-1){
				 showInfo("请上传图片格式文件！",3000);
				 $(this).parent().parent().find('.realImage_submit').prop("disabled",true);
				 return;
	         }else{
	        	 $(this).parent().parent().find('.realImage_submit').prop("disabled",false);
	         }
	});
	
	new biz.select({//产品状态下拉
	    id:"#edit_productStatus",
	    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=productStatus'/>",
	});
	//绑定提交按钮click事件
	$("#submit").click(function() {
		$("#submit").prop('disabled', true).css({'cursor':'not-allowed'});showMessage("正在处理...");
		if(!biz.validate("valid",$('#productFormEdit')[0])){
			showWarn("数据验证失败",3000);
			$("#submit").prop('disabled', false).css({'cursor':'pointer'});
			return;
		}
		var options = {
			url : "<m:url value='/product/addProduct.do'/>",
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
		$('#productFormEdit').ajaxSubmit(options);
	});

	/* 
	new biz.validate({
		id:"#productFormEdit",
		rules:{
		}
	});  */
});
</script>
</head>
  
<body>
	<form id="productFormEdit" > 
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<input type="hidden" id="edit_productId" name="productId" type="text" value="${product.productId}"/>
		<table class="table">
			<tr>
				<td class="inputLabelTd">产品类别：</td>
				<td class="inputTd">
					<select class="search_select choose_select" name="productClassId" id="edit_productClassId">
						<option value="">--请选择--</option>
						<c:forEach var="productClass" items="${productClass}">
							<option value="${productClass.productClassId}"<c:if test="${productClass.productClassId==productClassId}">selected</c:if>> <c:out value="${productClass.productClassName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
				<td class="inputLabelTd">产品名称：</td>
				<td class="inputTd">
					<input id="edit_productName" name="productName" type="text" class="text" value="${product.productName}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品图片：</td>
				<td class="inputTd">
					<form method="post" id="realImageForm" target="realImageIframe" enctype="multipart/form-data" action="<%=request.getContextPath()%>/common/fileUpload">
						<input id="image_storeName" name="image_storeName"  class="text" type="hidden" value="storeName"/><!-- 商铺名称作为文件夹名称 -->
						<input type="file" class="text" name="image"/>
						<input id="edit_productImagePath" name="productImagePath" type="hidden" class="path"/><!-- 数据库保存地址 -->
						<input type="button" class="realImage_submit btn btn-xs spinner-up btn-success upload" value="上传" disabled><!--上传按钮-->
					</form>
				</td>
				<td class="inputLabelTd">产品单价：</td>
				<td class="inputTd">
					<input id="edit_productUnitPrice" name="productUnitPrice" type="text" class="text number" value="${product.productUnitPrice}"/>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">库存数量：</td>
				<td class="inputTd">
					<input id="edit_productStocks" name="productStocks" type="text" class="text number" value="${product.productStocks}"/>
				</td>
				<td class="inputLabelTd">产品状态：</td>
				<td class="inputTd">
					<select class="search_select" name="productStatus" id="edit_productStatus">
					</select>
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
