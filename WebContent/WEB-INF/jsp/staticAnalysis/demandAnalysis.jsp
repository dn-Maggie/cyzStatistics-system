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
.ui-jqgrid .ui-jqgrid-pager-nonav{height:100%;}
.easy-pie-chart span{font-family: monospace;}
.widget-main {
    padding: 12px;
    position: relative;
}
.easyPieChart {
    position: absolute;
    text-align: center;
}
.stats-customsec-info-list {
    height: 200px;
    padding-top: 90px;
    box-sizing: border-box;
    margin-left: 245px;
    width: auto;
    position: relative;
}
.stats-customsec-info-list>.stats-customsec-info-showcount {
    text-align: center;
    display: inline-block;
}
.stats-customsec-info-list>.stats-customsec-info-showcount span {
    font-size: 30px;
    line-height: 1;
    color: #4c5165;
    margin-bottom: 6px;
    display: block;
    width: 200px;
}
.stats-customsec-info-list>.stats-customsec-info-showcount span:FIRST-CHILD {
    font-size: 14px;
    color: #3d4253;
    margin-bottom: 10px;
}
</style>
<script src="<%=request.getContextPath() %>/static/js/jquery.easy-pie-chart.min.js"></script>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/staticAnalysis/demandAnalysis.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"orderNum",
           	sortorder:"desc",
           	rownumbers:false,
           	shrinkToFit: false,
        	frozen:true,
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[5,15,50,100],//每页显示记录数
    		rowNum:5,//默认显示15条
            colModel:[
				{name : "orderNum",label:"下单次数",index : "orderNum"},
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
		drawChart();
    });
	function getdemandNum(){
		var param = getQueryCondition();
		var data = ajax("<m:url value='/staticAnalysis/demandNumAnalysis.do'/>", param);
    	return data;
	}
	function drawChart(){
		var data = JSON.parse(getdemandNum());
		$("#alls").text(data.storeELMId);
		$("#olds").text(data.storeMTId);
		$("#news").text(data.storeBDId);
		$("#oldsRate").text((data.storeMTId*100/data.storeELMId).toFixed(2)+'%');
		$('.easy-pie-chart.percentage').each(function(){
			var barColor = $(this).data('color') || '#4ad434';
			var trackColor = barColor == '#54a7f4' ? '#54a7f4' : '#54a7f4';
			var size = parseInt($(this).data('size')) || 200;
			$(this).easyPieChart({
				barColor: barColor,
				trackColor: trackColor,
				scaleColor: false,
				lineCap: 'butt',
				lineWidth:20,
				animate: /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase()) ? false : 1000,
				size: size
			});
		});
	}
	 //ajax请求
    function ajax(url, param) {
    	var data;
    	$.ajax({
    		type : "post",
    		url :   url,
    		data :  param,
    		cache : false,
    		async : false,
    		error : function() {
    			data = "";
    		},
    		success : function(response) {
				data = response;
    		}
    	});
    	return data;
    }
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
    	drawChart();
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
				  <li><input type="text" name="customName" class="text" placeholder="客户姓名"></li>
				 <li>
					<input type="reset" class="reset_btn" onclick="List.resetForm('queryForm')" value="重置"><!-- 重置 -->
					<input type="button" class="search_btn mr22 " onclick="doSearch(gridObj);" value="查询"></li><!-- 查询-->
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
				<div class="col-sm-12" >
					<div class="widget-box" >
						<div class="widget-header widget-header-flat widget-header-small">
							<h5 style="color:#555">
								<i class="icon-signal"></i>
								顾客总览
							</h5>
						</div>
						<div class="widget-body" style="padding: 12px;padding-left: 25%;padding-right: 15%;">
							<div class="widget-main">
								<div class="easy-pie-chart percentage"  data-percent="86*100/120" data-size="200">
									<span>所有顾客</span>
									<span class="percent" style="font-size: 26px;" id="alls">
									</span>
								</div> 
								<div class="stats-customsec-info-list">
									<div class="stats-customsec-info-showcount">
										<span>新顾客</span>
										<span class="percent" style="font-size: 26px;" id="news">
										</span>
									</div>
									<div class="stats-customsec-info-showcount">
										<span>老顾客</span>
										<span class="percent" style="font-size: 26px;" id="olds">
										</span>
									</div>
									<div class="stats-customsec-info-showcount">
										<span>复购率</span>
										<span class="percent" style="font-size: 26px;" id="oldsRate">
										</span>
									</div>
								</div>
							</div><!-- /widget-main -->
						</div><!-- /widget-body -->
					</div><!-- /widget-box -->
					<!-- 表格 -->
					<div class="widget-box">
						<table  id="remote_rowed" ></table>
						<div  id="remote_prowed"></div>		
					</div><!-- /widget-box -->
			</div>
		</div>
	</div>
</body>
</html>
