<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="../../common/header.jsp"%>
</head>
<body style="height: 100%;">
	<div class="main  choice_box" style="height: 100%; float: left; width: 22%">
		<div class="ui-table ui-widget ui-corner-all ui-margin ui-leftDiv">
			<form id="queryForm1" style="height:auto">
				<div id="equal1" class="equal">
					<table class="top_table">
						<tr>
							<td class="rightSide">产品类名:</td>
							<td><input type="text" name="productClassName" id="productClassName" onkeyup="initProductClassTree();"/></td>
						</tr>
					</table>
				</div>
			</form>
			<ul id="productClassTree" class="ztree" style="height: 350px; margin-top: 0; border-top: 1px solid #ddd; position: relative; overflow: auto; width: 97%">
			</ul>
		</div>
	</div>
	<div class="main  choice_box">
		<div class="ui-table ui-widget ui-corner-all ui-margin ui-rightDiv"
			style="display: block;">
			<form id="queryForm">
				<!-- 查询区 表单 -->
				<input type="hidden" id="typeCode" value="" /> 
				<input type="hidden" id=productClassId name="productClassId" value="" />
				<div class="search border-bottom">
					<ul>
						<li style="width: 320px; float: left;"><span>关键字:</span> 
						<input id="productClassName" type="text" placeholder="产品类名" class="search_choose100" value="" name="productClassName" autocomplete="off">
						<input id="productName" type="text" placeholder="产品名称" class="search_choose100" value="" name="productName" autocomplete="off">
						</li>
						<li><input type="reset" value="重置" onClick="resetForm('queryForm')" class="reset_btn">
						<!-- 重置 --> <input type="button" value="查询" onclick="doSearch();" class="search_btn mr22 " /></li>
						<!-- 查询-->
					</ul>
				</div>
			</form>

			<!--功能按钮begin-->
			<div class="list_btn_bg fl" style="z-index: 2">
				<!--功能按钮 div-->
				<ul>
						<li><a title="<m:message code="button.add"/>"
							href="javascript:;" onclick="addProduct();"> <i
								class="icon_bg icon_add"> </i> <span><m:message
										code="button.add" /></span>
						</a></li>
						<li><a title="<m:message code="button.edit"/>"
							href="javascript:;" onclick="editProduct();"><i
								class="icon_bg icon_edit"></i> <span><m:message
										code="button.edit" /></span> </a></li>
						<li><a title="<m:message code="button.delete"/>"
							href="javascript:;" onclick="batchDelete();"> <i
								class="icon_bg icon_del"></i> <span><m:message
										code="button.delete" /></span>
						</a></li>
					<li><a title="<m:message code="button.view"/>"
						href="javascript:" onclick="showProduct();"> <i
							class="icon_bg icon_ckxq"></i> <span><m:message
									code="button.view" /></span>
					</a></li>
				</ul>
			</div>
			<!--功能按钮end-->
			<table id="productTable"></table>
			<div id="productPager"></div>
		</div>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		initProductClassTree();
		initProductTable();
	});

	var productClassTree;
	//新增框
	var add_iframe_dialog;
	//编辑窗
	var edit_iframe_dialog;
	//展示窗
	var show_iframe_dialog;
	//产品信息
	var gridObj = {};


	//供子页面调用
	function closeEdit() {
		edit_iframe_dialog.close();
	}

	function closeAdd() {
		add_iframe_dialog.close();
	}

	function initProductClassTree() {
		$.ajax({
			url : "<m:url value='/productClass/initProductClassTree.do'/>",
			data : {
				productClassName : $('#productClassName').val()
			},
			type : "POST",
			dataType:"json",
			success : function(data, textStatus, jqXHR) {
				var setting_checkbox = {
						data : {},
						id : "#productClassTree",
						nodes :data, // 数据节点指定
						data : {
							simpleData : {
								enable : true
							}
						},
						callback : {
							onClick : treeOnClick
						}
					};
				productClassTree = new biz.tree(setting_checkbox);// 创建树
			}
		});
	}
	
	function treeOnClick(event, treeId, treeNode) {//获取预设的查询条件
		if(!treeNode.isParent){//如果不是顶
			var productClassId = treeNode.id;
			$('#productClassId').val(productClassId);
			doSearch();
		}
	}

	//初始化表格
	function initProductTable() {
		gridObj = new biz.grid({
			id : "#productTable",/*html部分table id*/
			url: "<m:url value='/product/listProduct.do'/>",/*grid初始化请求数据的远程地址*/
			datatype : "json",/*数据类型，设置为json数据，默认为json*/
			colModel:[
						{name : "productId",hidden : true,key : true,label:"产品ID(主键)",index : "PRODUCT_ID"},				
						{name : "productClassName",label:"产品分类",index : "PRODUCT_CLASS_ID"},				
						{name : "productName",label:"产品名称",index : "PRODUCT_ID"},				
						{name : "productImagePath",label:"产品图片地址",index : "PRODUCT_IMAGE_PATH"},				
						{name : "productUnitPrice",label:"产品单价",index : "PRODUCT_UNIT_PRICE"},				
						{name : "productStocks",label:"库存数量",index : "PRODUCT_STOCKS"},				
						{name : "productStatus",label:"产品状态",index : "PRODUCT_STATUS"
							,formatter:GridColModelForMatter.productStatus}								
		           	],
			sortname : "PRODUCT_STOCKS",
			sortorder : "desc",
			pager : '#productPager' /*分页栏id*/,
			rowList : [ 10, 15, 50, 100 ],//每页显示记录数
			serializeGridData : function(postData) {//添加查询条件值
				var obj = getQueryCondition();
				$.extend(true, obj, postData);//合并查询条件值与grid的默认传递参数
				return obj;
			},
			rowNum : 10,//默认显示15条
		});
	}

	/**
	 * 获取查询条件值
	 */
	function getQueryCondition() {
		var obj = {};
		ICSS.utils.addAttrToObject(obj, "productClassName");
		ICSS.utils.addAttrToObject(obj, "productName");
		ICSS.utils.addAttrToObject(obj, "productClassId");
		ICSS.utils.addAttrToObject(obj, "productStatus");
		return obj;
	}
	
	function doSearch(isStayCurrentPage) {
		if(!isStayCurrentPage)gridObj.setGridParam({"page" : "1"});
		gridObj.trigger('reloadGrid');
	}
	 //重置查询表单
    function resetForm(formId){
		document.getElementById(formId).reset();
		initProductClassTree();
		$("#"+formId+" input[type='hidden']").val(""); 
		doSearch();
	}
	function addProduct() {
		var nodes = productClassTree.getSelectedNodes();
		if(nodes.length != 1|| nodes[0].isParent){
			var url = "productClass/toAddProductClass.do";
			add_iframe_dialog = new biz.dialog({
				id : $('<div id="addwindow_iframe"></div>').html('<iframe id="iframeAdd" name="iframeAdd" src="' + url + '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
				modal : true,
				width : 550,
				height : 320,
				title : "增加产品类别"
			});
			add_iframe_dialog.open();
			return;
		}
		
		var url = "product/toAddProduct.do?productClassId=" + nodes[0].id;
		add_iframe_dialog = new biz.dialog({
			id : $('<div id="addwindow_iframe"></div>').html('<iframe id="iframeAdd" name="iframeAdd" src="' + url + '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
			modal : true,
			width : 550,
			height : 320,
			title : "增加产品信息"
		});
		add_iframe_dialog.open();
	}

	//删除
	function batchDelete() {
		var ids = ICSS.utils.getSelectRowData("productId");
		if (ids == "") {
			var nodes = productClassTree.getSelectedNodes();
			if(nodes.length != 0 && !nodes[0].isParent){
				new biz.alert({
					type : "confirm",
					message : "确定删除该类别以及改类别下所有产品？",
					title : I18N.promp,
					callback : function(r) {
						if (r) {
							$.ajax({
								url: "<m:url value='/productClass/deleteProductClass.do'/>?key="+nodes[0].id,
								cache : false,
								success : function(data, textStatus, jqXHR) {
									initProductClassTree();
									initProductTable();
									showInfo("<m:message code='delete.success'/>", 3000);
								}
							});
						}
					}
				});
				return;
			}
		} else {
			new biz.alert({
				type : "confirm",
				message : I18N.msg_del_confirm,
				title : I18N.promp,
				callback : function(r) {
					if (r) {
						$.ajax({
							url: "<m:url value='/product/deleteProduct.do'/>?key="+ids,
							cache : false,
							success : function(data, textStatus, jqXHR) {
								doSearch();
								showInfo("<m:message code='delete.success'/>", 3000);
							}
						});
					}
				}
			});
		}
	}

	//编辑
	function editProduct() {
		var key = ICSS.utils.getSelectRowData("productId");
		if (key.indexOf(",") > -1) {
			showMessage("<m:message code='grid.edit.chooseColAlert'/>");
			return;
		}
		if(key ==""){
			var nodes = productClassTree.getSelectedNodes();
			if (nodes.length != 0 && !nodes[0].isParent) {
				var url = "productClass/toEditProductClass.do?key=" + nodes[0].id;
				edit_iframe_dialog = new biz.dialog({
					id : $('<div id="editwindow_iframe"></div>').html('<iframe id="iframeEdit" name="iframeEdit" src="' + url + '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
					modal : true,
					width : 550,
					height : 320,
					title : "编辑产品类别"
				});
				edit_iframe_dialog.open();
				return;
			} 
		}
		var url="<m:url value='/product/toEditProduct.do'/>?key="+key;
		edit_iframe_dialog = new biz.dialog({
					id : $('<div id="editwindow_iframe"></div>').html('<iframe id="iframeEdit" name="iframeEdit" src="' + url + '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
					modal : true,
					width : 550,
					height : 320,
					title : "编辑产品信息"
				});
		edit_iframe_dialog.open();
	}

	//展示
	function showProduct() {
		var key = ICSS.utils.getSelectRowData("productId");
		if (key.indexOf(",") > -1 || key == "") {
			showMessage("<m:message code='grid.view.chooseColAlert'/>");
			return;
		}
		var url="<m:url value='/product/toShowProduct.do'/>?key="+key;
		show_iframe_dialog = new biz.dialog({
					id : $('<div id="showwindow_iframe"></div>').html('<iframe id="iframeShow" name="iframeShow" src="' + url + '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
					modal : true,
					width : 550,
					height : 320,
					title : "产品信息详细"
				});
		show_iframe_dialog.open();
	}

	function closeShow() {
		show_iframe_dialog.close();
	}
</script>
</html>