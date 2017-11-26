package DTO;

import java.sql.Date;

public class DTO_PRESC {

	public int PR_ID;
	public int TR_ID;
	public int R_ID;
	public int CHUP;
	public int PACK;
	public int STD_VOL;
	public int WATER_VOL;
	public boolean INSUR;
	public Date REG_DATE;
	public Date MOD_DATE;
	public boolean FREQ;

	public DTO_PRESC() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO_PRESC(int tR_ID, int r_ID, int cHUP, int pACK, int sTD_VOL, int wATER_VOL, boolean iNSUR,
			Date rEG_DATE, Date mOD_DATE, boolean fREQ) {
		super();
		
		TR_ID = tR_ID;
		R_ID = r_ID;
		CHUP = cHUP;
		PACK = pACK;
		STD_VOL = sTD_VOL;
		WATER_VOL = wATER_VOL;
		INSUR = iNSUR;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
		FREQ = fREQ;
	}
	public DTO_PRESC(int pR_ID, int tR_ID, int r_ID, int cHUP, int pACK, int sTD_VOL, int wATER_VOL, boolean iNSUR,
			Date rEG_DATE, Date mOD_DATE, boolean fREQ) {
		super();
		PR_ID = pR_ID;
		TR_ID = tR_ID;
		R_ID = r_ID;
		CHUP = cHUP;
		PACK = pACK;
		STD_VOL = sTD_VOL;
		WATER_VOL = wATER_VOL;
		INSUR = iNSUR;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
		FREQ = fREQ;
	}

}
