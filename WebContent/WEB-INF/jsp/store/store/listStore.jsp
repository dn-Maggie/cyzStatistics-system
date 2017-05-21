<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML  >
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<title></title>
<script type="text/javascript">
var gridObj = {};
var Model = {
		url:"<m:url value='/store/listStore.do'/>",
	 	colModel:[
			{name : "storeId",hidden : true,key : true,label:"店铺ID",index : "STORE_ID"},				
			{name : "storeName",label:"店铺名称",index : "STORE_NAME",align:"left"},				
			{name : "brandName",label:"所属品牌",index : "BRAND_ID"},				
			{name : "storeAddress",label:"店铺地址",index : "STORE_ADDRESS"},				
			{name : "registrant",label:"负责人",index : "registrant"},		
			{name : "storeOwnerName",label:"店长姓名",index : "STORE_OWNER_NAME"},	
			{name : "storeOwnerTel",label:"店长电话",index : "STORE_OWNER_TEL"},		
			/*{name : "storeType",label:"店铺类型",index : "store_type"
				,formatter:GridColModelForMatter.storeType},	*/	
			{name : "storeType",label:"店铺类型",index : "store_type"},
			{name : "isDelete",label:"营业状态",index : "is_delete"
				,formatter:GridColModelForMatter.yesno},				
			{name : "operateDate",label:"运营开始时间",index : "OPERATE_DATE"},				
			{name : "settlementMethod",label:"结算方式",index : "SETTLEMENT_METHOD"
				,formatter:GridColModelForMatter.settlementMethod},				
			{name : "storeTel",label:"店铺联系电话",index : "STORE_TEL"},				
          	],
		};
	$(function(){
		gridObj = List.createGrid(Model.url,Model.colModel,"STORE_NAME", false);
    });

	//新增的弹出框
	var add_iframe_dialog;
	//修改的弹出框
   	var edit_iframe_dialog;
	//查看的弹出框
	var show_iframe_dialog;
  	
  	function add(){
  		var add_iframe_dialog;
		var url="<m:url value='/store/toAddStore.do'/>";
		var title = "店铺增加";
		add_iframe_dialog = Add.create(url, title);
		List.openDialog(add_iframe_dialog);
  	}
  	function closeAdd(){
		List.closeDialog(add_iframe_dialog);
		List.doSearch(gridObj);
	}
  	
    function edit(){
		var key = ICSS.utils.getSelectRowData("storeId");
		var url = baseUrl+'/store/toEditStore.do';
		var title ="店铺编辑";
		edit_iframe_dialog = Edit.create(key, url, title);
		List.openDialog(edit_iframe_dialog);
    }
    function closeEdit(){
		List.closeDialog(edit_iframe_dialog,gridObj);
	}
    function show(){
    	var key = ICSS.utils.getSelectRowData("storeId");
    	var url = baseUrl+'/store/toShowStore.do';
		var title = "店铺详情";
		show_iframe_dialog = Show.create(key, url, title);
		List.openDialog(show_iframe_dialog);
    }
    function closeShow(){
		List.closeDialog(show_iframe_dialog);
	}
    //删除
    function batchDelete(){
    	new biz.alert({type:"confirm",message:"确定停止该店铺营业？（停止以后将无法继续生成报表数据）",title:I18N.promp,callback:function(result){
			if(result){
				var id = ICSS.utils.getSelectRowData("storeId");
	        	var url = baseUrl+'/store/deleteStore.do';
	        	List.batchDelete(id, url,gridObj);
			}
		}}) ;   
    }
    //导入excel数据
	function importData(){
		ExpExcel.importStore();
	}
	 //下载模板
    function downloadTemplate(){
    	ExpExcel.showStoreDownloadWin();
    }
 	//下载模板
	function executeDownload(){
		var fid = $("#downloadform");
		$("#downloadform").attr("action", "<%=request.getContextPath()%>/download/fileDownload");
		fid.submit();
	}
 	// 打开产品资源界面
    function linkStoreProduct(){
   		var key = ICSS.utils.getSelectRowData("storeId");
   		if (key.indexOf(",") > -1 || key == "") {
   			showMessage("请选择一条数据");
   			return;
   		}
   		var url = baseUrl + '/store/toListStoreProduct.do?key=' + key;
   		productList_iframe_dialog = new biz.dialog(
   				{
   					id : $('<div id="sublist_window_iframe"></div>')
   						.html(
   						'<iframe id="iframeSublist" name="iframeSublist" src="'
  						+ url
   						+ '" width="100%" frameborder="no" border="0" height="97%"></iframe>'),
   					modal : true,
   					width : $(window).width()*0.8,
   					height : $(window).height()*0.8,
   					title : "店铺产品管理"
   				});
   		productList_iframe_dialog.open();
    }
    </script>
</head>
<body style="height:100%;">
	<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
			 <div class="search border-bottom">
				<ul>
				<li><span>店铺类型：</span>
					<select class="search_select choose_select" name="categoryId" id="categoryId">
						<option value = "">所有类型</option>
						<c:forEach var="category" items="${category}">
							<option value="${category.categoryId}"> <c:out value="${category.categoryName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</li>
				<li><span>所属品牌：</span>
					<select class="search_select choose_select" name="brandId" id="brandId">
					<option value = "">所有品牌</option>
						<c:forEach var="brand" items="${brand}">
							<option value="${brand.brandId}"> <c:out value="${brand.brandName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</li>
				<li><span>商户名称：</span>
					<select class="search_select choose_select" name="storeName" id="storeName">
						<c:if test="${isAdmin}"><option value = "">所有店铺</option></c:if>
						<c:forEach var="store" items="${store}">
							<option value="${store.storeName}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</li>
				<li><input type="text" name="storeOwnerName" id="storeOwnerName" class="search_choose" placeholder="店长姓名">
				</li>
				<li>	
				<input type="text" name="storeAddress" id="storeAddress" class="search_choose" placeholder="店铺地址">
				</li>
				<li><span>店铺状态：</span>
					<select class="search_select" name="isDelete" id="isDelete">
						<option value="0">正常营业</option>
						<option value="1">已退出</option>
					</select>
				</li>
				<li>	
				<input type="text" name="storeDistMode" id="storeDistMode" class="search_choose" placeholder="配送方式">
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
						<!-- li>
							<a title="下载模板" href="javascript:" onclick="downloadTemplate();">
								<i class="icon_bg icon_download"></i><span>下载模板</span>
							</a>
						</li-->
						<li>
							<a title="<m:message code="button.add"/>" href="javascript:;" onclick="add();"> <i class="icon_bg icon_add"> </i> 
								<span><m:message code="button.add" /></span>
							</a>
							<!-- a title="批量增加" href="javascript:;" onclick="importData();"> <i class="icon_bg icon_add"> </i> 
								<span>批量导入</span>
							</a-->
						</li>
						<li>
							<a title="<m:message code="button.edit"/>" href="javascript:;" onclick="edit();"><i class="icon_bg icon_edit"></i> 
								<span><m:message code="button.edit" /></span>
							</a>
						</li>
						<li>
							<a title="停止营业"  href="javascript:;" onclick="batchDelete();"> <i class="icon_bg icon_del"></i> 
								<span>停止营业</span>
							</a>
						</li>
						<!-- li>
							<a title="店铺产品关联" href="javascript:;" onclick="linkStoreProduct();"> <i class="back_icon resources_icon"></i> 
								<span>店铺产品关联</span>
							</a>
						</li-->
						<li>
							<a title="<m:message code="button.view"/>" href="javascript:" onclick="show();">
								<i class="icon_bg icon_ckxq"></i> <span><m:message code="button.view" /></span>
							</a>
						</li>
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
