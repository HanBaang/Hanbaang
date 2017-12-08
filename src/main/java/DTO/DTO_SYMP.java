package DTO;

public class DTO_SYMP {
	public int SY_ID;
	public int TR_ID;
	public String SYMP_CODE;
	public String SYMP_NAME;
	public boolean INSUR;

	public DTO_SYMP() {
		super();
	}

	public DTO_SYMP(int sY_ID, int tR_ID, String sYMP_CODE, String sYMP_NAME, boolean iNSUR) {
		super();
		SY_ID = sY_ID;
		TR_ID = tR_ID;
		SYMP_CODE = sYMP_CODE;
		SYMP_NAME = sYMP_NAME;
		INSUR = iNSUR;
	}

	public DTO_SYMP(int tR_ID, String sYMP_CODE, String sYMP_NAME, boolean iNSUR) {
		super();
		TR_ID = tR_ID;
		SYMP_CODE = sYMP_CODE;
		SYMP_NAME = sYMP_NAME;
		INSUR = iNSUR;
	}

}
