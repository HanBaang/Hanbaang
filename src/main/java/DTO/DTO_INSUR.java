package DTO;

import java.sql.Date;

public class DTO_INSUR {
	public int IN_ID;
	public int PR_ID;
	public int TR_ID;
	public int R_ID;
	public Date TREAT_DATE;
	public String PATNT_NAME;
	public String CID;
	public String DOC;
	public boolean INSUR;
	public int INSUR_CHARGE;
	public int HANDI_CHARGE;
	public int SUP;
	public int PATNT_CHARGE;
	public int TOTAL_CHARGE;

	public DTO_INSUR() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_INSUR(int iN_ID, int pR_ID, int tR_ID, int r_ID, Date tREAT_DATE, String pATNT_NAME, String cID,
			String dOC, boolean iNSUR, int iNSUR_CHARGE, int hANDI_CHARGE, int sUP, int pATNT_CHARGE,
			int tOTAL_CHARGE) {
		super();
		IN_ID = iN_ID;
		PR_ID = pR_ID;
		TR_ID = tR_ID;
		R_ID = r_ID;
		TREAT_DATE = tREAT_DATE;
		PATNT_NAME = pATNT_NAME;
		CID = cID;
		DOC = dOC;
		INSUR = iNSUR;
		INSUR_CHARGE = iNSUR_CHARGE;
		HANDI_CHARGE = hANDI_CHARGE;
		SUP = sUP;
		PATNT_CHARGE = pATNT_CHARGE;
		TOTAL_CHARGE = tOTAL_CHARGE;
	}

}