package DTO;

public class DTO_INSUR_DRUG {

	public int IDR_ID;
	public String IDR_CODE;
	public String IDR_NAME;
	public String IDR_COMP_NAME;
	public double IDR_WEIGHT;
	public int IDR_PRICE;

	public DTO_INSUR_DRUG() {
		// TODO Auto-generated constructor stub
	}
	public DTO_INSUR_DRUG(int IDR_ID, String IDR_CODE, String IDR_NAME, String IDR_COMP_NAME, double IDR_WEIGHT,
			int IDR_PRICE) {
		super();
		this.IDR_ID = IDR_ID;
		this.IDR_CODE = IDR_CODE;
		this.IDR_NAME = IDR_NAME;
		this.IDR_COMP_NAME = IDR_COMP_NAME;
		this.IDR_WEIGHT = IDR_WEIGHT;
		this.IDR_PRICE = IDR_PRICE;
	}

	

}
