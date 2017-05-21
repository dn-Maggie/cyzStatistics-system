GridColModelForMatter = {
	//订单状态
	isInvalid : function(cellvalue, options, cellObject) {
		if (cellvalue == "1")
			return "已取消";
		else return "正常";
	},
	// 配送方式
	distributionMode : function(cellvalue, options, cellObject) {
		if (cellvalue == "0000"||cellvalue == "CROWD")
			return "商家自配送";
		else if(cellvalue == "1001"||cellvalue == "CONTROLLED")
			return "平台专送";
		else return "其他方式";
	},
	// 店铺类型
	storeType : function(cellvalue, options, cellObject) {
		if (cellvalue == "1")
			return "夜宵";
		else
			return "正餐";
	},
	// 计划附件状态
	fjFlag : function(cellvalue, options, cellObject) {
		if (cellvalue == "0")
			return "无";
		else
			return "有";
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
		if (cellvalue == "1")
			return "否（模糊查询）";
		else
			return "是（精准匹配）";
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
		if (cellvalue == "1")
			return "平台活动";
		else
			return "店铺活动";
	},
	// 活动状态
	activityStatus : function(cellvalue, options, cellObject) {
		if (cellvalue == "1")
			return '<i value="0" class="state_icons icon_enabled"></i>正在进行';
		else
			return '<i value="1" class="state_icons icon_nochange"></i>暂未进行';
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