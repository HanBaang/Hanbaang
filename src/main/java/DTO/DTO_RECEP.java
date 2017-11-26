package DTO;

import java.sql.Date;

public class DTO_RECEP {
	public int R_ID;
	public int PA_ID;
	public String PATNT_NAME;
	public Date RECEP_DATE;
	public String STATE;
	public String MEMO;
	public String MDOC;
	public String STAFF_NAME;

	public DTO_RECEP() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO_RECEP(int pA_ID, String pATNT_NAME, Date rECEP_DATE, String sTATE, String mEMO, String mDOC,
			String sTAFF_NAME) {
		super();
		PA_ID = pA_ID;
		PATNT_NAME = pATNT_NAME;
		RECEP_DATE = rECEP_DATE;
		STATE = sTATE;
		MEMO = mEMO;
		MDOC = mDOC;
		STAFF_NAME = sTAFF_NAME;
	}

	public DTO_RECEP(int r_ID, int pA_ID, String pATNT_NAME, Date rECEP_DATE, String sTATE, String mEMO, String mDOC,
			String sTAFF_NAME) {
		super();
		R_ID = r_ID;
		PA_ID = pA_ID;
		PATNT_NAME = pATNT_NAME;
		RECEP_DATE = rECEP_DATE;
		STATE = sTATE;
		MEMO = mEMO;
		MDOC = mDOC;
		STAFF_NAME = sTAFF_NAME;
	}

}