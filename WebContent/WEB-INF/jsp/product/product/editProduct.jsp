<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script type="text/javascript">
$(function() {
	/* $('.number').ace_spinner({min:0,max:999999,step:1, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'}); */
	$('input[type="file"]').ace_file_input({
		no_file:'请选择...',
		btn_choose:'选择',
		btn_change:'更换',
		droppable:false,
		onchange:null,
		thumbnail:false,
		whitelist:'gif|png|jpg|jpeg'
		//blacklist:'exe|php'
		//onchange:''
		//
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

	/*编辑表单数据验证*/
	new biz.validate({
		id:"#productFormEdit",
		rules:{
		}
	}); 
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
							<option value="${productClass.productClassId}"<c:if test="${product.productClassId==productClass.productClassId}">selected</c:if>> <c:out value="${productClass.productClassName}"></c:out> </option>
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
					<input id="edit_productImagePath" name="productImagePath" type="file" class="text" value="${product.productImagePath}"/>
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
						<option></option>
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
