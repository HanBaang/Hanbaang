package DTO;

public class DTO_DRUG {

	public int DR_ID;
	public int PR_ID;
	public String DRUG_CODE;
	public String DRUG_COMP_NAME;
	public String DRUG_NAME;
	public int DRUG_WEIGHT;
	public String DRUG_MEMO;
	public boolean INSUR;
	public String TYPE;
	public String TYPE_ID;
	public DTO_DRUG() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTO_DRUG(int pR_ID, String dRUG_CODE, String dRUG_COMP_NAME, String dRUG_NAME, int dRUG_WEIGHT,
			String dRUG_MEMO, boolean iNSUR, String tYPE, String tYPE_ID) {
		super();
		PR_ID = pR_ID;
		DRUG_CODE = dRUG_CODE;
		DRUG_COMP_NAME = dRUG_COMP_NAME;
		DRUG_NAME = dRUG_NAME;
		DRUG_WEIGHT = dRUG_WEIGHT;
		DRUG_MEMO = dRUG_MEMO;
		INSUR = iNSUR;
		TYPE = tYPE;
		TYPE_ID = tYPE_ID;
	}

	public DTO_DRUG(int dR_ID, int pR_ID, String dRUG_CODE, String dRUG_COMP_NAME, String dRUG_NAME, int dRUG_WEIGHT,
			String dRUG_MEMO, boolean iNSUR, String tYPE, String tYPE_ID) {
		super();
		DR_ID = dR_ID;
		PR_ID = pR_ID;
		DRUG_CODE = dRUG_CODE;
		DRUG_COMP_NAME = dRUG_COMP_NAME;
		DRUG_NAME = dRUG_NAME;
		DRUG_WEIGHT = dRUG_WEIGHT;
		DRUG_MEMO = dRUG_MEMO;
		INSUR = iNSUR;
		TYPE = tYPE;
		TYPE_ID = tYPE_ID;
	}
	
	
}