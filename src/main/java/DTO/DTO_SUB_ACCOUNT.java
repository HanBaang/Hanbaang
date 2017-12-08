package DTO;

import java.sql.Date;

public class DTO_SUB_ACCOUNT {

	public int SA_id;
	public int AC_id;
	public String ID;
	public String PW;
	public String STAFF_NAME;
	public String PHONE;
	public String ORG_NUM;
	public String COMP_NUM;
	public String MAIL;
	public String ADDR;
	public String ADDR_DETAIL;

	public Date REG_DATE;
	public Date MOD_DATE;
	
	public DTO_SUB_ACCOUNT() {
		super();
	}
	public DTO_SUB_ACCOUNT(int aC_id, String iD, String pW, String sTAFF_NAME, String pHONE, String oRG_NUM,
			String cOMP_NUM, String mAIL, String aDDR, String aDDR_DETAIL,  Date rEG_DATE, Date mOD_DATE) {
		super();
		
		AC_id = aC_id;
		ID = iD;
		PW = pW;
		STAFF_NAME = sTAFF_NAME;
		PHONE = pHONE;
		ORG_NUM = oRG_NUM;
		COMP_NUM = cOMP_NUM;
		ADDR = aDDR;
		ADDR_DETAIL = aDDR_DETAIL;
		MAIL = mAIL;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
	}
	public DTO_SUB_ACCOUNT(int sA_id, int aC_id, String iD, String pW, String sTAFF_NAME, String pHONE, String oRG_NUM,
			String cOMP_NUM, String mAIL, String aDDR, String aDDR_DETAIL,  Date rEG_DATE, Date mOD_DATE) {
		super();
		SA_id = sA_id;
		AC_id = aC_id;
		ID = iD;
		PW = pW;
		STAFF_NAME = sTAFF_NAME;
		PHONE = pHONE;
		ORG_NUM = oRG_NUM;
		COMP_NUM = cOMP_NUM;
		ADDR = aDDR;
		ADDR_DETAIL = aDDR_DETAIL;
		MAIL = mAIL;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
	}
}