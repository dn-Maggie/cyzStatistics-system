<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/ace.jsp"%>
<title></title>
<style type="text/css">
.ui-jqgrid-labels{height:54px;}
.ui-jqgrid-hdiv{overflow: hidden;}
</style>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/staticAnalysis/demandAnalysis.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"searchTime",
           	sortorder:"desc",
           	rownumbers:false,
           	shrinkToFit: false,
        	frozen:true,
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],//每页显示记录数
    		rowNum:15,//默认显示15条
            colModel:[
				//{name : "searchTime",label:"统计时间",index : "searchTime"},
				{name : "customName",label:"客户名称",index : "customName",frozen:true},	
				{name : "customTel",label:"客户手机号",index : "customTel",frozen:true},	
				{name : "customOrdAddr",label:"客户常用订餐地址",index : "customOrdAddr",width:300},
				{name : "mostBrowseMerchantType",label:"客户浏览最多次的商户类型",index : "mostBrowseMerchantType"},				
				{name : "mostBrowseMerchantName",label:"客户浏览最多次的商户名称",index : "mostBrowseMerchantName",width:220},				
				{name : "storeArea",label:"商户所在区域",index : "storeArea"},		
				{name : "averageCost",label:"客户消费的平均单价",index : "averageCost"},				
				{name : "favoriteDishesName",label:"客户最喜欢的菜品名称",index : "favoriteDishesName",width:400},				
				{name : "favoriteDishesCost",label:"客户最喜欢的菜品的平均价格",index : "favoriteDishesCost"},	
				{name : "platformType",label:"平台类型",index : "platformType",formatter:GridColModelForMatter.platformType},
           	],
           	serializeGridData:function(postData){//添加查询条件值
				var obj = getQueryCondition();
    			$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
    			return obj;
    		}
      }).setFrozenColumns();
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
