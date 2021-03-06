<%@page import="com.cyz.staticsystem.common.enums.LogisticsCode"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<style type="text/css">
.ui-jqgrid-labels{height:54px;}
.ui-jqgrid-hdiv{overflow: hidden;}
</style>
<script type="text/javascript">
var gridObj = {};
	$(function(){
		gridObj =  new biz.grid({
	        id:"#orderDetail",
	        url: "<m:url value='/accountOrderDetail/listAccountOrderDetail.do'/>",
	       	sortname:"order_time",
	       	sortorder:"desc",
	       	rownumbers:true,
	       	frozen:true,
	       	shrinkToFit: false,
	       	ondblClickRow: function (rowid) {
	            var tr_id = rowid;
	            var url = baseUrl+'/accountOrderDetail/toShowAccountOrderDetail.do';
	    		var title = "订单明细详细";
	    		show_iframe_dialog = Show.create(tr_id, url, title);
	    		List.openDialog(show_iframe_dialog);
	        },
	       	footerrow:true,
	       	/* cellEdit:baseUrl+"/accountOrderDetail/updateAccountOrderDetail.do",
           	afterSaveCell : function(rowid,name,val,iRow,iCol) {
           			var paramDatas = {};
	           		paramDatas[name] = val;
	           		paramDatas.id = rowid;
	           		paramDatas.storeName = rowid.substr(19).replace(/elm$|bdwm$|mt$/,'');
	           		$ .ajax({
	           			type: "post",
	    				url: baseUrl+"/accountOrderDetail/updateAccountOrderDetail.do",
	    				data: paramDatas,
						cache:false,
	    				dataType:"json"
	    			});
          	},*/
	       	pager: "#orderDetailprowed",
	       	colModel:[
					{name : "id",hidden : true,key : true,label:"账单ID",index : "id",frozen:true},	
					{name : "storeName",label:"店铺名称",index : "store_name",width:220,frozen:true},
					{name : "orderTime",label:"订单时间",index : "order_time",width:200,frozen:true},	
					{name : "orderNo",label:"订单号",index : "order_no",width:200},
					{name : "latestStatus",label:"订单最终状态",index : "latest_status",width:100
							,formatter:GridColModelForMatter.lastStatus},	
					{name : "orderType",label:"订单类型",index : "order_type",width:100
						,formatter:GridColModelForMatter.orderType},	
					{name : "distributionMode",label:"配送方式",index : "distribution_mode",formatter:GridColModelForMatter.distributionMode},	
					{name : "orginPrice",label:"菜价",index : "orgin_price",width:100},				
					{name : "mealFee",label:"餐盒费",index : "meal_fee",width:100},			
					/*{name : "activitiesSubsidyBymerchant",label:"实际菜品折扣",index : "activities_subsidy_bymerchant",editable:true,width:100},	*/			
					{name : "specialOffer",label:"特价菜结算",index : "special_offer",width:100},			
					{name : "orderDistCharge",label:"订单取配送费",index : "order_dist_charge",width:100},
					{name : "platformDistCharge",label:"平台收取配送费",index : "platform_dist_charge",width:100},
					{name : "merchantDistCharge",label:"公司收取配送费",index : "merchant_dist_charge",width:100},			
					{name : "merchantActivitiesSubsidies",label:"商户承担活动补贴",index : "merchant_activities_subsidies",width:100},		
					{name : "platformActivitiesSubsidies",label:"平台承担活动补贴",index : "platform_activities_subsidies",width:100},	
					{name : "merchantSubsidyVouchers",label:"商户承担代金券补贴",index : "merchant_subsidy_vouchers",width:100},	
					{name : "platformSubsidyVouchers",label:"平台承担代金券补贴",index : "platform_subsidy_vouchers",width:100}, 
					{name : "serviceCharge",label:"服务费",index : "service_charge",width:100},				
					{name : "settlementAmount",label:"结算金额",index : "settlement_amount",width:100},	
					{name : "refundAmount",label:"用户申请退单金额",index : "refund_amount",width:80},
					{name : "remark",label:"备注",index : "remark",width:100},
					{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType,width:100},
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
			loadComplete: function(resp){
				if(resp.status!=null&&resp.status==0){
					showError(resp.message, 5000);
				}
			},
			gridComplete:function(){//表格加载执行  
				/*matchGrid(); */
			 	var footerCell = $(this).footerData();
			 	var footerObj = {};
			 	for(var i in footerCell){
			 		if(!/rn$|cb$|Time$|Date$|Name$|Type$|remark$|Mode$|No$|Rate$|id$/.test(i)){
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
		
    });
	//下载模板
	function executeDownload(){
		var fid = $("#downloadform");
		$("#downloadform").attr("action", "<%=request.getContextPath()%>/download/fileDownload");
		fid.submit();
	}
	
	//查看的弹出框
	var show_iframe_dialog;
  	
    function show(){
    	var key = ICSS.utils.getSelectRowData("id");
		var url = baseUrl+'/accountOrderDetail/toShowAccountOrderDetail.do';
		var title = "订单明细详细";
		show_iframe_dialog = Show.create(key, url, title);
		List.openDialog(show_iframe_dialog);
    }
    //关闭查看页面，供子页面调用
    function closeShow(){
    	List.closeDialog(show_iframe_dialog);
    }
    //删除
    function batchDelete(){
    	var ids = ICSS.utils.getSelectRowData("id");
		var url = baseUrl+'/accountOrderDetail/deleteAccountOrderDetail.do';
		List.batchDelete(id, url,gridObj);
    }
 	//导出订单详细数据
 	function exportData(){
 		ExpExcel.showWin(gridObj,baseUrl+"/accountOrderDetail/exportExcel.do",'grid','queryForm');
 	}
	//生成运营汇总表
    function genTotal(){
    	var storeId = $('#storeId').val();
    	if(storeId == null || storeId.length==0){
	    	new biz.alert({type:"confirm",message:"确定要生成所有店铺的深运营表吗?（确认将覆盖已生成的深运营记录，请及时将深运营表下载）",title:I18N.promp,callback:function(result){
				if(!result){
					return;
				}else{
					showInfo("正在处理，请稍后...");
					genOperaDate();
				}
			}});   
    	}else{
    		genOperaDate();
    	}
    }
    function genOperaDate(){
    	$.ajax({
 			type: "post",
 			data:Finance.getQueryCondition(),
	 		url: baseUrl+"/operaDate/addByOrderDetail.do",
	 		cache:false,
	 		dataType:"json",
	 		success : function(response) {
	 			showMessage(response.message,"提示", 5000);
	 		}
	 	});
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
				<li><span>配送方名称：</span>
					<select class="input_select" id="groupLogisticsCode" name="distributionMode" style="float:none">
						<option value="">--请选择--</option>
						<c:forEach items="<%=LogisticsCode.values() %>" var="status">
							<option value="${status.name}">${status.descript }</option>
						</c:forEach>
					</select> 
				</li>
				<li><span>订单状态：</span>
					<select class="search_select" name="latestValidStatus">
						<option value="">--请选择--</option>
						<option value="0">有效订单</option>
						<option value="1">无效订单</option>
					</select>
				</li>
				<li>
					<input type="text" placeholder="订单号"  class="search_choose" name="orderNo">
				</li>
				<li>
					<div class="time_bg">
						<input type="text" placeholder="订单截止"  class="search_time150 date-picker" name="propsMap['endDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
					<div class="time_bg">
						<input type="text" placeholder="订单起始" class="search_time150 date-picker" name="propsMap['startDate']" data-date-format="yyyy-mm-dd "><!-- 时间选择控件-->
					</div>
				</li>
				<!-- <li class="date_area">
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
					</li>		 -->
				 <li>
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
					<c:if test="${exportData}">
						<li>
							<a title="导出数据" href="javascript:;" onclick="exportData();"> 
								<i class="back_icon import_icon"> </i> 
								<span>导出数据</span>
							</a>
						</li>
					</c:if>
					<li>
						<a href="javascript:;" class="btn" onclick="genTotal();">
							<span>生成深运营运营表</span>
						</a>
					</li>
					</ul>
				</div>
	
				<!--功能按钮end-->
				<div class="listtable_box">
					<!--此处放表格-->
					<table  id="orderDetail" ></table>
					<div  id="orderDetailprowed"></div>		
				</div>
		</div>
	</div>
</body>
</html>
