package com.frank.enumdemo;

/**
 * 老超柜交易码交易名称枚举类
 * 
 * @author kst,20210625
 *
 */
public enum OldSTMTradeNameEnum {
	
	TRADE0001q("0001q","借据分户查询"),
	TRADE0002q("0002q","金价查询"),
	TRADE0003q("0003q","次日到账查询"),
	TRADE010201("010201","客户信息维护_无纸化"),
	TRADE020002("020002","综合签约_无纸化"),
	TRADE020017("020017","电子银行密码重置_无纸化"),
	TRADE020031("020031","次日到账受理_无纸化"),
	TRADE020032("020032","次日到账撤销_无纸化"),
	TRADE0201("0201","新增客户信息"),
	TRADE0203("0203","修改客户信息"),
	TRADE020902("020902","密码修改_无纸化"),
	TRADE022102("022102","不动户激活_无纸化"),
	TRADE0302("0302","活转定"),
	TRADE0306("0306","行内转账"),
	TRADE0308("0308","定转活_部提"),
	TRADE0310("0310","磁条卡销户"),
	TRADE031007("031007","换卡_无纸化"),
	TRADE031011("031011","卡解锁_无纸化"),
	TRADE0310201("0310201","卡挂失_无纸化"),
	TRADE0310202("0310202","卡解挂_无纸化"),
	TRADE0310_1("0310_1","磁条卡本息合计查询"),
	TRADE0310_2("0310_2","定转活_销户"),
	TRADE0404("0404","自助贷款还款"),
	TRADE0451("0451","自助贷款申请"),
	TRADE060301("060301","自助开卡_无纸化"),
	TRADE06030101("06030101","活转定_无纸化"),
	TRADE060310("060310","销户_无纸化"),
	TRADE06031003("06031003","定转活_无纸化"),
	TRADE064320("064320","卡激活_无纸化"),
	TRADE0715_1("0715_1","ATM转账签约"),
	TRADE0715_2("0715_2","ATM转账修改"),
	TRADE0715_3("0715_3","ATM转账解约"),
	TRADE0803("0803","信用卡转账"),
	TRADE080306("080306","行内转账_无纸化"),
	TRADE080341("080341","次日到账受理"),
	TRADE0902("0902","密码修改"),
	TRADE090402("090402","自助贷款发放_无纸化"),
	TRADE090403("090403","自助贷款还款_无纸化"),
	TRADE100200("100200","理财购买"),
	TRADE100200jj("100200jj","基金产品购买"),
	TRADE100202("100202","理财赎回"),
	TRADE100202jj("100202jj","基金赎回"),
	TRADE100219("100219","理财撤单"),
	TRADE100219jj("100219jj","基金撤单"),
	TRADE100301decd("100301decd","大额存单签约信息查询"),
	TRADE100301jj("100301jj","基金客户签约银行账户信息查询"),
	TRADE100304jj("100304jj","基金持有产品份额查询"),
	TRADE100307jj("100307jj","基金当前委托查询"),
	TRADE100308("100308","理财赎回查询"),
	TRADE100308jj("100308jj","基金历史委托查询"),
	TRADE100309jj("100309jj","基金历史成交查询"),
	TRADE100330jj("100330jj","基金产品行情查询"),
	TRADE100342jj("100342jj","基金允许撤单流水查询"),
	TRADE100343jj("100343jj","基金产品额度查询"),
	TRADE100375jj("100375jj","基金客户风险等级查询"),
	TRADE1011("1011","卡解锁"),
	TRADE1020_1("1020_1","卡挂失"),
	TRADE1020_2("1020_2","卡解挂"),
	TRADE117111("117111","本转他"),
	TRADE117111_1("117111_1","本转他通道查询"),
	TRADE117111_2("117111_2","本转他_无纸化"),
	TRADE117112("117112","他转本"),
	TRADE117112_1("117112_1","他转本通道查询"),
	TRADE117112_2("117112_2","他转本_无纸化"),
	TRADE145311_961009("145311_961009","跨行汇款大额_无纸化"),
	TRADE145311_961302("145311_961302","跨行汇款小额_无纸化"),
	TRADE1801("1801","联网核查"),
	TRADE1A0001("1A0001","大额存单购买"),
	TRADE1A0301("1A0301","大额存单产品信息查询"),
	TRADE1A0302("1A0302","大额存单历史交易记录详情查询"),
	TRADE1A0304("1A0304","大额存单产品列表查询"),
	TRADE2102("2102","不动户激活"),
	TRADE2221("2221","自助开卡"),
	TRADE2236("2236","IC卡废卡处理"),
	TRADE2255("2255","IC卡销户"),
	TRADE2257("2257","IC卡换卡"),
	TRADE2285("2285","磁条卡换卡"),
	TRADE2305("2305","交易明细查询"),
	TRADE240803("240803","信用卡转账_无纸化"),
	TRADE240806("240806","信用卡密码重置"),
	TRADE240806_01("240806_01","信用卡密码重置_无纸化"),
	TRADE240807("240807","信用卡激活"),
	TRADE240807_01("240807_01","信用卡激活_无纸化"),
	TRADE240818("240818","信用卡自动扣款账号维护"),
	TRADE240818_01("240818_01","信用卡自动扣款账号维护_无纸化"),
	TRADE27000("27000","账户信息查询"),
	TRADE27002("27002","定期子账户查询"),
	TRADE360001("360001","贵金属订购_无纸化"),
	TRADE372("372","次日到账撤销"),
	TRADE4320("4320","卡激活"),
	TRADE45003("45003","自助贷款信息查询"),
	TRADE45004("45004","自助贷款借据查询"),
	TRADE45006("45006","自助贷款全部还款试算"),
	TRADE45007("45007","自助贷款部分还款试算"),
	TRADE6060("6060","自助贷款还款"),
	TRADE6181("6181","短信通签约"),
	TRADE6182_1("6182_1","短信通修改"),
	TRADE6182_2("6182_2","短信通解约"),
	TRADE6351("6351","贵金属订购"),
	TRADE7302("7302","账户余额查询"),
	TRADE7305("7305","账户信息列表查询"),
	TRADE762421("762421","跨行汇款_大小额渠道参数查询"),
	TRADE8951("8951","介质出售"),
	TRADE9015("9015","尾箱核对"),
	TRADE9015_0301("9015_0301","客户信息查询"),
	TRADE9015_1001("9015_1001","磁条卡查账户总余额"),
	TRADE9015_2227("9015_2227","IC卡查账户总余额"),
	TRADE9015_2255("9015_2255","IC卡本息合计查询"),
	TRADE9015_6183("9015_6183","短信通签约查询"),
	TRADE9015_70072_13("9015_70072_13","利率查询"),
	TRADE9015_70072_6("9015_70072_6","ATM转账签约查询"),
	TRADE9015_8951("9015_8951","介质查询"),
	TRADE9022("9022","密码输入次数登记"),
	TRADE9025_635101("9025_635101","贵金属公司查询"),
	TRADE9025_635102("9025_635102","贵金属产品信息查询"),
	TRADE9111("9111","已开账户查询"),
	TRADE961009("961009","跨行汇款_大额"),
	TRADE961302("961302","跨行汇款_小额"),
	TRADECIB03001("CIB03001","兴业账户验证"),
	TRADEMCACifPwdReset("MCACifPwdReset","电子银行密码重置"),
	TRADEMCAPayeeManageMod("MCAPayeeManageMod","收款人名册更新"),
	TRADEMCAPayeeManageQry("MCAPayeeManageQry","收款人名册查询"),
	TRADEMCASignCif("MCASignCif","电子银行签约"),
	TRADEMCASignCifCancel("MCASignCifCancel","电子银行解约"),
	TRADEMCASignCifQry("MCASignCifQry","电子银行签约查询"),
	TRADEMCASignCifUpdate("MCASignCifUpdate","电子银行修改"),
	TRADESTL01003("STL01003","跨行转账信息补全"),
	TRADEY0001("Y0001","贷款申请"),
	TRADEcd001("cd001","大额存单购买_无纸化"),
	TRADEdk001("dk001","贷款申请_无纸化"),
	TRADEfaceDetect("faceDetect","人脸比对"),
	TRADEfd001("fd001","基金购买_无纸化"),
	TRADEfd002("fd002","基金撤单_无纸化"),
	TRADEfd003("fd003","基金赎回_无纸化"),
	TRADElc001("lc001","理财购买_无纸化"),
	TRADElc002("lc002","理财撤单_无纸化"),
	TRADElc003("lc003","理财赎回_无纸化"),
	TRADEsendSMS("sendSMS","短信验证"),
	TRADEupdatePrd("updatePrd","理财产品信息同步");
	
	// 交易码
	private String tradeCode;
	// 交易名称
	private String tradeName;

	private OldSTMTradeNameEnum(String tradeCode, String tradeName) {
		this.tradeCode = tradeCode;
		this.tradeName = tradeName;
	}

	public String getTradeCode() {
		return tradeCode;
	}

	public void setTradeCode(String tradeCode) {
		this.tradeCode = tradeCode;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public static String getTradeName(String tradeCode) {
		for (OldSTMTradeNameEnum oldSTMTradeNameEnum : OldSTMTradeNameEnum
				.values()) {
			if (oldSTMTradeNameEnum.getTradeCode().equals(tradeCode)) {
				return oldSTMTradeNameEnum.getTradeName();
			}
		}
		return tradeCode;
	}
	
}
