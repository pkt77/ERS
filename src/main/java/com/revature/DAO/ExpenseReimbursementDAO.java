package com.revature.DAO;

import java.util.List;

import com.revature.model.ExpenseReimbursement;

public interface ExpenseReimbursementDAO {

	void reimburseLogIn(String uName, String pWord);

	void employeeSubmitReimburse (int rType, double rAmount, String empFK, String descrip);

	List<ExpenseReimbursement> viewAllReimburseReq();

	void resolveReimburse(String finManFM, int appStat, int rID);

	List viewPending();

}