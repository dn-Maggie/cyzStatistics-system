package com.cyz.staticsystem.common.enums;
/**
 * @ClassName: LogisticsCode
 * @Description: 配送方式枚举
 * @author Maggie
 * @date 2017年8月1日17:26:13
 * 
 */
public enum LogisticsCode {
	/**
     * 商家自配送
     */
	 SELF("0000","商家自配送"),
	 /**
     *  趣活
     */
     QUHUO("0002","趣活"),
	 /**
     * 达达
     */
     DADA("0016","达达"),
 	 /**
      * E代送
      */
     EDAISONG("0033","E代送"),
  	 /**
      * 美团专送-加盟
      */
     MTJM("1001","美团专送-加盟"),
   	 /**
      * 美团专送-自建
      */
     MTZJ("1002","美团专送-自建"),
	 /**
      * 美团配送-众包
      */
     MTZB("1003","美团配送-众包"),
 	 /**
	   * 美团专送-城市代理
	   */
     MTCSDL("1004","美团专送-城市代理"),
  	 /**
     * 角马
     */
     JIAOMA("2001","角马"),
   	 /**
      * 快送
      */
     KUAISONG("2002","快送"),
	 /**
      * 美团专送－混合送
      */
     MEHH("3001","美团专送－混合送");
	
	
	 private String name;
     private String descript;
     private int sort;
     
     private LogisticsCode(String _name,String _descript){
    	 this.setName(_name);
    	 this.setDescript(_descript);
    	 this.setSort(this.ordinal());
     }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescript() {
		return descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
	
	public static void main(String[] args) {
		for (LogisticsCode e : LogisticsCode.values()) {
            System.out.println(e.name);
        }
		/*System.out.println(LogisticsCode.JIAOMA.name);
		System.out.println();*/
	}
	    
}
