package com.cyz.staticsystem.finance.service;

import java.util.List;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.finance.model.AccountOperaTotal;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.OperaDate;

/**
 * 描述：运营合计模块service接口，提供controller操作所需方法
 *
 * @author maggie
 * @version 1.0 2017-03-26
 */
public interface AccountOperaTotalService  {

	/**
	 * 新增运营合计方法
	 * @param accountOperaTotal AccountOperaTotal:实体类
	 */
	public int addSimpleTotalByOperaDate(OperaDate operaDate);
	public int addDeepTotalByOperaDate(OperaDate operaDate);
	/**
	 * 删除运营合计方法
	 * @param key:多个由“，”分割开的id字符串
	 */
	public int deleteSimpleTotalByOperaDate(OperaDate operaDate);
	public int deleteDeepTotalByOperaDate(OperaDate operaDate);

	/**
	 * 修改运营合计方法
	 * @param accountOperaTotal AccountOperaTotal 实体对象
	 */	
	public ResultMessage updateSimpleTotal(AccountOperaTotal accountOperaTotal);
	public ResultMessage updateDeepTotal(AccountOperaTotal accountOperaTotal);
	/**
	 * 根据条件查找运营合计列表方法
	 * @param accountOperaTotal AccountOperaTotal 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<AccountOperaTotal> listSimpleTotalByCondition(AccountOperaTotal accountOperaTotal);
	public List<AccountOperaTotal> listDeepTotalByCondition(AccountOperaTotal accountOperaTotal);
	
	
}