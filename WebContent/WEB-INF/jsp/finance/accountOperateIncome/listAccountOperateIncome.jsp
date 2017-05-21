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
//格式化cell
function cellFormat(value, options, rData){
	/*if(rData.raw){*/
		return accounting.formatMoney(value,"",2).replace(".00","").replace(",","");
	/*}else if(options.colModel.calculate.indexOf("rData")>0){
		return accounting.formatMoney(eval(options.colModel.calculate),"",2).replace(".00","").replace(",","");
	}return accounting.formatMoney(value,"",2).replace(".00","").replace(",","");*/
};
//汇总运营表头
var totalColModel = {
		basePrice:[{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
      		{name : "storeName",label:"店铺名称",index : "store_name",width:200},		
			{name : "createDate",label:"日期",index : "create_date",width:200},				
			{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true},				
			{name : "validNum",label:"有效单",index : "valid_num"},
			{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",formatter:Finance.formatAccountting},				
			{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",formatter:Finance.formatAccountting},				
			{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",formatter:Finance.formatAccountting},				
			{name : "cyzServiceCharge",label:"公司收入",index : "cyz_service_charge",formatter:Finance.formatAccountting},				
			{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",formatter:Finance.formatAccountting},	
			{name : "actualMerchantDistCharge",label:"自配送实际支付金额",index : "actual_merchant_dist_charge",formatter:Finance.formatAccountting},		
      	],
     	 saleRate:[{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
           	{name : "storeName",label:"店铺名称",index : "store_name"},		
   			{name : "createDate",label:"日期",index : "create_date"},				
   			{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true},				
   			{name : "validNum",label:"有效单",index : "valid_num"},
   			{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",formatter:Finance.formatAccountting},				
   			{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",formatter:Finance.formatAccountting},				
   			{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",formatter:Finance.formatAccountting},				
   			{name : "cyzServiceCharge",label:"公司收入",index : "cyz_service_charge",formatter:Finance.formatAccountting},				
   			{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",formatter:Finance.formatAccountting},	
   			{name : "actualMerchantDistCharge",label:"自配送实际支付金额",editable:true,index : "actual_merchant_dist_charge",formatter:Finance.formatAccountting},		
         ],
         deepOpera:[{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
           	{name : "storeName",label:"店铺名称",index : "store_name"},		
   			{name : "createDate",label:"日期",index : "create_date"},				
   			{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true},				
   			{name : "validNum",label:"有效单",index : "valid_num"},
   			{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",formatter:Finance.formatAccountting},				
   			{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",formatter:Finance.formatAccountting},				
   			{name : "amountRatePayable",label:"品牌商家应收",index : "amount_rate_payable",editFlag:true,formatter:Finance.formatAccountting},		
			{name : "cyzServiceChargeOperaPart",label:"运营应收",index : "cyz_service_charge_opera_part",editFlag:true,formatter:Finance.formatAccountting},				
			{name : "saleGrossProfit",label:"运营实收",index : "sale_gross_profit",editFlag:true,formatter:Finance.formatAccountting},			
			{name : "cyzDistCharge",label:"运营收取客户配送费",index : "cyz_dist_charge",formatter:Finance.formatAccountting},
			{name : "cyzServiceChargeIndustryPart",label:"工厂应收",index : "cyz_service_charge_industry_part",editFlag:true,formatter:Finance.formatAccountting},		
		],
         platformAccount:[{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
          	{name : "storeName",label:"店铺名称",index : "store_name"},		
   			{name : "createDate",label:"日期",index : "create_date"},				
   			{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true},				
   			{name : "validNum",label:"有效单",index : "valid_num"},
   			{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",formatter:Finance.formatAccountting},				
   			{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",formatter:Finance.formatAccountting},				
   			{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",formatter:Finance.formatAccountting},				
   			{name : "cyzServiceCharge",label:"公司收入",index : "cyz_service_charge",formatter:Finance.formatAccountting},				
   			{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",formatter:Finance.formatAccountting},	
   			{name : "actualMerchantDistCharge",label:"自配送实际支付金额",editable:true,index : "actual_merchant_dist_charge",formatter:Finance.formatAccountting},		
         ],
}
//底价运营表表头     
var basePriceModel = {url: "<m:url value='/operaDate/listOperaDate.do'/>?type=basePrice",
					 colModel:[
						{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
						 {name : "storeName",label:"商户名称",index : "store_name",width:320}, 				
						{name : "createDate",label:"日期",index : "create_date",width:200},				
						{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true,width:100},				
						{name : "validNum",label:"有效单",index : "valid_num",width:100},				
						{name : "orginPrice",label:"菜品原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},	
						{name : "orderDistCharge",label:"订单上收取客户配送费",index : "order_dist_charge",isBasic:true,formatter:Finance.formatAccountting},
						{name : "goodsQuality",label:"菜品份数",index : "goods_quality",isBasic:true,formatter:Finance.formatAccountting},//菜品数量表中的销售量总和	
						{name : "allbasePrice",label:"底价",index : "allbase_price",editable:true,isBasic:true,formatter:Finance.formatAccountting},//菜品数量表中的销售额总和				
						{name : "allotherBasePrice",label:"其他底价",index : "allother_base_price",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
						{name : "platformServiceCharge",label:"平台服务费",index : "platform_service_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "platformDistCharge",label:"平台收取配送费",index : "platform_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "platformActivitiesCharge",label:"平台补贴线上活动费",index : "platform_activities_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "activitiesSubsidyBycompany",label:"公司扣除平台补贴自营销费用",index : "activities_subsidy_bycompany",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
						{name : "cyzDistCharge",label:"公司收取配送费",index : "cyz_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",editFlag:true, formatter:Finance.formatAccountting},				
						{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "cyzServiceCharge",label:"公司收入",index : "cyz_service_charge",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "saleGrossProfitRate",label:"毛利率",index : "sale_gross_profit_rate",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "actualMerchantDistCharge",label:"自配送实际支付金额",index : "actual_merchant_dist_charge",editable:true,formatter:Finance.formatAccountting},				
						/* {name : "remark",label:"备注",index : "remark",editable:true},	 */			
						{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType},    
		           	],};
//销售额比例抽佣运营表表头         
var saleRateModel = {url: "<m:url value='/operaDate/listOperaDate.do'/>?type=saleRate",
					 colModel:[
						{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
						 {name : "storeName",label:"商户名称",index : "store_name",width:320}, 				
						{name : "createDate",label:"日期",index : "create_date",width:200},				
						{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true,width:100},				
						{name : "validNum",label:"有效单",index : "valid_num",width:100},				
						{name : "orginPrice",label:"原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "specialOrgin",label:"特价菜原价",index : "special_orgin",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
						{name : "specialOffer",label:"特价菜结算",index : "special_offer",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
						{name : "activitiesSubsidyBymerchant",label:"实际菜品折扣",isBasic:true,index : "activities_subsidy_bymerchant",formatter:Finance.formatAccountting},				
						{name : "orderDistCharge",label:"订单上收取客户配送费",index : "order_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "platformDistCharge",label:"平台收取配送费",index : "platform_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "cyzDistCharge",label:"公司收取配送费",index : "cyz_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "activitiesSubsidyBycompany",label:"公司承担线上活动费",index : "activities_subsidy_bycompany",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "platformActivitiesCharge",label:"平台承担线上活动费",index : "platform_activities_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "platformServiceCharge",label:"平台服务费",index : "platform_service_charge",isBasic:true,formatter:Finance.formatAccountting},				
						{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "orderSaleRate",label:"结算比例",index : "order_sale_rate",editFlag:true,hidden:true,editable:true,formatter:Finance.formatAccountting,calculate:"0.7"},		
						{name : "amountRatePayable",label:"按比例计算结算金额",index : "amount_rate_payable",editFlag:true},				
						{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "cyzServiceCharge",label:"公司收取店铺服务费",index : "cyz_service_charge",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "actualMerchantDistCharge",label:"自配送实际支付金额",index : "actual_merchant_dist_charge",editable:true,formatter:Finance.formatAccountting},				
						{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",editFlag:true,formatter:Finance.formatAccountting},				
						{name : "saleGrossProfitRate",label:"毛利率",index : "sale_gross_profit_rate",editFlag:true,formatter:Finance.formatAccountting},			
						/* {name : "remark",label:"备注",index : "remark",editable:true}, */				
						{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType},    
			           	],};
//深运营表表头     
var deepOperaModel ={url: "<m:url value='/operaDate/listOperaDate.do'/>?type=deepOpera",
				 	colModel:[
							{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
							 {name : "storeName",label:"商户名称",index : "store_name",width:320}, 				
							{name : "createDate",label:"日期",index : "create_date",width:200},				
							{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true,width:100},				
							{name : "validNum",label:"有效单",index : "valid_num",width:100},				
							{name : "orginPrice",label:"原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "specialOrgin",label:"特价菜原价",index : "special_orgin",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
							{name : "specialOffer",label:"特价菜结算",index : "special_offer",isBasic:true,editable:true},				
							{name : "activitiesSubsidyBymerchant",label:"实际菜品折扣",index : "activities_subsidy_bymerchant",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "orderDistCharge",label:"订单上收取客户配送费",index : "order_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformDistCharge",label:"平台收取配送费",index : "platform_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "cyzDistCharge",label:"运营收取客户配送费",index : "cyz_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "activitiesSubsidyBycompany",label:"运营承担线上活动费",index : "activities_subsidy_bycompany",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformActivitiesCharge",label:"平台承担线上活动费",index : "platform_activities_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformServiceCharge",label:"平台服务费",index : "platform_service_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",editFlag:true,formatter:Finance.formatAccountting},	
							{name : "orderSaleRate",label:"结算比例",index : "order_sale_rate",editFlag:true,hidden:true,editable:true,formatter:Finance.formatAccountting,calculate:"0.65"},	
							{name : "amountRatePayable",label:"品牌商家应收",index : "amount_rate_payable",editFlag:true,formatter:Finance.formatAccountting},		
							{name : "cyzServiceChargeOperaPart",label:"运营应收",index : "cyz_service_charge_opera_part",editFlag:true,formatter:Finance.formatAccountting},	
							{name : "distAll",label:"应付配送费",index : "dist_all",formatter:Finance.formatAccountting,editable:true},	
							{name : "actualMerchantDistCharge",label:"自配送实际支付金额",index : "actual_merchant_dist_charge",editable:true},			
							{name : "distDiff",label:"自配送实际支付差额",index : "dist_diff",formatter:Finance.formatAccountting},		
							{name : "saleGrossProfit",label:"运营实收",index : "sale_gross_profit",editFlag:true,formatter:Finance.formatAccountting},			
							{name : "cyzServiceChargeIndustryPart",label:"工厂应收",index : "cyz_service_charge_industry_part",editFlag:true,formatter:Finance.formatAccountting},		
							/* {name : "remark",label:"备注",index : "remark",editable:true}, */				
							{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType},    
			           	],};
//平台到账抽佣运营表表头            		
var platformAccountModel = {
						url: "<m:url value='/operaDate/listOperaDate.do'/>?type=platformAccount",
						colModel:[
							{name : "id",hidden : true,key : true,label:"主键",index : "id",frozen:true,},				
							{name : "storeName",label:"商户名称",index : "store_name",width:320,frozen:true,}, 				
							{name : "createDate",label:"日期",index : "create_date",width:200,frozen:true,},				
							{name : "invalidNum",label:"无效单",index : "invalid_num",editable:true,width:100},				
							{name : "validNum",label:"有效单",index : "valid_num",width:100},				
							{name : "orginPrice",label:"原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "specialOrgin",label:"特价菜原价",index : "special_orgin",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
							{name : "specialOffer",label:"特价菜结算",index : "special_offer",isBasic:true,editable:true,formatter:Finance.formatAccountting},				
							{name : "activitiesSubsidyBymerchant",label:"实际菜品折扣",index : "activities_subsidy_bymerchant",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "orderDistCharge",label:"订单上收取客户配送费",index : "order_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformDistCharge",label:"平台收取配送费",index : "platform_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "cyzDistCharge",label:"公司收取配送费",index : "cyz_dist_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "activitiesSubsidyBycompany",label:"公司承担线上活动费",index : "activities_subsidy_bycompany",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformActivitiesCharge",label:"平台承担线上活动费",index : "platform_activities_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "platformServiceCharge",label:"平台服务费",index : "platform_service_charge",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "productSaleAmount",label:"产品销售金额",index : "product_sale_amount",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "amountReceivable",label:"应收平台结算金额",index : "amount_receivable",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "orderSaleRate",label:"结算比例",index : "order_sale_rate",hidden:true,calculate:"0.95",editFlag:true,editable:true},				
							{name : "amountRatePayable",label:"按比例计算结算金额",index : "amount_rate_payable",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "amountPayable",label:"应付店铺结算金额",index : "amount_payable",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "cyzServiceCharge",label:"公司收取店铺服务费",index : "cyz_service_charge",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "actualMerchantDistCharge",label:"自配送实际支付金额",index : "actual_merchant_dist_charge",editable:true,formatter:Finance.formatAccountting},				
							{name : "saleGrossProfit",label:"销售毛利",index : "sale_gross_profit",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "saleGrossProfitRate",label:"毛利率",index : "sale_gross_profit_rate",editFlag:true,formatter:Finance.formatAccountting},				
							/* {name : "remark",label:"备注",index : "remark",editable:true},	 */			
							{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType},    		
			           	],};
	$(function(){
			initGrid("platformAccount");
			Finance.changeTabMenu();
    });
	//初始化grid
	function initGrid(ways){
		if(localStorage.getItem(ways+"Model")){
			var localStorageModel = $.each(JSON.parse(localStorage.getItem(ways+"Model")), function(idx, obj) {
				if(obj.serial){
					obj.formatter=cellFormat;
				}
			    return obj;
			});
		}
		gridObj = Finance.createGrid(ways,localStorageModel,true,true,baseUrl+"/operaDate/updateOperaDate.do?type="+ways);
		gridObj.setFrozenColumns();
		
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('isBasic');
		$("#"+ways).setColProp('editFlag');
		if(ways="basePrice"){
			jQuery("#basePrice").jqGrid('setGroupHeaders', {
		    useColSpanStyle: true, 
		    groupHeaders:[
			   {startColumnName: 'invalidNum', numberOfColumns:2, titleText: '每日单量'},
			   {startColumnName: 'goodsQuality', numberOfColumns:3, titleText: '商家底价'},
			   {startColumnName: 'platformServiceCharge', numberOfColumns:2, titleText: '平台收取'},
		    ]
		  });
		}
	}
	
	//config grid
	function loadConfigGrid(ways,colModel){
		$(".listtable_box").html("");
		$(".listtable_box").html('<table id="'+ways+'" ></table><div id="'+ways+'prowed"></div>');
		gridObj = Finance.loadConfigGrid(ways,colModel,true,true,baseUrl+"/operaDate/updateOperaDate.do?type="+ways);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('isBasic');
		$("#"+ways).setColProp('editFlag');
		if(ways="basePrice"){
			jQuery("#basePrice").jqGrid('setGroupHeaders', {
			    useColSpanStyle: true, 
			    groupHeaders:[
				   {startColumnName: 'invalidNum', numberOfColumns:2, titleText: '每日单量'},
				   {startColumnName: 'goodsQuality', numberOfColumns:3, titleText: '商家底价'},
				   {startColumnName: 'platformServiceCharge', numberOfColumns:2, titleText: '平台收取'},
			    ] 
			  });
		}
	}
	//配置的弹出框
	var config_iframe_dialog;
	//关闭配置页面，供子页面调用
  	function closeConfig(){
  		config_iframe_dialog.close();
  	}
    //导出运营明细数据
    function exportData(){
    	ExpExcel.showWin(gridObj,baseUrl+"/operaDate/exportExcel.do",'grid',gridObj.id);
    }
  	//获取表头	
    function getColModel(){
    	var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id')
    	var columnNames = $("#"+tableId).jqGrid('getGridParam','colModel');
    	return columnNames;
    }
  	//查看汇总信息
  	function changeTotal(){
  		var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id');
  		switch (tableId) {
		case "basePrice":
			loadConfigGrid(tableId,totalColModel.basePrice);
			break;
		case "platformAccount":
			loadConfigGrid(tableId,totalColModel.platformAccount);
			break;
		case "deepOpera":
			loadConfigGrid(tableId,totalColModel.deepOpera);
			break;
		case "saleRate":
			loadConfigGrid(tableId,totalColModel.saleRate);
			break;
		default:
			break;
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
					<i class="search_time_ico2" ></i>
					</div>
					<div class="time_bg">
					<input type="text" placeholder="起始日期" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					<i class="search_time_ico2" ></i>
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
						<c:if test="${configTitle}">
							<li>
								<a title="配置表头标题" href="javascript:;" onclick="Finance.configTitle()"> 
									<i class="back_icon permissions_icon"> </i> 
									<span>配置表头</span>
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
						<c:if test="${show}">
						<li>
							<a title="根据订单详细显示平台到账抽佣运营表" href="javascript:;" class="tableTab checked" data-id="platformAccount"> 
								<i class="back_icon show_icon"> </i> 
								<span>平台到账抽佣运营表</span>
							</a>
						</li>
						<li>
							<a title="根据订单详细显示底价运营表" href="javascript:;"  class="tableTab" data-id="basePrice"> 
								<i class="back_icon show_icon"> </i> 
								<span>底价运营表</span>
							</a>
						</li>
						<li>
							<a title="根据订单详细显示销售额比例抽佣运营表" href="javascript:;" class="tableTab" data-id="saleRate">   
								<i class="back_icon show_icon"> </i> 
								<span>销售额比例抽佣运营表</span>
							</a>
						</li>
						<li>
							<a title="根据订单详细显示深运营表" href="javascript:;"  class="tableTab" data-id="deepOpera"> 
								<i class="back_icon show_icon"> </i> 
								<span>深运营表</span>
							</a>
						</li>
						<li>
							<a href="javascript:;" class="btn" onclick="changeTotal();">
								<span>查看汇总信息</span>
							</a>
						</li>
						</c:if>
						
					</ul>
				</div>
	
			<!--功能按钮end-->
				<div class="listtable_box">
					<!--此处放表格-->
					<table  id="platformAccount" ></table>
					<div  id="platformAccountprowed"></div>	
				</div>
		</div>
	</div>
</body>
</html>
