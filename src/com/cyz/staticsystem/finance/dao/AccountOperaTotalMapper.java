package com.cyz.staticsystem.finance.dao;

import java.util.List;

import com.cyz.staticsystem.finance.model.AccountOperaTotal;
import com.cyz.staticsystem.finance.model.OperaDate;
/**
 * 描述：运营合计模块dao接口，提供数据库操作方法
 *
 * @author maggie
 * @version 1.0 2017-03-26
 */
public interface AccountOperaTotalMapper  {

	/**
	 * 新增运营合计方法
	 * @param accountOperaTotal AccountOperaTotal:实体类
	 */
	public int addSimpleTotalByOperaDate(OperaDate operaDate);
	public int addDeepTotalByOperaDate(OperaDate operaDate);
	/**
	 * 删除运营合计方法
	 * @param accountOperaTotal String:多个由“，”分割开的id字符串
	 */
	public int deleteSimpleTotalByOperaDate(OperaDate operaDate);
	public int deleteDeepTotalByOperaDate(OperaDate operaDate);
	/**
	 * 根据条件查找运营汇总列表方法
	 * @param operaDate OperaDate 实体对象（查询条件）
	 * @return: 实体对象的list
	 */
	public List<AccountOperaTotal> listDeepTotalByCondition(AccountOperaTotal accountOperaTotal);
	public List<AccountOperaTotal> listSimpleTotalByCondition(AccountOperaTotal accountOperaTotal);
	/**
	 * 修改运营合计方法
	 * @param accountOperaTotal AccountOperaTotal：实体对象
	 */	
	public void updateSimpleTotal(AccountOperaTotal accountOperaTotal);
	public void updateDeepTotal(AccountOperaTotal accountOperaTotal);
	



}