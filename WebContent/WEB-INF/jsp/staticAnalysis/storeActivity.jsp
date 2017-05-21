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
            url: "<m:url value='/staticAnalysis/listStoreActivity.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"id",
           	sortorder:"asc",
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],//每页显示记录数
    		rowNum:10,//默认显示15条
   		  	colModel:[
   					{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
   					{name : "storeName",label:"商户名称",index : "storeName"},				
   					{name : "storeArea",label:"商圈",index : "storeArea"},				
   					{name : "searchTime",label:"查询时间",index : "searchTime"},				
   					{name : "activityType",label:"活动类型",index : "activityType"},				
   					{name : "activityName",label:"活动名称",index : "activityName"},				
   					{name : "platformAllowance",label:"平台补贴金额",index : "platformAllowance"},				
   					{name : "activityIntensity",label:"活动力度",index : "activityIntensity"},				
   					{name : "activityCycle",label:"活动周期",index : "activityCycle"},				
   					{name : "activityTotalCost",label:"该活动总支出",index : "activityTotalCost"},				
   					{name : "activityTotalProfit",label:"共计产生利润",index : "activityTotalProfit"},				
   					{name : "profitPercent",label:"利润率",index : "profitPercent"},				
   					{name : "enterRateInActivity",label:"活动期间进店率",index : "enterRateInActivity"},				
   					{name : "conversionRateInActivity",label:"活动期间转化率",index : "conversionRateInActivity"},				
   					{name : "tradeAmountIncrementPercent",label:"活动期间同比上期交易额增幅",index : "tradeAmountIncrementPercent"},				
   					{name : "orderAmountIncrementPercent",label:"活动期间同比上期订单量增幅",index : "orderAmountIncrementPercent"}				
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
