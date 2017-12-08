package DTO;

public class DTO_INSUR_DETAIL {

	public int _ID;
	public String TREAT_NAME;
	public String TREAT_CODE;
	public int TYPE;
	public String PART;
	public int ONCE_DOSE;
	public int TOTAL_DOSE;
	public int TOTAL_CHARGE;

	public DTO_INSUR_DETAIL() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_INSUR_DETAIL(int _ID, String tREAT_NAME, String tREAT_CODE, int tYPE, String pART, int oNCE_DOSE,
			int tOTAL_DOSE, int tOTAL_CHARGE) {
		super();
		this._ID = _ID;
		TREAT_NAME = tREAT_NAME;
		TREAT_CODE = tREAT_CODE;
		TYPE = tYPE;
		PART = pART;
		ONCE_DOSE = oNCE_DOSE;
		TOTAL_DOSE = tOTAL_DOSE;
		TOTAL_CHARGE = tOTAL_CHARGE;
	}

	public DTO_INSUR_DETAIL(String tREAT_NAME, String tREAT_CODE, int tYPE, String pART, int oNCE_DOSE, int tOTAL_DOSE,
			int tOTAL_CHARGE) {
		super();
		TREAT_NAME = tREAT_NAME;
		TREAT_CODE = tREAT_CODE;
		TYPE = tYPE;
		PART = pART;
		ONCE_DOSE = oNCE_DOSE;
		TOTAL_DOSE = tOTAL_DOSE;
		TOTAL_CHARGE = tOTAL_CHARGE;
	}

}
