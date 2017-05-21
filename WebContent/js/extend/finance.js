Finance = {
	 changeTabMenu : function(){
		$(".tableTab").on('click',function(){
			$(".tableTab").trigger("removeCheck");
			$(this).addClass('checked');
			$(".listtable_box").trigger("removeAll");
			$(".listtable_box").html('<table  id="'+$(this).data("id")+'" ></table><div id='+$(this).data("id")+'prowed></div>');
			initGrid($(this).data("id"));
		})
		$(".tableTab").bind('removeCheck',function(){
			$(this).removeClass('checked');
		});
		$(".listtable_box").bind('removeAll',function(){
			$(this).html("");
		});
	},
	//获取表头	
	getColModel: function (){
    	var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id')
    	var columnNames = $("#"+tableId).jqGrid('getGridParam','colModel');
    	return columnNames;
    },
    //配置表头
    configTitle: function (tableName,tableId){
    	var tableId = $('.listtable_box').find('table.ui-jqgrid-btable').attr('id');
    	var tableName = $('.tableTab.checked').find('span').text();
    	var storeName = $('#storeId').val();
    	storeName==""?showMessage("请选择一个店铺", "提示", 2000):Finance.configGrid(tableName,tableId,storeName);
    },
    getQueryCondition:function(){
        var obj = {};
 		jQuery.each($("#queryForm").serializeArray(),function(i,o){
         	if(o.value){
         		obj[o.name] = o.value;
         	}
         });
 		return obj;
     },
    createGrid :function(ways,localStorageModel,gridCompleteCount,editCell,editURL){ 
    	return new biz.grid({
	        id:"#"+ways,
	        url: eval(ways+"Model.url"),
	       	sortname:"create_date",
	       	sortorder:"desc",
	       	rownumbers:false,
	       	frozen:true,
	       	shrinkToFit: false,
	       	footerrow:gridCompleteCount,
	       	cellEdit:editCell,
           	afterSaveCell : function(rowid,name,val,iRow,iCol) {
           		if(editCell){
           			var paramDatas = {};
	           		paramDatas[name] = val;
	           		paramDatas.id = rowid;
	           	//	paramDatas.storeId = rowid.substr(19).replace(/elm$|bdwm$|mt$/,'');
	           		$ .ajax({
	           			type: "post",
	    				url: editURL,
	    				data: paramDatas,
						cache:false,
	    				dataType:"json"
	    			});
           		}
          	},
	       	pager: "#"+ways+"prowed",
	        colModel:localStorageModel?localStorageModel:eval(ways+"Model.colModel"),
			serializeGridData:function(postData){//添加查询条件值
				var obj = Finance.getQueryCondition();
				$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
				return obj;
			},
		 	datatype: "json",/*数据类型，设置为json数据，默认为json*/
	        emptyrecords: "无记录可显示",
	        rowList:[10,15,50,100],//每页显示记录数
			rowNum:15,//默认显示15条
			gridComplete:function(){//表格加载执行  
				//$(this).closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'hidden' });
			 	if(gridCompleteCount){
			 		 $(".ui-jqgrid-sdiv").show();
					 	var footerCell = $(this).footerData();
					 	var footerObj = {};
					 	for(var i in footerCell){
					 		if(!/rn$|cb$|Time$|Date$|Name$|Type$|remark$|Mode$|No$|Rate$|id$/.test(i)){
					 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
					 		}
					 		if(/Num$/.test(i)){
					 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
					 		}
					 	}
					 	footerObj['raw'] = true;
					 	footerObj['cb'] = "合";
				    	$(this).footerData("set",footerObj); //将合计值显示出来
			 	}
			}
    	}).setFrozenColumns();
    },
    loadConfigGrid :function(ways,colModel,gridCompleteCount,editCell,editURL){ 
    	return new biz.grid({
	        id:"#"+ways,
	        url: eval(ways+"Model.url"),
	       	sortname:"create_date",
	       	sortorder:"desc",
	       	rownumbers:false,
	       	footerrow:gridCompleteCount,
	       	cellEdit:editCell,
           	afterSaveCell : function(rowid,name,val,iRow,iCol) {
           		if(editCell){
           			var paramDatas = {};
	           		paramDatas[name] = val;
	           		paramDatas.id = rowid;
	           		$ .ajax({
	           			type: "post",
	    				url: editURL,
	    				data: paramDatas,
						cache:false,
	    				dataType:"json"
	    			});
           		}
          	},
	       	pager: '#'+ways+'prowed',
	        colModel:colModel,
	        serializeGridData:function(postData){//添加查询条件值
				var obj = Finance.getQueryCondition();
				$ .extend(true,obj,postData);//合并查询条件值与grid的默认传递参数
				return obj;
			},
		 	datatype: "json",/*数据类型，设置为json数据，默认为json*/
	        emptyrecords: "无记录可显示",
	        rowList:[10,15,50,100],//每页显示记录数
			rowNum:15,//默认显示15条
			gridComplete:function(){//表格加载执行  
			    $(this).closest(".ui-jqgrid-bdiv").css({ 'overflow-x' : 'hidden' });
			    if(gridCompleteCount){
				 	$(".ui-jqgrid-sdiv").show();
				 	var footerCell = $(this).footerData();
				 	var footerObj = {};
				 	for(var i in footerCell){
				 		if(!/rn$|cb$|Time$|Date$|Name$|Type$|remark$|Mode$|No$|Rate$|id$/.test(i)){
				 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
				 		}
				 		if(/Num$/.test(i)){
				 			footerObj[i]=$(this).getCol(i,false,"sum")?$(this).getCol(i,false,"sum").toFixed(2):"0";
				 		}
				 	}
				 	footerObj['raw'] = true;
				 	footerObj['cb'] = "合";
			    	$(this).footerData("set",footerObj); //将合计值显示出来
			    }
			}
      	});
    },
    configGrid:function(tableName,tableId,storeName){
    	var url=baseUrl+"/config/toConfigGridTitle.do?storeName="+storeName;
		config_iframe_dialog = new biz.dialog({
			id:$('<div id="addwindow_iframe" ></div>').html('<iframe id="iframeAdd"  class="'+tableId+'" data-id="'+tableId+'" name="iframeAdd" src="'+url+'" width="100%" frameborder="no" border="0" height="97%"></iframe>'),  
			modal: true,
			width: $(window).width()*0.9,
			height: 600,
			title: tableName+"表头配置"
		});
		config_iframe_dialog.open();
  	},
  	formatAccountting:function(cellValue,options,rowObject){
  		return accounting.formatMoney(cellValue,"",2).replace(".00","").replace(",","");
  	}
}