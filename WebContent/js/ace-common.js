$(function() {
	//select多选 初始化方法
	$(".choose_select").chosen(); 
	//number控件
	$('.number').ace_spinner({value:0,min:0,max:999999,step:1, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
	$('.money').ace_spinner({value:0,min:0,step:1, max:999999,touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
	$('.rate').ace_spinner({value:0,min:0,max:100,step:1,icon_up:'icon-plus smaller-75', icon_down:'icon-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});
	//datePicker控件
	$('.date-picker').datepicker({autoclose:false}).next().on(ace.click_event, function(){
		$(this).prev().focus();
	});
	//timePicker控件
	$('.timepicker').timepicker({
		minuteStep: 1,
		showSeconds: true,
		showMeridian: false,
		defaultTime: false
	}).next().on(ace.click_event, function(){
		/*$(this).prev().focus();*/
	});
	//图片上传控件
	$('input[type="file"]').ace_file_input({
		no_file:'请选择...',
		btn_choose:'选择',
		btn_change:'更换',
		droppable:false,
		thumbnail:false,
	}).on('change',function(){
    	$(this).parent().parent().find('.realImage_submit').val("上传");
    	var extend=$(this).val().split('.').pop().toLowerCase();
			if("gif|png|jpg|jpeg|svg".indexOf(extend)==-1){
				 showInfo("请上传图片格式文件！",3000);
				 $(this).parent().parent().find('.realImage_submit').prop("disabled",true);
				 return;
	         }else{
	        	 $(this).parent().parent().find('.realImage_submit').prop("disabled",false);
	         }
	});
	$('.icon-remove').click(function(){
		$(this).parent().find('.realImage_submit').val("上传");
	});
})