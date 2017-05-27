<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../../common/header.jsp"%>
<%@ include file="../../common/ace.jsp"%>
<script src="<%=request.getContextPath() %>/js/extend/finance.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/styles/extend/style.css" media="screen" type="text/css" />
<style>
.calcu.checked{
	color: #696969;
    border-color: #f59942;
    background-color: #fff;
    outline: 0;
    }
.readname:hover{
	background-color: #ddd!important;
	cursor: pointer;
	}
.icon_del{
	border:0;
	outline:0;
	color:#fff;
}
</style>
<script type="text/template" id="colModel">
<tr class="trItem">
	<td class="indexId">
		{{index}}
	</td>
	<td>列名</td>
	<td class="inputTd">
		<input  type="text" class="text colname" value="{{colNameValue}}"/>
		<input  type="hidden" class="text readname" value="{{colValueValue}}" readonly/>
		<input name="colindex" type="hidden" class="colindex" value="{{colIndex}}"/>
		<input name="isBasic" type="hidden" class="isBasic" value="{{isBasic}}"/>
		<input name="editValue" type="hidden" class="editable" value="{{editValue}}"/>
	</td>
	<td>计算公式</td>
	<td class="inputTd">
		<span class="input-icon">
			<input type="text" class="text calcu" value="{{colFormatValue}}"  {{editableFlag}}/>
			{{calcuFlag}}
		</span>
	</td>
	<td >隐藏该列</td>
	<td class="inputTd">
		<label>
			<input class="ace ace-switch ace-switch-5" type="checkbox" {{hideFlag}}/>
			<span class="lbl"></span>
		</label>
	</td>
	<td>
	<input type="button" onclick="delTr(this)" class="icon_bg icon_del" {{editableFlag}} />
	</td>
</tr>
</script>
<script type="text/template" id="calculateModel">
<div id="container">
	<div id="the-calculator">
		<div id="the-display">
			<form name="calculator">
				<span id="total">0</span>
			</form>
		</div>
		<div id="the-buttons">
			<div class="button-row clearfix">
				<button id="calc_clear" value="C/E" >C/E</button>
				<button id="calc_back" value="&larr;" >&larr;</button>
				<button id="calc_neg" value="-/+" >-/+</button>
				<button class="calc_op" value="/" >&divide;</button>
			</div>
			<div class="button-row clearfix">
				<button class="calc_int" value="7" >7</button>
				<button class="calc_int" value="8" >8</button>
				<button class="calc_int" value="9" >9</button>
				<button class="calc_op" value="*" >&times;</button>
			</div>
			<div class="button-row clearfix">
				<button class="calc_int" value="4" >4</button>
				<button class="calc_int" value="5" >5</button>
				<button class="calc_int" value="6" >6</button>
				<button class="calc_op" value="-" >-</button>
			</div>
			<div class="button-row clearfix">
				<button class="calc_int" value="1" >1</button>
				<button class="calc_int" value="2" >2</button>
				<button class="calc_int" value="3" >3</button>
				<button class="calc_op" value="+" >+</button>
			</div>
			<div class="button-row clearfix">
				<button id="calc_zero" class="calc_int" value="0" >0</button>
				<button id="calc_decimal" value="." >.</button>
				<button id="calc_eval" value="=" >确定</button>
			</div>
			<div id="extra-buttons" class="button-row">
				<button id="calc_denom" value="(" >(</button>
				<button id="calc_sqrt" value=")" >)</button>
				<button id="calc_square" value="?" >?</button>
				<button id="calc_powerof" class="calc_op" value=":" >:</button>
			</div>
		</div>
	</div>
	<div id="the-results">
		<ul id="results_list">
		</ul>		
	</div>
</div>
</script>

<!-- 配置基础项目 -->
<script type="text/template" id="calculateBasicModel">
	<li class="result" style="display: list-item;">
		<span class="use"><a class="calc_use" href="#" data-val="{{basicName}}" data-index="{{basicIndex}}">{{basicLabel}}</a></span>
	</li>
</script>
<script type="text/javascript">
//index排序
function orderIndex(){
	for(var i = 0;i<$('.trItem').size();i++){
		$('.indexId:eq('+i+')').html(i+1);
	}
}
function cellFormatter(value, options, rData){
		return accounting.formatMoney(value,"",2).replace(".00","").replace(",","");
}
//添加行
function addTr(){
	$('.trItem:last').after($("#colModel").html()
			   .replace(/{{index}}/g,Number($(".trItem:last").find('.indexId').html())+1)
			   .replace('{{colNameValue}}', "")
			   .replace('{{colIndex}}', "")
			   .replace('{{isBasic}}', "")
			   .replace('{{colValueValue}}', "") 
			   .replace('{{colFormatValue}}',"")
			   .replace('{{hideFlag}}',"checked")
			   .replace('{{editValue}}',"")
			   .replace('{{calcuFlag}}','<i class="icon-columns blue" onclick="calcu(this)" style="cursor:pointer"></i>')
			   )
	};
	
//删除行
function delTr(Object){
	if($(".trItem").size()>1)
	{$(Object).parents('.trItem').remove();
	orderIndex();}
	else return;
};
//打开计算器
function calculateCreate(){
	var $calculate = $('#calculateModel').html();
	$("#calcubox").append($calculate);
	var colModel = window.parent.getColModel();
	var calculateBasic = [];
	for(var i =0;i<colModel.length;i++){
		var trTpl = $("#calculateBasicModel").html();//获取模板
		if(colModel[i].isBasic && "|rn|cb|".indexOf("|"+colModel[i].name+"|")==-1){
			calculateBasic.push(trTpl
					   .replace('{{basicName}}',colModel[i].name)
					   .replace('{{basicIndex}}',colModel[i].index)
					   .replace('{{basicLabel}}', colModel[i].label)
					);
		}
	}
	$('#results_list').prepend(calculateBasic.join(''));
};
function calculateOpen(){
	$("#calcubox").css('display', 'block');
};
//打开计算器
function calcu(obj){
	$(".calcu").trigger("removeCheck");
	$(obj).prev().addClass('checked');
	calculateOpen();
	$('#total').text($(obj).prev().val());
}
//添加内容
function appendText(val){
	if($('#total').text()==0){
		$('#total').text(val);
	}else{
		$('#total').text($('#total').text()+val);
	}
}
//添加计算项
function appendColname(val){
	if($('#total').text()==0){
		$('#total').text(val);
	}else{
		$('#total').text($('#total').text()+val);
	}
}
//改变正负值
function negText(){
	if(isNaN($('#total').text())){
		$('#total').text("-("+$('#total').text()+")");
	}else{
		$('#total').text($('#total').text() * -1);
	}
};
$(function() {
	//画出页面模板
	drawHtml();
	//创建计算器
	calculateCreate();
	$(".calcu").bind('removeCheck',function(){
		$(this).removeClass('checked');
	});
	$('.ace-switch').on('change', function(){
		$(this).attr("checked",$(this).is(':checked')?true:false);
	});
	/*
	** Usage - 计算器操作
	*/
	//选择项
	$('.calc_use').on('click',function() {
		appendColname($(this).data('index'));
	});
	//加减乘除数字按钮
	$('.calc_op,#calc_denom,.calc_int, #calc_decimal,#calc_sqrt,#calc_square').on('click',function() {
		appendText($(this).val());
	});
	//确定按钮
	$('#calc_eval').on('click',function() {
		$(".calcu.checked").val($('#total').text());
		$('#total').text(0);
		$("#calcubox").css('display', 'none');
	});
	// 清除按钮
	$('#calc_clear').on('click',function() {
		$('#total').text(0);
	});
	// 改变正负按钮
	$('#calc_neg').on('click',function() {
		negText();
	});
	// 回退按钮
	$('#calc_back').on('click',function() {
		if ( $('#total').text() !== '' && $('#total').text() !== '0' ) {
			$('#total').text($('#total').text().substring(0, $('#total').text().length - 1) );
		  } else {
			  $('#total').text('0');
		 }
	});
	//绑定提交按钮click事件
	$("#submit").click(function() {
		var jsonArr = [];
		var params = {};
		params.storeName ="${storeName}";
		for(var i = 0;i<$(".trItem").size();i++){
				var jsonObj ={
					 label:$(".colname:eq("+i+")").val(),
				     name:$(".readname:eq("+i+")").val(),
				     index:$(".colindex:eq("+i+")").val(),
				     isBasic:$(".isBasic:eq("+i+")").val()=="true"?true:false,
				     hidden:$(".ace-switch:eq("+i+")").is(':checked'),
				     editable:$(".editable:eq("+i+")").val()=="true"?true:false,
			     }
				if(!$(".calcu:eq("+i+")").prop("disabled")){
					jsonObj.editFlag=true;
					jsonObj.calculate=$(".calcu:eq("+i+")").val();
					jsonObj.serial = i;
					jsonObj.formatter = cellFormatter; 
					if(jsonObj.calculate.length>0&&jsonObj.name!="orderSaleRate"){
		       			params[jsonObj.name] = jsonObj.calculate;
					}
				}
				if(jsonObj.name=="orderSaleRate"){
					var paramDatas = {};
	           		paramDatas["orderSaleRate"] = jsonObj.calculate;
	           		paramDatas.storeName ="${storeName}";
		           		$ .ajax({
		           			type: "post",
		    				url: baseUrl+"/operaDate/updateOperaDate.do?type=otherSum",
		    				data: paramDatas,
							cache:false,
		    				dataType:"json"
	    				});
					}
					jsonArr.push(jsonObj);
				}
			$ .ajax({
  				type: "post",
				url: baseUrl+"/operaDate/updateOperaDate.do?type=otherSum",
				data: params,
				cache:false,
				dataType:"json"
			});
		var $parent = window.parent;
		var tableId = $parent.$('.listtable_box').find('table.ui-jqgrid-btable').attr('id');
		localStorage.setItem(tableId+"Model",JSON.stringify(jsonArr));
		$parent.loadConfigGrid(tableId,jsonArr);
		$parent.closeConfig();
	});
});
//填充模板数据
function drawHtml(){
	var colModel = window.parent.getColModel();
	var htmlTemp = [];
	for(var i =0;i<colModel.length;i++){
		var trTpl = $("#colModel").html();//获取模板
		if("|rn|cb|".indexOf("|"+colModel[i].name+"|")==-1){
			htmlTemp.push(trTpl
					   .replace(/{{index}}/g,i-1)
					   .replace('{{colNameValue}}', colModel[i].label?colModel[i].label:"")//列名
					   .replace('{{colValueValue}}', colModel[i].name?colModel[i].name:"")//列名对应的javabean
					   .replace('{{colIndex}}', colModel[i].index?colModel[i].index:"")//数据库排序字段值
					   .replace('{{isBasic}}',colModel[i].isBasic?true:"")//是否为基数
					   .replace('{{colFormatValue}}',typeof(colModel[i].calculate)=='undefined'?'':colModel[i].calculate)//是否有公式
					   .replace('{{hideFlag}}', colModel[i].hidden?"checked":"")//是否隐藏
					   .replace('{{editValue}}',colModel[i].editable?true:"")
					   .replace('{{calcuFlag}}',colModel[i].editFlag?'<i class="icon-columns blue" onclick="calcu(this)" style="cursor:pointer"></i>':'')
					   .replace(/{{editableFlag}}/g, colModel[i].editFlag?"":"disabled")
					);
		}
	}
	$('#colModeltable').prepend(htmlTemp.join(''));
}
</script>
</head>
  
<body>
	<form id="configFormEdit" >
    <div class="ui-table ui-widget ui-corner-all ui-border" >
		<table class="table" id="colModeltable">
			<tr>
				<td class="inputTd" colspan="10" style="text-align:center;">
					<input id="submit" type="button" class="ti_bottom" value="保存"/>
					<input id="addItem" type="button" class="ti_bottom" value="新增" onclick="addTr()"/>
				</td>
			</tr>
		</table>
    </div>
	</form>
	<div id="calcubox" style="display:none"></div>
</body>
</html>
