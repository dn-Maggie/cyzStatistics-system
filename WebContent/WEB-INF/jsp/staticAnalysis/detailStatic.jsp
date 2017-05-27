<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<title></title>
<style type="text/css">
.ui-jqgrid-labels{height:54px;}
.ui-jqgrid-hdiv{overflow: hidden;}
</style>
<script type="text/javascript">
var gridObj = {};
	$(function(){
		gridObj =  new biz.grid({
	        id:"#orderDetail",
	        url: "<m:url value='/accountOrderDetail/listDetailStatic.do'/>",
	       	sortname:"storeName",
	       	sortorder:"desc",
	       	rownumbers:false,
	       	frozen:true,
	       	shrinkToFit: false,
	       	footerrow:true,
	       	pager: "#orderDetailprowed",
	       	colModel:[
					{name : "brandName",label:"品牌",index : "brandName",frozen:true,width:200},
					{name : "storeName",label:"店铺名称",index : "storeName",frozen:true,width:220},
					{name : "businessArea",label:"区域",index : "businessArea",frozen:true,width:100},	
					{name : "successOrderNum",label:"有效订单",width:80},	
					{name : "failOrderNum",label:"无效订单",width:80},	
					{name : "successOrderAmount",label:"有效交易额",width:80},
					{name : "failOrderAmount",label:"无效交易额",width:80},	
					
					{name : "elmsuccessOrderNum",label:"饿了么有效订单",width:80},				
					{name : "elmfailOrderNum",label:"饿了么无效订单",width:80},
					{name : "elmsuccessOrderAmount",label:"饿了么有效交易额",width:80},	
					{name : "elmfailOrderAmount",label:"饿了么无效交易额",width:80},	
					
					{name : "mtsuccessOrderNum",label:"美团有效订单",width:80},
					{name : "mtfailOrderNum",label:"美团无效订单",width:80},	
					{name : "mtsuccessOrderAmount",label:"美团有效交易额",width:80},		
					{name : "mtfailOrderAmount",label:"美团无效交易额",width:80},	
					
					{name : "bdwmsuccessOrderNum",label:"百度有效订单",width:80},
					{name : "bdwmfailOrderNum",label:"百度无效订单",width:80},	
					{name : "bdwmsuccessOrderAmount",label:"百度有效交易额",width:80},		
					{name : "bdwmfailOrderAmount",label:"百度无效交易额",width:80},	
	           		],
			serializeGridData:function(postData){//添加查询条件值
				var obj = Finance.getQueryCondition();
				$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
				return obj;
			},
		 	datatype: "json",/*数据类型，设置为json数据，默认为json*/
	        emptyrecords: "无记录可显示",
	        rowList:[10,15,50,100],//每页显示记录数
			rowNum:15,//默认显示15条
			gridComplete:function(){//表格加载执行  
			 	var footerCell = $(this).footerData();
			 	var footerObj = {};
			 	for(var i in footerCell){
			 		if(!/rn$|Area$|cb$|Time$|Date$|Name$|Type$|remark$|Mode$|No$|Rate$|id$/.test(i)){
			 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
			 		}
			 		if(/Num$/.test(i)){
			 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
			 		}
			 	}
			 	footerObj['raw'] = true;
			 	footerObj['cb'] = "合计";
		    	$(this).footerData("set",footerObj); //将合计值显示出来
			}
		})
		gridObj.setFrozenColumns();
		/*jQuery("#orderDetail").jqGrid('setGroupHeaders', {
		    useColSpanStyle: true, 
		    groupHeaders:[
			   {startColumnName: 'successOrderNum', numberOfColumns:4, titleText:'合计'},
			   {startColumnName: 'elmsuccessOrderNum', numberOfColumns:4, titleText: '饿了么'},
			   {startColumnName: 'mtsuccessOrderNum', numberOfColumns:4, titleText: '美团'},
			   {startColumnName: 'bdwmsuccessOrderNum', numberOfColumns:4, titleText: '百度'},
		    ]
		  });*/
    });
  	//导出数据
 	function exportData(){
 		ExpExcel.showWin(gridObj,baseUrl+"/config/exportExcel.do",'grid',gridObj.id);
 	}
	
    </script>
</head>
<body style="height:100%;">

	<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
			<div class="search border-bottom">
				<ul>
				<li><span>所属品牌：</span>
					<select class="search_select choose_select" name="brandId" id="brandId">
					<option value = "">所有品牌</option>
						<c:forEach var="brand" items="${brand}">
							<option value="${brand.brandId}"> <c:out value="${brand.brandName}"></c:out> </option>
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
				<li><span>订单状态：</span>
					<select class="search_select" name="isInvalid">
						<option value=""></option>
						<option value="0">有效订单</option>
						<option value="1">无效订单</option>
					</select>
				</li>
				<li>
					<div class="time_bg">
						<input type="text" placeholder="订单截止"  class="search_time150 date-picker" name="propsMap['endDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
					<div class="time_bg">
						<input type="text" placeholder="订单起始" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
				</li>
				<li class="date_area">
					<span>创建时间:</span>
					<div class="time_bg">
						<div class="input-group bootstrap-timepicker">
							<input class="timepicker text" name="propsMap['startTime']" type="text" />
						</div>
					</div>
					<i>至</i>
					<div class="time_bg">
						<div class="input-group bootstrap-timepicker">
							<input class="timepicker text" name="propsMap['endTime']"   type="text" />
						</div>
					</div>
					</li>		
			 	<li>
			 		<select class="search_select" name="platformType" id="platformType"><option value="">所有平台</option>
							<option value="elm">饿了么</option><option value="mt">美团</option><option value="bdwm">百度</option>
					</select>
					<span>平台类型:</span>
				 </li>
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
						<a title="导出数据" href="javascript:;" onclick="exportData();"> 
							<i class="back_icon import_icon"> </i> 
							<span>导出数据</span>
						</a>
					</li>
				</ul>
			</div>
			<!--功能按钮end-->
			<div class="listtable_box">
				<!--此处放表格-->
			<table id="orderDetail"></table>
			<div id="orderDetailprowed"></div>		
			</div>
		</div>
	</div>
</body>
</html>