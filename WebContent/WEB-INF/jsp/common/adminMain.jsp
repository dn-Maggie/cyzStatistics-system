<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html style="overflow:hidden">
<head lang="en">
<meta charset="UTF-8">
<title>后台管理</title>
<%@ include file="../common/ace.jsp"%>
<!-- page specific plugin styles -->
<link rel="stylesheet" type="text/css" href="${ctx}/styles/skin/default/theme.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/default/css/master.css" />
<%-- <link rel="stylesheet" href="${ctx}/static/css/chosen.css" /> --%>


<!-- page specific plugin scripts -->
<!--[if lte IE 8]>
		  <script src="${ctx}/static/js/excanvas.min.js"></script>
<![endif]-->
<script src="${ctx}/static/js/chosen.jquery.min.js"></script> 
<script src="${ctx}/static/js/fuelux/fuelux.spinner.min.js"></script>
<script src="${ctx}/static/js/date-time/moment.min.js"></script>
 <script src="${ctx}/static/js/jquery.autosize.min.js"></script> 

<!-- inline styles related to this page -->
<style type="text/css">
.mask-wrap {
	position: absolute;
	width: 100%;
	height: 100%;
	filter: alpha(opacity = 30);
	background-color: #FFFFFF;
	text-align: center;
	display: none;
	vertical-align: middle;
}

.mask-wrap-msg {
	font-size: 13px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	width: 50%;
	height: 30%;
	margin: auto;
	color: #f47115;
}

.mask-wrap-msg-img {
	width: 100px;
	height: 100px;
	vertical-align: middle;
}
input[name='timeQuantum']{
	visibility:hidden;
}
input[name='timeQuantum']+label{
    background-color: #fff;
    font-size: 12px;
    padding: 1px 6px 3px 2px;
    text-align: center;
   height: 20px;
    line-height: 20px;
}
input[name='timeQuantum']:checked+label{
	background-color: #f47115;
    color: #fff;
    font-size: 12px;
    padding: 1px 6px 3px 2px;
    text-align: center;
    height: 20px;
    line-height: 20px;
    border-radius: 3px;
}
.hidden{
	display:none;
}
.inlineBlock{
	display:inline-block;
}
.input-group{
	margin:0;
	padding:0;
}
.breadcrumb>li, .breadcrumb>li.active{
    vertical-align: middle;
    height:30px;
    line-height:30px;
    font-family: "Microsoft YaHei",SimSun,SimHei;
}
.breadcrumb{
	line-height:inherit;
}
.breadcrumb .posiText{
	font-weight:bold;
}
.breadcrumb>li>span{
	margin-right:4px;
	vertical-align:middle;
}
</style>
<!-- inline scripts related to this page -->
<script type="text/javascript">
jQuery(function($) {
	$('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
		$(this).next().focus();
	});
	try {
		ace.settings.check('main-container', 'fixed');
		ace.settings.check('breadcrumbs', 'fixed');
	} catch (e) { }
});
</script>
	

</head>
<body>
	<!-- 页面顶部¨ -->
	<%@ include file="top.jsp"%>
	<div class="main-container" id="main-container">
		<!-- script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
			
		</script-->
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<%@ include file="left.jsp"%>
			<div class="main-content">
				<div class="breadcrumbs" id="breadcrumbs" style="display:none">
					<!--script type="text/javascript">
						try {
							ace.settings.check('breadcrumbs', 'fixed');
						} catch (e) {
						}
					</script-->
					<form id="queryForm">
					<ul class="breadcrumb">
						<li class="posiText"><i class="icon-home home-icon"></i> <a href="${ctx}/index.do">首页</a></li>
						<li class="posiText active" style="margin-right:10px;"></li>
						<li style="margin-right:10px;"><span class="nowDate"></span></li>
						<li class="hidden">
							<span>商圈</span>
							<select class="search_select_nowidth" name="bussinessCir" id="bussinessCir">
								<option>请选择</option>
								<c:forEach items="${tradingArea}" var="tradingArea">
									<option value="${tradingArea.dictCode}"><c:out value="${tradingArea.dictName}"></c:out></option>
								</c:forEach>
							</select>
						</li>
						<li style="margin-right:10px;"  class="hidden">
							<span>活动类型</span>
							<select class="search_select_nowidth" name="activityType" id="activityType">
								<option>请选择</option>
								<c:forEach items="${activityType}" var="activityType">
									<option value="${activityType.dictCode}"><c:out value="${activityType.dictName}"></c:out></option>
								</c:forEach>
							</select>
						</li>
						<li style="margin-right:10px"  class="hidden">
							<input type="radio" name="timeQuantum" id="timeQuantum_today"><label for="timeQuantum_today">今天</label>
							<input type="radio" name="timeQuantum" id="timeQuantum_yesterday"><label for="timeQuantum_yesterday">昨天</label>
							<input type="radio" name="timeQuantum" id="timeQuantum_7"><label for="timeQuantum_7">近7天</label>
							<input type="radio" name="timeQuantum" id="timeQuantum_30"><label for="timeQuantum_30">近30天</label>
							<input type="radio" name="timeQuantum" id="timeQuantum_90"><label for="timeQuantum_90">近90天</label>
						</li>
						<li style="width:220px;display:inline-block;vertical-align: middle;"  class="hidden">
							<div class="input-group">
								<span class="input-group-addon">
									<i class="icon-calendar bigger-110"></i>
								</span>
								<input class="form-control" type="text" name="date-range-picker" id="id-date-range-picker-1" />
							</div>
						</li>
						<li  class="hidden"><input type="text" name="keyWord" id="keyWord" class="form-control" placeholder="请输入搜索关键字"></li>
						<li  class="hidden"><input type="button" class="search_btn_default" value="查询"></li>
					</ul>
					</form>
					
					<!-- .breadcrumb -->
					<!-- #nav-search -->
				</div>
			<div class="" id="contentright">
			<iframe style="*overflow-x: hidden; *table-layout: fixed; *word-wrap: break-word; word-break: break-all;"
					id="iframepage" name="iframepage" frameBorder=0 width="100%" height="100%" src="adminHomePage.do"> </iframe>
			</div>
				<!-- /.page-content -->
			</div>
			<!-- /.main-content -->
			<!-- 换肤 -->
			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>
				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#F47115">#F47115</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>
					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
			<!-- /#ace-settings-container -->
		</div>
		<!-- /.main-container-inner -->
	</div>
	<!-- basic scripts -->



	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='${ctx}/static/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='${ctx}/static/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='${ctx}/static/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<!-- script src="${ctx}/static/js/bootstrap.min.js"></script-->
	<!-- script src="${ctx}/static/js/typeahead-bs2.min.js"></script-->


	<!-- inline scripts related to this page -->
	<script type="text/javascript">
	function loadingMask(wrap) {
		return;
		// 默认遮罩全局
		if (wrap) {// 如果有指定某div进行遮罩
			wrap = $(wrap);
		} else {
			wrap = $(document.body);
		}
		if (wrap.find("div.mask-wrap").length > 0) {
			wrap.find("div.mask-wrap").show();
		} else {
			var winHg = wrap.get(0).offsetHeight;
			var winWd = wrap.get(0).offsetWidth;
			var _top = wrap.position().top;
			var _left = wrap.position().left;
			wrap.prepend($("<div class=\"mask-wrap\"></div>").css({
						display : "block",
						left : _left,
						top : _top,
						width : winWd,
						zIndex : 100000,
						height : winHg
					}).append($("<div class=\"mask-wrap-msg\"></div>")
					.html('<img class="mask-wrap-msg-img" src="${ctx}/styles/images/jiazai.gif" /><span>请稍候</span>')));
		}
	}

	function loadedMask(wrap) {
		if (wrap) {//remove
			$(wrap).find("div.mask-wrap").hide();
		} else {
			$(document.body).find("div.mask-wrap").hide();
		}
	}
		var fmid = "fhindex";
		var mid = "fhindex";
		function setIframePage(urlPath,targetUrl,id,fid){
			if (id != mid) {
				$("#" + mid).removeClass();
				mid = id;
			}
			if (fid != fmid) {
				$("#" + fmid).removeClass();
				fmid = fid;
			}
			$("#" + id).attr("class", "active");
		    if(targetUrl.indexOf('http:')>-1){
		    	targetUrl=targetUrl.substr(4);
		    }
		    $("#breadcrumbs").css("display", "block");
	    	document.getElementById("iframepage").src = targetUrl; 
		    getModuleName(urlPath);
	    	//getModuleName(event.target.parentElement.dataset.modulename);
		}
		function setHomePage(urlPath,targetUrl,id,fid){
			if (id != mid) {
				$("#" + mid).removeClass();
				mid = id;
			}
			if (fid != fmid) {
				$("#" + fmid).removeClass();
				fmid = fid;
			}
			$("#" + id).attr("class", "active");
		    if(targetUrl.indexOf('http:')>-1){
		    	targetUrl=targetUrl.substr(4);
		    }
	    	document.getElementById("iframepage").src = targetUrl; 
	    	$("#breadcrumbs").css("display", "none");
		}
		function getModuleName(moduleName){
			$('.breadcrumb>.active').text(moduleName);
			var date = new Date();
			var week =['日','一','二','三','四','五','六'];
			$('.nowDate').text('('+(date.getMonth()+1)+'月'+date.getDate()+'日  星期'+week[date.getDay()]+')');
		}
		function pageHeight() {
			if ($.support.msie) {
				return document.compatMode == "CSS1Compat" ? document.documentElement.clientHeight
						: document.body.clientHeight;
			} else {
				return self.innerHeight;
			}
		}
		function cmainFrame() {
			$('#contentright').height(pageHeight() -90);
			var hmain = document.getElementById("iframepage");
			hmain.style.width = '100%';
			hmain.style.height = (pageHeight()-90) + 'px';
			hmain.style.overflowX='none';
			hmain.style.overflowY='scroll';
		}
		//保存缩放菜单状态
		function menusf() {
			if (document.getElementsByName('menusf')[0].checked) {
				$.cookie('menusf', '', {
					expires : -1
				});
				$("#sidebar").attr("class", "menu-min");
			} else {
				$.cookie('menusf', 'ok');
				$("#sidebar").attr("class", "");
			}
		}
		$(function() {
			cmainFrame();
			window.onresize = function() {
				cmainFrame();
			}
			 /* $("[name='stopPropagation']").click(function(event) { 
					 event.stopPropagation();
	         });   */
			$(".dropdown-toggle").click(function(event) {
				getModuleName(event.target.parentElement.dataset.modulename);
       		}); 
		});
	</script>

</body>
</html>

