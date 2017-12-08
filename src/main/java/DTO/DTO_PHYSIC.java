package DTO;

public class DTO_PHYSIC {

	public int PH_ID;
	public int CH_ID;
	public int TR_ID;
	public String PH_TYPE;
	public String NAME;
	public String PART_CODE;
	public boolean INSUR;

	public DTO_PHYSIC() {
		super();
	}
	
	public DTO_PHYSIC(int pH_ID, int cH_ID, int tR_ID, String pH_TYPE, String nAME, String pART_CODE, boolean iNSUR) {
		super();
		PH_ID = pH_ID;
		CH_ID = cH_ID;
		TR_ID = tR_ID;
		PH_TYPE = pH_TYPE;
		NAME = nAME;
		PART_CODE = pART_CODE;
		INSUR = iNSUR;
	}

	public DTO_PHYSIC(int cH_ID, int tR_ID, String pH_TYPE, String nAME, String pART_CODE, boolean iNSUR) {
		super();
		CH_ID = cH_ID;
		TR_ID = tR_ID;
		PH_TYPE = pH_TYPE;
		NAME = nAME;
		PART_CODE = pART_CODE;
		INSUR = iNSUR;
	}

}
