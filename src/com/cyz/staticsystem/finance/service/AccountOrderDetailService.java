package com.cyz.staticsystem.finance.service;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.AccountSaleGoods;
import com.cyz.staticsystem.finance.model.OrderDetailQuery;
import com.cyz.staticsystem.finance.model.OrderDetailStatic;

/**
 * 描述：订单明细模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-03-02
 */
public interface AccountOrderDetailService  {

	/**
	 * 新增订单明细方法
	 * @param accountOrderDetail AccountOrderDetail:实体类
	 */
	public ResultMessage add(AccountOrderDetail accountOrderDetail);
	
	/**
	 * 删除订单明细方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public void deleteByKey(String key);
	
	/**
	 * 根据主键查找订单明细实体方法
	 * @param key String：实体主键
	 * @return accountOrderDetail AccountOrderDetail 实体对象
	 */
	public AccountOrderDetail getByPrimaryKey(String key);
	
	/**
	 * 根据条件查找订单明细列表方法
	 * @param accountOrderDetail AccountOrderDetail 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<AccountOrderDetail> listByCondition(AccountOrderDetail accountOrderDetail);
	
	/**
	 * 修改订单明细方法
	 * @param accountOrderDetail AccountOrderDetail 实体对象
	 */	
	public ResultMessage update(AccountOrderDetail accountOrderDetail);
	/**
	 * 批量插入订单详细方法
	 */
	public int addOrderDetail(List<AccountOrderDetail> orderDetailList);
	
	/**
	 * 根据订单计算出菜品数量表
	 */
	public List<AccountSaleGoods> listGoods(AccountOrderDetail accountOrderDetail);
	/**
	 * 修改自配送实际支付金额方法
	 * @param accountOrderDetail AccountOrderDetail 实体对象
	 */	
	public ResultMessage updateActualDistCharge(AccountOrderDetail accountOrderDetail);
	/**
	 * 统计订单数据（分店铺）*/
	public List<OrderDetailStatic> calcuOrderDetail(OrderDetailQuery odq);
	/**
	 *  统计商家排名*/
	public List<AccountOrderDetail> staticStoreOrder(AccountOrderDetail orders);
	/**
	 * 统计订单数据(空值情况)*/
	public List<OrderDetailStatic> calcuOrderDetailNull(OrderDetailQuery odq);
	/**
	 * 统计订单数据（全部）*/
	public List<OrderDetailStatic> calcuOrderAll(OrderDetailQuery odq);
}