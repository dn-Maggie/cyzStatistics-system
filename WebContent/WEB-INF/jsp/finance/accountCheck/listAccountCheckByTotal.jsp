<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<title></title>
<script type="text/javascript">
var checkModel = {url: "<m:url value='/accountCheck/listTotalAccountCheck.do'/>",
				  colModel:[
					{name : "storeName",label:"店铺名称",index : "store_name"},
					{name : "createDate",label:"日期",index : "create_date"},	
					{name : "elmMealFee",label:"饿了么餐盒费",formatter:Finance.formatAccountting},	//餐盒费
					{name : "elmSpecialOffer",label:"饿了么折扣菜金额",formatter:Finance.formatAccountting},	//特价菜结算			
					{name : "elmActualPrice",label:"饿了么结算款",formatter:Finance.formatAccountting},	//原价菜金额
					{name : "bdMealFee",label:"百度餐盒费",formatter:Finance.formatAccountting},	//餐盒费
					{name : "bdSpecialOffer",label:"百度折扣菜金额",formatter:Finance.formatAccountting},				
					{name : "bdActualPrice",label:"百度结算款",formatter:Finance.formatAccountting},
					{name : "mtMealFee",label:"美团餐盒费",formatter:Finance.formatAccountting},	//餐盒费
					{name : "mtSpecialOffer",label:"美团折扣菜金额",formatter:Finance.formatAccountting},				
					{name : "mtActualPrice",label:"美团结算款",formatter:Finance.formatAccountting},
					{name : "actualPrice",label:"三平台小计",formatter:Finance.formatAccountting},	//三平台结算款合计	
					{name : "amountRatePayable",label:"70%结算",formatter:Finance.formatAccountting},		//三平台结算款合计*70%
					{name : "specialOffer",label:"特价菜结算",formatter:Finance.formatAccountting},	//三平台折扣菜金额合计
					{name : "mealFee",label:"餐盒费",formatter:Finance.formatAccountting},	//餐盒费
					{name : "orderSaleRate",label:"调整金额",formatter:Finance.formatAccountting},		//？
					{name : "allotherBasePrice",label:"实际结算",formatter:Finance.formatAccountting},		//70%结算+特价结算
					{name : "remark",label:"备注"},		
					{name : "elmRecieveAdjust",label:"饿了么平台到账",formatter:Finance.formatAccountting},	//？
					{name : "bdRecieveAdjust",label:"百度平台到账",formatter:Finance.formatAccountting},//？
					{name : "mtRecieveAdjust",label:"美团平台到账",formatter:Finance.formatAccountting},//？
					{name : "otherAll",label:"其他（线下支付、商米扣款）",formatter:Finance.formatAccountting},	 
					{name : "elmSettlement",label:"饿了么结算金额",formatter:Finance.formatAccountting},	//饿了么折扣菜+结算款*70%
					{name : "bdSettlement",label:"百度结算金额",formatter:Finance.formatAccountting},
					{name : "mtSettlement",label:"美团结算金额",formatter:Finance.formatAccountting},
					{name : "settlement",label:"合计",formatter:Finance.formatAccountting},		
	           		]}
var gridObj = {};
	$(function(){
		initGrid("check");
		Finance.changeTabMenu();
    });
  	//导出财务总数据
 	function exportData(){
 		ExpExcel.showWin(gridObj,baseUrl+"/accountCheck/exportExcel.do",'grid',gridObj.id);
 	}
 	//初始化grid
	function initGrid(ways){
		gridObj = Finance.createGrid(ways,eval(ways+"Model.colModel"),false,true);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('editFlag');
		if(ways="check"){
			jQuery("#check").jqGrid('setGroupHeaders', {
		    useColSpanStyle: true, 
		    groupHeaders:[
			   {startColumnName: 'elmMealFee', numberOfColumns:9, titleText: '对账结算表'},
			   {startColumnName: 'elmRecieveAdjust', numberOfColumns:2, titleText: '调整金额'},
			   {startColumnName: 'elmSettlement', numberOfColumns:4, titleText: '各平台商家结算金额'},
		    ]
		  });
		}
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
				<li>
					<div class="time_bg">
					<input type="text" placeholder="截止日期"  class="search_time150 date-picker" name="propsMap['endDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
					<div class="time_bg">
					<input type="text" placeholder="起始日期" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
				</li>
				<li><select class="search_select" name="platformType" id="platformType"><option value="">所有平台</option>
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
			<table  id="check"></table>
			<div  id="checkprowed"></div>		
			</div>
		</div>
	</div>
</body>
</html>
