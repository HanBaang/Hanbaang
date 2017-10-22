package DTO;

import java.sql.Date;


public class DTO_ACCOUNT {
	public int AC_id;
	public String ID;
	public String PW;
	public String HOSPI_NAME;
	public String ORG_NUM;
	public String COMP_NUM;
	public String PHONE;
	public String MAIL;
	public String ADDR;
	public String ADDR_DETAIL;
	public Date REG_DATE;
	public Date MOD_DATE;
	public int numOfCol = 12;

	public DTO_ACCOUNT() {
		super();
	}

	public DTO_ACCOUNT(int AC_id, String ID, String PW, String HOSPI_NAME, String ORG_NUM, String COMP_NUM,
			String PHONE, String MAIL, String ADDR, String ADDR_DETAIL, Date REG_DATE, Date MOD_DATE) {
		super();
		this.AC_id = AC_id;
		this.ID = ID;
		this.PW = PW;
		this.HOSPI_NAME = HOSPI_NAME;
		this.ORG_NUM = ORG_NUM;
		this.COMP_NUM = COMP_NUM;
		this.PHONE = PHONE;
		this.MAIL = MAIL;
		this.ADDR = ADDR;
		this.ADDR_DETAIL = ADDR_DETAIL;
		this.REG_DATE = REG_DATE;
		this.MOD_DATE = MOD_DATE;
	}

	public int getAC_id() {
		return AC_id;
	}

	public void setAC_id(int aC_id) {
		AC_id = aC_id;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPW() {
		return PW;
	}

	public void setPW(String pW) {
		PW = pW;
	}

	public String getHOSPI_NAME() {
		return HOSPI_NAME;
	}

	public void setHOSPI_NAME(String hOSPI_NAME) {
		HOSPI_NAME = hOSPI_NAME;
	}

	public String getORG_NUM() {
		return ORG_NUM;
	}

	public void setORG_NUM(String oRG_NUM) {
		ORG_NUM = oRG_NUM;
	}

	public String getCOMP_NUM() {
		return COMP_NUM;
	}

	public void setCOMP_NUM(String cOMP_NUM) {
		COMP_NUM = cOMP_NUM;
	}

	public String getPHONE() {
		return PHONE;
	}

	public void setPHONE(String pHONE) {
		PHONE = pHONE;
	}

	public String getMAIL() {
		return MAIL;
	}

	public void setMAIL(String mAIL) {
		MAIL = mAIL;
	}

	public String getADDR() {
		return ADDR;
	}

	public void setADDR(String aDDR) {
		ADDR = aDDR;
	}

	public String getADDR_DETAIL() {
		return ADDR_DETAIL;
	}

	public void setADDR_DETAIL(String aDDR_DETAIL) {
		ADDR_DETAIL = aDDR_DETAIL;
	}

	public Date getREG_DATE() {
		return REG_DATE;
	}

	public void setREG_DATE(Date rEG_DATE) {
		REG_DATE = rEG_DATE;
	}

	public Date getMOD_DATE() {
		return MOD_DATE;
	}

	public void setMOD_DATE(Date mOD_DATE) {
		MOD_DATE = mOD_DATE;
	}
}
