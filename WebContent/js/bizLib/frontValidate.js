ICSS.validate={
	validate_form:function(formId){
		var flag = true;
		$(":input",$("#"+formId)).each(function (){
			var checkFlag = true;
			if($(this).attr("required")&&checkFlag){
				checkFlag = ICSS.validate.is_empty($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("email")&&checkFlag){
				checkFlag = ICSS.validate.is_email($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("number")&&checkFlag){
				checkFlag = ICSS.validate.is_number($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("image")&&checkFlag){
				checkFlag = ICSS.validate.is_image($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("mobile")&&checkFlag){
				checkFlag = ICSS.validate.is_mobile($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("maxLength")&&checkFlag){
				checkFlag = ICSS.validate.max_length($(this)[0].id, $(this).attr("spanid"));
			}
			if($(this).attr("url")&&checkFlag){
				checkFlag = ICSS.validate.is_url($(this)[0].id, $(this).attr("spanid"));
			}
			flag = flag&&checkFlag;
		});
		
		$("textarea",$("#"+formId)).each(function (){
			var checkFlag = true;
			if($(this).attr("maxLength")&&checkFlag){
				checkFlag = ICSS.validate.max_length($(this)[0].id, $(this).attr("spanid"));
			}
			flag = flag&&checkFlag;
		});
		return flag;
	},
	is_empty:function(id,spanid,msg){
		$("#"+spanid).empty();
		var flag = true;
		if($("#"+id).val()==null||$("#"+id).val()==""||$("#"+id).val()==undefined){
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).addClass("input-error");
			}else if($("#"+id).attr("class")&&($("#"+id).attr("class").indexOf("pwd394")!=-1||$("#"+id).attr("class").indexOf("ipt650")!=-1)){
				$("#"+id).addClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
			this.showMessage(spanid, msg==undefined||msg==null||msg==''?"必填项":msg);
			flag = false;
		}else{
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).removeClass("input-error");
			}else if($("#"+id).attr("class")&&($("#"+id).attr("class").indexOf("pwd394")!=-1||$("#"+id).attr("class").indexOf("ipt650")!=-1)){
				$("#"+id).removeClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt b_gray");
			}
		}
		return flag;
	},
	confirm_password:function(id,equalTo,message){
		if($("#"+equalTo).val()!=$("#"+id).val()) {
			this.showMessage($("#"+id).attr("spanid"),message);
			return false;
		} else return true;
	},
	is_email:function(id,spanid){
		var reg = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if(!reg.test($("#"+id).val())){
			if($("#"+id).attr("class")&&$("#"+id).attr("class").indexOf("pwd394")!=-1){
				$("#"+id).addClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
			this.showMessage(spanid,"Email格式错误");
			return false;
		}else{
			if($($("#"+id).attr("class")&&$("#"+id).attr("class").indexOf("pwd394")!=-1)){
				$("#"+id).removeClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt b_gray");
			}
		}
		return true;
	},
	is_url:function(id,spanid){
		var reg = /^(((https?)|(ftp)):\/\/([\-\w]+\.)+\w{2,3}(\/[%\-\w]+(\.\w{2,})?)*(([\w\-\.\?\\\/+@&#;`~=%!]*)(\.\w{2,})?)*\/?)/i;
		if(!reg.test($("#"+id).val())){
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).addClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
			this.showMessage(spanid,"链接地址格式错误");
			return false;
	    }else{
	    	if($("#"+id).attr("errClass")=="append"){
				$("#"+id).removeClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
		}
		return true;
	},
	is_number:function(id,spanid){
		var reg = new RegExp("^[0-9]*$");
		if(!reg.test($("#"+id).val())){
			this.showMessage(spanid, "必须是数字");
			return false;
	    }
		return true;
	},
	is_mobile:function(id,spanid){
		var reg=/(\(\d{3,4}\)|\d{3,4}-|\s)?\d{7,14}/;
		if(!reg.test($("#"+id).val())){
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).addClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
			this.showMessage(spanid, "联系电话格式不对，请输入正确的格式");
			return false;
		}else{
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).removeClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt b_gray");
			}
			return true;
		}
	},
	is_image:function(id,spanid){
		var flag = true;
		if($("#"+id).val()==null||$("#"+id).val()==""||$("#"+id).val()==undefined) return false;
		var arr=$("#"+id).val().split('\\');
		var my=arr[arr.length-1];
		if(my.indexOf(".")!=-1){
			var fileType = my.split(".")[my.split(".").length-1];
			if(!(fileType=="jpg"||fileType=="png")){
				this.showMessage(spanid, msg==undefined||msg==null||msg==''?"图片格式错误":msg);
				flag = false;
			}
		}
		return flag;
	},
	max_length:function(id,spanid){
		var num=$("#"+id).attr("maxLength");
		if($("#"+id).val().length>num){
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).addClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt input-error");
			}
			this.showMessage(spanid, "允许输入的长度为0到"+num+"之间");
			return false;
		}else{
			if($("#"+id).attr("errClass")=="append"){
				$("#"+id).removeClass("input-error");
			}else{
				$("#"+id).attr("class","re-ipt b_gray");
			}
			return true;
		}
	},
	remote_validate:function(url,data,spanId,message){
		$("#"+spanId).empty();
		var flag = true;
		$.ajax({
			url:url,
			type:"post",
			cache : false,
			data:data,
			dataType: "json",
			async:false,
			success:function(data){
				flag = data;
			}
		});
		if(!flag){
			this.showMessage(spanId, message);
		}
		return flag;
	},
	showMessage:function(spanId,message){//提示信息显示
		$("#"+spanId).empty();
		var errorDiv= $("#errorDiv").clone(true);
		errorDiv[0].style.display="block";
		$(errorDiv[0].children[1]).empty();
		$(errorDiv[0].children[1]).append(message);
		$("#"+spanId).append(errorDiv);
	}
};

ICSS.code = {
	initCode:function(id,url){
		$("#"+id).attr("src",url);
	}
};
