<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<div class="sidebar" id="sidebar">
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'fixed')
			} catch (e) {
		}
	</script>


	<ul class="nav nav-list">
		<li id="fhindex">
		<a href="javaScript:;" id="zindex" onclick='setHomePage("","adminHomePage.do","z","lm");'>
			<i class="icon-dashboard"></i> 
			<span class="menu-text"> 后台首页</span>
		</a>
		</li>

		<c:forEach var="menu" items="${menus}">
			<li id="z${menu.id}" data-moduleName="${menu.moduleName}">
				<a href="javascript:;" class="dropdown-toggle"
						<c:if test="${not empty menu.navurl}">
							name="stopPropagation"
							onclick='setIframePage("${menu.moduleName}","${ctx}${menu.navurl}","z${menu.id}","lm${menu.id}");'
							target="iframepage" 
						</c:if>> 
					<i class="${menu.resourceId }"></i>
					<span class="menu-text">${menu.moduleName }</span>
					<b class="arrow icon-angle-down"></b>
				</a>
				<ul class="submenu">
					<c:forEach var="mr" items="${menu.listModuleRes}">
						<li id="lm${mr.id}" data-moduleName="${mr.resourceName}">
						<a href="javascript:;"
							onclick='setIframePage("${mr.resourceName}","${ctx}${mr.resurl}","lm${mr.id }","z${menu.id }");'
							target="iframepage"> <i class="icon-double-angle-right"></i>
								${mr.resourceName }
						</a></li>
					</c:forEach>
				</ul></li>
		</c:forEach>

	</ul>
	<!-- /.nav-list -->

	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>

	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>





