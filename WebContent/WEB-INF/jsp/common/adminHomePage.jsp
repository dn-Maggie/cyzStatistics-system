<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@page import="com.cyz.staticsystem.common.util.Utils"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" class="no-js">
<%@ include file="header.jsp"%>
<%@ include file="ace.jsp"%>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title></title>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="renderer" content="webkit">
<meta name="Keywords" content=""/>
<meta name="Description" content=""/>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">

<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/default/css/index_static.css">
<style type="text/css">
		.box {
			position: absolute;
			left: 0px;
			z-index: 99999999;
			background: white;
			width: 300px;
			border: 1px solid #ccc;
			padding: 10px;
		}
		.box li {
			line-height: 20px;
			font-weight: 600;
			color:#666;
		}
		.box span {
			float: right;
		}
		.breadcrumb{
			margin-left: 0!important;
		}
	</style>
</head>
<body onselect="return false;">
	<div class="search-time ">
	<ul class="breadcrumb">
    	<li><span>时间搜索</span>
    		<input type="text" placeholder="时间" class="search_time150 date-picker"  style="padding: 6px 12px;border-radius:5px!important;width:200px;" data-date-format="yyyy-mm-dd " id="queryTime">
		</li>
		<li>
			<span>商圈</span>
			<select class="search_select_nowidth" name="businessArea" id="businessArea">
				<option value="">请选择</option>
				<c:forEach items="${tradingArea}" var="tradingArea">
					<option value="${tradingArea.businessArea}"><c:out value="${tradingArea.businessArea}"></c:out></option>
				</c:forEach>
			</select>
		</li>
		<li>
			<input type="radio" name="timeQuantum" id="timeQuantum_today" checked><label for="timeQuantum_today">今天</label>
			<input type="radio" name="timeQuantum" id="timeQuantum_yesterday"><label for="timeQuantum_yesterday">昨天</label>
			<input type="radio" name="timeQuantum" id="timeQuantum_7"><label for="timeQuantum_7">近7天</label>
			<input type="radio" name="timeQuantum" id="timeQuantum_30"><label for="timeQuantum_30">近30天</label>
			<input type="radio" name="timeQuantum" id="timeQuantum_90"><label for="timeQuantum_90">近90天</label>
		</li>
		<li><span>商户名称：</span>
					<select class="search_select choose_select" name="storeId" id="storeId">
					<option value = "">所有店铺</option>
						<c:forEach var="store" items="${store}">
							<option value="${store.storeId}"> <c:out value="${store.storeName}"></c:out> </option>
		             	</c:forEach>
					</select>
		</li>
		<li><input type="button" id="breadcrumb_search" class="search_btn_default" value="查询"></li>
	</ul>
	</div>
	<div class="col-sm-12">
	<ul class="today">
		<li class="ht200">
			<div class="today_item todayAll">
				<div class="today_item_title">
					<span><img>财务数据总览</span>
				</div>
				<div class="today_item_data">
					<ul>
						<li class="wh50p " >
							<span><b></b>订单成交数量</span>
							<strong class="allNumber" style="color: rgb(238, 114, 26)" id="todayAccountOrderNum"></strong>
							
						</li>
						<li class="wh50p">
							<span><b></b>成交金额</span>
							<strong class="allAmount" style="color: rgb(237, 121, 122)" id="todayAccountOrderAmount"></strong>
						</li>
					</ul>
				</div>
			</div>
			<div class="today_item todayRank">
				<div class="today_item_title">
					<span><img>商家排名</span>
				</div>
				<div class="today_item_data">
					<ul id="storeOrderList">
					</ul>
				</div>
			</div>
		</li>
		<li class="ht200">
			<div class="today_item todayAll">
				<div class="today_item_title">
					<span><img>运营数据总览</span>
				</div>
				<div class="today_item_data">
					<ul>
						<li class="wh50p " >
							<span><b></b>订单成交数量</span>
							<strong class="allNumber" style="color: rgb(238, 114, 26)" id="todayOperaOrderNum"></strong>
							
						</li>
						<li class="wh50p">
							<span><b></b>成交金额</span>
							<strong class="allAmount" style="color: rgb(237, 121, 122)" id="todayOperaOrderAmount"></strong>
						</li>
					</ul>
				</div>
			</div>
			
			<div class="today_item todaySeller">
				<div class="today_item_title">
					<span><img>商家数量</span>
				</div>
				<div class="today_item_data">
					<ul id="storeNumList">
					</ul>
				</div>
			</div>
		</li>
	</ul>
	
	
		<div class="widget-box transparent">
			<div class="widget-header widget-header-flat">
				<h5 class="lighter" style="color:#555">
					<i class="icon-eye-open"></i>
					三大平台财务营业额总览
				</h5>
			</div>
			<div class="widget-body">
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">饿了么</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="elmOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="elmOrderAmount"></strong>
						</div>
					</div>
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">美团外卖</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="mtOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="mtOrderAmount"></strong>
						</div>
					</div>
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">百度外卖</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="bdwmOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="bdwmOrderAmount"></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="widget-box transparent">
			<div class="widget-header widget-header-flat">
				<h5 class="lighter" style="color:#555">
					<i class="icon-eye-open"></i>
					三大平台运营营业额总览
				</h5>
			</div>
			<div class="widget-body">
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">饿了么</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="elmOperaOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="elmOperaOrderAmount"></strong>
						</div>
					</div>
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">美团外卖</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="mtOperaOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="mtOperaOrderAmount"></strong>
						</div>
					</div>
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">百度外卖</span>
						<div class="detail_box">
							<strong class="platform_totalMoney_item-todayValue" id="bdwmOperaOrderNum"></strong>
							<strong class="platform_totalMoney_item-todayValue">/</strong>
							<strong class="platform_totalMoney_item-todayValue" id="bdwmOperaOrderAmount"></strong>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="widget-box transparent">
			<div class="widget-header widget-header-flat">
				<h5 class="lighter" style="color:#555">
					<i class="icon-signal"></i>
					营业额趋势图
				</h5>
				<div class="widget-toolbar">
					<a href="#" data-action="collapse">
						<i class="icon-chevron-up"></i>
					</a>
				</div>
			</div>
			<div class="widget-body" style="background-color: #ffffff;">
				<div class="widget-main padding-4">
					<div id="sales-charts"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=request.getContextPath() %>/static/js/jquery.slimscroll.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/jquery.easy-pie-chart.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/jquery.sparkline.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.pie.min.js"></script>
	<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.resize.min.js"></script>
	<script type="text/javascript">
	//修改密码弹出框
	var edit_password_iframe_dialog;
	$(document)
	.ready(function(){
		//获取父框架修改密码和用户资料按钮
		var _iframe = window.parent;
		var _setPwdBtn =_iframe.document.getElementById('setPwdBtn');
		//修改密码点击事件
		_setPwdBtn.addEventListener("click", function(){
				var url="<m:url value='/userInfo/toEditPassWord.do'/>";
				edit_password_iframe_dialog = new biz.dialog({
					id:$('<div id="addwindow_iframe"></div>').html('<iframe id="iframeAdd" name="iframeAdd" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
					modal: true,
					width: 400,
					height: 240,
					title: "修改密码"
				});
				edit_password_iframe_dialog.open();
		})
		queryStatic(new Date().format('yyyy-MM-dd'),new Date().format('yyyy-MM-dd'),"","");
		queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd'));
	})
	$("#queryTime").on("change",function(){
		queryStatic($("#queryTime").val(),$("#queryTime").val(),$("#storeId").val(),$("#businessArea").val());
	})
	$("input[name='timeQuantum']").on('click',function(){
		var chooseDate = $("input[type='radio']:checked").attr('id');
		switch (chooseDate) {
		case 'timeQuantum_yesterday':
			queryStatic(new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd'),$("#storeId").val(),$("#businessArea").val());
			queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*2).format('yyyy-MM-dd'));
			break;
		case 'timeQuantum_today':
			queryStatic(new Date().format('yyyy-MM-dd'),new Date().format('yyyy-MM-dd'),$("#storeId").val(),$("#businessArea").val());
			queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd'));
			break;
		case 'timeQuantum_7':
			queryStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*7).format('yyyy-MM-dd'),$("#storeId").val(),$("#businessArea").val());
			queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*7).format('yyyy-MM-dd'));
			break;
		case 'timeQuantum_30':
			queryStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*30).format('yyyy-MM-dd'),$("#storeId").val(),$("#businessArea").val());
			queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*30).format('yyyy-MM-dd'));
			break;
		case 'timeQuantum_90':
			queryStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*90).format('yyyy-MM-dd'),$("#storeId").val(),$("#businessArea").val());
			queryOperaStatic(new Date().format('yyyy-MM-dd'),new Date(new Date().getTime() - 86400000*90).format('yyyy-MM-dd'));
			break;
		default:
			break;
		}
	})
	$("#breadcrumb_search").on("click",function(){
		var storeId = $("#storeId").val();
		var queryTime = $("#queryTime").val()!=""?$("#queryTime").val():new Date().format('yyyy-MM-dd');
		var beginTime = $("#queryTime").val()!=""?$("#queryTime").val():new Date().format('yyyy-MM-dd');
		var businessArea = $("#businessArea").val();
		var chooseDate = $("input[type='radio']:checked").attr('id');
		switch (chooseDate) {
		case 'timeQuantum_yesterday':
			queryTime = new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd');
			beginTime =  new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd');
			break;
		case 'timeQuantum_today':
			queryTime = new Date().format('yyyy-MM-dd');
			beginTime =  new Date().format('yyyy-MM-dd');
			break;
		case 'timeQuantum_7':
			queryTime = new Date().format('yyyy-MM-dd');
			beginTime =  new Date(new Date().getTime() - 86400000*7).format('yyyy-MM-dd');
			break;
		case 'timeQuantum_30':
			queryTime = new Date().format('yyyy-MM-dd');
			beginTime = new Date(new Date().getTime() - 86400000*30).format('yyyy-MM-dd');
			break;
		case 'timeQuantum_90':
			queryTime = new Date().format('yyyy-MM-dd');
			beginTime =  new Date(new Date().getTime() - 86400000*90).format('yyyy-MM-dd');
			break;
		default:
			break;
		}
		queryStatic(queryTime,beginTime,storeId,businessArea);
	})
	function queryStatic(queryTime,beginTime,storeId,businessArea){
			var paramData = {
				username:"<%=Utils.getLoginUserInfo(request).getUserAccount()%>",
				password:"<%=Utils.getLoginUserInfo(request).getPassword()%>",
				queryTime:queryTime,
				beginTime:beginTime,
				storeId:$("#storeId").val(),
				businessArea:businessArea
			};
			/**
			 * 统计财务订单数据
			 */
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/calcuOrderDetail.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: true,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	drawAccountStaticData(response);
	             }
	        });
			/**
			 * 统计运营订单数据
			 */
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/calcuOperaDetail.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: true,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	drawOperaStaticData(response);
	             }
	        });
			/**
			 * 统计今日商家总量
			 */
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/staticStoreNum.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: true,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	drawStoreNum(response);
	             }
	        });
			/**
			 * 统计今日商家排名
			 */
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/staticStoreOrder.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: true,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	drawStoreOrder(response);
	             }
	        });
	}
	function queryOperaStatic(beginTime,endTime){
		//12天美团外卖营业额
		var d2 = [];
		//12天百度外卖营业额
		var d3 = [];
		//12天饿了么外卖营业额
		var d4 = [];
		getWeekData(beginTime,endTime,d2,d3,d4);
		drawOperaLine(d2,d3,d4);
	}
	function getWeekData(beginTime,endTime,d2,d3,d4){
			var paramData = {
				username:"<%=Utils.getLoginUserInfo(request).getUserAccount()%>",
				password:"<%=Utils.getLoginUserInfo(request).getPassword()%>",
				beginTime:beginTime,
				queryTime:endTime,
				storeId:$("#storeId").val(),
				businessArea:$("#businessArea").val()
			};
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/calcuOperaDetail.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: false,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	 var k = response.result;
	            	 for(var i = 0;i<k;i++){
	            		 d2.push([(k-i), response.operaStatic.detailStatic[i].mtsuccessOrderAmount]);
		            	 d3.push([(k-i), response.operaStatic.detailStatic[i].bdwmsuccessOrderAmount]);
		            	 d4.push([(k-i), response.operaStatic.detailStatic[i].elmsuccessOrderAmount]); 
	            	 }
	             }
	        });
	}
	//财务营业额
	function drawAccountStaticData(data){
		 $("#todayAccountOrderNum").text(data.accountStatic.successOrderNum);
         $("#todayAccountOrderAmount").text(data.accountStatic.successOrderPrice.toFixed(2));
         //财务营业额
         $("#elmOrderNum").text(data.accountStatic.elmsuccessOrderNum);
         $("#mtOrderNum").text(data.accountStatic.mtsuccessOrderNum);
         $("#bdwmOrderNum").text(data.accountStatic.bdwmsuccessOrderNum);
         $("#elmOrderAmount").text(data.accountStatic.elmsuccessOrderPrice.toFixed(2));
         $("#mtOrderAmount").text(data.accountStatic.mtsuccessOrderPrice.toFixed(2));
         $("#bdwmOrderAmount").text(data.accountStatic.bdwmsuccessOrderPrice.toFixed(2));
 	}
	 //运营营业额
	function drawOperaStaticData(data){
        $("#todayOperaOrderNum").text(data.operaStatic.allStatic.successOrderNum);
        $("#todayOperaOrderAmount").text(data.operaStatic.allStatic.successOrderAmount.toFixed(2));
		 //运营营业额
        $("#elmOperaOrderNum").text(data.operaStatic.allStatic.elmsuccessOrderNum);
        $("#mtOperaOrderNum").text(data.operaStatic.allStatic.mtsuccessOrderNum);
        $("#bdwmOperaOrderNum").text(data.operaStatic.allStatic.bdwmsuccessOrderNum);
        $("#elmOperaOrderAmount").text(data.operaStatic.allStatic.elmsuccessOrderAmount.toFixed(2));
        $("#mtOperaOrderAmount").text(data.operaStatic.allStatic.mtsuccessOrderAmount.toFixed(2));
        $("#bdwmOperaOrderAmount").text(data.operaStatic.allStatic.bdwmsuccessOrderAmount.toFixed(2));
	}
	 //商家数量
	function drawStoreNum(data){
		var storeNumList_htmltemp =""
      	if(data.storeNumList!=null){
       		for(var i=0;i<data.storeNumList.length;i++){
           	 storeNumList_htmltemp +='<li class="ht33p">'
    				+'<span>'+data.storeNumList[i].storeName+'</span>'
    				+'<span>'+data.storeNumList[i].averageSales+'</span>'
    				+'</li>'
            }
       	}
		 $("#storeNumList").html(storeNumList_htmltemp);
	}
	 //商家排名
	function drawStoreOrder(data){
		 var storeOrderList_htmltemp =""
         if(data.storeOrderList!=null){
            for(var i=0;i<data.storeOrderList.length;i++){
           	 storeOrderList_htmltemp +='<li>'
    				+'<span>'+data.storeOrderList[i].storeName+'</span>'
    				+'<span>'+data.storeOrderList[i].orderNo+'单</span>'
    				+'</li>'
            }
       	 }
		 $("#storeOrderList").html(storeOrderList_htmltemp);
	}
	 
	 
	 
	 
	//填充营业额趋势图	
	function drawOperaLine(d2,d3,d4){
		var ticks = [];
		for(var i = 0;i<d2.length;i++){
			var tick = [d2.length-i, new Date(new Date().getTime() - 86400000*i).format('yyyy-MM-dd')];
			ticks.push(tick);
		}
		$('.sparkline').each(function(){
			var $box = $(this).closest('.infobox');
			var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
			$(this).sparkline('html', {
				tagValuesAttribute:'data-values',
				type: 'line',
				barColor: barColor ,
				chartRangeMin:$(this).data('min') || 0} 
			);
		});
		var sales_charts = $('#sales-charts').css({'width':'100%' , 'height':'450px'});
		$.plot("#sales-charts", [
			{ label: "美团外卖营业额", data: d2, color:'#3ECF8B' },
			{ label: "百度外卖营业额", data: d3 , color:'#FF2D48'},
			{ label: "饿了么外卖营业额", data:d4, color:'#359BF5' }
		], {
			hoverable: true,
			shadowSize: 0,
			series: {
				lines: { show: true },
				points: { show: true},
			},
			xaxis: {
				ticks: ticks,
		        	}, 
			yaxis: {
				ticks: 6,
				min: 0,
				max: 120000,
				tickDecimals: 0
			},
			grid: {
				backgroundColor: { colors: [ "#fff", "#fff" ] },
				borderWidth: 0,
				borderColor:'#555'
			}
		});
	}

	</script>
</body>
</html>

