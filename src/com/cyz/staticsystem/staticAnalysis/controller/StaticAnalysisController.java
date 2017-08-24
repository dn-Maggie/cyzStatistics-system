package com.cyz.staticsystem.staticAnalysis.controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.cyz.staticsystem.basic.model.Category;
import com.cyz.staticsystem.basic.service.CategoryService;
import com.cyz.staticsystem.common.bean.ResultMessage;
import com.cyz.staticsystem.common.excel.ImportExcelUtil;
import com.cyz.staticsystem.common.page.Page;
import com.cyz.staticsystem.common.util.AjaxUtils;
import com.cyz.staticsystem.common.util.DateUtil;
import com.cyz.staticsystem.common.util.StringUtil;
import com.cyz.staticsystem.common.util.Utils;
import com.cyz.staticsystem.finance.model.AccountOrderDetail;
import com.cyz.staticsystem.finance.model.AccountSaleGoods;
import com.cyz.staticsystem.finance.service.AccountOrderDetailService;
import com.cyz.staticsystem.staticAnalysis.model.BidStaticAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.DemandAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.StoreActiveAnalysis;
import com.cyz.staticsystem.staticAnalysis.model.mtDate.MtDateBase;
import com.cyz.staticsystem.staticAnalysis.model.mtDate.MtDetail;
import com.cyz.staticsystem.staticAnalysis.model.mtDate.MtExtras;
import com.cyz.staticsystem.staticAnalysis.model.mtDate.MtPoiReceiveDetail;
import com.cyz.staticsystem.staticAnalysis.service.AnalysisService;
import com.cyz.staticsystem.store.model.Store;
import com.cyz.staticsystem.store.service.StoreService;

import net.sf.json.JSONObject;



/**
 * 描述：数据分析模块controller类，负责数据分析页面分发与方法跳转
 * 
 * @author maggie
 * @version 1.0 2017-02-10
 */
 
@Controller
@RequestMapping("staticAnalysis")
public class StaticAnalysisController{
	@Resource
	private AnalysisService analysisService;
	@Resource
	private StoreService storeService;
	@Resource
	private CategoryService categoryService;
	@Resource 
	private AccountOrderDetailService accountOrderDetailService;
 	/**
 	* 进入竞价分析页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toBidAnalysis")
	public ModelAndView toBidAnalysis(){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/staticAnalysis/bidAnalysis");
		return mv;
	}
 	/**
	 * 竞价分析
	 * @return ModelAndView
	 */
	@RequestMapping("/bidAnalysis")
	public void bidAnalysis(BidStaticAnalysis bidStaticAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		bidStaticAnalysis.setPage(page);	
		List<BidStaticAnalysis> list = analysisService.bidStaticAnalysis(bidStaticAnalysis);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 进入活动数据分析页面
	 * @return ModelAndView
	 */
	@RequestMapping("/toStoreActivity")
	public ModelAndView toStoreActivity(HttpServletRequest request,HttpServletResponse response){
		 ModelAndView mv = new ModelAndView("WEB-INF/jsp/staticAnalysis/storeActivity");
		 Store store = new Store();
	 		store.setIsDelete(0);
	 		if(!Utils.isSuperAdmin(request)){
	 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
			}
	 	 mv.addObject("store",storeService.listByCondition(store));
	 	 mv.addObject("category",categoryService.listByCondition(new Category()));
		 mv.addObject("tradingArea", storeService.getBussinessArea());
		 return mv;
	}
	/**
	 * 活动数据分析
	 * @return ModelAndView
	 */
	@RequestMapping("/listStoreActivity")
	public void listStoreActivity(StoreActiveAnalysis storeActiveAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		storeActiveAnalysis.setPage(page);	
		if(storeActiveAnalysis.getStoreId()!=""&&storeActiveAnalysis.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(storeActiveAnalysis.getStoreId());
			storeActiveAnalysis.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			storeActiveAnalysis.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			storeActiveAnalysis.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<StoreActiveAnalysis> list = analysisService.storeActiveAnalysis(storeActiveAnalysis);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	/**
	 * 活动数据更新
	 * @return ModelAndView
	 */
	@RequestMapping("/updateStoreActivity")
	public void updateStoreActiveAnalysis(StoreActiveAnalysis storeActiveAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		ResultMessage rs = new ResultMessage();
		rs = analysisService.updateStoreActiveAnalysis(storeActiveAnalysis);
		AjaxUtils.sendAjaxForObjectStr(response,rs);
	}
	
	
	
	/**
 	* 进入精准客户需求分析页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toDemandAnalysis")
	public ModelAndView toDemandAnalysis(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/staticAnalysis/demandAnalysis");
		Store store = new Store();
 		store.setIsDelete(0);
 		if(!Utils.isSuperAdmin(request)){
 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
		}
 		mv.addObject("store",storeService.listByCondition(store));
 		mv.addObject("category",categoryService.listByCondition(new Category()));
		mv.addObject("tradingArea", storeService.getBussinessArea());
		return mv;
	}
 	/**
	 * 精准客户需求分析
	 * @return ModelAndView
	 */
	@RequestMapping("/demandAnalysis")
	public void demandAnalysis(DemandAnalysis demandAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		demandAnalysis.setPage(page);	
		if(demandAnalysis.getStoreId()!=""&&demandAnalysis.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(demandAnalysis.getStoreId());
			demandAnalysis.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			demandAnalysis.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			demandAnalysis.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		List<DemandAnalysis> list = analysisService.demandAnalysis(demandAnalysis);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	/**
	 * 精准客户需求分析
	 * @return ModelAndView
	 */
	@RequestMapping("/demandNumAnalysis")
	public void demandNumAnalysis(DemandAnalysis demandAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		demandAnalysis.setPage(page);	
		if(demandAnalysis.getStoreId()!=""&&demandAnalysis.getStoreId()!=null){
			Store s = storeService.getByPrimaryKey(demandAnalysis.getStoreId());
			demandAnalysis.setStoreELMId(StringUtils.defaultIfEmpty(
					s.getElmId(), "0"));
			demandAnalysis.setStoreMTId(StringUtils.defaultIfEmpty(
					s.getMeituanId(), "0"));
			demandAnalysis.setStoreBDId(StringUtils.defaultIfEmpty(
					s.getBaiduId(), "0"));
		}
		DemandAnalysis da = analysisService.demandNumAnalysis(demandAnalysis);
		AjaxUtils.sendAjaxForObjectStr(response,da);
	}
	
	
	/**
 	* 进入商户产品销售统计页面
 	* @return ModelAndView 返回到新增页面
 	*/
 	@RequestMapping("/toProductSale")
	public ModelAndView toProductSale(HttpServletRequest request){
		ModelAndView mv = new ModelAndView("WEB-INF/jsp/staticAnalysis/productSale");
		Store store = new Store();
 		store.setIsDelete(0);
 		if(!Utils.isSuperAdmin(request)){
 			store.setOwnerUserId(Utils.getLoginUserInfoId(request));
		}
 		mv.addObject("store",storeService.listByCondition(store));
		return mv;
	}
 	/**
	 * 商户产品销售统计页面
	 * @return ModelAndView
	 */
	@RequestMapping("/productSale")
	public void productSale(DemandAnalysis demandAnalysis,HttpServletRequest request,HttpServletResponse response, Page page){
		demandAnalysis.setPage(page);	
		List<DemandAnalysis> list = analysisService.demandAnalysis(demandAnalysis);
		AjaxUtils.sendAjaxForPage(request, response, page, list);
	}
	
	 /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
 	@RequestMapping("/bidimport")
	public void bidimport(HttpServletRequest request,HttpServletResponse response
		)throws Exception {  	
 		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
 		InputStream in =null;  
        List<List<Object>> listob = null;  
        ArrayList<BidStaticAnalysis> bidlist = new ArrayList<BidStaticAnalysis>();
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        for (int i = 1; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            BidStaticAnalysis bidAnalysis = new BidStaticAnalysis();  
            try{
            	bidAnalysis.setId(Utils.generateUniqueID());
            	bidAnalysis.setStoreName(StringUtil.valueOf(lo.get(0)));
            	bidAnalysis.setStoreArea(StringUtil.valueOf(lo.get(1)));
            	bidAnalysis.setBidTime(StringUtil.valueOf(lo.get(2)));
            	bidAnalysis.setBidCycle(StringUtil.valueOf(lo.get(3)));
            	bidAnalysis.setBidTotalAmountInWeek(StringUtil.valueOf(lo.get(4)));
            	bidAnalysis.setAverageClickCost(StringUtil.valueOf(lo.get(5)));
            	bidAnalysis.setBidActivityIntensity(StringUtil.valueOf(lo.get(6)));
            	bidAnalysis.setExposureIncrementPercent(StringUtil.valueOf(lo.get(7)));
            	bidAnalysis.setEnterRateIncrementPercent(StringUtil.valueOf(lo.get(8)));
            	bidAnalysis.setTradeAmountIncrementPercent(StringUtil.valueOf(lo.get(10)));
            	bidAnalysis.setRankBeforeBid(StringUtil.valueOf(lo.get(11)));
            	bidAnalysis.setRankAfterBid(StringUtil.valueOf(lo.get(12)));
            	bidAnalysis.setContributionInBid(StringUtil.valueOf(lo.get(13)));
            	bidlist.add(bidAnalysis);
            }catch(Exception e){
            	e.printStackTrace();
            }
        }  
        analysisService.addbidAnalysis(bidlist);//批量插入，传入bidAnalysis实体集合
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print("文件导入成功！");  
        out.flush();  
        out.close();  
	}

 	
	 /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
 	@RequestMapping("/demandimport")
	public void demandimport(HttpServletRequest request,HttpServletResponse response
		)throws Exception {  	
 		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
 		InputStream in =null;  
        List<List<Object>> listob = null;  
        ArrayList<DemandAnalysis> demandlist = new ArrayList<DemandAnalysis>();
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        for (int i = 1; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            DemandAnalysis demandAnalysis = new DemandAnalysis();  
            try{
            	demandAnalysis.setId(Utils.generateUniqueID());
            	demandAnalysis.setCustomName(StringUtil.valueOf(lo.get(0)));
            	demandAnalysis.setCustomOrdAddr(StringUtil.valueOf(lo.get(1)));
            	demandAnalysis.setCustomTel(StringUtil.valueOf(lo.get(2)));
            	demandAnalysis.setMostBrowseMerchantName(StringUtil.valueOf(lo.get(3)));
            	demandAnalysis.setMostBrowseMerchantType(StringUtil.valueOf(lo.get(4)));
            	demandAnalysis.setAverageCost(StringUtil.valueOf(lo.get(5)));
            	demandAnalysis.setFavoriteDishesName(StringUtil.valueOf(lo.get(6)));
            	demandAnalysis.setFavoriteDishesCost(StringUtil.valueOf(lo.get(7)));
            	demandlist.add(demandAnalysis);
            }catch(Exception e){
            	e.printStackTrace();
            }
        }  
        analysisService.adddemanAnalysis(demandlist);//批量插入，传入bidAnalysis实体集合
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print("文件导入成功！");  
        out.flush();  
        out.close();  
	}
 	
 	 /**
     * 读取Excel的内容，第一维数组存储的是一行中格列的值，二维数组存储的是多少个行
     * @param file 读取数据的源Excel
     * @param ignoreRows 读取数据忽略的行数，比喻行头不需要读入 忽略的行数为1
     * @return 读出的Excel中数据的内容
     * @throws FileNotFoundException
     * @throws IOException
     */
 	@RequestMapping("/sactiveimport")
	public void sactiveimport(HttpServletRequest request,HttpServletResponse response
		)throws Exception {  	
 		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
 		InputStream in =null;  
        List<List<Object>> listob = null;  
        ArrayList<StoreActiveAnalysis> activelist = new ArrayList<StoreActiveAnalysis>();
        MultipartFile file = multipartRequest.getFile("file");  
        if(file.isEmpty()){  
            throw new Exception("文件不存在！");  
        }  
        in = file.getInputStream();  
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        for (int i = 1; i < listob.size(); i++) {  
            List<Object> lo = listob.get(i);  
            StoreActiveAnalysis storeActiveAnalysis = new StoreActiveAnalysis();  
            try{
            	storeActiveAnalysis.setId(Utils.generateUniqueID());
            	storeActiveAnalysis.setStoreName(StringUtil.valueOf(lo.get(0)));
            	storeActiveAnalysis.setStoreArea(StringUtil.valueOf(lo.get(1)));
            	storeActiveAnalysis.setActivityName(StringUtil.valueOf(lo.get(2)));
            	storeActiveAnalysis.setPlatformAllowance(StringUtil.valueOf(lo.get(3)));
            	storeActiveAnalysis.setActivityType(StringUtil.valueOf(lo.get(4)));
            	storeActiveAnalysis.setActivityIntensity(StringUtil.valueOf(lo.get(5)));
            	storeActiveAnalysis.setActivityCycle(StringUtil.valueOf(lo.get(6)));
            	storeActiveAnalysis.setActivityTotalCost(StringUtil.valueOf(lo.get(7)));
            	storeActiveAnalysis.setActivityTotalProfit(StringUtil.valueOf(lo.get(8)));
            	storeActiveAnalysis.setProfitPercent(StringUtil.valueOf(lo.get(9)));
            	storeActiveAnalysis.setEnterRateInActivity(StringUtil.valueOf(lo.get(10)));
            	storeActiveAnalysis.setConversionRateInActivity(StringUtil.valueOf(lo.get(11)));
            	storeActiveAnalysis.setTradeAmountIncrementPercent(StringUtil.valueOf(lo.get(12)));
            	storeActiveAnalysis.setOrderAmountIncrementPercent(StringUtil.valueOf(lo.get(13)));
            	activelist.add(storeActiveAnalysis);
            }catch(Exception e){
            	e.printStackTrace();
            }
        }  
        analysisService.addactiveAnalysis(activelist);//批量插入，传入bidAnalysis实体集合
        PrintWriter out = null;  
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码  
        out = response.getWriter();  
        out.print("文件导入成功！");  
        out.flush();  
        out.close();  
	}
 	/**
	 * 接收json字符串，解析保存至数据库
	 * @return ModelAndView
	 */
	@RequestMapping("/AnalysisMtData")
	public void analysisDate(HttpServletRequest request,HttpServletResponse response){
		String content = request.getParameter("content");
		
		if(JSONObject.fromObject(content).get("ePoiId")!=null){
			createMtData(response,content);
		}
	}
	
	public void createMtData(HttpServletResponse response,String content) {
		MtDateBase mtDateBase = (MtDateBase) MtDateBase.createDataBean(new MtDateBase(),content);
		@SuppressWarnings("unchecked")
		Map<Integer,MtDetail> mtDetailMap = (Map<Integer, MtDetail>) MtDateBase.createDataBean(new MtDetail(),mtDateBase.detail);
		@SuppressWarnings("unchecked")
		Map<Integer,MtExtras> mtExtraMap = (Map<Integer, MtExtras>) MtDateBase.createDataBean(new MtExtras(),mtDateBase.extras);
		MtPoiReceiveDetail mtPoiReceiveDetail =(MtPoiReceiveDetail) MtDateBase.createDataBean(new MtPoiReceiveDetail(),mtDateBase.poiReceiveDetail);
		Map<String, Object> map = new HashMap<String, Object>();
		createAccountOrderDetail(response,mtDateBase,mtDetailMap,mtExtraMap,mtPoiReceiveDetail);
	}
	
	public void createAccountOrderDetail(HttpServletResponse response,MtDateBase mtDateBase,Map<Integer, MtDetail> mtDetail,
			Map<Integer, MtExtras> mtExtras,MtPoiReceiveDetail mtPoiReceiveDetail) {
		AccountOrderDetail aod= new AccountOrderDetail();
		boolean insertFlag  =  true;
		String aodid = "";
		/**
		 * 查询数据库中是否有该订单信息 ，如果有，更新数据；否则，插入数据
		 */
		AccountOrderDetail  recentAod = accountOrderDetailService.getByPrimaryKey(mtDateBase.getOrderIdView());
		if(recentAod!=null){
			insertFlag = false;
			aodid = recentAod.getId();
		}
		/**
		 * Detail部分   -- 订单菜品详情
		 */
		Iterator<Entry<Integer, MtDetail>> it = mtDetail.entrySet().iterator();
		double mealFee = 0, orginPrice = 0;
		String goodName="",goodsPrice="" ,goodsId="",quantity ="";
		while(it.hasNext()){
			MtDetail mtDetailObj = (MtDetail) it.next().getValue();
			//计算餐盒费
			mealFee +=(Double.parseDouble(mtDetailObj.getBox_num())
					*Double.parseDouble(mtDetailObj.getBox_price()));
			orginPrice += Double.parseDouble(mtDetailObj.getPrice());
			//菜品名称
			goodName += mtDetailObj.getFood_name()!=null?goodName.length()>0?","+mtDetailObj.getFood_name():mtDetailObj.getFood_name():"";
			//菜品价格
			goodsPrice += mtDetailObj.getPrice()!=null?goodsPrice.length()>0?","+mtDetailObj.getPrice():mtDetailObj.getPrice():"";
			//菜品Id - erp方菜品id
			goodsId += mtDetailObj.getApp_food_code()!=null?goodsId.length()>0?","+mtDetailObj.getApp_food_code():mtDetailObj.getApp_food_code():"";
			//菜品份数
			quantity +=mtDetailObj.getQuantity()!=null?quantity.length()>0?","+mtDetailObj.getQuantity():mtDetailObj.getQuantity():"";
			//菜品数量表对象
			AccountSaleGoods asg = new AccountSaleGoods();
			//店铺ID
			asg.setStoreId(mtDateBase.getPoiId());
			//店铺名称
			asg.setStoreName(mtDateBase.getPoiName());
			//日期
			asg.setCreateDate(Timestamp.valueOf(DateUtil.timestamp2Date(mtDateBase.getCtime())));
			//订单编号
			asg.setOrderNo(mtDateBase.getOrderIdView());
			//菜品名称
			asg.setGoodName(mtDetailObj.getFood_name());
			//原价单价
			asg.setGoodUnitPrice(new BigDecimal(mtDetailObj.getPrice()));
			//实际结算单价
			asg.setGoodActualPrice(BigDecimal.valueOf(Double.parseDouble(mtDetailObj.getPrice())
					*Double.parseDouble(mtDetailObj.getFood_discount())));
			//销售数量
			asg.setGoodNum(Integer.valueOf(mtDetailObj.getQuantity()));
			asg.setPlatformType("mt");
			ResultMessage aodrm = null ;
			if(insertFlag){
				aodrm = accountOrderDetailService.addSaleGoods(asg);
			}else{
				aodrm = accountOrderDetailService.updateSaleGoods(asg);
			}
			if(aodrm.getStatus()==0){
				AjaxUtils.sendAjaxForObjectStr(response,aodrm);
				return;
			}
		}
		/**
		 * poiReceiveDetail -- 商家对账信息
		 */
		aod.setServiceCharge(BigDecimal.valueOf(Double.parseDouble(mtPoiReceiveDetail.getFoodShareFeeChargeByPoi())/100));
		/*
		mtPoiReceiveDetail.getActOrderChargeByMt();//美团承担明细
		mtPoiReceiveDetail.getActOrderChargeByMt();
		mtPoiReceiveDetail.getActOrderChargeByMt();
		mtPoiReceiveDetail.getActOrderChargeByMt();
		*/
		/**
		 * extras部分 -- 订单优惠信息  
		 */
		Iterator<Entry<Integer, MtExtras>> extrasIt = mtExtras.entrySet().iterator();
		double mt_charges = 0,poi_charge = 0, reduce_fee = 0;
		while(extrasIt.hasNext()){
			MtExtras mtExtrasObj = (MtExtras) extrasIt.next().getValue();
			//优惠金额中美团承担的部分
			mt_charges += (Double.parseDouble(mtExtrasObj.getMt_charge()!=""?mtExtrasObj.getMt_charge():"0"));
			//优惠金额中商家承担的部分
			poi_charge += (Double.parseDouble(mtExtrasObj.getPoi_charge()!=""?mtExtrasObj.getMt_charge():"0"));
			//活动优惠金额
			reduce_fee += (Double.parseDouble(mtExtrasObj.getReduce_fee()!=""?mtExtrasObj.getMt_charge():"0"));
		
		}
		aod.setCheckNo(mtDateBase.getOrderId());
		aod.setPlatformActivitiesSubsidies(BigDecimal.valueOf(mt_charges));//优惠金额中美团承担的部分
		aod.setMerchantActivitiesSubsidies(BigDecimal.valueOf(poi_charge));//优惠金额中商家承担的部分
		aod.setActiveTotal(BigDecimal.valueOf(reduce_fee));//活动优惠总额 
		aod.setOrderTime(Timestamp.valueOf(DateUtil.timestamp2Date(mtDateBase.getCtime())));//订单创建时间
		aod.setRemark(mtDateBase.getCaution());//订单备注
		aod.setOrderType("0".equals(mtDateBase.getDeliveryTime())?"NORMAL":"BOOKING");//用户预计送达时间，“立即送达”时为0
		aod.setMealFee(BigDecimal.valueOf(mealFee));
		aod.setGoodsName(goodName.trim());
		aod.setGoodsPrice(goodsPrice.trim());
		aod.setGoodsId(goodsId.trim());
		aod.setGoodsQuality(quantity.trim());
		aod.setOverTime(Timestamp.valueOf(DateUtil.timestamp2Date(mtDateBase.getCtime())));//订单完成时间
		aod.setOrderNo(mtDateBase.getOrderIdView());//订单展示Id
		//mtDateBase.getPayType();//订单支付类型（1：货到付款；2：在线支付）
		aod.setStoreMTId(mtDateBase.getPoiId());
		aod.setStoreName(mtDateBase.getPoiName());//门店名称
		aod.setLatestStatus(mtDateBase.getStatus());//订单状态
		aod.setSettlementAmount(new BigDecimal(mtDateBase.getTotal()));//订单总价
		aod.setOrderIndex(mtDateBase.getDaySeq());
		aod.setPlatformType("mt");
		aod.setCreateDate(new Date());
		aod.setTargetAddr(mtDateBase.getRecipientAddress());
		aod.setConsigneeName(mtDateBase.getRecipientName());
		aod.setActiveTime(Timestamp.valueOf(DateUtil.timestamp2Date(mtDateBase.getCtime())));
		aod.setOrginPrice(BigDecimal.valueOf(orginPrice));//订单原价
		aod.setStoreId(mtDateBase.getPoiId());
		aod.setConsigneePhones(mtDateBase.getRecipientPhone());
		aod.setDistributionMode(mtDateBase.getLogisticsCode());//配送类型码	
		aod.setPlatformDistCharge("0000".equals(mtDateBase.getLogisticsCode())?BigDecimal.valueOf(0):new BigDecimal(mtDateBase.getShippingFee()));//平台配送费
		aod.setMerchantDistCharge("0000".equals(mtDateBase.getLogisticsCode())?new BigDecimal(mtDateBase.getShippingFee()):BigDecimal.valueOf(0));//商户配送费
		aod.setIsInvalid("9".equals(mtDateBase.getStatus())?"1":"0");
		if(mtDateBase.getDeliveryTime().length()>2){
			aod.setBookedTime(Timestamp.valueOf(DateUtil.timestamp2Date(mtDateBase.getDeliveryTime())));
		}
		ResultMessage rm = null;
		if(insertFlag){
			rm= accountOrderDetailService.add(aod);
			rm.setData(aod);
		}else{
			aod.setId(aodid); 
			rm= accountOrderDetailService.update(aod);
			rm.setData(aod);
		}
		AjaxUtils.sendAjaxForObjectStr(response,rm);
	
	}

	

	
}

