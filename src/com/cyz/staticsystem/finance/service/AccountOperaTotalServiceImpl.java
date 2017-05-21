package com.cyz.staticsystem.finance.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.finance.dao.AccountOperaTotalMapper;
import com.cyz.staticsystem.finance.model.AccountOperaTotal;
import com.cyz.staticsystem.finance.model.OperaDate;
import com.cyz.staticsystem.finance.service.AccountOperaTotalService;
 
/**
 * 描述：运营合计模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-03-26
 */
@Service("accountOperaTotalService")
public class AccountOperaTotalServiceImpl implements AccountOperaTotalService{
    @Resource
	private AccountOperaTotalMapper accountOperaTotalMapper;
 
	/**
	 * 新增运营合计方法
	 * @param accountOperaTotal:实体类
	 */	
	public int addSimpleTotalByOperaDate(OperaDate operaDate) {
		return accountOperaTotalMapper.addSimpleTotalByOperaDate(operaDate);
	}
	public int addDeepTotalByOperaDate(OperaDate operaDate) {
		return accountOperaTotalMapper.addDeepTotalByOperaDate(operaDate);
	}
	
	/**
	 * 删除运营合计方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public int deleteSimpleTotalByOperaDate(OperaDate operaDate) {
		return accountOperaTotalMapper.deleteSimpleTotalByOperaDate(operaDate);
	}
	public int deleteDeepTotalByOperaDate(OperaDate operaDate) {
		return accountOperaTotalMapper.deleteDeepTotalByOperaDate(operaDate);
	}
	/**
	 * 根据条件查找运营合计列表方法
	 * @param accountOperaTotal AccountOperaTotal 实体对象（查询条件）
	 * @return List<AccountOperaTotal> 实体对象的list
	 */
	public List<AccountOperaTotal> listDeepTotalByCondition(AccountOperaTotal accountOperaTotal){
		return accountOperaTotalMapper.listDeepTotalByCondition(accountOperaTotal);
	}
	public List<AccountOperaTotal> listSimpleTotalByCondition(AccountOperaTotal accountOperaTotal){
		return accountOperaTotalMapper.listSimpleTotalByCondition(accountOperaTotal);
	}
	/**
	 * 修改运营合计方法
	 * @param accountOperaTotal AccountOperaTotal 实体对象
	 */	
	public ResultMessage updateDeepTotal(AccountOperaTotal accountOperaTotal){
		accountOperaTotalMapper.updateDeepTotal(accountOperaTotal);
		return AjaxUtils.getSuccessMessage();
	}
	/**
	 * 修改运营合计方法
	 * @param accountOperaTotal AccountOperaTotal 实体对象
	 */	
	public ResultMessage updateSimpleTotal(AccountOperaTotal accountOperaTotal){
		accountOperaTotalMapper.updateSimpleTotal(accountOperaTotal);
		return AjaxUtils.getSuccessMessage();
	}
}