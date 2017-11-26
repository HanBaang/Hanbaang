package DTO;

public class DTO_TREAT {

	public int TR_ID;
	public int R_ID;
	public String SYMP_NAME;
	public String MEMO;

	public DTO_TREAT() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DTO_TREAT(int r_ID, String sYMP_NAME, String mEMO) {
		super();
		R_ID = r_ID;
		SYMP_NAME = sYMP_NAME;
		MEMO = mEMO;
	}
	public DTO_TREAT(int tR_ID, int r_ID, String sYMP_NAME, String mEMO) {
		super();
		TR_ID = tR_ID;
		R_ID = r_ID;
		SYMP_NAME = sYMP_NAME;
		MEMO = mEMO;
	}

}
