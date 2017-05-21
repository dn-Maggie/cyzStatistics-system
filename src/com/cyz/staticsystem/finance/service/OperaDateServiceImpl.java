package com.cyz.staticsystem.finance.service;
import javax.annotation.Resource;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.finance.dao.OperaDateMapper;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.AccountSpecialFood;
import com.cyz.staticsystem.finance.model.OperaDate;
import com.cyz.staticsystem.finance.service.OperaDateService;
 
/**
 * 描述：运营日明细模块service接口实现类，实现service接口方法
 *
 * @author maggie
 * @version 1.0 2017-03-28
 */
@Service("operaDateService")
public class OperaDateServiceImpl implements OperaDateService{
        @Resource
	private OperaDateMapper operaDateMapper;
	
 
	/**
	 * 新增运营日明细方法
	 * @param operaDate:实体类
	 */	
	public ResultMessage add(OperaDate operaDate){
		operaDateMapper.add(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public int addDeepOperaByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.addDeepOperaByOrderDetail(accountOrderDetail);		
	}
	public int addBasePriceByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.addBasePriceByOrderDetail(accountOrderDetail);
	}
	public int addSaleRateByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.addSaleRateByOrderDetail(accountOrderDetail);
	}
	public int addPlatformAccountByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.addPlatformAccountByOrderDetail(accountOrderDetail);
	}
	
	/**
	 * 根据主键查找运营日明细实体方法
	 * @param key String 实体主键
	 * @return OperaDate 实体对象
	 */
	public OperaDate getByPrimaryKey(String key){
		return operaDateMapper.getByPrimaryKey(key);
	}
	
	/**
	 * 删除运营日明细方法
	 * @param key String 多个由“，”分割开的id字符串
	 */
	public int deleteBasePriceByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.deleteBasePriceByOrderDetail(accountOrderDetail);
	}
	public int deleteDeepOperaByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.deleteDeepOperaByOrderDetail(accountOrderDetail);
	}
	public int deleteSaleRateByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.deleteSaleRateByOrderDetail(accountOrderDetail);
	}
	public int deletePlatformAccountByOrderDetail(AccountOrderDetail accountOrderDetail) {
		return operaDateMapper.deletePlatformAccountByOrderDetail(accountOrderDetail);
	}
	
	/**
	 * 根据条件查找运营日明细列表方法
	 * @param operaDate OperaDate 实体对象（查询条件）
	 * @return List<OperaDate> 实体对象的list
	 */
	public List<OperaDate> listBasePriceByCondition(OperaDate operaDate) {
		return operaDateMapper.listBasePriceByCondition(operaDate);
	}
	public List<OperaDate> listDeepOperaByCondition(OperaDate operaDate) {
		return operaDateMapper.listDeepOperaByCondition(operaDate);
	}
	public List<OperaDate> listSaleRateByCondition(OperaDate operaDate) {
		return operaDateMapper.listSaleRateByCondition(operaDate);
	}
	public List<OperaDate> listPlatformAccountByCondition(OperaDate operaDate) {
		return operaDateMapper.listPlatformAccountByCondition(operaDate);
	}
	@Override
	public List<AccountSpecialFood> listSpecialFood(AccountSpecialFood accountSpecialFood) {
		return operaDateMapper.listSpecialFood(accountSpecialFood);
	}
	/**
	 * 修改运营日明细方法
	 * @param operaDate OperaDate 实体对象
	 */	
	public ResultMessage updateBasePrice(OperaDate operaDate) {
		operaDateMapper.updateBasePrice(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public ResultMessage updateDeepOpera(OperaDate operaDate) {
		operaDateMapper.updateDeepOpera(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public ResultMessage updateSaleRate(OperaDate operaDate) {
		operaDateMapper.updateSaleRate(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public ResultMessage updatePlatformAccount(OperaDate operaDate) {
		operaDateMapper.updatePlatformAccount(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	
	
	/**
	 * 修改运营明细结算方法
	 */
	public ResultMessage updateDeepOperaSum(OperaDate operaDate) {
		operaDateMapper.updateDeepOperaSum(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public ResultMessage updateSaleRateSum(OperaDate operaDate) {
		operaDateMapper.updateSaleRateSum(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
	public ResultMessage updatePlatformAccountSum(OperaDate operaDate) {
		operaDateMapper.updatePlatformAccountSum(operaDate);
		return AjaxUtils.getSuccessMessage();
	}
}