<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<title></title>
<script type="text/javascript">
var gridObj = {};
//菜品数量表表头
var goodsModel = {url: "<m:url value='/accountOrderDetail/listAccountSaleGoods.do'/>",
						colModel:[
						{name : "id",hidden : true,key : true,label:"主键",index : "id"},						
						{name : "storeName",label:"商户名称",index : "store_name",width:300}, 
						{name : "goodName",label:"菜品名称",index : "good_name",width:300},	
						{name : "goodNum",label:"销售数量",index : "good_num",width:300},		
						{name : "goodUnitPrice",label:"结算单价",index : "good_unit_price",formatter:Finance.formatAccountting},	
						/* {name : "goodActualPrice",label:"实际支付单价",index : "good_actual_price",formatter:Finance.formatAccountting}, */	
						{name:"goodsPrice",label:"销售额",formatter:Finance.formatAccountting},
						{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType},
				       	]};
	$(function(){
		initGrid("goods");
    });
	//初始化grid
	function initGrid(ways){
		gridObj = Finance.createGrid(ways,goodsModel.colModel,true,false);
	}
	function exportData(){
		ExpExcel.showWin(gridObj,baseUrl+"/operaDate/exportExcel.do",'grid',gridObj.id);
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
				<li><span>菜品名称：</span>
					<input type="text" name="goodsName">
				</li>
				<li>
					<div class="time_bg">
					<input type="text" placeholder="截止日期"  class="search_time150 date-picker" name="propsMap['endDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
					<div class="time_bg">
					<input type="text" placeholder="起始日期" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
				</li>
				 <li><select class="search_select" name="platformType" id="platformType"><option value=""></option>
					 <option value="elm">饿了么</option><option value="mt">美团</option><option value="bdwm">百度</option>
					</select><span>平台类型:</span></li><!--下拉 -->
				<li><input type="reset" class="reset_btn" onclick="List.resetForm('queryForm')" value="重置"><!-- 重置 -->
						<input type="button" class="search_btn mr22 " onclick="List.doSearch(gridObj);" value="查询"></li><!-- 查询-->
				</ul>
		   </div>
	    </form>
		<div class="listplace">
				<!--功能按钮begin-->
				<div class="list_btn_bg fl"><!--功能按钮 div-->
					<ul>
						<c:if test="${exportData}">
							<li>
								<a title="根据订单详细导出运营详细数据" href="javascript:;" onclick="exportData();"> 
									<i class="back_icon import_icon"> </i> 
									<span>导出数据</span>
								</a>
							</li>
						</c:if>
					</ul>
				</div>
			<!--功能按钮end-->
				<div class="listtable_box">
					<!--此处放表格-->
					<table  id="goods" ></table>
					<div  id="goodsprowed"></div>	
				</div>
		</div>
	</div>
</body>
</html>
