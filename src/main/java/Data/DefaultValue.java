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
	public static final String SQL_SELECT_SUB_ACCOUNT = "";

	// PATNT TABLE

	// RECEP TABLE

	// TREAT TABLE

	// DRUG TABLE

	// PRESC TABLE

	// FREQ_PRESC TABLE

	// INSUR TABLE

	// INSUR_DETAIL TABLE

}
