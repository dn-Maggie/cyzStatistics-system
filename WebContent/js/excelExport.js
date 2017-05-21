ExpExcel = {
	expExcel : function(formId, queryFormId) {
		var form = $(formId);
		var tableIdOrGridId = $("#tableIdOrGridId").val();
		var expTableType = $("#expTableType").val();
		if (expTableType == "grid") {
			ExpExcel.onSubmitbBefore(formId, tableIdOrGridId);
		}
		if (expTableType == "report") {
			var queryParams = $(queryFormId).getFormParams();
			ExpExcel.createOrSetQueryHidden(formId, queryParams);
		}
		form.submit();
	},
	createOrSetQueryHidden : function(formId, queryParams) {
		$.each(queryParams, function(idx, item) {
			var eid = formId + '_' + idx;
			var es = $(eid);
			if (es.length == 0) {
				$(ExpExcel.createHidden(eid.replace('#', ''), item.trim(), idx))
						.appendTo($(formId));
			} else {
				$(es).val(item.trim());
			}
		});
	},
	htmlEleToField : function(ele) {
		var v_title = $(ele).html();
		if ($.trim(v_title) === '') {
			v_title = null;
		}
		var v_field = null;
		var v_width = null;
		var v_rowspan = null;
		var v_colspan = null;
		if (typeof($(ele).attr('width')) != "undefined") {
			v_width = $(ele).attr('width');
		}
		if (typeof($(ele).attr('field')) != "undefined") {
			v_field = $(ele).attr('field');
		}
		if (typeof($(ele).attr('rowspan')) != "undefined") {
			v_rowspan = $(ele).attr('rowspan');
		}
		if (typeof($(ele).attr('colspan')) != "undefined") {
			v_colspan = $(ele).attr('colspan');
		}
		return {
			field : v_field,
			title : v_title,
			width : v_width,
			rowspan : v_rowspan,
			colspan : v_colspan
		};
	},
	getTableTotalFields : function(tableId) {
		var countRows = $(tableId).find(".count-row");// 得到合计行
		var trArray = new Array(); // 先声明一维
		var thArray; // 先声明一维
		$.each(countRows, function(i, n) {
					thArray = new Array();
					$.each($(n).children("td"), function() {
								thArray.push(ExpExcel.htmlEleToField(this));
							});
					trArray.push(thArray);
				});
		return trArray;
	},
	createHidden : function(name, value) {
		if (value) {
			value = 'value="' + value + '" />';
		} else {
			value = ' />';
		}
		var hidn = $('<input type="hidden"   name="' + name + '"  ' + value);
		return hidn;
	},
	getTableHeadFields : function(tableId) {
		var headRows = $(tableId).find(".HeadRow");// 得到里面的标题行集合
		var trArray = new Array(); // 先声明一维
		var thArray; // 先声明一维
		$.each(headRows, function(i, n) {
					thArray = new Array();
					$.each($(n).children("th"), function() {
								thArray.push(ExpExcel.htmlEleToField(this));
							});
					trArray.push(thArray);
				});
		return trArray;
	},
	htmlTableFieldsToFrom : function(formId, tableId) {
		var headFields = ExpExcel.getTableHeadFields(tableId);
		ExpExcel.fieldsToFrom(formId, headFields, "fieldlist");
		var totalFields = ExpExcel.getTableTotalFields(tableId);
		ExpExcel.fieldsToFrom(formId, totalFields, "totallist");
	},
	/**
	 * 把field变成表单元素加到表单里面
	 * 
	 * @param {}
	 *            formId
	 * @param {}
	 *            fields
	 */
	fieldsToFrom : function(formId, fields, paramName) {
		var k = 0, tmpj, clum;
		var form = $(formId);
		for (var i = 0; i < fields.length; i++) {
			clum = fields[i];// 单个列对象
			if (!clum.hidden | clum.hidden != true) { // 如果这列不是隐藏的
				if (clum.name != 'rn' && clum.name != 'subgrid'
						&& clum.name != 'cb' && clum.width != 25) {
					for (op in clum) {// 循环列对象里的所有属性
						if (op == 'name' || op == 'label' || op == 'width') {// 要取得的属性
							$(ExpExcel.createHidden((paramName + '[0][' + k
											+ '].' + op), clum[op]))
									.appendTo(form);
						}
					}
					k++;
				}
			}
		}
	},
	createWinHtml : function() {
		var htmlTmp = '<form id="expExcelForm"  method="post" action="">';
		htmlTmp += '<input type="hidden" id="startpage" name="startpage"/>';
		htmlTmp += '<input type="hidden" id="endpage" name="endpage"/>';
		htmlTmp += '<input type="hidden" id="pageSize" name="pageSize"/>';
		htmlTmp += '<input type="hidden" id="orderFields" name="orderFields"/>';
		htmlTmp += '<input type="hidden" id="order" name="order"/>';
		htmlTmp += '<input type="hidden" id="gridId" name="gridId"/>';
		htmlTmp += '<div style="height:100px;margin-left:44px; margin-top:16px;"><div style="height:32px; line-height:32px;"><input type="radio" checked="checked" name="expType" value="1" />导出当前页数据</div>';
		htmlTmp += '<div style="height:32px; line-height:32px;"><input type="radio" name="expType" value="2" />导出全部数据</div></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="export" class="add_save" value="导出" /></div>';
		htmlTmp += '</form>';
		return htmlTmp;
	},
	createImportStoreHtml : function() {
		var htmlTmp = '';
		htmlTmp += '<div style="height:20px;margin-left:44px; margin-top:16px;"></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="import" class="add_save" value="导入" onclick="$(\'#file\').click()"></div>';
		htmlTmp += '<form name="form" id="form" method="post"  enctype="multipart/form-data"><input type="file" id="file" name="file" style="display: none" onchange="ExpExcel.importData()"/></form>';
		return htmlTmp;
	},
	createImportWinHtml : function() {
		var htmlTmp = '';
		htmlTmp += '<div style="height:100px;margin-left:44px; margin-top:16px;">';
		htmlTmp += '<select class="search_select" id="platFormType"><option value="elm">饿了么</option><option value="meituan">美团</option><option value="baidu">百度</option></select></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="import" class="add_save" value="导入" onclick="$(\'#file\').click()"></div>';
		htmlTmp += '<form name="form" id="form" method="post"  enctype="multipart/form-data"><input type="file" id="file" name="file" style="display: none" onchange="ExpExcel.importData()"/></form>';
		return htmlTmp;
	},
	createDownloadStoreHtml : function() {
		var htmlTmp = '';
		htmlTmp += '<form name="downloadform" id="downloadform" method="GET"><div style="height:100px;margin-left:44px; margin-top:16px;">';
		htmlTmp += '<select class="search_select" id="platFormType" name="platFormType"><option value="store">店铺基本信息</option></select></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="download" class="add_save" value="下载" onclick="executeDownload()"></div></form>';
		return htmlTmp;
    },
	createDownloadWinHtml : function() {
		var htmlTmp = '';
		htmlTmp += '<form name="downloadform" id="downloadform" method="GET"><div style="height:100px;margin-left:44px; margin-top:16px;">';
		htmlTmp += '<select class="search_select" id="platFormType" name="platFormType"><option value="elm">饿了么</option><option value="meituan">美团</option><option value="baidu">百度</option></select></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="download" class="add_save" value="下载" onclick="executeDownload()"></div></form>';
		return htmlTmp;
    },
    createImportOperaWinHtml : function() {
		var htmlTmp = '';
		htmlTmp += '<div style="height:100px;margin-left:44px; margin-top:16px;">';
		htmlTmp += '<select class="search_select" id="platFormType"><option value="elm">饿了么</option><option value="meituan">美团</option><option value="baidu">百度</option></select></div>';
		htmlTmp += '<div style="float:left;margin-left:46px;"><input type="button" id="cancel" class="search_btn4" value="取消">';
		htmlTmp += '<input type="button" id="import" class="add_save" value="导入" onclick="$(\'#file\').click()"></div>';
		htmlTmp += '<form name="form" id="form" method="post"  enctype="multipart/form-data"><input type="file" id="file" name="file" style="display: none" onchange="ExpExcel.importOperaData()"/></form>';
		return htmlTmp;
	},
	// Grid导出
	exeExportByGrid : function(gridObj, expUrl, queryForm) {
		var formId = '#expExcelForm';
		var expExcelForm = $(formId);
		if (expExcelForm.attr("action") == expUrl) {
			expExcelForm.submit();
		} else {
			expExcelForm.attr("action", expUrl);
			var columns = gridObj.jqGrid('getGridParam', 'colModel');
			var queryPostDatas = Finance.getQueryCondition();
			$.each(queryPostDatas, function(k, v) {
				$(ExpExcel.createHidden(k, v)).appendTo(expExcelForm);
			});
			$("#gridId").val(queryForm);
			$('#orderFields').val(gridObj.jqGrid('getGridParam', 'sortname'));
			$('#order').val(gridObj.jqGrid('getGridParam', 'sortorder'));
			var page = gridObj.jqGrid('getGridParam', 'page');
			var pagesize = gridObj.jqGrid('getGridParam', 'rowNum');
			var expType = $('input[name=expType]:checked');
			var t = $(expType).val();
			$('#startpage').val(page);
			$('#endpage').val(page);
			$('#pageSize').val(pagesize);
			ExpExcel.fieldsToFrom(formId, columns, "fieldlist");
			expExcelForm.submit();
		}
	},
	showWin : function(tableIdOrGridId, expUrl, type, queryForm) {
		$("#excelExportDialogDiv").remove();
		var excelExportDialogDiv = $('<div id="excelExportDialogDiv">'
				+ ExpExcel.createWinHtml() + '</div>');
		$(document.body).append(excelExportDialogDiv);
		if (type == "grid") {
			excelExportDialogDiv.find('#export').bind("click", function() {
						ExpExcel.exeExportByGrid(tableIdOrGridId, expUrl,
								queryForm);
					});
		} else {

		}
		excelExportDialogDiv.find('#cancel').bind("click", function() {
			excelExportDialogDiv.dialog("close");
		});
		excelExportDialogDiv.dialog({
			height : 200,
			width : 320,
			autoOpen : false,
			modal : true,
			title : "导出选择"
		});
		excelExportDialogDiv.dialog("open");
	},
	importStore:function(){
		$("#excelExportDialogDiv").remove();
		var excelExportDialogDiv = $('<div id="excelExportDialogDiv">'
				+ ExpExcel.createImportStoreHtml() + '</div>');
		$(document.body).append(excelExportDialogDiv);
		excelExportDialogDiv.find('#cancel').bind("click", function() {
			excelExportDialogDiv.dialog("close");
		});
		excelExportDialogDiv.dialog({
			height : 200,
			width : 320,
			autoOpen : false,
			modal : true,
			title : "导入选择"
		});
		excelExportDialogDiv.dialog("open");
	},
	showImportWin : function() {
		$("#excelExportDialogDiv").remove();
		var excelExportDialogDiv = $('<div id="excelExportDialogDiv">'
				+ ExpExcel.createImportWinHtml() + '</div>');
		$(document.body).append(excelExportDialogDiv);
		excelExportDialogDiv.find('#cancel').bind("click", function() {
			excelExportDialogDiv.dialog("close");
		});
		excelExportDialogDiv.dialog({
			height : 250,
			width : 320,
			autoOpen : false,
			modal : true,
			title : "导入选择"
		});
		excelExportDialogDiv.dialog("open");
	},
	executeDownload : function(){
		var fid = $("#downloadform");
		fid.submit();
	},
	showDownloadWin : function() {
		$("#excelDownloadDialogDiv").remove();
		var excelDownloadDialogDiv = $('<div id="excelDownloadDialogDiv">'
				+ ExpExcel.createDownloadWinHtml() + '</div>');
		$(document.body).append(excelDownloadDialogDiv);
		excelDownloadDialogDiv.find('#cancel').bind("click", function() {
			excelDownloadDialogDiv.dialog("close");
		});
		excelDownloadDialogDiv.dialog({
      	height : 250,
			width : 320,
			autoOpen : false,
			modal : true,
      title : "选择下载模板"
		});
		excelDownloadDialogDiv.dialog("open");
	},
	showStoreDownloadWin : function() {
		$("#excelDownloadDialogDiv").remove();
		var excelDownloadDialogDiv = $('<div id="excelDownloadDialogDiv">'
				+ ExpExcel.createDownloadStoreHtml() + '</div>');
		$(document.body).append(excelDownloadDialogDiv);
		excelDownloadDialogDiv.find('#cancel').bind("click", function() {
			excelDownloadDialogDiv.dialog("close");
		});
		excelDownloadDialogDiv.dialog({
      	height : 250,
			width : 320,
			autoOpen : false,
			modal : true,
      title : "选择下载模板"
		});
		excelDownloadDialogDiv.dialog("open");
	},
	showImportOperaWin : function() {
		$("#excelExportDialogDiv").remove();
		var excelExportDialogDiv = $('<div id="excelExportDialogDiv">'
				+ ExpExcel.createImportOperaWinHtml() + '</div>');
		$(document.body).append(excelExportDialogDiv);
		excelExportDialogDiv.find('#cancel').bind("click", function() {
			excelExportDialogDiv.dialog("close");
		});
		excelExportDialogDiv.dialog({
			height : 250,
			width : 320,
			autoOpen : false,
			modal : true,
			title : "导入选择"
		});
		excelExportDialogDiv.dialog("open");
	},
	importData : function(){
		if($('input[type="file"]').val()!=""){
		var extend=$('input[type="file"]').val().substr($('input[type="file"]').val().lastIndexOf(".")+1);
		if("xls|xlsx".indexOf(extend)==-1){//在字符串中xls|xlsx寻找后缀xls或者xlsx，有的话返回下标，没有就返回-1
			 showInfo("选择的文件必须是EXCEL文件,请确认！",3000);
         }else{ 
        	 var plat = '';
        	 plat = $("#platFormType").val()?$("#platFormType").val():'';
        	 switch (plat) {
				case 'elm':
					 ExpExcel.ajaxFileUpload(baseUrl+"/accountOrderDetail/emlorderDetailImport.do");
					break;
				case 'meituan':
					 ExpExcel.ajaxFileUpload(baseUrl+"/accountOrderDetail/meituanorderDetailImport.do");
					break;
				case 'baidu':
					 ExpExcel.ajaxFileUpload(baseUrl+"/accountOrderDetail/baiduorderDetailImport.do");
					break;
				default:
					ExpExcel.ajaxFileUpload(baseUrl+"/store/storeImport.do");
					break;
				}
        	 }
	 }else{
		showInfo("请选择EXCEL文件！",3000);
	 	} 
	},
	ajaxFileUpload:function(Url){
		var options = {
				url : Url,
				type : "post",
				dataType:"text",
				success : function(response) {
					if(response){showMessage("导入数据成功","","",function(){
						gridObj.trigger('reloadGrid');
					});}
				},
				error : function(response) {
					showInfo(response.msg);},
			};
			$('#form').ajaxSubmit(options);
	}
}