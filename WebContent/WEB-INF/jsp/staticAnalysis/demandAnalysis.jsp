<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<title></title>
<script type="text/javascript">
//离开页面的恢复导航栏方法
function checkLeave(){
	var _iframe = window.parent;
	_iframe.$(".inlineBlock").each(function(){this.className='hidden'})
}
var gridObj = {};
	$(function(){
		//进入页面的展开导航栏搜索方法
		var _iframe = window.parent;
		_iframe.$(".hidden").each(function(){this.className='inlineBlock'})
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/staticAnalysis/demandAnalysis.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"averageCost",
           	sortorder:"asc",
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],//每页显示记录数
    		rowNum:10,//默认显示15条
            colModel:[
				{name : "storeArea",hidden : true,key : true,label:"商户所在区域",index : "storeArea"},				
				{name : "customName",label:"客户名称",index : "customName"},				
				{name : "customOrdAddr",label:"客户常用订餐地址",index : "customOrdAddr"},				
				{name : "customTel",label:"客户手机号",index : "customTel"},				
				{name : "mostBrowseMerchantName",label:"客户浏览最多次的商户名称",index : "mostBrowseMerchantName"},				
				{name : "mostBrowseMerchantType",label:"客户浏览最多次的商户类型",index : "mostBrowseMerchantType"},				
				{name : "averageCost",label:"客户消费的平均单价",index : "averageCost"},				
				{name : "favoriteDishesName",label:"客户最喜欢的菜品名称",index : "favoriteDishesName"},				
				{name : "favoriteDishesCost",label:"客户最喜欢的菜品的平均价格",index : "favoriteDishesCost"},				
           	],
           	serializeGridData:function(postData){//添加查询条件值
				var obj = getQueryCondition();
    			$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
    			return obj;
    		}
      });
        
    });

 

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
    
    //删除
    function batchDelete(){
    	var ids = ICSS.utils.getSelectRowData("storeActivityId");
    	if(ids==""){
    		showMessage("请至少选择一条数据！");
    		return ;
    	}else{
    		new biz.alert({type:"confirm",message:I18N.msg_del_confirm,title:I18N.promp,callback:function(result){
    			if(result){
    				$ .ajax({
        				url: "<m:url value='/storeActivity/deleteStoreActivity.do'/>?key="+ids,
        				cache:false,
        				success: function(data, textStatus, jqXHR){
        					doSearch();
    						showInfo("删除成功",3000);
        				}
        			});
    			}
    		}}) ;   
    	}
    }
    </script>
</head>
<body onbeforeunload="checkLeave()">

	<div class="main  choice_box">
		<div class="listplace">
				<!--功能按钮begin-->
				<div class="list_btn_bg fl"><!--功能按钮 div-->
					<ul>
					<li>
						<a title="导出数据" href="javascript:;" onclick=""> 
							<i class="back_icon import_icon"> </i> 
							<span>导出数据</span>
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
