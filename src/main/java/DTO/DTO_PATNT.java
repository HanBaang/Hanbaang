package DTO;

import java.sql.Date;

public class DTO_PATNT {
	public int PA_ID;
	public String PATNT_NAME;
	public String H_INSUR_NUM;
	public String CID;
	public int GEND;
	public String MAIL;
	public String ADDR;
	public String ADDR_DETAIL;
	public String PHONE;
	public String MDOC;
	public Date REG_DATE;
	public Date MOD_DATE;

	public DTO_PATNT(int pA_ID, String pATNT_NAME, String h_INSUR_NUM, String cID, int gEND, String mAIL, String aDDR,
			String aDDR_DETAIL, String pHONE, String mDOC, Date rEG_DATE, Date mOD_DATE) {
		super();
		PA_ID = pA_ID;
		PATNT_NAME = pATNT_NAME;
		H_INSUR_NUM = h_INSUR_NUM;
		CID = cID;
		GEND = gEND;
		MAIL = mAIL;
		ADDR = aDDR;
		ADDR_DETAIL = aDDR_DETAIL;
		PHONE = pHONE;
		MDOC = mDOC;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
	}

	public DTO_PATNT() {
		super();
		// TODO Auto-generated constructor stub
	}

}