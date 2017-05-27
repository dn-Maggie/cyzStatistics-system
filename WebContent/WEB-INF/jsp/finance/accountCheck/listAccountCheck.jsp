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
//汇总对账表头
var totalColModel = [{name : "id",hidden : true,key : true,label:"主键",index : "id"},				
                     	{name : "storeName",label:"店铺名称",index : "store_name"},				
						{name : "createDate",label:"日期",index : "create_date"},				
						{name : "validNum",label:"订单数",index : "valid_num"},	
						{name : "specialOffer",label:"特价菜结算",index : "special_offer",formatter:Finance.formatAccountting},
						{name : "actualPrice",label:"原价菜金额",index : "actual_price",formatter:Finance.formatAccountting},				
						{name : "amountPayable",label:"结算金额",index : "amount_payable",formatter:Finance.formatAccountting}
                     ];
//绑商家卡对账表表头    
var boundMerchantModel = {url: "<m:url value='/accountCheck/listAccountCheck.do'/>?type=boundMerchant",
					 		colModel:[
							{name : "storeName",label:"店铺名称",index : "store_name"},
							{name : "createDate",label:"日期",index : "create_date"},				
							{name : "invalidNum",label:"无效单量",index : "invalid_num"},		
							{name : "validNum",label:"有效单量",index : "valid_num",isBasic:true,},	
							{name : "orginPrice",label:"原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "specialOrgin",label:"特价菜原价",index : "special_orgin",isBasic:true,formatter:Finance.formatAccountting},	
							{name : "specialOffer",label:"特价菜结算",index : "special_offer",isBasic:true,formatter:Finance.formatAccountting},
							{name : "actualPrice",label:"原价菜金额",index : "actual_price",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "amountPayable",label:"结算金额",index : "amount_payable",editFlag:true,formatter:Finance.formatAccountting}
		           		]};
//绑公司卡对账表表头         
var boundCompanyModel = {url: "<m:url value='/accountCheck/listAccountCheck.do'/>?type=boundCompany",
						colModel:[
							{name : "storeName",label:"店铺名称",index : "store_name"},
							{name : "createDate",label:"日期",index : "create_date"},				
							{name : "invalidNum",label:"无效单量",index : "invalid_num"},		
							{name : "validNum",label:"有效单量",index : "valid_num",isBasic:true,},	
							{name : "orginPrice",label:"原价",index : "orgin_price",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "mealFee",label:"餐盒费",index : "meal_fee",isBasic:true,formatter:Finance.formatAccountting},				
							{name : "specialOrgin",label:"特价菜原价",index : "special_orgin",isBasic:true,formatter:Finance.formatAccountting},	
							{name : "specialOffer",label:"特价菜结算",index : "special_offer",isBasic:true,formatter:Finance.formatAccountting},
							{name : "actualPrice",label:"原价菜金额",index : "actual_price",editFlag:true,formatter:Finance.formatAccountting},				
							{name : "amountPayable",label:"结算金额",index : "amount_payable",editFlag:true,formatter:Finance.formatAccountting}
		           		]};
	$(function(){
		initGrid("boundMerchant");
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
		gridObj = Finance.createGrid(ways,localStorageModel,true,false);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('editFlag');
	}
	
	//config grid
	function loadConfigGrid(ways,colModel){
		$(".listtable_box").html("");
		$(".listtable_box").html('<table id="'+ways+'" ></table><div id="'+ways+'prowed"></div>');
		gridObj = Finance.loadConfigGrid(ways,colModel,true,false);
		$("#"+ways).setColProp('calculate');
		$("#"+ways).setColProp('editFlag');
	}
	//配置的弹出框
	var config_iframe_dialog;
	//关闭配置页面，供子页面调用
  	function closeConfig(){
  		config_iframe_dialog.close();
  	}
	
    //导出运营明细数据
    function exportData(){
    	ExpExcel.showWin(gridObj,baseUrl+"/accountCheck/exportExcel.do",'grid',gridObj.id);
    }
    
  	//获取表头	
    function getColModel(){
    	var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id')
    	var columnNames = $("#"+tableId).jqGrid('getGridParam','colModel');
    	return columnNames;
    }
  //查看汇总信息
  	function changeTotal(){
  		var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id')
  		loadConfigGrid(tableId, totalColModel);
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
						<c:if test="${configTitle}">
							<li>
								<a title="配置表头标题" href="javascript:;" onclick="Finance.configTitle()"> 
									<i class="back_icon permissions_icon"> </i> 
									<span>配置表头</span>
								</a>
							</li>
						</c:if>
						<c:if test="${show}">
						<li>
							<a title="根据订单详细显示绑商家卡对账表" href="javascript:;" class="tableTab checked" data-id=boundMerchant>   
								<i class="back_icon show_icon"> </i> 
								<span>绑商家卡对账表</span>
							</a>
						</li>
						<li>
							<a title="根据订单详细显示绑公司卡对账表" href="javascript:;"  class="tableTab" data-id="boundCompany"> 
								<i class="back_icon show_icon"> </i> 
								<span>绑公司卡对账表</span>
							</a>
						</li>
						</c:if>
						<c:if test="${exportData}">
							<li>
								<a title="根据订单详细导出对账详细数据" href="javascript:;" onclick="exportData();"> 
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
					<table  id="boundMerchant" ></table>
					<div  id="boundMerchantprowed"></div>	
				</div>
				<div><input type="button" value= "查看汇总信息" onclick="changeTotal();" class="btn"></div>
		</div>
	</div>
</body>
</html>
