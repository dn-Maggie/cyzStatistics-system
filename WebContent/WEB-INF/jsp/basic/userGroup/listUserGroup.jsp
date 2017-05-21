<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE HTML  >
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<title></title>
<script type="text/javascript">
var gridObj = {};
	$(function(){
  		gridObj = new biz.grid({
            id:"#remote_rowed",/*html部分table id*/
            url: "<m:url value='/userGroup/listUserGroup.do'/>",/*grid初始化请求数据的远程地址*/
            datatype: "json",/*数据类型，设置为json数据，默认为json*/
           	sortname:"id",
           	sortorder:"asc",
           	pager: '#remote_prowed' /*分页栏id*/,
     		rowList:[10,15,50,100],//每页显示记录数
    		rowNum:10,//默认显示15条
            colModel:[
				{name : "id",hidden : true,key : true,label:"组别ID(主键)",index : "id"},				
				{name : "groupName",label:"组别名",index : "group_name"},				
				{name : "groupDesc",label:"组别描述",index : "group_desc"},				
				{name : "groupStates",label:"组别状态",index : "group_states",
					formatter:GridColModelForMatter.enableStates},				
				{name : "groupCreaterName",label:"创建者",index : "group_creater"},				
				{name : "groupUpdaterName",label:"更新者",index : "group_updater"},				
				{name : "groupCreateTime",label:"创建时间",index : "group_create_time"},				
				{name : "groupUpdateTime",label:"更新时间",index : "group_update_time"}				
           	],
           	serializeGridData:function(postData){//添加查询条件值
				var obj = getQueryCondition();
    			$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
    			return obj;
    		}
      });
        
    });

 

    //新增的弹出框
	var add_iframe_dialog;
	//修改的弹出框
   	var edit_iframe_dialog;
	//查看的弹出框
	var show_iframe_dialog;
  	
  	function add(){
  	//xin zeng iframe 弹出框
		var url="<m:url value='/userGroup/toAddUserGroup.do'/>";
		add_iframe_dialog = new biz.dialog({
			id:$('<div id="addwindow_iframe"></div>').html('<iframe id="iframeAdd" name="iframeAdd" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
			modal: true,
			width: 800,
			height: 235,
			title: "用户组别增加"
		});
		add_iframe_dialog.open();
  	}
  	
  	//关闭新增页面，供子页面调用
  	function closeAdd(){
		add_iframe_dialog.close();
  	}
  	
    function edit(){
		var key = ICSS.utils.getSelectRowData("id");
		if(key.indexOf(",")>-1||key==""){
			showMessage("请选择一条数据！");
			return ;
		}
		var url="<m:url value='/userGroup/toEditUserGroup.do'/>?key="+key;
		edit_iframe_dialog = new biz.dialog({
		 	id:$('<div id="editwindow_iframe"></div>').html('<iframe id="iframeEdit" name="iframeEdit" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
			modal: true,
			width: 800,
			height: 235,
			title: "用户组别编辑"
		});
  		edit_iframe_dialog.open();
    }
    
    //关闭编辑页面，供子页面调用
    function closeEdit(){
    	edit_iframe_dialog.close();
    }
    
    function show(){
    	var key = ICSS.utils.getSelectRowData("id");
		if(key.indexOf(",")>-1||key==""){
			showMessage("请选择一条数据！");
			return ;
		}
		var url="<m:url value='/userGroup/toShowUserGroup.do'/>?key="+key;
		show_iframe_dialog = new biz.dialog({
		 	id:$('<div id="showwindow_iframe"></div>').html('<iframe id="iframeShow" name="iframeShow" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
			modal: true,
			width: 800,
			height: 235,
				title: "用户组别详情"
		});
  		show_iframe_dialog.open();
    }
    
    //关闭查看页面，供子页面调用
    function closeShow(){
    	show_iframe_dialog.close();
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
    }
    //重置查询表单
    function resetForm(formId){
		document.getElementById(formId).reset();
	}
    
    //删除
    function batchDelete(){
    	var ids = ICSS.utils.getSelectRowData("id");
    	if(ids==""){
    		showMessage("请至少选择一条数据！");
    		return ;
    	}else{
    		new biz.alert({type:"confirm",message:I18N.msg_del_confirm,title:I18N.promp,callback:function(result){
    			if(result){
    				$ .ajax({
        				url: "<m:url value='/userGroup/deleteUserGroup.do'/>?key="+ids,
        				cache:false,
        				success: function(data, textStatus, jqXHR){
        					doSearch();
    						showInfo("删除成功",3000);
        				}
        			});
    			}
    		}}) ;   
    	}
    }
    </script>
</head>
<body style="height:100%;">

	<div class="main  choice_box">
		<form id="queryForm"><!-- 查询区 表单 -->
	    </form>
<div class="listplace">
				<!--功能按钮begin-->
				<div class="list_btn_bg fl"><!--功能按钮 div-->
					<ul>
						<c:if test="${add}">
							<li><a title="<m:message code="button.add"/>" href="javascript:;"
								onclick="add();"> <i class="icon_bg icon_add"> </i> <span><m:message
											code="button.add" /></span>
							</a></li>
						</c:if>
						<c:if test="${edit}">
							<li><a title="<m:message code="button.edit"/>" href="javascript:;"
								onclick="edit();"><i class="icon_bg icon_edit"></i> <span><m:message
											code="button.edit" /></span> </a></li>
						</c:if>
						<c:if test="${delete}">
							<li><a title="<m:message code="button.delete"/>" href="javascript:;"
								onclick="batchDelete();"> <i class="icon_bg icon_del"></i> <span><m:message
											code="button.delete" /></span>
							</a></li>
						</c:if>
						<li><a title="<m:message code="button.view"/>" href="javascript:"
							onclick="show();"> <i class="icon_bg icon_ckxq"></i> <span><m:message
										code="button.view" /></span>
						</a></li>
						<c:if test="${manage}">
						<li><a title="<m:message code="button.module.moduleRes"/>" href="javascript:"
							onclick="moduleResMgt();"> <i class="back_icon resources_icon"></i> <span><m:message
										code="button.module.moduleRes" /></span>
						</a></li>
						</c:if>
					</ul>
				</div>
	
			<!--功能按钮end-->
				<div class="listtable_box">
					<!--此处放表格-->
				<table  id="remote_rowed" ></table>
				<div  id="remote_prowed"></div>		
				</div>
		</div>
	</div>
</body>
</html>
