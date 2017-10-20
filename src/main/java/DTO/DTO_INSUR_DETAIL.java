package DTO;

public class DTO_INSUR_DETAIL {

	public int _ID;
	public int PR_ID;
	public int TR_ID;
	public int R_ID;
	public String TREAT_NAME;
	public String TREAT_CODE;
	public String PART;
	public int ONCE_DOSE;
	public int TOTAL_DOSE;
	public int TOTAL_CHARGE;

	public DTO_INSUR_DETAIL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_INSUR_DETAIL(int _ID, int pR_ID, int tR_ID, int r_ID, String tREAT_NAME, String tREAT_CODE, String pART,
			int oNCE_DOSE, int tOTAL_DOSE, int tOTAL_CHARGE) {
		super();
		this._ID = _ID;
		PR_ID = pR_ID;
		TR_ID = tR_ID;
		R_ID = r_ID;
		TREAT_NAME = tREAT_NAME;
		TREAT_CODE = tREAT_CODE;
		PART = pART;
		ONCE_DOSE = oNCE_DOSE;
		TOTAL_DOSE = tOTAL_DOSE;
		TOTAL_CHARGE = tOTAL_CHARGE;
	}

}
