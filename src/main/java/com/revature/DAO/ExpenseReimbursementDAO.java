package com.revature.DAO;

public interface ExpenseReimbursementDAO {

	void reimburseLogIn(String uName, String pWord);

	void employeeSubmitReimburse (int type, double amount, String empForKey, String description);

	void viewAllReimburseReq();

	boolean resolveReimburse(String finManForeignKey, boolean approvalStatus);

	void viewPending();

}