<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<title></title>
<script type="text/javascript">
var gridObj = {};
var Model = {
		url:"<m:url value='/storeSpecialOffer/listStoreSpecialOffer.do'/>",
		colModel:[
			{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
			{name : "storeName",label:"店铺名称",index : "store_name"},				
			{name : "specialOfferBeginDate",label:"特价结算时间起",index : "special_offer_begin_date"},				
			{name : "specialOfferEndDate",label:"特价结算时间止",index : "special_offer_end_date"},				
			{name : "specialOfferFoodName",label:"特价结算菜品名称",index : "special_offer_food_name"},				
			{name : "specialOfferFoodOrginPrice",label:"特价结算菜品原价",index : "special_offer_food_orgin_price"},				
			{name : "specialOfferFoodPrice",label:"特价结算价格",index : "special_offer_food_price"},				
			{name : "specialType",label:"是否分前缀",index : "special_type"
				,formatter:GridColModelForMatter.fontAddressFlag}				
       		],
		};
	$(function(){
		gridObj = List.createGrid(Model.url,Model.colModel,"store_name", false);
    });
 
    //新增的弹出框
	var add_iframe_dialog;
	//修改的弹出框
   	var edit_iframe_dialog;
	//查看的弹出框
	var show_iframe_dialog;
  	
  	function add(){
		var url="<m:url value='/storeSpecialOffer/toAddStoreSpecialOffer.do'/>";
		var title = "商铺特价菜增加";
		add_iframe_dialog = Add.create(url, title);
		List.openDialog(add_iframe_dialog);
  	}
  	function closeAdd(){
		List.closeDialog(add_iframe_dialog,gridObj);
	}
    function edit(){
    	var key = ICSS.utils.getSelectRowData("id");
		var url = baseUrl+'/storeSpecialOffer/toEditStoreSpecialOffer.do';
		var title ="商铺特价菜编辑";
		edit_iframe_dialog = Edit.create(key, url, title);
		List.openDialog(edit_iframe_dialog);
    }
    function closeEdit(){
    	List.closeDialog(edit_iframe_dialog,gridObj);
	}
    
    function show(){
    	var key = ICSS.utils.getSelectRowData("id");
		var url = baseUrl+'/storeSpecialOffer/toShowStoreSpecialOffer.do';
		var title = "商铺特价菜详情";
		show_iframe_dialog = Show.create(key, url, title);
		List.openDialog(show_iframe_dialog);
    }
    function closeShow(){
		List.closeDialog(show_iframe_dialog);
	}
    //删除
    function batchDelete(){
    	var id = ICSS.utils.getSelectRowData("id");
    	var url = baseUrl+'/storeSpecialOffer/deleteStoreSpecialOffer.do';
		List.batchDelete(id, url,gridObj);
    }
    </script>
</head>
<body style="height:100%;">

	<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
			<div class="search border-bottom">
				<ul>
				<li><span>商户名称：</span>
					<select class="search_select choose_select" name="storeName" id="storeName">
						<c:if test="${isAdmin}"><option value = "">所有店铺</option></c:if>
						<c:forEach var="store" items="${store}">
							<option value="${store.storeName}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</li>
				<li>
				<input type="text" name="specialOfferFoodName" id="specialOfferFoodName" class="search_choose" placeholder="菜品名称">
				</li>
				<li>
					<select class="search_select" name="specialType" id="specialType">
							<option value="">所有</option>
					 		<option value="1">不分前缀</option>
						 	<option value="2">分前缀</option>
					</select>
					<span>是否分前缀:</span>
				</li>
				<li>
				<input type="reset" class="reset_btn" onclick="List.resetForm('queryForm')" value="重置">
				<input type="button" class="search_btn mr22 " onclick="List.doSearch(gridObj);" value="查询"></li>
			</ul> 
		   </div>
	    </form>
		<div class="listplace">
		<!--功能按钮begin-->
		<div class="list_btn_bg fl"><!--功能按钮 div-->
			<ul>
				<c:if test="${add}">
					<li><a title="<m:message code="button.add"/>" href="javascript:;"
						onclick="add();"> <i class="icon_bg icon_add"> </i> <span><m:message
									code="button.add" /></span>
					</a></li>
				</c:if>
				<c:if test="${edit}">
					<li><a title="<m:message code="button.edit"/>" href="javascript:;"
						onclick="edit();"><i class="icon_bg icon_edit"></i> <span><m:message
									code="button.edit" /></span> </a></li>
				</c:if>
				<c:if test="${delete}">
					<li><a title="<m:message code="button.delete"/>" href="javascript:;"
						onclick="batchDelete();"> <i class="icon_bg icon_del"></i> <span><m:message
									code="button.delete" /></span>
					</a></li>
				</c:if>
				<li><a title="<m:message code="button.view"/>" href="javascript:"
					onclick="show();"> <i class="icon_bg icon_ckxq"></i> <span><m:message
								code="button.view" /></span>
				</a></li>
			</ul>
		</div>
	
	<!--功能按钮end-->
		<div class="listtable_box">
			<!--此处放表格-->
		<table  id="remote_rowed" ></table>
		<div  id="remote_prowed"></div>		
		</div>
		</div>
	</div>
</body>
</html>
