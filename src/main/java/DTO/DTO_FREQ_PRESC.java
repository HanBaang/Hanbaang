package DTO;

public class DTO_FREQ_PRESC {
	public int FP_ID;
	public String PRESC_NAME;
	public String DRUG_NAME;

	public DTO_FREQ_PRESC() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTO_FREQ_PRESC(int fP_ID, String pRESC_NAME, String dRUG_NAME) {
		super();
		FP_ID = fP_ID;
		PRESC_NAME = pRESC_NAME;
		DRUG_NAME = dRUG_NAME;
	}

}