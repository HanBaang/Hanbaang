package DTO;

public class DTO_CHIM {

	public int CH_ID;
	public String CODE;
	public String NAME;
	public String C_NAME;
	public int PART;

	public DTO_CHIM() {
		super();
	}
	public DTO_CHIM(String cODE, String nAME, String c_NAME, int pART) {
		super();
		
		CODE = cODE;
		NAME = nAME;
		C_NAME = c_NAME;
		PART = pART;
	}
	public DTO_CHIM(int cH_ID, String cODE, String nAME, String c_NAME, int pART) {
		super();
		CH_ID = cH_ID;
		CODE = cODE;
		NAME = nAME;
		C_NAME = c_NAME;
		PART = pART;
	}

}
