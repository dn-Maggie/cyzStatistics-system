<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<head>
<base href="<%=basePath%>">

<%@ include file="../../common/header.jsp"%>
<script type="text/javascript">
	$(function() {
		//绑定提交按钮click事件
		$("#close_button").click(function() {
			window.parent.closeShow();
		});
	});
</script>
</head>
  
<body>
	<div class="ui-table ui-widget ui-corner-all ui-border">
		<table class="table forview">
			<tr>
				<td class="inputLabelTd">创建日期：</td>
				<td class="inputTd">${accountOrderDetail.createDate}</td>
				<td class="inputLabelTd">：</td>
				<td class="inputTd">${accountOrderDetail.storeId}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">店铺在饿了么平台唯一标识：</td>
				<td class="inputTd">${accountOrderDetail.storeElmId}</td>
				<td class="inputLabelTd">店铺在美团平台唯一标识：</td>
				<td class="inputTd">${accountOrderDetail.storeMtId}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">店铺在百度平台唯一标识：</td>
				<td class="inputTd">${accountOrderDetail.storeBdId}</td>
				<td class="inputLabelTd">店铺名：</td>
				<td class="inputTd">${accountOrderDetail.storeName}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">账单编号：</td>
				<td class="inputTd">${accountOrderDetail.checkNo}</td>
				<td class="inputLabelTd">订单类型：</td>
				<td class="inputTd">${accountOrderDetail.orderType}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">订单创建时间：</td>
				<td class="inputTd">${accountOrderDetail.orderTime}</td>
				<td class="inputLabelTd">订单完成时间：</td>
				<td class="inputTd">${accountOrderDetail.overTime}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">接单序号：</td>
				<td class="inputTd">${accountOrderDetail.orderIndex}</td>
				<td class="inputLabelTd">订单号：</td>
				<td class="inputTd">${accountOrderDetail.orderNo}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜价：</td>
				<td class="inputTd">${accountOrderDetail.orginPrice}</td>
				<td class="inputLabelTd">餐盒费：</td>
				<td class="inputTd">${accountOrderDetail.mealFee}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">原价：</td>
				<td class="inputTd">${accountOrderDetail.totalPrice}</td>
				<td class="inputLabelTd">产品销售金额：</td>
				<td class="inputTd">${accountOrderDetail.productSaleAmount}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">赠品补贴：</td>
				<td class="inputTd">${accountOrderDetail.giftAllowance}</td>
				<td class="inputLabelTd">商户承担活动补贴：</td>
				<td class="inputTd">${accountOrderDetail.merchantActivitiesSubsidies}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">商户承担代金券补贴：</td>
				<td class="inputTd">${accountOrderDetail.merchantSubsidyVouchers}</td>
				<td class="inputLabelTd">自配送实际支付金额：</td>
				<td class="inputTd">${accountOrderDetail.actualMerchantDistCharge}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">商户收取配送费：</td>
				<td class="inputTd">${accountOrderDetail.merchantDistCharge}</td>
				<td class="inputLabelTd">订单上收取配送费：</td>
				<td class="inputTd">${accountOrderDetail.orderDistCharge}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">平台收取配送费：</td>
				<td class="inputTd">${accountOrderDetail.platformDistCharge}</td>
				<td class="inputLabelTd">服务费费率：</td>
				<td class="inputTd">${accountOrderDetail.serviceRate}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">服务费：</td>
				<td class="inputTd">${accountOrderDetail.serviceCharge}</td>
				<td class="inputLabelTd">用户申请退单金额：</td>
				<td class="inputTd">${accountOrderDetail.refundAmount}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">结算金额：</td>
				<td class="inputTd">${accountOrderDetail.settlementAmount}</td>
				<td class="inputLabelTd">配送方式：</td>
				<td class="inputTd">${accountOrderDetail.distributionMode}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">备注：</td>
				<td class="inputTd">${accountOrderDetail.remark}</td>
				<td class="inputLabelTd">平台承担活动补贴：</td>
				<td class="inputTd">${accountOrderDetail.platformActivitiesSubsidies}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">平台承担代金券补贴：</td>
				<td class="inputTd">${accountOrderDetail.platformSubsidyVouchers}</td>
				<td class="inputLabelTd">平台类型：</td>
				<td class="inputTd">${accountOrderDetail.platformType}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">是否为无效单：</td>
				<td class="inputTd">${accountOrderDetail.isInvalid}</td>
				<td class="inputLabelTd">菜品折扣：</td>
				<td class="inputTd">${accountOrderDetail.activitiesSubsidyBymerchant}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">公司承担线上活动费：</td>
				<td class="inputTd">${accountOrderDetail.activitiesSubsidyBycompany}</td>
				<td class="inputLabelTd">折扣菜金额：</td>
				<td class="inputTd">${accountOrderDetail.foodDiscount}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">特价结算：</td>
				<td class="inputTd">${accountOrderDetail.specialOffer}</td>
				<td class="inputLabelTd">预定时间：</td>
				<td class="inputTd">${accountOrderDetail.bookedTime}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">客户名称：</td>
				<td class="inputTd">${accountOrderDetail.consigneeName}</td>
				<td class="inputLabelTd">客户手机号：</td>
				<td class="inputTd">${accountOrderDetail.consigneePhones}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">活动时间：</td>
				<td class="inputTd">${accountOrderDetail.activeTime}</td>
				<td class="inputLabelTd">活动优惠：</td>
				<td class="inputTd">${accountOrderDetail.activeTotal}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品名称：</td>
				<td class="inputTd">${accountOrderDetail.goodsName}</td>
				<td class="inputLabelTd">菜品数量：</td>
				<td class="inputTd">${accountOrderDetail.goodsQuality}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">菜品id：</td>
				<td class="inputTd">${accountOrderDetail.goodsId}</td>
				<td class="inputLabelTd">菜品价格：</td>
				<td class="inputTd">${accountOrderDetail.goodsPrice}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">结算比例：</td>
				<td class="inputTd">${accountOrderDetail.orderSaleRate}</td>
				<td class="inputLabelTd">送货地址：</td>
				<td class="inputTd">${accountOrderDetail.targetAddr}</td>
			</tr>
			<tr>
				<td class="inputLabelTd">原价菜金额：</td>
				<td class="inputTd">${accountOrderDetail.actualPrice}</td>
			<tr>
				<td class="inputTd" colspan="4" style="text-align:center;">
					<input class="ti_bottom"  type="button" id="close_button"  value="关闭"/>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>
