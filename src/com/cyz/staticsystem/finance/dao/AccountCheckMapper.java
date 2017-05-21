package com.cyz.staticsystem.finance.dao;

import java.util.List;

import com.cyz.staticsystem.finance.model.AccountCheck;
import com.cyz.staticsystem.finance.model.AccountOperateIncome;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
/**
 * 描述：财务对账模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-02-23
 */
public interface AccountCheckMapper  {
	/**
	 * 修改财务对账方法
	 * @param accountCheck AccountCheck：实体对象
	 */	
	public void updateTotal(AccountCheck accountCheck);

	public List<AccountOperateIncome> listTotalAccountCheck(AccountOrderDetail accountOrderDetail);
	public List<AccountOperateIncome> listDetailAccountCheckByBoundMerchant(AccountOrderDetail accountOrderDetail);
	public List<AccountOperateIncome> listDetailAccountCheckByBoundCompany(AccountOrderDetail accountOrderDetail);

}