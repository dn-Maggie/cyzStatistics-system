<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld"%>
<%@ taglib prefix="fn" uri="/WEB-INF/tld/fn.tld"%>
<%@ taglib prefix="m" uri="/WEB-INF/tld/spring.tld"%>
<%@ taglib prefix="form" uri="/WEB-INF/tld/spring-form.tld"%>
<meta http-equiv="Content-Type" content="text/xml; charset=utf-8" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/index.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/menu_animation.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/skin/default/theme.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/skin/default/components/jqgrid/jquery.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/skin/default/components/tree/zTreeStyle.css" />


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/base.css" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/master.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/trans.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/popup_window.css" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/style.css" media="screen" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/styles/default/css/pagination.css" media="screen" />
<style>
<!--
.ui-jqgrid tr.ui-row-ltr td{
	text-align:center;
}
-->
</style>
<script type="text/javascript">
  baseUrl="<%=request.getContextPath()%>";
</script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/lib/biz.jquery.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/excelExport.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/styles/index.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/lib/biz-html5.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/lib/biz-ie.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.cookie.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/i18n/i18n_zh.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/lib/biz.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.nicescroll.js"></script>
<script title="js模板控件" type="text/javascript" src="<%=request.getContextPath() %>/js/doT.min.js"></script>
<!-- 自定义js -->
<script title="表格列耐热格式" type="text/javascript" src="<%=request.getContextPath() %>/js/GridColModelForMatter.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bizLib/common.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bizLib/jquery.form.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bizLib/jquery.contextmenu.r2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/tiledCombobox.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/bizLib/placeholder.js"></script>

<script src="<%=request.getContextPath() %>/js/gameco/jquery.collapse.js"></script>
<script src="<%=request.getContextPath() %>/modulejs/common.js"></script>
<script src="<%=request.getContextPath() %>/js/extend/list.js"></script>
<style>
.ui-pg-selbox {
	font-size: 14px;
}
body{
-webkit-user-select: none;  /* Chrome all / Safari all */
-moz-user-select: none;     /* Firefox all */
-ms-user-select: none;      /* IE 10+ */
/* No support for these yet, use at own risk */
-o-user-select: none;
user-select: none;
}


</style>

