<%@page import="com.cyz.staticsystem.common.enums.LogisticsCode"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<style>
	.ui-jqgrid-sortable{
		font-weight:normal;
	}
</style>
<title></title>
<script type="text/javascript">
var gridObj = {};
//格式化cell
function cellFormat(value, options, rData){
	if(rData.raw){
		return accounting.formatMoney(value,"",2).replace(".00","").replace(",","");
	}else if(options.colModel.calculate.indexOf("rData")>0){
		return accounting.formatMoney(eval(options.colModel.calculate),"",2).replace(".00","").replace(",","");
	}return accounting.formatMoney(value,"",2).replace(".00","").replace(",","");
};

//深运营汇总表表头
var deepTotalModel = {url: "<m:url value='/accountOperaTotal/listAccountOperaTotal.do'/>?type=deepTotal",
					colModel:[
					{name : "id",hidden : true,key : true,label:"主键",index : "id"},	
					{name : "brandName",label:"品牌"},
					{name : "storeName",label:"商户名称",index : "store_name"},
					{name : "storeType",label:"店铺类型",index : "store_type",formatter:GridColModelForMatter.storeType}, 	
					{name : "invalidNum",label:"无效单",isBasic:true},				
					{name : "validNum",label:"有效单",isBasic:true},	 
					{name : "productSaleAmount",label:"产品销售金额",isBasic:true,editFlag:true,formatter:Finance.formatAccountting},				
	 				{name : "amountReceivable",label:"应收平台结算金额",isBasic:true,editFlag:true,formatter:Finance.formatAccountting},	
	 				{name : "amountPayable",label:"应付店铺结算金额",isBasic:true,editFlag:true,formatter:Finance.formatAccountting},				
	 				{name : "cyzServiceCharge",label:"公司收入",isBasic:true,editFlag:true,formatter:Finance.formatAccountting},	
     				{name : "saleGrossProfit",label:"销售毛利",isBasic:true,formatter:Finance.formatAccountting},				
     				{name : "distPrice",label:"自配送金额单价",hidden:true,formatter:Finance.formatAccountting},
     				{name : "distAll",label:"自配送金额",editFlag:true,formatter : Finance.formatAccountting},
	 				{name : "distDiff",label:"自配送补差",editFlag:true,formatter : Finance.formatAccountting},
	 				{name : "actualMerchantDistCharge",label:"实际收取自配送金额",isBasic:true,editable:true,formatter:Finance.formatAccountting},
	 				{name : "platformActivitiesCharge",label:"饿了吗平台补贴 ",isBasic:true,formatter:Finance.formatAccountting},
	 				{name : "serviceAll",label:"对外支付饿了么平台补贴服务费",editFlag:true, formatter : Finance.formatAccountting},
	 				{name : "profitAll",label:"实际运营毛利",editFlag:true,formatter : Finance.formatAccountting},
   					{name : "otherAll",label:"竞价费用+短信推广",editable:true},
			       	]};
		$(function(){
			initGrid("deepTotal");
			Finance.changeTabMenu();
    	});
	//初始化grid
	function initGrid(ways){
		if(localStorage.getItem(ways+"Model")){
			var localStorageModel= $.each(JSON.parse(localStorage.getItem(ways+"Model")), function(idx, obj) {
				if(obj.serial){
					obj.formatter=cellFormat;
				}
			    return obj;
			});
		}
		gridObj = Finance.createGrid(ways,localStorageModel,true,true,baseUrl+"/accountOperaTotal/updateAccountOperaTotal.do?type="+ways);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('isBasic');
		$("#"+ways).setColProp('editFlag');
		jQuery("#"+ways).jqGrid('setGroupHeaders', {
		    useColSpanStyle: true, 
		    groupHeaders:[
			   {startColumnName: 'invalidNum', numberOfColumns:15, titleText: '三平台汇总'},
		    ]
		  });
	}
	//config grid
	function loadConfigGrid(ways,colModel){
		$(".listtable_box").html("");
		$(".listtable_box").html('<table id="'+ways+'" ></table><div id="'+ways+'prowed"></div>');
		$("#orderSaleRate").val(localStorage.getItem(ways+"orderSaleRate")?localStorage.getItem(ways+"orderSaleRate"):0.7);
		gridObj = Finance.loadConfigGrid(ways,colModel);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('isBasic');
		$("#"+ways).setColProp('editFlag');
	}
	//配置的弹出框
	var config_iframe_dialog ;
	//关闭配置页面，供子页面调用
  	function closeConfig(){config_iframe_dialog.close();}
    //导出运营明细数据
    function exportData(){
    	ExpExcel.showWin(gridObj,baseUrl+"/accountOperaTotal/exportExcel.do",'grid',gridObj.id);
    }
    function getColModel(){
    	var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id')
    	var columnNames = $("#"+tableId).jqGrid('getGridParam','colModel');
    	return columnNames;
    };
</script>
</head>
<body style="height:100%;">
	<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
			<div class="search border-bottom">
				<ul>
					<li>
						<span>商户名称：</span>
						<select class="search_select choose_select" name="storeId" id="storeId">
							<c:if test="${isAdmin}"><option value = "">所有店铺</option></c:if>
							<c:forEach var="store" items="${store}">
								<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
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
					<li>
					 	<select class="search_select" name="platformType" id="platformType">
					 		<option value="">所有平台</option>
						 	<option value="elm">饿了么</option>
						 	<option value="meituan">美团</option>
						 	<option value="baidu">百度</option>
						</select>
						<span>平台类型:</span>
					 </li>
					<li>
						<input type="reset" class="reset_btn" onclick="List.resetForm('queryForm')" value="重置"><!-- 重置 -->
						<input type="button" class="search_btn mr22 " onclick="List.doSearch(gridObj);" value="查询">
					</li><!-- 查询-->
				</ul>
		   </div>
	    </form>
		<div class="listplace">
				<!--功能按钮begin-->
				<div class="list_btn_bg fl"><!--功能按钮 div-->
					<ul>
						<c:if test="${configTitle}">
							<!-- li>
								<a title="配置表头标题" href="javascript:;" onclick="Finance.configTitle()"> 
									<i class="back_icon permissions_icon"> </i> 
									<span>配置表头</span>
								</a>
							</li-->
						</c:if>
						<c:if test="${show}">
						
						<li>
							<a title="根据订单详细显示深运营汇总表" href="javascript:;" class="tableTab checked" data-id="deepTotal"> 
								<i class="back_icon show_icon"> </i> 
								<span>深运营汇总表</span>
							</a>
						</li>
						</c:if>
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
					<table  id="deepTotal" ></table>
					<div id="deepTotalprowed"></div>	
				</div>
		</div>
	</div>
</body>
</html>
