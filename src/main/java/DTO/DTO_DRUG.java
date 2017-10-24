package DTO;

public class DTO_DRUG {

	public int DR_ID;
	public int PR_ID;
	public int TR_ID;
	public int R_ID;
	public String DRUG_CODE;
	public String DRUG_BRAND;
	public int DRUG_WEIGHT;
	public String DRUG_MEMO;
	public DTO_DRUG() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_DRUG(int dR_ID, int pR_ID, int tR_ID, int r_ID, String dRUG_CODE, String dRUG_BRAND, int dRUG_WEIGHT,
			String dRUG_MEMO) {
		super();
		DR_ID = dR_ID;
		PR_ID = pR_ID;
		TR_ID = tR_ID;
		R_ID = r_ID;
		DRUG_CODE = dRUG_CODE;
		DRUG_BRAND = dRUG_BRAND;
		DRUG_WEIGHT = dRUG_WEIGHT;
		DRUG_MEMO = dRUG_MEMO;
	}
}