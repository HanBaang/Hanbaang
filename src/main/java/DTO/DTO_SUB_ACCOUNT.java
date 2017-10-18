package DTO;

import java.sql.Date;

public class DTO_SUB_ACCOUNT {
	private int SA_id;
	private String ID;
	private String PW;
	private String STAFF_NAME;
	private String ORG_NUM;

	private String COMP_NUM;
	private String PHONE;
	private String MAIL;
	private String ADDR;
	private String ADDR_DETAIL;
	private Date REG_DATE;
	private Date MOD_DATE;

	public DTO_SUB_ACCOUNT() {
		super();
	}

	public DTO_SUB_ACCOUNT(int sA_id, String iD, String pW, String sTAFF_NAME, String oRG_NUM, String cOMP_NUM,
			String pHONE, String mAIL, String aDDR, String aDDR_DETAIL, Date rEG_DATE, Date mOD_DATE) {
		super();
		SA_id = sA_id;
		ID = iD;
		PW = pW;
		STAFF_NAME = sTAFF_NAME;
		ORG_NUM = oRG_NUM;
		COMP_NUM = cOMP_NUM;
		PHONE = pHONE;
		MAIL = mAIL;
		ADDR = aDDR;
		ADDR_DETAIL = aDDR_DETAIL;
		REG_DATE = rEG_DATE;
		MOD_DATE = mOD_DATE;
	}

	public int getSA_id() {
		return SA_id;
	}

	public void setSA_id(int sA_id) {
		SA_id = sA_id;
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

	public String getSTAFF_NAME() {
		return STAFF_NAME;
	}

	public void setSTAFF_NAME(String sTAFF_NAME) {
		STAFF_NAME = sTAFF_NAME;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ADDR == null) ? 0 : ADDR.hashCode());
		result = prime * result + ((ADDR_DETAIL == null) ? 0 : ADDR_DETAIL.hashCode());
		result = prime * result + ((COMP_NUM == null) ? 0 : COMP_NUM.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((MAIL == null) ? 0 : MAIL.hashCode());
		result = prime * result + ((MOD_DATE == null) ? 0 : MOD_DATE.hashCode());
		result = prime * result + ((ORG_NUM == null) ? 0 : ORG_NUM.hashCode());
		result = prime * result + ((PHONE == null) ? 0 : PHONE.hashCode());
		result = prime * result + ((PW == null) ? 0 : PW.hashCode());
		result = prime * result + ((REG_DATE == null) ? 0 : REG_DATE.hashCode());
		result = prime * result + SA_id;
		result = prime * result + ((STAFF_NAME == null) ? 0 : STAFF_NAME.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DTO_SUB_ACCOUNT other = (DTO_SUB_ACCOUNT) obj;
		if (ADDR == null) {
			if (other.ADDR != null)
				return false;
		} else if (!ADDR.equals(other.ADDR))
			return false;
		if (ADDR_DETAIL == null) {
			if (other.ADDR_DETAIL != null)
				return false;
		} else if (!ADDR_DETAIL.equals(other.ADDR_DETAIL))
			return false;
		if (COMP_NUM == null) {
			if (other.COMP_NUM != null)
				return false;
		} else if (!COMP_NUM.equals(other.COMP_NUM))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (MAIL == null) {
			if (other.MAIL != null)
				return false;
		} else if (!MAIL.equals(other.MAIL))
			return false;
		if (MOD_DATE == null) {
			if (other.MOD_DATE != null)
				return false;
		} else if (!MOD_DATE.equals(other.MOD_DATE))
			return false;
		if (ORG_NUM == null) {
			if (other.ORG_NUM != null)
				return false;
		} else if (!ORG_NUM.equals(other.ORG_NUM))
			return false;
		if (PHONE == null) {
			if (other.PHONE != null)
				return false;
		} else if (!PHONE.equals(other.PHONE))
			return false;
		if (PW == null) {
			if (other.PW != null)
				return false;
		} else if (!PW.equals(other.PW))
			return false;
		if (REG_DATE == null) {
			if (other.REG_DATE != null)
				return false;
		} else if (!REG_DATE.equals(other.REG_DATE))
			return false;
		if (SA_id != other.SA_id)
			return false;
		if (STAFF_NAME == null) {
			if (other.STAFF_NAME != null)
				return false;
		} else if (!STAFF_NAME.equals(other.STAFF_NAME))
			return false;
		return true;
	}

}