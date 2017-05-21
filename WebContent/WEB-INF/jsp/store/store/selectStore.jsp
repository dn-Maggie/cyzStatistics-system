<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML  >
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/store/listStore.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"STORE_ID",
           	sortorder:"asc",
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],//每页显示记录数
    		rowNum:10,//默认显示15条
            colModel:[
				{name : "storeId",hidden : true,key : true,label:"店铺ID",index : "STORE_ID"},				
				{name : "storeName",label:"店铺名称",index : "STORE_NAME"},				
				{name : "brandName",label:"所属品牌",index : "BRAND_ID"},				
				{name : "storeAddress",label:"店铺地址",index : "STORE_ADDRESS"},				
				{name : "storeOwnerName",label:"店长姓名",index : "STORE_OWNER_NAME"},				
				{name : "storeOwnerTel",label:"店长电话",index : "STORE_OWNER_TEL"},				
				{name : "remark",label:"备注",index : "REMARK"},				
				{name : "operateDate",label:"运营开始时间",index : "OPERATE_DATE"},				
				{name : "storeTel",label:"店铺联系电话",index : "STORE_TEL"},				
           	],
           	serializeGridData:function(postData){//添加查询条件值
				var obj = getQueryCondition();
    			$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
    			return obj;
    		}
      });
        
  	//绑定提交按钮click事件
		$("#submit").click(function() {
	    	rowid = gridObj.getGridParam("selarrrow");
	    	if(rowid == null || rowid.length == 0){
				showInfo("<m:message code='grid.dealwith.chooseColAlert'/>",3000);
				return ;
			}
			var ids="";
			for(var i=0; i < rowid.length;i++){
				var id = gridObj.getCell(rowid[i],'id');
				if(i>0){
					ids +=',';
				}
				ids += id;
			}
			var rowData = $("#remote_rowed").jqGrid('getRowData',rowid);
			drawParentForm(rowData);
		});
    });
  	
	function drawParentForm(rowData){
		window.parent.closeStore();
		window.parent.drawForm(rowData);
	};
    /**
    * 获取查询条件值
    */
    function getQueryCondition(){
       var obj = {};
		jQuery.each($("#queryForm").serializeArray(),function(i,o){
        	if(o.value){
        		obj[o.name] = o.value;
        	}
        });
		return obj;
    }
    //查询Grid数据
    function doSearch(isStayCurrentPage){
    	if(!isStayCurrentPage)gridObj.setGridParam({"page":"1"});
    	gridObj.trigger('reloadGrid');
    }
    //重置查询表单
    function resetForm(formId){
		document.getElementById(formId).reset();
	}
  
    </script>
</head>
<body style="height:100%;">
	<div class="main  choice_box">
		<form id="queryForm">
			<div class="search border-bottom">
				<ul>
					<li style="width:320px;float:left;"><span>模糊查询:</span>
						<input type="text" class="search_choose100" name="storeName"  placeholder="店铺名称" autocomplete="off">
						<input type="text" class="search_choose100" name="storeOwnerName"  placeholder="店长姓名" autocomplete="off">
					</li>
					<li>
						<input type="reset" value="重置" id="reset" onClick="resetForm('queryForm')" class="reset_btn"><!-- 重置 -->
						<input type="button" value="查询"  id="query" onClick="doSearch()" class="search_btn mr22 " />
					</li><!-- 查询-->
				</ul>
		   </div><!-- 查询区 表单 -->
	    </form>
		<div class="listplace">
				<div class="listtable_box">
					<!--此处放表格-->
					<table  id="remote_rowed" ></table>
					<div  id="remote_prowed"></div>		
				</div>
				<div class="btn_area">
					<input type="button" id="submit" class="add_save" value="确定" />
				</div>
		</div>
	</div>
</body>
</html>
