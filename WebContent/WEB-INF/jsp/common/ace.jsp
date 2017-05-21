<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- basic styles -->
<link href="<%=request.getContextPath() %>/static/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font-awesome.min.css" />
<!--[if IE 7]>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/font-awesome-ie7.min.css" />
<![endif]-->

<!-- 表单控件css -->
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/jquery-ui-1.10.3.custom.min.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/chosen.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/datepicker.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/bootstrap-timepicker.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/daterangepicker.css" />
<link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/colorpicker.css" />

<!-- ace styles -->
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/ace.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/ace-rtl.min.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/static/css/ace-skins.min.css" />


<!--[if lte IE 8]>
  <link rel="stylesheet" href="<%=request.getContextPath() %>/static/css/ace-ie.min.css" />
<![endif]-->
<!-- ace settings handler -->
<script src="<%=request.getContextPath() %>/static/js/ace-extra.min.js"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
<script src="<%=request.getContextPath() %>/static/js/html5shiv.js"></script>
<script src="<%=request.getContextPath() %>/static/js/respond.min.js"></script>
<![endif]-->

<!-- basic scripts -->
<!--[if !IE]> -->
<script type="text/javascript">
	window.jQuery || document.write("<script src='<%=request.getContextPath() %>/static/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>
<!-- <![endif]-->
<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='<%=request.getContextPath() %>/static/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->


<script type="text/javascript">
	if("ontouchend" in document) document.write("<script src='<%=request.getContextPath() %>/static/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=request.getContextPath() %>/static/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/typeahead-bs2.min.js"></script>

<!-- 表单控件js-->
<script src="<%=request.getContextPath() %>/static/js/chosen.jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/fuelux/fuelux.spinner.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/date-time/moment.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/date-time/daterangepicker.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/bootstrap-colorpicker.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.knob.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.autosize.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/jquery.maskedinput.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/bootstrap-tag.min.js"></script>

<!-- ace scripts -->
<script src="<%=request.getContextPath() %>/static/js/ace-elements.min.js"></script>
<script src="<%=request.getContextPath() %>/static/js/ace.min.js"></script>
<!-- script src="<%=request.getContextPath() %>/static/js/jquery.ui.touch-punch.min.js"></script-->


<!-- 其他scripts -->
<script src="<%=request.getContextPath() %>/js/extend/accounting.min.js"></script>

<style type="text/css">
	 .table thead>tr>th, .table tbody>tr>th, .table tfoot>tr>th, .table thead>tr>td, .table tbody>tr>td, .table tfoot>tr>td{
		vertical-align: middle;
    	border-top: 0;
	}  
	.ui-pg-table>tbody>tr>.ui-pg-button>.ui-icon {
	    display: inline-block;
	    padding: 0;
	    width: 20px;
	    height: 20px;
	    line-height: 20px;
	    text-align: center;
	    position: static;
	    color: #808080;
	    border: 1px solid #CCC;
	    background-color: #FFF;
	    border-radius: 100%;
	    background-color: white;
	}
	.ui-jqgrid-sortable {
	    padding-left: 4px;
	    font-size: 13px;
	    color: #fff;
	    font-weight: bold;
	}
	.ui-jqgrid-sortable:hover {
	   	 color: #666;
	}
	.ui-state-default ui-th-column-header ui-th-ltr,.ui-jqgrid .ui-jqgrid-labels th{
		text-align: center!important;
	}
	.ui-jqgrid tr.footrow-ltr td {
	    border: 0; 
	    text-align: center;
	}
	.th[aria-selected=true] .ui-jqgrid-sortable,.ui-icon,th[aria-selected=true] .ui-jqgrid-sortable {
	    color: #f47115;
	}
	.ui-th-column, .ui-jqgrid .ui-jqgrid-htable th.ui-th-column{
		white-space:normal; 
	}
	.ui-jqgrid-sortable{
		font-weight:normal;
	}
	textarea, input[type="text"], input[type="password"], input[type="datetime"], input[type="datetime-local"], input[type="date"], input[type="month"], input[type="time"], input[type="week"], input[type="number"], input[type="email"], input[type="url"], input[type="search"], input[type="tel"], input[type="color"]{
		padding-top:0;
		padding-bottom:0;
   		height: 30px;
	}
	body{
	    padding-bottom: 20px;}
	    ::-webkit-scrollbar{height:5px}
::-webkit-scrollbar-track{background-color:#FFF;}
::-webkit-scrollbar-thumb{background-color:#F47115;}
::-webkit-scrollbar-thumb:hover {background-color:#F47115}
::-webkit-scrollbar-thumb:active {background-color:#F47115}
</style>
<script src="<%=request.getContextPath() %>/js/ace-common.js"></script>