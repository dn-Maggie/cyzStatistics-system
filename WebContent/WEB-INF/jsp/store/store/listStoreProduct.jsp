<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<title><m:message code="moduleRes.list.title" /></title>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#storeProduct_rowed",/*html部分table id*/
            url: "<m:url value='/storeProduct/listStoreProduct.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"PRODUCT_STOCKS",
           	sortorder:"asc",
           	autowidth:true,
			shrinkToFit:true,
			multiselect:true,
	       	multiboxonly:true,
           	pager: '#storeProduct_prowed' /*分页栏id*/,
     		rowList:[10,20,30,50,100,200],//每页显示记录数
    		rowNum:10,//默认显示15条
    		rownumbers: true, //是否显示行号
   			colModel:[
   					{name : "storeProductId",hidden : true,key : true,label:"店铺产品ID",index : "store_product_id"},				
   					{name : "storeName",label:"店铺名称",index : "store_id"}, 				
   					{name : "productClassName",label:"产品类名",index : "product_class_name"},				
   					{name : "productName",label:"产品名称",index : "product_name"},				
   					{name : "productUnitPrice",label:"产品单价",index : "PRODUCT_UNIT_PRICE"},				
   					{name : "productStocks",label:"库存数量",index : "PRODUCT_STOCKS"},				
   					{name : "productStatus",label:"产品状态",index : "PRODUCT_STATUS"
   						,formatter:GridColModelForMatter.productStatus},
					{name : "merchantDiscount",label:"菜品折扣",index : "merchant_discount"},	
   					{name : "merchantDiscountBegin",label:"折扣时间起",index : "merchant_discount_begin"},	
   					{name : "merchantDiscountEnd",label:"折扣时间止",index : "merchant_discount_end"},		
   					{name : "specialOffer",label:"签订特价结算金额",index : "special_offer"},			
   					{name : "specialOfferBegin",label:"签订特价结算时间起",index : "special_offer_begin"},			
   					{name : "specialOfferEnd",label:"签订特价结算时间止",index : "special_offer_end"}		
   	        ],
           	serializeGridData:function(postData){//添加查询条件值
				var obj = getQueryCondition();
    			$.extend(true,obj,postData);//合并查询条件值与grid的默认传递参数   				
    			return obj;
    		},
      });
  	//产品状态下拉
	new biz.select({
	    id:"#productStatus",
	    url:"<m:url value='/dictInfo/getDictByTypeCode.do?dictTypeCode=productStatus'/>",
	});
    });

	 /**
    * 获取查询条件值
    */
    function getQueryCondition(){
       var obj = {storeId:"${storeId}"};
		jQuery.each($("#queryForm").serializeArray(),function(i,o){
        	if(o.value){
        		obj[o.name] = o.value;
        	}
        });
		return obj;
    }
    function doSearch(isStayCurrentPage){
    	if(!isStayCurrentPage)gridObj.setGridParam({"page":"1"});
    	gridObj.trigger('reloadGrid');
    }
    //重置查询表单
    function resetForm(formId){
		document.getElementById(formId).reset();
	}
    //新增的弹出框
	var add_iframe_dialog;
    
  	//新增产品类别弹出框
    function add(){
   		var url="<m:url value='/storeProduct/toAddStoreProduct.do'/>?storeId=${storeId}";
   		add_iframe_dialog = new biz.dialog({
   			id:$('<div id="addwindow_iframe"></div>').html('<iframe id="iframeAdd" name="iframeAdd" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
   			modal: true,
   			width: $(window).width()*0.8,
			height:$(window).height()*0.8,
   			title: "店铺产品增加"
   		});
   		add_iframe_dialog.open();
   	}
      	
   	//关闭新增页面，供子页面调用
   	function closeAdd(){
 		add_iframe_dialog.close();
   	}
  	//修改的弹出框
   	var edit_iframe_dialog;
    function edit(){
		var key = ICSS.utils.getSelectRowData("storeProductId");
		if(key.indexOf(",")>-1||key==""){
			showMessage("请选择一条数据！");
			return ;
		}
		var url="<m:url value='/storeProduct/toEditStoreProduct.do'/>?key="+key;
		edit_iframe_dialog = new biz.dialog({
		 	id:$('<div id="editwindow_iframe"></div>').html('<iframe id="iframeEdit" name="iframeEdit" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
			modal: true,
			width: $(window).width()*0.8,
			height: $(window).height()*0.8,
			title: "店铺产品编辑"
		});
  		edit_iframe_dialog.open();
    }
    
    //关闭编辑页面，供子页面调用
    function closeEdit(){
    	edit_iframe_dialog.close();
    }
	
    function delProFromStore(){
    	rowid = gridObj.getGridParam("selarrrow");
    	if(rowid == null || rowid.length == 0){
			showInfo("<m:message code='grid.delete.chooseColAlert'/>",3000);
			return ;
		}
    	new biz.alert({type:"confirm",message:I18N.msg_del_confirm,title:I18N.promp,callback:function(result){
	    		if (!result) {
	    			return;
	    		}
				var ids="";
				for(var i=0; i < rowid.length;i++){
					var id = gridObj.getCell(rowid[i],'storeProductId');
					if(i>0){
						ids +=',';
					}
					ids += id;
				}
				$.ajax({
					url: "<m:url value='/storeProduct/deleteStoreProduct.do'/>",
					data: {key:ids},
    				cache:false,
					success: function(data){
    					doSearch();
						showInfo("<m:message code='delete.success'/>",3000);
					}
				});
			}
		});
    }
    </script>
</head>
<body>
<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
			 <div class="search border-bottom">
				<ul>
				<li>
				<span>关键字:</span>
				<input type="text" name="productClassName" id="productClassName" class="search_choose" placeholder="产品类名">
				</li>
				<li>
				<input type="text" name="productName" id="productName" class="search_choose" placeholder="产品名称">
				</li>
				<li>
					<select  name="productStatus" id="productStatus" class="search_select"></select>
				<!-- <input type="text" name="productStatus" id="productStatus" class="search_choose" placeholder="产品状态"> -->
				</li>
				<li>
				<input type="reset" class="reset_btn" onclick="resetForm('queryForm')" value="重置">
				<input type="button" class="search_btn mr22 " onclick="doSearch();" value="查询"></li>
			</ul>
		   </div>
	    </form>
	<div class="listplace">
		<!--功能按钮begin-->
		<div class="list_btn_bg fl">
			<!--功能按钮 div-->
			<ul>
				<li><a title="<m:message code="button.add"/>"
					href="javascript:;" onclick="add();"> <i
						class="icon_bg icon_add"> </i> <span><m:message
								code="button.add" /></span>
				</a></li>
				<li><a title="<m:message code="button.edit"/>"
					href="javascript:;" onclick="edit();"> <i
						class="icon_bg icon_edit"> </i> <span><m:message
								code="button.edit" /></span>
				</a></li>
				<li><a title="<m:message code="button.delete"/>"
					href="javascript:;" onclick="delProFromStore();"> <i
						class="icon_bg icon_del"></i> <span><m:message
								code="button.delete" /></span>
				</a></li>
			</ul>
		</div>
		<!--功能按钮end-->
		<div class="listtable_box">
			<!--此处放表格-->
			<table id="storeProduct_rowed"></table>
			<div id="storeProduct_prowed"></div>
		</div>
	</div>
	<!--功能列表区end-->
</div>
</body>
</html>
