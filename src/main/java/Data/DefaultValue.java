package Data;

public class DefaultValue {
	public static final String SQL_SELECT_TEST_BY_ID = "SELECT id, pw FROM test where id = ?";
	public static final int DB_TIMEOUT = 10000;

	// ACCOUNT TABLE
	public static final String SQL_LOGIN_ACCOUNT = "Select ID, HOSPI_NAME From ACCOUNT Where ID = ? AND PW = password(?) ";
	public static final String SQL_INSERT_ACCOUNT = "Insert Into ACCOUNT(ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE) Values (?,password(?),?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_ACCOUNT = "Select AC_ID,ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE From ACCOUNT;";
	public static final String SQL_SELECT_ACCOUNT_BY_PK = "Select AC_ID,ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE From ACCOUNT Where AC_ID=?;";
	public static final String SQL_UPDATE_ACCOUNT_BY_PK = "Update ACCOUNT Set ID=?, PW=?, HOSPI_NAME=?, ORG_NUM=?, COMP_NUM=?, PHONE=?, MAIL=?, ADDR=?, ADDR_DETAIL=?, REG_DATE=?, MOD_DATE=? Where AC_ID=?;";
	public static final String SQL_DELETE_ACCOUNT_BY_PK = "Delete From ACCOUNT Where AC_ID=?;";

	// SUB_ACCOUNT TABLE
	public static final String SQL_INSERT_SUB_ACCOUNT = "Insert Into SUB_ACCOUNT(AC_ID,ID,PW,STAFF_NAME,PHONE,ORG_NUM,COMP_NUM,ADDR,ADDR_DETAIL,MAIL,REG_DATE,MOD_DATE) Values (?,password(?),?,?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_SUB_ACCOUNT_BY_PK = "Select SA_ID,AC_ID,ID,PW,STAFF_NAME,PHONE,ORG_NUM,COMP_NUM,ADDR,ADDR_DETAIL,MAIL,REG_DATE,MOD_DATE From SUB_ACCOUNT Where SA_ID=?;";
	public static final String SQL_SELECT_SUB_ACCOUNT = "Select SA_ID,AC_ID,ID,PW,STAFF_NAME,PHONE,ORG_NUM,COMP_NUM,ADDR,ADDR_DETAIL,MAIL,REG_DATE,MOD_DATE From SUB_ACCOUNT;";
	public static final String SQL_UPDATE_SUB_ACCOUNT_BY_PK = "Update SUB_ACCOUNT Set AC_ID=?, ID=?, PW=?, STAFF_NAME=?, PHONE=?, ORG_NUM=?, COMP_NUM=?, ADDR=?, ADDR_DETAIL=?, MAIL=?, REG_DATE=?, MOD_DATE=? Where SA_ID=?;";
	public static final String SQL_DELETE_SUB_ACCOUNT_BY_PK = "Delete From SUB_ACCOUNT Where SA_ID=?;";

	// PATNT TABLE
	public static final String SQL_INSERT_PATNT = "Insert Into PATNT(PATNT_NAME,H_INSUR_NUM,CID,GEND,MAIL,ADDR,ADDR_DETAIL,PHONE,MDOC,REG_DATE,MOD_DATE) Values (?,?,?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_PATNT_BY_PK = "Select PA_ID,PATNT_NAME,H_INSUR_NUM,CID,GEND,MAIL,ADDR,ADDR_DETAIL,PHONE,MDOC,REG_DATE,MOD_DATE From PATNT Where PA_ID=?;";
	public static final String SQL_SELECT_PATNT = "Select PA_ID,PATNT_NAME,H_INSUR_NUM,CID,GEND,MAIL,ADDR,ADDR_DETAIL,PHONE,MDOC,REG_DATE,MOD_DATE From PATNT;";
	public static final String SQL_UPDATE_PATNT_BY_PK = "Update PATNT Set PATNT_NAME=?, H_INSUR_NUM=?, CID=?, GEND=?, MAIL=?, ADDR=?, ADDR_DETAIL=?, PHONE=?, MDOC=?, REG_DATE=?, MOD_DATE=? Where PA_ID=?;";
	public static final String SQL_DELETE_PATNT_BY_PK = "Delete From PATNT Where PA_ID=?;";

	// RECEP TABLE
	public static final String SQL_INSERT_RECEP = "Insert Into RECEP(PA_ID,PATNT_NAME,RECEP_DATE,STATE,MEMO,MDOC,STAFF_NAME) Values (?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_RECEP_BY_PK = "Select R_ID,PA_ID,PATNT_NAME,RECEP_DATE,STATE,MEMO,MDOC,STAFF_NAME From RECEP Where R_ID=?;";
	public static final String SQL_SELECT_RECEP = "Select R_ID,PA_ID,PATNT_NAME,RECEP_DATE,STATE,MEMO,MDOC,STAFF_NAME From RECEP;";
	public static final String SQL_UPDATE_RECEP_BY_PK = "Update RECEP Set PA_ID=?, PATNT_NAME=?, RECEP_DATE=?, STATE=?, MEMO=?, MDOC=?, STAFF_NAME=? Where R_ID=?;";
	public static final String SQL_DELETE_RECEP_BY_PK = "Delete From RECEP Where R_ID=?;";

	// TREAT TABLE
	public static final String SQL_INSERT_TREAT = "Insert Into TREAT(R_ID,SYMP_NAME,MEMO) Values (?,?,?);";
	public static final String SQL_SELECT_TREAT_BY_PK = "Select TR_ID,R_ID,SYMP_NAME,MEMO From TREAT Where TR_ID=?;";
	public static final String SQL_SELECT_TREAT = "Select TR_ID,R_ID,SYMP_NAME,MEMO From TREAT;";
	public static final String SQL_UPDATE_TREAT_BY_PK = "Update TREAT Set R_ID=?, SYMP_NAME=?, MEMO=? Where TR_ID=?;";
	public static final String SQL_DELETE_TREAT_BY_PK = "Delete From TREAT Where TR_ID=?;";

	// DRUG TABLE
	public static final String SQL_INSERT_DRUG = "Insert Into DRUG(PR_ID,TR_ID,R_ID,DRUG_CODE,DRUG_BRAND,DRUG_WEIGHT,DRUG_MEMO) Values (?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_DRUG_BY_PK = "Select DR_ID,PR_ID,TR_ID,R_ID,DRUG_CODE,DRUG_BRAND,DRUG_WEIGHT,DRUG_MEMO From DRUG Where DR_ID=?;";
	public static final String SQL_SELECT_DRUG_BY_FK_PR = "Select DR_ID,PR_ID,TR_ID,R_ID,DRUG_CODE,DRUG_BRAND,DRUG_WEIGHT,DRUG_MEMO From DRUG Where PR_ID=?;";
	public static final String SQL_SELECT_DRUG = "Select DR_ID,PR_ID,TR_ID,R_ID,DRUG_CODE,DRUG_BRAND,DRUG_WEIGHT,DRUG_MEMO From DRUG;";
	public static final String SQL_UPDATE_DRUG_BY_PK = "Update DRUG Set PR_ID=?, TR_ID=?, R_ID=?, DRUG_CODE=?, DRUG_BRAND=?, DRUG_WEIGHT=?, DRUG_MEMO=? Where DR_ID=?;";
	public static final String SQL_DELETE_DRUG_BY_PK = "Delete From DRUG Where DR_ID=?;";

	// PRESC TABLE
	public static final String SQL_INSERT_PRESC = "Insert Into PRESC(TR_ID,R_ID,CHUP,PACK,STD_VOL,WATER_VOL,INSUR,REG_DATE,MOD_DATE,FREQ) Values (?,?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_PRESC_BY_PK = "Select PR_ID,TR_ID,R_ID,CHUP,PACK,STD_VOL,WATER_VOL,INSUR,REG_DATE,MOD_DATE,FREQ From PRESC Where PR_ID=?;";
	public static final String SQL_SELECT_PRESC = "Select PR_ID,TR_ID,R_ID,CHUP,PACK,STD_VOL,WATER_VOL,INSUR,REG_DATE,MOD_DATE,FREQ From PRESC;";
	public static final String SQL_UPDATE_PRESC_BY_PK = "Update PRESC Set TR_ID=?, R_ID=?, CHUP=?, PACK=?, STD_VOL=?, WATER_VOL=?, INSUR=?, REG_DATE=?, MOD_DATE=?, FREQ=? Where PR_ID=?;";
	public static final String SQL_DELETE_PRESC_BY_PK = "Delete From PRESC Where PR_ID=?;";

	// FREQ_PRESC TABLE
	public static final String SQL_INSERT_FREQ_PRESC = "Insert Into FREQ_PRESC(PRESC_NAME,DRUG_NAME) Values (?,?);";
	public static final String SQL_SELECT_FREQ_PRESC_BY_PK = "Select FP_ID,PRESC_NAME,DRUG_NAME From FREQ_PRESC Where FP_ID=?;";
	public static final String SQL_SELECT_FREQ_PRESC = "Select FP_ID,PRESC_NAME,DRUG_NAME From FREQ_PRESC;";
	public static final String SQL_UPDATE_FREQ_PRESC_BY_PK = "Update FREQ_PRESC Set PRESC_NAME=?, DRUG_NAME=? Where FP_ID=?;";
	public static final String SQL_DELETE_FREQ_PRESC_BY_PK = "Delete From FREQ_PRESC Where FP_ID=?;";

	// INSUR TABLE
	public static final String SQL_INSERT_INSUR = "Insert Into INSUR(PR_ID,TR_ID,R_ID,TREAT_DATE,PATNT_NAME,CID,DOC,INSUR,INSUR_CHARGE,HANDI_CHARGE,SUP,PATNT_CHARGE,TOTAL_CHARGE) Values (?,?,?,?,?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_INSUR_BY_PK = "Select IN_ID,PR_ID,TR_ID,R_ID,TREAT_DATE,PATNT_NAME,CID,DOC,INSUR,INSUR_CHARGE,HANDI_CHARGE,SUP,PATNT_CHARGE,TOTAL_CHARGE From INSUR Where IN_ID=?;";
	public static final String SQL_SELECT_INSUR = "Select IN_ID,PR_ID,TR_ID,R_ID,TREAT_DATE,PATNT_NAME,CID,DOC,INSUR,INSUR_CHARGE,HANDI_CHARGE,SUP,PATNT_CHARGE,TOTAL_CHARGE From INSUR;";
	public static final String SQL_UPDATE_INSUR_BY_PK = "Update INSUR Set PR_ID=?, TR_ID=?, R_ID=?, TREAT_DATE=?, PATNT_NAME=?, CID=?, DOC=?, INSUR=?, INSUR_CHARGE=?, HANDI_CHARGE=?, SUP=?, PATNT_CHARGE=?, TOTAL_CHARGE=? Where IN_ID=?;";
	public static final String SQL_DELETE_INSUR_BY_PK = "Delete From INSUR Where IN_ID=?;";

	// INSUR_DETAIL TABLE
	public static final String SQL_INSERT_INSUR_DETAIL = "Insert Into INSUR_DETAIL(PR_ID,TR_ID,R_ID,TREAT_NAME,TREAT_CODE,PART,ONCE_DOSE,TOTAL_DOSE,TOTAL_CHARGE) Values (?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_INSUR_DETAIL_BY_PK = "Select _ID,PR_ID,TR_ID,R_ID,TREAT_NAME,TREAT_CODE,PART,ONCE_DOSE,TOTAL_DOSE,TOTAL_CHARGE From INSUR_DETAIL Where _ID=?;";
	public static final String SQL_SELECT_INSUR_DETAIL = "Select _ID,PR_ID,TR_ID,R_ID,TREAT_NAME,TREAT_CODE,PART,ONCE_DOSE,TOTAL_DOSE,TOTAL_CHARGE From INSUR_DETAIL;";
	public static final String SQL_UPDATE_INSUR_DETAIL_BY_PK = "Update INSUR_DETAIL Set PR_ID=?, TR_ID=?, R_ID=?, TREAT_NAME=?, TREAT_CODE=?, PART=?, ONCE_DOSE=?, TOTAL_DOSE=?, TOTAL_CHARGE=? Where _ID=?;";
	public static final String SQL_DELETE_INSUR_DETAIL_BY_PK = "Delete From INSUR_DETAIL Where _ID=?;";

	//PHYSIC TABLE
	public static final String SQL_INSERT_PHYSIC = "Insert Into PHYSIC(PR_ID,TR_ID,R_ID,PH_TYPE,PART_CODE,INSUR) Values (?,?,?,?,?,?);";
	public static final String SQL_SELECT_PHYSIC_BY_PK = "Select PH_ID,PR_ID,TR_ID,R_ID,PH_TYPE,PART_CODE,INSUR From PHYSIC Where PH_ID=?;";
	public static final String SQL_SELECT_PHYSIC = "Select PH_ID,PR_ID,TR_ID,R_ID,PH_TYPE,PART_CODE,INSUR From PHYSIC;";
	public static final String SQL_UPDATE_PHYSIC_BY_PK = "Update PHYSIC Set PR_ID=?, TR_ID=?, R_ID=?, PH_TYPE=?, PART_CODE=?, INSUR=? Where PH_ID=?;";
	public static final String SQL_DELETE_PHYSIC_BY_PK = "Delete From PHYSIC Where PH_ID=?;";
	
	//INSUR_DRUG TABLE
	public static final String SQL_DELETE_INSUR_DRUG_BY_PK = "Delete From INSUR_DRUG Where IDR_ID=?;";
	public static final String SQL_UPDATE_INSUR_DRUG_BY_PK = "Update INSUR_DRUG Set IDR_CODE=?, IDR_NAME=?, IDR_COMP_NAME=?, IDR_WEIGHT=?, IDR_PRICE=? Where IDR_ID=?;";
	public static final String SQL_SELECT_INSUR_DRUG = "Select IDR_ID,IDR_CODE,IDR_NAME,IDR_COMP_NAME,IDR_WEIGHT,IDR_PRICE From INSUR_DRUG;";
	public static final String SQL_SELECT_INSUR_DRUG_BY_PK = "Select IDR_ID,IDR_CODE,IDR_NAME,IDR_COMP_NAME,IDR_WEIGHT,IDR_PRICE From INSUR_DRUG Where IDR_ID=?;";
	public static final String SQL_INSERT_INSUR_DRUG = "Insert Into INSUR_DRUG(IDR_CODE,IDR_NAME,IDR_COMP_NAME,IDR_WEIGHT,IDR_PRICE) Values (?,?,?,?,?);";

	//INSUR_PRESC TABLE
	public static final String SQL_DELETE_INSUR_PRESC_BY_PK = "Delete From INSUR_PRESC Where IP_ID=?;";
	public static final String SQL_UPDATE_INSUR_PRESC_BY_PK = "Update INSUR_PRESC Set IP_CODE=?, IP_NAME=?, SUB_NAME=?, IP_COMP_NAME=?, IP_WEIGHT=?, IP_PRICE=? Where IP_ID=?;";
	public static final String SQL_SELECT_INSUR_PRESC = "Select IP_ID,IP_CODE,IP_NAME,SUB_NAME,IP_COMP_NAME,IP_WEIGHT,IP_PRICE From INSUR_PRESC;";
	public static final String SQL_SELECT_INSUR_PRESC_BY_PK = "Select IP_ID,IP_CODE,IP_NAME,SUB_NAME,IP_COMP_NAME,IP_WEIGHT,IP_PRICE From INSUR_PRESC Where IP_ID=?;";
	public static final String SQL_INSERT_INSUR_PRESC = "Insert Into INSUR_PRESC(IP_CODE,IP_NAME,SUB_NAME,IP_COMP_NAME,IP_WEIGHT,IP_PRICE) Values (?,?,?,?,?,?);";
	
	//CHIM TABLE
	public static final String SQL_DELETE_CHIM_BY_PK = "Delete From CHIM Where CH_ID=?;";
	public static final String SQL_UPDATE_CHIM_BY_PK = "Update CHIM Set CODE=?, NAME=?, C_NAME=?, PART=? Where CH_ID=?;";
	public static final String SQL_SELECT_CHIM = "Select CH_ID,CODE,NAME,C_NAME,PART From CHIM;";
	public static final String SQL_SELECT_CHIM_BY_PK = "Select CH_ID,CODE,NAME,C_NAME,PART From CHIM Where CH_ID=?;";
	public static final String SQL_INSERT_CHIM = "Insert Into CHIM(CODE,NAME,C_NAME,PART) Values (?,?,?,?);";
}
