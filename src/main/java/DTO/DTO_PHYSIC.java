package DTO;

public class DTO_PHYSIC {

	public int PH_ID;
	public int PR_ID;
	public int TR_ID;
	public int R_ID;
	public String PH_TYPE;
	public String PART_CODE;
	public boolean INSUR;

	public DTO_PHYSIC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_PHYSIC(int pH_ID, int pR_ID, int tR_ID, int r_ID, String pH_TYPE, String pART_CODE, boolean iNSUR) {
		super();
		PH_ID = pH_ID;
		PR_ID = pR_ID;
		TR_ID = tR_ID;
		R_ID = r_ID;
		PH_TYPE = pH_TYPE;
		PART_CODE = pART_CODE;
		INSUR = iNSUR;
	}

}
