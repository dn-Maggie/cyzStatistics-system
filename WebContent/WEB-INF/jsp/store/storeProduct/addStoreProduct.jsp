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
	$('.realImage_submit').click(function(){
		if(!$("#edit_storeId").val()) {showMessage("请先填写店铺名称"); return;}
		if(!$("#edit_productClassName").val()) {showMessage("请填写产品类别"); return;}
		$(this).parent().find('#image_productClassName').val($.trim($("#edit_storeId").find("option:selected").text()));
		var btnObj = $(this);
		var $realPathobj = $(this).parent().find('.path')[0]; 
		var options = {
			url : "<%=request.getContextPath()%>/common/fileUpload",
			type : "post",
			dataType:"json", 
			processData: false,
	        contentType: false, 
			success : function(d) {
				if(d&&d.respCode == '0000'){
					$realPathobj.value = d.picAddr; 
					btnObj.val("上传成功")
				}else{
					showMessage("图片上传失败");
				}
			},
			error:function(){
				showMessage("图片上传失败");
			}
		};
		$(this).parent('#realImageForm').ajaxSubmit(options);
	});
	new biz.select({//产品状态下拉
	    id:"#edit_productStatus",
	    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=productStatus'/>",
	});
	//绑定提交按钮click事件
	$("#submit").click(function() {
		$("#submit").prop('disabled', true).css({'cursor':'not-allowed'});
		showMessage("正在处理...");
		var paramDatas = {
				storeId:$("#edit_storeId").val(),
				productClassId:$("#edit_productClassId").val(),
				productClassName:$("#edit_productClassName").val(),
				productId:$("#edit_productId").val(),
				productName:$("#edit_productName").val(),
				productImagePath:$("#edit_productImagePath").val(),
				productStatus:$("#edit_productStatus").val(),
				productUnitPrice:$("#edit_productUnitPrice").val(),
				productStocks:$("#edit_productStocks").val(),
				merchantDiscount:$("#edit_merchantDiscount").val(),
				/* merchantDiscountBegin:$("#edit_merchantDiscountBegin").val(),
				merchantDiscountEnd:$("#edit_merchantDiscountEnd").val(), */
				specialOffer:$("#edit_specialOffer").val(),
				/* specialOfferBegin:$("#edit_specialOfferBegin").val(),
				specialOfferEnd:$("#edit_specialOfferEnd").val() */
			};
		$.ajax({
	 		   type: "post",
	 		   url : "<m:url value='/storeProduct/addStoreProduct.do'/>",
	 		   data: paramDatas,
	 		   cache: false,
	 		   dataType:"json",
	           error: function() {
	          	showMessage("请求失败");
	          	$("#submit").prop('disabled', false).css({'cursor':'pointer'});
	           },
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
	 		});
	});
/* 
	new biz.validate({
		id:"#storeProductFormEdit",
		rules:{
		}
	});  */
});
/*自动完成(Autocomplete) 根据用户输入值进行搜索和过滤,让用户快速找到并从预设值列表中选择*/
function getproductClassIdByName(obj,value) {
	var did = $("#productClassList").find("option[value="+value+"]").data('pcid')
	$(obj).parents('.inputTd').find("#edit_productClassId").val(did);
}
/*自动完成(Autocomplete) 根据用户输入值进行搜索和过滤,让用户快速找到并从预设值列表中选择*/
function getproductIdByName(obj,value) {
	var did = $("#productList").find("option[value="+value+"]").data('pid')
	$(obj).parents('.inputTd').find("#edit_productId").val(did);
}

//产品列表的弹出框
	var mrselect_iframe_dialog;
//从产品信息表中选择
function addProducts(){
	var url="<m:url value='/product/toSelectProduct.do'/>?key=${storeId}";
	mrselect_iframe_dialog = new biz.dialog({
		id:$('<div id="mrselect_window_iframe"></div>').html('<iframe id="iframeMrSelect" name="iframeMrSelect" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
		modal: true,
		width: $(window).width()*0.6,
		height:$(window).width()*0.6,
		title: "产品资源"
	});
	mrselect_iframe_dialog.open();
}
function closeMrSelect(){
	mrselect_iframe_dialog.close();
}
//填充数据
function drawForm(rowData) {
	$("#edit_productId").val(rowData.productId);
	$("#edit_productName").val(rowData.productName);
	$("#edit_productClassId").val(rowData.productClassId);
	$("#edit_productClassName").val(rowData.productClassName);
}
</script>
</head>
  
<body>
	<!--功能按钮begin-->
	<div class="listplace" style="position:absolute;top:0;">
		<div class="list_btn_bg fl"><!--功能按钮 div-->
		<ul>
		<li><a title="从产品列表中选择" href="javascript:;" onclick="addProducts();">
			<i class="back_icon resources_icon"></i>
			<span>从产品列表中选择</span>
		</a></li>
			</ul>
		</div>
	</div>
	<!-- <form id="storeProductFormEdit" style="margin-top:40px"> -->
    <div class="ui-table ui-widget ui-corner-all ui-border" style="margin-top:40px">
		<input type="hidden" id="edit_storeProductId" name="storeProductId" value="${storeProduct.storeProductId}"/>
		<%-- <input id="edit_storeId" name="storeId" type="hidden" value="${storeId}"/> --%>
		<table class="table" style="height:auto">
			<tr>
				<td class="inputLabelTd">店铺名称：</td>
				<td class="inputTd">
					<select class="search_select choose_select" name="storeId" id="edit_storeId">
						<option value="">--请选择--</option>
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"<c:if test="${storeId==store.storeId}">selected</c:if>> <c:out value="${store.storeName}"></c:out> </option>
			             </c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品类别：</td>
				<td class="inputTd">
					<input id="edit_productClassId" name="productClassId" type="hidden" value="${storeProduct.productClassId}"/>
					<input id="edit_productClassName" name="productClassName" type="text" class="search_select" 
						value="${storeProduct.productClassName}" list="productClassList"
						oninput="getproductClassIdByName(this,this.value);"/>
					<datalist id="productClassList">
						<c:forEach items="${productClass}" var="productClass">
							<option data-pcid="${productClass.productClassId}" value="${productClass.productClassName}" label="${productClass.productClassName}"></option>
						</c:forEach>
					</datalist>
				</td>
				<td class="inputLabelTd">产品名称：</td>
				<td class="inputTd">
					<input id="edit_productId" name="productId" type="hidden" value="${storeProduct.productId}"/>
					<input id="edit_productName" name="productName" type="text" class="search_select"
						value="${storeProduct.productName}" list="productList"
						oninput="getproductIdByName(this,this.value);"/>
					<datalist id="productList">
						<c:forEach items="${product}" var="product">
							<option data-pid="${product.productId}" value="${product.productName}" label="${product.productName}"></option>
						</c:forEach>
					</datalist>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品图片：</td>
				<td class="inputTd">
					<form method="post" id="realImageForm" target="realImageIframe" enctype="multipart/form-data" action="<%=request.getContextPath()%>/common/fileUpload">
						<input id="image_productClassName" name="product" class="text" type="hidden" value="productClassName"/><!-- 类名名称作为文件夹名称 -->
						<input type="file" class="text" name="image"/>
						<input id="edit_productImagePath" name="productImagePath" type="hidden" class="path"/><!-- 数据库保存地址 -->
						<input type="button" class="realImage_submit btn btn-xs spinner-up btn-success upload" value="上传" disabled><!--上传按钮-->
					</form>
				</td>
				<td class="inputLabelTd">产品状态：</td>
				<td class="inputTd">
					<select name="productStatus" class="search_select" id="edit_productStatus"></select>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">产品单价：</td>
				<td class="inputTd">
					<input id="edit_productUnitPrice" name="productUnitPrice" type="text" class="text number" />
				</td>
				<td class="inputLabelTd">库存数量：</td>
				<td class="inputTd">
					<input id="edit_productStocks" name="productStocks" type="text" class="text number" />
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品折扣：</td>
				<td class="inputTd">
					<input id="edit_merchantDiscount" name="merchantDiscount" type="text" class="text number" />
				</td>
				<td class="inputLabelTd">签订特价结算金额：</td>
				<td class="inputTd">
					<input id="edit_specialOffer" name="specialOffer" type="text" class="text number"/>
				</td>
			</tr>
			<!-- <tr>
				<td class="inputLabelTd">菜品折扣时间起：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="merchantDiscountBegin" id="edit_merchantDiscountBegin" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">菜品折扣时间止：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="merchantDiscountEnd" id="edit_merchantDiscountEnd" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
			</tr>
			<tr>
				<td class="inputLabelTd">签订特价结算时间起：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="specialOfferBegin" id="edit_specialOfferBegin" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
				<td class="inputLabelTd">签订特价结算时间止：</td>
				<td class="inputTd">
					<div class="input-group">
						<input class="date-picker text" name="specialOfferEnd" id="edit_specialOfferEnd" type="text" data-date-format="yyyy-mm-dd" />
						<span>
							<i class="icon-calendar bigger-110"></i>
						</span>
					</div>
				</td>
			</tr> -->
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input id="submit" type="button" class="ti_bottom" value="保存"/>
				</td>
			</tr>
		</table>
    </div>
	<!-- </form> -->
</body>
</html>
