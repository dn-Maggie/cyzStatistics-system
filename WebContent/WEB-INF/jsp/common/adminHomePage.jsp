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
			<select class="search_select_nowidth" name="bussinessCir" id="bussinessCir">
				<option>请选择</option>
				<c:forEach items="${tradingArea}" var="tradingArea">
					<option value="${tradingArea.dictCode}"><c:out value="${tradingArea.dictName}"></c:out></option>
				</c:forEach>
			</select>
		</li>
		<li>
			<span>活动类型</span>
			<select class="search_select_nowidth" name="activityType" id="activityType">
				<option>请选择</option>
				<c:forEach items="${activityType}" var="activityType">
					<option value="${activityType.dictCode}"><c:out value="${activityType.dictName}"></c:out></option>
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
		<li><input type="button" id="breadcrumb_search" class="search_btn_default" value="查询"></li>
	</ul>
	</div>
	<div class="col-sm-12">
	<ul class="today">
		<li class="ht200">
			<div class="today_item todayAll">
				<div class="today_item_title">
					<span><img>今日总览</span>
				</div>
				<div class="today_item_data">
					<ul>
						<li class="wh50p " >
							<span><b></b>订单成交数量</span>
							<strong class="allNumber" style="color: rgb(238, 114, 26)" id="todayOrderNum"></strong>
							
						</li>
						<li class="wh50p">
							<span><b></b>成交金额</span>
							<strong class="allAmount" style="color: rgb(237, 121, 122)" id="todayOrderAmount"></strong>
						</li>
					</ul>
				</div>
			</div>
			<div class="today_item todayRank">
				<div class="today_item_title">
					<span><img>今日商家排名</span>
				</div>
				<div class="today_item_data">
					<ul id="storeOrderList">
					</ul>
				</div>
			</div>
		</li>
		<li class="ht200">
			<div class="today_item todayOrder">
				<div class="today_item_title">
					<span><img>平台交易订单数量</span>
				</div>
				<div class="today_item_data">
					<ul>
						<li class="wh33p">
							<strong class="elm"><b id="elmOrderNum"></b></strong>
							<span>【饿了么】</span>
						</li>
						<li class="wh33p">
							<strong class="meituan"><b id="mtOrderNum"></b></strong>
							<span>【美团外卖】</span>
						</li>
						<li class="wh33p">
							<strong class="baidu"><b id="bdwmOrderNum"></b></strong>
							<span>【百度外卖】</span>
						</li>
					</ul>
				</div>
			</div>
			<div class="today_item todaySeller">
				<div class="today_item_title">
					<span><img>今日商家数量</span>
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
					三大平台营业额总览
				</h5>
			</div>
			<div class="widget-body">
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">饿了么外卖</span>
						<strong class="platform_totalMoney_item-todayValue" id="elmOrderAmount"></strong>
					</div>
					
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">美团外卖</span>
						<strong class="platform_totalMoney_item-todayValue" id="mtOrderAmount"></strong>
					</div>
				</div>
				<div class="col-sm-4 platform_totalMoney">
					<div class="platform_totalMoney_item">
						<span class="platform_totalMoney_item-Name">百度外卖</span>
						<strong class="platform_totalMoney_item-todayValue" id="bdwmOrderAmount"></strong>
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
		
	
		<div class="orderNum box" style="display: none;">
			<ul class="ulOrderNum">
			</ul>
		</div>	
		<div class="orderAmount box" style="display: none;">
			<ul class="ulOrderAmount">
			</ul>
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
		queryStatic();
		queryOperaStatic();
	})
	$("#queryTime").on("change",function(){
		queryStatic();
	})
	$("#breadcrumb_search").on("click",function(){
		console.log(1);
	})
	function queryStatic(){
			var paramData = {
				username:"<%=Utils.getLoginUserInfo(request).getUserAccount()%>",
				password:"<%=Utils.getLoginUserInfo(request).getPassword()%>",
				queryTime:$("#queryTime").val().length>0?$("#queryTime").val():new Date().format("yyyy-MM-dd")
			};
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/calcuOrderDetail.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: false,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	drawStaticData(response);
	             }
	        });
	}
	function queryOperaStatic(){
		//12天总营业额
		var d1 = [];
		//12天美团外卖营业额
		var d2 = [];
		//12天百度外卖营业额
		var d3 = [];
		//12天饿了么外卖营业额
		var d4 = [];
		var i ;
		for(i = 0; i<= 6 ; i++){
			getWeekData(i,d1,d2,d3,d4);
		}
		console.log(d1,d2,d3,d4);
		drawOperaLine(d1,d2,d3,d4);
	}
	function getWeekData(i,d1,d2,d3,d4){
			var paramData = {
				username:"<%=Utils.getLoginUserInfo(request).getUserAccount()%>",
				password:"<%=Utils.getLoginUserInfo(request).getPassword()%>",
				queryTime:new Date(new Date().getTime() - 86400000*i).format('yyyy-MM-dd')
			};
			$.ajax({
	             type: "post",
	             url : "<m:url value='/config/calcuOrderDetail.do'/>",
	             data: JSON.stringify(paramData),
	             cache: true,
	             async: false,
	 		   	 dataType:"json",
	 		   	 contentType:false,
	             success: function(response){
	            	 d1.push([(7-i), response.successOrderPrice]);
	            	 d2.push([(7-i), response.mtsuccessOrderPrice]);
	            	 d3.push([(7-i), response.bdwmsuccessOrderPrice]);
	            	 d4.push([(7-i), response.elmsuccessOrderPrice]);
	             }
	        });
	}
	function drawStaticData(data){
		 $("#todayOrderNum").text(data.successOrderNum);
         $("#todayOrderAmount").text(data.successOrderPrice.toFixed(2));
         $("#elmOrderNum").text(data.elmsuccessOrderNum);
         $("#mtOrderNum").text(data.mtsuccessOrderNum);
         $("#bdwmOrderNum").text(data.bdwmsuccessOrderNum);
         $("#elmOrderAmount").text(data.elmsuccessOrderPrice.toFixed(2));
         $("#mtOrderAmount").text(data.mtsuccessOrderPrice.toFixed(2));
         $("#bdwmOrderAmount").text(data.bdwmsuccessOrderPrice.toFixed(2));
         var storeNumList_htmltemp =""
       	 var storeOrderList_htmltemp =""
      	 var _detailDayOrderNum_htmltemp =""
       	 var _detailDayOrderAmount_htmltemp =""
       	 if(data.storeNumList!=null){
       		for(var i=0;i<data.storeNumList.length;i++){
           	 storeNumList_htmltemp +='<li class="ht33p">'
    				+'<span>'+data.storeNumList[i].storeName+'</span>'
    				+'<span>'+data.storeNumList[i].averageSales+'</span>'
    				+'</li>'
            }
       	}
         if(data.storeOrderList!=null){
            for(var i=0;i<data.storeOrderList.length;i++){
           	 storeOrderList_htmltemp +='<li>'
    				+'<span>'+data.storeOrderList[i].storeName+'</span>'
    				+'<span>'+data.storeOrderList[i].orderNo+'单</span>'
    				+'</li>'
            }
       	 }
         $("#storeNumList").html(storeNumList_htmltemp);
         $("#storeOrderList").html(storeOrderList_htmltemp);
         var orderNumTemp = "";
         var orderAmontTemp  = "";
         if(data.result!=null){
	         for(var i = 0;i<data.result[0].length;i++) {
	        	 var _pt = data.result[0][i].platformType;
	        	 var store = data.result[0][i].storeName || "未登记店铺";
	        	 var platformType = _pt=='mt'?"美团":_pt=='elm'?"饿了么":_pt=='bdwm'?"百度外卖":"未知";
	        	 var color = _pt=='mt'?"#3ECF8B":_pt=='elm'?"#359BF5":_pt=='bdwm'?"#FF2D48":"#ccc";
	        	 orderNumTemp += '<li>'+ store +'（'+ platformType +'） <span style="color:'+color+'">'+ data.result[0][i].successOrderNum +'</span></li>';
	        	 orderAmontTemp += '<li>'+ store +'（'+ platformType +'） <span style="color:'+color+'">'+ data.result[0][i].successOrderAmount +'</span></li>';
	         }
         }
         $(".ulOrderNum").html(orderNumTemp);
    	 $(".ulOrderAmount").html(orderAmontTemp);
 	}
	
	$orderNum = $('.orderNum');
	$orderAmount = $('.orderAmount');
	$(".allNumber").hover(function(){$orderNum.show();},function(){$orderNum.hide();})
	$(".allAmount").hover(function(){$orderAmount.show();},function(){$orderAmount.hide();})
	$(".allNumber,.allAmount").mouseenter(function(e) {  
		$orderNum.css({top: e.pageY,left: e.pageX,});
		$orderAmount.css({top: e.pageY,left: e.pageX,})
	});
	
	
	
	//填充营业额趋势图	
	function drawOperaLine(d1,d2,d3,d4){
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
			{ label: "总营业额", data: d1},
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
				ticks: [[1, new Date(new Date().getTime() - 86400000*6).format('yyyy-MM-dd')],
				        [2, new Date(new Date().getTime() - 86400000*5).format('yyyy-MM-dd')],
				        [3, new Date(new Date().getTime() - 86400000*4).format('yyyy-MM-dd')],
				        [4, new Date(new Date().getTime() - 86400000*3).format('yyyy-MM-dd')],
				        [5, new Date(new Date().getTime() - 86400000*2).format('yyyy-MM-dd')],
				        [6, new Date(new Date().getTime() - 86400000).format('yyyy-MM-dd')],
				        [7, new Date().format("yyyy-MM-dd")]],
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

