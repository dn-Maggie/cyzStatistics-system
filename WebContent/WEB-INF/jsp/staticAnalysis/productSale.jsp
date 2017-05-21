<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML>
<html lang="en">
	<head>
		<%@ include file="../common/ace.jsp"%>
		<%@ include file="../common/header.jsp"%>
		<style type="text/css">
			.platform_totalMoney_item{
				background-color:#fff;
				height:200px;
			}
			.platform_totalMoney_item{
				background-color:#fff;
				height:200px;
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
		</style>
		
		<!-- page specific plugin scripts -->
		<!--[if lte IE 8]>
		  <script src="<%=request.getContextPath() %>/static/js/excanvas.min.js"></script>
		<![endif]-->
		<script src="<%=request.getContextPath() %>/static/js/jquery.slimscroll.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/jquery.easy-pie-chart.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.pie.min.js"></script>
		<script src="<%=request.getContextPath() %>/static/js/flot/jquery.flot.resize.min.js"></script>
	</head>
	<body onbeforeunload="checkLeave()">
			<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							产品销售饼图
						</h5>

						<div class="widget-toolbar no-border">
							<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
								本周<i class="icon-angle-down icon-on-right bigger-110"></i>
							</button>
							<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
								<li class="active">
									<a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>本月</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上月</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-product"></div>

							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<div class="grid3">
									<span class="grey">
										<i class="icon-facebook-sign icon-2x blue"></i>
										&nbsp; likes
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-twitter-sign icon-2x purple"></i>
										&nbsp; tweets
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-pinterest-sign icon-2x red"></i>
										&nbsp; pins
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
			</div>
			<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							行业销售饼图
						</h5>
						<div class="widget-toolbar no-border">
							<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
								本周<i class="icon-angle-down icon-on-right bigger-110"></i>
							</button>
							<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
								<li class="active">
									<a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>本月</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上月</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-industry"></div>
							<div class="hr hr8 hr-double"></div>
							<div class="clearfix">
								<div class="grid3">
									<span class="grey">
										<i class="icon-facebook-sign icon-2x blue"></i>
										&nbsp; likes
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-twitter-sign icon-2x purple"></i>
										&nbsp; tweets
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-pinterest-sign icon-2x red"></i>
										&nbsp; pins
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
			</div>
			<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							品类销售饼图
						</h5>

						<div class="widget-toolbar no-border">
							<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
								本周<i class="icon-angle-down icon-on-right bigger-110"></i>
							</button>

							<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
								<li class="active">
									<a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>本月</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上月</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-category"></div>

							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<div class="grid3">
									<span class="grey">
										<i class="icon-facebook-sign icon-2x blue"></i>
										&nbsp; likes
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-twitter-sign icon-2x purple"></i>
										&nbsp; tweets
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-pinterest-sign icon-2x red"></i>
										&nbsp; pins
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
		</div>
		<div class="col-sm-12">
			<div class="widget-box transparent">
				<div class="widget-header widget-header-flat">
					<h4 class="lighter" style="color:#555">
						<i class="icon-eye-open"></i>
						三大平台营业额总览
					</h4>
				</div>
				<div class="widget-body">
					<div class="col-sm-4 platform_totalMoney">
						<div class="platform_totalMoney_item">
							<span class="platform_totalMoney_item-Name">美团外卖</span>
							<strong class="platform_totalMoney_item-todayValue">8909.00</strong>
							<span class="platform_totalMoney_item-yesterdayValue">昨日  ￥7890.00</span>
						</div>
					</div>
					<div class="col-sm-4 platform_totalMoney">
						<div class="platform_totalMoney_item">
							<span class="platform_totalMoney_item-Name">饿了么外卖</span>
							<strong class="platform_totalMoney_item-todayValue">7099.00</strong>
							<span class="platform_totalMoney_item-yesterdayValue">昨日  ￥7090.00</span>
						</div>
					</div>
					<div class="col-sm-4 platform_totalMoney">
						<div class="platform_totalMoney_item">
							<span class="platform_totalMoney_item-Name">百度外卖</span>
							<strong class="platform_totalMoney_item-todayValue">7309.00</strong>
							<span class="platform_totalMoney_item-yesterdayValue">昨日  ￥6890.00</span>
						</div>
					</div>
				</div><!-- /widget-body -->
			</div><!-- /widget-box -->
			
		</div>		
		<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							品类销售饼图
						</h5>

						<div class="widget-toolbar no-border">
							<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
								本周<i class="icon-angle-down icon-on-right bigger-110"></i>
							</button>

							<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
								<li class="active">
									<a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>本月</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上月</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-category"></div>

							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<div class="grid3">
									<span class="grey">
										<i class="icon-facebook-sign icon-2x blue"></i>
										&nbsp; likes
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-twitter-sign icon-2x purple"></i>
										&nbsp; tweets
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-pinterest-sign icon-2x red"></i>
										&nbsp; pins
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
		</div>
		<div class="col-sm-12">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 style="color:#555">
							<i class="icon-signal"></i>
							品类销售饼图
						</h5>

						<div class="widget-toolbar no-border">
							<button class="btn btn-minier btn-primary dropdown-toggle" data-toggle="dropdown">
								本周<i class="icon-angle-down icon-on-right bigger-110"></i>
							</button>

							<ul class="dropdown-menu pull-right dropdown-125 dropdown-lighter dropdown-caret">
								<li class="active">
									<a href="#" class="blue"><i class="icon-caret-right bigger-110">&nbsp;</i>本周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上周</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>本月</a>
								</li>
								<li>
									<a href="#"><i class="icon-caret-right bigger-110 invisible">&nbsp;</i>上月</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main">
							<div id="piechart-category"></div>

							<div class="hr hr8 hr-double"></div>

							<div class="clearfix">
								<div class="grid3">
									<span class="grey">
										<i class="icon-facebook-sign icon-2x blue"></i>
										&nbsp; likes
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-twitter-sign icon-2x purple"></i>
										&nbsp; tweets
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>

								<div class="grid3">
									<span class="grey">
										<i class="icon-pinterest-sign icon-2x red"></i>
										&nbsp; pins
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
							</div>
						</div><!-- /widget-main -->
					</div><!-- /widget-body -->
				</div><!-- /widget-box -->
		</div>
		<!-- inline scripts related to this page -->
		<script type="text/javascript">
		//离开页面的恢复导航栏方法
		function checkLeave(){
			var _iframe = window.parent;
			_iframe.$(".inlineBlock").each(function(){this.className='hidden'})
		}
			jQuery(function($){
				//进入页面的展开导航栏搜索方法
				var _iframe = window.parent;
				_iframe.$(".hidden").each(function(){this.className='inlineBlock'})
				<!--产品销售饼状图-->
				var product = $('#piechart-product').css({'width':'90%' , 'min-height':'150px'});
				  var data = [
					{ label: "麦当劳麦辣鸡翅",  data: 38.7, color: "#68BC31"},
					{ label: "豪大大爆浆鸡排",  data: 24.5, color: "#2091CF"},
					{ label: "林科大螺蛳粉",  data: 8.2, color: "#AF4E96"},
					{ label: "意品原味鱼头粉",  data: 18.6, color: "#DA5430"},
					{ label: "其他",  data: 10, color: "#FEE074"}
				  ]
				  function drawPieChart(product, data, position) {
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
				 <!--行业饼状图-->
				 var industry = $('#piechart-industry').css({'width':'90%' , 'min-height':'150px'});
				  var data = [
					{ label: "快餐便当",  data: 38.7, color: "#68BC31"},
					{ label: "小吃夜宵",  data: 24.5, color: "#2091CF"},
					{ label: "特色菜系",  data: 8.2, color: "#AF4E96"},
					{ label: "异国料理",  data: 18.6, color: "#DA5430"},
					{ label: "其他",  data: 10, color: "#FEE074"}
				  ]
				  function drawPieChart(industry, data, position) {
				 	  $.plot(industry, data, {
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
				 drawPieChart(industry, data);
				 industry.data('chart', data);
				 industry.data('draw', drawPieChart);
				 <!--品类饼状图-->
				 var category = $('#piechart-category').css({'width':'90%' , 'min-height':'150px'});
				  var data = [
					{ label: "川湘菜",  data: 38.7, color: "#68BC31"},
					{ label: "粤菜",  data: 24.5, color: "#2091CF"},
					{ label: "东北菜",  data: 8.2, color: "#AF4E96"},
					{ label: "江浙菜",  data: 18.6, color: "#DA5430"},
					{ label: "其他",  data: 10, color: "#FEE074"}
				  ]
				  function drawPieChart(category, data, position) {
				 	  $.plot(category, data, {
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
				 drawPieChart(category, data);
				 category.data('chart', data);
				 category.data('draw', drawPieChart);
			});
		</script>
	</body>
</html>

