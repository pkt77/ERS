package com.revature.DAO;

public interface ExpenseReimbursementDAO {
	
	void employeeLogIn(String uName, String pWord);
	
	void customerLogIn(String uName, String pWord);
	
	void employeeSubmitReimburse (int type, double amount, String description);
	
	void viewAllReimburseReq();
	
	boolean resolveReimburse();
	
	void viewPending();

}
