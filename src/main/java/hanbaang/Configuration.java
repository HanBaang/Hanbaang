package hanbaang;

import java.util.HashMap;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import Action.*;

public class Configuration implements ServletContextListener {
	public static HashMap<String, Action> actions = new HashMap<>();
	Action action;

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		setUpPage();
	}

	public void setUpPage() {
		// ACCOUNT TABLE ACTION
		action = new AccountAction("/ACCOUNT/DELETE_ACCOUNT_BY_PK.jsp", 1);
		actions.put("/DELETE_ACCOUNT_BY_PK.hb", action);
		action = new AccountAction("/ACCOUNT/INSERT_ACCOUNT.jsp", 2);
		actions.put("/INSERT_ACCOUNT.hb", action);
		action = new AccountAction("/ACCOUNT/SELECT_ACCOUNT_BY_PK.jsp", 3);
		actions.put("/SELECT_ACCOUNT_BY_PK.hb", action);
		action = new AccountAction("/ACCOUNT/SELECT_ACCOUNT.jsp", 4);
		actions.put("/SELECT_ACCOUNT.hb", action);
		action = new AccountAction("/ACCOUNT/UPDATE_ACCOUNT_BY_PK.jsp", 5);
		actions.put("/UPDATE_ACCOUNT_BY_PK.hb", action);

		// DRUG TABLE ACTION
		action = new DrugAction("/DRUG/DELETE_DRUG_BY_PK.jsp", 1);
		actions.put("/DELETE_DRUG_BY_PK.hb", action);
		action = new DrugAction("/DRUG/INSERT_DRUG.jsp", 2);
		actions.put("/INSERT_DRUG.hb", action);
		action = new DrugAction("/DRUG/SELECT_DRUG_BY_PK.jsp", 3);
		actions.put("/SELECT_DRUG_BY_PK.hb", action);
		action = new DrugAction("/DRUG/SELECT_DRUG.jsp", 4);
		actions.put("/SELECT_DRUG.hb", action);
		action = new DrugAction("/DRUG/UPDATE_DRUG_BY_PK.jsp", 5);
		actions.put("/UPDATE_DRUG_BY_PK.hb", action);

		// FREQ PRESC ACTION
		action = new FreqPrescAction("/FREQ_PRESC/DELETE_FREQ_PRESC_BY_PK.jsp", 1);
		actions.put("/DELETE_FREQ_PRESC_BY_PK.hb", action);
		action = new FreqPrescAction("/FREQ_PRESC/INSERT_FREQ_PRESC.jsp", 2);
		actions.put("/INSERT_FREQ_PRESC.hb", action);
		action = new FreqPrescAction("/FREQ_PRESC/SELECT_FREQ_PRESC_BY_PK.jsp", 3);
		actions.put("/SELECT_FREQ_PRESC_BY_PK.hb", action);
		action = new FreqPrescAction("/FREQ_PRESC/SELECT_FREQ_PRESC.jsp", 4);
		actions.put("/SELECT_FREQ_PRESC.hb", action);
		action = new FreqPrescAction("/FREQ_PRESC/UPDATE_FREQ_PRESC_BY_PK.jsp", 5);
		actions.put("/UPDATE_FREQ_PRESC_BY_PK.hb", action);

		// SUB ACCOUNT TABLE ACTION
		action = new SubAccAction("/SUB_ACCOUNT/DELETE_SUB_ACCOUNT_BY_PK.jsp", 1);
		actions.put("/DELETE_SUB_ACCOUNT_BY_PK.hb", action);
		action = new SubAccAction("/SUB_ACCOUNT/INSERT_SUB_ACCOUNT.jsp", 2);
		actions.put("/INSERT_SUB_ACCOUNT.hb", action);
		action = new SubAccAction("/SUB_ACCOUNT/SELECT_SUB_ACCOUNT_BY_PK.jsp", 3);
		actions.put("/SELECT_SUB_ACCOUNT_BY_PK.hb", action);
		action = new SubAccAction("/SUB_ACCOUNT/SELECT_SUB_ACCOUNT.jsp", 4);
		actions.put("/SELECT_SUB_ACCOUNT.hb", action);
		action = new SubAccAction("/SUB_ACCOUNT/UPDATE_SUB_ACCOUNT_BY_PK.jsp", 5);
		actions.put("/UPDATE_SUB_ACCOUNT_BY_PK.hb", action);

		// INSUR TABLE ACTION
		action = new InsurAction("/INSUR/DELETE_INSUR_BY_PK.jsp", 1);
		actions.put("/DELETE_INSUR_BY_PK.hb", action);
		action = new InsurAction("/INSUR/INSERT_INSUR.jsp", 2);
		actions.put("/INSERT_INSUR.hb", action);
		action = new InsurAction("/INSUR/SELECT_INSUR_BY_PK.jsp", 3);
		actions.put("/SELECT_INSUR_BY_PK.hb", action);
		action = new InsurAction("/INSUR/SELECT_INSUR.jsp", 4);
		actions.put("/SELECT_INSUR.hb", action);
		action = new InsurAction("/INSUR/UPDATE_INSUR_BY_PK.jsp", 5);
		actions.put("/UPDATE_INSUR_BY_PK.hb", action);

		// INSUR DETAIL TABLE ACTION
		action = new InsurDetailAction("/INSUR_DETAIL/DELETE_INSUR_DETAIL_BY_PK.jsp", 1);
		actions.put("/DELETE_INSUR_DETAIL_BY_PK.hb", action);
		action = new InsurDetailAction("/INSUR_DETAIL/INSERT_INSUR_DETAIL.jsp", 2);
		actions.put("/INSERT_INSUR_DETAIL.hb", action);
		action = new InsurDetailAction("/INSUR_DETAIL/SELECT_INSUR_DETAIL_BY_PK.jsp", 3);
		actions.put("/SELECT_INSUR_DETAIL_BY_PK.hb", action);
		action = new InsurDetailAction("/INSUR/SELECT_INSUR_DETAIL.jsp", 4);
		actions.put("/SELECT_INSUR_DETAIL.hb", action);
		action = new InsurDetailAction("/INSUR/UPDATE_INSUR_DETAIL_BY_PK.jsp", 5);
		actions.put("/UPDATE_INSUR_DETAIL_BY_PK.hb", action);

		
		// PATNT TABLE ACTION
		action = new PatntAction("/PATNT/DELETE_PATNT_BY_PK.jsp", 1);
		actions.put("/DELETE_PATNT_BY_PK.hb", action);
		action = new PatntAction("/PATNT/INSERT_PATNT.jsp", 2);
		actions.put("/INSERT_PATNT.hb", action);
		action = new PatntAction("/PATNT/SELECT_PATNT_BY_PK.jsp", 3);
		actions.put("/SELECT_PATNT_BY_PK.hb", action);
		action = new PatntAction("/PATNT/SELECT_PATNT.jsp", 4);
		actions.put("/SELECT_PATNT.hb", action);
		action = new PatntAction("/PATNT/UPDATE_PATNT_BY_PK.jsp", 5);
		actions.put("/UPDATE_PATNT_BY_PK.hb", action);
	}

}
