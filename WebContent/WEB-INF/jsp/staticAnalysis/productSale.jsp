<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<%@ include file="../common/header.jsp"%>
		<%@ include file="../common/ace.jsp"%>
		<style type="text/css">
			.platform_totalMoney_item{
				background-color:#fff;
				height:300px;
			}
			.platform_totalMoney_item{
				background-color:#fff;
				height:300px;
			}
			.platform_totalMoney_item-Name{
				display:block;
				height:30%;
				padding: 10px;
			}
			.platform_totalMoney_item-todayValue{
				display:block;
				height:30%;
				text-align:center;
				font-size:40px;
			}
			.platform_totalMoney_item-yesterdayValue{
				display:block;
				height:30%;
				text-align:center;
			}
			.ui-jqgrid .ui-jqgrid-pager-nonav{
				height:100%;
			}
		</style>
		
		<!-- page specific plugin scripts -->
		<!--[if lte IE 8]>
		  <script src="<%=request.getContextPath() %>/static/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.resize.min.js"></script>
	</head>
	<body>
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
				<li><input type="reset" class="reset_btn" onclick="resetForm('')" value="重置"><!-- 重置 -->
						<input type="button" class="search_btn mr22 " onclick="doSearch();" value="查询"></li><!-- 查询-->
				</ul>
		   </div>
	    </form>
	    <div class="listplace">
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
	   		
			<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							产品销售饼图（TOP5）
						</h5>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-product"></div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
				<div class="widget-box">
					<table  id="goods" ></table>
					<div  id="goodsprowed"></div>	
				</div><!-- /widget-box -->
			</div>
		</div>
	</div>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		var gridObj = {};
			$(function(){
				gridObj = new biz.grid({
			        id:"#goods",/*html部分table id*/
			        url: "<m:url value='/accountOrderDetail/listAccountSaleGoods.do'/>",/*grid初始化请求数据的远程地址*/
			        datatype: "json",/*数据类型，设置为json数据，默认为json*/
			       	sortname:"goods_price",
			       	rownumbers:true,
			       	sortorder:"desc",
			       	pager: '#goodsprowed' /*分页栏id*/,
			 		rowList:[5,15,50,100],
					rowNum:5,
			    	colModel:[{name : "id",hidden : true,key : true,label:"主键",index : "id"},						
						{name : "storeName",label:"商户名称",index : "store_name",width:350}, 
						{name : "goodName",label:"菜品名称",index : "good_name",width:300},	
						{name : "goodNum",label:"销售数量",index : "good_num",width:300},		
						{name : "goodUnitPrice",label:"结算单价",index : "good_unit_price",formatter:Finance.formatAccountting,width:300},	
						{name:"goodsPrice",label:"销售额",formatter:Finance.formatAccountting,width:300},
						{name : "platformType",label:"平台类型",index : "platform_type",formatter:GridColModelForMatter.platformType,width:350},
				       	],
			    	serializeGridData:function(postData){//添加查询条件值
						var obj = getQueryCondition();
						$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
						return obj;
					}
			  });
				drwaPie();
			});
			function getGoodsTotalPrice(){
		    	var param = getQueryCondition();
		    	var data = ajax("<m:url value='/accountOrderDetail/getGoodsTotalPrice.do'/>", param);
		    	return data;
		    };
		    function getTop5Goods(){
		    	var param = getQueryCondition();
		    	var data = ajax("<m:url value='/accountOrderDetail/getTop5Goods.do'/>", param);
		    	return data;
		    };
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
			function drwaPie(){
				<!--产品销售饼状图-->
				var product = $('#piechart-product').css({'width':'90%' , 'min-height':'150px'});
			  	var datas = getTop5Goods().rows;
			  	var totalPrice = getGoodsTotalPrice();
				var data = []
				for(var i = 0;i<datas.length;i++){
					data.push({label:datas[i].goodName,data:(datas[i].goodsPrice/totalPrice)});
				}
				data[0].color = "#4383b4"
				data[1].color = "#3ECF8B"
				data[2].color = "#FF2D48"
				data[3].color = "#F47115"
				data[4].color = "rgb(237, 121, 122)"
				function drawPieChart(product, data, position){
				 	  $.plot(product, data, {
						series: {
							pie: {
								show: true,
								tilt:0.8,
								highlight: {
									opacity: 0.25
								},
								stroke: {
									color: '#fff',
									width: 2
								},
								startAngle: 2
							}
						},
						legend: {
							show: true,
							position: position || "ne", 
							labelBoxBorderColor: null,
							margin:[-30,15]
						}
						,
						grid: {
							hoverable: true,
							clickable: true
						}
					 })
				 }
				 drawPieChart(product, data);
				 product.data('chart', data);
				 product.data('draw', drawPieChart);
				 
				  var $tooltip = $("<div class='tooltip in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
				  var previousPoint = null;
				
				  product.on('plothover', function (event, pos, item) {
					if(item) {
						if (previousPoint != item.seriesIndex) {
							previousPoint = item.seriesIndex;
							var tip = item.series['label'] + " : " + item.series['percent'].toFixed(2)+'%';
							$tooltip.show().children(0).text(tip);
						}
						$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
					} else {
						$tooltip.hide();
						previousPoint = null;
					}
					
				 });

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
			    };
			    //查询Grid数据
			    function doSearch(isStayCurrentPage){
			    	if(!isStayCurrentPage)gridObj.setGridParam({"page":"1"});
			     	gridObj.trigger('reloadGrid');
			    	drwaPie();
			    };
			    //重置查询表单
			    function resetForm(formId){
					document.getElementById(formId).reset();
				};
			    
		</script>
	</body>
</html>

