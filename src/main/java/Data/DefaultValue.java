package Data;

public class DefaultValue {
	public static final String SQL_SELECT_TEST_BY_ID = "SELECT id, pw FROM test where id = ?";
	public static final int DB_TIMEOUT = 10000;

	// ACCOUNT TABLE

	public static final String SQL_INSERT_ACCOUNT = "Insert Into ACCOUNT(ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE) Values (?,?,?,?,?,?,?,?,?,?,?);";
	public static final String SQL_SELECT_ACCOUNT = "Select AC_ID,ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE From ACCOUNT;";
	public static final String SQL_SELECT_ACCOUNT_BY_PK = "Select AC_ID,ID,PW,HOSPI_NAME,ORG_NUM,COMP_NUM,PHONE,MAIL,ADDR,ADDR_DETAIL,REG_DATE,MOD_DATE From ACCOUNT Where AC_ID=?;";
	public static final String SQL_UPDATE_ACCOUNT_BY_PK = "Update ACCOUNT Set ID=?, PW=?, HOSPI_NAME=?, ORG_NUM=?, COMP_NUM=?, PHONE=?, MAIL=?, ADDR=?, ADDR_DETAIL=?, REG_DATE=?, MOD_DATE=? Where AC_ID=?;";
	public static final String SQL_DELETE_ACCOUNT_BY_PK = "Delete From ACCOUNT Where AC_ID=?;";

	
	// SUB_ACCOUNT TABLE
	public static final String SQL_INSERT_SUB_ACCOUNT = "Insert Into SUB_ACCOUNT(AC_ID,ID,PW,STAFF_NAME,PHONE,ORG_NUM,COMP_NUM,ADDR,ADDR_DETAIL,MAIL,REG_DATE,MOD_DATE) Values (?,?,?,?,?,?,?,?,?,?,?,?);";
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

	// PRESC TABLE

	// FREQ_PRESC TABLE

	// INSUR TABLE

	// INSUR_DETAIL TABLE

}
