<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/ace.jsp"%>
<title></title>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/staticAnalysis/listStoreActivity.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"id",
           	sortorder:"asc",
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],
    		rowNum:15,
    		cellEdit:true,
    		afterSaveCell : function(rowid,name,val,iRow,iCol) {
           			var paramDatas = {};
	           		paramDatas[name] = val;
	           		paramDatas.id = rowid;
	           		$ .ajax({
	           			type: "post",
	    				url: "<m:url value='/staticAnalysis/updateStoreActivity.do'/>",
	    				data: paramDatas,
						cache:false,
	    				dataType:"json"
	    			});
          	},
   		  	colModel:[
   					{name : "id",hidden : true,key : true,label:"主键",index : "id"},		
   					{name : "storeName",label:"商户名称",index : "storeName"},		
   					{name : "storeArea",label:"商圈",index : "storeArea"},				
   					{name : "searchTime",label:"查询时间",index : "searchTime"},				
   					{name : "activityType",label:"活动类型",index : "activityType",editable:true,edittype : "select",editoptions : {
 						   url: "<m:url value='/dictInfo/getDictInfoByType.do'/>?type=activityType"
   					}},				
   					{name : "activityName",label:"活动名称",index : "activityName"},			
   					{name : "platformAllowance",label:"平台补贴金额",index : "platformAllowance",editable:true},				
   					{name : "activityIntensity",label:"活动力度",index : "activityIntensity",editable:true},				
   					{name : "activityCycle",label:"活动周期",index : "activityCycle",editable:true,width:300},				
   					{name : "activityTotalCost",label:"该活动总支出",index : "activityTotalCost",editable:true},				
   					{name : "activityTotalProfit",label:"共计产生利润",index : "activityTotalProfit",editable:true},				
   					{name : "profitPercent",label:"利润率",index : "profitPercent",editable:true},				
   					{name : "enterRateInActivity",label:"活动期间进店率",index : "enterRateInActivity",editable:true},				
   					{name : "conversionRateInActivity",label:"活动期间转化率",index : "conversionRateInActivity",editable:true},				
   					{name : "tradeAmountIncrementPercent",label:"活动期间同比上期交易额增幅",index : "tradeAmountIncrementPercent",editable:true},				
   					{name : "orderAmountIncrementPercent",label:"活动期间同比上期订单量增幅",index : "orderAmountIncrementPercent",editable:true},
   					{name : "platformType",label:"平台类型",index : "platformType",formatter:GridColModelForMatter.platformType}
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
<body>
	<div class="main  choice_box">
	<form id="queryForm"><!-- 查询区 表单 -->
			<div class="search border-bottom">
				<ul>
				<li>
					<span>商户类型</span>
					<select class="search_select_nowidth" name="mostBrowseMerchantType" id="mostBrowseMerchantType">
						<option value="">请选择</option>
						<c:forEach items="${category}" var="category">
							<option value="${category.categoryId}"><c:out value="${category.categoryName}"></c:out></option>
						</c:forEach>
					</select>
				</li>
				<li>
					<span>商圈</span>
					<select class="search_select_nowidth" name="storeArea" id="storeArea">
						<option value="">请选择</option>
						<c:forEach items="${tradingArea}" var="tradingArea">
							<option value="${tradingArea.businessArea}"><c:out value="${tradingArea.businessArea}"></c:out></option>
						</c:forEach>
					</select>
				</li>
				<li><span>商户名称：</span>
					<select class="search_select choose_select" name="storeId" id="storeId">
						<c:if test="${isAdmin}"><option value = "">所有店铺</option></c:if>
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
				</li>
				<li>
					<div class="time_bg">
						<input type="text" placeholder="订单截止"  class="search_time150 date-picker" name="propsMap['endDate']" data-date-format="yyyy-mm-dd"><!-- 时间选择控件-->
					</div>
					<div class="time_bg">
						<input type="text" placeholder="订单起始" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd"><!-- 时间选择控件-->
					</div>
				</li>
			 	<li>
			 		<select class="search_select" name="platformType" id="platformType"><option value="">所有平台</option>
						<option value="elm">饿了么</option><option value="mt">美团</option><option value="bdwm">百度</option>
					</select>
					<span>平台类型:</span>
				 </li>
				 <li><input type="text" name="favoriteDishesName" class="text" placeholder="菜品关键字"></li>
				 <li>
					<input type="reset" class="reset_btn" onclick="List.resetForm('queryForm')" value="重置"><!-- 重置 -->
					<input type="button" class="search_btn mr22 " onclick="List.doSearch(gridObj);" value="查询"></li><!-- 查询-->
				</ul>
		   </div>
	    </form>
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
