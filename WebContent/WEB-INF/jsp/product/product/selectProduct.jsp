<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<title><m:message code="moduleRes.list.title" /></title>
</head>
<body>
	<div class="main  choice_box">
		<form id="queryForm">
			<!-- 查询区 表单 -->
			<div class="search border-bottom">
				<ul>
					<li style="width: 320px; float: left;"><span>关键字:</span> 
					<input id="productClassName" type="text" 
						placeholder="产品类名"
						class="search_choose100" value="" name="productClassName"
						autocomplete="off"> 
					<input id="productName" type="text"
						placeholder="产品名称"
						class="search_choose100" value="" name="productName"
						autocomplete="off"></li>
					<li><input type="reset" value="重置" id="reset"
						onClick="resetForm('queryForm')" class="reset_btn">
					<!-- 重置 --> <input type="button" value="查询" id="query"
						class="search_btn mr22 " /></li>
					<!-- 查询-->
				</ul>
			</div>
		</form>

		<div class="listtable_box">
			<!--此处放表格-->
			<table id="mrSelect_rowed"></table>
			<div id="mrSelect_prowed"></div>
		</div>
		<div class="btn_area">
			<input type="button" id="submit" class="add_save"
				value="<m:message code='button.submit' />" />
		</div>
	</div>
</body>
<script type="text/javascript">
var mrSelectGrid = {};
	$(function(){
  		mrSelectGrid = new biz.grid({
            id:"#mrSelect_rowed",/*html部分table id*/
            url: "<m:url value='/product/listProduct.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"PRODUCT_STOCKS",
           	sortorder:"asc",
           	autowidth:true,
			shrinkToFit:true,
			multiselect:true,
	       	multiboxonly:true,
			singleselect : true,
           	pager: '#mrSelect_prowed' /*分页栏id*/,
     		rowList:[10,20,30,50,100,200],//每页显示记录数
    		rowNum:10,//默认显示15条
    		rownumbers: true, //是否显示行号
    		colModel:[
				{name : "productId",hidden : true,key : true,label:"产品ID(主键)",index : "PRODUCT_ID"},
				{name : "productClassId",hidden : true,index : "PRODUCT_CLASS_ID"},
				{name : "productClassName",label:"产品分类",index : "PRODUCT_CLASS_ID"},				
				{name : "productName",label:"产品名称",index : "PRODUCT_NAME"},				
				{name : "productUnitPrice",label:"产品单价",index : "PRODUCT_UNIT_PRICE"},				
				{name : "productStocks",label:"库存数量",index : "PRODUCT_STOCKS"},				
				{name : "productStatus",label:"产品状态",index : "PRODUCT_STATUS"}				
 	        ],
           	serializeGridData:function(postData){//添加查询条件值
           		var obj = {};
    			$.extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
    			return obj;
    		},

      });
  		
  		// 查询Grid数据
  	    $("#query").click(function(){
  	      	var productClassName = $("#productClassName").val(); 
  	      	var productName = $("#productName").val(); 
  	      	$("#mrSelect_rowed").jqGrid('setGridParam',{  
	  	        datatype:'json',  
	  	        postData:{
	  	        	'productClassName':productClassName,
	  	        	'productName':productName}, //发送数据  
	  	        page:1  
  	      	}).trigger("reloadGrid"); //重新载入  
	  	    	mrSelectGrid.setGridParam({"page":"1"});
	  	    	mrSelectGrid.trigger('reloadGrid');
  	    });

  		
  		// 重置查询表单
  		$("#reset").click(function(){
  			$("#queryForm").reset();
  		});
  		
  		//绑定提交按钮click事件
  		$("#submit").click(function() {
  	    	rowid = mrSelectGrid.getGridParam("selarrrow");
  	    	if(rowid == null || rowid.length == 0){
  				showInfo("<m:message code='grid.dealwith.chooseColAlert'/>",3000);
  				return ;
  			}
  			if(rowid.length>1){
  				showInfo("请选择一条数据！",3000);
  				return ;
  			}
			var rowData = $("#mrSelect_rowed").jqGrid('getRowData',rowid);
			window.parent.closeMrSelect();
			window.parent.drawForm(rowData);
  		});
    });

    function ma_status(cellvalue, options, rowObject){
    	if(cellvalue=='1'){
			return "启用";
		}else if(cellvalue=='0'){
			return "禁用";
		}
    }

    function ma_needright(cellvalue, options, rowObject){
    	if(cellvalue=='1'){
			return "是";
		}else if(cellvalue=='0'){
			return "否";
		}
    }
 	
    </script>
</html>
