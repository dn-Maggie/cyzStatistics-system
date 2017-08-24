GridColModelForMatter = {
	//订单状态
	isInvalid : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return "已取消";
		} else {
			return "正常";
		}
	},
	//订单最终状态
	lastStatus : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		//mt
		case "1":return "用户已提交订单";
		case "2":return "信息已推送";
		case "3":return "商家已收到";
		case "4":return "商家已确认";
		case "6":return "已配送";
		case "8":return "已完成";
		case "9":return "已取消";

		case "1001":return "系统取消，超时未确认";
		case "1002":return "系统取消，在线支付订单30分钟未支付";
		case "1101":return "用户取消，在线支付中取消";
		case "1102":return "用户取消，商家确认前取消";
		case "1103":return "用户取消，用户退款取消";
		case "1201":return "客服取消，用户下错单";
		case "1202":return "客服取消，用户测试";
		case "1203":return "客服取消，重复订单";
		case "1204":return "客服取消，其他原因";
		case "1301":return "已取消，其他原因";

		case "apply":return "发起退款";
		case "agree":return "确认退款";
		case "reject":return "驳回退款";
		case "cancelRefund":return "用户取消退款申请";
		case "cancelRefundComplaint":return "取消退款申诉";


		//elm
		case "pending":return "未生效订单";
		case "unprocessed":return "未处理订单";
		case "refunding":return "退单处理中";
		case "valid":return "已处理的有效订单";
		case "invalid":return "无效订单";
		case "settled":return "已完成订单";


		default:
			return "";
		}
	},
	// 配送方式
	distributionMode : function(cellvalue, options, cellObject) {
		if (cellvalue == "0000") {
			return "商家自配送";
		} else if(cellvalue == "1001") {
			return "美团专送-加盟";
		}else if(cellvalue == "0002") {
			return "趣活";
		}else if(cellvalue == "0016") {
			return "达达";
		}else if(cellvalue == "0033") {
			return "E代送";
		}else if(cellvalue == "1002") {
			return "美团专送-自建";
		}else if(cellvalue == "1003") {
			return "美团配送-众包";
		}else if(cellvalue == "1004") {
			return "美团专送-城市代理";
		}else if(cellvalue == "2001") {
			return "角马";
		}else if(cellvalue == "2002") {
			return "快送";
		}else if(cellvalue == "3001") {
			return "美团专送－混合送";
		}else {
			return "其他方式";
		}
	},
	// 店铺类型
	storeType : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return "夜宵";
		} else {
			return "正餐";
		}
	},
	// 计划附件状态
	fjFlag : function(cellvalue, options, cellObject) {
		if (cellvalue == "0") {
			return "无";
		} else {
			return "有";
		}
	},
	// 平台类型
	platformType : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		case "bdwm":return "百度外卖";
		case "elm":return "饿了么";
		case "mt":return "美团";
		default:
			return "";
		}
	},
	// 是否分前缀
	fontAddressFlag : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return "否（模糊查询）";
		} else {
			return "是（精准匹配）";
		}
	},
	// 订单类型状态
	orderType : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		case "NORMAL":return "普通单";
		case "BOOKING":return "预定单";
		default:
			return "";
		}
	},
	// 是否状态
	yesno : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		case 1:return "<i value='3' class='state_icons icon_nochange'>";
		case 0:return "<i value='0' class='state_icons icon_enabled'>";
		default:
			return "<i value='0' class='state_icons icon_nochange'>";
		}
	},
	// 产品状态
	productStatus : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		case "1":return "<i value='0' class='state_icons icon_enabled'></i>正常销售";
		case "2":return "<i value='2' class='state_icons icon_nochange'></i>库存告罄";
		case "3":return "<i value='3' class='state_icons icon_noaudit'></i>存货短缺";
		default:
			return "";
		}
	},
	// 活动类型
	activityType : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return "平台活动";
		} else {
			return "店铺活动";
		}
	},
	// 活动状态
	activityStatus : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return '<i value="0" class="state_icons icon_enabled"></i>正在进行';
		} else {
			return '<i value="1" class="state_icons icon_nochange"></i>暂未进行';
		}
	},
	// 结算方式
	settlementMethod : function(cellvalue, options, cellObject) {
		switch (cellvalue) {
		case "1":return "现金结算";
		case "2":return "转帐结算";
		case "3":return "支票";
		case "4":return "信用卡";
		case "5":return "银行汇票";
		case "6":return "商业汇票";
		default:
			return "";
		}
	},
	// 主计划审核状态
	groupCkStatus : function(cellvalue, options, cellObject) {
		if (cellvalue == "0") {
			return '<i value="0" class="state_icons icon_noaudit"></i>待审核';
		} else if (cellvalue == "1") {
			return '<i value="1" class="state_icons icon_audit1"></i>审核通过';
		} else if (cellvalue == "2") {
			return '<i value="2" class="state_icons icon_shwtg"></i>审核未通过';
		}

	},
	groupPhStatus : function(cellvalue, options, cellObject) {
		if (cellvalue == "0") {
			return '<i value="0" class="state_icons icon_noaudit"></i>待处理';
		} else if (cellvalue == "1") {
			return '<i value="1" class="state_icons icon_audit1"></i>申购成功';
		} else if (cellvalue == "2") {
			return '<i value="2" class="state_icons icon_shwtg"></i>申购失败';
		}

	},
	dutySort : function(cellvalue, options, cellObject) {
		if (cellvalue == "1") {
			return '集团级别';
		} else if (cellvalue == "2") {
			return '省级别';
		} else if (cellvalue == "3") {
			return '分公司级别';
		}
	},
	// （1启用，0停用）
	enableStates : function(cellvalue, options, cellObject) {
		if (cellvalue == "0") {
			return '<i value="0" class="state_icons icon_nochange"></i>停用';//
		} else {
			return '<i value="1" class="state_icons icon_enabled"></i>启用';//
		}
	},
	rate : function(cellvalue, options, cellObject) {
		cellvalue = parseFloat(cellvalue)||0;
		if (cellvalue < 0 ) {
			return '<i style="float:right;font-weight:bold;padding-right:10px;color:green">'+cellvalue+'%</i>';
		} else{
			return '<i style="float:right;font-weight:bold;padding-right:10px;color:red">+'+cellvalue+'%</i>';
		}
	},
	rate_nc : function(cellvalue, options, cellObject) {
		cellvalue = parseFloat(cellvalue)||0;
		return '<i style="float:right;font-weight:bold;padding-right:10px">'+cellvalue+'%</i>';
	},
	price : function(cellvalue, options, cellObject) {
		cellvalue = parseFloat(cellvalue)||0;
		cellvalue = cellvalue<10000?cellvalue:(cellvalue*0.0001)+"万";
		if (cellvalue < 0 ) {
			return '<i style="float:right;font-weight:bold;padding-right:10px;color:green">'+cellvalue+'</i>';
		} else{
			return '<i style="float:right;font-weight:bold;padding-right:10px;color:red">'+cellvalue+'</i>';
		}
	},
	price_nc : function(cellvalue, options, cellObject) {
		cellvalue = parseFloat(cellvalue)||0;
		cellvalue = cellvalue<10000?cellvalue:(cellvalue*0.0001)+"万";
		return '<i style="float:right;font-weight:bold;padding-right:10px">'+cellvalue+'</i>';
	},
	finance_type : function(cellvalue, options, cellObject) {
		if(cellvalue=="1"){
			return '借[收入]';
		}else{
			return '贷[支出]';
		}
	}
};