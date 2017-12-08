package DTO;

public class DTO_INSUR_PRESC {
	public int IP_ID;
	public String IP_CODE;
	public String IP_NAME;
	public String SUB_NAME;
	public String IP_COMP_NAME;
	public double IP_WEIGHT;
	public int IP_PRICE;

	public DTO_INSUR_PRESC() {
		super();
	}

	public DTO_INSUR_PRESC(int iP_ID, String iP_CODE, String iP_NAME, String sUB_NAME, String iP_COMP_NAME,
			double iP_WEIGHT, int iP_PRICE) {
		super();
		IP_ID = iP_ID;
		IP_CODE = iP_CODE;
		IP_NAME = iP_NAME;
		SUB_NAME = sUB_NAME;
		IP_COMP_NAME = iP_COMP_NAME;
		IP_WEIGHT = iP_WEIGHT;
		IP_PRICE = iP_PRICE;
	}

}
